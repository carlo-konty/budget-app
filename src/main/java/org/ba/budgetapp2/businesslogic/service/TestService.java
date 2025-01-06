package org.ba.budgetapp2.businesslogic.service;

import lombok.extern.slf4j.Slf4j;
import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.ba.budgetapp2.businesslogic.service.intesa.IntesaXlsService;
import org.ba.budgetapp2.businesslogic.service.xls.XLSReader;
import org.ba.budgetapp2.businesslogic.service.xls.XLSWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TestService {

    @Autowired
    private IntesaXlsService intesaXlsService;

    public String test() {
        return "Hello World!";
    }

    public Integer getIndex() throws IOException {
        return -1;
    }

    public Map<String,List<MovimentiModel>> testDirectory() throws IOException {
        return intesaXlsService.iterateOverFolder();
    }

    public void testWrite() throws IOException {
        for(int i=1;i<=12;i++) {
            intesaXlsService.writeToXlsModel(2024,i);
        }
    }

    public void testRead() throws IOException {

    }


}
