package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public class MappedPreparedStmt<T, ID> extends BaseMappedQuery<T, ID> implements PreparedQuery<T>, PreparedDelete<T>, PreparedUpdate<T> {
    private final ArgumentHolder[] argHolders;
    private final boolean cacheStore;
    private final Long limit;
    private final StatementBuilder.StatementType type;

    public MappedPreparedStmt(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2, ArgumentHolder[] argumentHolderArr, Long l2, StatementBuilder.StatementType statementType, boolean z) {
        super(tableInfo, str, fieldTypeArr, fieldTypeArr2);
        this.argHolders = argumentHolderArr;
        this.limit = l2;
        this.type = statementType;
        this.cacheStore = z;
    }

    private CompiledStatement assignStatementArguments(CompiledStatement compiledStatement) throws SQLException {
        ArgumentHolder[] argumentHolderArr;
        SqlType sqlType;
        try {
            Long l2 = this.limit;
            if (l2 != null) {
                compiledStatement.setMaxRows(l2.intValue());
            }
            Object[] objArr = null;
            if (BaseMappedStatement.logger.isLevelEnabled(Log.Level.TRACE)) {
                ArgumentHolder[] argumentHolderArr2 = this.argHolders;
                if (argumentHolderArr2.length > 0) {
                    objArr = new Object[argumentHolderArr2.length];
                }
            }
            int i2 = 0;
            while (true) {
                argumentHolderArr = this.argHolders;
                if (i2 >= argumentHolderArr.length) {
                    break;
                }
                Object sqlArgValue = argumentHolderArr[i2].getSqlArgValue();
                FieldType fieldType = this.argFieldTypes[i2];
                if (fieldType == null) {
                    sqlType = this.argHolders[i2].getSqlType();
                } else {
                    sqlType = fieldType.getSqlType();
                }
                compiledStatement.setObject(i2, sqlArgValue, sqlType);
                if (objArr != null) {
                    objArr[i2] = sqlArgValue;
                }
                i2++;
            }
            BaseMappedStatement.logger.debug("prepared statement '{}' with {} args", this.statement, Integer.valueOf(argumentHolderArr.length));
            if (objArr != null) {
                BaseMappedStatement.logger.trace("prepared statement arguments: {}", (Object) objArr);
            }
            return compiledStatement;
        } catch (Throwable th) {
            IOUtils.closeThrowSqlException(compiledStatement, "statement");
            throw th;
        }
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType) throws SQLException {
        return compile(databaseConnection, statementType, -1);
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public String getStatement() {
        return this.statement;
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public StatementBuilder.StatementType getType() {
        return this.type;
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public void setArgumentHolderValue(int i2, Object obj) throws SQLException {
        if (i2 >= 0) {
            ArgumentHolder[] argumentHolderArr = this.argHolders;
            if (argumentHolderArr.length > i2) {
                argumentHolderArr[i2].setValue(obj);
                return;
            }
            throw new SQLException("argument holder index " + i2 + " is not valid, only " + this.argHolders.length + " in statement (index starts at 0)");
        }
        throw new SQLException("argument holder index " + i2 + " must be >= 0");
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType, int i2) throws SQLException {
        if (this.type == statementType) {
            return assignStatementArguments(databaseConnection.compileStatement(this.statement, statementType, this.argFieldTypes, i2, this.cacheStore));
        }
        throw new SQLException("Could not compile this " + this.type + " statement since the caller is expecting a " + statementType + " statement.  Check your QueryBuilder methods.");
    }
}
