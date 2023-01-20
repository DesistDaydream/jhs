package e.j.a.b.c.n.u;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* loaded from: classes2.dex */
public final class u3 implements Runnable {
    private final /* synthetic */ LifecycleCallback a;
    private final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ t3 f10328c;

    public u3(t3 t3Var, LifecycleCallback lifecycleCallback, String str) {
        this.f10328c = t3Var;
        this.a = lifecycleCallback;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        i2 = this.f10328c.b;
        if (i2 > 0) {
            LifecycleCallback lifecycleCallback = this.a;
            bundle = this.f10328c.f10326c;
            if (bundle != null) {
                bundle3 = this.f10328c.f10326c;
                bundle2 = bundle3.getBundle(this.b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.f(bundle2);
        }
        i3 = this.f10328c.b;
        if (i3 >= 2) {
            this.a.j();
        }
        i4 = this.f10328c.b;
        if (i4 >= 3) {
            this.a.h();
        }
        i5 = this.f10328c.b;
        if (i5 >= 4) {
            this.a.k();
        }
        i6 = this.f10328c.b;
        if (i6 >= 5) {
            this.a.g();
        }
    }
}
