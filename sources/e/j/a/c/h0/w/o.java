package e.j.a.c.h0.w;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;

@RequiresApi(21)
/* loaded from: classes2.dex */
public final class o extends r<d> {

    /* renamed from: d  reason: collision with root package name */
    private static final float f10813d = 0.8f;

    /* renamed from: e  reason: collision with root package name */
    private static final float f10814e = 0.3f;
    @AttrRes

    /* renamed from: f  reason: collision with root package name */
    private static final int f10815f = R.attr.motionDurationShort2;
    @AttrRes

    /* renamed from: g  reason: collision with root package name */
    private static final int f10816g = R.attr.motionDurationShort1;
    @AttrRes

    /* renamed from: h  reason: collision with root package name */
    private static final int f10817h = R.attr.motionEasingLinear;

    public o() {
        super(o(), p());
    }

    private static d o() {
        d dVar = new d();
        dVar.e(f10814e);
        return dVar;
    }

    private static w p() {
        s sVar = new s();
        sVar.o(false);
        sVar.l(f10813d);
        return sVar;
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
    @NonNull
    public TimeInterpolator f(boolean z) {
        return e.j.a.c.a.a.a;
    }

    @Override // e.j.a.c.h0.w.r
    @AttrRes
    public int g(boolean z) {
        return z ? f10815f : f10816g;
    }

    @Override // e.j.a.c.h0.w.r
    @AttrRes
    public int h(boolean z) {
        return f10817h;
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
}
