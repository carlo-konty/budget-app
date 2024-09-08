package org.ba.budgetapp2.costants;

public enum IntesaSanPaoloIndex {

        DATA(0),
        DETTAGLI(2),
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