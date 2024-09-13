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
        categorie.put("STIPENDI", 13);
        categorie.put("INTERESSI", 14);
        categorie.put("RISARCIMENTI", 15);
        categorie.put("EXTRA", 16);

// RISPARMI
        categorie.put("EMERGENZA", 22);
        categorie.put("CONTO_RISPARMIO", 23);
        categorie.put("PENSIONE", 24);
        categorie.put("INVESTIMENTI", 25);

// SPESE

// RICORRENTI
        categorie.put("UNIVERSITA", 32);
        categorie.put("CASA", 33);
        categorie.put("BOLLETTE", 34);
        categorie.put("TELEFONO", 35);
        categorie.put("REGALI", 36);
        categorie.put("ABBONAMENTI", 37);
        categorie.put("PRELIEVI", 38);

// TRASPORTI
        categorie.put("RATE", 41);
        categorie.put("ASSICURAZIONE", 42);
        categorie.put("BENZINA", 43);
        categorie.put("MEZZI_PUBBLICI", 44);
        categorie.put("MANUTENZIONE", 45);
        categorie.put("BOLLO", 46);

// NECESSITA
        categorie.put("ALIMENTI", 49);
        categorie.put("CENE_BAR", 50);
        categorie.put("ABBIGLIAMENTO", 51);
        categorie.put("PULIZIE", 52);
        categorie.put("PARRUCCHIERE", 53);
        categorie.put("ISTRUZIONE", 54);

// INTRATTENIMENTO
        categorie.put("E_COMMERCE", 57);
        categorie.put("LIBRI", 58);
        categorie.put("VIDEOGIOCHI", 59);
        categorie.put("APERTO", 60);
        categorie.put("PAYPAL", 61);

// SALUTE
        categorie.put("ASSICURAZIONE_MEDICA", 64);
        categorie.put("PALESTRA", 65);
        categorie.put("DOTTORE", 66);
        categorie.put("MEDICINE", 67);
        categorie.put("INTEGRATORI", 68);

// VACANZE
        categorie.put("BIGLIETTI", 71);
        categorie.put("PERNOTTAMENTI", 72);
        categorie.put("CIBO", 73);
        categorie.put("SOUVENIR", 74);
        categorie.put("TRASPORTI", 75);
        categorie.put("CONTANTE", 76);



        return categorie;
    }
}
