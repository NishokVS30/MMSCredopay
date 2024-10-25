package org.Testcases;

import java.util.Set;
import com.github.javafaker.Faker;

public class generateFaker {
    
    public Faker faker = new Faker(); // Instantiate Faker here

    public String generateValidBankName(Faker faker, Set<String> existingBankNames) {
        String bankName;
        int attempts = 0;
        final int maxAttempts = 100;
        do {
            bankName = faker.company().name().trim(); // Generate a bank name
            attempts++;
            if (attempts >= maxAttempts) { // Check if max attempts have been reached
                throw new IllegalStateException("Unable to generate a unique valid bank name after " + maxAttempts + " attempts");
            }
        } while (!isValidBankName(bankName, existingBankNames));

        existingBankNames.add(bankName.toLowerCase()); // Store the valid bank name in the set to avoid future duplicates
        return bankName;
    }

    private boolean isValidBankName(String bankName, Set<String> existingBankNames) {
        if (bankName.length() < 7 || bankName.length() > 30) { // Check length
            return false;
        }
        String baseName = bankName.toLowerCase();
        if (existingBankNames.contains(baseName)) { // Check for duplicate variations
            return false;
        }
        for (int i = 1; i <= 100; i++) { // Check for variations (like "BANK ONE", "BANK TWO")
            String variation = baseName + " " + i;
            if (existingBankNames.contains(variation)) {
                return false;
            }
        }
        return bankName.matches("[a-zA-Z\\s]+"); // Check if the name contains only letters and spaces
    }

    public String generateRandomAddress(Faker fake) {
        String houseNumber = fake.number().numberBetween(1, 100) + "/A"; // Generate a random house number (e.g., "67/A")
        String streetName = fake.address().streetName(); // Generate a random street name
        String cityName = fake.address().city(); // Generate a random city name
         return houseNumber + ", " + streetName + ", " + cityName;
    }

    public String generateValidPAN() {
        StringBuilder pan = new StringBuilder();
        for (int i = 0; i < 5; i++) { // First 5 characters: Uppercase letters
            pan.append(faker.regexify("[A-Z]"));
        }
        for (int i = 0; i < 4; i++) { // Next 4 characters: Digits
            pan.append(faker.number().numberBetween(0, 10));
        }
        pan.append(faker.regexify("[A-Z]")); // Last character: Uppercase letter
        return pan.toString();
    }

    public String generateValidGST() {
        StringBuilder gst = new StringBuilder();
        int stateCode = faker.number().numberBetween(1, 38); // First 2 characters: State code (01 to 37)
        gst.append(String.format("%02d", stateCode)); // Format to ensure 2 digits

        for (int i = 0; i < 5; i++) { // Next 10 characters: PAN number (5 letters, 4 digits, 1 letter)
            gst.append(faker.regexify("[A-Z]"));
        }
        for (int i = 0; i < 4; i++) {
            gst.append(faker.number().numberBetween(0, 10));
        }
        gst.append(faker.regexify("[A-Z]")); // Last character of PAN number
        gst.append("Z"); // Entity type (Z by default)
        for (int i = 0; i < 3; i++) { // Last 3 characters: Checksum
            gst.append(faker.regexify("[A-Z0-9]"));
        }
        return gst.toString();
    }
}
