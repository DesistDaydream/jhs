package com.jihuanshe.ui.page.user.edit;

import android.view.View;
import com.jihuanshe.ui.widget.VerifyView;
import com.jihuanshe.viewmodel.user.edit.EditPhoneNumberViewModel;
import h.k2.u.l;
import h.t1;
import java.util.Objects;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditPhoneNumberActivity$onVerify$1$onComplete$2 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ View $view;
    public final /* synthetic */ EditPhoneNumberActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditPhoneNumberActivity$onVerify$1$onComplete$2(EditPhoneNumberActivity editPhoneNumberActivity, View view) {
        super(1);
        this.this$0 = editPhoneNumberActivity;
        this.$view = view;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        ((EditPhoneNumberViewModel) this.this$0.L()).getType().setValue(Integer.valueOf(this.this$0.e0()));
        View view = this.$view;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.jihuanshe.ui.widget.VerifyView");
        ((VerifyView) view).f();
    }
}
