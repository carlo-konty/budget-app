package org.ba.budgetapp2.businesslogic.service;

import lombok.extern.slf4j.Slf4j;
import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TestService {

    @Autowired
    private XLSService xlsService;

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
        return xlsService.getMovimentiList(new XLSReader("2024","8"));
    }

    public Map<String,List<MovimentiModel>> testDirectory() throws IOException {
        return xlsService.iterateOverFolder();
    }


}
