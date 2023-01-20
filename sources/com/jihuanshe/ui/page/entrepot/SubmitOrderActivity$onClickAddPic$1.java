package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.utils.ImagePicker;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderActivity$onClickAddPic$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SubmitOrderActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderActivity$onClickAddPic$1(SubmitOrderActivity submitOrderActivity) {
        super(1);
        this.this$0 = submitOrderActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        ImagePicker imagePicker;
        imagePicker = this.this$0.p;
        imagePicker.E();
    }
}
