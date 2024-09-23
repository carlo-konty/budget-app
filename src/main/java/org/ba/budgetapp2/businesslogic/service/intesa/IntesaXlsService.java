package org.ba.budgetapp2.businesslogic.service.intesa;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.ba.budgetapp2.businesslogic.service.MovimentiService;
import org.ba.budgetapp2.businesslogic.service.interfaces.XLSServiceInterface;
import org.ba.budgetapp2.businesslogic.service.xls.XLSReader;
import org.ba.budgetapp2.businesslogic.service.xls.XLSWriter;
import org.ba.budgetapp2.costants.IntesaSanPaoloIndex;
import org.ba.budgetapp2.costants.MappaIntesaFoglio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Service
@Slf4j
public class IntesaXlsService implements XLSServiceInterface {


    @Autowired
    private MovimentiService movimentiService;

    private Map<Integer, List<String>> data = new HashMap<>();


    public List<MovimentiModel> getMovimentiList(XLSReader reader) throws IOException {
        List<MovimentiModel> movimentiModelList = new ArrayList<>();
        data = reader.getData();
        Integer firstIndex = getMovimentiFirstIndex(data);
        for(int i = firstIndex; i < data.size()-1; i++) {
            List<String> row = data.get(i);
            if(row != null && row.size() == 8) {
                if(row.get(IntesaSanPaoloIndex.DATA.getValore()) == null || row.get(IntesaSanPaoloIndex.DATA.getValore()).equalsIgnoreCase(" ")) {
                    continue;
                }
                MovimentiModel movimento = MovimentiModel.builder()
                        .date(new Date(String.valueOf(row.get(IntesaSanPaoloIndex.DATA.getValore()))))
                        .description(row.get(IntesaSanPaoloIndex.DETTAGLI.getValore()))
                        .contoOrCarta(row.get(IntesaSanPaoloIndex.CONTO_O_CARTA.getValore()))
                        .category(row.get(IntesaSanPaoloIndex.CATEGORIA.getValore()))
                        .value(Double.parseDouble(row.get(IntesaSanPaoloIndex.VALORE.getValore())))
                        .build();
                movimentiModelList.add(movimento);
            }
        }
        return movimentiModelList;
    }

    //TODO DA SPOSTARE ALTROVE IN UNA FACADE
    public Map<String,List<MovimentiModel>> iterateOverFolder() throws IOException {
        Map<String,List<MovimentiModel>> allMovimentiModels = new HashMap<>();
        final String path = "C:\\Users\\Giuseppe\\OneDrive\\Desktop\\LIBRO MASTRO\\MOVIMENTI";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        List<String> folderNames = new ArrayList<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                folderNames.add(file.getName());
                System.out.println("Directory: " + file.getName());
            }
        }
        for (String folderName : folderNames) {
            File innerFolder = new File(path + "/" + folderName);
            File[] listOfInnerFolders = innerFolder.listFiles();
            List<MovimentiModel> movimentiYear = new ArrayList<>();
            for(File file : listOfInnerFolders) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                    movimentiYear.addAll(getMovimentiList(new XLSReader(folderName,file.getName())));
                    allMovimentiModels.put(folderName,movimentiYear);
                }
            }
        }
        return allMovimentiModels;
    }

    public boolean writeToXlsModel(Integer year, Integer month) throws IOException {
        try {
            XLSWriter writer = new XLSWriter();
            Sheet sheet = writer.getSheet();
            List<MovimentiModel> movimentiModels = movimentiService.getMovimentiListByYearAndMonth(year, month);
            Map<String, Integer> map = MappaIntesaFoglio.getMapIntesa();
            log.info(movimentiModels.toString());
            for (MovimentiModel movimentiModel : movimentiModels) {
                log.info("movimentiModel: {}", movimentiModel);
                Integer mapValue = map.get(movimentiModel.getCategory());
                if (mapValue != null) {
                    Row row = sheet.getRow(mapValue);
                    Cell cell = row.getCell(month);
                    if (!cell.getCellType().equals(CellType.BLANK)) {
                        StringBuilder sb = new StringBuilder(cell.getCellFormula());
                        Double value = movimentiModel.getValue();
                        sb.append((value < 0 ? value.toString() : "+" + value));
                        cell.setCellFormula(sb.toString());
                    } else {
                        Double value = movimentiModel.getValue();
                        cell.setCellFormula(value < 0 ? value.toString() : "+" + value);
                    }
                }
            }
            writer.write();
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

    //metodi privati di utility alla classe
    private Integer getMovimentiFirstIndex(Map<Integer,List<String>> data) throws IOException {
        for (Map.Entry<Integer, List<String>> entry : data.entrySet()) {
            if (entry.getValue() != null && entry.getValue().size() > 1) {
                if (entry.getValue().get(0).equalsIgnoreCase("data")) {
                    return entry.getKey() + 1;
                }
            }
        }
        return -1;
    }




}
