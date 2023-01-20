package com.jihuanshe.adapter;

import android.view.View;
import com.jihuanshe.model.ReplyDetailInfo;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListAdapter$onClickFavor$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReplyListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListAdapter$onClickFavor$1(ReplyListAdapter replyListAdapter) {
        super(1);
        this.this$0 = replyListAdapter;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Object tag = view.getTag(view.getId());
        if (tag instanceof ReplyDetailInfo) {
            this.this$0.B().H0((ReplyDetailInfo) tag);
            List<ReplyDetailInfo> d2 = this.this$0.d();
            Integer valueOf = d2 == null ? null : Integer.valueOf(d2.indexOf(tag));
            if (valueOf != null && valueOf.intValue() >= 0) {
                this.this$0.notifyItemChanged(valueOf.intValue());
            } else {
                this.this$0.notifyDataSetChanged();
            }
        }
    }
}
