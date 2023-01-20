package com.tencent.qcloud.tuikit.tuicontact.ui.pages;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.imsdk.v2.V2TIMGroupApplication;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactGroupApplyInfo;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout;
import com.tencent.qcloud.tuikit.tuicontact.util.ContactUtils;

/* loaded from: classes3.dex */
public class FriendProfileActivity extends BaseLightActivity {
    private FriendProfilePresenter presenter;

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.contact_friend_profile_activity);
        FriendProfileLayout friendProfileLayout = (FriendProfileLayout) findViewById(R.id.friend_profile);
        FriendProfilePresenter friendProfilePresenter = new FriendProfilePresenter();
        this.presenter = friendProfilePresenter;
        friendProfileLayout.setPresenter(friendProfilePresenter);
        this.presenter.setFriendProfileLayout(friendProfileLayout);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("chatId");
        String stringExtra2 = intent.getStringExtra("fromUser");
        String stringExtra3 = intent.getStringExtra("fromUserNickName");
        String stringExtra4 = intent.getStringExtra("requestMsg");
        V2TIMGroupApplication v2TIMGroupApplication = (V2TIMGroupApplication) intent.getSerializableExtra("groupApplication");
        if (!TextUtils.isEmpty(stringExtra)) {
            friendProfileLayout.initData(stringExtra);
        } else if (!TextUtils.isEmpty(stringExtra2)) {
            ContactGroupApplyInfo contactGroupApplyInfo = new ContactGroupApplyInfo();
            contactGroupApplyInfo.setFromUser(stringExtra2);
            contactGroupApplyInfo.setFromUserNickName(stringExtra3);
            contactGroupApplyInfo.setRequestMsg(stringExtra4);
            contactGroupApplyInfo.setTimGroupApplication(v2TIMGroupApplication);
            friendProfileLayout.initData(contactGroupApplyInfo);
        } else {
            friendProfileLayout.initData(intent.getSerializableExtra("content"));
        }
        friendProfileLayout.setOnButtonClickListener(new FriendProfileLayout.OnButtonClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.FriendProfileActivity.1
            @Override // com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.OnButtonClickListener
            public void onDeleteFriendClick(String str) {
                FriendProfileActivity.this.finish();
            }

            @Override // com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.OnButtonClickListener
            public void onStartConversationClick(ContactItemBean contactItemBean) {
                String id = contactItemBean.getId();
                if (!TextUtils.isEmpty(contactItemBean.getRemark())) {
                    id = contactItemBean.getRemark();
                } else if (!TextUtils.isEmpty(contactItemBean.getNickName())) {
                    id = contactItemBean.getNickName();
                }
                ContactUtils.startChatActivity(contactItemBean.getId(), 1, id, "");
            }
        });
    }
}
