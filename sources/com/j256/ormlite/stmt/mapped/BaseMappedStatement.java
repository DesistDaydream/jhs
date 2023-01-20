package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseMappedStatement<T, ID> {
    public static Logger logger = LoggerFactory.getLogger(BaseMappedStatement.class);
    public final FieldType[] argFieldTypes;
    public final Class<T> clazz;
    public final FieldType idField;
    public final String statement;
    public final TableInfo<T, ID> tableInfo;

    public BaseMappedStatement(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr) {
        this.tableInfo = tableInfo;
        this.clazz = tableInfo.getDataClass();
        this.idField = tableInfo.getIdField();
        this.statement = str;
        this.argFieldTypes = fieldTypeArr;
    }

    public static void appendFieldColumnName(DatabaseType databaseType, StringBuilder sb, FieldType fieldType, List<FieldType> list) {
        databaseType.appendEscapedEntityName(sb, fieldType.getColumnName());
        if (list != null) {
            list.add(fieldType);
        }
        sb.append(' ');
    }

    public static void appendTableName(DatabaseType databaseType, StringBuilder sb, String str, String str2) {
        if (str != null) {
            sb.append(str);
        }
        databaseType.appendEscapedEntityName(sb, str2);
        sb.append(' ');
    }

    public static void appendWhereFieldEq(DatabaseType databaseType, FieldType fieldType, StringBuilder sb, List<FieldType> list) {
        sb.append("WHERE ");
        appendFieldColumnName(databaseType, sb, fieldType, list);
        sb.append("= ?");
    }

    public Object convertIdToFieldObject(ID id) throws SQLException {
        return this.idField.convertJavaFieldToSqlArgValue(id);
    }

    public Object[] getFieldObjects(Object obj) throws SQLException {
        Object[] objArr = new Object[this.argFieldTypes.length];
        int i2 = 0;
        while (true) {
            FieldType[] fieldTypeArr = this.argFieldTypes;
            if (i2 >= fieldTypeArr.length) {
                return objArr;
            }
            FieldType fieldType = fieldTypeArr[i2];
            if (fieldType.isAllowGeneratedIdInsert()) {
                objArr[i2] = fieldType.getFieldValueIfNotDefault(obj);
            } else {
                objArr[i2] = fieldType.extractJavaFieldToSqlArgValue(obj);
            }
            if (objArr[i2] == null) {
                objArr[i2] = fieldType.getDefaultValue();
            }
            i2++;
        }
    }

    public String toString() {
        return "MappedStatement: " + this.statement;
    }
}
