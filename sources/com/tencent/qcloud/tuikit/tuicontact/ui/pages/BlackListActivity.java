package com.tencent.qcloud.tuikit.tuicontact.ui.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView;

/* loaded from: classes3.dex */
public class BlackListActivity extends BaseLightActivity {
    private ContactListView mListView;
    private TitleBarLayout mTitleBar;
    private ContactPresenter presenter;

    private void init() {
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.black_list_titlebar);
        this.mTitleBar = titleBarLayout;
        titleBarLayout.setTitle(getResources().getString(R.string.blacklist), ITitleBarLayout.Position.MIDDLE);
        this.mTitleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.BlackListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BlackListActivity.this.finish();
            }
        });
        this.mTitleBar.getRightGroup().setVisibility(8);
        ContactListView contactListView = (ContactListView) findViewById(R.id.black_list);
        this.mListView = contactListView;
        contactListView.setOnItemClickListener(new ContactListView.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.BlackListActivity.2
            @Override // com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView.OnItemClickListener
            public void onItemClick(int i2, ContactItemBean contactItemBean) {
                Intent intent = new Intent(BlackListActivity.this, FriendProfileActivity.class);
                intent.putExtra("content", contactItemBean);
                BlackListActivity.this.startActivity(intent);
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
        this.mListView.setPresenter(contactPresenter);
        this.presenter.setContactListView(this.mListView);
        this.presenter.setBlackListListener();
        this.mListView.loadDataSource(2);
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.contact_blacklist_activity);
        init();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        loadDataSource();
    }
}
