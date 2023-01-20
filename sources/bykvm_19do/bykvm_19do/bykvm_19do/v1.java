package bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.mapplog.collector.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes.dex */
public class v1 implements Handler.Callback, Comparator<u> {

    /* renamed from: l  reason: collision with root package name */
    private static v1 f176l;
    private k1 a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    public Application f177c;

    /* renamed from: d  reason: collision with root package name */
    private j2 f178d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<u> f179e = new ArrayList<>(32);

    /* renamed from: f  reason: collision with root package name */
    private v f180f;

    /* renamed from: g  reason: collision with root package name */
    private k2 f181g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f182h;

    /* renamed from: i  reason: collision with root package name */
    private b2 f183i;

    /* renamed from: j  reason: collision with root package name */
    private e.c.a.b.a f184j;

    /* renamed from: k  reason: collision with root package name */
    private Handler f185k;

    private v1() {
    }

    public static void a(u uVar) {
        int size;
        Handler handler;
        v1 v1Var = f176l;
        if (v1Var == null) {
            l0.b("Init comes First!", null);
            d2.a(uVar);
            return;
        }
        if (uVar.a == 0) {
            l0.a(null);
        }
        if (uVar instanceof c0) {
            ((c0) uVar).f92k = v1Var.f178d.A();
        }
        synchronized (v1Var.f179e) {
            size = v1Var.f179e.size();
            v1Var.f179e.add(uVar);
        }
        if (size % 10 != 0 || (handler = v1Var.f185k) == null) {
            return;
        }
        handler.removeMessages(4);
        v1Var.f185k.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void a(String[] strArr) {
        v1 v1Var = f176l;
        if (v1Var == null) {
            l0.a(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = v1Var.f185k;
        if (handler != null) {
            handler.removeMessages(4);
            v1Var.f185k.obtainMessage(5, strArr).sendToTarget();
        }
    }

    private void b(String[] strArr) {
        ArrayList<u> arrayList;
        synchronized (this.f179e) {
            arrayList = (ArrayList) this.f179e.clone();
            this.f179e.clear();
        }
        int i2 = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(u.a(str));
            }
        }
        boolean a = this.f178d.a(arrayList);
        if (arrayList.size() > 0) {
            if (!this.f178d.J()) {
                Intent intent = new Intent(this.f177c, Collector.class);
                int size = arrayList.size();
                String[] strArr2 = new String[size];
                int i3 = 0;
                while (i2 < size) {
                    strArr2[i2] = arrayList.get(i2).e().toString();
                    i3 += strArr2[i2].length();
                    i2++;
                }
                if (i3 >= 307200) {
                    l0.a(null);
                }
                intent.putExtra("EMBED_K_DATA", strArr2);
                try {
                    this.f177c.sendBroadcast(intent);
                } catch (Exception e2) {
                    l0.a(e2);
                }
            } else if (!a && arrayList.size() <= 100) {
                synchronized (this.f179e) {
                    this.f179e.addAll(arrayList);
                }
            } else {
                Collections.sort(arrayList, this);
                ArrayList<u> arrayList2 = new ArrayList<>(arrayList.size());
                Iterator<u> it = arrayList.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    u next = it.next();
                    if (this.f183i.a(next, arrayList2)) {
                        l();
                    }
                    if (next instanceof b0) {
                        z = b2.b(next);
                        i2 = 1;
                    }
                }
                if (i2 != 0) {
                    Handler handler = this.f185k;
                    if (z) {
                        handler.removeMessages(7);
                    } else {
                        handler.sendEmptyMessageDelayed(7, this.f178d.P());
                    }
                }
                this.f180f.a(arrayList2);
                if (this.b || !this.f183i.b() || this.f182h == null || !a.e()) {
                    return;
                }
                g();
            }
        }
    }

    public static void h() {
        v1 v1Var = f176l;
        if (v1Var != null) {
            v1Var.b(null);
        }
    }

