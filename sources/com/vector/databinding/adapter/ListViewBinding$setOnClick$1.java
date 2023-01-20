package com.vector.databinding.adapter;

import android.view.View;
import com.vector.view.scrollable.ListView;
import e.t.j.h.l;
import e.t.k.a.c.c;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "position", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ListViewBinding$setOnClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ l $binding;
    public final /* synthetic */ l $footerBinding;
    public final /* synthetic */ l $headerBinding;
    public final /* synthetic */ ListView $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewBinding$setOnClick$1(ListView listView, l lVar, l lVar2, l lVar3) {
        super(2);
        this.$view = listView;
        this.$headerBinding = lVar;
        this.$footerBinding = lVar2;
        this.$binding = lVar3;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@d View view, int i2) {
        p<View, Integer, t1> a;
        p<View, Integer, t1> a2;
        p<View, Integer, t1> a3;
        c<?> adapter = this.$view.getAdapter();
        boolean z = false;
        if (adapter != null && adapter.p(i2)) {
            l lVar = this.$headerBinding;
            if (lVar == null || (a3 = lVar.a()) == null) {
                return;
            }
            a3.invoke(view, Integer.valueOf(i2));
            return;
        }
        if (adapter != null && adapter.o(i2)) {
            z = true;
        }
        if (z) {
            l lVar2 = this.$footerBinding;
            if (lVar2 == null || (a2 = lVar2.a()) == null) {
                return;
            }
            a2.invoke(view, Integer.valueOf(i2));
            return;
        }
        l lVar3 = this.$binding;
        if (lVar3 == null || (a = lVar3.a()) == null) {
            return;
        }
        c<?> adapter2 = this.$view.getAdapter();
        if (adapter2 != null) {
            i2 = adapter2.i(i2);
        }
        a.invoke(view, Integer.valueOf(i2));
    }
}
