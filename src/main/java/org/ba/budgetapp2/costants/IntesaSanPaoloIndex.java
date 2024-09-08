package org.ba.budgetapp2.costants;

public enum IntesaSanPaoloIndex {

        DATA(0),
        DETTAGLI(2),
        CONTO_O_CARTA(3),
        CATEGORIA(5),
        VALORE(7);

        private final int valore;

        IntesaSanPaoloIndex(int valore) {
            this.valore = valore;
        }

        public int getValore() {
            return valore;
        }
}