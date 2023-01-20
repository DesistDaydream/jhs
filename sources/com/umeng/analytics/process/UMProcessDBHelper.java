package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    /* loaded from: classes3.dex */
    public class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i2) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f7294c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f7294c, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.f7295d, ""), (JSONArray) obj);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i2) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f7294c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f7294c, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.f7295d, ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Serializable {
        public int a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f7287c;

        /* renamed from: d  reason: collision with root package name */
        public String f7288d;

        /* renamed from: e  reason: collision with root package name */
        public int f7289e;

        /* renamed from: f  reason: collision with root package name */
        public String f7290f;

        /* renamed from: g  reason: collision with root package name */
        public String f7291g;

        /* renamed from: h  reason: collision with root package name */
        public String f7292h;

        private a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                a aVar = new a();
                aVar.f7287c = jSONObject.optString("id");
                aVar.f7291g = UMUtils.getAppVersionName(this.mContext);
                aVar.f7292h = UMUtils.getAppVersionCode(this.mContext);
                aVar.b = jSONObject.optString("__i");
                aVar.f7289e = jSONObject.optInt("__t");
                aVar.f7290f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.f7288d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<a> list) {
        SQLiteDatabase a2;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            a2 = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                a2.beginTransaction();
                for (a aVar : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", aVar.b);
                        contentValues.put("__e", aVar.f7287c);
                        contentValues.put("__t", Integer.valueOf(aVar.f7289e));
                        contentValues.put(a.InterfaceC0283a.f7303f, aVar.f7290f);
                        contentValues.put("__av", aVar.f7291g);
                        contentValues.put("__vc", aVar.f7292h);
                        contentValues.put("__s", aVar.f7288d);
                        a2.insert(a.InterfaceC0283a.a, null, contentValues);
                    } catch (Exception unused2) {
                    }
                }
                a2.setTransactionSuccessful();
                if (a2 != null) {
                    try {
                        a2.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
                c.a(this.mContext).b(str);
                return true;
            } catch (Exception unused4) {
                sQLiteDatabase = a2;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                c.a(this.mContext).b(str);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = a2;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            c.a(this.mContext).b(str);
            throw th;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.f7299h, readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0093, code lost:
        if (r2 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ac, code lost:
        if (r2 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ae, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4 A[Catch: Exception -> 0x00c7, TRY_LEAVE, TryCatch #4 {Exception -> 0x00c7, blocks: (B:34:0x00bf, B:36:0x00c4), top: B:43:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r12.mContext     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
            android.database.sqlite.SQLiteDatabase r2 = r2.a(r13)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            java.lang.String r4 = "__et_p"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r2
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            if (r3 == 0) goto L8e
        L22:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            if (r4 == 0) goto L8e
            com.umeng.analytics.process.UMProcessDBHelper$a r4 = new com.umeng.analytics.process.UMProcessDBHelper$a     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.<init>()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r5 = 0
            int r5 = r3.getInt(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.a = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__i"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.b = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__e"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.f7287c = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__s"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.f7288d = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__t"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            int r5 = r3.getInt(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.f7289e = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__pn"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.f7290f = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__av"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.f7291g = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = "__vc"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r4.f7292h = r5     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            r0.add(r4)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> Lbb
            goto L22
        L8c:
            r1 = move-exception
            goto La4
        L8e:
            if (r3 == 0) goto L93
            r3.close()     // Catch: java.lang.Exception -> Lb1
        L93:
            if (r2 == 0) goto Lb1
            goto Lae
        L96:
            r0 = move-exception
            goto Lbd
        L98:
            r3 = move-exception
            r11 = r3
            r3 = r1
            r1 = r11
            goto La4
        L9d:
            r0 = move-exception
            r2 = r1
            goto Lbd
        La0:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        La4:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lbb
            if (r3 == 0) goto Lac
            r3.close()     // Catch: java.lang.Exception -> Lb1
        Lac:
            if (r2 == 0) goto Lb1
        Lae:
            r2.endTransaction()     // Catch: java.lang.Exception -> Lb1
        Lb1:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r13)
            return r0
        Lbb:
            r0 = move-exception
            r1 = r3
        Lbd:
            if (r1 == 0) goto Lc2
            r1.close()     // Catch: java.lang.Exception -> Lc7
        Lc2:
            if (r2 == 0) goto Lc7
            r2.endTransaction()     // Catch: java.lang.Exception -> Lc7
        Lc7:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void deleteEventDatas(String str, String str2, List<a> list) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            sQLiteDatabase = null;
            th = th2;
        }
        try {
            sQLiteDatabase.beginTransaction();
            int size = list.size();
            if (list == null || size <= 0) {
                sQLiteDatabase.delete(a.InterfaceC0283a.a, null, null);
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    sQLiteDatabase.execSQL("delete from __et_p where rowid=" + list.get(i2).a);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Exception unused2) {
            sQLiteDatabase2 = sQLiteDatabase;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
            c.a(this.mContext).b(str);
        } catch (Throwable th3) {
            th = th3;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b(str);
            throw th;
        }
        c.a(this.mContext).b(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r1 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        com.umeng.analytics.process.c.a(r7.mContext).b(com.umeng.analytics.process.a.f7299h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "_main_"
            r1 = 0
            android.content.Context r2 = r7.mContext     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            android.database.sqlite.SQLiteDatabase r1 = r2.a(r0)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
        L14:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            if (r2 == 0) goto L32
            java.lang.Object r2 = r8.next()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.lang.String r3 = "__et_p"
            java.lang.String r4 = "id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r6 = 0
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r5[r6] = r2     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r1.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            goto L14
        L32:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            if (r1 == 0) goto L4e
            goto L4b
        L38:
            r8 = move-exception
            if (r1 == 0) goto L3e
            r1.endTransaction()
        L3e:
            android.content.Context r1 = r7.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r0)
            throw r8
        L48:
            if (r1 == 0) goto L4e
        L4b:
            r1.endTransaction()
        L4e:
            android.content.Context r8 = r7.mContext
            com.umeng.analytics.process.c r8 = com.umeng.analytics.process.c.a(r8)
            r8.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readMainEvents(long r20, java.util.List<java.lang.Integer> r22) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    public JSONObject readVersionInfoFromColumId(Integer num) {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.f7299h);
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor query = sQLiteDatabase.query(a.InterfaceC0283a.a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (query != null) {
                        try {
                            try {
                                if (query.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = query.getString(query.getColumnIndex("__av"));
                                        String string2 = query.getString(query.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e2) {
                                        e = e2;
                                        cursor = query;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.f7299h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f7299h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                jSONObject = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = query;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused2) {
                                    c.a(this.mContext).b(com.umeng.analytics.process.a.f7299h);
                                    throw th;
                                }
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            c.a(this.mContext).b(com.umeng.analytics.process.a.f7299h);
                            throw th;
                        }
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.f7299h);
                    return jSONObject2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                jSONObject = null;
            }
        } catch (Exception e5) {
            e = e5;
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }
}
