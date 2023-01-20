package com.tencent.qcloud.tuikit.tuichat.ui.interfaces;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import java.util.List;

/* loaded from: classes3.dex */
public interface IMessageAdapter {
    void onDataSourceChanged(List<TUIMessageBean> list);

    void onScrollToEnd();

    void onViewNeedRefresh(int i2, int i3);

    void onViewNeedRefresh(int i2, TUIMessageBean tUIMessageBean);
}
