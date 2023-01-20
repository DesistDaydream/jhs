package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class MappedDelete<T, ID> extends BaseMappedStatement<T, ID> {
    private MappedDelete(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr) {
        super(tableInfo, str, fieldTypeArr);
    }

    public static <T, ID> MappedDelete<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField != null) {
            StringBuilder sb = new StringBuilder(64);
            BaseMappedStatement.appendTableName(databaseType, sb, "DELETE FROM ", tableInfo.getTableName());
            BaseMappedStatement.appendWhereFieldEq(databaseType, idField, sb, null);
            return new MappedDelete<>(tableInfo, sb.toString(), new FieldType[]{idField});
        }
        throw new SQLException("Cannot delete from " + tableInfo.getDataClass() + " because it doesn't have an id field");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int delete(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        try {
            Object[] fieldObjects = getFieldObjects(t);
            int delete = databaseConnection.delete(this.statement, fieldObjects, this.argFieldTypes);
            BaseMappedStatement.logger.debug("delete data with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(fieldObjects.length), Integer.valueOf(delete));
            if (fieldObjects.length > 0) {
                BaseMappedStatement.logger.trace("delete arguments: {}", (Object) fieldObjects);
            }
            if (delete > 0 && objectCache != 0) {
                objectCache.remove(this.clazz, this.idField.extractJavaFieldToSqlArgValue(t));
            }
            return delete;
        } catch (SQLException e2) {
            throw SqlExceptionUtil.create("Unable to run delete stmt on object " + t + ": " + this.statement, e2);
        }
    }

    public int deleteById(DatabaseConnection databaseConnection, ID id, ObjectCache objectCache) throws SQLException {
        try {
            Object[] objArr = {convertIdToFieldObject(id)};
            int delete = databaseConnection.delete(this.statement, objArr, this.argFieldTypes);
            BaseMappedStatement.logger.debug("delete data with statement '{}' and {} args, changed {} rows", (Object) this.statement, (Object) 1, (Object) Integer.valueOf(delete));
            BaseMappedStatement.logger.trace("delete arguments: {}", (Object) objArr);
            if (delete > 0 && objectCache != null) {
                objectCache.remove(this.clazz, id);
            }
            return delete;
        } catch (SQLException e2) {
            throw SqlExceptionUtil.create("Unable to run deleteById stmt on id " + id + ": " + this.statement, e2);
        }
    }
}
