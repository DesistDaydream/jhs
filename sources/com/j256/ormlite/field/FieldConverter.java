package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public interface FieldConverter {
    SqlType getSqlType();

    boolean isStreamType();

    Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException;

    Object parseDefaultString(FieldType fieldType, String str) throws SQLException;

    Object resultStringToJava(FieldType fieldType, String str, int i2) throws SQLException;

    Object resultToJava(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException;

    Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException;

    Object sqlArgToJava(FieldType fieldType, Object obj, int i2) throws SQLException;
}
