package org.ba.budgetapp2.costants;

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
}
