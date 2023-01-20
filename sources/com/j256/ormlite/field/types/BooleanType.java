package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes2.dex */
public class BooleanType extends BooleanObjectType {
    private static final BooleanType singleTon = new BooleanType();

    private BooleanType() {
        super(SqlType.BOOLEAN, new Class[]{Boolean.TYPE});
    }

    public static BooleanType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    public BooleanType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public BooleanType(SqlType sqlType) {
        super(sqlType);
    }
}
