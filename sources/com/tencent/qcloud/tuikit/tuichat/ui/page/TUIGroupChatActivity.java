package com.tencent.qcloud.tuikit.tuichat.ui.page;

import android.os.Bundle;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;

/* loaded from: classes3.dex */
public class TUIGroupChatActivity extends TUIBaseChatActivity {
    private static final String TAG = TUIC2CChatActivity.class.getSimpleName();
    private TUIGroupChatFragment chatFragment;
    private GroupChatPresenter presenter;

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatActivity
    public void initChat(ChatInfo chatInfo) {
        String str = TAG;
        TUIChatLog.i(str, "inti chat " + chatInfo);
        if (!TUIChatUtils.isGroupChat(chatInfo.getType())) {
            TUIChatLog.e(str, "init group chat failed , chatInfo = " + chatInfo);
            ToastUtil.toastShortMessage("init group chat failed.");
        }
        this.chatFragment = new TUIGroupChatFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TUIChatConstants.CHAT_INFO, (GroupInfo) chatInfo);
        this.chatFragment.setArguments(bundle);
        GroupChatPresenter groupChatPresenter = new GroupChatPresenter();
        this.presenter = groupChatPresenter;
        groupChatPresenter.initListener();
        this.chatFragment.setPresenter(this.presenter);
        getSupportFragmentManager().beginTransaction().replace(R.id.empty_view, this.chatFragment).commitAllowingStateLoss();
    }
}
