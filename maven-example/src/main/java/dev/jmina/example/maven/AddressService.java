package dev.jmina.example.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressService {
    Logger log = LoggerFactory.getLogger(AddressService.class);

    public Address parse(String address) {
        String[] parts = address.split(",\\s*");

        log.debug("First and last name: {}", parts[0]);
        String[] names = parts[0].split("\\s+");

        log.debug("Region and postcode: {}", parts[5]);
        String[] state = parts[5].split("\\s+");

        return new Address(
                names[0],
                names[1],
                parts[1],
                parts[2],
                parts[3],
                parts[4],
                state[0],
                parts[6],
                state[1]
        );
    }
}
