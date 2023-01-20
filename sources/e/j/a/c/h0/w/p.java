package e.j.a.c.h0.w;

import android.animation.Animator;
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
public final class p extends r<e> {

    /* renamed from: d  reason: collision with root package name */
    private static final float f10818d = 0.92f;
    @AttrRes

    /* renamed from: e  reason: collision with root package name */
    private static final int f10819e = R.attr.motionDurationLong1;
    @AttrRes

    /* renamed from: f  reason: collision with root package name */
    private static final int f10820f = R.attr.motionEasingStandard;

    public p() {
        super(o(), p());
    }

    private static e o() {
        return new e();
    }

    private static w p() {
        s sVar = new s();
        sVar.o(false);
        sVar.l(f10818d);
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
    @AttrRes
    public int g(boolean z) {
        return f10819e;
    }

    @Override // e.j.a.c.h0.w.r
    @AttrRes
    public int h(boolean z) {
        return f10820f;
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
