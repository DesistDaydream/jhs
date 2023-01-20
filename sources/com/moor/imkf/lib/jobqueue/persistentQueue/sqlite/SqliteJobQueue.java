package com.moor.imkf.lib.jobqueue.persistentQueue.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteStatement;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.lib.jobqueue.base.Constraint;
import com.moor.imkf.lib.jobqueue.base.Job;
import com.moor.imkf.lib.jobqueue.base.JobHolder;
import com.moor.imkf.lib.jobqueue.base.JobQueue;
import com.moor.imkf.lib.jobqueue.config.Configuration;
import com.moor.imkf.lib.jobqueue.log.JqLog;
import com.moor.imkf.lib.jobqueue.persistentQueue.sqlite.SqlHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class SqliteJobQueue implements JobQueue {
    private SQLiteDatabase db;
    private DbOpenHelper dbOpenHelper;
    private JobSerializer jobSerializer;
    private FileStorage jobStorage;
    private final StringBuilder reusedStringBuilder = new StringBuilder();
    private final long sessionId;
    private SqlHelper sqlHelper;
    private final WhereQueryCache whereQueryCache;

    /* loaded from: classes2.dex */
    public static class InvalidJobException extends Exception {
        public InvalidJobException(String str) {
            super(str);
        }

        public InvalidJobException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes2.dex */
    public static class JavaSerializer implements JobSerializer {
        @Override // com.moor.imkf.lib.jobqueue.persistentQueue.sqlite.SqliteJobQueue.JobSerializer
        public <T extends Job> T deserialize(byte[] bArr) throws IOException, ClassNotFoundException {
            ObjectInputStream objectInputStream;
            ObjectInputStream objectInputStream2 = null;
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            } catch (Throwable th) {
                th = th;
            }
            try {
                T t = (T) objectInputStream.readObject();
                objectInputStream.close();
                return t;
            } catch (Throwable th2) {
                th = th2;
                objectInputStream2 = objectInputStream;
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                }
                throw th;
            }
        }

        @Override // com.moor.imkf.lib.jobqueue.persistentQueue.sqlite.SqliteJobQueue.JobSerializer
        public byte[] serialize(Object obj) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream;
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            if (obj == null) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
            try {
                new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                throw th;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface JobSerializer {
        <T extends Job> T deserialize(byte[] bArr) throws IOException, ClassNotFoundException;

        byte[] serialize(Object obj) throws IOException;
    }

    public SqliteJobQueue(Configuration configuration, long j2, JobSerializer jobSerializer) {
        String str;
        this.sessionId = j2;
        this.jobStorage = new FileStorage(configuration.getAppContext(), "jobs_" + configuration.getId());
        this.whereQueryCache = new WhereQueryCache(j2);
        Context appContext = configuration.getAppContext();
        if (configuration.isInTestMode()) {
            str = null;
        } else {
            str = "db_" + configuration.getId();
        }
        DbOpenHelper dbOpenHelper = new DbOpenHelper(appContext, str);
        this.dbOpenHelper = dbOpenHelper;
        SQLiteDatabase writableDatabase = dbOpenHelper.getWritableDatabase();
        this.db = writableDatabase;
        this.sqlHelper = new SqlHelper(writableDatabase, DbOpenHelper.JOB_HOLDER_TABLE_NAME, DbOpenHelper.ID_COLUMN.columnName, 12, DbOpenHelper.JOB_TAGS_TABLE_NAME, 3, j2);
        this.jobSerializer = jobSerializer;
        if (configuration.resetDelaysOnRestart()) {
            this.sqlHelper.resetDelayTimesTo(Long.MIN_VALUE);
        }
        reEnablePendingCancellations();
        cleanupFiles();
    }

    private void bindTag(SQLiteStatement sQLiteStatement, String str, String str2) {
        sQLiteStatement.bindString(DbOpenHelper.TAGS_JOB_ID_COLUMN.columnIndex + 1, str);
        sQLiteStatement.bindString(DbOpenHelper.TAGS_NAME_COLUMN.columnIndex + 1, str2);
    }

    private void bindValues(SQLiteStatement sQLiteStatement, JobHolder jobHolder) {
        if (jobHolder.getInsertionOrder() != null) {
            sQLiteStatement.bindLong(DbOpenHelper.INSERTION_ORDER_COLUMN.columnIndex + 1, jobHolder.getInsertionOrder().longValue());
        }
        sQLiteStatement.bindString(DbOpenHelper.ID_COLUMN.columnIndex + 1, jobHolder.getId());
        sQLiteStatement.bindLong(DbOpenHelper.PRIORITY_COLUMN.columnIndex + 1, jobHolder.getPriority());
        if (jobHolder.getGroupId() != null) {
            sQLiteStatement.bindString(DbOpenHelper.GROUP_ID_COLUMN.columnIndex + 1, jobHolder.getGroupId());
        }
        sQLiteStatement.bindLong(DbOpenHelper.RUN_COUNT_COLUMN.columnIndex + 1, jobHolder.getRunCount());
        sQLiteStatement.bindLong(DbOpenHelper.CREATED_NS_COLUMN.columnIndex + 1, jobHolder.getCreatedNs());
        sQLiteStatement.bindLong(DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnIndex + 1, jobHolder.getDelayUntilNs());
        sQLiteStatement.bindLong(DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnIndex + 1, jobHolder.getRunningSessionId());
        sQLiteStatement.bindLong(DbOpenHelper.REQUIRED_NETWORK_TYPE_COLUMN.columnIndex + 1, jobHolder.getRequiredNetworkType());
        sQLiteStatement.bindLong(DbOpenHelper.DEADLINE_COLUMN.columnIndex + 1, jobHolder.getDeadlineNs());
        sQLiteStatement.bindLong(DbOpenHelper.CANCEL_ON_DEADLINE_COLUMN.columnIndex + 1, jobHolder.shouldCancelOnDeadline() ? 1L : 0L);
        sQLiteStatement.bindLong(DbOpenHelper.CANCELLED_COLUMN.columnIndex + 1, jobHolder.isCancelled() ? 1L : 0L);
    }

    private void cleanupFiles() {
        Cursor rawQuery = this.db.rawQuery(this.sqlHelper.LOAD_ALL_IDS_QUERY, null);
        HashSet hashSet = new HashSet();
        while (rawQuery.moveToNext()) {
            try {
                hashSet.add(rawQuery.getString(0));
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }
        rawQuery.close();
        this.jobStorage.truncateExcept(hashSet);
    }

    private JobHolder createJobHolderFromCursor(Cursor cursor) throws InvalidJobException {
        String string = cursor.getString(DbOpenHelper.ID_COLUMN.columnIndex);
        try {
            Job safeDeserialize = safeDeserialize(this.jobStorage.load(string));
            if (safeDeserialize != null) {
                return new JobHolder.Builder().insertionOrder(cursor.getLong(DbOpenHelper.INSERTION_ORDER_COLUMN.columnIndex)).priority(cursor.getInt(DbOpenHelper.PRIORITY_COLUMN.columnIndex)).groupId(cursor.getString(DbOpenHelper.GROUP_ID_COLUMN.columnIndex)).runCount(cursor.getInt(DbOpenHelper.RUN_COUNT_COLUMN.columnIndex)).job(safeDeserialize).id(string).tags(loadTags(string)).persistent(true).deadline(cursor.getLong(DbOpenHelper.DEADLINE_COLUMN.columnIndex), cursor.getInt(DbOpenHelper.CANCEL_ON_DEADLINE_COLUMN.columnIndex) == 1).createdNs(cursor.getLong(DbOpenHelper.CREATED_NS_COLUMN.columnIndex)).delayUntilNs(cursor.getLong(DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnIndex)).runningSessionId(cursor.getLong(DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnIndex)).requiredNetworkType(cursor.getInt(DbOpenHelper.REQUIRED_NETWORK_TYPE_COLUMN.columnIndex)).build();
            }
            throw new InvalidJobException("null job");
        } catch (IOException e2) {
            throw new InvalidJobException("cannot load job from disk", e2);
        }
    }

    private Where createWhere(Constraint constraint) {
        return this.whereQueryCache.build(constraint, this.reusedStringBuilder);
    }

    private void delete(String str) {
        this.db.beginTransaction();
        try {
            SQLiteStatement deleteStatement = this.sqlHelper.getDeleteStatement();
            deleteStatement.clearBindings();
            deleteStatement.bindString(1, str);
            deleteStatement.execute();
            SQLiteStatement deleteJobTagsStatement = this.sqlHelper.getDeleteJobTagsStatement();
            deleteJobTagsStatement.bindString(1, str);
            deleteJobTagsStatement.execute();
            this.db.setTransactionSuccessful();
            this.jobStorage.delete(str);
        } finally {
            this.db.endTransaction();
        }
    }

    private boolean insertWithTags(JobHolder jobHolder) {
        SQLiteStatement insertStatement = this.sqlHelper.getInsertStatement();
        SQLiteStatement insertTagsStatement = this.sqlHelper.getInsertTagsStatement();
        this.db.beginTransaction();
        try {
            insertStatement.clearBindings();
            bindValues(insertStatement, jobHolder);
            if (insertStatement.executeInsert() != -1) {
                for (String str : jobHolder.getTags()) {
                    insertTagsStatement.clearBindings();
                    bindTag(insertTagsStatement, jobHolder.getId(), str);
                    insertTagsStatement.executeInsert();
                }
                this.db.setTransactionSuccessful();
                return true;
            }
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }

    private Set<String> loadTags(String str) {
        Cursor rawQuery = this.db.rawQuery(this.sqlHelper.LOAD_TAGS_QUERY, new String[]{str});
        try {
            if (rawQuery.getCount() == 0) {
                return Collections.EMPTY_SET;
            }
            HashSet hashSet = new HashSet();
            while (rawQuery.moveToNext()) {
                hashSet.add(rawQuery.getString(0));
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    private void persistJobToDisk(@NonNull JobHolder jobHolder) {
        try {
            this.jobStorage.save(jobHolder.getId(), this.jobSerializer.serialize(jobHolder.getJob()));
        } catch (IOException e2) {
            throw new RuntimeException("cannot save job to disk", e2);
        }
    }

    private void reEnablePendingCancellations() {
        this.db.execSQL(this.sqlHelper.RE_ENABLE_PENDING_CANCELLATIONS_QUERY);
    }

    private Job safeDeserialize(byte[] bArr) {
        try {
            return this.jobSerializer.deserialize(bArr);
        } catch (Throwable th) {
            JqLog.e(th, "error while deserializing job", new Object[0]);
            return null;
        }
    }

    private void setSessionIdOnJob(JobHolder jobHolder) {
        SQLiteStatement onJobFetchedForRunningStatement = this.sqlHelper.getOnJobFetchedForRunningStatement();
        jobHolder.setRunCount(jobHolder.getRunCount() + 1);
        jobHolder.setRunningSessionId(this.sessionId);
        onJobFetchedForRunningStatement.clearBindings();
        onJobFetchedForRunningStatement.bindLong(1, jobHolder.getRunCount());
        onJobFetchedForRunningStatement.bindLong(2, this.sessionId);
        onJobFetchedForRunningStatement.bindString(3, jobHolder.getId());
        onJobFetchedForRunningStatement.execute();
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void clear() {
        this.sqlHelper.truncate();
        cleanupFiles();
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public int count() {
        SQLiteStatement countStatement = this.sqlHelper.getCountStatement();
        countStatement.clearBindings();
        countStatement.bindLong(1, this.sessionId);
        return (int) countStatement.simpleQueryForLong();
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public int countReadyJobs(@NonNull Constraint constraint) {
        return (int) createWhere(constraint).countReady(this.db, this.reusedStringBuilder).simpleQueryForLong();
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public JobHolder findJobById(@NonNull String str) {
        Cursor rawQuery = this.db.rawQuery(this.sqlHelper.FIND_BY_ID_QUERY, new String[]{str});
        try {
            if (rawQuery.moveToFirst()) {
                return createJobHolderFromCursor(rawQuery);
            }
            return null;
        } catch (InvalidJobException e2) {
            JqLog.e(e2, "invalid job on findJobById", new Object[0]);
            return null;
        } finally {
            rawQuery.close();
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    @NonNull
    public Set<JobHolder> findJobs(@NonNull Constraint constraint) {
        Where createWhere = createWhere(constraint);
        Cursor rawQuery = this.db.rawQuery(createWhere.findJobs(this.sqlHelper), createWhere.args);
        HashSet hashSet = new HashSet();
        while (rawQuery.moveToNext()) {
            try {
                try {
                    hashSet.add(createJobHolderFromCursor(rawQuery));
                } catch (InvalidJobException e2) {
                    JqLog.e(e2, "invalid job found by tags.", new Object[0]);
                }
            } finally {
                rawQuery.close();
            }
        }
        return hashSet;
    }

    @VisibleForTesting
    public SQLiteDatabase getDb() {
        return this.db;
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public Long getNextJobDelayUntilNs(@NonNull Constraint constraint) {
        try {
            long simpleQueryForLong = createWhere(constraint).nextJobDelayUntil(this.db, this.sqlHelper).simpleQueryForLong();
            if (simpleQueryForLong == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(simpleQueryForLong);
        } catch (SQLiteDoneException unused) {
            return null;
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public boolean insert(@NonNull JobHolder jobHolder) {
        persistJobToDisk(jobHolder);
        if (jobHolder.hasTags()) {
            return insertWithTags(jobHolder);
        }
        SQLiteStatement insertStatement = this.sqlHelper.getInsertStatement();
        insertStatement.clearBindings();
        bindValues(insertStatement, jobHolder);
        long executeInsert = insertStatement.executeInsert();
        jobHolder.setInsertionOrder(executeInsert);
        return executeInsert != -1;
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public boolean insertOrReplace(@NonNull JobHolder jobHolder) {
        if (jobHolder.getInsertionOrder() == null) {
            return insert(jobHolder);
        }
        persistJobToDisk(jobHolder);
        jobHolder.setRunningSessionId(Long.MIN_VALUE);
        SQLiteStatement insertOrReplaceStatement = this.sqlHelper.getInsertOrReplaceStatement();
        insertOrReplaceStatement.clearBindings();
        bindValues(insertOrReplaceStatement, jobHolder);
        boolean z = insertOrReplaceStatement.executeInsert() != -1;
        JqLog.d("reinsert job result %s", Boolean.valueOf(z));
        return z;
    }

    public String logJobs() {
        StringBuilder sb = new StringBuilder();
        SqlHelper sqlHelper = this.sqlHelper;
        SqlHelper.Property property = DbOpenHelper.CREATED_NS_COLUMN;
        SqlHelper.Order.Type type = SqlHelper.Order.Type.ASC;
        Cursor rawQuery = this.db.rawQuery(sqlHelper.createSelect(null, 100, new SqlHelper.Order(DbOpenHelper.PRIORITY_COLUMN, SqlHelper.Order.Type.DESC), new SqlHelper.Order(property, type), new SqlHelper.Order(DbOpenHelper.INSERTION_ORDER_COLUMN, type)), new String[0]);
        while (rawQuery.moveToNext()) {
            try {
                String string = rawQuery.getString(DbOpenHelper.ID_COLUMN.columnIndex);
                sb.append(rawQuery.getLong(DbOpenHelper.INSERTION_ORDER_COLUMN.columnIndex));
                sb.append(ExpandableTextView.N);
                sb.append(string);
                sb.append(" id:");
                sb.append(rawQuery.getString(DbOpenHelper.GROUP_ID_COLUMN.columnIndex));
                sb.append(" deadline:");
                sb.append(rawQuery.getLong(DbOpenHelper.DEADLINE_COLUMN.columnIndex));
                sb.append(" cancelled:");
                sb.append(rawQuery.getInt(DbOpenHelper.CANCELLED_COLUMN.columnIndex) == 1);
                sb.append(" delay until:");
                sb.append(rawQuery.getLong(DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnIndex));
                sb.append(" sessionId:");
                sb.append(rawQuery.getLong(DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnIndex));
                sb.append(" reqNetworkType:");
                sb.append(rawQuery.getLong(DbOpenHelper.REQUIRED_NETWORK_TYPE_COLUMN.columnIndex));
                SQLiteDatabase sQLiteDatabase = this.db;
                Cursor rawQuery2 = sQLiteDatabase.rawQuery("SELECT " + DbOpenHelper.TAGS_NAME_COLUMN.columnName + " FROM " + DbOpenHelper.JOB_TAGS_TABLE_NAME + " WHERE " + DbOpenHelper.TAGS_JOB_ID_COLUMN.columnName + " = ?", new String[]{string});
                while (rawQuery2.moveToNext()) {
                    sb.append(", ");
                    sb.append(rawQuery2.getString(0));
                }
                rawQuery2.close();
                sb.append("\n");
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }
        rawQuery.close();
        return sb.toString();
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public JobHolder nextJobAndIncRunCount(@NonNull Constraint constraint) {
        Where createWhere = createWhere(constraint);
        String nextJob = createWhere.nextJob(this.sqlHelper);
        while (true) {
            Cursor rawQuery = this.db.rawQuery(nextJob, createWhere.args);
            try {
                if (!rawQuery.moveToNext()) {
                    return null;
                }
                JobHolder createJobHolderFromCursor = createJobHolderFromCursor(rawQuery);
                setSessionIdOnJob(createJobHolderFromCursor);
                return createJobHolderFromCursor;
            } catch (InvalidJobException unused) {
                String string = rawQuery.getString(DbOpenHelper.ID_COLUMN.columnIndex);
                if (string == null) {
                    JqLog.e("cannot find job id on a retrieved job", new Object[0]);
                } else {
                    delete(string);
                }
            } finally {
                rawQuery.close();
            }
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void onJobCancelled(JobHolder jobHolder) {
        SQLiteStatement markAsCancelledStatement = this.sqlHelper.getMarkAsCancelledStatement();
        markAsCancelledStatement.clearBindings();
        markAsCancelledStatement.bindString(1, jobHolder.getId());
        markAsCancelledStatement.execute();
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void remove(@NonNull JobHolder jobHolder) {
        delete(jobHolder.getId());
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void substitute(@NonNull JobHolder jobHolder, @NonNull JobHolder jobHolder2) {
        this.db.beginTransaction();
        try {
            remove(jobHolder2);
            insert(jobHolder);
            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }
}
