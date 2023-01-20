package com.j256.ormlite.stmt;

import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public interface PreparedStmt<T> extends GenericRowMapper<T> {
    CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType) throws SQLException;

    CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType, int i2) throws SQLException;

    String getStatement() throws SQLException;

    StatementBuilder.StatementType getType();

    void setArgumentHolderValue(int i2, Object obj) throws SQLException;
}
