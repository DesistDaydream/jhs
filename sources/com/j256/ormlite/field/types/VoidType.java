package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class VoidType extends BaseDataType {
    public VoidType() {
        super(null, new Class[0]);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return false;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return null;
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) {
        return null;
    }
}
