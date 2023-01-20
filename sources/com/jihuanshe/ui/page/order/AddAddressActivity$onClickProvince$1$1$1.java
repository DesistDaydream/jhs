package com.jihuanshe.ui.page.order;

import android.view.View;
import android.widget.TextView;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddAddressActivity$onClickProvince$1$1$1 extends Lambda implements q<String, String, String, t1> {
    public final /* synthetic */ AddAddressActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddAddressActivity$onClickProvince$1$1$1(AddAddressActivity addAddressActivity) {
        super(3);
        this.this$0 = addAddressActivity;
    }

    @Override // h.k2.u.q
    public /* bridge */ /* synthetic */ t1 invoke(String str, String str2, String str3) {
        invoke2(str, str2, str3);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str, @d String str2, @d String str3) {
        boolean Y;
        this.this$0.w0(str);
        this.this$0.t0(str2);
        this.this$0.r0(str3);
        TextView m0 = this.this$0.m0();
        m0.setText(str + ' ' + str2 + ' ' + str3);
        View n0 = this.this$0.n0();
        if (n0 == null) {
            return;
        }
        Y = this.this$0.Y();
        n0.setEnabled(Y);
    }
}
