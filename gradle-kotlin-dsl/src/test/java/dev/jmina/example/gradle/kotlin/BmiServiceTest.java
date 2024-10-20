package dev.jmina.example.gradle.kotlin;

import org.junit.jupiter.api.Test;

import static dev.jmina.core.Mina.assertAllCalled;
import static dev.jmina.core.Mina.on;
import static dev.jmina.example.gradle.kotlin.WeightCategory.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BmiServiceTest {
    @Test
    public void test() {
        on(BmiService.class).check((Double heightM, Double weightKg, Double index) -> {
                    assertEquals(2d, heightM, 0.1d);
                    assertEquals(80d, weightKg, 0.1d);
                    assertEquals(20d, index, 0.1d);
                }
        );

        BmiService service = new BmiService();
        WeightCategory category = service.calculateCategory(2, 80);

        assertEquals(NORMAL, category);

        assertAllCalled();
    }
}
