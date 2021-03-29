package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Clownfish extends Fish {
    private static final int WEIGHT_INC = 1;

    public Clownfish(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        weight += WEIGHT_INC;
    }
}
