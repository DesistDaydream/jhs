package com.jihuanshe.ui.page.detail;

import android.widget.EditText;
import android.widget.TextView;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.AtUserBean;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.utils.StringUtil;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import e.g.d.a;
import e.l.q.c.o0;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.t0;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$onEditAction$1 extends Lambda implements p<TextView, Integer, Boolean> {
    public final /* synthetic */ ReviewListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.ReviewListActivity$onEditAction$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ ReviewListActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReviewListActivity reviewListActivity) {
            super(1);
            this.this$0 = reviewListActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            EditText l0;
            ((ReviewListViewModel) this.this$0.L()).K0().setValue(Boolean.FALSE);
            this.this$0.F();
            l0 = this.this$0.l0();
            l0.setText("");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$onEditAction$1(ReviewListActivity reviewListActivity) {
        super(2);
        this.this$0 = reviewListActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num) {
        return Boolean.valueOf(invoke(textView, num.intValue()));
    }

    public final boolean invoke(@d TextView textView, int i2) {
        o0 o0Var;
        EditText l0;
        String obj;
        Integer reviewID;
        EditText l02;
        if (i2 == 4 && this.this$0.h0() != null) {
            o0Var = this.this$0.M;
            List<AtUserBean> g2 = t0.g(o0Var == null ? null : o0Var.f());
            if (g2 == null || g2.size() <= 0) {
                l0 = this.this$0.l0();
                obj = l0.getText().toString();
            } else {
                StringUtil stringUtil = StringUtil.a;
                l02 = this.this$0.l0();
                obj = stringUtil.e(l02, g2);
            }
            if (obj.length() > 0) {
                ReviewListViewModel reviewListViewModel = (ReviewListViewModel) this.this$0.L();
                ReviewListInfo h0 = this.this$0.h0();
                a.j(BinderKt.k(BinderKt.p(reviewListViewModel.P0((h0 == null || (reviewID = h0.getReviewID()) == null) ? 0 : reviewID.intValue(), obj)), this.this$0, false, 2, null), null, new AnonymousClass1(this.this$0), 1, null);
            } else {
                e.l.h.j.b.e.h(this.this$0, "输入内容为空", null, null, null, 0, null, 62, null);
            }
        }
        return true;
    }
}
