package com.vector.design.ui.dialog;

import android.content.DialogInterface;
import e.t.k.a.f.g;
import h.k2.u.a;
import h.r0;
import h.t1;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DialogEx$show$1 extends Lambda implements a<t1> {
    public final /* synthetic */ DialogEx this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogEx$show$1(DialogEx dialogEx) {
        super(0);
        this.this$0 = dialogEx;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        g gVar;
        DialogInterface.OnShowListener onShowListener;
        g gVar2;
        t1 t1Var;
        DialogEx dialogEx = this.this$0;
        try {
            Result.a aVar = Result.Companion;
            gVar = dialogEx.f7755i;
            gVar.show();
            onShowListener = dialogEx.f7749c;
            if (onShowListener == null) {
                t1Var = null;
            } else {
                gVar2 = dialogEx.f7755i;
                onShowListener.onShow(gVar2);
                t1Var = t1.a;
            }
            Result.m106constructorimpl(t1Var);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
    }
}
