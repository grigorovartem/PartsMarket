package Entity;

public enum Brand {

    MERSEDES,
    DAF,
    VOLVO,
    SCANIA,
    MAN,
    RENAULT,
    IVECO;

    public static boolean isBrand(String brand) {
        for (Brand value : Brand.values()) {
            if (value.name().equals(brand)) {
                return true;
            }
        }
        return false;
    }

}
