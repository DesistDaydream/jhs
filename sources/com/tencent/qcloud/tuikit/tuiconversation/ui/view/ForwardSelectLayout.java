package com.tencent.qcloud.tuikit.tuiconversation.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuiconversation.R;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter;
import com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationLayout;
import com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter;

/* loaded from: classes3.dex */
public class ForwardSelectLayout extends RelativeLayout implements IConversationLayout {
    private ConversationListLayout conversationList;
    private ConversationPresenter presenter;
    private TitleBarLayout titleBarLayout;

    public ForwardSelectLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        RelativeLayout.inflate(getContext(), R.layout.forward_layout, this);
        this.titleBarLayout = (TitleBarLayout) findViewById(R.id.conversation_title);
        this.conversationList = (ConversationListLayout) findViewById(R.id.conversation_list);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationLayout
    public void clearConversationMessage(ConversationInfo conversationInfo) {
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationLayout
    public void deleteConversation(ConversationInfo conversationInfo) {
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationLayout
    public ConversationListLayout getConversationList() {
        return this.conversationList;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ILayout
    public TitleBarLayout getTitleBar() {
        return this.titleBarLayout;
    }

    public void initDefault() {
        ConversationListAdapter conversationListAdapter = new ConversationListAdapter();
        conversationListAdapter.setForwardFragment(true);
        this.conversationList.setAdapter((IConversationListAdapter) conversationListAdapter);
        this.presenter.setAdapter(conversationListAdapter);
        this.presenter.loadConversation(0L);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationLayout
    public void setConversationTop(ConversationInfo conversationInfo, IUIKitCallback iUIKitCallback) {
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ILayout
    public void setParentLayout(Object obj) {
    }

    public void setPresenter(ConversationPresenter conversationPresenter) {
        this.presenter = conversationPresenter;
        ConversationListLayout conversationListLayout = this.conversationList;
        if (conversationListLayout != null) {
            conversationListLayout.setPresenter(conversationPresenter);
        }
    }

    public ForwardSelectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ForwardSelectLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
