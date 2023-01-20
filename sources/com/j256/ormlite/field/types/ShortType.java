package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes2.dex */
public class ShortType extends ShortObjectType {
    private static final ShortType singleTon = new ShortType();

    private ShortType() {
        super(SqlType.SHORT, new Class[]{Short.TYPE});
    }

    public static ShortType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    public ShortType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
