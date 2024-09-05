package org.ba.budgetapp2.businesslogic.service;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Log4j2
@Data
public class XLSReader {

    private FileInputStream file = new FileInputStream(new File("C:\\Users\\Giuseppe\\OneDrive\\Desktop\\LIBRO MASTRO\\MOVIMENTI\\2024\\1.xlsx"));
    private Workbook workbook = new XSSFWorkbook(file);
    private Map<Integer,List<String>> data = new HashMap<>();

    public XLSReader() throws IOException {
        Sheet sheet = workbook.getSheetAt(0);
        int i = 0;
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            Integer letter = row.getRowNum();
            log.info("POSIZIONE: {}", letter);
            data.put(i, new ArrayList<>());
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case CellType.NUMERIC: {
                        data.get(i).add(String.valueOf(cell.getNumericCellValue()));
                        break;
                    }
                    case CellType.STRING: {
                        data.get(i).add(cell.getStringCellValue());
                        break;
                    }
                    case CellType.BLANK: {
                        data.get(i).add(" ");
                        break;
                    }
                    case CellType.BOOLEAN: {
                        data.get(i).add(String.valueOf(cell.getBooleanCellValue()));
                        break;
                    }
                    case CellType.FORMULA: {
                        data.get(i).add(String.valueOf(cell.getCellFormula()));
                        break;
                    }
                    case CellType.ERROR: {
                        data.get(i).add(String.valueOf(cell.getErrorCellValue()));
                        break;
                    }
                    default:
                        break;
                }
            }
            i++;
        }
    }
}
