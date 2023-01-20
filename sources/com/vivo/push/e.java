package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.imsdk.BaseConstants;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.t;
import com.vivo.push.util.w;
import com.vivo.push.util.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class e {
    private static volatile e a;

    /* renamed from: h  reason: collision with root package name */
    private Context f8128h;

    /* renamed from: j  reason: collision with root package name */
    private com.vivo.push.util.b f8130j;

    /* renamed from: k  reason: collision with root package name */
    private String f8131k;

    /* renamed from: l  reason: collision with root package name */
    private String f8132l;
    private Boolean o;
    private Long p;
    private boolean q;
    private int s;
    private long b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f8123c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f8124d = -1;

    /* renamed from: e  reason: collision with root package name */
    private long f8125e = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f8126f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f8127g = -1;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8129i = true;

    /* renamed from: m  reason: collision with root package name */
    private SparseArray<a> f8133m = new SparseArray<>();
    private int n = 0;
    private IPushClientFactory r = new d();

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.f8132l = null;
        this.f8130j.b("APP_ALIAS");
    }

    private boolean n() {
        if (this.o == null) {
            this.o = Boolean.valueOf(l() >= 1230 && z.d(this.f8128h));
        }
        return this.o.booleanValue();
    }

    public final boolean d() {
        if (this.f8128h == null) {
            com.vivo.push.util.p.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(n());
        this.o = valueOf;
        return valueOf.booleanValue();
    }

    public final boolean e() {
        return this.q;
    }

    public final String f() {
        if (!TextUtils.isEmpty(this.f8131k)) {
            return this.f8131k;
        }
        com.vivo.push.util.b bVar = this.f8130j;
        String b = bVar != null ? bVar.b("APP_TOKEN", (String) null) : "";
        c(b);
        return b;
    }

    public final boolean g() {
        return this.f8129i;
    }

    public final Context h() {
        return this.f8128h;
    }

    public final void i() {
        this.f8130j.a();
    }

    public final String j() {
        return this.f8132l;
    }

    public final int k() {
        return this.s;
    }

    public final long l() {
        Context context = this.f8128h;
        if (context == null) {
            return -1L;
        }
        if (this.p == null) {
            this.p = Long.valueOf(z.a(context));
        }
        return this.p.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        m.a(new k(this, str));
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    public final void b() {
        Context context = this.f8128h;
        if (context != null) {
            z.b(context);
        }
    }

    public final List<String> c() {
        String b = this.f8130j.b("APP_TAGS", (String) null);
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            this.f8130j.b("APP_TAGS");
            arrayList.clear();
            com.vivo.push.util.p.d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(b)) {
            return arrayList;
        }
        Iterator<String> keys = new JSONObject(b).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private IPushActionListener a;
        private com.vivo.push.b.c b;

        /* renamed from: c  reason: collision with root package name */
        private IPushActionListener f8134c;

        /* renamed from: d  reason: collision with root package name */
        private Runnable f8135d;

        /* renamed from: e  reason: collision with root package name */
        private Object[] f8136e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.b = cVar;
            this.a = iPushActionListener;
        }

        public final void a(int i2, Object... objArr) {
            this.f8136e = objArr;
            IPushActionListener iPushActionListener = this.f8134c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i2);
            }
            IPushActionListener iPushActionListener2 = this.a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i2);
            }
        }

        public final Object[] b() {
            return this.f8136e;
        }

        public final void a(Runnable runnable) {
            this.f8135d = runnable;
        }

        public final void a() {
            Runnable runnable = this.f8135d;
            if (runnable == null) {
                com.vivo.push.util.p.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.f8134c = iPushActionListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a d(String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                a aVar = this.f8133m.get(parseInt);
                this.f8133m.delete(parseInt);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String b = this.f8130j.b("APP_TAGS", (String) null);
            if (TextUtils.isEmpty(b)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(b);
            }
            for (String str : list) {
                jSONObject.remove(str);
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.f8130j.b("APP_TAGS");
            } else {
                this.f8130j.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f8130j.b("APP_TAGS");
        }
    }

    public final synchronized void a(Context context) {
        if (this.f8128h == null) {
            this.f8128h = ContextDelegate.getContext(context);
            this.q = t.c(context, context.getPackageName());
            w.b().a(this.f8128h);
            a(new com.vivo.push.b.g());
            com.vivo.push.util.b bVar = new com.vivo.push.util.b();
            this.f8130j = bVar;
            bVar.a(this.f8128h, "com.vivo.push_preferences.appconfig_v1");
            this.f8131k = f();
            this.f8132l = this.f8130j.b("APP_ALIAS", (String) null);
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.f8132l)) {
            m();
        }
    }

    private void c(String str) {
        m.c(new f(this, str));
    }

    public final void a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String b = this.f8130j.b("APP_TAGS", (String) null);
            if (TextUtils.isEmpty(b)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(b);
            }
            for (String str : list) {
                jSONObject.put(str, System.currentTimeMillis());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.f8130j.b("APP_TAGS");
            } else {
                this.f8130j.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f8130j.b("APP_TAGS");
        }
    }

    public final void b(IPushActionListener iPushActionListener) {
        if (this.f8128h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if ("".equals(this.f8131k)) {
            iPushActionListener.onStateChanged(0);
        } else if (!a(this.f8123c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f8123c = SystemClock.elapsedRealtime();
            String packageName = this.f8128h.getPackageName();
            a aVar = null;
            if (this.f8128h != null) {
                com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, packageName);
                bVar.d();
                bVar.e();
                bVar.g();
                bVar.a(100);
                if (this.q) {
                    if (n()) {
                        aVar = new a(bVar, iPushActionListener);
                        String a2 = a(aVar);
                        bVar.b(a2);
                        aVar.a(new j(this, bVar, a2));
                    } else if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                    }
                } else if (bVar.a(this.f8128h) == 2) {
                    aVar = a(bVar, iPushActionListener);
                } else {
                    a(bVar);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            if (aVar == null) {
                return;
            }
            aVar.a(new i(this));
            aVar.a();
        }
    }

    public final void a(String str) {
        this.f8131k = str;
        this.f8130j.a("APP_TOKEN", str);
    }

    public final void a(boolean z) {
        this.f8129i = z;
    }

    public final void a(IPushActionListener iPushActionListener) {
        if (this.f8128h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        String f2 = f();
        this.f8131k = f2;
        if (!TextUtils.isEmpty(f2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else if (!a(this.b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.b = SystemClock.elapsedRealtime();
            String packageName = this.f8128h.getPackageName();
            a aVar = null;
            if (this.f8128h != null) {
                com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
                bVar.g();
                bVar.d();
                bVar.e();
                bVar.a(100);
                if (this.q) {
                    if (n()) {
                        aVar = a(bVar, iPushActionListener);
                    } else if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                    }
                } else if (bVar.a(this.f8128h) == 2) {
                    aVar = a(bVar, iPushActionListener);
                } else {
                    a(bVar);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            if (aVar == null) {
                return;
            }
            aVar.a(new g(this, aVar));
            aVar.a();
        }
    }

    public final void b(String str, IPushActionListener iPushActionListener) {
        if (this.f8128h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (TextUtils.isEmpty(this.f8132l)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.f8128h.getPackageName(), arrayList);
            aVar.a(100);
            if (this.q) {
                if (!n()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f8125e)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f8125e = SystemClock.elapsedRealtime();
                    String a2 = a(new a(aVar, iPushActionListener));
                    aVar.b(a2);
                    if (TextUtils.isEmpty(this.f8131k)) {
                        a(a2, 30001);
                        return;
                    } else if (TextUtils.isEmpty(str)) {
                        a(a2, BaseConstants.ERR_SVR_FRIENDSHIP_INVALID_SDKAPPID);
                        return;
                    } else if (str.length() > 70) {
                        a(a2, BaseConstants.ERR_SVR_FRIENDSHIP_ACCOUNT_NOT_FOUND);
                        return;
                    } else {
                        a(aVar);
                        e(a2);
                        return;
                    }
                }
            }
            a(aVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        a aVar = new a(bVar, iPushActionListener);
        String a2 = a(aVar);
        bVar.b(a2);
        aVar.a(new h(this, bVar, a2));
        return aVar;
    }

    public final void a(String str, int i2, Object... objArr) {
        a d2 = d(str);
        if (d2 != null) {
            d2.a(i2, objArr);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyApp token is null");
        }
    }

    public final void a(String str, IPushActionListener iPushActionListener) {
        if (this.f8128h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (!TextUtils.isEmpty(this.f8132l) && this.f8132l.equals(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.f8128h.getPackageName(), arrayList);
            aVar.a(100);
            if (this.q) {
                if (!n()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f8124d)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f8124d = SystemClock.elapsedRealtime();
                    String a2 = a(new a(aVar, iPushActionListener));
                    aVar.b(a2);
                    if (TextUtils.isEmpty(this.f8131k)) {
                        a(a2, 30001);
                        return;
                    } else if (TextUtils.isEmpty(str)) {
                        a(a2, BaseConstants.ERR_SVR_FRIENDSHIP_INVALID_SDKAPPID);
                        return;
                    } else if (str.length() > 70) {
                        a(a2, BaseConstants.ERR_SVR_FRIENDSHIP_ACCOUNT_NOT_FOUND);
                        return;
                    } else {
                        a(aVar);
                        e(a2);
                        return;
                    }
                }
            }
            a(aVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    public final void b(String str) {
        this.f8132l = str;
        this.f8130j.a("APP_ALIAS", str);
    }

    public final void b(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.f8128h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, context.getPackageName(), arrayList);
        zVar.a(500);
        if (this.q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (!a(this.f8127g)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            } else {
                this.f8127g = SystemClock.elapsedRealtime();
                String a2 = a(new a(zVar, iPushActionListener));
                zVar.b(a2);
                if (TextUtils.isEmpty(this.f8131k)) {
                    a(a2, 20001);
                    return;
                } else if (arrayList.size() < 0) {
                    a(a2, BaseConstants.ERR_SVR_MSG_INTERNAL_AUTH_FAILED);
                    return;
                } else if (arrayList.size() > 500) {
                    a(a2, BaseConstants.ERR_SVR_MSG_NET_ERROR);
                    return;
                } else {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().length() > 70) {
                            a(a2, BaseConstants.ERR_SVR_MSG_INVALID_ID);
                            return;
                        }
                    }
                    a(zVar);
                    e(a2);
                    return;
                }
            }
        }
        a(zVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    private static boolean a(long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j2 == -1 || elapsedRealtime <= j2 || elapsedRealtime >= j2 + 2000;
    }

    public final void a(String str, int i2) {
        a d2 = d(str);
        if (d2 != null) {
            d2.a(i2, new Object[0]);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i2;
        this.f8133m.put(this.n, aVar);
        i2 = this.n;
        this.n = i2 + 1;
        return Integer.toString(i2);
    }

    public final void a(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.f8128h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, context.getPackageName(), arrayList);
        zVar.a(500);
        if (this.q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (!a(this.f8126f)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            } else {
                this.f8126f = SystemClock.elapsedRealtime();
                String a2 = a(new a(zVar, iPushActionListener));
                zVar.b(a2);
                if (TextUtils.isEmpty(this.f8131k)) {
                    a(a2, 20001);
                    return;
                } else if (arrayList.size() < 0) {
                    a(a2, BaseConstants.ERR_SVR_MSG_INTERNAL_AUTH_FAILED);
                    return;
                } else {
                    if (arrayList.size() + c().size() > 500) {
                        a(a2, BaseConstants.ERR_SVR_MSG_NET_ERROR);
                        return;
                    }
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().length() > 70) {
                            a(a2, BaseConstants.ERR_SVR_MSG_INVALID_ID);
                            return;
                        }
                    }
                    a(zVar);
                    e(a2);
                    return;
                }
            }
        }
        a(zVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        o createReceiverCommand = this.r.createReceiverCommand(intent);
        Context context = a().f8128h;
        if (createReceiverCommand == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        com.vivo.push.d.z createReceiveTask = this.r.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
                return;
            }
            return;
        }
        if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.p.a(context, "[接收指令]".concat(String.valueOf(createReceiverCommand)));
        }
        createReceiveTask.a(pushMessageCallback);
        m.a((l) createReceiveTask);
    }

    public final void a(o oVar) {
        Context context = a().f8128h;
        if (oVar == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        l createTask = this.r.createTask(oVar);
        if (createTask == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(oVar)));
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令" + oVar + "任务空！");
                return;
            }
            return;
        }
        com.vivo.push.util.p.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(oVar)));
        m.a(createTask);
    }
}
