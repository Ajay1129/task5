package com.project_1;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static String generatePassword(int length, boolean useUppercase, boolean useLowercase, boolean useNumbers, boolean useSpecialChars) {
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+<>?";

        StringBuilder charPool = new StringBuilder();

        if (useUppercase) {
            charPool.append(uppercaseLetters);
        }
        if (useLowercase) {
            charPool.append(lowercaseLetters);
        }
        if (useNumbers) {
            charPool.append(numbers);
        }
        if (useSpecialChars) {
            charPool.append(specialChars);
        }

        if (charPool.length() == 0) {
            throw new IllegalArgumentException("You must select at least one character type!");
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charPool.length());
            password.append(charPool.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Random Password Generator!");

        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean useUppercase = scanner.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean useLowercase = scanner.nextBoolean();

        System.out.print("Include numbers? (true/false): ");
        boolean useNumbers = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean useSpecialChars = scanner.nextBoolean();

        try {
            String password = generatePassword(length, useUppercase, useLowercase, useNumbers, useSpecialChars);
            System.out.println("Generated Password: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
