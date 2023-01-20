package com.moor.imkf.lib.jobqueue.persistentQueue.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.lib.jobqueue.log.JqLog;
import com.xiaomi.mipush.sdk.Constants;
import k.b.a.a.o.e;

/* loaded from: classes2.dex */
public class SqlHelper {
    public String FIND_BY_ID_QUERY;
    public String FIND_BY_TAG_QUERY;
    public String LOAD_ALL_IDS_QUERY;
    public String LOAD_TAGS_QUERY;
    public String RE_ENABLE_PENDING_CANCELLATIONS_QUERY;
    public final int columnCount;
    private SQLiteStatement countStatement;
    public final SQLiteDatabase db;
    private SQLiteStatement deleteJobTagsStatement;
    private SQLiteStatement deleteStatement;
    private SQLiteStatement insertOrReplaceStatement;
    private SQLiteStatement insertStatement;
    private SQLiteStatement insertTagsStatement;
    private SQLiteStatement markAsCancelledStatement;
    private SQLiteStatement onJobFetchedForRunningStatement;
    public final String primaryKeyColumnName;
    public final StringBuilder reusedStringBuilder = new StringBuilder();
    public final long sessionId;
    public final String tableName;
    public final int tagsColumnCount;
    public final String tagsTableName;

    /* loaded from: classes2.dex */
    public static class ForeignKey {
        public final String targetFieldName;
        public final String targetTable;

        public ForeignKey(String str, String str2) {
            this.targetTable = str;
            this.targetFieldName = str2;
        }
    }

    /* loaded from: classes2.dex */
    public static class Order {
        public final Property property;
        public final Type type;

        /* loaded from: classes2.dex */
        public enum Type {
            ASC,
            DESC
        }

        public Order(Property property, Type type) {
            this.property = property;
            this.type = type;
        }
    }

    /* loaded from: classes2.dex */
    public static class Property {
        public final int columnIndex;
        public final String columnName;
        public final ForeignKey foreignKey;
        public final String type;
        public final boolean unique;

        public Property(String str, String str2, int i2) {
            this(str, str2, i2, null, false);
        }

        public Property(String str, String str2, int i2, ForeignKey foreignKey) {
            this(str, str2, i2, foreignKey, false);
        }

        public Property(String str, String str2, int i2, ForeignKey foreignKey, boolean z) {
            this.columnName = str;
            this.type = str2;
            this.columnIndex = i2;
            this.foreignKey = foreignKey;
            this.unique = z;
        }
    }

