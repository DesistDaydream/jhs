package com.jihuanshe.ui.page.im;

import com.jihuanshe.model.InteractNewCount;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationLayout;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListAdapter;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ImConversationFragment$onResume$1 extends Lambda implements l<InteractNewCount, t1> {
    public final /* synthetic */ ImConversationFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImConversationFragment$onResume$1(ImConversationFragment imConversationFragment) {
        super(1);
        this.this$0 = imConversationFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(InteractNewCount interactNewCount) {
        invoke2(interactNewCount);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e InteractNewCount interactNewCount) {
        ConversationLayout conversationLayout;
        ConversationListLayout conversationList;
        ConversationLayout conversationLayout2;
        ConversationListLayout conversationList2;
        ConversationLayout conversationLayout3;
        ConversationListLayout conversationList3;
        ConversationListAdapter adapter;
        conversationLayout = this.this$0.mConversationLayout;
        String str = null;
        ConversationListAdapter adapter2 = (conversationLayout == null || (conversationList = conversationLayout.getConversationList()) == null) ? null : conversationList.getAdapter();
        if (adapter2 != null) {
            adapter2.last = interactNewCount == null ? null : interactNewCount.getLastContent();
        }
        conversationLayout2 = this.this$0.mConversationLayout;
        ConversationListAdapter adapter3 = (conversationLayout2 == null || (conversationList2 = conversationLayout2.getConversationList()) == null) ? null : conversationList2.getAdapter();
        if (adapter3 != null) {
            if (!f0.g(interactNewCount == null ? null : interactNewCount.getTotalUnreadCount(), "0") && interactNewCount != null) {
                str = interactNewCount.getTotalUnreadCount();
            }
            adapter3.unread = str;
        }
        conversationLayout3 = this.this$0.mConversationLayout;
        if (conversationLayout3 == null || (conversationList3 = conversationLayout3.getConversationList()) == null || (adapter = conversationList3.getAdapter()) == null) {
            return;
        }
        adapter.notifyItemChanged(0);
    }
}
