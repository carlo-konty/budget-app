package org.ba.budgetapp2.costants;

import java.util.HashMap;
import java.util.Map;

public enum Category {

    //ENTRATE
    STIPENDI(14),
    INTERESSI(15),
    RISARCIMENTI(16),
    EXTRA(17),
    //RISPARMI
    EMERGENZA(23),
    CONTO_RISPARMIO(24),
    PENSIONE(25),
    INVESTIMENTI(26),
    //SPESE
    //RICORRENTI
    UNIVERSITA(33),
    AFFITTO(34),
    BOLLETTE(35),
    TELEFONO(36),
    REGALI(37),
    INTERNET(38),
    PRELIEVI(39),
    //TRASPORTI
    RATE(42),
    ASSICURAZIONE(43),
    BENZINA(44),
    MEZZI_PUBBLICI(45),
    MANUTENZIONE(46),
    BOLLO(47),
    //NECESSITA
    ALIMENTI(50),
    CENE_BAR(51),
    ABBIGLIAMENTO(52),
    PULIZIE(53),
    PARRUCCHIERE(54),
    ISTRUZIONE(55),
    //INTRATTENIMENTO
    E_COMMERCE(58),
    LIBRI(59),
    VIDEOGIOCHI(60),
    APERTO(61),
    PAYPAL(62),
    //SALUTE
    ASSICURAZIONE_MEDICA(65),
    PALESTRA(66),
    DOTTORE(67),
    MEDICINE(68),
    INTEGRATORI(69),
    //VACANZE
    BIGLIETTI(72),
    PERNOTTAMENTI(73),
    CIBO(74),
    SOUVENIR(75),
    TRASPORTI(76),
    CONTANTE(77);

    private final int value;

    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Map<String,Integer> getMap() {
        Map<String, Integer> categorie = new HashMap<>();

        // ENTRATE
        categorie.put("STIPENDI", 14);
        categorie.put("INTERESSI", 15);
        categorie.put("RISARCIMENTI", 16);
        categorie.put("EXTRA", 17);

        // RISPARMI
        categorie.put("EMERGENZA", 23);
        categorie.put("CONTO_RISPARMIO", 24);
        categorie.put("PENSIONE", 25);
        categorie.put("INVESTIMENTI", 26);

        // SPESE
        // RICORRENTI
        categorie.put("UNIVERSITA", 33);
        categorie.put("AFFITTO", 34);
        categorie.put("BOLLETTE", 35);
        categorie.put("TELEFONO", 36);
        categorie.put("REGALI", 37);
        categorie.put("INTERNET", 38);
        categorie.put("PRELIEVI", 39);

        // TRASPORTI
        categorie.put("RATE", 42);
        categorie.put("ASSICURAZIONE", 43);
        categorie.put("BENZINA", 44);
        categorie.put("MEZZI_PUBBLICI", 45);
        categorie.put("MANUTENZIONE", 46);
        categorie.put("BOLLO", 47);

        // NECESSITA
        categorie.put("ALIMENTI", 50);
        categorie.put("CENE_BAR", 51);
        categorie.put("ABBIGLIAMENTO", 52);
        categorie.put("PULIZIE", 53);
        categorie.put("PARRUCCHIERE", 54);
        categorie.put("ISTRUZIONE", 55);

        // INTRATTENIMENTO
        categorie.put("E_COMMERCE", 58);
        categorie.put("LIBRI", 59);
        categorie.put("VIDEOGIOCHI", 60);
        categorie.put("APERTO", 61);
        categorie.put("PAYPAL", 62);

        // SALUTE
        categorie.put("ASSICURAZIONE_MEDICA", 65);
        categorie.put("PALESTRA", 66);
        categorie.put("DOTTORE", 67);
        categorie.put("MEDICINE", 68);
        categorie.put("INTEGRATORI", 69);

        // VACANZE
        categorie.put("BIGLIETTI", 72);
        categorie.put("PERNOTTAMENTI", 73);
        categorie.put("CIBO", 74);
        categorie.put("SOUVENIR", 75);
        categorie.put("TRASPORTI", 76);
        categorie.put("CONTANTE", 77);

        return categorie;
    }
}
