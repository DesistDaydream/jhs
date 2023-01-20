package com.tencent.qcloud.tuikit.tuicontact.ui.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.LineControllerView;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.component.popupcard.PopupInputCard;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactGroupApplyInfo;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.FriendApplicationBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IFriendProfileLayout;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class FriendProfileLayout extends LinearLayout implements View.OnClickListener, IFriendProfileLayout {
    private static final String TAG = FriendProfileLayout.class.getSimpleName();
    private final int CHANGE_REMARK_CODE;
    private Button acceptFriendBtn;
    private View addFriendArea;
    private LineControllerView addFriendGroupLv;
    private LineControllerView addFriendRemarkLv;
    private Button addFriendSendBtn;
    private EditText addWordingEditText;
    private Button audioCallBtn;
    private Button chatBtn;
    private Button deleteFriendBtn;
    private TextView friendApplicationAddWording;
    private FriendApplicationBean friendApplicationBean;
    private View friendApplicationVerifyArea;
    private boolean isFriend;
    private boolean isGroup;
    private LineControllerView mAddBlackView;
    private String mAddWords;
    private LineControllerView mChatTopView;
    private ContactItemBean mContactInfo;
    private ImageView mHeadImageView;
    private TextView mIDView;
    private String mId;
    private OnButtonClickListener mListener;
    private LineControllerView mMessageOptionView;
    private TextView mNickNameView;
    private String mNickname;
    private String mRemark;
    private LineControllerView mRemarkView;
    private TextView mSignatureTagView;
    private TextView mSignatureView;
    private TitleBarLayout mTitleBar;
    private FriendProfilePresenter presenter;
    private Button refuseFriendBtn;
    private TextView remarkAndGroupTip;
    private Button videoCallBtn;

    /* loaded from: classes3.dex */
    public interface OnButtonClickListener {
        void onDeleteFriendClick(String str);

        void onStartConversationClick(ContactItemBean contactItemBean);
    }

    public FriendProfileLayout(Context context) {
        super(context);
        this.CHANGE_REMARK_CODE = 200;
        this.isGroup = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(String str) {
        this.mRemarkView.setContent(str);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        modifyRemark(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void accept() {
        this.presenter.acceptFriendApplication(this.friendApplicationBean, 1, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.10
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ToastUtil.toastShortMessage("accept Error code = " + i2 + ", desc = " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                FriendProfileLayout.this.chatBtn.setText(R.string.accepted);
                ((Activity) FriendProfileLayout.this.getContext()).finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBlack() {
        this.presenter.addToBlackList(new ArrayList(Arrays.asList(this.mId.split(Constants.ACCEPT_TIME_SEPARATOR_SP))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(String str) {
        this.addFriendRemarkLv.setContent(str);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        modifyRemark(str);
    }

    private void chat() {
        OnButtonClickListener onButtonClickListener = this.mListener;
        if (onButtonClickListener != null || this.mContactInfo != null) {
            onButtonClickListener.onStartConversationClick(this.mContactInfo);
        }
        ((Activity) getContext()).finish();
    }

    private void delete() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mId);
        this.presenter.deleteFriend(arrayList, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.14
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ToastUtil.toastShortMessage("deleteFriend Error code = " + i2 + ", desc = " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                if (FriendProfileLayout.this.mListener != null) {
                    FriendProfileLayout.this.mListener.onDeleteFriendClick(FriendProfileLayout.this.mId);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteBlack() {
        this.presenter.deleteFromBlackList(new ArrayList(Arrays.asList(this.mId.split(Constants.ACCEPT_TIME_SEPARATOR_SP))));
    }

    private void init() {
        LinearLayout.inflate(getContext(), R.layout.contact_friend_profile_layout, this);
        this.mHeadImageView = (ImageView) findViewById(R.id.friend_icon);
        this.mNickNameView = (TextView) findViewById(R.id.friend_nick_name);
        this.mIDView = (TextView) findViewById(R.id.friend_account);
        LineControllerView lineControllerView = (LineControllerView) findViewById(R.id.remark);
        this.mRemarkView = lineControllerView;
        lineControllerView.setOnClickListener(this);
        this.mSignatureTagView = (TextView) findViewById(R.id.friend_signature_tag);
        this.mSignatureView = (TextView) findViewById(R.id.friend_signature);
        LineControllerView lineControllerView2 = (LineControllerView) findViewById(R.id.msg_rev_opt);
        this.mMessageOptionView = lineControllerView2;
        lineControllerView2.setOnClickListener(this);
        this.mChatTopView = (LineControllerView) findViewById(R.id.chat_to_top);
        this.mAddBlackView = (LineControllerView) findViewById(R.id.blackList);
        Button button = (Button) findViewById(R.id.btn_delete);
        this.deleteFriendBtn = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.btn_chat);
        this.chatBtn = button2;
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.btn_voice);
        this.audioCallBtn = button3;
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.btn_video);
        this.videoCallBtn = button4;
        button4.setOnClickListener(this);
        Button button5 = (Button) findViewById(R.id.add_friend_send_btn);
        this.addFriendSendBtn = button5;
        button5.setOnClickListener(this);
        this.acceptFriendBtn = (Button) findViewById(R.id.accept_friend_send_btn);
        this.refuseFriendBtn = (Button) findViewById(R.id.refuse_friend_send_btn);
        this.addFriendArea = findViewById(R.id.add_friend_verify_area);
        this.addWordingEditText = (EditText) findViewById(R.id.add_wording_edit);
        this.friendApplicationVerifyArea = findViewById(R.id.friend_application_verify_area);
        this.friendApplicationAddWording = (TextView) findViewById(R.id.friend_application_add_wording);
        LineControllerView lineControllerView3 = (LineControllerView) findViewById(R.id.friend_remark_lv);
        this.addFriendRemarkLv = lineControllerView3;
        lineControllerView3.setOnClickListener(this);
        LineControllerView lineControllerView4 = (LineControllerView) findViewById(R.id.friend_group_lv);
        this.addFriendGroupLv = lineControllerView4;
        lineControllerView4.setContent(getContext().getString(R.string.contact_my_friend));
        this.remarkAndGroupTip = (TextView) findViewById(R.id.remark_and_group_tip);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.friend_titlebar);
        this.mTitleBar = titleBarLayout;
        titleBarLayout.setTitle(getResources().getString(R.string.profile_detail), ITitleBarLayout.Position.MIDDLE);
        this.mTitleBar.getRightGroup().setVisibility(8);
        this.mTitleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((Activity) FriendProfileLayout.this.getContext()).finish();
            }
        });
    }

    private void initEvent() {
        this.mChatTopView.setCheckListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (FriendProfileLayout.this.presenter != null) {
                    FriendProfileLayout.this.presenter.setConversationTop(FriendProfileLayout.this.mId, z);
                }
            }
        });
        this.mAddBlackView.setCheckListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    FriendProfileLayout.this.addBlack();
                } else {
                    FriendProfileLayout.this.deleteBlack();
                }
            }
        });
        this.refuseFriendBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FriendProfileLayout.this.refuse();
            }
        });
        this.acceptFriendBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FriendProfileLayout.this.accept();
            }
        });
    }

    private void loadUserProfile(String str) {
        this.presenter.getUsersInfo(str, new ContactItemBean());
    }

    private void modifyRemark(final String str) {
        this.presenter.modifyRemark(this.mId, str, new IUIKitCallback<String>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.17
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(String str2) {
                FriendProfileLayout.this.mContactInfo.setRemark(str);
                HashMap hashMap = new HashMap();
                hashMap.put(TUIConstants.TUIContact.FRIEND_ID, FriendProfileLayout.this.mId);
                hashMap.put(TUIConstants.TUIContact.FRIEND_REMARK, str);
                TUICore.notifyEvent(TUIConstants.TUIContact.EVENT_FRIEND_INFO_CHANGED, TUIConstants.TUIContact.EVENT_SUB_KEY_FRIEND_REMARK_CHANGED, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refuse() {
        this.presenter.refuseFriendApplication(this.friendApplicationBean, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.11
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ToastUtil.toastShortMessage("refuse Error code = " + i2 + ", desc = " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                FriendProfileLayout.this.deleteFriendBtn.setText(R.string.refused);
                ((Activity) FriendProfileLayout.this.getContext()).finish();
            }
        });
    }

    private void setViewContentFromContactGroupApplyInfo(final ContactGroupApplyInfo contactGroupApplyInfo) {
        this.mId = contactGroupApplyInfo.getFromUser();
        this.mNickname = contactGroupApplyInfo.getFromUserNickName();
        this.mRemarkView.setVisibility(8);
        this.mAddBlackView.setVisibility(8);
        this.mMessageOptionView.setVisibility(8);
        this.deleteFriendBtn.setText(R.string.refuse);
        this.deleteFriendBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FriendProfileLayout.this.refuseJoinGroupApply(contactGroupApplyInfo);
            }
        });
        this.chatBtn.setText(R.string.accept);
        this.chatBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FriendProfileLayout.this.acceptJoinGroupApply(contactGroupApplyInfo);
            }
        });
    }

    private void setViewContentFromFriendApplicationBean(FriendApplicationBean friendApplicationBean) {
        this.friendApplicationBean = friendApplicationBean;
        this.mId = friendApplicationBean.getUserId();
        this.mNickname = this.friendApplicationBean.getNickName();
        this.mSignatureTagView.setVisibility(8);
        this.mSignatureView.setVisibility(8);
        this.mRemarkView.setVisibility(8);
        this.mAddBlackView.setVisibility(8);
        this.mMessageOptionView.setVisibility(8);
        this.friendApplicationVerifyArea.setVisibility(0);
        this.friendApplicationAddWording.setText(this.friendApplicationBean.getAddWording());
        this.refuseFriendBtn.setVisibility(0);
        this.acceptFriendBtn.setVisibility(0);
        GlideEngine.loadUserIcon(this.mHeadImageView, this.friendApplicationBean.getFaceUrl(), getResources().getDimensionPixelSize(R.dimen.contact_profile_face_radius));
    }

    private void setViewContentFromGroupInfo(GroupInfo groupInfo) {
        this.mTitleBar.setTitle(getResources().getString(R.string.add_group), ITitleBarLayout.Position.MIDDLE);
        this.isGroup = true;
        this.mId = groupInfo.getId();
        this.mNickname = groupInfo.getGroupName();
        this.mSignatureTagView.setText(getResources().getString(R.string.contact_group_type_tag));
        this.mSignatureView.setText(groupInfo.getGroupType());
        GlideEngine.loadUserIcon(this.mHeadImageView, groupInfo.getFaceUrl(), R.drawable.core_default_group_icon_serious, getResources().getDimensionPixelSize(R.dimen.contact_profile_face_radius));
        this.addFriendSendBtn.setVisibility(0);
        this.addFriendArea.setVisibility(0);
        this.remarkAndGroupTip.setVisibility(8);
        this.addFriendRemarkLv.setVisibility(8);
        this.addFriendGroupLv.setVisibility(8);
    }

    private void setViewContentFromItemBean(ContactItemBean contactItemBean) {
        this.mContactInfo = contactItemBean;
        this.isFriend = contactItemBean.isFriend();
        this.mId = this.mContactInfo.getId();
        this.mNickname = this.mContactInfo.getNickName();
        this.mSignatureView.setText(this.mContactInfo.getSignature());
        if (TextUtils.isEmpty(this.mContactInfo.getSignature())) {
            this.mSignatureTagView.setText(getResources().getString(R.string.contact_no_status));
        } else {
            this.mSignatureTagView.setText(getResources().getString(R.string.contact_signature_tag));
        }
        GlideEngine.loadUserIcon(this.mHeadImageView, this.mContactInfo.getAvatarUrl(), getResources().getDimensionPixelSize(R.dimen.contact_profile_face_radius));
        this.mChatTopView.setChecked(this.presenter.isTopConversation(this.mId));
        this.mAddBlackView.setChecked(this.mContactInfo.isBlackList());
        this.mRemarkView.setContent(this.mContactInfo.getRemark());
        if (TextUtils.equals(this.mContactInfo.getId(), TUILogin.getLoginUser())) {
            if (this.isFriend) {
                this.mRemarkView.setVisibility(0);
                this.chatBtn.setVisibility(0);
                this.audioCallBtn.setVisibility(0);
                this.videoCallBtn.setVisibility(0);
                this.deleteFriendBtn.setVisibility(0);
                this.mAddBlackView.setVisibility(0);
                this.mChatTopView.setVisibility(0);
                updateMessageOptionView();
            }
        } else if (this.mContactInfo.isBlackList()) {
            this.deleteFriendBtn.setVisibility(0);
            this.chatBtn.setVisibility(0);
            this.audioCallBtn.setVisibility(0);
            this.videoCallBtn.setVisibility(0);
            this.mRemarkView.setVisibility(0);
            this.mAddBlackView.setVisibility(0);
            this.mMessageOptionView.setVisibility(0);
            this.mChatTopView.setVisibility(0);
        } else if (!this.isFriend) {
            if (this.isGroup) {
                this.addFriendRemarkLv.setVisibility(8);
                this.addFriendGroupLv.setVisibility(8);
            }
            this.mTitleBar.setTitle(getResources().getString(R.string.add_friend), ITitleBarLayout.Position.MIDDLE);
            this.addFriendSendBtn.setVisibility(0);
            this.addFriendArea.setVisibility(0);
        } else {
            this.mRemarkView.setVisibility(0);
            this.chatBtn.setVisibility(0);
            this.audioCallBtn.setVisibility(0);
            this.videoCallBtn.setVisibility(0);
            this.deleteFriendBtn.setVisibility(0);
            this.mAddBlackView.setVisibility(0);
            this.mChatTopView.setVisibility(0);
            updateMessageOptionView();
        }
    }

    private void setupCall() {
        HashMap hashMap = new HashMap();
        hashMap.put("chatId", this.mId);
        hashMap.put(TUIConstants.TUIChat.CHAT_NAME, this.mNickname);
        hashMap.put(TUIConstants.TUIChat.CHAT_TYPE, 1);
        hashMap.put("context", getContext());
        if (TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_VIDEO_CALL, hashMap) == null) {
            this.videoCallBtn.setVisibility(8);
        }
        if (TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_AUDIO_CALL, hashMap) == null) {
            this.audioCallBtn.setVisibility(8);
        }
    }

    private void updateMessageOptionView() {
        this.mMessageOptionView.setVisibility(0);
        final ArrayList arrayList = new ArrayList();
        arrayList.add(this.mId);
        this.presenter.getC2CReceiveMessageOpt(arrayList, new IUIKitCallback<Boolean>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.8
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                FriendProfileLayout.this.mMessageOptionView.setChecked(false);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Boolean bool) {
                FriendProfileLayout.this.mMessageOptionView.setChecked(bool.booleanValue());
            }
        });
        this.mMessageOptionView.setCheckListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.9
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FriendProfileLayout.this.presenter.setC2CReceiveMessageOpt(arrayList, z);
            }
        });
    }

    public void acceptJoinGroupApply(ContactGroupApplyInfo contactGroupApplyInfo) {
        this.presenter.acceptJoinGroupApply(contactGroupApplyInfo, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.12
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ToastUtil.toastLongMessage(str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
                ((Activity) FriendProfileLayout.this.getContext()).finish();
            }
        });
    }

    public void initData(Object obj) {
        initEvent();
        if (obj instanceof String) {
            String str = (String) obj;
            this.mId = str;
            loadUserProfile(str);
        } else if (obj instanceof ContactItemBean) {
            setViewContentFromItemBean((ContactItemBean) obj);
        } else if (obj instanceof FriendApplicationBean) {
            setViewContentFromFriendApplicationBean((FriendApplicationBean) obj);
        } else if (obj instanceof ContactGroupApplyInfo) {
            setViewContentFromContactGroupApplyInfo((ContactGroupApplyInfo) obj);
        } else if (obj instanceof GroupInfo) {
            setViewContentFromGroupInfo((GroupInfo) obj);
        }
        if (!TextUtils.isEmpty(this.mNickname)) {
            this.mNickNameView.setText(this.mNickname);
        } else {
            this.mNickNameView.setText(this.mId);
        }
        this.mIDView.setText(this.mId);
        setupCall();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.chatBtn) {
            chat();
        } else if (view == this.deleteFriendBtn) {
            delete();
        } else if (view == this.videoCallBtn) {
            HashMap hashMap = new HashMap();
            hashMap.put(TUIConstants.TUICalling.PARAM_NAME_USERIDS, new String[]{this.mId});
            hashMap.put("type", "video");
            TUICore.callService("TUICallingService", "call", hashMap);
        } else if (view == this.audioCallBtn) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(TUIConstants.TUICalling.PARAM_NAME_USERIDS, new String[]{this.mId});
            hashMap2.put("type", TUIConstants.TUICalling.TYPE_AUDIO);
            TUICore.callService("TUICallingService", "call", hashMap2);
        } else if (view == this.addFriendSendBtn) {
            String obj = this.addWordingEditText.getText().toString();
            String content = this.addFriendRemarkLv.getContent();
            if (this.isGroup) {
                this.presenter.joinGroup(this.mId, obj, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.15
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                        ToastUtil.toastShortMessage(FriendProfileLayout.this.getContext().getString(R.string.contact_add_failed) + ExpandableTextView.N + str2);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Void r2) {
                        ToastUtil.toastShortMessage(FriendProfileLayout.this.getContext().getString(R.string.success));
                    }
                });
            } else {
                this.presenter.addFriend(this.mId, obj, "", content, new IUIKitCallback<Pair<Integer, String>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.16
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                        ToastUtil.toastShortMessage(FriendProfileLayout.this.getContext().getString(R.string.contact_add_failed));
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Pair<Integer, String> pair) {
                        ToastUtil.toastShortMessage((String) pair.second);
                    }
                });
            }
        } else if (view == this.mRemarkView) {
            PopupInputCard popupInputCard = new PopupInputCard((Activity) getContext());
            popupInputCard.setContent(this.mRemarkView.getContent());
            popupInputCard.setTitle(getResources().getString(R.string.profile_remark_edit));
            popupInputCard.setOnPositive(new PopupInputCard.OnClickListener() { // from class: e.s.a.b.b.a.a.b
                {
                    FriendProfileLayout.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.popupcard.PopupInputCard.OnClickListener
                public final void onClick(String str) {
                    FriendProfileLayout.this.b(str);
                }
            });
            popupInputCard.show(this.mRemarkView, 80);
        } else if (view == this.addFriendRemarkLv) {
            PopupInputCard popupInputCard2 = new PopupInputCard((Activity) getContext());
            popupInputCard2.setContent(this.addFriendRemarkLv.getContent());
            popupInputCard2.setTitle(getResources().getString(R.string.contact_friend_remark));
            popupInputCard2.setOnPositive(new PopupInputCard.OnClickListener() { // from class: e.s.a.b.b.a.a.a
                {
                    FriendProfileLayout.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.popupcard.PopupInputCard.OnClickListener
                public final void onClick(String str) {
                    FriendProfileLayout.this.d(str);
                }
            });
            popupInputCard2.show(this.addFriendRemarkLv, 80);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IFriendProfileLayout
    public void onDataSourceChanged(ContactItemBean contactItemBean) {
        setViewContentFromItemBean(contactItemBean);
        setupCall();
        if (contactItemBean.isFriend()) {
            updateMessageOptionView();
        }
        if (!TextUtils.isEmpty(this.mNickname)) {
            this.mNickNameView.setText(this.mNickname);
        } else {
            this.mNickNameView.setText(this.mId);
        }
        if (!TextUtils.isEmpty(contactItemBean.getAvatarUrl())) {
            GlideEngine.loadUserIcon(this.mHeadImageView, contactItemBean.getAvatarUrl(), getResources().getDimensionPixelSize(R.dimen.contact_profile_face_radius));
        }
        this.mIDView.setText(this.mId);
    }

    public void refuseJoinGroupApply(ContactGroupApplyInfo contactGroupApplyInfo) {
        this.presenter.refuseJoinGroupApply(contactGroupApplyInfo, "", new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.FriendProfileLayout.13
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ToastUtil.toastLongMessage(str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
                ((Activity) FriendProfileLayout.this.getContext()).finish();
            }
        });
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.mListener = onButtonClickListener;
    }

    public void setPresenter(FriendProfilePresenter friendProfilePresenter) {
        this.presenter = friendProfilePresenter;
    }

    public FriendProfileLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CHANGE_REMARK_CODE = 200;
        this.isGroup = false;
        init();
    }

    public FriendProfileLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.CHANGE_REMARK_CODE = 200;
        this.isGroup = false;
        init();
    }
}
