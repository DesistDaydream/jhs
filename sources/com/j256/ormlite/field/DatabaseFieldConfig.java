package com.j256.ormlite.field;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.JavaxPersistenceConfigurer;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class DatabaseFieldConfig {
    public static final boolean DEFAULT_CAN_BE_NULL = true;
    public static final boolean DEFAULT_FOREIGN_COLLECTION_ORDER_ASCENDING = true;
    private static final int DEFAULT_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = 1;
    public static final int NO_MAX_FOREIGN_AUTO_REFRESH_LEVEL_SPECIFIED = -1;
    private static JavaxPersistenceConfigurer javaxPersistenceConfigurer;
    private boolean allowGeneratedIdInsert;
    private boolean canBeNull;
    private String columnDefinition;
    private String columnName;
    private DataPersister dataPersister;
    private DataType dataType;
    private String defaultValue;
    private String fieldName;
    private boolean foreign;
    private boolean foreignAutoCreate;
    private boolean foreignAutoRefresh;
    private boolean foreignCollection;
    private String foreignCollectionColumnName;
    private boolean foreignCollectionEager;
    private String foreignCollectionForeignFieldName;
    private int foreignCollectionMaxEagerLevel;
    private boolean foreignCollectionOrderAscending;
    private String foreignCollectionOrderColumnName;
    private String foreignColumnName;
    private DatabaseTableConfig<?> foreignTableConfig;
    private String format;
    private String fullColumnDefinition;
    private boolean generatedId;
    private String generatedIdSequence;
    private boolean id;
    private boolean index;
    private String indexName;
    private int maxForeignAutoRefreshLevel;
    private boolean persisted;
    private Class<? extends DataPersister> persisterClass;
    private boolean readOnly;
    private boolean throwIfNull;
    private boolean unique;
    private boolean uniqueCombo;
    private boolean uniqueIndex;
    private String uniqueIndexName;
    private Enum<?> unknownEnumValue;
    private boolean useGetSet;
    private boolean version;
    private int width;
    public static final Class<? extends DataPersister> DEFAULT_PERSISTER_CLASS = VoidType.class;
    public static final DataType DEFAULT_DATA_TYPE = DataType.UNKNOWN;

    static {
        try {
            Class.forName("javax.persistence.Entity");
            javaxPersistenceConfigurer = (JavaxPersistenceConfigurer) Class.forName("com.j256.ormlite.misc.JavaxPersistenceImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            javaxPersistenceConfigurer = null;
        }
    }

    public DatabaseFieldConfig() {
        this.dataType = DEFAULT_DATA_TYPE;
        this.canBeNull = true;
        this.persisted = true;
        this.maxForeignAutoRefreshLevel = -1;
        this.persisterClass = DEFAULT_PERSISTER_CLASS;
        this.foreignCollectionMaxEagerLevel = 1;
        this.foreignCollectionOrderAscending = true;
    }

    public static Method findGetMethod(Field field, DatabaseType databaseType, boolean z) throws IllegalArgumentException {
        Method findMethodFromNames = findMethodFromNames(field, true, z, methodFromField(field, "get", databaseType, true), methodFromField(field, "get", databaseType, false), methodFromField(field, "is", databaseType, true), methodFromField(field, "is", databaseType, false));
        if (findMethodFromNames == null) {
            return null;
        }
        if (findMethodFromNames.getReturnType() != field.getType()) {
            if (z) {
                throw new IllegalArgumentException("Return type of get method " + findMethodFromNames.getName() + " does not return " + field.getType());
            }
            return null;
        }
        return findMethodFromNames;
    }

    private String findIndexName(String str) {
        if (this.columnName == null) {
            return str + "_" + this.fieldName + "_idx";
        }
        return str + "_" + this.columnName + "_idx";
    }

    public static Enum<?> findMatchingEnumVal(Field field, String str) {
        Enum<?>[] enumArr;
        if (str == null || str.length() == 0) {
            return null;
        }
        for (Enum<?> r3 : (Enum[]) field.getType().getEnumConstants()) {
            if (r3.name().equals(str)) {
                return r3;
            }
        }
        throw new IllegalArgumentException("Unknwown enum unknown name " + str + " for field " + field);
    }

    private static Method findMethodFromNames(Field field, boolean z, boolean z2, String... strArr) {
        NoSuchMethodException noSuchMethodException = null;
        for (String str : strArr) {
            try {
                return z ? field.getDeclaringClass().getMethod(str, new Class[0]) : field.getDeclaringClass().getMethod(str, field.getType());
            } catch (NoSuchMethodException e2) {
                if (noSuchMethodException == null) {
                    noSuchMethodException = e2;
                }
            }
        }
        if (z2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find appropriate ");
            sb.append(z ? "get" : "set");
            sb.append(" method for ");
            sb.append(field);
            throw new IllegalArgumentException(sb.toString(), noSuchMethodException);
        }
        return null;
    }

    public static Method findSetMethod(Field field, DatabaseType databaseType, boolean z) throws IllegalArgumentException {
        Method findMethodFromNames = findMethodFromNames(field, false, z, methodFromField(field, "set", databaseType, true), methodFromField(field, "set", databaseType, false));
        if (findMethodFromNames == null) {
            return null;
        }
        if (findMethodFromNames.getReturnType() != Void.TYPE) {
            if (z) {
                throw new IllegalArgumentException("Return type of set method " + findMethodFromNames.getName() + " returns " + findMethodFromNames.getReturnType() + " instead of void");
            }
            return null;
        }
        return findMethodFromNames;
    }

    public static DatabaseFieldConfig fromDatabaseField(DatabaseType databaseType, String str, Field field, DatabaseField databaseField) {
        DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
        databaseFieldConfig.fieldName = field.getName();
        if (databaseType.isEntityNamesMustBeUpCase()) {
            databaseFieldConfig.fieldName = databaseType.upCaseEntityName(databaseFieldConfig.fieldName);
        }
        databaseFieldConfig.columnName = valueIfNotBlank(databaseField.columnName());
        databaseFieldConfig.dataType = databaseField.dataType();
        String defaultValue = databaseField.defaultValue();
        if (!defaultValue.equals(DatabaseField.DEFAULT_STRING)) {
            databaseFieldConfig.defaultValue = defaultValue;
        }
        databaseFieldConfig.width = databaseField.width();
        databaseFieldConfig.canBeNull = databaseField.canBeNull();
        databaseFieldConfig.id = databaseField.id();
        databaseFieldConfig.generatedId = databaseField.generatedId();
        databaseFieldConfig.generatedIdSequence = valueIfNotBlank(databaseField.generatedIdSequence());
        databaseFieldConfig.foreign = databaseField.foreign();
        databaseFieldConfig.useGetSet = databaseField.useGetSet();
        databaseFieldConfig.unknownEnumValue = findMatchingEnumVal(field, databaseField.unknownEnumName());
        databaseFieldConfig.throwIfNull = databaseField.throwIfNull();
        databaseFieldConfig.format = valueIfNotBlank(databaseField.format());
        databaseFieldConfig.unique = databaseField.unique();
        databaseFieldConfig.uniqueCombo = databaseField.uniqueCombo();
        databaseFieldConfig.index = databaseField.index();
        databaseFieldConfig.indexName = valueIfNotBlank(databaseField.indexName());
        databaseFieldConfig.uniqueIndex = databaseField.uniqueIndex();
        databaseFieldConfig.uniqueIndexName = valueIfNotBlank(databaseField.uniqueIndexName());
        boolean foreignAutoRefresh = databaseField.foreignAutoRefresh();
        databaseFieldConfig.foreignAutoRefresh = foreignAutoRefresh;
        if (!foreignAutoRefresh && databaseField.maxForeignAutoRefreshLevel() == 2) {
            databaseFieldConfig.maxForeignAutoRefreshLevel = -1;
        } else {
            databaseFieldConfig.maxForeignAutoRefreshLevel = databaseField.maxForeignAutoRefreshLevel();
        }
        databaseFieldConfig.persisterClass = databaseField.persisterClass();
        databaseFieldConfig.allowGeneratedIdInsert = databaseField.allowGeneratedIdInsert();
        databaseFieldConfig.columnDefinition = valueIfNotBlank(databaseField.columnDefinition());
        databaseFieldConfig.foreignAutoCreate = databaseField.foreignAutoCreate();
        databaseFieldConfig.version = databaseField.version();
        databaseFieldConfig.foreignColumnName = valueIfNotBlank(databaseField.foreignColumnName());
        databaseFieldConfig.readOnly = databaseField.readOnly();
        databaseFieldConfig.fullColumnDefinition = valueIfNotBlank(databaseField.fullColumnDefinition());
        return databaseFieldConfig;
    }

    public static DatabaseFieldConfig fromField(DatabaseType databaseType, String str, Field field) throws SQLException {
        DatabaseField databaseField = (DatabaseField) field.getAnnotation(DatabaseField.class);
        if (databaseField != null) {
            if (databaseField.persisted()) {
                return fromDatabaseField(databaseType, str, field, databaseField);
            }
            return null;
        }
        ForeignCollectionField foreignCollectionField = (ForeignCollectionField) field.getAnnotation(ForeignCollectionField.class);
        if (foreignCollectionField != null) {
            return fromForeignCollection(databaseType, field, foreignCollectionField);
        }
        JavaxPersistenceConfigurer javaxPersistenceConfigurer2 = javaxPersistenceConfigurer;
        if (javaxPersistenceConfigurer2 == null) {
            return null;
        }
        return javaxPersistenceConfigurer2.createFieldConfig(databaseType, field);
    }

    private static DatabaseFieldConfig fromForeignCollection(DatabaseType databaseType, Field field, ForeignCollectionField foreignCollectionField) {
        DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
        databaseFieldConfig.fieldName = field.getName();
        if (foreignCollectionField.columnName().length() > 0) {
            databaseFieldConfig.columnName = foreignCollectionField.columnName();
        }
        databaseFieldConfig.foreignCollection = true;
        databaseFieldConfig.foreignCollectionEager = foreignCollectionField.eager();
        databaseFieldConfig.foreignCollectionMaxEagerLevel = foreignCollectionField.maxEagerLevel();
        databaseFieldConfig.foreignCollectionOrderColumnName = valueIfNotBlank(foreignCollectionField.orderColumnName());
        databaseFieldConfig.foreignCollectionOrderAscending = foreignCollectionField.orderAscending();
        databaseFieldConfig.foreignCollectionColumnName = valueIfNotBlank(foreignCollectionField.columnName());
        databaseFieldConfig.foreignCollectionForeignFieldName = valueIfNotBlank(foreignCollectionField.foreignFieldName());
        return databaseFieldConfig;
    }

    private static String methodFromField(Field field, String str, DatabaseType databaseType, boolean z) {
        String name = field.getName();
        String upCaseString = databaseType.upCaseString(name.substring(0, 1), z);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(upCaseString);
        sb.append((CharSequence) name, 1, name.length());
        return sb.toString();
    }

    private static String valueIfNotBlank(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }

    public String getColumnDefinition() {
        return this.columnDefinition;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public DataPersister getDataPersister() {
        DataPersister dataPersister = this.dataPersister;
        return dataPersister == null ? this.dataType.getDataPersister() : dataPersister;
    }

    public DataType getDataType() {
        return this.dataType;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getForeignCollectionColumnName() {
        return this.foreignCollectionColumnName;
    }

    public String getForeignCollectionForeignFieldName() {
        return this.foreignCollectionForeignFieldName;
    }

    public int getForeignCollectionMaxEagerLevel() {
        return this.foreignCollectionMaxEagerLevel;
    }

    public String getForeignCollectionOrderColumnName() {
        return this.foreignCollectionOrderColumnName;
    }

    public String getForeignColumnName() {
        return this.foreignColumnName;
    }

    public DatabaseTableConfig<?> getForeignTableConfig() {
        return this.foreignTableConfig;
    }

    public String getFormat() {
        return this.format;
    }

    public String getFullColumnDefinition() {
        return this.fullColumnDefinition;
    }

    public String getGeneratedIdSequence() {
        return this.generatedIdSequence;
    }

    public String getIndexName(String str) {
        if (this.index && this.indexName == null) {
            this.indexName = findIndexName(str);
        }
        return this.indexName;
    }

    public int getMaxForeignAutoRefreshLevel() {
        if (this.foreignAutoRefresh) {
            return this.maxForeignAutoRefreshLevel;
        }
        return -1;
    }

    public Class<? extends DataPersister> getPersisterClass() {
        return this.persisterClass;
    }

    public String getUniqueIndexName(String str) {
        if (this.uniqueIndex && this.uniqueIndexName == null) {
            this.uniqueIndexName = findIndexName(str);
        }
        return this.uniqueIndexName;
    }

    public Enum<?> getUnknownEnumValue() {
        return this.unknownEnumValue;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAllowGeneratedIdInsert() {
        return this.allowGeneratedIdInsert;
    }

    public boolean isCanBeNull() {
        return this.canBeNull;
    }

    public boolean isForeign() {
        return this.foreign;
    }

    public boolean isForeignAutoCreate() {
        return this.foreignAutoCreate;
    }

    public boolean isForeignAutoRefresh() {
        return this.foreignAutoRefresh;
    }

    public boolean isForeignCollection() {
        return this.foreignCollection;
    }

    public boolean isForeignCollectionEager() {
        return this.foreignCollectionEager;
    }

    public boolean isForeignCollectionOrderAscending() {
        return this.foreignCollectionOrderAscending;
    }

    public boolean isGeneratedId() {
        return this.generatedId;
    }

    public boolean isId() {
        return this.id;
    }

    public boolean isIndex() {
        return this.index;
    }

    public boolean isPersisted() {
        return this.persisted;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public boolean isThrowIfNull() {
        return this.throwIfNull;
    }

    public boolean isUnique() {
        return this.unique;
    }

    public boolean isUniqueCombo() {
        return this.uniqueCombo;
    }

    public boolean isUniqueIndex() {
        return this.uniqueIndex;
    }

    public boolean isUseGetSet() {
        return this.useGetSet;
    }

    public boolean isVersion() {
        return this.version;
    }

    public void postProcess() {
        if (this.foreignColumnName != null) {
            this.foreignAutoRefresh = true;
        }
        if (this.foreignAutoRefresh && this.maxForeignAutoRefreshLevel == -1) {
            this.maxForeignAutoRefreshLevel = 2;
        }
    }

    public void setAllowGeneratedIdInsert(boolean z) {
        this.allowGeneratedIdInsert = z;
    }

    public void setCanBeNull(boolean z) {
        this.canBeNull = z;
    }

    public void setColumnDefinition(String str) {
        this.columnDefinition = str;
    }

    public void setColumnName(String str) {
        this.columnName = str;
    }

    public void setDataPersister(DataPersister dataPersister) {
        this.dataPersister = dataPersister;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public void setDefaultValue(String str) {
        this.defaultValue = str;
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public void setForeign(boolean z) {
        this.foreign = z;
    }

    public void setForeignAutoCreate(boolean z) {
        this.foreignAutoCreate = z;
    }

    public void setForeignAutoRefresh(boolean z) {
        this.foreignAutoRefresh = z;
    }

    public void setForeignCollection(boolean z) {
        this.foreignCollection = z;
    }

    public void setForeignCollectionColumnName(String str) {
        this.foreignCollectionColumnName = str;
    }

    public void setForeignCollectionEager(boolean z) {
        this.foreignCollectionEager = z;
    }

    public void setForeignCollectionForeignFieldName(String str) {
        this.foreignCollectionForeignFieldName = str;
    }

    public void setForeignCollectionMaxEagerLevel(int i2) {
        this.foreignCollectionMaxEagerLevel = i2;
    }

    public void setForeignCollectionOrderAscending(boolean z) {
        this.foreignCollectionOrderAscending = z;
    }

    public void setForeignCollectionOrderColumnName(String str) {
        this.foreignCollectionOrderColumnName = str;
    }

    public void setForeignColumnName(String str) {
        this.foreignColumnName = str;
    }

    public void setForeignTableConfig(DatabaseTableConfig<?> databaseTableConfig) {
        this.foreignTableConfig = databaseTableConfig;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setFullColumnDefinition(String str) {
        this.fullColumnDefinition = str;
    }

    public void setGeneratedId(boolean z) {
        this.generatedId = z;
    }

    public void setGeneratedIdSequence(String str) {
        this.generatedIdSequence = str;
    }

    public void setId(boolean z) {
        this.id = z;
    }

    public void setIndex(boolean z) {
        this.index = z;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public void setMaxForeignAutoRefreshLevel(int i2) {
        this.maxForeignAutoRefreshLevel = i2;
    }

    public void setPersisted(boolean z) {
        this.persisted = z;
    }

    public void setPersisterClass(Class<? extends DataPersister> cls) {
        this.persisterClass = cls;
    }

    public void setReadOnly(boolean z) {
        this.readOnly = z;
    }

    public void setThrowIfNull(boolean z) {
        this.throwIfNull = z;
    }

    public void setUnique(boolean z) {
        this.unique = z;
    }

    public void setUniqueCombo(boolean z) {
        this.uniqueCombo = z;
    }

    public void setUniqueIndex(boolean z) {
        this.uniqueIndex = z;
    }

    public void setUniqueIndexName(String str) {
        this.uniqueIndexName = str;
    }

    public void setUnknownEnumValue(Enum<?> r1) {
        this.unknownEnumValue = r1;
    }

    public void setUseGetSet(boolean z) {
        this.useGetSet = z;
    }

    public void setVersion(boolean z) {
        this.version = z;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public DatabaseFieldConfig(String str) {
        this.dataType = DEFAULT_DATA_TYPE;
        this.canBeNull = true;
        this.persisted = true;
        this.maxForeignAutoRefreshLevel = -1;
        this.persisterClass = DEFAULT_PERSISTER_CLASS;
        this.foreignCollectionMaxEagerLevel = 1;
        this.foreignCollectionOrderAscending = true;
        this.fieldName = str;
    }

    public DatabaseFieldConfig(String str, String str2, DataType dataType, String str3, int i2, boolean z, boolean z2, boolean z3, String str4, boolean z4, DatabaseTableConfig<?> databaseTableConfig, boolean z5, Enum<?> r16, boolean z6, String str5, boolean z7, String str6, String str7, boolean z8, int i3, int i4) {
        this.dataType = DEFAULT_DATA_TYPE;
        this.canBeNull = true;
        this.persisted = true;
        this.maxForeignAutoRefreshLevel = -1;
        this.persisterClass = DEFAULT_PERSISTER_CLASS;
        this.foreignCollectionMaxEagerLevel = 1;
        this.foreignCollectionOrderAscending = true;
        this.fieldName = str;
        this.columnName = str2;
        this.dataType = dataType;
        this.defaultValue = str3;
        this.width = i2;
        this.canBeNull = z;
        this.id = z2;
        this.generatedId = z3;
        this.generatedIdSequence = str4;
        this.foreign = z4;
        this.foreignTableConfig = databaseTableConfig;
        this.useGetSet = z5;
        this.unknownEnumValue = r16;
        this.throwIfNull = z6;
        this.format = str5;
        this.unique = z7;
        this.indexName = str6;
        this.uniqueIndexName = str7;
        this.foreignAutoRefresh = z8;
        this.maxForeignAutoRefreshLevel = i3;
        this.foreignCollectionMaxEagerLevel = i4;
    }
}
