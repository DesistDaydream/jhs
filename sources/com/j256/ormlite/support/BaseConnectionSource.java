package com.j256.ormlite.support;

import com.j256.ormlite.logger.Logger;
import java.sql.SQLException;

/* loaded from: classes2.dex */
public abstract class BaseConnectionSource implements ConnectionSource {
    private ThreadLocal<NestedConnection> specialConnection = new ThreadLocal<>();

    /* loaded from: classes2.dex */
    public static class NestedConnection {
        public final DatabaseConnection connection;
        private int nestedC = 1;

        public NestedConnection(DatabaseConnection databaseConnection) {
            this.connection = databaseConnection;
        }

        public int decrementAndGet() {
            int i2 = this.nestedC - 1;
            this.nestedC = i2;
            return i2;
        }

        public void increment() {
            this.nestedC++;
        }
    }

    public boolean clearSpecial(DatabaseConnection databaseConnection, Logger logger) {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (databaseConnection != null) {
            if (nestedConnection == null) {
                logger.error("no connection has been saved when clear() called");
            } else {
                DatabaseConnection databaseConnection2 = nestedConnection.connection;
                if (databaseConnection2 == databaseConnection) {
                    if (nestedConnection.decrementAndGet() == 0) {
                        this.specialConnection.set(null);
                    }
                    return true;
                }
                logger.error("connection saved {} is not the one being cleared {}", databaseConnection2, databaseConnection);
            }
        }
        return false;
    }

    public DatabaseConnection getSavedConnection() {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            return null;
        }
        return nestedConnection.connection;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public DatabaseConnection getSpecialConnection(String str) {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            return null;
        }
        return nestedConnection.connection;
    }

    public boolean isSavedConnection(DatabaseConnection databaseConnection) {
        NestedConnection nestedConnection = this.specialConnection.get();
        return nestedConnection != null && nestedConnection.connection == databaseConnection;
    }

    public boolean isSingleConnection(DatabaseConnection databaseConnection, DatabaseConnection databaseConnection2) throws SQLException {
        databaseConnection.setAutoCommit(true);
        databaseConnection2.setAutoCommit(true);
        try {
            databaseConnection.setAutoCommit(false);
            return !databaseConnection2.isAutoCommit();
        } finally {
            databaseConnection.setAutoCommit(true);
        }
    }

    public boolean saveSpecial(DatabaseConnection databaseConnection) throws SQLException {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            this.specialConnection.set(new NestedConnection(databaseConnection));
            return true;
        } else if (nestedConnection.connection == databaseConnection) {
            nestedConnection.increment();
            return false;
        } else {
            throw new SQLException("trying to save connection " + databaseConnection + " but already have saved connection " + nestedConnection.connection);
        }
    }
}
