package com.tencent.qcloud.tuikit.tuichat.ui.page;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.jihuanshe.model.Constants;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.fragments.BaseFragment;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import e.s.a.b.a.b.a.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class TUIBaseChatFragment extends BaseFragment {
    private static final String TAG = TUIBaseChatFragment.class.getSimpleName();
    public View baseView;
    public ChatView chatView;
    private int mForwardMode;
    private List<TUIMessageBean> mForwardSelectMsgInfos = null;
    public TitleBarLayout titleBar;

    public ChatInfo getChatInfo() {
        return null;
    }

    public ChatPresenter getPresenter() {
        return null;
    }

    public void initView() {
        ChatView chatView = (ChatView) this.baseView.findViewById(R.id.chat_layout);
        this.chatView = chatView;
        chatView.initDefault();
        TitleBarLayout titleBar = this.chatView.getTitleBar();
        this.titleBar = titleBar;
        titleBar.setFitsSystemWindows(true);
        this.titleBar.setLeftIcon(R.drawable.icon_back_msg);
        this.titleBar.getLeftIcon().setBackgroundResource(R.drawable.bg_back_icon_msg);
        this.titleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIBaseChatFragment.this.getActivity().finish();
            }
        });
        this.chatView.setForwardSelectActivityListener(new ChatView.ForwardSelectActivityListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment.2
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.ForwardSelectActivityListener
            public void onStartForwardSelectActivity(int i2, List<TUIMessageBean> list) {
                TUIBaseChatFragment.this.mForwardMode = i2;
                TUIBaseChatFragment.this.mForwardSelectMsgInfos = list;
                Bundle bundle = new Bundle();
                bundle.putInt(TUIChatConstants.FORWARD_MODE, i2);
                TUICore.startActivity(TUIBaseChatFragment.this, "TUIForwardSelectActivity", bundle, 101);
            }
        });
        this.chatView.getMessageLayout().setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment.3
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public /* synthetic */ void onMessageClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                a.$default$onMessageClick(this, view, i2, tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                TUIBaseChatFragment.this.chatView.getMessageLayout().showItemPopMenu(i2 - 1, tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onReEditRevokeMessage(View view, int i2, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean == null) {
                    return;
                }
                int msgType = tUIMessageBean.getMsgType();
                if (msgType != 1) {
                    String str = TUIBaseChatFragment.TAG;
                    TUIChatLog.e(str, "error type: " + msgType);
                    return;
                }
                TUIBaseChatFragment.this.chatView.getInputLayout().appendText(tUIMessageBean.getV2TIMMessage().getTextElem().getText());
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
                    String str = TUIBaseChatFragment.TAG;
                    TUIChatLog.d(str, "chatfragment onTextSelected selectedText = " + ((TextMessageBean) tUIMessageBean).getSelectText());
                }
                TUIBaseChatFragment.this.chatView.getMessageLayout().setSelectedPosition(i2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean == null) {
                    return;
                }
                try {
                    Intent intent = new Intent(TUIBaseChatFragment.this.getContext(), Class.forName("com.jihuanshe.ui.page.user.SellerDetailActivity"));
                    intent.addFlags(268435456);
                    intent.putExtra(Constants.KEY_PARAM_USER_ID, Integer.valueOf(tUIMessageBean.getSender()));
                    TUIBaseChatFragment.this.getContext().startActivity(intent);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onUserIconLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
            }
        });
        this.chatView.getInputLayout().setStartActivityListener(new InputView.OnStartActivityListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment.4
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.OnStartActivityListener
            public void onStartGroupMemberSelectActivity() {
                Bundle bundle = new Bundle();
                bundle.putString("group_id", TUIBaseChatFragment.this.getChatInfo().getId());
                TUICore.startActivity(TUIBaseChatFragment.this, "StartGroupMemberSelectActivity", bundle, 1);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        List<TUIMessageBean> list;
        HashMap hashMap;
        String id;
        String str;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == 3) {
            this.chatView.getInputLayout().updateInputText(intent.getStringArrayListExtra("user_namecard_select"), intent.getStringArrayListExtra("user_id_select"));
        } else if (i2 == 101 && i3 == 101 && intent != null && (list = this.mForwardSelectMsgInfos) != null && !list.isEmpty() && (hashMap = (HashMap) intent.getSerializableExtra("forward_select_conversation_key")) != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
                String str2 = (String) entry.getKey();
                ChatInfo chatInfo = getChatInfo();
                if (chatInfo == null) {
                    return;
                }
                if (TUIChatUtils.isGroupChat(chatInfo.getType())) {
                    str = getString(R.string.forward_chats);
                } else {
                    String selfNickName = TUIConfig.getSelfNickName();
                    if (TextUtils.isEmpty(selfNickName)) {
                        selfNickName = TUILogin.getLoginUser();
                    }
                    if (!TextUtils.isEmpty(getChatInfo().getChatName())) {
                        id = getChatInfo().getChatName();
                    } else {
                        id = getChatInfo().getId();
                    }
                    str = selfNickName + getString(R.string.and_text) + id + getString(R.string.forward_chats_c2c);
                }
                getPresenter().forwardMessage(this.mForwardSelectMsgInfos, booleanValue, str2, str, this.mForwardMode, str2 != null && str2.equals(chatInfo.getId()), new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatFragment.5
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str3, int i4, String str4) {
                        String str5 = TUIBaseChatFragment.TAG;
                        TUIChatLog.v(str5, "sendMessage fail:" + i4 + "=" + str4);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Object obj) {
                        TUIChatLog.v(TUIBaseChatFragment.TAG, "sendMessage onSuccess:");
                    }
                });
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "oncreate view " + this);
        this.baseView = layoutInflater.inflate(R.layout.chat_fragment, viewGroup, false);
        if (getArguments() == null) {
            return this.baseView;
        }
        return this.baseView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ChatView chatView = this.chatView;
        if (chatView != null) {
            chatView.exitChat();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ChatView chatView = this.chatView;
        if (chatView != null) {
            if (chatView.getInputLayout() != null) {
                this.chatView.getInputLayout().setDraft();
            }
            if (getPresenter() != null) {
                getPresenter().setChatFragmentShow(false);
            }
        }
        AudioPlayer.getInstance().stopPlay();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().setChatFragmentShow(true);
        }
    }
}
