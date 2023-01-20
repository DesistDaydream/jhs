package com.jihuanshe.utils;

import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import h.k2.u.a;
import h.t1;
import h.t2.t;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class StringUtil$handleReplyText$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ String $id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringUtil$handleReplyText$1$1(String str) {
        super(0);
        this.$id = str;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SellerDetailActivityCreator.create(t.X0(this.$id), null).start(e.t.a.b());
    }
}
