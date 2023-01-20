package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class BooleanObjectType extends BaseDataType {
    private static final BooleanObjectType singleTon = new BooleanObjectType();

    private BooleanObjectType() {
        super(SqlType.BOOLEAN, new Class[]{Boolean.class});
    }

    public static BooleanObjectType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException {
        return Boolean.valueOf(databaseResults.getBoolean(i2));
    }

    public BooleanObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public BooleanObjectType(SqlType sqlType) {
        super(sqlType);
    }
}
