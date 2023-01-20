package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import k.b.a.a.o.e;

/* loaded from: classes2.dex */
public class MappedCreate<T, ID> extends BaseMappedStatement<T, ID> {
    private String dataClassName;
    private final String queryNextSequenceStmt;
    private int versionFieldTypeIndex;

    /* loaded from: classes2.dex */
    public static class KeyHolder implements GeneratedKeyHolder {
        public Number key;

        private KeyHolder() {
        }

        @Override // com.j256.ormlite.support.GeneratedKeyHolder
        public void addKey(Number number) throws SQLException {
            if (this.key == null) {
                this.key = number;
                return;
            }
            throw new SQLException("generated key has already been set to " + this.key + ", now set to " + number);
        }

        public Number getKey() {
            return this.key;
        }
    }

    private MappedCreate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, String str2, int i2) {
        super(tableInfo, str, fieldTypeArr);
        this.dataClassName = tableInfo.getDataClass().getSimpleName();
        this.queryNextSequenceStmt = str2;
        this.versionFieldTypeIndex = i2;
    }

    private void assignIdValue(T t, Number number, String str, ObjectCache objectCache) throws SQLException {
        this.idField.assignIdValue(t, number, objectCache);
        if (BaseMappedStatement.logger.isLevelEnabled(Log.Level.DEBUG)) {
            BaseMappedStatement.logger.debug("assigned id '{}' from {} to '{}' in {} object", new Object[]{number, str, this.idField.getFieldName(), this.dataClassName});
        }
    }

    private void assignSequenceId(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        long queryForLong = databaseConnection.queryForLong(this.queryNextSequenceStmt);
        BaseMappedStatement.logger.debug("queried for sequence {} using stmt: {}", Long.valueOf(queryForLong), this.queryNextSequenceStmt);
        if (queryForLong != 0) {
            assignIdValue(t, Long.valueOf(queryForLong), "sequence", objectCache);
            return;
        }
        throw new SQLException("Should not have returned 0 for stmt: " + this.queryNextSequenceStmt);
    }

    public static <T, ID> MappedCreate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) {
        FieldType[] fieldTypes;
        FieldType[] fieldTypes2;
        StringBuilder sb = new StringBuilder(128);
        BaseMappedStatement.appendTableName(databaseType, sb, "INSERT INTO ", tableInfo.getTableName());
        int i2 = 0;
        int i3 = -1;
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (isFieldCreatable(databaseType, fieldType)) {
                if (fieldType.isVersion()) {
                    i3 = i2;
                }
                i2++;
            }
        }
        FieldType[] fieldTypeArr = new FieldType[i2];
        if (i2 == 0) {
            databaseType.appendInsertNoColumns(sb);
        } else {
            sb.append('(');
            boolean z = true;
            boolean z2 = true;
            int i4 = 0;
            for (FieldType fieldType2 : tableInfo.getFieldTypes()) {
                if (isFieldCreatable(databaseType, fieldType2)) {
                    if (z2) {
                        z2 = false;
                    } else {
                        sb.append(',');
                    }
                    BaseMappedStatement.appendFieldColumnName(databaseType, sb, fieldType2, null);
                    fieldTypeArr[i4] = fieldType2;
                    i4++;
                }
            }
            sb.append(") VALUES (");
            for (FieldType fieldType3 : tableInfo.getFieldTypes()) {
                if (isFieldCreatable(databaseType, fieldType3)) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append(e.a);
                }
            }
            sb.append(')');
        }
        return new MappedCreate<>(tableInfo, sb.toString(), fieldTypeArr, buildQueryNextSequence(databaseType, tableInfo.getIdField()), i3);
    }

    private static String buildQueryNextSequence(DatabaseType databaseType, FieldType fieldType) {
        String generatedIdSequence;
        if (fieldType == null || (generatedIdSequence = fieldType.getGeneratedIdSequence()) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(64);
        databaseType.appendSelectNextValFromSequence(sb, generatedIdSequence);
        return sb.toString();
    }

    private boolean foreignCollectionsAreAssigned(FieldType[] fieldTypeArr, Object obj) throws SQLException {
        for (FieldType fieldType : fieldTypeArr) {
            if (fieldType.extractJavaFieldValue(obj) == null) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFieldCreatable(DatabaseType databaseType, FieldType fieldType) {
        if (fieldType.isForeignCollection() || fieldType.isReadOnly()) {
            return false;
        }
        return (databaseType.isIdSequenceNeeded() && databaseType.isSelectSequenceBeforeInsert()) || !fieldType.isGeneratedId() || fieldType.isSelfGeneratedId() || fieldType.isAllowGeneratedIdInsert();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062 A[Catch: SQLException -> 0x0132, TryCatch #0 {SQLException -> 0x0132, blocks: (B:27:0x005a, B:29:0x0062, B:31:0x006c, B:39:0x0088, B:34:0x0075, B:36:0x007b, B:38:0x0085, B:40:0x008b, B:42:0x0093, B:44:0x0097, B:48:0x00b1, B:50:0x00c6, B:53:0x00cf, B:55:0x00da, B:57:0x00e0, B:59:0x00ea, B:60:0x00f0, B:61:0x00f7, B:62:0x00f8, B:63:0x00ff, B:65:0x0102, B:67:0x010e, B:70:0x011b, B:72:0x012c, B:73:0x0131, B:47:0x00a9), top: B:77:0x005a, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6 A[Catch: SQLException -> 0x0132, TryCatch #0 {SQLException -> 0x0132, blocks: (B:27:0x005a, B:29:0x0062, B:31:0x006c, B:39:0x0088, B:34:0x0075, B:36:0x007b, B:38:0x0085, B:40:0x008b, B:42:0x0093, B:44:0x0097, B:48:0x00b1, B:50:0x00c6, B:53:0x00cf, B:55:0x00da, B:57:0x00e0, B:59:0x00ea, B:60:0x00f0, B:61:0x00f7, B:62:0x00f8, B:63:0x00ff, B:65:0x0102, B:67:0x010e, B:70:0x011b, B:72:0x012c, B:73:0x0131, B:47:0x00a9), top: B:77:0x005a, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int insert(com.j256.ormlite.db.DatabaseType r11, com.j256.ormlite.support.DatabaseConnection r12, T r13, com.j256.ormlite.dao.ObjectCache r14) throws java.sql.SQLException {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.mapped.MappedCreate.insert(com.j256.ormlite.db.DatabaseType, com.j256.ormlite.support.DatabaseConnection, java.lang.Object, com.j256.ormlite.dao.ObjectCache):int");
    }
}
