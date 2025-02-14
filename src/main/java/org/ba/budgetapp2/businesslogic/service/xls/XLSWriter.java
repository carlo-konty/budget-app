package org.ba.budgetapp2.businesslogic.service.xls;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Data
@Slf4j
public class XLSWriter {


    private final String path = "C:\\Users\\Giuseppe\\OneDrive\\Documents\\libro_mastro\\planner";
    private String fileName;
    private Sheet sheet;
    private Workbook workbook;

    public XLSWriter(String fileName, Integer sheet) throws IOException {
        this.fileName = fileName;
        FileInputStream file = new FileInputStream(path + "\\" + this.fileName);
        this.workbook = new XSSFWorkbook(file);
        this.workbook.setForceFormulaRecalculation(true);
        this.sheet = workbook.getSheetAt(sheet);
    }

    public void write() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path + "\\" + this.fileName);
        workbook.write(outputStream);
        outputStream.close();
    }

}
