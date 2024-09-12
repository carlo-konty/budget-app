package org.ba.budgetapp2.businesslogic.service.xls;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

@Data
@Slf4j
public class XLSWriter {

    private int month;
    private int year;
    private Sheet sheet;
    private Workbook workbook;

    public XLSWriter(int year,int month) throws IOException {
        this.year = year; this.month = month;
        FileInputStream file = new FileInputStream("C:\\Users\\Giuseppe\\OneDrive\\Desktop\\LIBRO MASTRO\\PLANNER\\Budget-PlannerTEST.xlsx");
        this.workbook = new XSSFWorkbook(file);
        this.sheet = workbook.getSheetAt(0);
    }

}
