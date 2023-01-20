package com.jihuanshe.adapter;

import android.view.View;
import com.jihuanshe.model.TopCommentInfo;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.ui.page.detail.CardDetailActivity;
import com.jihuanshe.ui.page.detail.CardPackDetailActivity;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import com.jihuanshe.viewmodel.detail.CardPackDetailViewModel;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CommentAdapter$onClickLike$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CommentAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentAdapter$onClickLike$1(CommentAdapter commentAdapter) {
        super(1);
        this.this$0 = commentAdapter;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Object tag = view.getTag(view.getId());
        if (tag instanceof TopCommentInfo) {
            if (this.this$0.v() instanceof CardDetailActivity) {
                ((CardDetailActivity) this.this$0.v()).w1(STATConstant.OP_CARD_OR_PACK_DETAIL.FAVOR_HOT_REVIEW);
                ((CardDetailViewModel) ((CardDetailActivity) this.this$0.v()).L()).d1((TopCommentInfo) tag);
            } else if (this.this$0.v() instanceof CardPackDetailActivity) {
                ((CardPackDetailActivity) this.this$0.v()).C0(STATConstant.OP_CARD_OR_PACK_DETAIL.FAVOR_HOT_REVIEW);
                ((CardPackDetailViewModel) ((CardPackDetailActivity) this.this$0.v()).L()).I0((TopCommentInfo) tag);
            }
            List<TopCommentInfo> d2 = this.this$0.d();
            Integer valueOf = d2 == null ? null : Integer.valueOf(d2.indexOf(tag));
            if (valueOf != null && valueOf.intValue() >= 0) {
                this.this$0.notifyItemChanged(valueOf.intValue());
            } else {
                this.this$0.notifyDataSetChanged();
            }
        }
    }
}
