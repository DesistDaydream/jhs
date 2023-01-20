package com.vector.databinding.adapter;

import android.view.View;
import com.vector.view.scrollable.ListView;
import e.t.j.h.m;
import e.t.k.a.c.c;
import h.k2.u.p;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "position", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ListViewBinding$setOnLongClick$1 extends Lambda implements p<View, Integer, Boolean> {
    public final /* synthetic */ m $binding;
    public final /* synthetic */ m $footerBinding;
    public final /* synthetic */ m $headerBinding;
    public final /* synthetic */ ListView $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewBinding$setOnLongClick$1(ListView listView, m mVar, m mVar2, m mVar3) {
        super(2);
        this.$view = listView;
        this.$headerBinding = mVar;
        this.$footerBinding = mVar2;
        this.$binding = mVar3;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num) {
        return Boolean.valueOf(invoke(view, num.intValue()));
    }

    public final boolean invoke(@d View view, int i2) {
        p<View, Integer, Boolean> a;
        p<View, Integer, Boolean> a2;
        p<View, Integer, Boolean> a3;
        c<?> adapter = this.$view.getAdapter();
        boolean z = false;
        Boolean bool = null;
        if (adapter != null && adapter.p(i2)) {
            m mVar = this.$headerBinding;
            if (mVar != null && (a3 = mVar.a()) != null) {
                bool = a3.invoke(view, Integer.valueOf(i2));
            }
        } else {
            if (adapter != null && adapter.o(i2)) {
                z = true;
            }
            if (z) {
                m mVar2 = this.$footerBinding;
                if (mVar2 != null && (a2 = mVar2.a()) != null) {
                    bool = a2.invoke(view, Integer.valueOf(i2));
                }
            } else {
                m mVar3 = this.$binding;
                if (mVar3 != null && (a = mVar3.a()) != null) {
                    c<?> adapter2 = this.$view.getAdapter();
                    if (adapter2 != null) {
                        i2 = adapter2.i(i2);
                    }
                    bool = a.invoke(view, Integer.valueOf(i2));
                }
            }
        }
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }
}
