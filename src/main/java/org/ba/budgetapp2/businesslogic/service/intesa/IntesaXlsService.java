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
import org.ba.budgetapp2.costants.Category;
import org.ba.budgetapp2.costants.IntesaSanPaoloIndex;
import org.ba.budgetapp2.costants.MappaIntesaFoglio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
@Slf4j
public class IntesaXlsService implements XLSServiceInterface {


    @Autowired
    private MovimentiService movimentiService;

    private final String FILE_PATH = "C:\\Users\\Giuseppe\\OneDrive\\Documents\\libro_mastro\\movimenti";
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
        File folder = new File(FILE_PATH);
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
            File innerFolder = new File(FILE_PATH + "/" + folderName);
            File[] listOfInnerFolders = innerFolder.listFiles();
            List<MovimentiModel> movimentiYear = new ArrayList<>();
            for(File file : listOfInnerFolders) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                    movimentiYear.addAll(getMovimentiList(new XLSReader(folderName,file.getName(),null)));
                    allMovimentiModels.put(folderName,movimentiYear);
                }
            }
        }
        return allMovimentiModels;
    }

    public Map<String,List<MovimentiModel>> iterateOverFolderByYearAndMonth(Integer year, Integer month, String fileName) throws IOException {
        Map<String,List<MovimentiModel>> allMovimentiModels = new HashMap<>();
        String path;
        try {
            if (year != null && !fileName.equals("")) {
                File file = new File(FILE_PATH + "\\" + year + "\\" + fileName);
                allMovimentiModels.put(year.toString(), getMovimentiList(new XLSReader(year.toString(), null, file.getAbsolutePath())));
                return allMovimentiModels;
            }
            if (year != null && month != null) {
                File file = new File(FILE_PATH + "\\" + year + "\\" + month + ".xlsx");
                allMovimentiModels.put(year.toString(), getMovimentiList(new XLSReader(year.toString(), month.toString(), file.getAbsolutePath())));
                return allMovimentiModels;
            }
            if (year != null) {
                path = FILE_PATH + "\\" + year;
                File folder = new File(path);
                File[] listOfFiles = folder.listFiles();
                List<MovimentiModel> movimentiYear = new ArrayList<>();
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        movimentiYear.addAll(getMovimentiList(new XLSReader(year.toString(), file.getName(), null)));
                        allMovimentiModels.put(year.toString(), movimentiYear);
                    }
                }
                return allMovimentiModels;
            }
            if (year == null && month == null) {
                return iterateOverFolder();
            }
        } catch (FileNotFoundException e) {
            return allMovimentiModels;
        }
        return allMovimentiModels;
    }


    /*public boolean writeToXlsModel(Integer year, Integer month) throws IOException {
        try {
            XLSWriter writer = new XLSWriter(month + ".xlsx",0);
            Sheet sheet = writer.getSheet();
            List<MovimentiModel> movimentiModels = movimentiService.getMovimentiListByYearAndMonth(year, month);
            Map<String, Integer> map = MappaIntesaFoglio.getMapIntesa();
            log.info("movimenti size {}",movimentiModels.size());
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
    }*/

    public boolean writeToXlsModel(Integer year, Integer month, String fileName) throws IOException {
        try {
            XLSWriter writer = new XLSWriter(fileName, 2);
            Sheet sheet = writer.getSheet();
            List<MovimentiModel> movimentiModels = movimentiService.getMovimentiListByYearAndMonth(year, month);
            int firstRow = this.findFirstEmptyRow(sheet);
            Map<String,Integer> categoryMap = Category.getMap();
            Map<String,Integer> intesaMap = MappaIntesaFoglio.getMapIntesa();
            log.info("movimenti: {}",movimentiModels.size());
            log.info("firstRow: {}",firstRow);
            for(MovimentiModel movimentiModel : movimentiModels) {
                Integer categoryValue = intesaMap.get(movimentiModel.getCategory());
                String category = "";
                for(Map.Entry<String,Integer> entry : categoryMap.entrySet()) {
                    if(entry.getValue().equals(categoryValue)) {
                        category = entry.getKey();
                    }
                }
                Row row = sheet.getRow(firstRow);
                row.createCell(3).setCellValue(movimentiModel.getDescription());
                row.createCell(4).setCellValue(category);
                row.createCell(5).setCellValue(Math.abs(movimentiModel.getValue()));
                row.createCell(6).setCellValue(movimentiModel.getDate());
                row.createCell(7).setCellValue(movimentiModel.getValue() > 0 ? "ENTRATA" : "USCITA");
                firstRow++;
            }
            writer.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private int findFirstEmptyRow(Sheet sheet) {
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row == null || row.getCell(3) == null || row.getCell(3).getCellType() == CellType.BLANK) {
                return i;
            }
        }
        return rowCount;
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
