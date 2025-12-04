package com.td.productcatalog.getproducts.service;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

@Service
public class EncryptDecryptService {

    private static  SecretKey secretKey;
    private  static IvParameterSpec ivParameterSpec;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            secretKey = keyGen.generateKey();

            byte[] ivBytes = new byte[16];
            java.security.SecureRandom random = new java.security.SecureRandom();
            random.nextBytes(ivBytes);
            ivParameterSpec = new IvParameterSpec(ivBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String encrypt(String number)  {

        String encryptedString = "";
        // generated AES key
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(number.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);

        }
        catch (Exception e) {
            System.out.println("Exception occurred while encryption: " + e.getMessage());
        }
        return encryptedString;
    }
    public String decrypt(String encryptedString) {
        String decryptedText = "";
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
            return new String(decrypted);
        }
        catch (Exception e){
            System.out.println("Exception occured while decrypting");
        }
        return decryptedText;
    }
}
