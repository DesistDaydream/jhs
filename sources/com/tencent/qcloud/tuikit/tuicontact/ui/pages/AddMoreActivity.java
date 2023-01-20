package com.tencent.qcloud.tuikit.tuicontact.ui.pages;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.TUIContactService;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuicontact.presenter.AddMorePresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IAddMoreActivity;

/* loaded from: classes3.dex */
public class AddMoreActivity extends BaseLightActivity implements IAddMoreActivity {
    private static final String TAG = AddMoreActivity.class.getSimpleName();
    private View detailArea;
    private ImageView faceImgView;
    private TextView groupTypeTagView;
    private TextView groupTypeView;
    private TextView idLabel;
    private TextView idTextView;
    private boolean mIsGroup;
    private TitleBarLayout mTitleBar;
    private TextView nickNameView;
    private TextView notFoundTip;
    private AddMorePresenter presenter;
    private TextView searchBtn;
    private EditText searchEdit;

    /* JADX INFO: Access modifiers changed from: private */
    public void setFriendDetail(String str, String str2, String str3) {
        GlideEngine.loadUserIcon(this.faceImgView, str, getResources().getDimensionPixelSize(R.dimen.contact_profile_face_radius));
        this.idTextView.setText(str2);
        if (TextUtils.isEmpty(str3)) {
            this.nickNameView.setText(str2);
        } else {
            this.nickNameView.setText(str3);
        }
        this.groupTypeTagView.setVisibility(8);
        this.groupTypeView.setVisibility(8);
        this.detailArea.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupDetail(GroupInfo groupInfo) {
        GlideEngine.loadUserIcon(this.faceImgView, groupInfo.getFaceUrl(), R.drawable.core_default_group_icon_serious, getResources().getDimensionPixelSize(R.dimen.contact_profile_face_radius));
        this.idTextView.setText(groupInfo.getId());
        this.nickNameView.setText(groupInfo.getGroupName());
        this.groupTypeTagView.setVisibility(0);
        this.groupTypeView.setVisibility(0);
        this.groupTypeView.setText(groupInfo.getGroupType());
        this.detailArea.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNotFound(boolean z) {
        this.detailArea.setVisibility(8);
        if (z) {
            this.notFoundTip.setText(getString(R.string.contact_no_such_group));
        } else {
            this.notFoundTip.setText(getString(R.string.contact_no_such_user));
        }
        this.notFoundTip.setVisibility(0);
    }

    @Override // android.app.Activity, com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IAddMoreActivity
    public void finish() {
        super.finish();
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Resources resources;
        int i2;
        super.onCreate(bundle);
        setContentView(R.layout.contact_add_activity);
        if (getIntent() != null) {
            this.mIsGroup = getIntent().getExtras().getBoolean("isGroup");
        }
        AddMorePresenter addMorePresenter = new AddMorePresenter();
        this.presenter = addMorePresenter;
        addMorePresenter.setAddMoreActivity(this);
        this.faceImgView = (ImageView) findViewById(R.id.friend_icon);
        this.idTextView = (TextView) findViewById(R.id.friend_account);
        this.groupTypeView = (TextView) findViewById(R.id.group_type);
        this.nickNameView = (TextView) findViewById(R.id.friend_nick_name);
        this.groupTypeTagView = (TextView) findViewById(R.id.group_type_tag);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.add_friend_titlebar);
        this.mTitleBar = titleBarLayout;
        if (this.mIsGroup) {
            resources = getResources();
            i2 = R.string.add_group;
        } else {
            resources = getResources();
            i2 = R.string.add_friend;
        }
        titleBarLayout.setTitle(resources.getString(i2), ITitleBarLayout.Position.MIDDLE);
        this.mTitleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.AddMoreActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddMoreActivity.this.finish();
            }
        });
        this.mTitleBar.getRightGroup().setVisibility(8);
        EditText editText = (EditText) findViewById(R.id.search_edit);
        this.searchEdit = editText;
        if (this.mIsGroup) {
            editText.setHint(R.string.hint_search_group_id);
        }
        this.idLabel = (TextView) findViewById(R.id.id_label);
        this.notFoundTip = (TextView) findViewById(R.id.not_found_tip);
        this.searchBtn = (TextView) findViewById(R.id.search_button);
        this.detailArea = findViewById(R.id.friend_detail_area);
        this.searchBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.AddMoreActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddMoreActivity.this.notFoundTip.setVisibility(8);
                String obj = AddMoreActivity.this.searchEdit.getText().toString();
                if (AddMoreActivity.this.mIsGroup) {
                    AddMoreActivity.this.presenter.getGroupInfo(obj, new IUIKitCallback<GroupInfo>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.AddMoreActivity.2.1
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str, int i3, String str2) {
                            AddMoreActivity.this.setNotFound(true);
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(final GroupInfo groupInfo) {
                            AddMoreActivity.this.setGroupDetail(groupInfo);
                            AddMoreActivity.this.detailArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.AddMoreActivity.2.1.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    Intent intent = new Intent(TUIContactService.getAppContext(), FriendProfileActivity.class);
                                    intent.addFlags(268435456);
                                    intent.putExtra("content", groupInfo);
                                    TUIContactService.getAppContext().startActivity(intent);
                                }
                            });
                        }
                    });
                } else {
                    AddMoreActivity.this.presenter.getUserInfo(obj, new IUIKitCallback<ContactItemBean>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.AddMoreActivity.2.2
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str, int i3, String str2) {
                            AddMoreActivity.this.setNotFound(false);
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(final ContactItemBean contactItemBean) {
                            AddMoreActivity.this.setFriendDetail(contactItemBean.getAvatarUrl(), contactItemBean.getId(), contactItemBean.getNickName());
                            AddMoreActivity.this.detailArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.AddMoreActivity.2.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    Intent intent = new Intent(TUIContactService.getAppContext(), FriendProfileActivity.class);
                                    intent.addFlags(268435456);
                                    intent.putExtra("content", contactItemBean);
                                    TUIContactService.getAppContext().startActivity(intent);
                                }
                            });
                        }
                    });
                }
            }
        });
        if (!this.mIsGroup) {
            this.idLabel.setText(getString(R.string.contact_my_user_id, new Object[]{TUILogin.getLoginUser()}));
        }
        this.searchEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.AddMoreActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    AddMoreActivity.this.idLabel.setVisibility(8);
                }
            }
        });
        this.searchEdit.addTextChangedListener(new TextWatcher() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.AddMoreActivity.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(AddMoreActivity.this.searchEdit.getText())) {
                    AddMoreActivity.this.detailArea.setVisibility(8);
                    AddMoreActivity.this.notFoundTip.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }
        });
    }
}
