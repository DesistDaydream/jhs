package e.j.a.c.h0;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;

/* loaded from: classes2.dex */
public final class m extends q<r> {

    /* renamed from: e  reason: collision with root package name */
    private static final float f10730e = 0.85f;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10731d;

    public m(boolean z) {
        super(o(z), p());
        this.f10731d = z;
    }

    private static r o(boolean z) {
        r rVar = new r(z);
        rVar.m(f10730e);
        rVar.l(f10730e);
        return rVar;
    }

    private static v p() {
        return new d();
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

    public boolean q() {
        return this.f10731d;
    }
}
