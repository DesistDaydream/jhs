package com.moor.imkf.lib.jobqueue.persistentQueue.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.moor.imkf.lib.jobqueue.persistentQueue.sqlite.SqlHelper;

/* loaded from: classes2.dex */
public class DbOpenHelper extends SQLiteOpenHelper {
    public static final SqlHelper.Property CANCELLED_COLUMN;
    public static final SqlHelper.Property CANCEL_ON_DEADLINE_COLUMN;
    public static final int COLUMN_COUNT = 12;
    public static final SqlHelper.Property CREATED_NS_COLUMN;
    private static final int DB_VERSION = 12;
    public static final SqlHelper.Property DEADLINE_COLUMN;
    public static final SqlHelper.Property DELAY_UNTIL_NS_COLUMN;
    public static final SqlHelper.Property GROUP_ID_COLUMN;
    public static final SqlHelper.Property ID_COLUMN;
    public static final SqlHelper.Property INSERTION_ORDER_COLUMN = new SqlHelper.Property("insertionOrder", "integer", 0);
    public static final String JOB_HOLDER_TABLE_NAME = "job_holder";
    public static final String JOB_TAGS_TABLE_NAME = "job_holder_tags";
    public static final SqlHelper.Property PRIORITY_COLUMN;
    public static final SqlHelper.Property REQUIRED_NETWORK_TYPE_COLUMN;
    public static final SqlHelper.Property RUNNING_SESSION_ID_COLUMN;
    public static final SqlHelper.Property RUN_COUNT_COLUMN;
    public static final int TAGS_COLUMN_COUNT = 3;
    public static final SqlHelper.Property TAGS_ID_COLUMN;
    public static final SqlHelper.Property TAGS_JOB_ID_COLUMN;
    public static final SqlHelper.Property TAGS_NAME_COLUMN;
    public static final String TAG_INDEX_NAME = "TAG_NAME_INDEX";

    static {
        SqlHelper.Property property = new SqlHelper.Property("_id", "text", 1, null, true);
        ID_COLUMN = property;
        PRIORITY_COLUMN = new SqlHelper.Property(RemoteMessageConst.Notification.PRIORITY, "integer", 2);
        GROUP_ID_COLUMN = new SqlHelper.Property("group_id", "text", 3);
        RUN_COUNT_COLUMN = new SqlHelper.Property("run_count", "integer", 4);
        CREATED_NS_COLUMN = new SqlHelper.Property("created_ns", "long", 5);
        DELAY_UNTIL_NS_COLUMN = new SqlHelper.Property("delay_until_ns", "long", 6);
        RUNNING_SESSION_ID_COLUMN = new SqlHelper.Property("running_session_id", "long", 7);
        REQUIRED_NETWORK_TYPE_COLUMN = new SqlHelper.Property("network_type", "integer", 8);
        DEADLINE_COLUMN = new SqlHelper.Property("deadline", "integer", 9);
        CANCEL_ON_DEADLINE_COLUMN = new SqlHelper.Property("cancel_on_deadline", "integer", 10);
        CANCELLED_COLUMN = new SqlHelper.Property("cancelled", "integer", 11);
        TAGS_ID_COLUMN = new SqlHelper.Property("_id", "integer", 0);
        TAGS_JOB_ID_COLUMN = new SqlHelper.Property("job_id", "text", 1, new SqlHelper.ForeignKey(JOB_HOLDER_TABLE_NAME, property.columnName));
        TAGS_NAME_COLUMN = new SqlHelper.Property(PushConstants.SUB_TAGS_STATUS_NAME, "text", 2);
    }

    public DbOpenHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 12);
    }

    private void addCancelColumn(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("ALTER TABLE job_holder ADD COLUMN ");
        SqlHelper.Property property = CANCELLED_COLUMN;
        sb.append(property.columnName);
        sb.append(ExpandableTextView.N);
        sb.append(property.type);
        sQLiteDatabase.execSQL(sb.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SqlHelper.create(JOB_HOLDER_TABLE_NAME, INSERTION_ORDER_COLUMN, ID_COLUMN, PRIORITY_COLUMN, GROUP_ID_COLUMN, RUN_COUNT_COLUMN, CREATED_NS_COLUMN, DELAY_UNTIL_NS_COLUMN, RUNNING_SESSION_ID_COLUMN, REQUIRED_NETWORK_TYPE_COLUMN, DEADLINE_COLUMN, CANCEL_ON_DEADLINE_COLUMN, CANCELLED_COLUMN));
        SqlHelper.Property property = TAGS_ID_COLUMN;
        SqlHelper.Property property2 = TAGS_NAME_COLUMN;
        sQLiteDatabase.execSQL(SqlHelper.create(JOB_TAGS_TABLE_NAME, property, TAGS_JOB_ID_COLUMN, property2));
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS TAG_NAME_INDEX ON job_holder_tags(" + property2.columnName + ")");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        onUpgrade(sQLiteDatabase, i2, i3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 == 11) {
            addCancelColumn(sQLiteDatabase);
            return;
        }
        sQLiteDatabase.execSQL(SqlHelper.drop(JOB_HOLDER_TABLE_NAME));
        sQLiteDatabase.execSQL(SqlHelper.drop(JOB_TAGS_TABLE_NAME));
        sQLiteDatabase.execSQL("DROP INDEX IF EXISTS TAG_NAME_INDEX");
        onCreate(sQLiteDatabase);
    }
}
