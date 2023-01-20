package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class FloatObjectType extends BaseDataType {
    private static final FloatObjectType singleTon = new FloatObjectType();

    private FloatObjectType() {
        super(SqlType.FLOAT, new Class[]{Float.class});
    }

    public static FloatObjectType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Float.valueOf(Float.parseFloat(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException {
        return Float.valueOf(databaseResults.getFloat(i2));
    }

    public FloatObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
