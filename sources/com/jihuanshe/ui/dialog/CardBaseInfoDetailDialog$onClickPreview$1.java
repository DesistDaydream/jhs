package com.jihuanshe.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.jihuanshe.model.CardBaseInfo;
import com.vector.network.image.NImageView;
import e.l.q.b.h.k;
import h.k2.u.l;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardBaseInfoDetailDialog$onClickPreview$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ NImageView $image;
    public final /* synthetic */ CardBaseInfoDetailDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardBaseInfoDetailDialog$onClickPreview$1(CardBaseInfoDetailDialog cardBaseInfoDetailDialog, NImageView nImageView) {
        super(1);
        this.this$0 = cardBaseInfoDetailDialog;
        this.$image = nImageView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Context context = this.this$0.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        CardBaseInfo value = this.this$0.C().getValue();
        new k(activity, value == null ? null : value.getImage(), this.$image).t();
    }
}