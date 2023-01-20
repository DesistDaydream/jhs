package com.jihuanshe.ui.page.shop;

import android.view.View;
import android.widget.EditText;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.shop.SellerConfirmViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import h.t2.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmActivity$onCommitChangeAccount$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerConfirmActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.shop.SellerConfirmActivity$onCommitChangeAccount$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ SellerConfirmActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellerConfirmActivity sellerConfirmActivity) {
            super(1);
            this.this$0 = sellerConfirmActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            BinderKt.s(((SellerConfirmViewModel) this.this$0.L()).R0(), this.this$0, false, false, 6, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmActivity$onCommitChangeAccount$1(SellerConfirmActivity sellerConfirmActivity) {
        super(1);
        this.this$0 = sellerConfirmActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        String str;
        EditText v0;
        String str2;
        String value = ((SellerConfirmViewModel) this.this$0.L()).G0().getValue();
        if (!(value == null || value.length() == 0)) {
            str = this.this$0.I;
            if (!(str == null || str.length() == 0)) {
                v0 = this.this$0.v0();
                String obj = v0.getText().toString();
                if (!(obj.length() == 0)) {
                    str2 = this.this$0.I;
                    BinderKt.p(BinderKt.k(a.j(((SellerConfirmViewModel) this.this$0.L()).z0(value, str2, u.k2(obj, ExpandableTextView.N, "", false, 4, null)), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null));
                    return;
                }
                e.l.h.j.b.e.h(this.this$0, "银行账号不能为空", null, null, null, 0, null, 62, null);
                return;
            }
            e.l.h.j.b.e.h(this.this$0, "请先选择开户所在地", null, null, null, 0, null, 62, null);
            return;
        }
        e.l.h.j.b.e.h(this.this$0, "请先选择开户银行", null, null, null, 0, null, 62, null);
    }
}
