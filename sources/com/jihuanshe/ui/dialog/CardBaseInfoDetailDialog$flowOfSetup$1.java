package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.model.CardBaseInfo;
import e.l.h.i.b;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardBaseInfoDetailDialog$flowOfSetup$1 extends Lambda implements l<b<CardBaseInfo>, t1> {
    public final /* synthetic */ CardBaseInfoDetailDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardBaseInfoDetailDialog$flowOfSetup$1(CardBaseInfoDetailDialog cardBaseInfoDetailDialog) {
        super(1);
        this.this$0 = cardBaseInfoDetailDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(b<CardBaseInfo> bVar) {
        invoke2(bVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e b<CardBaseInfo> bVar) {
        this.this$0.C().setValue(bVar == null ? null : bVar.a());
        View view = this.this$0.getView();
        if (view == null) {
            return;
        }
        view.requestLayout();
    }
}
