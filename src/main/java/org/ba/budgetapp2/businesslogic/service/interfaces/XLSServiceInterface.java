package org.ba.budgetapp2.businesslogic.service.interfaces;

import org.ba.budgetapp2.businesslogic.entities.MovimentiModel;
import org.ba.budgetapp2.businesslogic.service.xls.XLSReader;

import java.io.IOException;
import java.util.*;

public interface XLSServiceInterface {


    //recupera la lista dei movimenti da un singolo foglio
    List<MovimentiModel> getMovimentiList(XLSReader reader) throws IOException;

    //crea la mappa dei movimenti per ogni anno e mese
    Map<String,List<MovimentiModel>> iterateOverFolder() throws IOException;

    //scrive sul foglio di calcolo
    boolean writeToXlsModel(Integer year, Integer month, String fileName) throws IOException;

}
