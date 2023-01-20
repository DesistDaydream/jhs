package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class EnumStringType extends BaseEnumType {
    public static int DEFAULT_WIDTH = 100;
    private static final EnumStringType singleTon = new EnumStringType();

    private EnumStringType() {
        super(SqlType.STRING, new Class[]{Enum.class});
    }

    public static EnumStringType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    public String getEnumName(Enum<?> r1) {
        return r1.name();
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return getEnumName((Enum) obj);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        HashMap hashMap = new HashMap();
        Enum<?>[] enumArr = (Enum[]) fieldType.getType().getEnumConstants();
        if (enumArr != null) {
            for (Enum<?> r3 : enumArr) {
                hashMap.put(getEnumName(r3), r3);
            }
            return hashMap;
        }
        throw new SQLException("Could not get enum-constants for field " + fieldType + ", not an enum or maybe generic?");
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return str;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException {
        return databaseResults.getString(i2);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) throws SQLException {
        if (fieldType == null) {
            return obj;
        }
        String str = (String) obj;
        Map map = (Map) fieldType.getDataTypeConfigObj();
        if (map == null) {
            return BaseEnumType.enumVal(fieldType, str, null, fieldType.getUnknownEnumVal());
        }
        return BaseEnumType.enumVal(fieldType, str, (Enum) map.get(str), fieldType.getUnknownEnumVal());
    }

    public EnumStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
