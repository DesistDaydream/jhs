package com.jihuanshe.ui.page.user.edit;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.UpdateUserInfoResult;
import com.jihuanshe.model.User;
import e.l.s.o.c.a;
import h.k2.u.l;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditUserActivity$onClickAddress$1$1$1 extends Lambda implements q<String, String, String, t1> {
    public final /* synthetic */ EditUserActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.edit.EditUserActivity$onClickAddress$1$1$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<UpdateUserInfoResult, t1> {
        public final /* synthetic */ String $area;
        public final /* synthetic */ String $city;
        public final /* synthetic */ String $province;
        public final /* synthetic */ EditUserActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EditUserActivity editUserActivity, String str, String str2, String str3) {
            super(1);
            this.this$0 = editUserActivity;
            this.$province = str;
            this.$city = str2;
            this.$area = str3;
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
                d0.setProvince(this.$province);
            }
            User d02 = this.this$0.d0();
            if (d02 != null) {
                d02.setCity(this.$city);
            }
            User d03 = this.this$0.d0();
            if (d03 != null) {
                d03.setArea(this.$area);
            }
            ((a) this.this$0.L()).A0().n();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserActivity$onClickAddress$1$1$1(EditUserActivity editUserActivity) {
        super(3);
        this.this$0 = editUserActivity;
    }

    @Override // h.k2.u.q
    public /* bridge */ /* synthetic */ t1 invoke(String str, String str2, String str3) {
        invoke2(str, str2, str3);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str, @d String str2, @d String str3) {
        BinderKt.p(BinderKt.k(e.g.d.a.j(a.C0((a) this.this$0.L(), null, null, str, str2, str3, null, null, null, 227, null), null, new AnonymousClass1(this.this$0, str, str2, str3), 1, null), this.this$0, false, 2, null));
    }
}
