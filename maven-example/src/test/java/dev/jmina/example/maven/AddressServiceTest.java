package dev.jmina.example.maven;

import org.junit.jupiter.api.Test;
import org.slf4j.event.Level;

import static dev.jmina.core.Mina.assertAllCalled;
import static dev.jmina.core.Mina.on;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressServiceTest {
    private final AddressService addressService = new AddressService();

    @Test
    public void test() {
        on(AddressService.class, Level.DEBUG, "First and last name: {}")
                .check("John Smith");
        on(AddressService.class, Level.DEBUG, "Region and postcode: {}")
                .check("CA 90210");

        Address address = addressService.parse(
                "John Smith, 9641 Sunset Blvd,,, Beverly Hills, CA 90210, United States"
        );

        assertEquals("John", address.firstName());
        assertEquals("Smith", address.lastName());

        assertEquals("9641 Sunset Blvd", address.address1());
        assertEquals("", address.address2());
        assertEquals("", address.address3());

        assertEquals("Beverly Hills", address.city());
        assertEquals("CA", address.region());
        assertEquals("90210", address.postcode());
        assertEquals("United States", address.country());

        assertAllCalled();
    }
}
