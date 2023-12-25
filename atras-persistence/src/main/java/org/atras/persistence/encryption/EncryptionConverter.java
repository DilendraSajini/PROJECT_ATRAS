package org.atras.persistence.encryption;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EncryptionConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        // Implement encryption logic
        // For example, you can use a library like Jasypt or implement your encryption algorithm
        // Here, Base64 encoding is used for simplicity (not recommended for real encryption)
        return Base64.getEncoder().encodeToString(attribute.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        // Implement decryption logic
        // Here, Base64 decoding is used for simplicity (not recommended for real encryption)
        byte[] decodedBytes = Base64.getDecoder().decode(dbData);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}
