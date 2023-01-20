package e.j.a.c.q;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes2.dex */
public final class c {
    @NonNull
    private final View a;
    private boolean b = false;
    @IdRes

    /* renamed from: c  reason: collision with root package name */
    private int f10928c = 0;

    public c(b bVar) {
        this.a = (View) bVar;
    }

    private void a() {
        ViewParent parent = this.a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.a);
        }
    }

    @IdRes
    public int b() {
        return this.f10928c;
    }

    public boolean c() {
        return this.b;
    }

    public void d(@NonNull Bundle bundle) {
        this.b = bundle.getBoolean("expanded", false);
        this.f10928c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.b) {
            a();
        }
    }

    @NonNull
    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.b);
        bundle.putInt("expandedComponentIdHint", this.f10928c);
        return bundle;
    }

    public boolean f(boolean z) {
        if (this.b != z) {
            this.b = z;
            a();
            return true;
        }
        return false;
    }

    public void g(@IdRes int i2) {
        this.f10928c = i2;
    }
}
