package org.ba.budgetapp2.businesslogic.service;

import lombok.extern.slf4j.Slf4j;
import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.ba.budgetapp2.businesslogic.service.intesa.IntesaXlsService;
import org.ba.budgetapp2.businesslogic.service.xls.XLSReader;
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

    public Map<Integer,List<String>> readData() throws IOException {
        XLSReader xlsReader = new XLSReader("2024","8");
        return xlsReader.getData();
    }

    public Integer getIndex() throws IOException {
        return -1;
    }

    public List<MovimentiModel> getMovimenti() throws IOException {
        return intesaXlsService.getMovimentiList(new XLSReader("2024","8"));
    }

    public Map<String,List<MovimentiModel>> testDirectory() throws IOException {
        return intesaXlsService.iterateOverFolder();
    }


}
