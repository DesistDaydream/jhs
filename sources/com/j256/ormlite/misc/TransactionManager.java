package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class TransactionManager {
    private static final String SAVE_POINT_PREFIX = "ORMLITE";
    private static final Logger logger = LoggerFactory.getLogger(TransactionManager.class);
    private static final AtomicInteger savePointCounter = new AtomicInteger();
    private static final ThreadLocal<TransactionLevel> transactionLevelThreadLocal = new ThreadLocal<TransactionLevel>() { // from class: com.j256.ormlite.misc.TransactionManager.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public TransactionLevel initialValue() {
            return new TransactionLevel();
        }
    };
    private ConnectionSource connectionSource;

    /* loaded from: classes2.dex */
    public static class TransactionLevel {
        public int counter;

        private TransactionLevel() {
        }

        public int decrementAndGet() {
            int i2 = this.counter - 1;
            this.counter = i2;
            return i2;
        }

        public int incrementAndGet() {
            int i2 = this.counter + 1;
            this.counter = i2;
            return i2;
        }
    }

    public TransactionManager() {
    }

    private static void commit(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.commit(savepoint);
        if (savepointName == null) {
            logger.trace("committed savePoint transaction");
        } else {
            logger.trace("committed savePoint transaction {}", savepointName);
        }
    }

    private static void release(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.releaseSavePoint(savepoint);
        if (savepointName == null) {
            logger.trace("released savePoint transaction");
        } else {
            logger.trace("released savePoint transaction {}", savepointName);
        }
    }

    private static void rollBack(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.rollback(savepoint);
        if (savepointName == null) {
            logger.trace("rolled back savePoint transaction");
        } else {
            logger.trace("rolled back savePoint transaction {}", savepointName);
        }
    }

    public <T> T callInTransaction(Callable<T> callable) throws SQLException {
        return (T) callInTransaction(this.connectionSource, callable);
    }

    public void initialize() {
        if (this.connectionSource != null) {
            return;
        }
        throw new IllegalStateException("dataSource was not set on " + getClass().getSimpleName());
    }

    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    public TransactionManager(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
        initialize();
    }

    public <T> T callInTransaction(String str, Callable<T> callable) throws SQLException {
        return (T) callInTransaction(str, this.connectionSource, callable);
    }

    public static <T> T callInTransaction(ConnectionSource connectionSource, Callable<T> callable) throws SQLException {
        return (T) callInTransaction((String) null, connectionSource, callable);
    }

    public static <T> T callInTransaction(String str, ConnectionSource connectionSource, Callable<T> callable) throws SQLException {
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection(str);
        try {
            return (T) callInTransaction(readWriteConnection, connectionSource.saveSpecialConnection(readWriteConnection), connectionSource.getDatabaseType(), callable);
        } finally {
            connectionSource.clearSpecialConnection(readWriteConnection);
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public static <T> T callInTransaction(DatabaseConnection databaseConnection, DatabaseType databaseType, Callable<T> callable) throws SQLException {
        return (T) callInTransaction(databaseConnection, false, databaseType, callable);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0071 A[Catch: all -> 0x008c, Exception -> 0x0090, SQLException -> 0x00a6, TryCatch #7 {SQLException -> 0x00a6, Exception -> 0x0090, blocks: (B:22:0x0068, B:24:0x0071, B:26:0x0077, B:27:0x007e), top: B:57:0x0068, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T callInTransaction(com.j256.ormlite.support.DatabaseConnection r8, boolean r9, com.j256.ormlite.db.DatabaseType r10, java.util.concurrent.Callable<T> r11) throws java.sql.SQLException {
        /*
            java.lang.String r0 = "after commit exception, rolling back to save-point also threw exception"
            java.lang.ThreadLocal<com.j256.ormlite.misc.TransactionManager$TransactionLevel> r1 = com.j256.ormlite.misc.TransactionManager.transactionLevelThreadLocal
            java.lang.Object r2 = r1.get()
            com.j256.ormlite.misc.TransactionManager$TransactionLevel r2 = (com.j256.ormlite.misc.TransactionManager.TransactionLevel) r2
            r3 = 0
            java.lang.String r4 = "restored auto-commit to true"
            r5 = 0
            r6 = 1
            if (r9 != 0) goto L1a
            boolean r9 = r10.isNestedSavePointsSupported()     // Catch: java.lang.Throwable -> Lb6
            if (r9 == 0) goto L18
            goto L1a
        L18:
            r9 = 0
            goto L68
        L1a:
            boolean r9 = r8.isAutoCommitSupported()     // Catch: java.lang.Throwable -> Lb6
            if (r9 == 0) goto L36
            boolean r9 = r8.isAutoCommit()     // Catch: java.lang.Throwable -> Lb6
            if (r9 == 0) goto L36
            r8.setAutoCommit(r5)     // Catch: java.lang.Throwable -> Lb6
            com.j256.ormlite.logger.Logger r9 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L32
            java.lang.String r10 = "had to set auto-commit to false"
            r9.trace(r10)     // Catch: java.lang.Throwable -> L32
            r5 = 1
            goto L36
        L32:
            r9 = move-exception
            r5 = 1
            goto Lb7
        L36:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb6
            r9.<init>()     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r10 = "ORMLITE"
            r9.append(r10)     // Catch: java.lang.Throwable -> Lb6
            java.util.concurrent.atomic.AtomicInteger r10 = com.j256.ormlite.misc.TransactionManager.savePointCounter     // Catch: java.lang.Throwable -> Lb6
            int r10 = r10.incrementAndGet()     // Catch: java.lang.Throwable -> Lb6
            r9.append(r10)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lb6
            java.sql.Savepoint r3 = r8.setSavePoint(r9)     // Catch: java.lang.Throwable -> Lb6
            if (r3 != 0) goto L5b
            com.j256.ormlite.logger.Logger r9 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r10 = "started savePoint transaction"
            r9.trace(r10)     // Catch: java.lang.Throwable -> Lb6
            goto L66
        L5b:
            com.j256.ormlite.logger.Logger r9 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r10 = "started savePoint transaction {}"
            java.lang.String r7 = r3.getSavepointName()     // Catch: java.lang.Throwable -> Lb6
            r9.trace(r10, r7)     // Catch: java.lang.Throwable -> Lb6
        L66:
            r9 = r5
            r5 = 1
        L68:
            r2.incrementAndGet()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90 java.sql.SQLException -> La6
            java.lang.Object r10 = r11.call()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90 java.sql.SQLException -> La6
            if (r5 == 0) goto L81
            int r11 = r2.decrementAndGet()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90 java.sql.SQLException -> La6
            if (r11 > 0) goto L7e
            commit(r8, r3)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90 java.sql.SQLException -> La6
            r1.remove()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90 java.sql.SQLException -> La6
            goto L81
        L7e:
            release(r8, r3)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90 java.sql.SQLException -> La6
        L81:
            if (r9 == 0) goto L8b
            r8.setAutoCommit(r6)
            com.j256.ormlite.logger.Logger r8 = com.j256.ormlite.misc.TransactionManager.logger
            r8.trace(r4)
        L8b:
            return r10
        L8c:
            r10 = move-exception
            r5 = r9
            r9 = r10
            goto Lb7
        L90:
            r10 = move-exception
            r2.decrementAndGet()     // Catch: java.lang.Throwable -> L8c
            if (r5 == 0) goto L9f
            rollBack(r8, r3)     // Catch: java.lang.Throwable -> L8c java.sql.SQLException -> L9a
            goto L9f
        L9a:
            com.j256.ormlite.logger.Logger r11 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L8c
            r11.error(r10, r0)     // Catch: java.lang.Throwable -> L8c
        L9f:
            java.lang.String r11 = "Transaction callable threw non-SQL exception"
            java.sql.SQLException r10 = com.j256.ormlite.misc.SqlExceptionUtil.create(r11, r10)     // Catch: java.lang.Throwable -> L8c
            throw r10     // Catch: java.lang.Throwable -> L8c
        La6:
            r10 = move-exception
            r2.decrementAndGet()     // Catch: java.lang.Throwable -> L8c
            if (r5 == 0) goto Lb5
            rollBack(r8, r3)     // Catch: java.lang.Throwable -> L8c java.sql.SQLException -> Lb0
            goto Lb5
        Lb0:
            com.j256.ormlite.logger.Logger r11 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L8c
            r11.error(r10, r0)     // Catch: java.lang.Throwable -> L8c
        Lb5:
            throw r10     // Catch: java.lang.Throwable -> L8c
        Lb6:
            r9 = move-exception
        Lb7:
            if (r5 == 0) goto Lc1
            r8.setAutoCommit(r6)
            com.j256.ormlite.logger.Logger r8 = com.j256.ormlite.misc.TransactionManager.logger
            r8.trace(r4)
        Lc1:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.misc.TransactionManager.callInTransaction(com.j256.ormlite.support.DatabaseConnection, boolean, com.j256.ormlite.db.DatabaseType, java.util.concurrent.Callable):java.lang.Object");
    }
}
