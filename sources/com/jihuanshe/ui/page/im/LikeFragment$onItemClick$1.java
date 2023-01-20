package com.jihuanshe.ui.page.im;

import android.view.View;
import com.jihuanshe.model.InteractData;
import com.jihuanshe.ui.page.detail.ReplyListActivityCreator;
import com.jihuanshe.viewmodel.im.LikeViewModel;
import e.g.d.a;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LikeFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ LikeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LikeFragment$onItemClick$1(LikeFragment likeFragment) {
        super(2);
        this.this$0 = likeFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        Integer msgId;
        List<InteractData> value = ((LikeViewModel) this.this$0.T()).s0().getValue();
        InteractData interactData = value == null ? null : (InteractData) CollectionsKt___CollectionsKt.J2(value, i2);
        if (interactData == null) {
            return;
        }
        if (!interactData.isRead() && (msgId = interactData.getMsgId()) != null) {
            LikeFragment likeFragment = this.this$0;
            a.j(((LikeViewModel) likeFragment.T()).t0(msgId.intValue()), null, new LikeFragment$onItemClick$1$1$1(interactData, likeFragment, i2), 1, null);
        }
        ReplyListActivityCreator.create(interactData.getReviewId()).start(this.this$0.getActivity());
    }
}
