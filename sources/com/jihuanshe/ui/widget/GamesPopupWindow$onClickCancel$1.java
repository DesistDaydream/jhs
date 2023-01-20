package com.jihuanshe.ui.widget;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GamesPopupWindow$onClickCancel$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ GamesPopupWindow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamesPopupWindow$onClickCancel$1(GamesPopupWindow gamesPopupWindow) {
        super(1);
        this.this$0 = gamesPopupWindow;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        l<Boolean, t1> j2 = this.this$0.j();
        if (j2 != null) {
            j2.invoke(Boolean.FALSE);
        }
        this.this$0.dismiss();
    }
}
