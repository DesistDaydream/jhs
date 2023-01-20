package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.bc;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class t {
    private final SimpleDateFormat a;
    private final r b;

    /* loaded from: classes3.dex */
    public static class a {
        private static final t a = new t((byte) 0);
    }

    /* loaded from: classes3.dex */
    public static class b {
        private String a;
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private String f6788c;

        public final long b() {
            return this.b;
        }

        public final String c() {
            return this.f6788c;
        }

        public final String toString() {
            return "SLAData{uuid='" + this.a + "', time=" + this.b + ", data='" + this.f6788c + "'}";
        }

        public final String a() {
            return this.a;
        }

        public final void b(String str) {
            this.f6788c = str;
        }

        public final void a(String str) {
            this.a = str;
        }

        public final void a(long j2) {
            this.b = j2;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        private String a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private long f6789c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6790d;

        /* renamed from: e  reason: collision with root package name */
        private long f6791e;

        /* renamed from: f  reason: collision with root package name */
        private String f6792f;

        /* renamed from: g  reason: collision with root package name */
        private String f6793g;

        public c(String str, String str2, long j2, boolean z, long j3, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.f6789c = j2;
            this.f6790d = z;
            this.f6791e = j3;
            this.f6792f = str3;
            this.f6793g = str4;
        }

        public final String b() {
            return this.b;
        }

        public final long c() {
            return this.f6789c;
        }

        public final boolean d() {
            return this.f6790d;
        }

        public final long e() {
            return this.f6791e;
        }

        public final String f() {
            return this.f6792f;
        }

        public final String g() {
            return this.f6793g;
        }

        public final String a() {
            return this.a;
        }

        public c() {
        }
    }

    public /* synthetic */ t(byte b2) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<b> list) {
        if (list != null && !list.isEmpty()) {
            y.c("sla batch report list size:%s", Integer.valueOf(list.size()));
            if (list.size() > 30) {
                list = list.subList(0, 29);
            }
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                arrayList.add(bVar.c());
            }
            Pair<Integer, String> a2 = this.b.a(arrayList);
            y.c("sla batch report result, rspCode:%s rspMsg:%s", a2.first, a2.second);
            if (((Integer) a2.first).intValue() == 200) {
                e(list);
                return;
            }
            return;
        }
        y.c("sla batch report data is empty", new Object[0]);
    }

    private static void d(List<b> list) {
        for (b bVar : list) {
            y.c("sla save id:%s time:%s msg:%s", bVar.a(), Long.valueOf(bVar.b()), bVar.c());
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", bVar.a());
                contentValues.put("_tm", Long.valueOf(bVar.b()));
                contentValues.put("_dt", bVar.c());
                o.a().a("t_sla", contentValues, (n) null, true);
            } catch (Throwable th) {
                y.b(th);
            }
        }
    }

    private void e(List<b> list) {
        if (list != null && !list.isEmpty()) {
            y.c("sla batch delete list size:%s", Integer.valueOf(list.size()));
            try {
                String str = "_id in (" + a(Constants.ACCEPT_TIME_SEPARATOR_SP, list) + ")";
                y.c("sla batch delete where:%s", str);
                o.a().a("t_sla", str, (String[]) null, (n) null, true);
                return;
            } catch (Throwable th) {
                y.b(th);
                return;
            }
        }
        y.c("sla batch delete list is null", new Object[0]);
    }

    public final void b() {
        List<b> c2 = c();
        if (c2 != null && !c2.isEmpty()) {
            y.c("sla load local data list size:%s", Integer.valueOf(c2.size()));
            Iterator<b> it = c2.iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                b next = it.next();
                if (next.b() < ab.b() - bc.f1469d) {
                    y.c("sla local data is expired:%s", next.c());
                    arrayList.add(next);
                    it.remove();
                }
            }
            e(arrayList);
            b(c2);
            return;
        }
        y.c("sla local data is null", new Object[0]);
    }

    private t() {
        this.a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.b = new r();
    }

    public static t a() {
        return a.a;
    }

    public final void a(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.b())) {
            y.c("sla report single event", new Object[0]);
            a(Collections.singletonList(cVar));
            return;
        }
        y.d("sla report event is null", new Object[0]);
    }

    public final void a(List<c> list) {
        if (list != null && !list.isEmpty()) {
            y.c("sla batch report event size:%s", Integer.valueOf(list.size()));
            ArrayList arrayList = new ArrayList();
            for (c cVar : list) {
                b bVar = null;
                if (cVar == null || TextUtils.isEmpty(cVar.b())) {
                    y.d("sla convert event is null", new Object[0]);
                } else {
                    com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
                    if (b2 == null) {
                        y.d("sla convert failed because ComInfoManager is null", new Object[0]);
                    } else {
                        String str = "&app_version=" + b2.f6525i + "&app_name=" + b2.f6526j + "&app_bundle_id=" + b2.f6519c + "&client_type=android&user_id=" + b2.g() + "&sdk_version=" + b2.f6522f + "&event_code=" + cVar.b() + "&event_result=" + (cVar.d() ? 1 : 0) + "&event_time=" + this.a.format(new Date(cVar.c())) + "&event_cost=" + cVar.e() + "&device_id=" + b2.k() + "&debug=" + (b2.t ? 1 : 0) + "&param_0=" + cVar.f() + "&param_1=" + cVar.a() + "&param_2=ext&param_4=" + b2.f();
                        if (!TextUtils.isEmpty(cVar.f6793g)) {
                            str = str + "&param_3=" + cVar.f6793g;
                        }
                        y.c("sla convert eventId:%s eventType:%s, eventTime:%s success:%s cost:%s from:%s uploadMsg:", cVar.a(), cVar.b(), Long.valueOf(cVar.c()), Boolean.valueOf(cVar.d()), Long.valueOf(cVar.e()), cVar.f(), cVar.g());
                        b bVar2 = new b();
                        bVar2.a(cVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + cVar.b());
                        bVar2.a(cVar.c());
                        bVar2.b(str);
                        bVar = bVar2;
                    }
                }
                if (bVar != null) {
                    arrayList.add(bVar);
                }
            }
            d(arrayList);
            b(arrayList);
            return;
        }
        y.d("sla batch report event is null", new Object[0]);
    }

    private static List<b> c() {
        Cursor a2 = o.a().a(false, "t_sla", new String[]{"_id", "_tm", "_dt"}, (String) null, (String[]) null, (String) null, (String) null, "_tm", "30", (n) null, true);
        if (a2 == null) {
            return null;
        }
        if (a2.getCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (a2.moveToNext()) {
            try {
                b bVar = new b();
                bVar.a(a2.getString(a2.getColumnIndex("_id")));
                bVar.a(a2.getLong(a2.getColumnIndex("_tm")));
                bVar.b(a2.getString(a2.getColumnIndex("_dt")));
                y.c(bVar.toString(), new Object[0]);
                arrayList.add(bVar);
            } finally {
                try {
                    return arrayList;
                } finally {
                }
            }
        }
        return arrayList;
    }

    private void b(final List<b> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            x.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.t.1
                @Override // java.lang.Runnable
                public final void run() {
                    t.this.c(list);
                }
            });
        } else {
            c(list);
        }
    }

    private static String a(String str, Iterable<b> iterable) {
        Iterator<b> it = iterable.iterator();
        if (it.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(it.next().a);
            sb.append("'");
            while (it.hasNext()) {
                sb.append(str);
                sb.append("'");
                sb.append(it.next().a);
                sb.append("'");
            }
            return sb.toString();
        }
        return "";
    }
}
