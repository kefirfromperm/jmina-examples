package dev.jmina.example.gradle.groovy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EuclideanAlgorithm {
    private final Logger log = LoggerFactory.getLogger(EuclideanAlgorithm.class);

    public int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("The given arguments cannot be negative");
        }

        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }

            log.debug("a = {}, b = {}", a, b);
        }

        return a + b;
    }
}