    public static v1 i() {
        if (f176l == null) {
            synchronized (v1.class) {
                try {
                    if (f176l == null) {
                        f176l = new v1();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f176l;
    }

    public static String j() {
        b2 b2Var;
        v1 v1Var = f176l;
        if (v1Var == null || (b2Var = v1Var.f183i) == null) {
            return null;
        }
        return b2Var.f81e;
    }

    private void k() {
        if (this.f178d.N()) {
            if (this.a == null) {
                k1 k1Var = new k1(this);
                this.a = k1Var;
                this.f182h.obtainMessage(6, k1Var).sendToTarget();
                return;
            }
            return;
        }
        k1 k1Var2 = this.a;
        if (k1Var2 != null) {
            k1Var2.f();
            this.a = null;
        }
    }

    private void l() {
        if (l0.a) {
            l0.a("packAndSend once, " + this.f183i.f81e + ", hadUI:" + this.f183i.b(), null);
        }
        Handler handler = this.f182h;
        if (handler != null) {
            handler.sendMessage(this.f185k.obtainMessage(6, new w1(this)));
            this.f182h.sendMessage(this.f185k.obtainMessage(6, new x1(this)));
        }
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(u uVar, u uVar2) {
        int i2 = ((uVar.a - uVar2.a) > 0L ? 1 : ((uVar.a - uVar2.a) == 0L ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public Context a() {
        return this.f177c;
    }

    public void a(Application application, j2 j2Var, k2 k2Var, j0 j0Var) {
        this.f177c = application;
        this.f180f = new v(application, k2Var, j2Var);
        this.f178d = j2Var;
        this.f181g = k2Var;
        this.f183i = new b2(k2Var, j2Var);
        this.f177c.registerActivityLifecycleCallbacks(j0Var);
        HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f185k = handler;
        handler.sendEmptyMessage(1);
        k0.a(j2Var.A() != 0);
    }

    public v b() {
        return this.f180f;
    }

    public j2 c() {
        return this.f178d;
    }

    public k2 d() {
        return this.f181g;
    }

    public b2 e() {
        return this.f183i;
    }

    public e.c.a.b.a f() {
        if (this.f184j == null) {
            e.c.a.b.a v = this.f178d.p().v();
            this.f184j = v;
            if (v == null) {
                this.f184j = e.c.a.b.b.a(0);
            }
        }
        return this.f184j;
    }

    public boolean g() {
        this.b = true;
        s1 s1Var = new s1(this);
        Handler handler = this.f182h;
        if (handler != null) {
            handler.obtainMessage(6, s1Var).sendToTarget();
            return true;
        }
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        b((String[]) message.obj);
                    } else if (i2 == 6) {
                        t1 t1Var = (t1) message.obj;
                        if (!t1Var.g()) {
                            long h2 = t1Var.h();
                            if (h2 < 864000000) {
                                this.f182h.sendMessageDelayed(this.f185k.obtainMessage(6, t1Var), h2);
                            }
                        }
                    } else if (i2 != 7) {
                        l0.a(null);
                    } else {
                        synchronized (this.f179e) {
                            this.f179e.add(b2.d());
                        }
                    }
                }
                b(null);
            } else {
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(new z1(this));
                arrayList.add(new u1(this));
                arrayList.add(new y1(this));
                arrayList.add(new a2(this));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    t1 t1Var2 = (t1) it.next();
                    long h3 = t1Var2.h();
                    if (h3 < 864000000) {
                        this.f182h.sendMessageDelayed(this.f185k.obtainMessage(6, t1Var2), h3);
                    }
                }
            }
            k();
        } else {
            this.f178d.O();
            if (!this.f181g.e()) {
                this.f185k.removeMessages(1);
                this.f185k.sendEmptyMessageDelayed(1, 1000L);
            } else if (this.f178d.J()) {
                HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper(), this);
                this.f182h = handler;
                handler.sendEmptyMessage(2);
                if (this.f179e.size() > 0) {
                    this.f185k.removeMessages(4);
                    this.f185k.sendEmptyMessageDelayed(4, 1000L);
                }
                l0.d("net|worker start", null);
            }
            d2.a();
        }
        return true;
    }
}
