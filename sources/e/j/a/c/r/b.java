package e.j.a.c.r;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import e.j.a.c.a.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class b implements f {
    private final Context a;
    @NonNull
    private final ExtendedFloatingActionButton b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f10929c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final e.j.a.c.r.a f10930d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private h f10931e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private h f10932f;

    /* loaded from: classes2.dex */
    public class a extends Property<ExtendedFloatingActionButton, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(e.j.a.c.a.a.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.K.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.b.K.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f2) {
            int colorForState = extendedFloatingActionButton.K.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.b.K.getDefaultColor());
            ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (e.j.a.c.a.a.a(0.0f, Color.alpha(colorForState) / 255.0f, f2.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f2.floatValue() == 1.0f) {
                extendedFloatingActionButton.V(extendedFloatingActionButton.K);
            } else {
                extendedFloatingActionButton.V(valueOf);
            }
        }
    }

    public b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, e.j.a.c.r.a aVar) {
        this.b = extendedFloatingActionButton;
        this.a = extendedFloatingActionButton.getContext();
        this.f10930d = aVar;
    }

    @Override // e.j.a.c.r.f
    public final h a() {
        h hVar = this.f10932f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f10931e == null) {
            this.f10931e = h.d(this.a, g());
        }
        return (h) Preconditions.checkNotNull(this.f10931e);
    }

    @Override // e.j.a.c.r.f
    @Nullable
    public h c() {
        return this.f10932f;
    }

    @Override // e.j.a.c.r.f
    public final void e(@NonNull Animator.AnimatorListener animatorListener) {
        this.f10929c.remove(animatorListener);
    }

    @Override // e.j.a.c.r.f
    @CallSuper
    public void f() {
        this.f10930d.b();
    }

    @Override // e.j.a.c.r.f
    public final void h(@NonNull Animator.AnimatorListener animatorListener) {
        this.f10929c.add(animatorListener);
    }

    @Override // e.j.a.c.r.f
    @CallSuper
    public void i() {
        this.f10930d.b();
    }

    @Override // e.j.a.c.r.f
    public final void j(@Nullable h hVar) {
        this.f10932f = hVar;
    }

    @Override // e.j.a.c.r.f
    public AnimatorSet k() {
        return o(a());
    }

    @Override // e.j.a.c.r.f
    @NonNull
    public final List<Animator.AnimatorListener> l() {
        return this.f10929c;
    }

    @NonNull
    public AnimatorSet o(@NonNull h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.j("opacity")) {
            arrayList.add(hVar.f("opacity", this.b, View.ALPHA));
        }
        if (hVar.j("scale")) {
            arrayList.add(hVar.f("scale", this.b, View.SCALE_Y));
            arrayList.add(hVar.f("scale", this.b, View.SCALE_X));
        }
        if (hVar.j("width")) {
            arrayList.add(hVar.f("width", this.b, ExtendedFloatingActionButton.P));
        }
        if (hVar.j("height")) {
            arrayList.add(hVar.f("height", this.b, ExtendedFloatingActionButton.Q));
        }
        if (hVar.j("paddingStart")) {
            arrayList.add(hVar.f("paddingStart", this.b, ExtendedFloatingActionButton.R));
        }
        if (hVar.j("paddingEnd")) {
            arrayList.add(hVar.f("paddingEnd", this.b, ExtendedFloatingActionButton.S));
        }
        if (hVar.j("labelOpacity")) {
            arrayList.add(hVar.f("labelOpacity", this.b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        e.j.a.c.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @Override // e.j.a.c.r.f
    @CallSuper
    public void onAnimationStart(Animator animator) {
        this.f10930d.c(animator);
    }
}
