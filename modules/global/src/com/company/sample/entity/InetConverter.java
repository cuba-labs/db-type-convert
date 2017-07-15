package com.company.sample.entity;

import org.postgresql.util.PGobject;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.SQLException;

@Converter
public class InetConverter implements AttributeConverter<String, Object> {

    @Override
    public Object convertToDatabaseColumn(String attribute) {
        if (attribute == null)
            return null;
        PGobject pgobject = new PGobject();
        pgobject.setType("inet");
        try {
            pgobject.setValue(attribute);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pgobject;
    }

    @Override
    public String convertToEntityAttribute(Object dbData) {
        return dbData == null ? null : dbData.toString();
    }
}
