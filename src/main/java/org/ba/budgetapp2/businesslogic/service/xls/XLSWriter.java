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


    private final String path = "C:\\Users\\Giuseppe\\OneDrive\\Desktop\\LIBRO MASTRO\\PLANNER\\Budget-PlannerTEST.xlsx";
    private Integer month;
    private Integer year;
    private Sheet sheet;
    private Workbook workbook;

    public XLSWriter(Integer year, Integer month) throws IOException {
        this.year = year; this.month = month;
        FileInputStream file = new FileInputStream(path);
        this.workbook = new XSSFWorkbook(file);
        this.workbook.setForceFormulaRecalculation(true);
        this.sheet = workbook.getSheetAt(0);
    }

    public void write() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        outputStream.close();
    }

}
