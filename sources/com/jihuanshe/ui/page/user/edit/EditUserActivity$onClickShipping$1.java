package com.jihuanshe.ui.page.user.edit;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.UpdateUserInfoResult;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.dialog.EditUserDialog;
import com.vector.util.Res;
import e.l.s.o.c.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditUserActivity$onClickShipping$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ String $content;
    public final /* synthetic */ EditUserActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.edit.EditUserActivity$onClickShipping$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<String, t1> {
        public final /* synthetic */ EditUserActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.user.edit.EditUserActivity$onClickShipping$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01381 extends Lambda implements l<UpdateUserInfoResult, t1> {
            public final /* synthetic */ String $ship;
            public final /* synthetic */ EditUserActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01381(EditUserActivity editUserActivity, String str) {
                super(1);
                this.this$0 = editUserActivity;
                this.$ship = str;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(UpdateUserInfoResult updateUserInfoResult) {
                invoke2(updateUserInfoResult);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e UpdateUserInfoResult updateUserInfoResult) {
                User d0 = this.this$0.d0();
                if (d0 != null) {
                    d0.setShipping(this.$ship);
                }
                ((a) this.this$0.L()).A0().n();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EditUserActivity editUserActivity) {
            super(1);
            this.this$0 = editUserActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(String str) {
            invoke2(str);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d String str) {
            if (str.length() == 0) {
                str = "0";
            }
            BinderKt.p(BinderKt.k(e.g.d.a.j(a.C0((a) this.this$0.L(), null, null, null, null, null, str, null, null, 223, null), null, new C01381(this.this$0, str), 1, null), this.this$0, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserActivity$onClickShipping$1(EditUserActivity editUserActivity, String str) {
        super(1);
        this.this$0 = editUserActivity;
        this.$content = str;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        new EditUserDialog(this.this$0, Res.w(Res.a, R.string.shipping_title, null, 2, null), true, 20, this.$content, new AnonymousClass1(this.this$0)).y();
    }
}
