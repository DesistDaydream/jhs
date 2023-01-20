package e.j.a.c.h0.w;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes2.dex */
public final class n extends r<s> {

    /* renamed from: e  reason: collision with root package name */
    private static final float f10811e = 0.85f;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10812d;

    public n(boolean z) {
        super(o(z), p());
        this.f10812d = z;
    }

    private static s o(boolean z) {
        s sVar = new s(z);
        sVar.m(f10811e);
        sVar.l(f10811e);
        return sVar;
    }

    private static w p() {
        return new d();
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

    public boolean q() {
        return this.f10812d;
    }
}