    public SqlHelper(SQLiteDatabase sQLiteDatabase, String str, String str2, int i2, String str3, int i3, long j2) {
        this.db = sQLiteDatabase;
        this.tableName = str;
        this.columnCount = i2;
        this.primaryKeyColumnName = str2;
        this.sessionId = j2;
        this.tagsColumnCount = i3;
        this.tagsTableName = str3;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" WHERE ");
        Property property = DbOpenHelper.ID_COLUMN;
        sb.append(property.columnName);
        sb.append(" = ?");
        this.FIND_BY_ID_QUERY = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM ");
        sb2.append(str);
        sb2.append(" WHERE ");
        sb2.append(property.columnName);
        sb2.append(" IN ( SELECT ");
        Property property2 = DbOpenHelper.TAGS_JOB_ID_COLUMN;
        sb2.append(property2.columnName);
        sb2.append(" FROM ");
        sb2.append(str3);
        sb2.append(" WHERE ");
        Property property3 = DbOpenHelper.TAGS_NAME_COLUMN;
        sb2.append(property3.columnName);
        sb2.append(" = ?)");
        this.FIND_BY_TAG_QUERY = sb2.toString();
        this.LOAD_ALL_IDS_QUERY = "SELECT " + property.columnName + " FROM " + str;
        this.LOAD_TAGS_QUERY = "SELECT " + property3.columnName + " FROM " + DbOpenHelper.JOB_TAGS_TABLE_NAME + " WHERE " + property2.columnName + " = ?";
        StringBuilder sb3 = new StringBuilder();
        sb3.append("UPDATE ");
        sb3.append(str);
        sb3.append(" SET ");
        sb3.append(DbOpenHelper.CANCELLED_COLUMN.columnName);
        sb3.append(" = 0");
        this.RE_ENABLE_PENDING_CANCELLATIONS_QUERY = sb3.toString();
    }

    public static void addPlaceholdersInto(StringBuilder sb, int i2) {
        if (i2 != 0) {
            sb.append("?");
            for (int i3 = 1; i3 < i2; i3++) {
                sb.append(",?");
            }
            return;
        }
        throw new IllegalArgumentException("cannot create placeholders for 0 items");
    }

    public static String create(String str, Property property, Property... propertyArr) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(str);
        sb.append(" (");
        sb.append(property.columnName);
        sb.append(ExpandableTextView.N);
        sb.append(property.type);
        sb.append("  primary key ");
        for (Property property2 : propertyArr) {
            sb.append(", `");
            sb.append(property2.columnName);
            sb.append("` ");
            sb.append(property2.type);
            if (property2.unique) {
                sb.append(" UNIQUE");
            }
        }
        for (Property property3 : propertyArr) {
            ForeignKey foreignKey = property3.foreignKey;
            if (foreignKey != null) {
                sb.append(", FOREIGN KEY(`");
                sb.append(property3.columnName);
                sb.append("`) REFERENCES ");
                sb.append(foreignKey.targetTable);
                sb.append("(`");
                sb.append(foreignKey.targetFieldName);
                sb.append("`) ON DELETE CASCADE");
            }
        }
        sb.append(" );");
        JqLog.d(sb.toString(), new Object[0]);
        return sb.toString();
    }

    public static String drop(String str) {
        return "DROP TABLE IF EXISTS " + str;
    }

    public String createSelect(String str, Integer num, Order... orderArr) {
        this.reusedStringBuilder.setLength(0);
        this.reusedStringBuilder.append("SELECT * FROM ");
        this.reusedStringBuilder.append(this.tableName);
        if (str != null) {
            StringBuilder sb = this.reusedStringBuilder;
            sb.append(" WHERE ");
            sb.append(str);
        }
        int length = orderArr.length;
        boolean z = true;
        int i2 = 0;
        while (i2 < length) {
            Order order = orderArr[i2];
            if (z) {
                this.reusedStringBuilder.append(" ORDER BY ");
            } else {
                this.reusedStringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            StringBuilder sb2 = this.reusedStringBuilder;
            sb2.append(order.property.columnName);
            sb2.append(ExpandableTextView.N);
            sb2.append(order.type);
            i2++;
            z = false;
        }
        if (num != null) {
            StringBuilder sb3 = this.reusedStringBuilder;
            sb3.append(" LIMIT ");
            sb3.append(num);
        }
        return this.reusedStringBuilder.toString();
    }

    public String createSelectOneField(String str, String str2, Integer num, Order... orderArr) {
        this.reusedStringBuilder.setLength(0);
        StringBuilder sb = this.reusedStringBuilder;
        sb.append("SELECT ");
        sb.append(str);
        sb.append(" FROM ");
        sb.append(this.tableName);
        if (str2 != null) {
            StringBuilder sb2 = this.reusedStringBuilder;
            sb2.append(" WHERE ");
            sb2.append(str2);
        }
        int length = orderArr.length;
        boolean z = true;
        int i2 = 0;
        while (i2 < length) {
            Order order = orderArr[i2];
            if (z) {
                this.reusedStringBuilder.append(" ORDER BY ");
            } else {
                this.reusedStringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            StringBuilder sb3 = this.reusedStringBuilder;
            sb3.append(order.property.columnName);
            sb3.append(ExpandableTextView.N);
            sb3.append(order.type);
            i2++;
            z = false;
        }
        if (num != null) {
            StringBuilder sb4 = this.reusedStringBuilder;
            sb4.append(" LIMIT ");
            sb4.append(num);
        }
        return this.reusedStringBuilder.toString();
    }

    public SQLiteStatement getCountStatement() {
        if (this.countStatement == null) {
            SQLiteDatabase sQLiteDatabase = this.db;
            this.countStatement = sQLiteDatabase.compileStatement("SELECT COUNT(*) FROM " + this.tableName + " WHERE " + DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnName + " != ?");
        }
        return this.countStatement;
    }

    public SQLiteStatement getDeleteJobTagsStatement() {
        if (this.deleteJobTagsStatement == null) {
            SQLiteDatabase sQLiteDatabase = this.db;
            this.deleteJobTagsStatement = sQLiteDatabase.compileStatement("DELETE FROM " + this.tagsTableName + " WHERE " + DbOpenHelper.TAGS_JOB_ID_COLUMN.columnName + "= ?");
        }
        return this.deleteJobTagsStatement;
    }

    public SQLiteStatement getDeleteStatement() {
        if (this.deleteStatement == null) {
            SQLiteDatabase sQLiteDatabase = this.db;
            this.deleteStatement = sQLiteDatabase.compileStatement("DELETE FROM " + this.tableName + " WHERE " + this.primaryKeyColumnName + " = ?");
        }
        return this.deleteStatement;
    }

    public SQLiteStatement getInsertOrReplaceStatement() {
        if (this.insertOrReplaceStatement == null) {
            this.reusedStringBuilder.setLength(0);
            StringBuilder sb = this.reusedStringBuilder;
            sb.append("INSERT OR REPLACE INTO ");
            sb.append(this.tableName);
            this.reusedStringBuilder.append(" VALUES (");
            for (int i2 = 0; i2 < this.columnCount; i2++) {
                if (i2 != 0) {
                    this.reusedStringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.reusedStringBuilder.append("?");
            }
            this.reusedStringBuilder.append(")");
            this.insertOrReplaceStatement = this.db.compileStatement(this.reusedStringBuilder.toString());
        }
        return this.insertOrReplaceStatement;
    }

    public SQLiteStatement getInsertStatement() {
        if (this.insertStatement == null) {
            this.reusedStringBuilder.setLength(0);
            StringBuilder sb = this.reusedStringBuilder;
            sb.append("INSERT INTO ");
            sb.append(this.tableName);
            this.reusedStringBuilder.append(" VALUES (");
            for (int i2 = 0; i2 < this.columnCount; i2++) {
                if (i2 != 0) {
                    this.reusedStringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.reusedStringBuilder.append("?");
            }
            this.reusedStringBuilder.append(")");
            this.insertStatement = this.db.compileStatement(this.reusedStringBuilder.toString());
        }
        return this.insertStatement;
    }

    public SQLiteStatement getInsertTagsStatement() {
        if (this.insertTagsStatement == null) {
            this.reusedStringBuilder.setLength(0);
            StringBuilder sb = this.reusedStringBuilder;
            sb.append("INSERT INTO ");
            sb.append(DbOpenHelper.JOB_TAGS_TABLE_NAME);
            this.reusedStringBuilder.append(" VALUES (");
            for (int i2 = 0; i2 < this.tagsColumnCount; i2++) {
                if (i2 != 0) {
                    this.reusedStringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.reusedStringBuilder.append("?");
            }
            this.reusedStringBuilder.append(")");
            this.insertTagsStatement = this.db.compileStatement(this.reusedStringBuilder.toString());
        }
        return this.insertTagsStatement;
    }

    public SQLiteStatement getMarkAsCancelledStatement() {
        if (this.markAsCancelledStatement == null) {
            this.markAsCancelledStatement = this.db.compileStatement("UPDATE " + this.tableName + " SET " + DbOpenHelper.CANCELLED_COLUMN.columnName + " = 1  WHERE " + this.primaryKeyColumnName + " = ? ");
        }
        return this.markAsCancelledStatement;
    }

    public SQLiteStatement getOnJobFetchedForRunningStatement() {
        if (this.onJobFetchedForRunningStatement == null) {
            this.onJobFetchedForRunningStatement = this.db.compileStatement("UPDATE " + this.tableName + " SET " + DbOpenHelper.RUN_COUNT_COLUMN.columnName + " = ? , " + DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnName + " = ?  WHERE " + this.primaryKeyColumnName + " = ? ");
        }
        return this.onJobFetchedForRunningStatement;
    }

    public void resetDelayTimesTo(long j2) {
        SQLiteDatabase sQLiteDatabase = this.db;
        sQLiteDatabase.execSQL("UPDATE job_holder SET " + DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnName + e.f16243c, new Object[]{Long.valueOf(j2)});
    }

    public void truncate() {
        this.db.execSQL("DELETE FROM job_holder");
        this.db.execSQL("DELETE FROM job_holder_tags");
        vacuum();
    }

    public void vacuum() {
        this.db.execSQL("VACUUM");
    }
}
