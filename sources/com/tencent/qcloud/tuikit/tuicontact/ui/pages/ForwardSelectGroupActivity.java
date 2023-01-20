package com.tencent.qcloud.tuikit.tuicontact.ui.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.LineControllerView;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.activities.SelectionActivity;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.ForwardContactSelectorAdapter;
import com.tencent.qcloud.tuikit.tuicontact.util.ContactUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class ForwardSelectGroupActivity extends BaseLightActivity {
    private static final String TAG = ForwardSelectGroupActivity.class.getSimpleName();
    private ForwardContactSelectorAdapter mAdapter;
    private ContactListView mContactListView;
    private boolean mCreating;
    private RecyclerView mForwardSelectlistView;
    private RelativeLayout mForwardSelectlistViewLayout;
    private LineControllerView mJoinType;
    private TextView mSureView;
    private TitleBarLayout mTitleBar;
    private ContactPresenter presenter;
    private ArrayList<GroupMemberInfo> mMembers = new ArrayList<>();
    private int mGroupType = -1;
    private int mJoinTypeIndex = 2;
    private ArrayList<String> mJoinTypes = new ArrayList<>();
    private ArrayList<String> mGroupTypeValue = new ArrayList<>();
    private boolean isCreateNewChat = true;
    private List<String> mSelectConversationIcons = new ArrayList();
    private List<ConversationInfo> mContactDataSource = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public void createGroupChat() {
        if (this.mCreating || this.mMembers.isEmpty()) {
            return;
        }
        if (this.mMembers.size() == 1) {
            Intent intent = new Intent();
            HashMap hashMap = new HashMap();
            hashMap.put(this.mMembers.get(0).getAccount(), Boolean.FALSE);
            intent.putExtra("forward_select_conversation_key", hashMap);
            setResult(103, intent);
            finish();
            return;
        }
        GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
        groupMemberInfo.setAccount(ContactUtils.getLoginUser());
        this.mMembers.add(groupMemberInfo);
        GroupInfo groupInfo = new GroupInfo();
        String loginUser = ContactUtils.getLoginUser();
        for (int i2 = 1; i2 < this.mMembers.size(); i2++) {
            loginUser = loginUser + "、" + this.mMembers.get(i2).getAccount();
        }
        if (loginUser.length() > 20) {
            loginUser = loginUser.substring(0, 17) + "...";
        }
        groupInfo.setChatName(loginUser);
        groupInfo.setGroupName(loginUser);
        groupInfo.setMemberDetails(this.mMembers);
        groupInfo.setGroupType("Public");
        groupInfo.setJoinType(0);
        this.mCreating = true;
        this.presenter.createGroupChat(groupInfo, new IUIKitCallback<String>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.ForwardSelectGroupActivity.6
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i3, String str2) {
                ForwardSelectGroupActivity.this.mCreating = false;
                ToastUtil.toastLongMessage("createGroupChat fail:" + i3 + "=" + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(String str) {
                Intent intent2 = new Intent();
                HashMap hashMap2 = new HashMap();
                hashMap2.put(str, Boolean.TRUE);
                intent2.putExtra("forward_select_conversation_key", hashMap2);
                ForwardSelectGroupActivity.this.setResult(103, intent2);
                ForwardSelectGroupActivity.this.finish();
            }
        });
    }

    private String getMembersUserId() {
        String str = "";
        if (this.mMembers.size() == 0) {
            return "";
        }
        for (int i2 = 0; i2 < this.mMembers.size(); i2++) {
            str = (str + this.mMembers.get(i2).getAccount()) + ExpandableTextView.N;
        }
        return str;
    }

    private void init() {
        Intent intent = getIntent();
        if (intent != null) {
            this.isCreateNewChat = intent.getBooleanExtra("forward_create_new_chat", false);
        }
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.group_create_title_bar);
        this.mTitleBar = titleBarLayout;
        titleBarLayout.getRightGroup().setVisibility(8);
        this.mTitleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.ForwardSelectGroupActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForwardSelectGroupActivity.this.finish();
            }
        });
        LineControllerView lineControllerView = (LineControllerView) findViewById(R.id.group_type_join);
        this.mJoinType = lineControllerView;
        lineControllerView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.ForwardSelectGroupActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForwardSelectGroupActivity.this.showJoinTypePickerView();
            }
        });
        this.mJoinType.setCanNav(true);
        this.mJoinType.setContent("Public");
        this.mJoinType.setVisibility(8);
        this.mContactListView = (ContactListView) findViewById(R.id.group_create_member_list);
        ContactPresenter contactPresenter = new ContactPresenter();
        this.presenter = contactPresenter;
        this.mContactListView.setPresenter(contactPresenter);
        this.presenter.setFriendListListener();
        this.presenter.setContactListView(this.mContactListView);
        this.mContactListView.loadDataSource(1);
        this.mContactListView.setOnSelectChangeListener(new ContactListView.OnSelectChangedListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.ForwardSelectGroupActivity.3
            @Override // com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView.OnSelectChangedListener
            public void onSelectChanged(ContactItemBean contactItemBean, boolean z) {
                if (z) {
                    GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                    groupMemberInfo.setAccount(contactItemBean.getId());
                    groupMemberInfo.setIconUrl(contactItemBean.getAvatarUrl());
                    ForwardSelectGroupActivity.this.mMembers.add(groupMemberInfo);
                } else {
                    for (int size = ForwardSelectGroupActivity.this.mMembers.size() - 1; size >= 0; size--) {
                        if (((GroupMemberInfo) ForwardSelectGroupActivity.this.mMembers.get(size)).getAccount().equals(contactItemBean.getId())) {
                            ForwardSelectGroupActivity.this.mMembers.remove(size);
                        }
                    }
                }
                ForwardSelectGroupActivity.this.refreshSelectConversations();
            }
        });
        setGroupType(1);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.forward_contact_select_list_layout);
        this.mForwardSelectlistViewLayout = relativeLayout;
        relativeLayout.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.forward_contact_select_list);
        this.mForwardSelectlistView = recyclerView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(this, 0, false));
        ForwardContactSelectorAdapter forwardContactSelectorAdapter = new ForwardContactSelectorAdapter(this);
        this.mAdapter = forwardContactSelectorAdapter;
        this.mForwardSelectlistView.setAdapter(forwardContactSelectorAdapter);
        TextView textView = (TextView) findViewById(R.id.btn_msg_ok);
        this.mSureView = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.ForwardSelectGroupActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForwardSelectGroupActivity.this.isCreateNewChat) {
                    ForwardSelectGroupActivity.this.createGroupChat();
                    return;
                }
                Intent intent2 = new Intent();
                HashMap hashMap = new HashMap();
                if (ForwardSelectGroupActivity.this.mMembers != null && ForwardSelectGroupActivity.this.mMembers.size() != 0) {
                    for (int i2 = 0; i2 < ForwardSelectGroupActivity.this.mMembers.size(); i2++) {
                        hashMap.put(((GroupMemberInfo) ForwardSelectGroupActivity.this.mMembers.get(i2)).getAccount(), ((GroupMemberInfo) ForwardSelectGroupActivity.this.mMembers.get(i2)).getIconUrl());
                    }
                }
                intent2.putExtra("forward_select_conversation_key", hashMap);
                ForwardSelectGroupActivity.this.setResult(102, intent2);
                ForwardSelectGroupActivity.this.finish();
            }
        });
        refreshSelectConversations();
    }

    private void refreshMembers() {
        List<ConversationInfo> list = this.mContactDataSource;
        if (list != null && list.size() != 0) {
            for (int i2 = 0; i2 < this.mContactDataSource.size(); i2++) {
                GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                groupMemberInfo.setAccount(this.mContactDataSource.get(i2).getId());
                groupMemberInfo.setIconUrl((String) this.mContactDataSource.get(i2).getIconUrlList().get(0));
                this.mMembers.add(groupMemberInfo);
            }
            return;
        }
        this.mMembers.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshSelectConversations() {
        this.mSelectConversationIcons.clear();
        ArrayList<GroupMemberInfo> arrayList = this.mMembers;
        if (arrayList != null && arrayList.size() != 0) {
            for (int i2 = 0; i2 < this.mMembers.size(); i2++) {
                this.mSelectConversationIcons.add(this.mMembers.get(i2).getIconUrl());
            }
        }
        this.mAdapter.setDataSource(this.mSelectConversationIcons);
        List<String> list = this.mSelectConversationIcons;
        if (list != null && list.size() != 0) {
            this.mForwardSelectlistViewLayout.setVisibility(0);
            this.mSureView.setVisibility(0);
            TextView textView = this.mSureView;
            textView.setText(getString(R.string.sure) + "(" + this.mSelectConversationIcons.size() + ")");
            return;
        }
        this.mSureView.setText(getString(R.string.sure));
        this.mSureView.setVisibility(8);
        this.mForwardSelectlistViewLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showJoinTypePickerView() {
        Bundle bundle = new Bundle();
        bundle.putString("title", getResources().getString(R.string.group_join_type));
        bundle.putStringArrayList("list", this.mJoinTypes);
        bundle.putInt("default_select_item_index", this.mJoinTypeIndex);
        SelectionActivity.startListSelection(this, bundle, new SelectionActivity.OnResultReturnListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.ForwardSelectGroupActivity.5
            @Override // com.tencent.qcloud.tuicore.component.activities.SelectionActivity.OnResultReturnListener
            public void onReturn(Object obj) {
                Integer num = (Integer) obj;
                ForwardSelectGroupActivity.this.mJoinType.setContent((String) ForwardSelectGroupActivity.this.mJoinTypes.get(num.intValue()));
                ForwardSelectGroupActivity.this.mJoinTypeIndex = num.intValue();
            }
        });
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forward_select_group_contact);
        init();
    }

    public void setGroupType(int i2) {
        this.mGroupType = i2;
        this.mTitleBar.setTitle(getResources().getString(R.string.contact_title), ITitleBarLayout.Position.MIDDLE);
        this.mJoinType.setVisibility(8);
    }
}
