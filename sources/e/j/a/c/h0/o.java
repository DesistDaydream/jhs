package e.j.a.c.h0;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import com.google.android.material.R;

/* loaded from: classes2.dex */
public final class o extends q<e> {

    /* renamed from: d  reason: collision with root package name */
    private static final float f10737d = 0.92f;
    @AttrRes

    /* renamed from: e  reason: collision with root package name */
    private static final int f10738e = R.attr.motionDurationLong1;
    @AttrRes

    /* renamed from: f  reason: collision with root package name */
    private static final int f10739f = R.attr.motionEasingStandard;

    public o() {
        super(o(), p());
    }

    private static e o() {
        return new e();
    }

    private static v p() {
        r rVar = new r();
        rVar.o(false);
        rVar.l(f10737d);
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
    @AttrRes
    public int g(boolean z) {
        return f10738e;
    }

    @Override // e.j.a.c.h0.q
    @AttrRes
    public int h(boolean z) {
        return f10739f;
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
