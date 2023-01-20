package com.tencent.qcloud.tuikit.tuicontact.presenter;

import android.text.TextUtils;
import android.util.Pair;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider;
import com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IAddMoreActivity;
import com.tencent.qcloud.tuikit.tuicontact.util.ContactUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AddMorePresenter {
    private static final String TAG = "AddMorePresenter";
    private IAddMoreActivity addMoreActivity;
    private ContactProvider provider = new ContactProvider();

    public void addFriend(String str, String str2) {
        this.provider.addFriend(str, str2, new IUIKitCallback<Pair<Integer, String>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.AddMorePresenter.1
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str3, int i2, String str4) {
                ToastUtil.toastShortMessage("Error code = " + i2 + ", desc = " + str4);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Pair<Integer, String> pair) {
                int intValue = ((Integer) pair.first).intValue();
                if (intValue != 0) {
                    if (intValue != 30001) {
                        if (intValue != 30010) {
                            if (intValue == 30014) {
                                ToastUtil.toastShortMessage(AddMorePresenter.this.addMoreActivity.getString(R.string.other_friend_limit));
                                return;
                            } else if (intValue == 30525) {
                                ToastUtil.toastShortMessage(AddMorePresenter.this.addMoreActivity.getString(R.string.set_in_blacklist));
                                return;
                            } else if (intValue == 30539) {
                                ToastUtil.toastShortMessage(AddMorePresenter.this.addMoreActivity.getString(R.string.wait_agree_friend));
                                return;
                            } else if (intValue == 30515) {
                                ToastUtil.toastShortMessage(AddMorePresenter.this.addMoreActivity.getString(R.string.in_blacklist));
                                return;
                            } else if (intValue == 30516) {
                                ToastUtil.toastShortMessage(AddMorePresenter.this.addMoreActivity.getString(R.string.forbid_add_friend));
                                return;
                            } else {
                                ToastUtil.toastLongMessage(pair.first + ExpandableTextView.N + ((String) pair.second));
                                return;
                            }
                        }
                    } else if (TextUtils.equals((CharSequence) pair.second, "Err_SNS_FriendAdd_Friend_Exist")) {
                        ToastUtil.toastShortMessage(AddMorePresenter.this.addMoreActivity.getString(R.string.have_be_friend));
                        return;
                    }
                    ToastUtil.toastShortMessage(AddMorePresenter.this.addMoreActivity.getString(R.string.friend_limit));
                    return;
                }
                ToastUtil.toastShortMessage(AddMorePresenter.this.addMoreActivity.getString(R.string.success));
            }
        });
    }

    public void getGroupInfo(String str, final IUIKitCallback<GroupInfo> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.provider.getGroupInfo(arrayList, new IUIKitCallback<List<GroupInfo>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.AddMorePresenter.4
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                ContactUtils.callbackOnError(iUIKitCallback, i2, str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<GroupInfo> list) {
                ContactUtils.callbackOnSuccess(iUIKitCallback, list.get(0));
            }
        });
    }

    public void getUserInfo(String str, final IUIKitCallback<ContactItemBean> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.provider.getUserInfo(arrayList, new IUIKitCallback<List<ContactItemBean>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.AddMorePresenter.3
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                ContactUtils.callbackOnError(iUIKitCallback, i2, str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<ContactItemBean> list) {
                ContactUtils.callbackOnSuccess(iUIKitCallback, list.get(0));
            }
        });
    }

    public void joinGroup(String str, String str2) {
        this.provider.joinGroup(str, str2, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.AddMorePresenter.2
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str3, int i2, String str4) {
                ToastUtil.toastShortMessage("Error code = " + i2 + ", desc = " + str4);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                ToastUtil.toastShortMessage(AddMorePresenter.this.addMoreActivity.getString(R.string.send_request));
            }
        });
    }

    public void setAddMoreActivity(IAddMoreActivity iAddMoreActivity) {
        this.addMoreActivity = iAddMoreActivity;
    }
}
