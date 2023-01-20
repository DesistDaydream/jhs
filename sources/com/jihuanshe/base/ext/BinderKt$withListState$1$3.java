package com.jihuanshe.base.ext;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.vector.design.ui.delegate.LoadMore;
import com.vector.view.scrollable.ListView;
import e.g.e.a;
import e.t.k.a.c.c;
import e.t.v.j.g;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, "Lcom/eth/model/Error;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BinderKt$withListState$1$3 extends Lambda implements l<a, t1> {
    public final /* synthetic */ boolean $isLoadMore;
    public final /* synthetic */ g<?> $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderKt$withListState$1$3(g<?> gVar, boolean z) {
        super(1);
        this.$view = gVar;
        this.$isLoadMore = z;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        this.$view.d();
        this.$view.b(true);
        if (this.$isLoadMore) {
            this.$view.f(LoadMore.State.ERROR);
            return;
        }
        g<?> gVar = this.$view;
        if (gVar instanceof ListView) {
            c<?> adapter = ((ListView) gVar).getAdapter();
            if (adapter != null && adapter.k() == 0) {
                this.$view.f(LoadMore.State.END);
            }
        }
    }
}
