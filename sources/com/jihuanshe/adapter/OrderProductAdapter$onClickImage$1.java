package com.jihuanshe.adapter;

import android.view.View;
import com.vector.network.image.NImageView;
import e.l.q.b.h.k;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderProductAdapter$onClickImage$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ NImageView $image;
    public final /* synthetic */ String $imageUrl;
    public final /* synthetic */ OrderProductAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderProductAdapter$onClickImage$1(OrderProductAdapter orderProductAdapter, String str, NImageView nImageView) {
        super(1);
        this.this$0 = orderProductAdapter;
        this.$imageUrl = str;
        this.$image = nImageView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        new k(this.this$0.h(), this.$imageUrl, this.$image).t();
    }
}
