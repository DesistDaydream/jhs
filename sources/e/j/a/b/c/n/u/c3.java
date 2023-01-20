package e.j.a.b.c.n.u;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class c3 extends LifecycleCallback implements DialogInterface.OnCancelListener {
    public volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<d3> f10207c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f10208d;

    /* renamed from: e  reason: collision with root package name */
    public final e.j.a.b.c.e f10209e;

    public c3(k kVar) {
        this(kVar, e.j.a.b.c.e.v());
    }

    private static int l(@Nullable d3 d3Var) {
        if (d3Var == null) {
            return -1;
        }
        return d3Var.b();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void e(int i2, int i3, Intent intent) {
        d3 d3Var = this.f10207c.get();
        if (i2 != 1) {
            if (i2 == 2) {
                int j2 = this.f10209e.j(getActivity());
                r1 = j2 == 0;
                if (d3Var == null) {
                    return;
                }
                if (d3Var.a().getErrorCode() == 18 && j2 == 18) {
                    return;
                }
            }
            r1 = false;
        } else if (i3 != -1) {
            if (i3 == 0) {
                d3 d3Var2 = new d3(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null), l(d3Var));
                this.f10207c.set(d3Var2);
                d3Var = d3Var2;
            }
            r1 = false;
        }
        if (r1) {
            p();
        } else if (d3Var != null) {
            m(d3Var.a(), d3Var.b());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.f10207c.set(bundle.getBoolean("resolving_error", false) ? new d3(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void i(Bundle bundle) {
        super.i(bundle);
        d3 d3Var = this.f10207c.get();
        if (d3Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", d3Var.b());
            bundle.putInt("failed_status", d3Var.a().getErrorCode());
            bundle.putParcelable("failed_resolution", d3Var.a().getResolution());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.b = false;
    }

    public abstract void m(ConnectionResult connectionResult, int i2);

    public final void n(ConnectionResult connectionResult, int i2) {
        d3 d3Var = new d3(connectionResult, i2);
        if (this.f10207c.compareAndSet(null, d3Var)) {
            this.f10208d.post(new e3(this, d3Var));
        }
    }

    public abstract void o();

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m(new ConnectionResult(13, null), l(this.f10207c.get()));
        p();
    }

    public final void p() {
        this.f10207c.set(null);
        o();
    }

    @e.j.a.b.c.x.d0
    private c3(k kVar, e.j.a.b.c.e eVar) {
        super(kVar);
        this.f10207c = new AtomicReference<>(null);
        this.f10208d = new e.j.a.b.f.a.o(Looper.getMainLooper());
        this.f10209e = eVar;
    }
}
