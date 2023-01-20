package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class UseDialog$rightClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ UseDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseDialog$rightClick$1(UseDialog useDialog) {
        super(1);
        this.this$0 = useDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        a<t1> onClickRightButton = this.this$0.getOnClickRightButton();
        if (onClickRightButton != null) {
            onClickRightButton.invoke();
        }
        this.this$0.h();
    }
}
