package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BaseDateType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes2.dex */
public class DateType extends BaseDateType {
    private static final DateType singleTon = new DateType();

    private DateType() {
        super(SqlType.DATE, new Class[]{Date.class});
    }

    public static DateType getSingleton() {
        return singleTon;
    }

    public BaseDateType.DateStringFormatConfig getDefaultDateFormatConfig() {
        return BaseDateType.defaultDateFormatConfig;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isArgumentHolderRequired() {
        return true;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return new Timestamp(((Date) obj).getTime());
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        BaseDateType.DateStringFormatConfig convertDateStringConfig = BaseDateType.convertDateStringConfig(fieldType, getDefaultDateFormatConfig());
        try {
            return new Timestamp(BaseDateType.parseDateString(convertDateStringConfig, str).getTime());
        } catch (ParseException e2) {
            throw SqlExceptionUtil.create("Problems parsing default date string '" + str + "' using '" + convertDateStringConfig + '\'', e2);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException {
        return databaseResults.getTimestamp(i2);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) {
        return new Date(((Timestamp) obj).getTime());
    }

    public DateType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
