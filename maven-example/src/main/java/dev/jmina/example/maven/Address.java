package dev.jmina.example.maven;

public record Address(
        String firstName,
        String lastName,
        String address1,
        String address2,
        String address3,
        String city,
        String region,
        String country,
        String postcode
) {
}
