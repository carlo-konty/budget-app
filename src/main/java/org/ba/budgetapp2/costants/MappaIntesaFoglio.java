package org.ba.budgetapp2.costants;

import java.util.HashMap;
import java.util.Map;

public enum MappaIntesaFoglio {

    VIAGGI_E_VACANZE("Viaggi e vacanze",73),
    TRENO_AEREO_NAVE("Treno, aereo, nave",76),
    TRASPORTI_NOLEGGI_TAXI_E_PARCHEGGI("Trasporti, noleggi, taxi e parcheggi",45),
    TRASPORTI_VARIE("Trasporti varie",45),
    TEMPO_LIBERO_VARIE("Tempo libero varie",61),
    TABACCAI_E_SIMILI("Tabaccai e simili",39),
    STIPENDI_E_PENSIONI("Stipendi e pensioni",14),
    SPETTACOLI_E_MUSEI("Spettacoli e musei",59),
    SPESE_MEDICHE("Spese mediche",67),
    RISTORANTI_E_BAR("Ristoranti e bar",51),
    RIMBORSI_SPESE_E_STORNI("Rimborsi spese e storni",16),
    RATE_PIANI_PENSIONISTICI("Rate piani pensionistici",25),
    PRELIEVI("Prelievi",39),
    MANUTENZIONE_CASA("Manutenzione casa",46),
    LIBRI_FILM_E_MUSICA("Libri, film e musica",59),
    INVESTIMENTI_BDR_E_XME_SALVADANAIO("Investimenti, BDR e XME Salvadanaio",24),
    IMPOSTE_SUL_REDDITO_E_TASSE_VARIE("Imposte sul reddito e tasse varie",35),
    GENERI_ALIMENTARI_E_SUPERMERCATO("Generi alimentari e supermercato",50),
    FARMACIA("Farmacia",68),
    FAMIGLIE_VARIE("Famiglie varie",37),
    ENTRATE_VARIE("Entrate varie",17),
    DOMICILIAZIONI_E_UTENZE("Domiciliazioni e Utenze",35),
    DISINVESTIMENTI_BDR_E_XME_SALVADANAIO("Disinvestimenti, BDR e XME Salvadanaio",39),
    CURA_DELLA_PERSONA("Cura della persona",53),
    CORSI_E_SPORT("Corsi e sport",61),
    CELLULARE("Cellulare",36),
    CASA_VARIE("Casa varie",37),
    CARBURANTI("Carburanti",44),
    BONIFICI_IN_USCITA("Bonifici in uscita",23),
    ALTRE_USCITE("Altre uscite",39),
    ADDEBITI_VARI("Addebiti vari",39),
    ABBIGLIAMENTO_E_ACCESSORI("Abbigliamento e accessori",52);

    private final String name;
    private final int value;

    MappaIntesaFoglio(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public static Map<String,Integer> getMapIntesa() {
        Map<String, Integer> categorieMap = new HashMap<>();
        categorieMap.put("Stipendi e pensioni", 13);
        categorieMap.put("Rimborsi spese e storni", 15);
        categorieMap.put("Entrate varie", 16);
        categorieMap.put("Bonifici in uscita", 22);
        categorieMap.put("Investimenti, BDR e XME Salvadanaio", 23);
        categorieMap.put("Disinvestimenti, BDR e XME Salvadanaio", 23);
        categorieMap.put("Rate piani pensionistici", 24);
        categorieMap.put("Imposte sul reddito e tasse varie", 34);
        categorieMap.put("Domiciliazioni e Utenze", 34);
        categorieMap.put("Cellulare", 35);
        categorieMap.put("Casa varie", 36);
        categorieMap.put("Famiglie varie", 36);
        categorieMap.put("Addebiti vari", 38);
        categorieMap.put("Altre uscite", 38);
        categorieMap.put("Prelievi", 38);
        categorieMap.put("Tabaccai e simili", 38);
        categorieMap.put("Carburanti", 43);
        categorieMap.put("Trasporti varie", 44);
        categorieMap.put("Trasporti, noleggi, taxi e parcheggi", 44);
        categorieMap.put("Manutenzione casa", 45);
        categorieMap.put("Generi alimentari e supermercato", 49);
        categorieMap.put("Ristoranti e bar", 50);
        categorieMap.put("Spettacoli e musei", 58);
        categorieMap.put("Libri, film e musica", 58);
        categorieMap.put("Corsi e sport", 60);
        categorieMap.put("Tempo libero varie", 60);
        categorieMap.put("Abbigliamento e accessori", 51);
        categorieMap.put("Cura della persona", 52);
        categorieMap.put("Spese mediche", 66);
        categorieMap.put("Farmacia", 67);
        categorieMap.put("Viaggi e vacanze", 72);
        categorieMap.put("Treno, aereo, nave", 75);


        return categorieMap;
    }
}
