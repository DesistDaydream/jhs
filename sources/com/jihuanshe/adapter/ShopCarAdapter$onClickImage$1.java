package com.jihuanshe.adapter;

import android.view.View;
import android.widget.ImageView;
import e.l.q.b.h.k;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopCarAdapter$onClickImage$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ String $url;
    public final /* synthetic */ ShopCarAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopCarAdapter$onClickImage$1(String str, ShopCarAdapter shopCarAdapter) {
        super(1);
        this.$url = str;
        this.this$0 = shopCarAdapter;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        String str = this.$url;
        if (str == null || str.length() == 0) {
            return;
        }
        new k(this.this$0.v(), this.$url, (ImageView) view).t();
    }
}
