package e.j.a.c.h0.w;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
/* loaded from: classes2.dex */
public final class q extends r<w> {

    /* renamed from: f  reason: collision with root package name */
    public static final int f10821f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f10822g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f10823h = 2;
    @AttrRes

    /* renamed from: i  reason: collision with root package name */
    private static final int f10824i = R.attr.motionDurationLong1;
    @AttrRes

    /* renamed from: j  reason: collision with root package name */
    private static final int f10825j = R.attr.motionEasingStandard;

    /* renamed from: d  reason: collision with root package name */
    private final int f10826d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f10827e;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface a {
    }

    public q(int i2, boolean z) {
        super(o(i2, z), p());
        this.f10826d = i2;
        this.f10827e = z;
    }

    private static w o(int i2, boolean z) {
        if (i2 == 0) {
            return new t(z ? GravityCompat.END : GravityCompat.START);
        } else if (i2 == 1) {
            return new t(z ? 80 : 48);
        } else if (i2 == 2) {
            return new s(z);
        } else {
            throw new IllegalArgumentException("Invalid axis: " + i2);
        }
    }

    private static w p() {
        return new e();
    }

    @Override // e.j.a.c.h0.w.r
    public /* bridge */ /* synthetic */ void a(@NonNull w wVar) {
        super.a(wVar);
    }

    @Override // e.j.a.c.h0.w.r
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // e.j.a.c.h0.w.r
    @AttrRes
    public int g(boolean z) {
        return f10824i;
    }

    @Override // e.j.a.c.h0.w.r
    @AttrRes
    public int h(boolean z) {
        return f10825j;
    }

    @Override // e.j.a.c.h0.w.r
    @NonNull
    public /* bridge */ /* synthetic */ w j() {
        return super.j();
    }

    @Override // e.j.a.c.h0.w.r
    @Nullable
    public /* bridge */ /* synthetic */ w k() {
        return super.k();
    }

    @Override // e.j.a.c.h0.w.r
    public /* bridge */ /* synthetic */ boolean m(@NonNull w wVar) {
        return super.m(wVar);
    }

    @Override // e.j.a.c.h0.w.r
    public /* bridge */ /* synthetic */ void n(@Nullable w wVar) {
        super.n(wVar);
    }

    @Override // e.j.a.c.h0.w.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // e.j.a.c.h0.w.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    public int q() {
        return this.f10826d;
    }

    public boolean r() {
        return this.f10827e;
    }
}
