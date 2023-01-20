package com.jihuanshe.ui.page.detail;

import android.widget.TextView;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.AtUserBean;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.utils.StringUtil;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import com.vector.util.Res;
import e.g.d.a;
import e.l.q.c.o0;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.t0;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$onEditAction$1 extends Lambda implements p<TextView, Integer, Boolean> {
    public final /* synthetic */ ReplyListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.ReplyListActivity$onEditAction$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ ReplyListActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReplyListActivity replyListActivity) {
            super(1);
            this.this$0 = replyListActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            this.this$0.J0(null);
            this.this$0.l0().setHint(Res.w(Res.a, R.string.comment_edit_hint, null, 2, null));
            this.this$0.y0().K0().setValue(Boolean.FALSE);
            ReplyListViewModel replyListViewModel = (ReplyListViewModel) this.this$0.L();
            int intValue = this.this$0.x0().intValue();
            Pair<String, String> value = this.this$0.y0().B0().getValue();
            ReplyListViewModel.D0(replyListViewModel, intValue, value != null ? value.getSecond() : null, null, 4, null);
            this.this$0.l0().setText("");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$onEditAction$1(ReplyListActivity replyListActivity) {
        super(2);
        this.this$0 = replyListActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num) {
        return Boolean.valueOf(invoke(textView, num.intValue()));
    }

    public final boolean invoke(@d TextView textView, int i2) {
        o0 o0Var;
        if (i2 == 4) {
            o0Var = this.this$0.K;
            List<AtUserBean> g2 = t0.g(o0Var == null ? null : o0Var.f());
            String obj = (g2 == null || g2.size() <= 0) ? this.this$0.l0().getText().toString() : StringUtil.a.e(this.this$0.l0(), g2);
            if (obj.length() > 0) {
                ReviewListViewModel y0 = this.this$0.y0();
                ReplyDetailInfo j0 = this.this$0.j0();
                Integer valueOf = j0 == null ? null : Integer.valueOf(j0.getId());
                if (valueOf == null) {
                    valueOf = this.this$0.x0();
                }
                a.j(BinderKt.k(BinderKt.p(y0.P0(valueOf.intValue(), obj)), this.this$0, false, 2, null), null, new AnonymousClass1(this.this$0), 1, null);
            } else {
                e.l.h.j.b.e.h(this.this$0, "输入内容为空", null, null, null, 0, null, 62, null);
            }
        }
        return true;
    }
}
