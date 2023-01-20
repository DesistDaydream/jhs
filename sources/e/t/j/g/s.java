package e.t.j.g;

import android.widget.CompoundButton;
import androidx.databinding.BindingAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/vector/databinding/adapter/CompoundButtonBinding;", "", "()V", "ON_CHECKED_CHANGED", "", "REQUEST_CHECKED", "onCheckChanged", "", "view", "Landroid/widget/CompoundButton;", "binding", "Lcom/vector/databinding/onBind/OnCheckedChangedBinding;", "setRequestChecked", "isChecked", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class s {
    @k.e.a.d
    public static final s a = new s();
    @k.e.a.d
    private static final String b = "android:compoundButton_onCheckedChanged";
    @k.e.a.d

    /* renamed from: c */
    private static final String f14514c = "android:view_isChecked";

    private s() {
    }

    public static /* synthetic */ void a(e.t.j.h.e eVar, CompoundButton compoundButton, boolean z) {
        c(eVar, compoundButton, z);
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void b(@k.e.a.d CompoundButton compoundButton, @k.e.a.d final e.t.j.h.e eVar) {
        compoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.t.j.g.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton2, boolean z) {
                s.a(e.t.j.h.e.this, compoundButton2, z);
            }
        });
    }

    public static final void c(e.t.j.h.e eVar, CompoundButton compoundButton, boolean z) {
        eVar.a().invoke(compoundButton, Boolean.valueOf(z));
    }

    @BindingAdapter({f14514c})
    @h.k2.k
    public static final void d(@k.e.a.d CompoundButton compoundButton, boolean z) {
        compoundButton.setChecked(z);
    }
}
