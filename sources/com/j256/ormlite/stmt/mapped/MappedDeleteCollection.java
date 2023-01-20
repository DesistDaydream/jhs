package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.Collection;
import k.b.a.a.o.e;

/* loaded from: classes2.dex */
public class MappedDeleteCollection<T, ID> extends BaseMappedStatement<T, ID> {
    private MappedDeleteCollection(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr) {
        super(tableInfo, str, fieldTypeArr);
    }

    private static void appendWhereIds(DatabaseType databaseType, FieldType fieldType, StringBuilder sb, int i2, FieldType[] fieldTypeArr) {
        sb.append("WHERE ");
        databaseType.appendEscapedEntityName(sb, fieldType.getColumnName());
        sb.append(" IN (");
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append(e.a);
            if (fieldTypeArr != null) {
                fieldTypeArr[i3] = fieldType;
            }
        }
        sb.append(") ");
    }

    private static <T, ID> MappedDeleteCollection<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo, int i2) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField != null) {
            StringBuilder sb = new StringBuilder(128);
            BaseMappedStatement.appendTableName(databaseType, sb, "DELETE FROM ", tableInfo.getTableName());
            FieldType[] fieldTypeArr = new FieldType[i2];
            appendWhereIds(databaseType, idField, sb, i2, fieldTypeArr);
            return new MappedDeleteCollection<>(tableInfo, sb.toString(), fieldTypeArr);
        }
        throw new SQLException("Cannot delete " + tableInfo.getDataClass() + " because it doesn't have an id field defined");
    }

    public static <T, ID> int deleteIds(DatabaseType databaseType, TableInfo<T, ID> tableInfo, DatabaseConnection databaseConnection, Collection<ID> collection, ObjectCache objectCache) throws SQLException {
        MappedDeleteCollection build = build(databaseType, tableInfo, collection.size());
        Object[] objArr = new Object[collection.size()];
        FieldType idField = tableInfo.getIdField();
        int i2 = 0;
        for (ID id : collection) {
            objArr[i2] = idField.convertJavaFieldToSqlArgValue(id);
            i2++;
        }
        return updateRows(databaseConnection, tableInfo.getDataClass(), build, objArr, objectCache);
    }

    public static <T, ID> int deleteObjects(DatabaseType databaseType, TableInfo<T, ID> tableInfo, DatabaseConnection databaseConnection, Collection<T> collection, ObjectCache objectCache) throws SQLException {
        MappedDeleteCollection build = build(databaseType, tableInfo, collection.size());
        Object[] objArr = new Object[collection.size()];
        FieldType idField = tableInfo.getIdField();
        int i2 = 0;
        for (T t : collection) {
            objArr[i2] = idField.extractJavaFieldToSqlArgValue(t);
            i2++;
        }
        return updateRows(databaseConnection, tableInfo.getDataClass(), build, objArr, objectCache);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T, ID> int updateRows(DatabaseConnection databaseConnection, Class<T> cls, MappedDeleteCollection<T, ID> mappedDeleteCollection, Object[] objArr, ObjectCache objectCache) throws SQLException {
        try {
            int delete = databaseConnection.delete(mappedDeleteCollection.statement, objArr, mappedDeleteCollection.argFieldTypes);
            if (delete > 0 && objectCache != 0) {
                for (Object obj : objArr) {
                    objectCache.remove(cls, obj);
                }
            }
            BaseMappedStatement.logger.debug("delete-collection with statement '{}' and {} args, changed {} rows", mappedDeleteCollection.statement, Integer.valueOf(objArr.length), Integer.valueOf(delete));
            if (objArr.length > 0) {
                BaseMappedStatement.logger.trace("delete-collection arguments: {}", (Object) objArr);
            }
            return delete;
        } catch (SQLException e2) {
            throw SqlExceptionUtil.create("Unable to run delete collection stmt: " + mappedDeleteCollection.statement, e2);
        }
    }
}
