package e.j.a.c.h0;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class p extends q<v> {

    /* renamed from: f  reason: collision with root package name */
    public static final int f10740f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f10741g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f10742h = 2;
    @AttrRes

    /* renamed from: i  reason: collision with root package name */
    private static final int f10743i = R.attr.motionDurationLong1;
    @AttrRes

    /* renamed from: j  reason: collision with root package name */
    private static final int f10744j = R.attr.motionEasingStandard;

    /* renamed from: d  reason: collision with root package name */
    private final int f10745d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f10746e;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface a {
    }

    public p(int i2, boolean z) {
        super(o(i2, z), p());
        this.f10745d = i2;
        this.f10746e = z;
    }

    private static v o(int i2, boolean z) {
        if (i2 == 0) {
            return new s(z ? GravityCompat.END : GravityCompat.START);
        } else if (i2 == 1) {
            return new s(z ? 80 : 48);
        } else if (i2 == 2) {
            return new r(z);
        } else {
            throw new IllegalArgumentException("Invalid axis: " + i2);
        }
    }

    private static v p() {
        return new e();
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
        return f10743i;
    }

    @Override // e.j.a.c.h0.q
    @AttrRes
    public int h(boolean z) {
        return f10744j;
    }

    @Override // e.j.a.c.h0.q
    @NonNull
    public /* bridge */ /* synthetic */ v j() {
        return super.j();
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

    public int q() {
        return this.f10745d;
    }

    public boolean r() {
        return this.f10746e;
    }
}
