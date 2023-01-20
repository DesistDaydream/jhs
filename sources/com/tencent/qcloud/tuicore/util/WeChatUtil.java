package com.tencent.qcloud.tuicore.util;

import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.qcloud.tuicore.TUIConfig;

/* loaded from: classes3.dex */
public class WeChatUtil {
    private static WeChatUtil instance;
    private IWXAPI api = WXAPIFactory.createWXAPI(TUIConfig.appContext, "wxe513b81e8994343a");

    private WeChatUtil() {
    }

    public static WeChatUtil getInstance() {
        if (instance == null) {
            instance = new WeChatUtil();
        }
        return instance;
    }

    public void openMiniProgram(String str) {
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = "gh_eb22bb8a6f27";
        req.path = str;
        req.miniprogramType = 0;
        this.api.sendReq(req);
    }
}
