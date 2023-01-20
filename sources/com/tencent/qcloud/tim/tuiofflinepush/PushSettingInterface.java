package com.tencent.qcloud.tim.tuiofflinepush;

import android.content.Context;

/* loaded from: classes3.dex */
public interface PushSettingInterface {
    void bindUserID(String str);

    void init(Context context);

    void unBindUserID(Context context, String str);

    void unInit(Context context);
}
