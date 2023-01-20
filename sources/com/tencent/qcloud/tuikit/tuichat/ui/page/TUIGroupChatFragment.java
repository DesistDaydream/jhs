package com.tencent.qcloud.tuikit.tuichat.ui.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import e.s.a.b.a.b.a.a;

/* loaded from: classes3.dex */
public class TUIGroupChatFragment extends TUIBaseChatFragment {
    private static final String TAG = TUIGroupChatFragment.class.getSimpleName();
    private GroupInfo groupInfo;
    private GroupChatPresenter presenter;

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment
    public ChatInfo getChatInfo() {
        return this.groupInfo;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment
    public void initView() {
        super.initView();
        this.chatView.setPresenter(this.presenter);
        this.presenter.setGroupInfo(this.groupInfo);
        this.chatView.setChatInfo(this.groupInfo);
        this.chatView.getMessageLayout().setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.TUIGroupChatFragment.1
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public /* synthetic */ void onMessageClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                a.$default$onMessageClick(this, view, i2, tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                TUIGroupChatFragment.this.chatView.getMessageLayout().showItemPopMenu(i2 - 1, tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onReEditRevokeMessage(View view, int i2, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean == null) {
                    return;
                }
                int msgType = tUIMessageBean.getMsgType();
                if (msgType != 1) {
                    String str = TUIGroupChatFragment.TAG;
                    TUIChatLog.e(str, "error type: " + msgType);
                    return;
                }
                TUIGroupChatFragment.this.chatView.getInputLayout().appendText(tUIMessageBean.getV2TIMMessage().getTextElem().getText());
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onRecallClick(View view, int i2, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public /* synthetic */ void onReplyMessageClick(View view, int i2, String str) {
                a.$default$onReplyMessageClick(this, view, i2, str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public /* synthetic */ void onSendFailBtnClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                a.$default$onSendFailBtnClick(this, view, i2, tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onTextSelected(View view, int i2, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean instanceof TextMessageBean) {
                    String str = TUIGroupChatFragment.TAG;
                    TUIChatLog.d(str, "chatfragment onTextSelected selectedText = " + ((TextMessageBean) tUIMessageBean).getSelectText());
                }
                TUIGroupChatFragment.this.chatView.getMessageLayout().setSelectedPosition(i2);
                TUIGroupChatFragment.this.chatView.getMessageLayout().showItemPopMenu(i2 - 1, tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean == null) {
                    return;
                }
                ChatInfo chatInfo = new ChatInfo();
                chatInfo.setId(tUIMessageBean.getSender());
                Bundle bundle = new Bundle();
                bundle.putString("chatId", chatInfo.getId());
                TUICore.startActivity("FriendProfileActivity", bundle);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onUserIconLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                String sender = tUIMessageBean.getV2TIMMessage().getSender();
                TUIGroupChatFragment.this.chatView.getInputLayout().addInputText(tUIMessageBean.getV2TIMMessage().getNickName(), sender);
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "oncreate view " + this);
        this.baseView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return this.baseView;
        }
        GroupInfo groupInfo = (GroupInfo) arguments.getSerializable(TUIChatConstants.CHAT_INFO);
        this.groupInfo = groupInfo;
        if (groupInfo == null) {
            return this.baseView;
        }
        initView();
        return this.baseView;
    }

    public void setPresenter(GroupChatPresenter groupChatPresenter) {
        this.presenter = groupChatPresenter;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment
    public GroupChatPresenter getPresenter() {
        return this.presenter;
    }
}
