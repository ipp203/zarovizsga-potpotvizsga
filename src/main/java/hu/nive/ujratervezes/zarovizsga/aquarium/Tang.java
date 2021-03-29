package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Tang extends Fish {
    private static final int WEIGHT_INC = 1;

    public Tang(String name, int weight, String color) {
        super(name, weight, color);
        memoryLoss = true;
    }

    @Override
    public void feed() {
        weight += WEIGHT_INC;
    }
}
