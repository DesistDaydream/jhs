package com.j256.ormlite.table;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.JavaxPersistenceConfigurer;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class DatabaseTableConfig<T> {
    private static JavaxPersistenceConfigurer javaxPersistenceConfigurer;
    private Constructor<T> constructor;
    private Class<T> dataClass;
    private DatabaseType databaseType;
    private List<DatabaseFieldConfig> fieldConfigs;
    private FieldType[] fieldTypes;
    private String tableName;

    static {
        try {
            Class.forName("javax.persistence.Entity");
            javaxPersistenceConfigurer = (JavaxPersistenceConfigurer) Class.forName("com.j256.ormlite.misc.JavaxPersistenceImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            javaxPersistenceConfigurer = null;
        }
    }

    public DatabaseTableConfig() {
    }

    private FieldType[] convertFieldConfigs(ConnectionSource connectionSource, String str, List<DatabaseFieldConfig> list) throws SQLException {
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (DatabaseFieldConfig databaseFieldConfig : list) {
            FieldType fieldType = null;
            Class<T> cls = this.dataClass;
            while (true) {
                if (cls == null) {
                    break;
                }
                try {
                    declaredField = cls.getDeclaredField(databaseFieldConfig.getFieldName());
                } catch (NoSuchFieldException unused) {
                }
                if (declaredField != null) {
                    fieldType = new FieldType(connectionSource, str, declaredField, databaseFieldConfig, this.dataClass);
                    break;
                }
                cls = cls.getSuperclass();
            }
            if (fieldType != null) {
                arrayList.add(fieldType);
            } else {
                throw new SQLException("Could not find declared field with name '" + databaseFieldConfig.getFieldName() + "' for " + this.dataClass);
            }
        }
        if (!arrayList.isEmpty()) {
            return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        throw new SQLException("No fields were configured for class " + this.dataClass);
    }

    public static <T> String extractTableName(DatabaseType databaseType, Class<T> cls) {
        JavaxPersistenceConfigurer javaxPersistenceConfigurer2;
        DatabaseTable databaseTable = (DatabaseTable) cls.getAnnotation(DatabaseTable.class);
        String tableName = (databaseTable == null || databaseTable.tableName() == null || databaseTable.tableName().length() <= 0) ? null : databaseTable.tableName();
        if (tableName == null && (javaxPersistenceConfigurer2 = javaxPersistenceConfigurer) != null) {
            tableName = javaxPersistenceConfigurer2.getEntityName(cls);
        }
        if (tableName == null) {
            if (databaseType == null) {
                return cls.getSimpleName().toLowerCase(Locale.ENGLISH);
            }
            return databaseType.downCaseString(cls.getSimpleName(), true);
        }
        return tableName;
    }

    public static <T> Constructor<T> findNoArgConstructor(Class<T> cls) {
        try {
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                Constructor<T> constructor2 = (Constructor<T>) constructor;
                if (constructor2.getParameterTypes().length == 0) {
                    if (!constructor2.isAccessible()) {
                        try {
                            constructor2.setAccessible(true);
                        } catch (SecurityException unused) {
                            throw new IllegalArgumentException("Could not open access to constructor for " + cls);
                        }
                    }
                    return constructor2;
                }
            }
            if (cls.getEnclosingClass() == null) {
                throw new IllegalArgumentException("Can't find a no-arg constructor for " + cls);
            }
            throw new IllegalArgumentException("Can't find a no-arg constructor for " + cls + ".  Missing static on inner class?");
        } catch (Exception e2) {
            throw new IllegalArgumentException("Can't lookup declared constructors for " + cls, e2);
        }
    }

    public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        String extractTableName = extractTableName(databaseType, cls);
        if (databaseType.isEntityNamesMustBeUpCase()) {
            extractTableName = databaseType.upCaseEntityName(extractTableName);
        }
        return new DatabaseTableConfig<>(databaseType, cls, extractTableName, extractFieldTypes(connectionSource, cls, extractTableName));
    }

    public void extractFieldTypes(ConnectionSource connectionSource) throws SQLException {
        if (this.fieldTypes == null) {
            List<DatabaseFieldConfig> list = this.fieldConfigs;
            if (list == null) {
                this.fieldTypes = extractFieldTypes(connectionSource, this.dataClass, this.tableName);
            } else {
                this.fieldTypes = convertFieldConfigs(connectionSource, this.tableName, list);
            }
        }
    }

    public Constructor<T> getConstructor() {
        if (this.constructor == null) {
            this.constructor = findNoArgConstructor(this.dataClass);
        }
        return this.constructor;
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public List<DatabaseFieldConfig> getFieldConfigs() {
        return this.fieldConfigs;
    }

    public FieldType[] getFieldTypes(DatabaseType databaseType) throws SQLException {
        FieldType[] fieldTypeArr = this.fieldTypes;
        if (fieldTypeArr != null) {
            return fieldTypeArr;
        }
        throw new SQLException("Field types have not been extracted in table config");
    }

    public String getTableName() {
        return this.tableName;
    }

    public void initialize() {
        Class<T> cls = this.dataClass;
        if (cls != null) {
            if (this.tableName == null) {
                this.tableName = extractTableName(this.databaseType, cls);
                return;
            }
            return;
        }
        throw new IllegalStateException("dataClass was never set on " + getClass().getSimpleName());
    }

    public void setConstructor(Constructor<T> constructor) {
        this.constructor = constructor;
    }

    public void setDataClass(Class<T> cls) {
        this.dataClass = cls;
    }

    public void setDatabaseType(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }

    public void setFieldConfigs(List<DatabaseFieldConfig> list) {
        this.fieldConfigs = list;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public DatabaseTableConfig(DatabaseType databaseType, Class<T> cls, List<DatabaseFieldConfig> list) {
        this(cls, extractTableName(databaseType, cls), list);
    }

    public DatabaseTableConfig(Class<T> cls, String str, List<DatabaseFieldConfig> list) {
        this.dataClass = cls;
        this.tableName = str;
        this.fieldConfigs = list;
    }

    private static <T> FieldType[] extractFieldTypes(ConnectionSource connectionSource, Class<T> cls, String str) throws SQLException {
        ArrayList arrayList = new ArrayList();
        for (Class<T> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Field field : cls2.getDeclaredFields()) {
                FieldType createFieldType = FieldType.createFieldType(connectionSource, str, field, cls);
                if (createFieldType != null) {
                    arrayList.add(createFieldType);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        throw new IllegalArgumentException("No fields have a " + DatabaseField.class.getSimpleName() + " annotation in " + cls);
    }

    private DatabaseTableConfig(DatabaseType databaseType, Class<T> cls, String str, FieldType[] fieldTypeArr) {
        this.databaseType = databaseType;
        this.dataClass = cls;
        this.tableName = str;
        this.fieldTypes = fieldTypeArr;
    }
}
