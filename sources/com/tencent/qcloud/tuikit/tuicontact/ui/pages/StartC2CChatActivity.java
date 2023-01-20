package com.tencent.qcloud.tuikit.tuicontact.ui.pages;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView;
import com.tencent.qcloud.tuikit.tuicontact.util.ContactUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class StartC2CChatActivity extends BaseLightActivity {
    private static final String TAG = StartC2CChatActivity.class.getSimpleName();
    private ContactListView mContactListView;
    private List<ContactItemBean> mContacts = new ArrayList();
    private ContactItemBean mSelectedItem;
    private TitleBarLayout mTitleBar;
    private ContactPresenter presenter;

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.popup_start_c2c_chat_activity);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.start_c2c_chat_title);
        this.mTitleBar = titleBarLayout;
        titleBarLayout.setTitle(getResources().getString(R.string.sure), ITitleBarLayout.Position.RIGHT);
        this.mTitleBar.getRightIcon().setVisibility(8);
        this.mTitleBar.setOnRightClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartC2CChatActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StartC2CChatActivity.this.startConversation();
            }
        });
        this.mTitleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartC2CChatActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StartC2CChatActivity.this.finish();
            }
        });
        ContactListView contactListView = (ContactListView) findViewById(R.id.contact_list_view);
        this.mContactListView = contactListView;
        contactListView.setSingleSelectMode(true);
        ContactPresenter contactPresenter = new ContactPresenter();
        this.presenter = contactPresenter;
        contactPresenter.setFriendListListener();
        this.mContactListView.setPresenter(this.presenter);
        this.presenter.setContactListView(this.mContactListView);
        this.mContactListView.loadDataSource(1);
        this.mContactListView.setOnSelectChangeListener(new ContactListView.OnSelectChangedListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartC2CChatActivity.3
            @Override // com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView.OnSelectChangedListener
            public void onSelectChanged(ContactItemBean contactItemBean, boolean z) {
                if (z) {
                    if (StartC2CChatActivity.this.mSelectedItem == contactItemBean) {
                        return;
                    }
                    if (StartC2CChatActivity.this.mSelectedItem != null) {
                        StartC2CChatActivity.this.mSelectedItem.setSelected(false);
                    }
                    StartC2CChatActivity.this.mSelectedItem = contactItemBean;
                } else if (StartC2CChatActivity.this.mSelectedItem == contactItemBean) {
                    StartC2CChatActivity.this.mSelectedItem.setSelected(false);
                }
            }
        });
    }

    public void startConversation() {
        ContactItemBean contactItemBean = this.mSelectedItem;
        if (contactItemBean != null && contactItemBean.isSelected()) {
            String id = this.mSelectedItem.getId();
            if (!TextUtils.isEmpty(this.mSelectedItem.getRemark())) {
                id = this.mSelectedItem.getRemark();
            } else if (!TextUtils.isEmpty(this.mSelectedItem.getNickName())) {
                id = this.mSelectedItem.getNickName();
            }
            ContactUtils.startChatActivity(this.mSelectedItem.getId(), 1, id, "");
            finish();
            return;
        }
        ToastUtil.toastLongMessage(getString(R.string.select_chat));
    }
}
