package com.vector.databinding.adapter;

import android.view.View;
import androidx.databinding.InverseBindingListener;
import e.t.j.h.j0;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "checked", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ToggleButtonBinding$setOnChecked$1 extends Lambda implements p<View, Boolean, t1> {
    public final /* synthetic */ InverseBindingListener $attrChange;
    public final /* synthetic */ j0 $binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToggleButtonBinding$setOnChecked$1(InverseBindingListener inverseBindingListener, j0 j0Var) {
        super(2);
        this.$attrChange = inverseBindingListener;
        this.$binding = j0Var;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Boolean bool) {
        invoke(view, bool.booleanValue());
        return t1.a;
    }

    public final void invoke(@e View view, boolean z) {
        p<View, Boolean, t1> a;
        InverseBindingListener inverseBindingListener = this.$attrChange;
        if (inverseBindingListener != null) {
            inverseBindingListener.onChange();
        }
        j0 j0Var = this.$binding;
        if (j0Var == null || (a = j0Var.a()) == null) {
            return;
        }
        a.invoke(view, Boolean.valueOf(z));
    }
}
