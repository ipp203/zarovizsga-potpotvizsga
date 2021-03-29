package hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish {
    private final String name;
    protected int weight;
    private final String color;
    protected boolean memoryLoss;

    protected Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return memoryLoss;
    }

    public String status() {
        return String.format("%s, weight: %d, color: %s, short term memory loss: %b", name, weight, color, memoryLoss);
    }

    public abstract void feed();
}
