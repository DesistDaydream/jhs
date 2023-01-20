package com.jihuanshe.ui.page.login;

import android.view.View;
import com.jihuanshe.ui.widget.VerifyView;
import e.g.e.a;
import h.k2.u.l;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginActivity$onVerify$1$onComplete$3 extends Lambda implements l<a, t1> {
    public final /* synthetic */ View $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivity$onVerify$1$onComplete$3(View view) {
        super(1);
        this.$view = view;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        View view = this.$view;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.jihuanshe.ui.widget.VerifyView");
        ((VerifyView) view).f();
    }
}
