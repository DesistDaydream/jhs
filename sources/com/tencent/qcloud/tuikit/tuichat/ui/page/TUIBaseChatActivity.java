package com.tencent.qcloud.tuikit.tuichat.ui.page;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.DraftInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class TUIBaseChatActivity extends BaseLightActivity {
    private static final String TAG = TUIBaseChatActivity.class.getSimpleName();

    private void chat(Intent intent) {
        Bundle extras = intent.getExtras();
        String str = TAG;
        TUIChatLog.i(str, "bundle: " + extras + " intent: " + intent);
        ChatInfo chatInfo = getChatInfo(intent);
        StringBuilder sb = new StringBuilder();
        sb.append("start chatActivity chatInfo: ");
        sb.append(chatInfo);
        TUIChatLog.i(str, sb.toString());
        if (chatInfo != null) {
            initChat(chatInfo);
            return;
        }
        ToastUtil.toastShortMessage("init chat failed , chatInfo is empty.");
        TUIChatLog.e(str, "init chat failed , chatInfo is empty.");
        finish();
    }

    private ChatInfo getChatInfo(Intent intent) {
        ChatInfo groupInfo;
        int intExtra = intent.getIntExtra(TUIConstants.TUIChat.CHAT_TYPE, 0);
        if (intExtra == 1) {
            groupInfo = new ChatInfo();
        } else if (intExtra != 2) {
            return null;
        } else {
            groupInfo = new GroupInfo();
        }
        groupInfo.setType(intExtra);
        groupInfo.setId(intent.getStringExtra("chatId"));
        groupInfo.setChatName(intent.getStringExtra(TUIConstants.TUIChat.CHAT_NAME));
        DraftInfo draftInfo = new DraftInfo();
        draftInfo.setDraftText(intent.getStringExtra(TUIConstants.TUIChat.DRAFT_TEXT));
        draftInfo.setDraftTime(intent.getLongExtra(TUIConstants.TUIChat.DRAFT_TIME, 0L));
        groupInfo.setDraft(draftInfo);
        groupInfo.setTopChat(intent.getBooleanExtra(TUIConstants.TUIChat.IS_TOP_CHAT, false));
        groupInfo.setLocateMessage(ChatMessageBuilder.buildMessage((V2TIMMessage) intent.getSerializableExtra(TUIConstants.TUIChat.LOCATE_MESSAGE)));
        groupInfo.setAtInfoList((List) intent.getSerializableExtra(TUIConstants.TUIChat.AT_INFO_LIST));
        if (intExtra == 2) {
            GroupInfo groupInfo2 = (GroupInfo) groupInfo;
            groupInfo2.setFaceUrl(intent.getStringExtra(TUIConstants.TUIChat.FACE_URL));
            groupInfo2.setGroupName(intent.getStringExtra("groupName"));
            groupInfo2.setGroupType(intent.getStringExtra(TUIConstants.TUIChat.GROUP_TYPE));
            groupInfo2.setJoinType(intent.getIntExtra(TUIConstants.TUIChat.JOIN_TYPE, 0));
            groupInfo2.setMemberCount(intent.getIntExtra(TUIConstants.TUIChat.MEMBER_COUNT, 0));
            groupInfo2.setMessageReceiveOption(intent.getBooleanExtra(TUIConstants.TUIChat.RECEIVE_OPTION, false));
            groupInfo2.setNotice(intent.getStringExtra(TUIConstants.TUIChat.NOTICE));
            groupInfo2.setOwner(intent.getStringExtra(TUIConstants.TUIChat.OWNER));
            groupInfo2.setMemberDetails((List) intent.getSerializableExtra(TUIConstants.TUIChat.MEMBER_DETAILS));
        }
        if (TextUtils.isEmpty(groupInfo.getId())) {
            return null;
        }
        return groupInfo;
    }

    private void startSplashActivity(Bundle bundle) {
        TUICore.startActivity(this, "SplashActivity", bundle);
        finish();
    }

    public abstract void initChat(ChatInfo chatInfo);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i2, i3, intent);
        if (i3 != 3 || intent == null || i2 != 11 || (stringArrayListExtra = intent.getStringArrayListExtra("list")) == null || stringArrayListExtra.isEmpty()) {
            return;
        }
        intent.putExtra(TUIConstants.TUICalling.PARAM_NAME_USERIDS, (String[]) stringArrayListExtra.toArray(new String[0]));
        HashMap hashMap = new HashMap();
        for (String str : intent.getExtras().keySet()) {
            hashMap.put(str, intent.getExtras().get(str));
        }
        TUICore.callService("TUICallingService", "call", hashMap);
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "onCreate " + this);
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity);
        chat(getIntent());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        TUIChatLog.i(TAG, "onNewIntent");
        super.onNewIntent(intent);
        chat(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        TUIChatLog.i(TAG, "onResume");
        super.onResume();
    }
}
