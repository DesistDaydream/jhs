package e.j.a.c.h0.w;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import e.j.a.c.h0.w.w;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes2.dex */
public abstract class r<P extends w> extends Visibility {
    private final P a;
    @Nullable
    private w b;

    /* renamed from: c  reason: collision with root package name */
    private final List<w> f10828c = new ArrayList();

    public r(P p, @Nullable w wVar) {
        this.a = p;
        this.b = wVar;
    }

    private static void b(List<Animator> list, @Nullable w wVar, ViewGroup viewGroup, View view, boolean z) {
        Animator a;
        if (wVar == null) {
            return;
        }
        if (z) {
            a = wVar.b(viewGroup, view);
        } else {
            a = wVar.a(viewGroup, view);
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
        for (w wVar : this.f10828c) {
            b(arrayList, wVar, viewGroup, view, z);
        }
        l(viewGroup.getContext(), z);
        e.j.a.c.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void l(@NonNull Context context, boolean z) {
        v.t(this, context, g(z));
        v.u(this, context, h(z), f(z));
    }

    public void a(@NonNull w wVar) {
        this.f10828c.add(wVar);
    }

    public void c() {
        this.f10828c.clear();
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
    public w k() {
        return this.b;
    }

    public boolean m(@NonNull w wVar) {
        return this.f10828c.remove(wVar);
    }

    public void n(@Nullable w wVar) {
        this.b = wVar;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return e(viewGroup, view, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return e(viewGroup, view, false);
    }
}
