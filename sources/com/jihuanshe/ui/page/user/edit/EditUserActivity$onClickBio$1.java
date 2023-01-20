package com.jihuanshe.ui.page.user.edit;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.UpdateUserInfoResult;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.dialog.EditUserDialog;
import e.l.s.o.c.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditUserActivity$onClickBio$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ String $content;
    public final /* synthetic */ EditUserActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.edit.EditUserActivity$onClickBio$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<String, t1> {
        public final /* synthetic */ EditUserActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.user.edit.EditUserActivity$onClickBio$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01351 extends Lambda implements l<UpdateUserInfoResult, t1> {
            public final /* synthetic */ String $it;
            public final /* synthetic */ EditUserActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01351(EditUserActivity editUserActivity, String str) {
                super(1);
                this.this$0 = editUserActivity;
                this.$it = str;
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
                    d0.setSellerBio(this.$it);
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
            if (str.length() > 0) {
                User d0 = this.this$0.d0();
                if (f0.g(str, d0 == null ? null : d0.getSellerBio())) {
                    return;
                }
                BinderKt.p(BinderKt.k(e.g.d.a.j(a.C0((a) this.this$0.L(), null, str, null, null, null, null, null, null, 253, null), null, new C01351(this.this$0, str), 1, null), this.this$0, false, 2, null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserActivity$onClickBio$1(EditUserActivity editUserActivity, String str) {
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
        EditUserActivity editUserActivity = this.this$0;
        new EditUserDialog(editUserActivity, "输入简介", false, 96, this.$content, new AnonymousClass1(editUserActivity)).y();
    }
}
