package org.ba.budgetapp2.businesslogic.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TestService {


    public String test() {
        return "Hello World!";
    }

    public String readData() throws IOException {
        XLSReader xlsReader = new XLSReader();
        Map<Integer, List<String>> data = xlsReader.getData();
        log.info(data.toString());
        return "OK";
    }


}
