package e.j.a.c.h0;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import com.google.android.material.R;

/* loaded from: classes2.dex */
public final class n extends q<d> {

    /* renamed from: d  reason: collision with root package name */
    private static final float f10732d = 0.8f;

    /* renamed from: e  reason: collision with root package name */
    private static final float f10733e = 0.3f;
    @AttrRes

    /* renamed from: f  reason: collision with root package name */
    private static final int f10734f = R.attr.motionDurationShort2;
    @AttrRes

    /* renamed from: g  reason: collision with root package name */
    private static final int f10735g = R.attr.motionDurationShort1;
    @AttrRes

    /* renamed from: h  reason: collision with root package name */
    private static final int f10736h = R.attr.motionEasingLinear;

    public n() {
        super(o(), p());
    }

    private static d o() {
        d dVar = new d();
        dVar.e(f10733e);
        return dVar;
    }

    private static v p() {
        r rVar = new r();
        rVar.o(false);
        rVar.l(f10732d);
        return rVar;
    }

    @Override // e.j.a.c.h0.q
    public /* bridge */ /* synthetic */ void a(@NonNull v vVar) {
        super.a(vVar);
    }

    @Override // e.j.a.c.h0.q
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // e.j.a.c.h0.q
    @NonNull
    public TimeInterpolator f(boolean z) {
        return e.j.a.c.a.a.a;
    }

    @Override // e.j.a.c.h0.q
    @AttrRes
    public int g(boolean z) {
        return z ? f10734f : f10735g;
    }

    @Override // e.j.a.c.h0.q
    @AttrRes
    public int h(boolean z) {
        return f10736h;
    }

    @Override // e.j.a.c.h0.q
    @Nullable
    public /* bridge */ /* synthetic */ v k() {
        return super.k();
    }

    @Override // e.j.a.c.h0.q
    public /* bridge */ /* synthetic */ boolean m(@NonNull v vVar) {
        return super.m(vVar);
    }

    @Override // e.j.a.c.h0.q
    public /* bridge */ /* synthetic */ void n(@Nullable v vVar) {
        super.n(vVar);
    }

    @Override // e.j.a.c.h0.q, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // e.j.a.c.h0.q, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }
}
