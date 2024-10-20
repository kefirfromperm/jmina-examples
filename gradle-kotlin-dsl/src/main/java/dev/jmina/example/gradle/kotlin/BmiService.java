package dev.jmina.example.gradle.kotlin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BmiService {
    private final Logger log = LoggerFactory.getLogger(BmiService.class);


    public WeightCategory calculateCategory(double heightM, double weightKg) {
        double index = calculateIndex(heightM, weightKg);

        log.debug("BMI index for height {} and weight {} is {}", heightM, weightKg, index);

        return indexToCategory(index);
    }

    public double calculateIndex(double heightM, double weightKg) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("weightKg must be greater than 0");
        }

        if (heightM <= 0) {
            throw new IllegalArgumentException("heightM must be greater than 0");
        }

        return weightKg / (heightM * heightM);
    }

    public WeightCategory indexToCategory(double index) {
        if (index < 18.5) {
            return WeightCategory.UNDERWEIGHT;
        } else if (index < 25) {
            return WeightCategory.NORMAL;
        } else if (index < 30) {
            return WeightCategory.OVERWEIGHT;
        } else {
            return WeightCategory.OBESE;
        }
    }
}
