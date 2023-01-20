package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;

/* loaded from: classes3.dex */
public class CustomHelloMessage {
    public static final int CUSTOM_HELLO_ACTION_ID = 3;
    public String businessID = TUIChatConstants.BUSINESS_ID_CUSTOM_HELLO;
    public String text = TUIChatService.getAppContext().getString(R.string.welcome_tip);
    public String link = "https://cloud.tencent.com/document/product/269/3794";
    public int version = 0;
}
