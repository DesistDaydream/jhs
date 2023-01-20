package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public abstract class BaseFieldConverter implements FieldConverter {
    @Override // com.j256.ormlite.field.FieldConverter
    public boolean isStreamType() {
        return false;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
        return obj;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToJava(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException {
        Object resultToSqlArg = resultToSqlArg(fieldType, databaseResults, i2);
        if (resultToSqlArg == null) {
            return null;
        }
        return sqlArgToJava(fieldType, resultToSqlArg, i2);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) throws SQLException {
        return obj;
    }
}
