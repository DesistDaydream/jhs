package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class o {
    private static o a = null;
    private static p b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f6768c = false;

    private o(Context context, List<com.tencent.bugly.a> list) {
        b = new p(context, list);
    }

    private synchronized boolean b(q qVar) {
        ContentValues d2;
        if (qVar == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase == null || (d2 = d(qVar)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_pf", "_id", d2);
            if (replace >= 0) {
                y.c("[Database] insert %s success.", "t_pf");
                qVar.a = replace;
                return true;
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
            }
        }
    }

    private static ContentValues c(q qVar) {
        if (qVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = qVar.a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put(com.umeng.analytics.pro.aq.f7041e, Integer.valueOf(qVar.b));
            contentValues.put("_pc", qVar.f6782c);
            contentValues.put("_th", qVar.f6783d);
            contentValues.put("_tm", Long.valueOf(qVar.f6784e));
            byte[] bArr = qVar.f6786g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static ContentValues d(q qVar) {
        if (qVar != null && !ab.a(qVar.f6785f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j2 = qVar.a;
                if (j2 > 0) {
                    contentValues.put("_id", Long.valueOf(j2));
                }
                contentValues.put(com.umeng.analytics.pro.aq.f7041e, qVar.f6785f);
                contentValues.put("_tm", Long.valueOf(qVar.f6784e));
                byte[] bArr = qVar.f6786g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized o a(Context context, List<com.tencent.bugly.a> list) {
        o oVar;
        synchronized (o.class) {
            if (a == null) {
                a = new o(context, list);
            }
            oVar = a;
        }
        return oVar;
    }

    /* loaded from: classes3.dex */
    public class a extends Thread {
        private int a;
        private n b;

        /* renamed from: c  reason: collision with root package name */
        private String f6769c;

        /* renamed from: d  reason: collision with root package name */
        private ContentValues f6770d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6771e;

        /* renamed from: f  reason: collision with root package name */
        private String[] f6772f;

        /* renamed from: g  reason: collision with root package name */
        private String f6773g;

        /* renamed from: h  reason: collision with root package name */
        private String[] f6774h;

        /* renamed from: i  reason: collision with root package name */
        private String f6775i;

        /* renamed from: j  reason: collision with root package name */
        private String f6776j;

        /* renamed from: k  reason: collision with root package name */
        private String f6777k;

        /* renamed from: l  reason: collision with root package name */
        private String f6778l;

        /* renamed from: m  reason: collision with root package name */
        private String f6779m;
        private String[] n;
        private int o;
        private String p;
        private byte[] q;

        public a(int i2, n nVar) {
            this.a = i2;
            this.b = nVar;
        }

        public final void a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f6771e = z;
            this.f6769c = str;
            this.f6772f = strArr;
            this.f6773g = str2;
            this.f6774h = strArr2;
            this.f6775i = str3;
            this.f6776j = str4;
            this.f6777k = str5;
            this.f6778l = str6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.a) {
                case 1:
                    o.this.a(this.f6769c, this.f6770d, this.b);
                    return;
                case 2:
                    o.this.a(this.f6769c, this.f6779m, this.n, this.b);
                    return;
                case 3:
                    Cursor a = o.this.a(this.f6771e, this.f6769c, this.f6772f, this.f6773g, this.f6774h, this.f6775i, this.f6776j, this.f6777k, this.f6778l, this.b);
                    if (a != null) {
                        a.close();
                        return;
                    }
                    return;
                case 4:
                    o.this.a(this.o, this.p, this.q, this.b);
                    return;
                case 5:
                    o.this.a(this.o, this.b);
                    return;
                case 6:
                    o.this.a(this.o, this.p, this.b);
                    return;
                default:
                    return;
            }
        }

        public final void a(int i2, String str, byte[] bArr) {
            this.o = i2;
            this.p = str;
            this.q = bArr;
        }
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            oVar = a;
        }
        return oVar;
    }

    public final long a(String str, ContentValues contentValues, n nVar, boolean z) {
        return a(str, contentValues, (n) null);
    }

    private synchronized List<q> c(int i2) {
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                String str = "_id = " + i2;
                cursor = writableDatabase.query("t_pf", null, str, null, null, null, null);
                if (cursor == null) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        q b2 = b(cursor);
                        if (b2 != null) {
                            arrayList.add(b2);
                        } else {
                            String string = cursor.getString(cursor.getColumnIndex(com.umeng.analytics.pro.aq.f7041e));
                            sb.append(" or _tp");
                            sb.append(" = ");
                            sb.append(string);
                        }
                    }
                    if (sb.length() > 0) {
                        sb.append(" and _id");
                        sb.append(" = ");
                        sb.append(i2);
                        y.d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", str.substring(4), null)));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    if (!y.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, n nVar, boolean z) {
        return a(false, str, strArr, str2, (String[]) null, (String) null, (String) null, (String) null, (String) null, (n) null, true);
    }

    public final Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, n nVar, boolean z2) {
        if (!z2) {
            a aVar = new a(3, nVar);
            aVar.a(false, str, strArr, str2, strArr2, null, null, str5, str6);
            x.a().a(aVar);
            return null;
        }
        return a(false, str, strArr, str2, strArr2, null, null, str5, str6, nVar);
    }

    public final synchronized void b(int i2) {
        String str;
        SQLiteDatabase writableDatabase = b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i2 >= 0) {
                str = "_tp = " + i2;
            } else {
                str = null;
            }
            y.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }

    public final int a(String str, String str2, String[] strArr, n nVar, boolean z) {
        return a(str, str2, (String[]) null, (n) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized long a(String str, ContentValues contentValues, n nVar) {
        long j2;
        j2 = -1;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long replace = writableDatabase.replace(str, "_id", contentValues);
                if (replace >= 0) {
                    y.c("[Database] insert %s success.", str);
                } else {
                    y.d("[Database] replace %s error.", str);
                }
                j2 = replace;
            }
        } catch (Throwable th) {
            try {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j2;
    }

    private static q b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            q qVar = new q();
            qVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            qVar.f6784e = cursor.getLong(cursor.getColumnIndex("_tm"));
            qVar.f6785f = cursor.getString(cursor.getColumnIndex(com.umeng.analytics.pro.aq.f7041e));
            qVar.f6786g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return qVar;
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, n nVar) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } finally {
            try {
                return cursor;
            } finally {
            }
        }
        return cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(String str, String str2, String[] strArr, n nVar) {
        int i2;
        i2 = 0;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                i2 = writableDatabase.delete(str, str2, strArr);
            }
        } catch (Throwable th) {
            try {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i2;
    }

    public final boolean a(int i2, String str, byte[] bArr, n nVar, boolean z) {
        if (!z) {
            a aVar = new a(4, null);
            aVar.a(i2, str, bArr);
            x.a().a(aVar);
            return true;
        }
        return a(i2, str, bArr, (n) null);
    }

    public final Map<String, byte[]> a(int i2, n nVar, boolean z) {
        return a(i2, (n) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, String str, byte[] bArr, n nVar) {
        try {
            q qVar = new q();
            qVar.a = i2;
            qVar.f6785f = str;
            qVar.f6784e = System.currentTimeMillis();
            qVar.f6786g = bArr;
            return b(qVar);
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, byte[]> a(int i2, n nVar) {
        HashMap hashMap = null;
        try {
            List<q> c2 = c(i2);
            if (c2 != null) {
                HashMap hashMap2 = new HashMap();
                try {
                    for (q qVar : c2) {
                        byte[] bArr = qVar.f6786g;
                        if (bArr != null) {
                            hashMap2.put(qVar.f6785f, bArr);
                        }
                    }
                    return hashMap2;
                } catch (Throwable th) {
                    th = th;
                    hashMap = hashMap2;
                    if (y.a(th)) {
                        return hashMap;
                    }
                    th.printStackTrace();
                    return hashMap;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized boolean a(q qVar) {
        ContentValues c2;
        if (qVar == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase == null || (c2 = c(qVar)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_lr", "_id", c2);
            if (replace >= 0) {
                y.c("[Database] insert %s success.", "t_lr");
                qVar.a = replace;
                return true;
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #4 {, blocks: (B:3:0x0001, B:14:0x0031, B:31:0x009b, B:40:0x00af, B:36:0x00a4, B:38:0x00aa), top: B:52:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af A[Catch: all -> 0x00bc, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:14:0x0031, B:31:0x009b, B:40:0x00af, B:36:0x00a4, B:38:0x00aa), top: B:52:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.tencent.bugly.proguard.q> a(int r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            com.tencent.bugly.proguard.p r0 = com.tencent.bugly.proguard.o.b     // Catch: java.lang.Throwable -> Lbc
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> Lbc
            r9 = 0
            if (r0 == 0) goto Lba
            if (r12 < 0) goto L20
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
            java.lang.String r2 = "_tp = "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1c
            r1.append(r12)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r12 = r1.toString()     // Catch: java.lang.Throwable -> L1c
            r4 = r12
            goto L21
        L1c:
            r12 = move-exception
            r0 = r9
            goto La4
        L20:
            r4 = r9
        L21:
            java.lang.String r2 = "t_lr"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r0
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L1c
            if (r12 != 0) goto L36
            if (r12 == 0) goto L34
            r12.close()     // Catch: java.lang.Throwable -> Lbc
        L34:
            monitor-exit(r11)
            return r9
        L36:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            r1.<init>()     // Catch: java.lang.Throwable -> La0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La0
            r2.<init>()     // Catch: java.lang.Throwable -> La0
        L40:
            boolean r3 = r12.moveToNext()     // Catch: java.lang.Throwable -> La0
            r4 = 0
            if (r3 == 0) goto L71
            com.tencent.bugly.proguard.q r3 = a(r12)     // Catch: java.lang.Throwable -> La0
            if (r3 == 0) goto L51
            r2.add(r3)     // Catch: java.lang.Throwable -> La0
            goto L40
        L51:
            java.lang.String r3 = "_id"
            int r3 = r12.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L69
            long r5 = r12.getLong(r3)     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = " or _id"
            r1.append(r3)     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = " = "
            r1.append(r3)     // Catch: java.lang.Throwable -> L69
            r1.append(r5)     // Catch: java.lang.Throwable -> L69
            goto L40
        L69:
            java.lang.String r3 = "[Database] unknown id."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> La0
            com.tencent.bugly.proguard.y.d(r3, r4)     // Catch: java.lang.Throwable -> La0
            goto L40
        L71:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La0
            int r3 = r1.length()     // Catch: java.lang.Throwable -> La0
            if (r3 <= 0) goto L99
            r3 = 4
            java.lang.String r1 = r1.substring(r3)     // Catch: java.lang.Throwable -> La0
            java.lang.String r3 = "t_lr"
            int r0 = r0.delete(r3, r1, r9)     // Catch: java.lang.Throwable -> La0
            java.lang.String r1 = "[Database] deleted %s illegal data %d"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> La0
            java.lang.String r5 = "t_lr"
            r3[r4] = r5     // Catch: java.lang.Throwable -> La0
            r4 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> La0
            r3[r4] = r0     // Catch: java.lang.Throwable -> La0
            com.tencent.bugly.proguard.y.d(r1, r3)     // Catch: java.lang.Throwable -> La0
        L99:
            if (r12 == 0) goto L9e
            r12.close()     // Catch: java.lang.Throwable -> Lbc
        L9e:
            monitor-exit(r11)
            return r2
        La0:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
        La4:
            boolean r1 = com.tencent.bugly.proguard.y.a(r12)     // Catch: java.lang.Throwable -> Lb3
            if (r1 != 0) goto Lad
            r12.printStackTrace()     // Catch: java.lang.Throwable -> Lb3
        Lad:
            if (r0 == 0) goto Lba
            r0.close()     // Catch: java.lang.Throwable -> Lbc
            goto Lba
        Lb3:
            r12 = move-exception
            if (r0 == 0) goto Lb9
            r0.close()     // Catch: java.lang.Throwable -> Lbc
        Lb9:
            throw r12     // Catch: java.lang.Throwable -> Lbc
        Lba:
            monitor-exit(r11)
            return r9
        Lbc:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.o.a(int):java.util.List");
    }

    public final synchronized void a(List<q> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = b.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (q qVar : list) {
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(qVar.a);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    sb.setLength(0);
                    y.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                }
            }
        }
    }

    private static q a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            q qVar = new q();
            qVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            qVar.b = cursor.getInt(cursor.getColumnIndex(com.umeng.analytics.pro.aq.f7041e));
            qVar.f6782c = cursor.getString(cursor.getColumnIndex("_pc"));
            qVar.f6783d = cursor.getString(cursor.getColumnIndex("_th"));
            qVar.f6784e = cursor.getLong(cursor.getColumnIndex("_tm"));
            qVar.f6786g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return qVar;
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i2, String str, n nVar) {
        boolean z;
        String str2;
        z = false;
        try {
            SQLiteDatabase writableDatabase = b.getWritableDatabase();
            if (writableDatabase != null) {
                if (ab.a(str)) {
                    str2 = "_id = " + i2;
                } else {
                    str2 = "_id = " + i2 + " and _tp = \"" + str + "\"";
                }
                int delete = writableDatabase.delete("t_pf", str2, null);
                y.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
                if (delete > 0) {
                    z = true;
                }
            }
        } catch (Throwable th) {
            try {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z;
    }
}
