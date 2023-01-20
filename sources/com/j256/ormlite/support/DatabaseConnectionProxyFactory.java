package com.j256.ormlite.support;

import java.sql.SQLException;

/* loaded from: classes2.dex */
public interface DatabaseConnectionProxyFactory {
    DatabaseConnection createProxy(DatabaseConnection databaseConnection) throws SQLException;
}
