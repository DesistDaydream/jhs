package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.be;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class e {
    public static final long a = 86400000;
    public static e b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final String f7496c = "umeng_it.cache";

    /* renamed from: j  reason: collision with root package name */
    private static Object f7497j = new Object();

    /* renamed from: d  reason: collision with root package name */
    private File f7498d;

    /* renamed from: f  reason: collision with root package name */
    private long f7500f;

    /* renamed from: i  reason: collision with root package name */
    private a f7503i;

    /* renamed from: e  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.c f7499e = null;

    /* renamed from: h  reason: collision with root package name */
    private Set<com.umeng.commonsdk.statistics.idtracking.a> f7502h = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private long f7501g = 86400000;

    /* loaded from: classes3.dex */
    public static class a {
        private Context a;
        private Set<String> b = new HashSet();

        public a(Context context) {
            this.a = context;
        }

        public synchronized boolean a(String str) {
            return !this.b.contains(str);
        }

        public synchronized void b(String str) {
            this.b.add(str);
        }

        public void c(String str) {
            this.b.remove(str);
        }

        public synchronized void a() {
            if (!this.b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String str : this.b) {
                    sb.append(str);
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.b.add(str);
                    }
                }
            }
        }
    }

    public e(Context context) {
        this.f7503i = null;
        this.f7498d = new File(context.getFilesDir(), f7496c);
        a aVar = new a(context);
        this.f7503i = aVar;
        aVar.b();
    }

    public static synchronized void a() {
        synchronized (e.class) {
            e eVar = b;
            if (eVar != null) {
                eVar.e();
                b = null;
            }
        }
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f7502h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    hashMap.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(hashMap);
        synchronized (this) {
            this.f7499e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (f7497j) {
            if (this.f7498d.exists()) {
                try {
                    fileInputStream = new FileInputStream(this.f7498d);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
                try {
                    try {
                        byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                        new ay().a(cVar, readStreamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return cVar;
                    } catch (Throwable th3) {
                        th = th3;
                        HelperUtils.safeClose(fileInputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    HelperUtils.safeClose(fileInputStream);
                    return null;
                }
            }
            return null;
        }
    }

    public synchronized void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f7500f >= this.f7501g) {
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f7502h) {
                if (aVar.c() && aVar.a()) {
                    z = true;
                    if (!aVar.c()) {
                        this.f7503i.b(aVar.b());
                    }
                }
            }
            if (z) {
                h();
                this.f7503i.a();
                g();
            }
            this.f7500f = currentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.f7499e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        if (b == null) {
            return;
        }
        boolean z = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f7502h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z = true;
            }
        }
        if (z) {
            this.f7499e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c i2 = i();
        if (i2 == null) {
            return;
        }
        a(i2);
        ArrayList<com.umeng.commonsdk.statistics.idtracking.a> arrayList = new ArrayList(this.f7502h.size());
        synchronized (this) {
            this.f7499e = i2;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f7502h) {
                aVar.a(this.f7499e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            for (com.umeng.commonsdk.statistics.idtracking.a aVar2 : arrayList) {
                this.f7502h.remove(aVar2);
            }
            h();
        }
    }

    public synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = this.f7499e;
        if (cVar != null) {
            b(cVar);
        }
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (b == null) {
                e eVar2 = new e(context);
                b = eVar2;
                eVar2.a(new f(context));
                b.a(new b(context));
                b.a(new j(context));
                b.a(new d(context));
                b.a(new c(context));
                b.a(new g(context));
                b.a(new i());
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                    b.a(new h(context));
                }
                b.f();
            }
            eVar = b;
        }
        return eVar;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a2;
        synchronized (f7497j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        a2 = new be().a(cVar);
                    }
                    if (a2 != null) {
                        HelperUtils.writeFile(this.f7498d, a2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.f7503i.a(aVar.b())) {
            return this.f7502h.add(aVar);
        }
        if (AnalyticsConstants.UM_DEBUG) {
            MLog.w("invalid domain: " + aVar.b());
            return false;
        }
        return false;
    }

    public void a(long j2) {
        this.f7501g = j2;
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.a) == null) {
            return;
        }
        if (map.containsKey("mac") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f7616h)) {
            cVar.a.remove("mac");
        }
        if (cVar.a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f7615g)) {
            cVar.a.remove("imei");
        }
        if (cVar.a.containsKey("android_id") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f7617i)) {
            cVar.a.remove("android_id");
        }
        if (cVar.a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f7618j)) {
            cVar.a.remove("serial");
        }
        if (cVar.a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.d.w)) {
            cVar.a.remove("idfa");
        }
        if (!cVar.a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.a.remove("oaid");
    }
}
