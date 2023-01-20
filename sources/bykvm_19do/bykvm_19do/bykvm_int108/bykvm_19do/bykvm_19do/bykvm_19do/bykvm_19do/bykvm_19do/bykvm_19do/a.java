package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements c {
    private final Context a;
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f1062c = new ArrayList();

    public a(Context context, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar) {
        this.a = context;
        this.b = aVar;
        if (aVar == null) {
            this.b = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a.c();
        }
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }

    private static String a(String str, List<?> list, int i2, boolean z) {
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i2, 1000);
        int size = list.size();
        int i3 = size % min == 0 ? size / min : (size / min) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * min;
            String a = a(TextUtils.join("','", list.subList(i5, Math.min(i5 + min, size))), "");
            if (i4 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(a);
            sb.append("')");
        }
        String sb2 = sb.toString();
        return a(sb2, str + str2 + "('')");
    }

    public static String f() {
        return "CREATE TABLE IF NOT EXISTS " + j.l().e().a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public Context a() {
        return this.a;
    }

    public List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> a(int i2, String str) {
        String str2;
        LinkedList linkedList;
        synchronized (this) {
            long a = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a.a(i2, a());
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("" + d() + " query db max :" + a + " limit:" + i2);
            if (a <= 0 || TextUtils.isEmpty(str)) {
                str2 = null;
            } else {
                str2 = str + " DESC limit " + a;
            }
            String str3 = str2;
            linkedList = new LinkedList();
            this.f1062c.clear();
            Cursor a2 = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c.a(a(), d(), new String[]{"id", "value", "encrypt"}, null, null, null, null, str3);
            if (a2 != null) {
                while (a2.moveToNext()) {
                    try {
                        String string = a2.getString(a2.getColumnIndex("id"));
                        String string2 = a2.getString(a2.getColumnIndex("value"));
                        if (a2.getInt(a2.getColumnIndex("encrypt")) == 1) {
                            string2 = j.l().b().a(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("log_show_query : value is null");
                            this.f1062c.add(string);
                        } else {
                            JSONObject jSONObject = new JSONObject(string2);
                            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a aVar = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a(string, jSONObject);
                            aVar.a(b());
                            aVar.b(c());
                            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(jSONObject, aVar);
                            linkedList.add(aVar);
                        }
                    } catch (Throwable th) {
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b(th.getMessage());
                    }
                }
                if (a2 != null) {
                    try {
                        a2.close();
                        if (!this.f1062c.isEmpty()) {
                            b(this.f1062c);
                            this.f1062c.clear();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("" + d() + " query db actually size :" + linkedList.size());
        }
        return linkedList;
    }

    public List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> a(String str) {
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> arrayList;
        synchronized (this) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar = this.b;
            arrayList = aVar == null ? new ArrayList<>() : a(aVar.a(), str);
        }
        return arrayList;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        synchronized (this) {
            JSONObject d2 = aVar.d();
            if (d2 == null || TextUtils.isEmpty(aVar.i())) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("log_show_save", "save error");
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", aVar.i());
                String b = j.l().b().b(d2.toString());
                if (!TextUtils.isEmpty(b)) {
                    contentValues.put("value", b);
                    contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("retry", (Integer) 0);
                    contentValues.put("encrypt", (Integer) 1);
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c.a(a(), d(), contentValues);
                }
            }
        }
    }

    public void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list) {
        synchronized (this) {
            if (list != null) {
                if (list.size() != 0) {
                    LinkedList linkedList = new LinkedList();
                    for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : list) {
                        linkedList.add(aVar.i());
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.b(aVar);
                    }
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c.a(a(), "DELETE FROM " + d() + " WHERE " + a("id", linkedList, 1000, true));
                }
            }
        }
    }

    public boolean a(int i2) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.b != null) {
                int e2 = e();
                int b = this.b.b();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("" + d() + " check dbCount:" + e2 + " MaxCacheCount:" + b + " message:" + i2);
                if (!bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.d() || (i2 != 1 && i2 != 2) ? e2 >= b : e2 >= 1) {
                    z = true;
                }
            }
        }
        return z;
    }

    public byte b() {
        return (byte) 0;
    }

    public void b(List<String> list) {
        synchronized (this) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("adevent repo delete: " + list.size());
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c.a(a(), "DELETE FROM " + d() + " WHERE " + a("id", list, 1000, true));
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.a0(), list.size());
        }
    }

    public byte c() {
        return (byte) 2;
    }

    public String d() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e e2 = j.l().e();
        if (e2 != null) {
            return e2.a();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r0 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
        if (r0 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int e() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            r1 = 0
            android.content.Context r2 = r10.a()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.lang.String r3 = r10.d()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.lang.String r4 = "count(1)"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r0 = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            if (r0 == 0) goto L28
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            int r1 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            goto L28
        L24:
            r1 = move-exception
            goto L2b
        L26:
            goto L33
        L28:
            if (r0 == 0) goto L3b
            goto L35
        L2b:
            if (r0 == 0) goto L30
            r0.close()     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L31
        L30:
            throw r1     // Catch: java.lang.Throwable -> L31
        L31:
            r0 = move-exception
            goto L39
        L33:
            if (r0 == 0) goto L3b
        L35:
            r0.close()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L3b
            goto L3b
        L39:
            monitor-exit(r10)
            throw r0
        L3b:
            monitor-exit(r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.e():int");
    }
}
