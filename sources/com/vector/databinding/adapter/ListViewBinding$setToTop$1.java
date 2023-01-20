package com.vector.databinding.adapter;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.vector.view.scrollable.ListView;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ListViewBinding$setToTop$1 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ ListView $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewBinding$setToTop$1(ListView listView) {
        super(1);
        this.$view = listView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke2(bool);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Boolean bool) {
        this.$view.Q(0, bool);
    }
}
