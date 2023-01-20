package com.jihuanshe.ui.widget.imagepreview.enitity;

import android.graphics.Rect;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public interface IThumbViewInfo extends Parcelable {
    String getAvatar();

    Rect getBounds();

    String getUrl();

    String getUserId();

    String getUserName();

    @Nullable
    String getVideoUrl();
}
