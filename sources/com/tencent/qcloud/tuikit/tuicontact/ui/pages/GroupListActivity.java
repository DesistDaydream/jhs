package com.tencent.qcloud.tuikit.tuicontact.ui.pages;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView;
import com.tencent.qcloud.tuikit.tuicontact.util.ContactUtils;

/* loaded from: classes3.dex */
public class GroupListActivity extends BaseLightActivity {
    private static final String TAG = GroupListActivity.class.getSimpleName();
    private ContactListView mListView;
    private TitleBarLayout mTitleBar;
    private ContactPresenter presenter;

    private void init() {
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.group_list_titlebar);
        this.mTitleBar = titleBarLayout;
        titleBarLayout.setTitle(getResources().getString(R.string.group), ITitleBarLayout.Position.LEFT);
        this.mTitleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.GroupListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupListActivity.this.finish();
            }
        });
        this.mTitleBar.setTitle(getResources().getString(R.string.add_group), ITitleBarLayout.Position.RIGHT);
        this.mTitleBar.getRightIcon().setVisibility(8);
        this.mTitleBar.setOnRightClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.GroupListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(GroupListActivity.this, AddMoreActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("isGroup", true);
                GroupListActivity.this.startActivity(intent);
            }
        });
        ContactListView contactListView = (ContactListView) findViewById(R.id.group_list);
        this.mListView = contactListView;
        contactListView.setOnItemClickListener(new ContactListView.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.GroupListActivity.3
            @Override // com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView.OnItemClickListener
            public void onItemClick(int i2, ContactItemBean contactItemBean) {
                String id = contactItemBean.getId();
                if (!TextUtils.isEmpty(contactItemBean.getRemark())) {
                    id = contactItemBean.getRemark();
                } else if (!TextUtils.isEmpty(contactItemBean.getNickName())) {
                    id = contactItemBean.getNickName();
                }
                ContactUtils.startChatActivity(contactItemBean.getId(), 2, id, contactItemBean.getGroupType());
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    public void loadDataSource() {
        ContactPresenter contactPresenter = new ContactPresenter();
        this.presenter = contactPresenter;
        contactPresenter.setFriendListListener();
        this.mListView.setIsGroupList(true);
        this.mListView.setPresenter(this.presenter);
        this.presenter.setContactListView(this.mListView);
        this.mListView.loadDataSource(3);
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.group_list_activity);
        init();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        loadDataSource();
    }
}
