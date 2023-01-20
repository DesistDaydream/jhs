package com.tencent.qcloud.tuikit.tuicontact.ui.interfaces;

import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import java.util.List;

/* loaded from: classes3.dex */
public interface IContactListView {
    void onDataSourceChanged(List<ContactItemBean> list);

    void onFriendApplicationChanged();
}
