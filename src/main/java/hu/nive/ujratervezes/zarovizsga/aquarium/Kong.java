package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Kong extends Fish {
    private static final int WEIGHT_INC = 2;

    public Kong(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        weight += WEIGHT_INC;
    }
}
