package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class EnumIntegerType extends BaseEnumType {
    private static final EnumIntegerType singleTon = new EnumIntegerType();

    private EnumIntegerType() {
        super(SqlType.INTEGER);
    }

    public static EnumIntegerType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return Integer.TYPE;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return Integer.valueOf(((Enum) obj).ordinal());
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        HashMap hashMap = new HashMap();
        Enum[] enumArr = (Enum[]) fieldType.getType().getEnumConstants();
        if (enumArr != null) {
            for (Enum r3 : enumArr) {
                hashMap.put(Integer.valueOf(r3.ordinal()), r3);
            }
            return hashMap;
        }
        throw new SQLException("Could not get enum-constants for field " + fieldType);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Integer.valueOf(Integer.parseInt(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException {
        return Integer.valueOf(databaseResults.getInt(i2));
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) throws SQLException {
        if (fieldType == null) {
            return obj;
        }
        Integer num = (Integer) obj;
        Map map = (Map) fieldType.getDataTypeConfigObj();
        if (map == null) {
            return BaseEnumType.enumVal(fieldType, num, null, fieldType.getUnknownEnumVal());
        }
        return BaseEnumType.enumVal(fieldType, num, (Enum) map.get(num), fieldType.getUnknownEnumVal());
    }

    public EnumIntegerType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
