package bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class v {

    /* renamed from: d */
    private static int f172d;

    /* renamed from: e */
    public static final HashMap<String, u> f173e = new HashMap<>();
    private final j2 a;
    private final k2 b;

    /* renamed from: c */
    private final a f174c;

    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {
        public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
            super(context, str, cursorFactory, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                for (u uVar : v.f173e.values()) {
                    String c2 = uVar.c();
                    if (c2 != null) {
                        sQLiteDatabase.execSQL(c2);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                }
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e2) {
                l0.a(e2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            onUpgrade(sQLiteDatabase, i2, i3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            l0.d("onUpgrade, " + i2 + ", " + i3, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<u> it = v.f173e.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().d());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                    onCreate(sQLiteDatabase);
                } finally {
                }
            }
            onCreate(sQLiteDatabase);
        }
    }

    static {
        r0 = "SELECT * FROM " + c0.o + " WHERE " + TUIConstants.TUICalling.EVENT_KEY_NAME + " =?  AND monitor_status" + k.b.a.a.o.e.f16243c;
        String str = "UPDATE " + c0.o + " SET monitor_num =? WHERE " + TUIConstants.TUICalling.EVENT_KEY_NAME + " =? AND monitor_status =?";
        String str2 = "SELECT * FROM " + c0.o + " WHERE " + MessageKey.MSG_DATE + "<? ORDER BY local_time_ms LIMIT ?";
        String str3 = "DELETE FROM " + c0.o + " WHERE local_time_ms <= ?";
        a(new b0());
        a(new w());
        a(new y(null, false, null));
        a(new z());
        a(new d0());
        a(new a0());
        a(new x("", new JSONObject()));
        a(new c0());
    }

    public v(Application application, k2 k2Var, j2 j2Var) {
        this.f174c = new a(application, "bd_embed_m_log.db", null, 29);
        this.b = k2Var;
        this.a = j2Var;
    }

    private int a(u[] uVarArr, int i2, SQLiteDatabase sQLiteDatabase, String str, JSONArray[] jSONArrayArr) {
        int i3 = 0;
        while (i3 < i2) {
            jSONArrayArr[i3] = null;
            i3++;
        }
        int i4 = 200;
        while (i4 > 0 && i3 < uVarArr.length) {
            jSONArrayArr[i3] = a(sQLiteDatabase, uVarArr[i3], str, i4);
            i4 -= jSONArrayArr[i3].length();
            if (i4 > 0) {
                i3++;
            }
        }
        return i3;
    }

    private String a(long j2, int i2) {
        return "UPDATE pack SET _fail=" + i2 + " WHERE local_time_ms=" + j2;
    }

    private String a(u uVar, String str, int i2) {
        return "SELECT * FROM " + uVar.d() + " WHERE session_id='" + str + "' ORDER BY local_time_ms LIMIT " + i2;
    }

    private String a(u uVar, String str, long j2) {
        return "DELETE FROM " + uVar.d() + " WHERE session_id='" + str + "' AND local_time_ms" + SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION + j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0054, code lost:
        if (r14 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0065, code lost:
        bykvm_19do.bykvm_19do.bykvm_19do.l0.a("queryEvent, " + r12 + ", " + r1.length() + ", " + r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0089, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONArray a(android.database.sqlite.SQLiteDatabase r11, bykvm_19do.bykvm_19do.bykvm_19do.u r12, java.lang.String r13, int r14) {
        /*
            r10 = this;
            java.lang.String r0 = ", "
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            r2 = 0
            r4 = 0
            java.lang.String r14 = r10.a(r12, r13, r14)     // Catch: java.lang.Throwable -> L5a
            android.database.Cursor r14 = r11.rawQuery(r14, r4)     // Catch: java.lang.Throwable -> L5a
            r5 = r2
        L13:
            boolean r7 = r14.moveToNext()     // Catch: java.lang.Throwable -> L57
            if (r7 == 0) goto L49
            r12.a(r14)     // Catch: java.lang.Throwable -> L57
            boolean r7 = bykvm_19do.bykvm_19do.bykvm_19do.l0.a     // Catch: java.lang.Throwable -> L57
            if (r7 == 0) goto L3a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L57
            r7.<init>()     // Catch: java.lang.Throwable -> L57
            java.lang.String r8 = "queryEvnetInner, "
            r7.append(r8)     // Catch: java.lang.Throwable -> L57
            r7.append(r13)     // Catch: java.lang.Throwable -> L57
            r7.append(r0)     // Catch: java.lang.Throwable -> L57
            r7.append(r12)     // Catch: java.lang.Throwable -> L57
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L57
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r7, r4)     // Catch: java.lang.Throwable -> L57
        L3a:
            org.json.JSONObject r7 = r12.f()     // Catch: java.lang.Throwable -> L57
            r1.put(r7)     // Catch: java.lang.Throwable -> L57
            long r7 = r12.a     // Catch: java.lang.Throwable -> L57
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 <= 0) goto L13
            r5 = r7
            goto L13
        L49:
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 <= 0) goto L54
            java.lang.String r13 = r10.a(r12, r13, r5)     // Catch: java.lang.Throwable -> L57
            r11.execSQL(r13)     // Catch: java.lang.Throwable -> L57
        L54:
            if (r14 == 0) goto L65
            goto L62
        L57:
            r11 = move-exception
            r2 = r5
            goto L5c
        L5a:
            r11 = move-exception
            r14 = r4
        L5c:
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r11)     // Catch: java.lang.Throwable -> L8a
            r5 = r2
            if (r14 == 0) goto L65
        L62:
            r14.close()
        L65:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = "queryEvent, "
            r11.append(r13)
            r11.append(r12)
            r11.append(r0)
            int r12 = r1.length()
            r11.append(r12)
            r11.append(r0)
            r11.append(r5)
            java.lang.String r11 = r11.toString()
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r11, r4)
            return r1
        L8a:
            r11 = move-exception
            if (r14 == 0) goto L90
            r14.close()
        L90:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.v.a(android.database.sqlite.SQLiteDatabase, bykvm_19do.bykvm_19do.bykvm_19do.u, java.lang.String, int):org.json.JSONArray");
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0059, code lost:
        if (r8 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x006c, code lost:
        if (r3.length() <= 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0072, code lost:
        if (r5 <= 1000) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0075, code lost:
        r5 = 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0076, code lost:
        r13.f101i = r5;
        r13.f166c = r12.f166c;
        r13.a = r12.a;
        r13.f102j = (r12.a + r5) / 1000;
        r13.b = bykvm_19do.bykvm_19do.bykvm_19do.b2.a(r11.a);
        r13.f168e = r12.f168e;
        r13.f169f = r12.f169f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0098, code lost:
        if (bykvm_19do.bykvm_19do.bykvm_19do.l0.a == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x009a, code lost:
        bykvm_19do.bykvm_19do.bykvm_19do.l0.a("queryPage, " + r13 + ", " + r3.length(), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00b8, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONArray a(bykvm_19do.bykvm_19do.bykvm_19do.z r12, bykvm_19do.bykvm_19do.bykvm_19do.d0 r13, bykvm_19do.bykvm_19do.bykvm_19do.b0 r14, android.database.sqlite.SQLiteDatabase r15) {
        /*
            r11 = this;
            java.lang.String r0 = ", "
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]
            java.lang.String r3 = r12.f166c
            r4 = 0
            r2[r4] = r3
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>()
            r5 = 0
            r7 = 0
            java.lang.String r8 = "SELECT * FROM page WHERE session_id=? LIMIT 500"
            android.database.Cursor r8 = r15.rawQuery(r8, r2)     // Catch: java.lang.Throwable -> L5e
        L18:
            boolean r9 = r8.moveToNext()     // Catch: java.lang.Throwable -> L5c
            if (r9 == 0) goto L52
            r14.a(r8)     // Catch: java.lang.Throwable -> L5c
            boolean r4 = bykvm_19do.bykvm_19do.bykvm_19do.l0.a     // Catch: java.lang.Throwable -> L5c
            if (r4 == 0) goto L3f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r4.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r9 = "queryPageInner, "
            r4.append(r9)     // Catch: java.lang.Throwable -> L5c
            r4.append(r2)     // Catch: java.lang.Throwable -> L5c
            r4.append(r0)     // Catch: java.lang.Throwable -> L5c
            r4.append(r14)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L5c
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r4, r7)     // Catch: java.lang.Throwable -> L5c
        L3f:
            boolean r4 = r14.j()     // Catch: java.lang.Throwable -> L5c
            if (r4 == 0) goto L4d
            org.json.JSONObject r4 = r14.f()     // Catch: java.lang.Throwable -> L5c
            r3.put(r4)     // Catch: java.lang.Throwable -> L5c
            goto L50
        L4d:
            long r9 = r14.f75i     // Catch: java.lang.Throwable -> L5c
            long r5 = r5 + r9
        L50:
            r4 = 1
            goto L18
        L52:
            if (r4 == 0) goto L59
            java.lang.String r14 = "DELETE FROM page WHERE session_id=?"
            r15.execSQL(r14, r2)     // Catch: java.lang.Throwable -> L5c
        L59:
            if (r8 == 0) goto L68
            goto L65
        L5c:
            r14 = move-exception
            goto L60
        L5e:
            r14 = move-exception
            r8 = r7
        L60:
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r14)     // Catch: java.lang.Throwable -> Lb9
            if (r8 == 0) goto L68
        L65:
            r8.close()
        L68:
            int r14 = r3.length()
            if (r14 <= 0) goto L96
            r14 = 1000(0x3e8, double:4.94E-321)
            int r1 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r1 <= 0) goto L75
            goto L76
        L75:
            r5 = r14
        L76:
            r13.f101i = r5
            java.lang.String r1 = r12.f166c
            r13.f166c = r1
            long r1 = r12.a
            r13.a = r1
            long r1 = r12.a
            long r1 = r1 + r5
            long r1 = r1 / r14
            r13.f102j = r1
            bykvm_19do.bykvm_19do.bykvm_19do.j2 r14 = r11.a
            long r14 = bykvm_19do.bykvm_19do.bykvm_19do.b2.a(r14)
            r13.b = r14
            java.lang.String r14 = r12.f168e
            r13.f168e = r14
            java.lang.String r12 = r12.f169f
            r13.f169f = r12
        L96:
            boolean r12 = bykvm_19do.bykvm_19do.bykvm_19do.l0.a
            if (r12 == 0) goto Lb8
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "queryPage, "
            r12.append(r14)
            r12.append(r13)
            r12.append(r0)
            int r13 = r3.length()
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r12, r7)
        Lb8:
            return r3
        Lb9:
            r12 = move-exception
            if (r8 == 0) goto Lbf
            r8.close()
        Lbf:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.v.a(bykvm_19do.bykvm_19do.bykvm_19do.z, bykvm_19do.bykvm_19do.bykvm_19do.d0, bykvm_19do.bykvm_19do.bykvm_19do.b0, android.database.sqlite.SQLiteDatabase):org.json.JSONArray");
    }

    private void a(a0 a0Var, HashMap<String, Integer> hashMap, boolean z) {
    }

    private static void a(u uVar) {
        f173e.put(uVar.d(), uVar);
    }

    private boolean a(z zVar, boolean z) {
        return !zVar.f203l && z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x002f, code lost:
        if (r3 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x003e, code lost:
        bykvm_19do.bykvm_19do.bykvm_19do.l0.a("queryPack, " + r0.size() + ", " + r0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x005e, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<bykvm_19do.bykvm_19do.bykvm_19do.a0> a() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashMap<java.lang.String, bykvm_19do.bykvm_19do.bykvm_19do.u> r1 = bykvm_19do.bykvm_19do.bykvm_19do.v.f173e
            java.lang.String r2 = "pack"
            java.lang.Object r1 = r1.get(r2)
            bykvm_19do.bykvm_19do.bykvm_19do.a0 r1 = (bykvm_19do.bykvm_19do.bykvm_19do.a0) r1
            r2 = 0
            bykvm_19do.bykvm_19do.bykvm_19do.v$a r3 = r5.f174c     // Catch: java.lang.Throwable -> L34
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = "SELECT * FROM pack ORDER BY local_time_ms DESC,_full DESC LIMIT 2"
            android.database.Cursor r3 = r3.rawQuery(r4, r2)     // Catch: java.lang.Throwable -> L34
        L1c:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L32
            if (r4 == 0) goto L2f
            bykvm_19do.bykvm_19do.bykvm_19do.u r1 = r1.clone()     // Catch: java.lang.Throwable -> L32
            bykvm_19do.bykvm_19do.bykvm_19do.a0 r1 = (bykvm_19do.bykvm_19do.bykvm_19do.a0) r1     // Catch: java.lang.Throwable -> L32
            r1.a(r3)     // Catch: java.lang.Throwable -> L32
            r0.add(r1)     // Catch: java.lang.Throwable -> L32
            goto L1c
        L2f:
            if (r3 == 0) goto L3e
            goto L3b
        L32:
            r1 = move-exception
            goto L36
        L34:
            r1 = move-exception
            r3 = r2
        L36:
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r1)     // Catch: java.lang.Throwable -> L5f
            if (r3 == 0) goto L3e
        L3b:
            r3.close()
        L3e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "queryPack, "
            r1.append(r3)
            int r3 = r0.size()
            r1.append(r3)
            java.lang.String r3 = ", "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r1, r2)
            return r0
        L5f:
            r0 = move-exception
            if (r3 == 0) goto L65
            r3.close()
        L65:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.v.a():java.util.ArrayList");
    }

    public void a(ArrayList<u> arrayList) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        l0.a("save, " + arrayList.toString(), null);
        try {
            sQLiteDatabase = this.f174c.getWritableDatabase();
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
        }
        try {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<u> it = arrayList.iterator();
                ContentValues contentValues = null;
                while (it.hasNext()) {
                    u next = it.next();
                    String d2 = next.d();
                    contentValues = next.b(contentValues);
                    sQLiteDatabase.insert(d2, null, contentValues);
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    f172d += arrayList.size();
                    l0.a(th);
                    if (sQLiteDatabase == null) {
                        return;
                    }
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th4) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable th5) {
                            l0.a(th5);
                        }
                    }
                    throw th4;
                }
            }
            sQLiteDatabase.endTransaction();
        } catch (Throwable th6) {
            l0.a(th6);
        }
    }

    public void a(ArrayList<a0> arrayList, ArrayList<a0> arrayList2) {
        SQLiteDatabase sQLiteDatabase = null;
        l0.a("setResult, " + arrayList + ", " + arrayList2, null);
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        HashMap<String, Integer> hashMap3 = new HashMap<>();
        HashMap<String, Integer> hashMap4 = new HashMap<>();
        HashMap<String, Integer> hashMap5 = new HashMap<>();
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).f68j == 0) {
                    a(arrayList.get(i2), hashMap, true);
                } else {
                    a(arrayList.get(i2), hashMap4, false);
                }
            }
        }
        Iterator<a0> it = arrayList2.iterator();
        while (it.hasNext()) {
            a0 next = it.next();
            int i3 = next.f68j;
            if (i3 == 0) {
                HashMap<String, Integer> hashMap6 = (HashMap) hashMap2.get(Integer.valueOf(next.f69k));
                if (hashMap6 == null) {
                    hashMap6 = new HashMap<>();
                    hashMap2.put(Integer.valueOf(next.f69k), hashMap6);
                }
                a(next, hashMap6, false);
            } else if (i3 + 1 > 5) {
                a(next, hashMap3, false);
                arrayList.add(next);
                it.remove();
            } else {
                a(next, hashMap5, false);
            }
        }
        try {
            sQLiteDatabase = this.f174c.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            Iterator<a0> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                sQLiteDatabase.execSQL("DELETE FROM pack WHERE local_time_ms=?", new String[]{String.valueOf(it2.next().a)});
            }
            Iterator<a0> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                a0 next2 = it3.next();
                long j2 = next2.a;
                int i4 = next2.f68j + 1;
                next2.f68j = i4;
                sQLiteDatabase.execSQL(a(j2, i4));
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            try {
                l0.a(th);
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Throwable th2) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        l0.a(e2);
                    }
                }
                throw th2;
            }
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Exception e3) {
            l0.a(e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:328:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x00f5 A[Catch: all -> 0x01e6, Exception -> 0x01ea, TryCatch #15 {Exception -> 0x01ea, all -> 0x01e6, blocks: (B:326:0x00b5, B:334:0x00c9, B:336:0x00d8, B:338:0x00f5, B:339:0x011d), top: B:440:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x011d A[Catch: all -> 0x01e6, Exception -> 0x01ea, TRY_LEAVE, TryCatch #15 {Exception -> 0x01ea, all -> 0x01e6, blocks: (B:326:0x00b5, B:334:0x00c9, B:336:0x00d8, B:338:0x00f5, B:339:0x011d), top: B:440:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0185 A[Catch: all -> 0x01de, Exception -> 0x01e2, TRY_LEAVE, TryCatch #11 {Exception -> 0x01e2, all -> 0x01de, blocks: (B:342:0x014c, B:344:0x0150, B:348:0x0163, B:349:0x0177, B:352:0x0185, B:341:0x0149), top: B:448:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:412:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x027b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0264 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:448:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:460:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Throwable, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(org.json.JSONObject r48) {
        /*
            Method dump skipped, instructions count: 645
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.v.a(org.json.JSONObject):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:270:0x0067, code lost:
        if (r5[0].length() <= 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0089, code lost:
        if (r5[2].length() <= 0) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0112, code lost:
        if (r5[0].length() <= 0) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:301:0x00f4 A[Catch: all -> 0x016d, Exception -> 0x016f, TRY_LEAVE, TryCatch #16 {Exception -> 0x016f, all -> 0x016d, blocks: (B:292:0x00b2, B:294:0x00c0, B:296:0x00c6, B:297:0x00e4, B:301:0x00f4, B:319:0x0142, B:326:0x015c), top: B:371:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:388:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(org.json.JSONObject r26, bykvm_19do.bykvm_19do.bykvm_19do.z r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.v.a(org.json.JSONObject, bykvm_19do.bykvm_19do.bykvm_19do.z, boolean):boolean");
    }
}
