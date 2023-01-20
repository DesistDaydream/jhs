package com.jihuanshe.ui.dialog;

import android.text.Editable;
import h.k2.u.l;
import h.r0;
import h.t1;
import k.e.a.d;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WaitCheckDialog$onAfterChanged$1 extends Lambda implements l<Editable, t1> {
    public final /* synthetic */ WaitCheckDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaitCheckDialog$onAfterChanged$1(WaitCheckDialog waitCheckDialog) {
        super(1);
        this.this$0 = waitCheckDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Editable editable) {
        invoke2(editable);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Editable editable) {
        Object m106constructorimpl;
        WaitCheckDialog waitCheckDialog = this.this$0;
        try {
            Result.a aVar = Result.Companion;
            if (Integer.parseInt(editable.toString()) <= 0) {
                waitCheckDialog.getCount().setValue(1);
            } else {
                waitCheckDialog.getCount().setValue(Integer.valueOf(Integer.parseInt(editable.toString())));
            }
            m106constructorimpl = Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        Result.m109exceptionOrNullimpl(m106constructorimpl);
    }
}
