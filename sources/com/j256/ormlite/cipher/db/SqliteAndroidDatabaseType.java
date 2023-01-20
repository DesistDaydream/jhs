package com.j256.ormlite.cipher.db;

import com.j256.ormlite.cipher.android.DatabaseTableConfigUtil;
import com.j256.ormlite.db.BaseSqliteDatabaseType;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.field.types.SqlDateStringType;
import com.j256.ormlite.field.types.SqlDateType;
import com.j256.ormlite.field.types.TimeStampStringType;
import com.j256.ormlite.field.types.TimeStampType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class SqliteAndroidDatabaseType extends BaseSqliteDatabaseType {

    /* renamed from: com.j256.ormlite.cipher.db.SqliteAndroidDatabaseType$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        static {
            int[] iArr = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = iArr;
            try {
                iArr[SqlType.DATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.j256.ormlite.db.BaseDatabaseType
    public void appendBooleanType(StringBuilder sb, FieldType fieldType, int i2) {
        appendShortType(sb, fieldType, i2);
    }

    @Override // com.j256.ormlite.db.BaseDatabaseType
    public void appendDateType(StringBuilder sb, FieldType fieldType, int i2) {
        appendStringType(sb, fieldType, i2);
    }

    @Override // com.j256.ormlite.db.BaseDatabaseType, com.j256.ormlite.db.DatabaseType
    public void appendEscapedEntityName(StringBuilder sb, String str) {
        sb.append('`');
        sb.append(str);
        sb.append('`');
    }

    @Override // com.j256.ormlite.db.BaseDatabaseType, com.j256.ormlite.db.DatabaseType
    public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return DatabaseTableConfigUtil.fromClass(connectionSource, cls);
    }

    @Override // com.j256.ormlite.db.BaseDatabaseType, com.j256.ormlite.db.DatabaseType
    public DataPersister getDataPersister(DataPersister dataPersister, FieldType fieldType) {
        if (dataPersister == null) {
            return super.getDataPersister(dataPersister, fieldType);
        }
        if (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()] != 1) {
            return super.getDataPersister(dataPersister, fieldType);
        }
        if (dataPersister instanceof TimeStampType) {
            return TimeStampStringType.getSingleton();
        }
        if (dataPersister instanceof SqlDateType) {
            return SqlDateStringType.getSingleton();
        }
        return DateStringType.getSingleton();
    }

    @Override // com.j256.ormlite.db.DatabaseType
    public String getDatabaseName() {
        return "Android SQLite";
    }

    @Override // com.j256.ormlite.db.BaseDatabaseType
    public String getDriverClassName() {
        return null;
    }

    @Override // com.j256.ormlite.db.BaseDatabaseType, com.j256.ormlite.db.DatabaseType
    public boolean isBatchUseTransaction() {
        return true;
    }

    @Override // com.j256.ormlite.db.DatabaseType
    public boolean isDatabaseUrlThisType(String str, String str2) {
        return true;
    }

    @Override // com.j256.ormlite.db.BaseDatabaseType, com.j256.ormlite.db.DatabaseType
    public boolean isNestedSavePointsSupported() {
        return false;
    }

    @Override // com.j256.ormlite.db.BaseDatabaseType, com.j256.ormlite.db.DatabaseType
    public void loadDriver() {
    }
}
