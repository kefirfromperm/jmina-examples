package dev.jmina.example.gradle.groovy;

import org.junit.jupiter.api.Test;
import org.slf4j.event.Level;

import static dev.jmina.core.Mina.assertAllCalled;
import static dev.jmina.core.Mina.on;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EuclideanAlgorithmTest {
    private final EuclideanAlgorithm algorithm = new EuclideanAlgorithm();

    @Test
    public void testGdc() {
        on(EuclideanAlgorithm.class, Level.DEBUG).checkCanonical((index, arguments, _) -> {
            int a = (int) arguments[0];
            int b = (int) arguments[1];
            switch (index) {
                case 0 -> {
                    assertEquals(64, a);
                    assertEquals(58, b);
                }
                case 1 -> {
                    assertEquals(6, a);
                    assertEquals(58, b);
                }
                case 2 -> {
                    assertEquals(6, a);
                    assertEquals(4, b);
                }
                case 3 -> {
                    assertEquals(2, a);
                    assertEquals(4, b);
                }
                case 4 -> {
                    assertEquals(2, a);
                    assertEquals(0, b);
                }
                default -> throw new AssertionError("Unexpected index: " + index);
            }
        });

        int gdc = algorithm.gcd(64, 250);

        assertEquals(2, gdc);

        assertAllCalled();
    }
}
