package com.tencent.imsdk.relationship;

import java.util.List;

/* loaded from: classes3.dex */
public abstract class FriendshipListener {
    public void OnBlackListAdded(List<FriendInfo> list) {
    }

    public void OnBlackListDeleted(List<String> list) {
    }

    public void OnFriendApplicationListAdded(List<FriendApplication> list) {
    }

    public void OnFriendApplicationListDelete(List<String> list) {
    }

    public void OnFriendApplicationListRead() {
    }

    public void OnFriendInfoChanged(List<FriendInfo> list) {
    }

    public void OnFriendListAdded(List<FriendInfo> list) {
    }

    public void OnFriendListDeleted(List<String> list) {
    }

    public void OnSelfInfoUpdated(UserInfo userInfo) {
    }
}
