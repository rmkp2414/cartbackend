package com.manuja.shoppingapp.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.security.Key;
import org.apache.commons.codec.binary.Base64;


@Converter
public class DbEncryptionService implements AttributeConverter<String, String> {

    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String AES = "AES";
    private static final String SECRET = "LRY4Ct2gNxeqXbUGgw3kd0xQ7E84Kjcu";

    private final Key key;
    private final Cipher cipher;

    public DbEncryptionService() throws Exception {
        key = new SecretKeySpec(SECRET.getBytes(), AES);
        cipher = Cipher.getInstance(ALGORITHM);
    }

    @Override
    public synchronized String convertToDatabaseColumn(String attribute) {
        //encryption
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.encodeBase64String(cipher.doFinal(attribute.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized String convertToEntityAttribute(String dbData) {
        //decryption
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.decodeBase64(dbData)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

