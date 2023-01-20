package com.tencent.qcloud.tuicore.component.interfaces;

import android.view.View;
import android.widget.TextView;

/* loaded from: classes3.dex */
public interface INoticeLayout {
    void alwaysShow(boolean z);

    TextView getContent();

    TextView getContentExtra();

    void setOnNoticeClickListener(View.OnClickListener onClickListener);
}
