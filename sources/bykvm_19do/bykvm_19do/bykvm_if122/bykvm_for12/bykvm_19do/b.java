package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.w;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b implements a<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> {
    private final Context a;
    private final h b;

    /* renamed from: c  reason: collision with root package name */
    private final c0 f930c = c0.a("tt_adevent", a());

    public b(Context context) {
        this.a = context;
        this.b = h.a(context);
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }

    private static String a(String str, List<?> list, int i2, boolean z) {
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i2, 1000);
        int size = list.size();
        int i3 = size % min;
        Logger.d("", "len=" + size + ",size=" + i3);
        int i4 = i3 == 0 ? size / min : (size / min) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 * min;
            String a = a(TextUtils.join("','", list.subList(i6, Math.min(i6 + min, size))), "");
            if (i5 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(a);
            sb.append("')");
        }
        String sb2 = sb.toString();
        String a2 = a(sb2, str + str2 + "('')");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("sql=");
        sb3.append(a2);
        Logger.d("", sb3.toString());
        return a2;
    }

    public static String b() {
        return "ALTER TABLE adevent_applog ADD COLUMN encrypt INTEGER default 0";
    }

    private void b(int i2, int i3, long j2) {
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            Logger.e("AdEventThread", "客户端容灾状态下事件过期时间(7天)：" + j2 + "，成功删除日志条数：delete count=" + this.b.a().a(c(i2), "gen_time < ? AND retry >?", new String[]{(currentTimeMillis - j2) + "", i3 + ""}));
        }
    }

    @VisibleForTesting
    private void b(int i2, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> list) {
        synchronized (this) {
            LinkedList linkedList = new LinkedList();
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a aVar : list) {
                linkedList.add(aVar.a);
            }
            this.b.a().a("UPDATE " + c(i2) + " SET retry = retry+1 WHERE " + a("id", (List<?>) linkedList, 1000, true));
        }
    }

    public static String c() {
        return "ALTER TABLE adevent ADD COLUMN encrypt INTEGER default 0";
    }

    private String c(int i2) {
        return (i2 != 1 && i2 == 2) ? "adevent_applog" : "adevent";
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    public static String e() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    public Context a() {
        Context context = this.a;
        return context == null ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() : context;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a A[Catch: all -> 0x007e, LOOP:0: B:10:0x004a->B:31:0x004a, LOOP_START, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x001f, B:17:0x007a, B:10:0x004a, B:12:0x0050, B:14:0x0074), top: B:27:0x0003 }] */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> a(int r10, int r11, java.lang.String r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            if (r11 <= 0) goto L1e
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L87
            if (r0 != 0) goto L1e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L87
            r0.<init>()     // Catch: java.lang.Throwable -> L87
            r0.append(r12)     // Catch: java.lang.Throwable -> L87
            java.lang.String r12 = " DESC limit "
            r0.append(r12)     // Catch: java.lang.Throwable -> L87
            r0.append(r11)     // Catch: java.lang.Throwable -> L87
            java.lang.String r11 = r0.toString()     // Catch: java.lang.Throwable -> L87
            goto L1f
        L1e:
            r11 = 0
        L1f:
            r7 = r11
            java.util.LinkedList r11 = new java.util.LinkedList     // Catch: java.lang.Throwable -> L87
            r11.<init>()     // Catch: java.lang.Throwable -> L87
            android.content.Context r12 = r9.a()     // Catch: java.lang.Throwable -> L87
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.h r12 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.h.a(r12)     // Catch: java.lang.Throwable -> L87
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.i$c r0 = r12.a()     // Catch: java.lang.Throwable -> L87
            java.lang.String r1 = r9.c(r10)     // Catch: java.lang.Throwable -> L87
            java.lang.String r10 = "id"
            java.lang.String r12 = "value"
            java.lang.String r2 = "encrypt"
            java.lang.String[] r2 = new java.lang.String[]{r10, r12, r2}     // Catch: java.lang.Throwable -> L87
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            android.database.Cursor r10 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L87
            if (r10 == 0) goto L85
        L4a:
            boolean r12 = r10.moveToNext()     // Catch: java.lang.Throwable -> L7e
            if (r12 == 0) goto L78
            java.lang.String r12 = "id"
            int r12 = r10.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r12 = r10.getString(r12)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r0 = "value"
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r1 = "encrypt"
            int r1 = r10.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L7e
            int r1 = r10.getInt(r1)     // Catch: java.lang.Throwable -> L7e
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a r12 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a.a(r12, r0, r1)     // Catch: java.lang.Throwable -> L7e
            if (r12 == 0) goto L4a
            r11.add(r12)     // Catch: java.lang.Throwable -> L7e
            goto L4a
        L78:
            if (r10 == 0) goto L85
            r10.close()     // Catch: java.lang.Throwable -> L87
            goto L85
        L7e:
            r11 = move-exception
            if (r10 == 0) goto L84
            r10.close()     // Catch: java.lang.Throwable -> L87
        L84:
            throw r11     // Catch: java.lang.Throwable -> L87
        L85:
            monitor-exit(r9)
            return r11
        L87:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.b.a(int, int, java.lang.String):java.util.List");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a
    public void a(int i2, int i3) {
        c0 c0Var;
        String str;
        if (i2 == 1) {
            c0Var = this.f930c;
            str = "serverbusy_retrycount";
        } else if (i2 != 2) {
            return;
        } else {
            c0Var = this.f930c;
            str = "applog_serverbusy_retrycount";
        }
        c0Var.b(str, i3);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a
    public void a(int i2, int i3, long j2) {
        synchronized (this) {
            b(i2, i3, j2);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a
    public void a(int i2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a aVar) {
        synchronized (this) {
            if (aVar != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", aVar.a);
                JSONObject jSONObject = aVar.b;
                contentValues.put("value", jSONObject != null ? jSONObject.toString() : "");
                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("retry", (Integer) 0);
                this.b.a().a(c(i2), (String) null, contentValues);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a
    public void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> list) {
        synchronized (this) {
            if (!w.a(list)) {
                LinkedList linkedList = new LinkedList();
                for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a aVar : list) {
                    linkedList.add(aVar.a);
                }
                this.b.a().a("DELETE FROM " + c(i2) + " WHERE " + a("id", (List<?>) linkedList, 1000, true));
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a
    public void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> list, int i3, long j2) {
        synchronized (this) {
            if (!w.a(list)) {
                try {
                    b(i2, list);
                    b(i2, i3, j2);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a
    public void a(int i2, boolean z) {
        c0 c0Var;
        String str;
        if (i2 == 1) {
            c0Var = this.f930c;
            str = "serverbusy_flag";
        } else if (i2 != 2) {
            return;
        } else {
            c0Var = this.f930c;
            str = "applog_serverbusy_flag";
        }
        c0Var.b(str, z);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a
    public boolean a(int i2) {
        c0 c0Var;
        String str;
        if (i2 == 1) {
            c0Var = this.f930c;
            str = "serverbusy_flag";
        } else if (i2 != 2) {
            return false;
        } else {
            c0Var = this.f930c;
            str = "applog_serverbusy_flag";
        }
        return c0Var.a(str, false);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a
    public int b(int i2) {
        c0 c0Var;
        String str;
        if (i2 == 1) {
            c0Var = this.f930c;
            str = "serverbusy_retrycount";
        } else if (i2 != 2) {
            return 0;
        } else {
            c0Var = this.f930c;
            str = "applog_serverbusy_retrycount";
        }
        return c0Var.a(str, 0);
    }
}
