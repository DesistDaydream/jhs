package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes2.dex */
public class IntType extends IntegerObjectType {
    private static final IntType singleTon = new IntType();

    private IntType() {
        super(SqlType.INTEGER, new Class[]{Integer.TYPE});
    }

    public static IntType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    public IntType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
