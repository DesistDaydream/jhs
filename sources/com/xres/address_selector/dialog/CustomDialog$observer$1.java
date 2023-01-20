package com.xres.address_selector.dialog;

import h.k2.u.a;
import h.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class CustomDialog$observer$1 extends FunctionReferenceImpl implements a<t1> {
    public CustomDialog$observer$1(CustomDialog customDialog) {
        super(0, customDialog, CustomDialog.class, "dismiss", "dismiss()V", 0);
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke */
    public final void invoke2() {
        ((CustomDialog) this.receiver).dismiss();
    }
}
