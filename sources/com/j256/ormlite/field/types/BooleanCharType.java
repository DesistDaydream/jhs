package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class BooleanCharType extends BooleanType {
    private static final String DEFAULT_TRUE_FALSE_FORMAT = "10";
    private static final BooleanCharType singleTon = new BooleanCharType();

    public BooleanCharType() {
        super(SqlType.STRING);
    }

    public static BooleanCharType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return Character.valueOf(((String) fieldType.getDataTypeConfigObj()).charAt(((Boolean) obj).booleanValue() ? 0 : 1));
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        String format = fieldType.getFormat();
        if (format == null) {
            return DEFAULT_TRUE_FALSE_FORMAT;
        }
        if (format.length() != 2 || format.charAt(0) == format.charAt(1)) {
            throw new SQLException("Invalid boolean format must have 2 different characters that represent true/false like \"10\" or \"tf\": " + format);
        }
        return format;
    }

    @Override // com.j256.ormlite.field.types.BooleanObjectType, com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return javaToSqlArg(fieldType, Boolean.valueOf(Boolean.parseBoolean(str)));
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i2) {
        if (str.length() == 0) {
            return Boolean.FALSE;
        }
        return sqlArgToJava(fieldType, Character.valueOf(str.charAt(0)), i2);
    }

    @Override // com.j256.ormlite.field.types.BooleanObjectType, com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException {
        return Character.valueOf(databaseResults.getChar(i2));
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) {
        return ((Character) obj).charValue() == ((String) fieldType.getDataTypeConfigObj()).charAt(0) ? Boolean.TRUE : Boolean.FALSE;
    }
}
