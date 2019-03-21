package com.binny.test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Main {

    public static void main(String[] args) {
        String password = "test";
        String salt;
        String ciphertext;
        try {

            salt = PasswordEncryption.generateSalt();
            ciphertext = PasswordEncryption.getEncryptedPassword(password, salt);
            boolean result = PasswordEncryption.authenticate(password, ciphertext, salt);

            System.out.println(password + "  " + password.length());
            System.out.println(salt + "  " + salt.length());
            System.out.println(ciphertext + "  " + ciphertext.length());
            if (result) {
                System.out.println("succeed");
            } else {
                System.out.println("failed");
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException e) {
            System.out.println("InvalidKeySpecException");
        }
    }
}
