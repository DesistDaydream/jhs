package com.tencent.qcloud.tuikit.tuicontact.ui.pages;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.LineControllerView;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.activities.SelectionActivity;
import com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView;
import com.tencent.qcloud.tuikit.tuicontact.util.ContactUtils;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class StartGroupChatActivity extends BaseLightActivity {
    private static final String TAG = StartGroupChatActivity.class.getSimpleName();
    private ContactListView mContactListView;
    private boolean mCreating;
    private LineControllerView mJoinType;
    private TitleBarLayout mTitleBar;
    private ContactPresenter presenter;
    private ArrayList<GroupMemberInfo> mMembers = new ArrayList<>();
    private int mGroupType = -1;
    private int mJoinTypeIndex = 2;
    private ArrayList<String> mJoinTypes = new ArrayList<>();
    private ArrayList<String> mGroupTypeValue = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void createGroupChat() {
        if (this.mCreating) {
            return;
        }
        if (this.mGroupType < 3 && this.mMembers.size() == 1) {
            ToastUtil.toastLongMessage(getResources().getString(R.string.tips_empty_group_member));
            return;
        }
        int i2 = this.mGroupType;
        if (i2 > 0 && this.mJoinTypeIndex == -1) {
            ToastUtil.toastLongMessage(getResources().getString(R.string.tips_empty_group_type));
            return;
        }
        if (i2 == 0) {
            this.mJoinTypeIndex = -1;
        }
        final GroupInfo groupInfo = new GroupInfo();
        String loginUser = ContactUtils.getLoginUser();
        for (int i3 = 1; i3 < this.mMembers.size(); i3++) {
            loginUser = loginUser + "、" + this.mMembers.get(i3).getAccount();
        }
        if (loginUser.length() > 20) {
            loginUser = loginUser.substring(0, 17) + "...";
        }
        groupInfo.setChatName(loginUser);
        groupInfo.setGroupName(loginUser);
        groupInfo.setMemberDetails(this.mMembers);
        groupInfo.setGroupType(this.mGroupTypeValue.get(this.mGroupType));
        groupInfo.setJoinType(this.mJoinTypeIndex);
        this.mCreating = true;
        this.presenter.createGroupChat(groupInfo, new IUIKitCallback<String>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupChatActivity.6
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i4, String str2) {
                StartGroupChatActivity.this.mCreating = false;
                if (i4 == 7013 || i4 == 11000) {
                    StartGroupChatActivity.this.showNotSupportDialog();
                }
                ToastUtil.toastLongMessage("createGroupChat fail:" + i4 + "=" + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(String str) {
                ContactUtils.startChatActivity(str, 2, groupInfo.getGroupName(), groupInfo.getGroupType());
                StartGroupChatActivity.this.finish();
            }
        });
    }

    private void init() {
        this.mGroupTypeValue.addAll(Arrays.asList(getResources().getStringArray(R.array.group_type)));
        this.mJoinTypes.addAll(Arrays.asList(getResources().getStringArray(R.array.group_join_type)));
        GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
        groupMemberInfo.setAccount(ContactUtils.getLoginUser());
        this.mMembers.add(0, groupMemberInfo);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.group_create_title_bar);
        this.mTitleBar = titleBarLayout;
        titleBarLayout.setTitle(getResources().getString(R.string.sure), ITitleBarLayout.Position.RIGHT);
        this.mTitleBar.getRightIcon().setVisibility(8);
        this.mTitleBar.setOnRightClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupChatActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StartGroupChatActivity.this.createGroupChat();
            }
        });
        this.mTitleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupChatActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StartGroupChatActivity.this.finish();
            }
        });
        LineControllerView lineControllerView = (LineControllerView) findViewById(R.id.group_type_join);
        this.mJoinType = lineControllerView;
        lineControllerView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupChatActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StartGroupChatActivity.this.showJoinTypePickerView();
            }
        });
        this.mJoinType.setCanNav(true);
        this.mJoinType.setContent(this.mJoinTypes.get(2));
        this.mContactListView = (ContactListView) findViewById(R.id.group_create_member_list);
        ContactPresenter contactPresenter = new ContactPresenter();
        this.presenter = contactPresenter;
        contactPresenter.setFriendListListener();
        this.mContactListView.setPresenter(this.presenter);
        this.presenter.setContactListView(this.mContactListView);
        this.mContactListView.loadDataSource(1);
        this.mContactListView.setOnSelectChangeListener(new ContactListView.OnSelectChangedListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupChatActivity.4
            @Override // com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView.OnSelectChangedListener
            public void onSelectChanged(ContactItemBean contactItemBean, boolean z) {
                if (z) {
                    GroupMemberInfo groupMemberInfo2 = new GroupMemberInfo();
                    groupMemberInfo2.setAccount(contactItemBean.getId());
                    StartGroupChatActivity.this.mMembers.add(groupMemberInfo2);
                    return;
                }
                for (int size = StartGroupChatActivity.this.mMembers.size() - 1; size >= 0; size--) {
                    if (((GroupMemberInfo) StartGroupChatActivity.this.mMembers.get(size)).getAccount().equals(contactItemBean.getId())) {
                        StartGroupChatActivity.this.mMembers.remove(size);
                    }
                }
            }
        });
        setGroupType(getIntent().getIntExtra("type", 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWebUrl(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showJoinTypePickerView() {
        Bundle bundle = new Bundle();
        bundle.putString("title", getResources().getString(R.string.group_join_type));
        bundle.putStringArrayList("list", this.mJoinTypes);
        bundle.putInt("default_select_item_index", this.mJoinTypeIndex);
        SelectionActivity.startListSelection(this, bundle, new SelectionActivity.OnResultReturnListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupChatActivity.5
            @Override // com.tencent.qcloud.tuicore.component.activities.SelectionActivity.OnResultReturnListener
            public void onReturn(Object obj) {
                Integer num = (Integer) obj;
                StartGroupChatActivity.this.mJoinType.setContent((String) StartGroupChatActivity.this.mJoinTypes.get(num.intValue()));
                StartGroupChatActivity.this.mJoinTypeIndex = num.intValue();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotSupportDialog() {
        String string = getResources().getString(R.string.contact_im_flagship_edition_update_tip, getString(R.string.contact_community));
        String string2 = getResources().getString(R.string.contact_buying_guidelines);
        int lastIndexOf = string.lastIndexOf(string2);
        int color = getResources().getColor(TUIThemeManager.getAttrResId(this, R.attr.core_primary_color));
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(color), lastIndexOf, string2.length() + lastIndexOf, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupChatActivity.7
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (TextUtils.equals(TUIThemeManager.getInstance().getCurrentLanguage(), "zh")) {
                    StartGroupChatActivity.this.openWebUrl("https://cloud.tencent.com/document/product/269/32458");
                } else {
                    StartGroupChatActivity.this.openWebUrl("https://intl.cloud.tencent.com/document/product/1047/36021?lang=en&pg=#changing-configuration");
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, lastIndexOf, string2.length() + lastIndexOf, 34);
        TUIKitDialog.TUIIMUpdateDialog.getInstance().createDialog(this).setMovementMethod(LinkMovementMethod.getInstance()).setShowOnlyDebug(true).setCancelable(true).setCancelOutside(true).setTitle(spannableString).setDialogWidth(0.75f).setPositiveButton(getString(R.string.contact_no_more_reminders), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupChatActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIKitDialog.TUIIMUpdateDialog.getInstance().dismiss();
                TUIKitDialog.TUIIMUpdateDialog.getInstance().setNeverShow(true);
            }
        }).setNegativeButton(getString(R.string.contact_i_know), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.StartGroupChatActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIKitDialog.TUIIMUpdateDialog.getInstance().dismiss();
            }
        }).show();
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.popup_start_group_chat_activity);
        init();
    }

    public void setGroupType(int i2) {
        this.mGroupType = i2;
        if (i2 == 1) {
            this.mTitleBar.setTitle(getResources().getString(R.string.create_group_chat), ITitleBarLayout.Position.MIDDLE);
            this.mJoinType.setVisibility(0);
        } else if (i2 == 2) {
            this.mTitleBar.setTitle(getResources().getString(R.string.create_chat_room), ITitleBarLayout.Position.MIDDLE);
            this.mJoinType.setVisibility(0);
        } else if (i2 != 3) {
            this.mTitleBar.setTitle(getResources().getString(R.string.create_private_group), ITitleBarLayout.Position.MIDDLE);
            this.mJoinType.setVisibility(8);
        } else {
            this.mTitleBar.setTitle(getResources().getString(R.string.create_community), ITitleBarLayout.Position.MIDDLE);
            this.mJoinType.setVisibility(0);
        }
    }
}
