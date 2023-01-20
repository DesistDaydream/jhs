package com.jihuanshe.ui.page.detail;

import com.jihuanshe.ui.page.detail.CardPackListActivity;
import com.jihuanshe.ui.page.detail.CardPackListActivity$onRetryClick$1$1;
import com.vector.ext.AnyKt;
import com.vector.view.scrollable.ListView;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackListActivity$onRetryClick$1$1 extends Lambda implements l<Object, t1> {
    public final /* synthetic */ CardPackListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackListActivity$onRetryClick$1$1(CardPackListActivity cardPackListActivity) {
        super(1);
        this.this$0 = cardPackListActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m21invoke$lambda0(CardPackListActivity cardPackListActivity) {
        AnyKt.z(new CardPackListActivity$onRetryClick$1$1$1$1(cardPackListActivity));
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Object obj) {
        invoke2(obj);
        return t1.a;
    }

    @Override // h.k2.u.l
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Object obj) {
        ListView e0 = this.this$0.e0();
        final CardPackListActivity cardPackListActivity = this.this$0;
        e0.postDelayed(new Runnable() { // from class: e.l.q.b.d.b
            @Override // java.lang.Runnable
            public final void run() {
                CardPackListActivity$onRetryClick$1$1.m21invoke$lambda0(CardPackListActivity.this);
            }
        }, 100L);
    }
}
