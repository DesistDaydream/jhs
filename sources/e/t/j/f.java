package e.t.j;

import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.databinding.BindingAdapter;
import e.t.j.h.g0;
import h.k2.k;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vector/databinding/SwitchBinding;", "", "()V", "ON_CHECKED_CHANGED", "", "setOnCheckedChanged", "", "view", "Landroid/widget/Switch;", "binding", "Lcom/vector/databinding/onBind/OnSwitchCheckedChangedBinding;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    @k.e.a.d
    public static final f a = new f();
    @k.e.a.d
    private static final String b = "android:switch_onCheckedChanged";

    private f() {
    }

    public static /* synthetic */ void a(g0 g0Var, CompoundButton compoundButton, boolean z) {
        c(g0Var, compoundButton, z);
    }

    @BindingAdapter({b})
    @k
    public static final void b(@k.e.a.d Switch r1, @k.e.a.d final g0 g0Var) {
        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.t.j.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                f.a(g0.this, compoundButton, z);
            }
        });
    }

    public static final void c(g0 g0Var, CompoundButton compoundButton, boolean z) {
        g0Var.a().invoke(compoundButton, Boolean.valueOf(z));
    }
}
