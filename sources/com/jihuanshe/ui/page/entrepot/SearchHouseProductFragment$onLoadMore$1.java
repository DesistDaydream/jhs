package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.entrepot.SearchHouseProductViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchHouseProductFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ SearchHouseProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchHouseProductFragment$onLoadMore$1(SearchHouseProductFragment searchHouseProductFragment) {
        super(2);
        this.this$0 = searchHouseProductFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        SearchHouseProductViewModel searchHouseProductViewModel = (SearchHouseProductViewModel) this.this$0.T();
        int l0 = this.this$0.l0();
        String value = this.this$0.k0().s0().getValue();
        GameBar.a aVar = GameBar.b;
        Game value2 = aVar.a().getValue();
        String gameKey = value2 == null ? null : value2.getGameKey();
        if (gameKey == null) {
            gameKey = "";
        }
        Game value3 = aVar.a().getValue();
        String gameSubKey = value3 != null ? value3.getGameSubKey() : null;
        if (gameSubKey == null) {
            gameSubKey = "";
        }
        BinderKt.p(BinderKt.d(searchHouseProductViewModel.r0(l0, value, gameKey, gameSubKey, state), this.this$0, gVar, true));
    }
}
