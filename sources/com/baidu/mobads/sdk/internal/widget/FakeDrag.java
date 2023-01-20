package com.baidu.mobads.sdk.internal.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class FakeDrag {
    private final ViewPager2 a;
    private final ScrollEventAdapter b;

    /* renamed from: c */
    private final RecyclerView f1629c;

    /* renamed from: d */
    private VelocityTracker f1630d;

    /* renamed from: e */
    private int f1631e;

    /* renamed from: f */
    private float f1632f;

    /* renamed from: g */
    private int f1633g;

    /* renamed from: h */
    private long f1634h;

    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.a = viewPager2;
        this.b = scrollEventAdapter;
        this.f1629c = recyclerView;
    }

    private void d() {
        VelocityTracker velocityTracker = this.f1630d;
        if (velocityTracker == null) {
            this.f1630d = VelocityTracker.obtain();
            this.f1631e = ViewConfiguration.get(this.a.getContext()).getScaledMaximumFlingVelocity();
            return;
        }
        velocityTracker.clear();
    }

    public boolean a() {
        return this.b.g();
    }

    @UiThread
    public boolean b() {
        if (this.b.f()) {
            return false;
        }
        this.f1633g = 0;
        this.f1632f = 0;
        this.f1634h = SystemClock.uptimeMillis();
        d();
        this.b.b();
        if (!this.b.e()) {
            this.f1629c.stopScroll();
        }
        a(this.f1634h, 0, 0.0f, 0.0f);
        return true;
    }

    @UiThread
    public boolean c() {
        if (this.b.g()) {
            this.b.c();
            VelocityTracker velocityTracker = this.f1630d;
            velocityTracker.computeCurrentVelocity(1000, this.f1631e);
            if (this.f1629c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
                return true;
            }
            this.a.d();
            return true;
        }
        return false;
    }

    @UiThread
    public boolean a(float f2) {
        if (this.b.g()) {
            float f3 = this.f1632f - f2;
            this.f1632f = f3;
            int round = Math.round(f3 - this.f1633g);
            this.f1633g += round;
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean z = this.a.getOrientation() == 0;
            int i2 = z ? round : 0;
            int i3 = z ? 0 : round;
            float f4 = z ? this.f1632f : 0.0f;
            float f5 = z ? 0.0f : this.f1632f;
            this.f1629c.scrollBy(i2, i3);
            a(uptimeMillis, 2, f4, f5);
            return true;
        }
        return false;
    }

    private void a(long j2, int i2, float f2, float f3) {
        MotionEvent obtain = MotionEvent.obtain(this.f1634h, j2, i2, f2, f3, 0);
        this.f1630d.addMovement(obtain);
        obtain.recycle();
    }
}
