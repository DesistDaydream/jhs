package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes2.dex */
public class LongType extends LongObjectType {
    private static final LongType singleTon = new LongType();

    private LongType() {
        super(SqlType.LONG, new Class[]{Long.TYPE});
    }

    public static LongType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    public LongType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
