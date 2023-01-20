package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;

/* loaded from: classes2.dex */
public class CharType extends CharacterObjectType {
    private static final CharType singleTon = new CharType();

    private CharType() {
        super(SqlType.CHAR, new Class[]{Character.TYPE});
    }

    public static CharType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        Character ch = (Character) obj;
        if (ch == null || ch.charValue() == 0) {
            return null;
        }
        return ch;
    }

    public CharType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
