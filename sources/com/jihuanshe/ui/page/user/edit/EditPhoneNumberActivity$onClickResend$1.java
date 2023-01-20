package com.jihuanshe.ui.page.user.edit;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.edit.EditPhoneNumberViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditPhoneNumberActivity$onClickResend$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ EditPhoneNumberActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.edit.EditPhoneNumberActivity$onClickResend$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ EditPhoneNumberActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EditPhoneNumberActivity editPhoneNumberActivity) {
            super(1);
            this.this$0 = editPhoneNumberActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            ((EditPhoneNumberViewModel) this.this$0.L()).C0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditPhoneNumberActivity$onClickResend$1(EditPhoneNumberActivity editPhoneNumberActivity) {
        super(1);
        this.this$0 = editPhoneNumberActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        String str;
        String str2;
        str = this.this$0.t;
        if (str == null) {
            return;
        }
        str2 = this.this$0.t;
        BinderKt.p(BinderKt.k(a.j(((EditPhoneNumberViewModel) this.this$0.L()).E0(str2), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null));
    }
}
