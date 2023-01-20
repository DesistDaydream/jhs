package e.t.j.g;

import androidx.databinding.BindingAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.vector.databinding.onBind.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/vector/databinding/adapter/AppBarLayoutBinding;", "", "()V", "ON_OFFSET_CHANGED", "", "ON_OFFSET_STATE_CHANGED", "addOnOffsetChangedListener", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "binding", "Lcom/vector/databinding/onBind/OnOffsetChangedBinding;", "offsetChangedListener", "v", "Lcom/vector/databinding/onBind/OnOffsetStateChangedBinding;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class q {
    @k.e.a.d
    public static final q a = new q();
    @k.e.a.d
    private static final String b = "android:appBarLayout_onOffsetChanged";
    @k.e.a.d

    /* renamed from: c */
    private static final String f14513c = "android:appBarLayout_onOffsetStateChanged";

    private q() {
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void a(@k.e.a.d AppBarLayout appBarLayout, @k.e.a.d final e.t.j.h.t tVar) {
        appBarLayout.b(new AppBarLayout.d() { // from class: e.t.j.g.a
            @Override // com.google.android.material.appbar.AppBarLayout.d, com.google.android.material.appbar.AppBarLayout.c
            public final void a(AppBarLayout appBarLayout2, int i2) {
                q.b(tVar, appBarLayout2, i2);
            }
        });
    }

    public static final void b(e.t.j.h.t tVar, AppBarLayout appBarLayout, int i2) {
        tVar.a().invoke(appBarLayout, Integer.valueOf(i2));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.vector.databinding.onBind.State] */
    @BindingAdapter({f14513c})
    @h.k2.k
    public static final void e(@k.e.a.d AppBarLayout appBarLayout, @k.e.a.d final e.t.j.h.u uVar) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = State.IDLE;
        appBarLayout.b(new AppBarLayout.d() { // from class: e.t.j.g.b
            @Override // com.google.android.material.appbar.AppBarLayout.d, com.google.android.material.appbar.AppBarLayout.c
            public final void a(AppBarLayout appBarLayout2, int i2) {
                q.f(objectRef, uVar, appBarLayout2, i2);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f(Ref.ObjectRef objectRef, e.t.j.h.u uVar, AppBarLayout appBarLayout, int i2) {
        T t;
        if (i2 == 0) {
            T t2 = objectRef.element;
            State state = State.EXPANDED;
            t = state;
            if (t2 != state) {
                uVar.a().invoke(appBarLayout, state);
                t = state;
            }
        } else if (Math.abs(i2) >= appBarLayout.getTotalScrollRange()) {
            T t3 = objectRef.element;
            State state2 = State.COLLAPSED;
            t = state2;
            if (t3 != state2) {
                uVar.a().invoke(appBarLayout, state2);
                t = state2;
            }
        } else {
            T t4 = objectRef.element;
            State state3 = State.IDLE;
            t = state3;
            if (t4 != state3) {
                uVar.a().invoke(appBarLayout, state3);
                t = state3;
            }
        }
        objectRef.element = t;
    }
}
