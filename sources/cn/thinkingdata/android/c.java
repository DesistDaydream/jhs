package cn.thinkingdata.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import cn.thinkingdata.android.utils.TDLog;
import com.umeng.analytics.pro.d;
import d.a.a.k;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    private static final String b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f1354c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Context, c> f1355d;
    private final a a;

    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {
        private final File a;
        private final int b;

        public a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
            this.a = context.getDatabasePath(str);
            this.b = k.b(context).d();
        }

        public boolean j() {
            return !this.a.exists() || k() < this.b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
            if (r0 == null) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x0031, code lost:
            if (r0 != null) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int k() {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                android.database.sqlite.SQLiteDatabase r2 = r5.getReadableDatabase()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                r3.<init>()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                java.lang.String r4 = "SELECT count(*) FROM "
                r3.append(r4)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                cn.thinkingdata.android.c$c r4 = cn.thinkingdata.android.c.EnumC0056c.EVENTS     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                java.lang.String r4 = r4.a()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                r3.append(r4)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                android.database.Cursor r0 = r2.rawQuery(r3, r0)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                if (r2 == 0) goto L31
                java.lang.String r2 = "count(*)"
                int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
                int r1 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            L31:
                if (r0 == 0) goto L3f
                goto L3c
            L34:
                r1 = move-exception
                goto L40
            L36:
                r2 = move-exception
                r2.printStackTrace()     // Catch: java.lang.Throwable -> L34
                if (r0 == 0) goto L3f
            L3c:
                r0.close()
            L3f:
                return r1
            L40:
                if (r0 == 0) goto L45
                r0.close()
            L45:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.c.a.k():int");
        }

        public void l() {
            close();
            this.a.delete();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            TDLog.d("ThinkingAnalytics.DatabaseAdapter", "Creating a new ThinkingData events database");
            sQLiteDatabase.execSQL(c.b);
            sQLiteDatabase.execSQL(c.f1354c);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            TDLog.d("ThinkingAnalytics.DatabaseAdapter", "Upgrading ThinkingData events database");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EnumC0056c.EVENTS.a());
            sQLiteDatabase.execSQL(c.b);
            sQLiteDatabase.execSQL(c.f1354c);
        }
    }

    /* loaded from: classes.dex */
    public class b extends SQLiteOpenHelper {
        public b(c cVar, Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
            if (r3 == null) goto L10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
            r3.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0066, code lost:
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0055, code lost:
            if (r3 != null) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public org.json.JSONArray j() {
            /*
                r7 = this;
                java.lang.String r0 = "clickdata"
                java.lang.String r1 = "creattime"
                org.json.JSONArray r2 = new org.json.JSONArray
                r2.<init>()
                r3 = 0
                android.database.sqlite.SQLiteDatabase r4 = r7.getReadableDatabase()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                r5.<init>()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                java.lang.String r6 = "SELECT * FROM "
                r5.append(r6)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                cn.thinkingdata.android.c$c r6 = cn.thinkingdata.android.c.EnumC0056c.EVENTS     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                r5.append(r6)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                java.lang.String r6 = " ORDER BY "
                r5.append(r6)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                r5.append(r1)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                android.database.Cursor r3 = r4.rawQuery(r5, r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            L2d:
                boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                if (r4 == 0) goto L52
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                r4.<init>()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                int r5 = r3.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                r4.put(r1, r5)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                int r5 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                r4.put(r0, r5)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                r2.put(r4)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                goto L2d
            L52:
                r7.close()
                if (r3 == 0) goto L66
                goto L63
            L58:
                r0 = move-exception
                goto L67
            L5a:
                r0 = move-exception
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L58
                r7.close()
                if (r3 == 0) goto L66
            L63:
                r3.close()
            L66:
                return r2
            L67:
                r7.close()
                if (r3 == 0) goto L6f
                r3.close()
            L6f:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.c.b.j():org.json.JSONArray");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    /* renamed from: cn.thinkingdata.android.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0056c {
        EVENTS(d.ar);
        
        private final String a;

        EnumC0056c(String str) {
            this.a = str;
        }

        public String a() {
            return this.a;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        EnumC0056c enumC0056c = EnumC0056c.EVENTS;
        sb.append(enumC0056c.a());
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("clickdata");
        sb.append(" TEXT NOT NULL, ");
        sb.append("creattime");
        sb.append(" INTEGER NOT NULL, ");
        sb.append("token");
        sb.append(" TEXT NOT NULL DEFAULT '')");
        b = sb.toString();
        f1354c = "CREATE INDEX IF NOT EXISTS time_idx ON " + enumC0056c.a() + " (creattime);";
        f1355d = new HashMap();
    }

    public c(Context context) {
        this(context, "thinkingdata");
    }

    public c(Context context, String str) {
        this.a = new a(context, str);
        try {
            File databasePath = context.getDatabasePath(context.getPackageName());
            if (databasePath.exists()) {
                JSONArray j2 = new b(this, context, context.getPackageName()).j();
                for (int i2 = 0; i2 < j2.length(); i2++) {
                    try {
                        JSONObject jSONObject = j2.getJSONObject(i2);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("clickdata", jSONObject.getString("clickdata"));
                        contentValues.put("creattime", jSONObject.getString("creattime"));
                        TDLog.d("ThinkingAnalytics.DatabaseAdapter", contentValues.toString());
                        this.a.getWritableDatabase().insert(EnumC0056c.EVENTS.a(), null, contentValues);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                databasePath.delete();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static boolean f(Context context) {
        return (context.getDatabasePath("thinkingdata").exists() || context.getDatabasePath(context.getPackageName()).exists()) ? false : true;
    }

    public static c h(Context context) {
        c cVar;
        Map<Context, c> map = f1355d;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (map.containsKey(applicationContext)) {
                cVar = map.get(applicationContext);
            } else {
                cVar = new c(applicationContext);
                map.put(applicationContext, cVar);
            }
        }
        return cVar;
    }

    private boolean j() {
        return this.a.j();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0068, code lost:
        if (r0 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
        if (r0 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0094, code lost:
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(java.lang.String r6, cn.thinkingdata.android.c.EnumC0056c r7, java.lang.String r8) {
        /*
            r5 = this;
            java.lang.String r7 = r7.a()
            r0 = 0
            cn.thinkingdata.android.c$a r1 = r5.a     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r3 = "_id <= "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r2.append(r6)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r6 = "'"
            if (r8 == 0) goto L2e
            java.lang.String r3 = " AND "
            r2.append(r3)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r3 = "token"
            r2.append(r3)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r3 = " = '"
            r2.append(r3)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r2.append(r8)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r2.append(r6)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
        L2e:
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.delete(r7, r2, r0)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r3.<init>()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r4 = "SELECT COUNT(*) FROM "
            r3.append(r4)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r3.append(r7)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            if (r8 == 0) goto L58
            java.lang.String r3 = " WHERE token='"
            r2.append(r3)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r2.append(r8)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r2.append(r6)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
        L58:
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            android.database.Cursor r0 = r1.rawQuery(r6, r0)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r6 = 0
            int r6 = r0.getInt(r6)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            if (r0 == 0) goto L94
            goto L91
        L6b:
            r6 = move-exception
            goto L95
        L6d:
            r6 = move-exception
            java.lang.String r8 = "ThinkingAnalytics.DatabaseAdapter"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
            r1.<init>()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r2 = "could not clean data from "
            r1.append(r2)     // Catch: java.lang.Throwable -> L6b
            r1.append(r7)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> L6b
            cn.thinkingdata.android.utils.TDLog.e(r8, r7, r6)     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L89
            r0.close()     // Catch: java.lang.Throwable -> L6b
        L89:
            cn.thinkingdata.android.c$a r6 = r5.a     // Catch: java.lang.Throwable -> L6b
            r6.l()     // Catch: java.lang.Throwable -> L6b
            r6 = -1
            if (r0 == 0) goto L94
        L91:
            r0.close()
        L94:
            return r6
        L95:
            if (r0 == 0) goto L9a
            r0.close()
        L9a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.c.a(java.lang.String, cn.thinkingdata.android.c$c, java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a5, code lost:
        if (r3 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ce, code lost:
        if (r3 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d0, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d3, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b(org.json.JSONObject r10, cn.thinkingdata.android.c.EnumC0056c r11, java.lang.String r12) {
        /*
            r9 = this;
            boolean r0 = r9.j()
            r1 = 0
            java.lang.String r2 = "ThinkingAnalytics.DatabaseAdapter"
            r3 = 0
            if (r0 != 0) goto L24
            java.lang.String r0 = "The data has reached the limit, oldest data will be deleted"
            cn.thinkingdata.android.utils.TDLog.d(r2, r0)
            r0 = 100
            java.lang.String[] r0 = r9.g(r11, r3, r0)
            r4 = -2
            if (r0 != 0) goto L19
            return r4
        L19:
            r0 = r0[r1]
            cn.thinkingdata.android.c$c r5 = cn.thinkingdata.android.c.EnumC0056c.EVENTS
            int r0 = r9.a(r0, r5, r3)
            if (r0 > 0) goto L24
            return r4
        L24:
            java.lang.String r11 = r11.a()
            r0 = -1
            cn.thinkingdata.android.c$a r4 = r9.a     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            android.database.sqlite.SQLiteDatabase r4 = r4.getWritableDatabase()     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            r5.<init>()     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            d.a.a.e.e r6 = d.a.a.e.e.b(r12)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            if (r6 == 0) goto L42
            d.a.a.e.e r6 = d.a.a.e.e.b(r12)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            org.json.JSONObject r10 = r6.d(r10)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
        L42:
            java.lang.String r6 = "clickdata"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            r7.<init>()     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            r7.append(r8)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.String r8 = "#td#"
            r7.append(r8)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            int r10 = r10.hashCode()     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            r7.append(r10)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.String r10 = r7.toString()     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            r5.put(r6, r10)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.String r10 = "creattime"
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            r5.put(r10, r6)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.String r10 = "token"
            r5.put(r10, r12)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            r4.insert(r11, r3, r5)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            r10.<init>()     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.String r5 = "SELECT COUNT(*) FROM "
            r10.append(r5)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            r10.append(r11)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.String r5 = " WHERE token='"
            r10.append(r5)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            r10.append(r12)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.String r12 = "'"
            r10.append(r12)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            android.database.Cursor r3 = r4.rawQuery(r10, r3)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            r3.moveToFirst()     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            int r0 = r3.getInt(r1)     // Catch: java.lang.Throwable -> La8 android.database.sqlite.SQLiteException -> Laa
            if (r3 == 0) goto Ld3
            goto Ld0
        La8:
            r10 = move-exception
            goto Ld4
        Laa:
            r10 = move-exception
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8
            r12.<init>()     // Catch: java.lang.Throwable -> La8
            java.lang.String r1 = "could not add data to table "
            r12.append(r1)     // Catch: java.lang.Throwable -> La8
            r12.append(r11)     // Catch: java.lang.Throwable -> La8
            java.lang.String r11 = ". Re-initializing database."
            r12.append(r11)     // Catch: java.lang.Throwable -> La8
            java.lang.String r11 = r12.toString()     // Catch: java.lang.Throwable -> La8
            cn.thinkingdata.android.utils.TDLog.e(r2, r11, r10)     // Catch: java.lang.Throwable -> La8
            if (r3 == 0) goto Lc9
            r3.close()     // Catch: java.lang.Throwable -> La8
        Lc9:
            cn.thinkingdata.android.c$a r10 = r9.a     // Catch: java.lang.Throwable -> La8
            r10.l()     // Catch: java.lang.Throwable -> La8
            if (r3 == 0) goto Ld3
        Ld0:
            r3.close()
        Ld3:
            return r0
        Ld4:
            if (r3 == 0) goto Ld9
            r3.close()
        Ld9:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.c.b(org.json.JSONObject, cn.thinkingdata.android.c$c, java.lang.String):int");
    }

    public void d(long j2, EnumC0056c enumC0056c) {
        String a2 = enumC0056c.a();
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            writableDatabase.delete(a2, "creattime <= " + j2, null);
        } catch (SQLiteException e2) {
            TDLog.e("ThinkingAnalytics.DatabaseAdapter", "Could not clean timed-out records. Re-initializing database.", e2);
            this.a.l();
        }
    }

    public void e(EnumC0056c enumC0056c, String str) {
        String a2 = enumC0056c.a();
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            writableDatabase.delete(a2, "token = '" + str + "'", null);
        } catch (SQLiteException e2) {
            TDLog.e("ThinkingAnalytics.DatabaseAdapter", "Could not clean records. Re-initializing database.", e2);
            this.a.l();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d3, code lost:
        if (r3 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f2, code lost:
        if (r3 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f4, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f7, code lost:
        if (r4 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f9, code lost:
        if (r10 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0103, code lost:
        return new java.lang.String[]{r4, r10};
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0104, code lost:
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0106: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:57:0x0106 */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] g(cn.thinkingdata.android.c.EnumC0056c r10, java.lang.String r11, int r12) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.c.g(cn.thinkingdata.android.c$c, java.lang.String, int):java.lang.String[]");
    }
}
