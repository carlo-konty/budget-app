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

    private String month;
    private String year;
    private Sheet sheet;

    public XLSWriter(String month, String year) throws IOException {
        this.year = year; this.month = month;
        FileInputStream file = new FileInputStream("C:\\Users\\Giuseppe\\OneDrive\\Desktop\\LIBRO MASTRO\\PLANNER\\Budget-PlannerTEST.xls");
        Workbook workbook = new XSSFWorkbook(file);
        this.sheet = workbook.getSheetAt(0);
    }

}
