package com.vector.databinding.adapter;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import com.vector.view.ToggleButton;
import e.t.j.h.j0;
import h.k2.k;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0007J$\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/vector/databinding/adapter/ToggleButtonBinding;", "", "()V", "CHECKED", "", "ON_CHECKED_CHANGED", "getChecked", "", "view", "Lcom/vector/view/ToggleButton;", "setChecked", "", "isChecked", "setOnChecked", "binding", "Lcom/vector/databinding/onBind/OnToggleButtonCheckedChangedBinding;", "attrChange", "Landroidx/databinding/InverseBindingListener;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ToggleButtonBinding {
    @d
    public static final ToggleButtonBinding a = new ToggleButtonBinding();
    @d
    private static final String b = "android:toggleButton_checked";
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final String f7701c = "android:toggleButton_onCheckedChanged";

    private ToggleButtonBinding() {
    }

    @k
    @InverseBindingAdapter(attribute = b)
    public static final boolean a(@d ToggleButton toggleButton) {
        return toggleButton.v();
    }

    @BindingAdapter({b})
    @k
    public static final void b(@d ToggleButton toggleButton, boolean z) {
        if (toggleButton.v() == z) {
            return;
        }
        ToggleButton.A(toggleButton, z, false, false, 6, null);
    }

    @BindingAdapter(requireAll = false, value = {f7701c, "android:toggleButton_checkedAttrChanged"})
    @k
    public static final void c(@d ToggleButton toggleButton, @e j0 j0Var, @e InverseBindingListener inverseBindingListener) {
        toggleButton.setListener(new ToggleButtonBinding$setOnChecked$1(inverseBindingListener, j0Var));
    }
}
