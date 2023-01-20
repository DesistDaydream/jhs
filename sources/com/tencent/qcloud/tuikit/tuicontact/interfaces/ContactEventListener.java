package com.tencent.qcloud.tuikit.tuicontact.interfaces;

import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.FriendApplicationBean;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class ContactEventListener {
    public void onBlackListAdd(List<ContactItemBean> list) {
    }

    public void onBlackListDeleted(List<String> list) {
    }

    public void onFriendApplicationListAdded(List<FriendApplicationBean> list) {
    }

    public void onFriendApplicationListDeleted(List<String> list) {
    }

    public void onFriendApplicationListRead() {
    }

    public void onFriendInfoChanged(List<ContactItemBean> list) {
    }

    public void onFriendListAdded(List<ContactItemBean> list) {
    }

    public void onFriendListDeleted(List<String> list) {
    }

    public void onFriendRemarkChanged(String str, String str2) {
    }
}
