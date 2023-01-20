package com.vector;

import androidx.annotation.CallSuper;
import androidx.multidex.MultiDexApplication;
import com.vector.config.AppBarConfig;
import com.vector.design.ui.nav.AppBar;
import e.t.a;
import e.t.i.b;
import e.t.o.f;
import e.t.u.k;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0017J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/vector/AppEx;", "Landroidx/multidex/MultiDexApplication;", "()V", "currProcessName", "", "getCurrProcessName", "()Ljava/lang/String;", "setCurrProcessName", "(Ljava/lang/String;)V", "isMainProcess", "", "()Z", "setMainProcess", "(Z)V", "configureApp", "Lcom/vector/config/AppConfig;", "configureAppBar", "Lcom/vector/config/AppBarConfig;", "configureList", "Lcom/vector/config/ListConfig;", "getCurrentProcessName", "initParams", "", "onCreate", "onCreateAllProcess", "onCreateInChildProcess", "onCreateInMainProcess", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AppEx extends MultiDexApplication {
    @e
    private String a;
    private boolean b = true;

    private final void f() {
        a.d(a());
        a.f(c());
        AppBar.f7769h.b(b());
        f.a.g(this);
        k.a.a(this);
    }

    @d
    public abstract e.t.i.a a();

    @d
    public abstract AppBarConfig b();

    @d
    public b c() {
        return b.f14464g.a(AppEx$configureList$1.INSTANCE);
    }

    @e
    public final String d() {
        return this.a;
    }

    @e
    public String e() {
        return null;
    }

    public final boolean g() {
        return this.b;
    }

    public void h() {
    }

    public void i() {
    }

    @CallSuper
    public void j() {
    }

    public final void k(@e String str) {
        this.a = str;
    }

    public final void l(boolean z) {
        this.b = z;
    }

    @Override // android.app.Application
    @CallSuper
    public void onCreate() {
        super.onCreate();
        a.e(getApplicationContext());
        f();
        String e2 = e();
        if (e2 == null) {
            e2 = e.t.l.k.e(this);
        }
        this.a = e2;
        this.b = f0.g(getPackageName(), this.a);
        h();
        if (this.b) {
            j();
        } else {
            i();
        }
    }
}
