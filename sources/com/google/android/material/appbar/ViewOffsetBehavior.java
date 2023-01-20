package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e.j.a.c.b.a;

/* loaded from: classes2.dex */
public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private a a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f2735c;

    public ViewOffsetBehavior() {
        this.b = 0;
        this.f2735c = 0;
    }

    public int a() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.d();
        }
        return 0;
    }

    public int b() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }

    public boolean c() {
        a aVar = this.a;
        return aVar != null && aVar.f();
    }

    public boolean d() {
        a aVar = this.a;
        return aVar != null && aVar.g();
    }

    public void e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        coordinatorLayout.onLayoutChild(v, i2);
    }

    public void f(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.i(z);
        }
    }

    public boolean g(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.j(i2);
        }
        this.f2735c = i2;
        return false;
    }

    public boolean h(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.k(i2);
        }
        this.b = i2;
        return false;
    }

    public void i(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.l(z);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        e(coordinatorLayout, v, i2);
        if (this.a == null) {
            this.a = new a(v);
        }
        this.a.h();
        this.a.a();
        int i3 = this.b;
        if (i3 != 0) {
            this.a.k(i3);
            this.b = 0;
        }
        int i4 = this.f2735c;
        if (i4 != 0) {
            this.a.j(i4);
            this.f2735c = 0;
            return true;
        }
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.f2735c = 0;
    }
}
