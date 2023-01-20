package com.jihuanshe.adapter;

import android.view.View;
import com.jihuanshe.model.ReplyDetailInfo;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListAdapter$onClickContent$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReplyListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListAdapter$onClickContent$1(ReplyListAdapter replyListAdapter) {
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
            p<View, Integer, t1> a = this.this$0.getActivity().v0().a();
            List<ReplyDetailInfo> d2 = this.this$0.d();
            a.invoke(view, Integer.valueOf(d2 == null ? -1 : d2.indexOf(tag)));
        }
    }
}
