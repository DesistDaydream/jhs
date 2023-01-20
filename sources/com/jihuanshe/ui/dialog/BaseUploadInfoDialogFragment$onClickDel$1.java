package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BaseUploadInfoDialogFragment$onClickDel$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ BaseUploadInfoDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseUploadInfoDialogFragment$onClickDel$1(BaseUploadInfoDialogFragment baseUploadInfoDialogFragment, int i2) {
        super(1);
        this.this$0 = baseUploadInfoDialogFragment;
        this.$index = i2;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        this.this$0.X().remove(this.$index);
        this.this$0.c0();
    }
}
