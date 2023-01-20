package com.jihuanshe.ui.page.detail;

import com.jihuanshe.adapter.CommentAdapter;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailActivity$adapterComment$2 extends Lambda implements a<CommentAdapter> {
    public final /* synthetic */ CardPackDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailActivity$adapterComment$2(CardPackDetailActivity cardPackDetailActivity) {
        super(0);
        this.this$0 = cardPackDetailActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final CommentAdapter invoke() {
        return new CommentAdapter(this.this$0);
    }
}
