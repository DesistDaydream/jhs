package com.tencent.qcloud.tuicore.component.interfaces;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public interface ITitleBarLayout {

    /* loaded from: classes3.dex */
    public enum Position {
        LEFT,
        MIDDLE,
        RIGHT
    }

    LinearLayout getLeftGroup();

    ImageView getLeftIcon();

    TextView getLeftTitle();

    TextView getMiddleTitle();

    LinearLayout getRightGroup();

    ImageView getRightIcon();

    TextView getRightTitle();

    void setLeftIcon(int i2);

    void setOnLeftClickListener(View.OnClickListener onClickListener);

    void setOnRightClickListener(View.OnClickListener onClickListener);

    void setRightIcon(int i2);

    void setTitle(String str, Position position);
}
