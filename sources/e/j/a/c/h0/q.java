package e.j.a.c.h0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import e.j.a.c.h0.v;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class q<P extends v> extends Visibility {
    private final P a;
    @Nullable
    private v b;

    /* renamed from: c  reason: collision with root package name */
    private final List<v> f10747c = new ArrayList();

    public q(P p, @Nullable v vVar) {
        this.a = p;
        this.b = vVar;
    }

    private static void b(List<Animator> list, @Nullable v vVar, ViewGroup viewGroup, View view, boolean z) {
        Animator a;
        if (vVar == null) {
            return;
        }
        if (z) {
            a = vVar.b(viewGroup, view);
        } else {
            a = vVar.a(viewGroup, view);
        }
        if (a != null) {
            list.add(a);
        }
    }

    private Animator e(@NonNull ViewGroup viewGroup, @NonNull View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        b(arrayList, this.a, viewGroup, view, z);
        b(arrayList, this.b, viewGroup, view, z);
        for (v vVar : this.f10747c) {
            b(arrayList, vVar, viewGroup, view, z);
        }
        l(viewGroup.getContext(), z);
        e.j.a.c.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void l(@NonNull Context context, boolean z) {
        u.t(this, context, g(z));
        u.u(this, context, h(z), f(z));
    }

    public void a(@NonNull v vVar) {
        this.f10747c.add(vVar);
    }

    public void c() {
        this.f10747c.clear();
    }

    @NonNull
    public TimeInterpolator f(boolean z) {
        return e.j.a.c.a.a.b;
    }

    @AttrRes
    public int g(boolean z) {
        return 0;
    }

    @AttrRes
    public int h(boolean z) {
        return 0;
    }

    @NonNull
    public P j() {
        return this.a;
    }

    @Nullable
    public v k() {
        return this.b;
    }

    public boolean m(@NonNull v vVar) {
        return this.f10747c.remove(vVar);
    }

    public void n(@Nullable v vVar) {
        this.b = vVar;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return e(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return e(viewGroup, view, false);
    }
}
