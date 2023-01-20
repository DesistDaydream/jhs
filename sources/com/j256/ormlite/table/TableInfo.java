package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TableInfo<T, ID> {
    private static final FieldType[] NO_FOREIGN_COLLECTIONS = new FieldType[0];
    private final BaseDaoImpl<T, ID> baseDaoImpl;
    private final Constructor<T> constructor;
    private final Class<T> dataClass;
    private final DatabaseType databaseType;
    private Map<String, FieldType> fieldNameMap;
    private final FieldType[] fieldTypes;
    private final boolean foreignAutoCreate;
    private final FieldType[] foreignCollections;
    private final FieldType idField;
    private final String tableName;

    public TableInfo(ConnectionSource connectionSource, BaseDaoImpl<T, ID> baseDaoImpl, Class<T> cls) throws SQLException {
        this(connectionSource.getDatabaseType(), baseDaoImpl, DatabaseTableConfig.fromClass(connectionSource, cls));
    }

    private static <T, ID> void wireNewInstance(BaseDaoImpl<T, ID> baseDaoImpl, T t) {
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(baseDaoImpl);
        }
    }

    public T createObject() throws SQLException {
        T createObject;
        try {
            BaseDaoImpl<T, ID> baseDaoImpl = this.baseDaoImpl;
            ObjectFactory<T> objectFactory = baseDaoImpl != null ? baseDaoImpl.getObjectFactory() : null;
            if (objectFactory == null) {
                createObject = this.constructor.newInstance(new Object[0]);
            } else {
                createObject = objectFactory.createObject(this.constructor, this.baseDaoImpl.getDataClass());
            }
            wireNewInstance(this.baseDaoImpl, createObject);
            return createObject;
        } catch (Exception e2) {
            throw SqlExceptionUtil.create("Could not create object for " + this.constructor.getDeclaringClass(), e2);
        }
    }

    public Constructor<T> getConstructor() {
        return this.constructor;
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public FieldType getFieldTypeByColumnName(String str) {
        FieldType[] fieldTypeArr;
        if (this.fieldNameMap == null) {
            HashMap hashMap = new HashMap();
            for (FieldType fieldType : this.fieldTypes) {
                hashMap.put(this.databaseType.downCaseString(fieldType.getColumnName(), true), fieldType);
            }
            this.fieldNameMap = hashMap;
        }
        FieldType fieldType2 = this.fieldNameMap.get(this.databaseType.downCaseString(str, true));
        if (fieldType2 != null) {
            return fieldType2;
        }
        for (FieldType fieldType3 : this.fieldTypes) {
            if (fieldType3.getFieldName().equals(str)) {
                throw new IllegalArgumentException("You should use columnName '" + fieldType3.getColumnName() + "' for table " + this.tableName + " instead of fieldName '" + fieldType3.getFieldName() + "'");
            }
        }
        throw new IllegalArgumentException("Unknown column name '" + str + "' in table " + this.tableName);
    }

    public FieldType[] getFieldTypes() {
        return this.fieldTypes;
    }

    public FieldType[] getForeignCollections() {
        return this.foreignCollections;
    }

    public FieldType getIdField() {
        return this.idField;
    }

    public String getTableName() {
        return this.tableName;
    }

    public boolean hasColumnName(String str) {
        for (FieldType fieldType : this.fieldTypes) {
            if (fieldType.getColumnName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isForeignAutoCreate() {
        return this.foreignAutoCreate;
    }

    public boolean isUpdatable() {
        return this.idField != null && this.fieldTypes.length > 1;
    }

    public String objectToString(T t) {
        FieldType[] fieldTypeArr;
        StringBuilder sb = new StringBuilder(64);
        sb.append(t.getClass().getSimpleName());
        for (FieldType fieldType : this.fieldTypes) {
            sb.append(' ');
            sb.append(fieldType.getColumnName());
            sb.append('=');
            try {
                sb.append(fieldType.extractJavaFieldValue(t));
            } catch (Exception e2) {
                throw new IllegalStateException("Could not generate toString of field " + fieldType, e2);
            }
        }
        return sb.toString();
    }

    public TableInfo(DatabaseType databaseType, BaseDaoImpl<T, ID> baseDaoImpl, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        FieldType[] fieldTypeArr;
        this.databaseType = databaseType;
        this.baseDaoImpl = baseDaoImpl;
        this.dataClass = databaseTableConfig.getDataClass();
        this.tableName = databaseTableConfig.getTableName();
        FieldType[] fieldTypes = databaseTableConfig.getFieldTypes(databaseType);
        this.fieldTypes = fieldTypes;
        FieldType fieldType = null;
        boolean z = false;
        int i2 = 0;
        for (FieldType fieldType2 : fieldTypes) {
            if (fieldType2.isId() || fieldType2.isGeneratedId() || fieldType2.isGeneratedIdSequence()) {
                if (fieldType != null) {
                    throw new SQLException("More than 1 idField configured for class " + this.dataClass + " (" + fieldType + Constants.ACCEPT_TIME_SEPARATOR_SP + fieldType2 + ")");
                }
                fieldType = fieldType2;
            }
            z = fieldType2.isForeignAutoCreate() ? true : z;
            if (fieldType2.isForeignCollection()) {
                i2++;
            }
        }
        this.idField = fieldType;
        this.constructor = databaseTableConfig.getConstructor();
        this.foreignAutoCreate = z;
        if (i2 == 0) {
            this.foreignCollections = NO_FOREIGN_COLLECTIONS;
            return;
        }
        this.foreignCollections = new FieldType[i2];
        int i3 = 0;
        for (FieldType fieldType3 : this.fieldTypes) {
            if (fieldType3.isForeignCollection()) {
                this.foreignCollections[i3] = fieldType3;
                i3++;
            }
        }
    }
}
