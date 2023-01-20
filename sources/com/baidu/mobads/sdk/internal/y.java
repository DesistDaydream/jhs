package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class y {
    private static final String a = "LoadRemoteDex";

    /* renamed from: i  reason: collision with root package name */
    private static y f1666i;
    private IXAdContainerFactory b;

    /* renamed from: c  reason: collision with root package name */
    private be f1667c;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f1670f;

    /* renamed from: g  reason: collision with root package name */
    private Context f1671g;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1674k;

    /* renamed from: d  reason: collision with root package name */
    private int f1668d = 5000;

    /* renamed from: e  reason: collision with root package name */
    private Handler f1669e = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    private bj f1672h = bj.a();

    /* renamed from: j  reason: collision with root package name */
    private AtomicBoolean f1673j = new AtomicBoolean(false);

    /* loaded from: classes.dex */
    public interface a {
        public static final int a = 1;
        public static final int b = 2;

        void onFailure();

        void onSuccess();
    }

    private y() {
    }

    private void f() {
        this.f1673j.set(true);
        if (al.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (y.class) {
            try {
                be beVar = new be(Class.forName(v.az, true, getClass().getClassLoader()), this.f1671g);
                this.f1667c = beVar;
                this.b = beVar.a();
                k();
            } catch (Exception unused) {
                a("反射调用remote失败");
            }
        }
    }

    private void h() {
        this.f1670f = new z(this);
        j();
        if (f.a == null) {
            synchronized (bp.class) {
                if (f.a == null) {
                    f.a = new bp(this.f1671g);
                }
            }
        }
        if (this.b != null) {
            k();
        } else if (f.a != null) {
            this.f1672h.a(a, "start load apk");
            try {
                f.a.a(new aa(this));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            this.f1672h.a(a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
        }
    }

    private void i() {
        Runnable runnable = this.f1670f;
        if (runnable != null) {
            this.f1669e.removeCallbacks(runnable);
        }
        this.f1670f = null;
    }

    private void j() {
        Runnable runnable = this.f1670f;
        if (runnable != null) {
            this.f1669e.postDelayed(runnable, this.f1668d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f1673j.set(false);
        bc.a(this.f1671g);
        i();
        o.a().a(1);
        cd.a(this.f1671g).b();
        cd.a(this.f1671g).a();
    }

    public IXAdContainerFactory c() {
        if (this.f1671g == null) {
            return null;
        }
        if (this.b == null && !this.f1673j.get()) {
            f();
        }
        return this.b;
    }

    public String d() {
        if (this.b != null) {
            return "_" + this.b.getRemoteVersion();
        }
        return "";
    }

    public boolean e() {
        return this.f1674k;
    }

    public Context b() {
        return this.f1671g;
    }

    public static y a() {
        if (f1666i == null) {
            synchronized (y.class) {
                if (f1666i == null) {
                    f1666i = new y();
                }
            }
        }
        return f1666i;
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            this.f1672h.c(a, "init Context is null,error");
            return;
        }
        this.f1671g = context.getApplicationContext();
        o.a().a(aVar);
        if (this.b != null) {
            k();
        } else if (this.f1673j.get()) {
        } else {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        bj bjVar = this.f1672h;
        bjVar.a(a, "加载dex失败原因=" + str);
        this.f1673j.set(false);
        i();
        o.a().a(2);
    }
}
