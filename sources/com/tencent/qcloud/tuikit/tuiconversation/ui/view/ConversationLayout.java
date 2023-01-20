package com.tencent.qcloud.tuikit.tuiconversation.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuiconversation.R;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter;
import com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationLayout;
import com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ConversationLayout extends RelativeLayout implements IConversationLayout {
    private ConversationListLayout mConversationList;
    private ConversationPresenter presenter;

    public ConversationLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        RelativeLayout.inflate(getContext(), R.layout.conversation_layout, this);
        this.mConversationList = (ConversationListLayout) findViewById(R.id.conversation_list);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationLayout
    public void clearConversationMessage(ConversationInfo conversationInfo) {
        ConversationPresenter conversationPresenter = this.presenter;
        if (conversationPresenter != null) {
            conversationPresenter.clearConversationMessage(conversationInfo);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationLayout
    public void deleteConversation(ConversationInfo conversationInfo) {
        ConversationPresenter conversationPresenter = this.presenter;
        if (conversationPresenter != null) {
            conversationPresenter.deleteConversation(conversationInfo);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationLayout
    public ConversationListLayout getConversationList() {
        return this.mConversationList;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ILayout
    public TitleBarLayout getTitleBar() {
        return null;
    }

    public void initDefault() {
        ConversationListAdapter conversationListAdapter = new ConversationListAdapter();
        initSearchView(conversationListAdapter);
        this.mConversationList.setAdapter((IConversationListAdapter) conversationListAdapter);
        ConversationPresenter conversationPresenter = this.presenter;
        if (conversationPresenter != null) {
            conversationPresenter.setAdapter(conversationListAdapter);
        }
        this.mConversationList.loadConversation(0L);
    }

    public void initSearchView(ConversationListAdapter conversationListAdapter) {
        View view;
        HashMap hashMap = new HashMap();
        hashMap.put("context", getContext());
        Map<String, Object> extensionInfo = TUICore.getExtensionInfo(TUIConstants.TUIConversation.EXTENSION_SEARCH, hashMap);
        if (extensionInfo == null || (view = (View) extensionInfo.get(TUIConstants.TUIConversation.SEARCH_VIEW)) == null) {
            return;
        }
        conversationListAdapter.setSearchView(view);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationLayout
    public void setConversationTop(ConversationInfo conversationInfo, IUIKitCallback iUIKitCallback) {
        ConversationPresenter conversationPresenter = this.presenter;
        if (conversationPresenter != null) {
            conversationPresenter.setConversationTop(conversationInfo, iUIKitCallback);
        }
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ILayout
    public void setParentLayout(Object obj) {
    }

    public void setPresenter(ConversationPresenter conversationPresenter) {
        this.presenter = conversationPresenter;
        ConversationListLayout conversationListLayout = this.mConversationList;
        if (conversationListLayout != null) {
            conversationListLayout.setPresenter(conversationPresenter);
        }
    }

    public ConversationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ConversationLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
