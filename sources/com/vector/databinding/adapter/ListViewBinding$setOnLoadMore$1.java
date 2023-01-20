package com.vector.databinding.adapter;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.vector.design.ui.delegate.LoadMore;
import com.vector.view.scrollable.ListView;
import e.t.j.h.p;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lcom/vector/design/ui/delegate/LoadMore$State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ListViewBinding$setOnLoadMore$1 extends Lambda implements l<LoadMore.State, t1> {
    public final /* synthetic */ p $binding;
    public final /* synthetic */ ListView $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewBinding$setOnLoadMore$1(p pVar, ListView listView) {
        super(1);
        this.$binding = pVar;
        this.$view = listView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(LoadMore.State state) {
        invoke2(state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d LoadMore.State state) {
        this.$binding.a().invoke(this.$view, state);
    }
}
