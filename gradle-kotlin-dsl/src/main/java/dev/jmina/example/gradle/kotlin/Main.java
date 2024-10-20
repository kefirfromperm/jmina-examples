package dev.jmina.example.gradle.kotlin;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("You must specify at least two arguments");
        }
        double heightM = Double.parseDouble(args[0]);
        double widthM = Double.parseDouble(args[1]);

        WeightCategory category = new BmiService().calculateCategory(heightM, widthM);
        System.out.println("You weight category is " + category);
    }
}