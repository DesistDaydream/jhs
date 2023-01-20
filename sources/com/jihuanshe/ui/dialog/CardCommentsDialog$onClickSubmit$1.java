package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.model.AtUserBean;
import com.jihuanshe.model.CommentBean;
import com.jihuanshe.utils.StringUtil;
import e.l.h.j.b.e;
import e.l.q.c.o0;
import h.k2.u.l;
import h.k2.v.t0;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardCommentsDialog$onClickSubmit$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardCommentsDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardCommentsDialog$onClickSubmit$1(CardCommentsDialog cardCommentsDialog) {
        super(1);
        this.this$0 = cardCommentsDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        o0 o0Var;
        String obj;
        if (this.this$0.getBinding().f13546c.getRating() < 1.0f) {
            e.f(this.this$0, "未选择评分星数", (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        } else if (this.this$0.getBinding().b.getText().toString().length() <= 200) {
            o0Var = this.this$0.x;
            List<AtUserBean> g2 = t0.g(o0Var == null ? null : o0Var.f());
            if (g2 != null && g2.size() > 0) {
                obj = StringUtil.a.e(this.this$0.getBinding().b, g2);
            } else {
                obj = this.this$0.getBinding().b.getText().toString();
            }
            this.this$0.getSubmit().invoke(new CommentBean((int) (this.this$0.getBinding().f13546c.getRating() * 2), obj));
            this.this$0.h();
        } else {
            e.f(this.this$0, "评论字数不能超过200字", (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        }
    }
}
