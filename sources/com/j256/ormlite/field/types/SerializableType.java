package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class SerializableType extends BaseDataType {
    private static final SerializableType singleTon = new SerializableType();

    private SerializableType() {
        super(SqlType.SERIALIZABLE);
    }

    public static SerializableType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return Serializable.class;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isArgumentHolderRequired() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isComparable() {
        return false;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public boolean isStreamType() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return Serializable.class.isAssignableFrom(field.getType());
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(obj);
                    objectOutputStream2.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    IOUtils.closeQuietly(null);
                    return byteArray;
                } catch (Exception e2) {
                    e = e2;
                    objectOutputStream = objectOutputStream2;
                    throw SqlExceptionUtil.create("Could not write serialized object to byte array: " + obj, e);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    IOUtils.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        throw new SQLException("Default values for serializable types are not supported");
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i2) throws SQLException {
        throw new SQLException("Serializable type cannot be converted from string to Java");
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i2) throws SQLException {
        return databaseResults.getBytes(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i2) throws SQLException {
        byte[] bArr;
        Throwable th;
        Exception e2;
        ObjectInputStream objectInputStream;
        try {
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream((byte[]) obj));
            } catch (Exception e3) {
                e2 = e3;
            } catch (Throwable th2) {
                i2 = 0;
                th = th2;
                IOUtils.closeQuietly(i2);
                throw th;
            }
            try {
                Object readObject = objectInputStream.readObject();
                IOUtils.closeQuietly(objectInputStream);
                return readObject;
            } catch (Exception e4) {
                e2 = e4;
                throw SqlExceptionUtil.create("Could not read serialized object from byte array: " + Arrays.toString(bArr) + "(len " + bArr.length + ")", e2);
            }
        } catch (Throwable th3) {
            th = th3;
            IOUtils.closeQuietly(i2);
            throw th;
        }
    }

    public SerializableType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
