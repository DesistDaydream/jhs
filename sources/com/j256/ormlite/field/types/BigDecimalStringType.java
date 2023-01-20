package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigDecimal;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class BigDecimalStringType extends BaseDataType {
    public static int DEFAULT_WIDTH = 255;
    private static final BigDecimalStringType singleTon = new BigDecimalStringType();

    private BigDecimalStringType() {
        super(SqlType.STRING, new Class[]{BigDecimal.class});
    }

    public static BigDecimalStringType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return ((BigDecimal) obj).toString();
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        try {
            return new BigDecimal(str).toString();
        } catch (IllegalArgumentException e2) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default BigDecimal string '" + str + "'", e2);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException {
        return databaseResults.getString(i2);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) throws SQLException {
        try {
            return new BigDecimal((String) obj);
        } catch (IllegalArgumentException e2) {
            throw SqlExceptionUtil.create("Problems with column " + i2 + " parsing BigDecimal string '" + obj + "'", e2);
        }
    }

    public BigDecimalStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
