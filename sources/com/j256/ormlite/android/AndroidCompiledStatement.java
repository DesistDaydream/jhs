package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.j256.ormlite.android.compat.ApiCompatibility;
import com.j256.ormlite.android.compat.ApiCompatibilityUtils;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseResults;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AndroidCompiledStatement implements CompiledStatement {
    private List<Object> args;
    private final boolean cacheStore;
    private final boolean cancelQueriesEnabled;
    private ApiCompatibility.CancellationHook cancellationHook;
    private Cursor cursor;
    private final SQLiteDatabase db;
    private Integer max;
    private final String sql;
    private final StatementBuilder.StatementType type;
    private static Logger logger = LoggerFactory.getLogger(AndroidCompiledStatement.class);
    private static final String[] NO_STRING_ARGS = new String[0];
    private static final ApiCompatibility apiCompatibility = ApiCompatibilityUtils.getCompatibility();

    /* renamed from: com.j256.ormlite.android.AndroidCompiledStatement$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        static {
            int[] iArr = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = iArr;
            try {
                iArr[SqlType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public AndroidCompiledStatement(String str, SQLiteDatabase sQLiteDatabase, StatementBuilder.StatementType statementType, boolean z, boolean z2) {
        this.sql = str;
        this.db = sQLiteDatabase;
        this.type = statementType;
        this.cancelQueriesEnabled = z;
        this.cacheStore = z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
        if (r5 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
        com.j256.ormlite.android.AndroidCompiledStatement.logger.trace("executing statement {} changed {} rows: {}", r3, java.lang.Integer.valueOf(r2), r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r5 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
        r5.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int execSql(android.database.sqlite.SQLiteDatabase r2, java.lang.String r3, java.lang.String r4, java.lang.Object[] r5) throws java.sql.SQLException {
        /*
            r2.execSQL(r4, r5)     // Catch: android.database.SQLException -> L2d
            r5 = 0
            java.lang.String r0 = "SELECT CHANGES()"
            android.database.sqlite.SQLiteStatement r5 = r2.compileStatement(r0)     // Catch: java.lang.Throwable -> L15 android.database.SQLException -> L1c
            long r0 = r5.simpleQueryForLong()     // Catch: java.lang.Throwable -> L15 android.database.SQLException -> L1c
            int r2 = (int) r0
            if (r5 == 0) goto L21
        L11:
            r5.close()
            goto L21
        L15:
            r2 = move-exception
            if (r5 == 0) goto L1b
            r5.close()
        L1b:
            throw r2
        L1c:
            r2 = 1
            if (r5 == 0) goto L21
            goto L11
        L21:
            com.j256.ormlite.logger.Logger r5 = com.j256.ormlite.android.AndroidCompiledStatement.logger
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.String r1 = "executing statement {} changed {} rows: {}"
            r5.trace(r1, r3, r0, r4)
            return r2
        L2d:
            r2 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Problems executing "
            r5.append(r0)
            r5.append(r3)
            java.lang.String r3 = " Android statement: "
            r5.append(r3)
            r5.append(r4)
            java.lang.String r3 = r5.toString()
            java.sql.SQLException r2 = com.j256.ormlite.misc.SqlExceptionUtil.create(r3, r2)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidCompiledStatement.execSql(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.Object[]):int");
    }

    private Object[] getArgArray() {
        List<Object> list = this.args;
        if (list == null) {
            return NO_STRING_ARGS;
        }
        return list.toArray(new Object[list.size()]);
    }

    private String[] getStringArray() {
        List<Object> list = this.args;
        if (list == null) {
            return NO_STRING_ARGS;
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    private void isInPrep() throws SQLException {
        if (this.cursor != null) {
            throw new SQLException("Query already run. Cannot add argument values.");
        }
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void cancel() {
        ApiCompatibility.CancellationHook cancellationHook = this.cancellationHook;
        if (cancellationHook != null) {
            cancellationHook.cancel();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Cursor cursor = this.cursor;
        if (cursor != null && !cursor.isClosed()) {
            try {
                this.cursor.close();
            } catch (android.database.SQLException e2) {
                throw new IOException("Problems closing Android cursor", e2);
            }
        }
        this.cancellationHook = null;
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void closeQuietly() {
        Cursor cursor = this.cursor;
        if (cursor != null) {
            cursor.close();
        }
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int getColumnCount() throws SQLException {
        return getCursor().getColumnCount();
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public String getColumnName(int i2) throws SQLException {
        return getCursor().getColumnName(i2);
    }

    public Cursor getCursor() throws SQLException {
        if (this.cursor == null) {
            String str = null;
            try {
                if (this.max == null) {
                    str = this.sql;
                } else {
                    str = this.sql + " LIMIT " + this.max;
                }
                if (this.cancelQueriesEnabled) {
                    this.cancellationHook = apiCompatibility.createCancellationHook();
                }
                Cursor rawQuery = apiCompatibility.rawQuery(this.db, str, getStringArray(), this.cancellationHook);
                this.cursor = rawQuery;
                rawQuery.moveToFirst();
                logger.trace("{}: started rawQuery cursor for: {}", this, str);
            } catch (android.database.SQLException e2) {
                throw SqlExceptionUtil.create("Problems executing Android query: " + str, e2);
            }
        }
        return this.cursor;
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int runExecute() throws SQLException {
        if (this.type.isOkForExecute()) {
            return execSql(this.db, "runExecute", this.sql, getArgArray());
        }
        throw new IllegalArgumentException("Cannot call execute on a " + this.type + " statement");
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public DatabaseResults runQuery(ObjectCache objectCache) throws SQLException {
        if (this.type.isOkForQuery()) {
            return new AndroidDatabaseResults(getCursor(), objectCache, this.cacheStore);
        }
        throw new IllegalArgumentException("Cannot call query on a " + this.type + " statement");
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int runUpdate() throws SQLException {
        String str;
        if (this.type.isOkForUpdate()) {
            if (this.max == null) {
                str = this.sql;
            } else {
                str = this.sql + ExpandableTextView.N + this.max;
            }
            return execSql(this.db, "runUpdate", str, getArgArray());
        }
        throw new IllegalArgumentException("Cannot call update on a " + this.type + " statement");
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setMaxRows(int i2) throws SQLException {
        isInPrep();
        this.max = Integer.valueOf(i2);
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setObject(int i2, Object obj, SqlType sqlType) throws SQLException {
        isInPrep();
        if (this.args == null) {
            this.args = new ArrayList();
        }
        if (obj == null) {
            this.args.add(i2, null);
            return;
        }
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                this.args.add(i2, obj.toString());
                return;
            case 12:
            case 13:
                this.args.add(i2, obj);
                return;
            case 14:
            case 15:
                throw new SQLException("Invalid Android type: " + sqlType);
            default:
                throw new SQLException("Unknown sql argument type: " + sqlType);
        }
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setQueryTimeout(long j2) {
    }

    public String toString() {
        return getClass().getSimpleName() + TIMMentionEditText.TIM_MENTION_TAG + Integer.toHexString(super.hashCode());
    }
}
