package com.moor.imkf.lib.jobqueue.persistentQueue.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.moor.imkf.lib.jobqueue.persistentQueue.sqlite.SqlHelper;

/* loaded from: classes2.dex */
public class Where {
    public final String[] args;
    public final long cacheKey;
    private SQLiteStatement countReadyStmt;
    private String findJobsQuery;
    private SQLiteStatement nextJobDelayUntilStmt;
    private String nextJobQuery;
    public final String query;
    public static final String NEVER = Long.toString(Long.MIN_VALUE);
    public static final String FOREVER = Long.toString(Long.MAX_VALUE);

    public Where(long j2, String str, String[] strArr) {
        this.cacheKey = j2;
        this.query = str;
        this.args = strArr;
    }

    public SQLiteStatement countReady(SQLiteDatabase sQLiteDatabase, StringBuilder sb) {
        SQLiteStatement sQLiteStatement = this.countReadyStmt;
        if (sQLiteStatement == null) {
            sb.setLength(0);
            sb.append("SELECT SUM(case WHEN ");
            SqlHelper.Property property = DbOpenHelper.GROUP_ID_COLUMN;
            sb.append(property.columnName);
            sb.append(" is null then group_cnt else 1 end) from (");
            sb.append("SELECT count(*) group_cnt, ");
            sb.append(property.columnName);
            sb.append(" FROM ");
            sb.append(DbOpenHelper.JOB_HOLDER_TABLE_NAME);
            sb.append(" WHERE ");
            sb.append(this.query);
            sb.append(" GROUP BY ");
            sb.append(property.columnName);
            sb.append(")");
            this.countReadyStmt = sQLiteDatabase.compileStatement(sb.toString());
        } else {
            sQLiteStatement.clearBindings();
        }
        int i2 = 1;
        while (true) {
            String[] strArr = this.args;
            if (i2 <= strArr.length) {
                this.countReadyStmt.bindString(i2, strArr[i2 - 1]);
                i2++;
            } else {
                return this.countReadyStmt;
            }
        }
    }

    public void destroy() {
        SQLiteStatement sQLiteStatement = this.countReadyStmt;
        if (sQLiteStatement != null) {
            sQLiteStatement.close();
            this.countReadyStmt = null;
        }
        SQLiteStatement sQLiteStatement2 = this.nextJobDelayUntilStmt;
        if (sQLiteStatement2 != null) {
            sQLiteStatement2.close();
            this.nextJobDelayUntilStmt = null;
        }
    }

    public String findJobs(SqlHelper sqlHelper) {
        if (this.findJobsQuery == null) {
            this.findJobsQuery = sqlHelper.createSelect(this.query, null, new SqlHelper.Order[0]);
        }
        return this.findJobsQuery;
    }

    public String nextJob(SqlHelper sqlHelper) {
        if (this.nextJobQuery == null) {
            String str = this.query;
            SqlHelper.Property property = DbOpenHelper.CREATED_NS_COLUMN;
            SqlHelper.Order.Type type = SqlHelper.Order.Type.ASC;
            this.nextJobQuery = sqlHelper.createSelect(str, 1, new SqlHelper.Order(DbOpenHelper.PRIORITY_COLUMN, SqlHelper.Order.Type.DESC), new SqlHelper.Order(property, type), new SqlHelper.Order(DbOpenHelper.INSERTION_ORDER_COLUMN, type));
        }
        return this.nextJobQuery;
    }

    public SQLiteStatement nextJobDelayUntil(SQLiteDatabase sQLiteDatabase, SqlHelper sqlHelper) {
        SQLiteStatement sQLiteStatement = this.nextJobDelayUntilStmt;
        if (sQLiteStatement == null) {
            String createSelectOneField = sqlHelper.createSelectOneField(DbOpenHelper.DEADLINE_COLUMN.columnName, this.query, null, new SqlHelper.Order[0]);
            String createSelectOneField2 = sqlHelper.createSelectOneField(DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnName, this.query, null, new SqlHelper.Order[0]);
            StringBuilder sb = sqlHelper.reusedStringBuilder;
            sb.setLength(0);
            sb.append("SELECT * FROM (");
            sb.append(createSelectOneField);
            sb.append(" ORDER BY 1 ASC LIMIT 1");
            sb.append(") UNION SELECT * FROM (");
            sb.append(createSelectOneField2);
            sb.append(" ORDER BY 1 ASC LIMIT 1");
            sb.append(") ORDER BY 1 ASC LIMIT 1");
            this.nextJobDelayUntilStmt = sQLiteDatabase.compileStatement(sb.toString());
        } else {
            sQLiteStatement.clearBindings();
        }
        int i2 = 1;
        while (true) {
            String[] strArr = this.args;
            if (i2 <= strArr.length) {
                int i3 = i2 - 1;
                this.nextJobDelayUntilStmt.bindString(i2, strArr[i3]);
                SQLiteStatement sQLiteStatement2 = this.nextJobDelayUntilStmt;
                String[] strArr2 = this.args;
                sQLiteStatement2.bindString(strArr2.length + i2, strArr2[i3]);
                i2++;
            } else {
                this.nextJobDelayUntilStmt.bindString(1, FOREVER);
                this.nextJobDelayUntilStmt.bindString(this.args.length + 1, NEVER);
                return this.nextJobDelayUntilStmt;
            }
        }
    }
}
