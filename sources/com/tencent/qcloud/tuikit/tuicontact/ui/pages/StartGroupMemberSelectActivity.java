package com.tencent.qcloud.tuikit.tuicontact.ui.pages;

import android.content.Intent;
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
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class StartGroupMemberSelectActivity extends BaseLightActivity {
    private static final String TAG = StartGroupMemberSelectActivity.class.getSimpleName();
    private ContactListView mContactListView;
    private ArrayList<GroupMemberInfo> mMembers = new ArrayList<>();
    private TitleBarLayout mTitleBar;
    private ContactPresenter presenter;

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> getMembersNameCard() {
        if (this.mMembers.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.mMembers.size(); i2++) {
            arrayList.add(this.mMembers.get(i2).getNameCard());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> getMembersUserId() {
        if (this.mMembers.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.mMembers.size(); i2++) {
            arrayList.add(this.mMembers.get(i2).getAccount());
        }
        return arrayList;
    }

    private void init() {
        this.mMembers.clear();
        String stringExtra = getIntent().getStringExtra("group_id");
        boolean booleanExtra = getIntent().getBooleanExtra("select_friends", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("isSelectForCall", false);
        final int intExtra = getIntent().getIntExtra("limit", Integer.MAX_VALUE);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.group_create_title_bar);
        this.mTitleBar = titleBarLayout;
        titleBarLayout.setTitle(getResources().getString(R.string.sure), ITitleBarLayout.Position.RIGHT);
        this.mTitleBar.getRightIcon().setVisibility(8);
        this.mTitleBar.setOnRightClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupMemberSelectActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int size = StartGroupMemberSelectActivity.this.mMembers.size();
                int i2 = intExtra;
                if (size > i2) {
                    ToastUtil.toastShortMessage(StartGroupMemberSelectActivity.this.getString(R.string.contact_over_limit_tip, new Object[]{Integer.valueOf(i2)}));
                    return;
                }
                Intent intent = new Intent();
                ArrayList arrayList = new ArrayList();
                Iterator it = StartGroupMemberSelectActivity.this.mMembers.iterator();
                while (it.hasNext()) {
                    arrayList.add(((GroupMemberInfo) it.next()).getAccount());
                }
                intent.putExtra("list", arrayList);
                intent.putStringArrayListExtra("user_namecard_select", StartGroupMemberSelectActivity.this.getMembersNameCard());
                intent.putStringArrayListExtra("user_id_select", StartGroupMemberSelectActivity.this.getMembersUserId());
                intent.putExtras(StartGroupMemberSelectActivity.this.getIntent());
                StartGroupMemberSelectActivity.this.setResult(3, intent);
                StartGroupMemberSelectActivity.this.finish();
            }
        });
        this.mTitleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupMemberSelectActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StartGroupMemberSelectActivity.this.finish();
            }
        });
        this.mContactListView = (ContactListView) findViewById(R.id.group_create_member_list);
        ContactPresenter contactPresenter = new ContactPresenter();
        this.presenter = contactPresenter;
        contactPresenter.setFriendListListener();
        this.presenter.setIsForCall(booleanExtra2);
        this.mContactListView.setPresenter(this.presenter);
        this.presenter.setContactListView(this.mContactListView);
        this.mContactListView.setGroupId(stringExtra);
        if (booleanExtra) {
            this.mTitleBar.setTitle(getString(R.string.add_group_member), ITitleBarLayout.Position.MIDDLE);
            this.mContactListView.loadDataSource(1);
        } else {
            this.mContactListView.loadDataSource(5);
        }
        if (!booleanExtra2 && !booleanExtra) {
            this.mContactListView.setOnItemClickListener(new ContactListView.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupMemberSelectActivity.3
                @Override // com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView.OnItemClickListener
                public void onItemClick(int i2, ContactItemBean contactItemBean) {
                    if (i2 == 0) {
                        StartGroupMemberSelectActivity.this.mMembers.clear();
                        Intent intent = new Intent();
                        intent.putStringArrayListExtra("user_namecard_select", new ArrayList<>(Arrays.asList(StartGroupMemberSelectActivity.this.getString(R.string.at_all))));
                        intent.putStringArrayListExtra("user_id_select", new ArrayList<>(Arrays.asList("__kImSDK_MesssageAtALL__")));
                        StartGroupMemberSelectActivity.this.setResult(3, intent);
                        StartGroupMemberSelectActivity.this.finish();
                    }
                }
            });
        }
        this.mContactListView.setOnSelectChangeListener(new ContactListView.OnSelectChangedListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupMemberSelectActivity.4
            @Override // com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView.OnSelectChangedListener
            public void onSelectChanged(ContactItemBean contactItemBean, boolean z) {
                if (z) {
                    GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                    groupMemberInfo.setAccount(contactItemBean.getId());
                    groupMemberInfo.setNameCard(TextUtils.isEmpty(contactItemBean.getNickName()) ? contactItemBean.getId() : contactItemBean.getNickName());
                    StartGroupMemberSelectActivity.this.mMembers.add(groupMemberInfo);
                    return;
                }
                for (int size = StartGroupMemberSelectActivity.this.mMembers.size() - 1; size >= 0; size--) {
                    if (((GroupMemberInfo) StartGroupMemberSelectActivity.this.mMembers.get(size)).getAccount().equals(contactItemBean.getId())) {
                        StartGroupMemberSelectActivity.this.mMembers.remove(size);
                    }
                }
            }
        });
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.popup_start_group_select_activity);
        init();
    }
}
