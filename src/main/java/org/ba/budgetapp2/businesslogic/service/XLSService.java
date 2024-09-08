package org.ba.budgetapp2.businesslogic.service;

import lombok.extern.slf4j.Slf4j;
import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.ba.budgetapp2.costants.IntesaSanPaoloIndex;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@Slf4j
public class XLSService {

    Map<Integer, List<String>> data = new HashMap<>();


    public Integer getMovimentiFirstIndex(Map<Integer,List<String>> data) throws IOException {
        for (Map.Entry<Integer, List<String>> entry : data.entrySet()) {
            if (entry.getValue() != null && entry.getValue().size() > 1) {
                if (entry.getValue().get(0).equalsIgnoreCase("data")) {
                    return entry.getKey() + 1;
                }
            }
        }
        return -1;
    }

    public List<MovimentiModel> getMovimentiList(XLSReader reader) throws IOException {
        List<MovimentiModel> movimentiModelList = new ArrayList<>();
        data = reader.getData();
        Integer firstIndex = getMovimentiFirstIndex(data);
        log.info("SIZE: {}", data.size());
        for(int i = firstIndex; i < data.size()-1; i++) {
            List<String> row = data.get(i);
            if(row != null && row.size() == 8) {
                if(row.get(IntesaSanPaoloIndex.DATA.getValore()) == null || row.get(IntesaSanPaoloIndex.DATA.getValore()).equalsIgnoreCase(" ")) {
                    continue;
                }
                log.info("Date: {}",row.get(IntesaSanPaoloIndex.DATA.getValore()));
                log.info("Description: {}",row.get(IntesaSanPaoloIndex.DETTAGLI.getValore()));
                log.info("Category: {}",row.get(IntesaSanPaoloIndex.CATEGORIA.getValore()));
                log.info("Value: {}",row.get(IntesaSanPaoloIndex.VALORE.getValore()));
                MovimentiModel movimento = MovimentiModel.builder()
                        .date(new Date(String.valueOf(row.get(IntesaSanPaoloIndex.DATA.getValore()))))
                        .description(row.get(IntesaSanPaoloIndex.DETTAGLI.getValore()))
                        .category(row.get(IntesaSanPaoloIndex.CATEGORIA.getValore()))
                        .value(Double.parseDouble(row.get(IntesaSanPaoloIndex.VALORE.getValore())))
                        .build();
                movimentiModelList.add(movimento);
            }
        }
        return movimentiModelList;
    }

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


}
