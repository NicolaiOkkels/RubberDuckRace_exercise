package app;

public class Duck {
    private int number = 1;
    private static int count= 1;

    public Duck() {
        this.number = count;
        count++;
    }

    @Override
    public String toString() {
        return "Duck: " + number;
    }
}
