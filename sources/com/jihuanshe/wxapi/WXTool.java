package com.jihuanshe.wxapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import com.jihuanshe.model.PayParams;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.vector.ext.BitmapKt;
import com.vector.util.IntentAction;
import e.n.f;
import e.t.a;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class WXTool {
    @e

    /* renamed from: c  reason: collision with root package name */
    private static IWXAPI f4595c;
    @d
    public static final WXTool a = new WXTool();
    @d
    private static final f<String> b = new f<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private static String f4596d = "wxe513b81e8994343a";

    private WXTool() {
    }

    private final String a(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : f0.C(str, Long.valueOf(System.currentTimeMillis()));
    }

    @d
    public final String b() {
        return f4596d;
    }

    @e
    public final IWXAPI c() {
        return f4595c;
    }

    @d
    public final f<String> d() {
        return b;
    }

    public final void e() {
        IWXAPI iwxapi = f4595c;
        boolean z = false;
        if (iwxapi != null && iwxapi.isWXAppInstalled()) {
            z = true;
        }
        if (!z) {
            e.l.h.j.b.e.f(this, "您还未安装微信客户端", (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            return;
        }
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "jhs_wx_login";
        IWXAPI iwxapi2 = f4595c;
        if (iwxapi2 == null) {
            return;
        }
        iwxapi2.sendReq(req);
    }

    public final void f(@d PayParams payParams) {
        PayReq payReq = new PayReq();
        payReq.appId = f4596d;
        payReq.nonceStr = payParams.getNonceStr();
        payReq.packageValue = payParams.getPkg();
        payReq.sign = payParams.getSign();
        payReq.timeStamp = payParams.getTimeStamp();
        payReq.partnerId = payParams.getPartnerId();
        payReq.prepayId = payParams.getPrepayId();
        IWXAPI iwxapi = f4595c;
        if (iwxapi == null) {
            return;
        }
        iwxapi.sendReq(payReq);
    }

    public final void g() {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(a.b(), f4596d, false);
        f4595c = createWXAPI;
        createWXAPI.registerApp(f4596d);
        a.b().registerReceiver(new BroadcastReceiver() { // from class: com.jihuanshe.wxapi.WXTool$registerToWX$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@d Context context, @d Intent intent) {
                WXTool wXTool = WXTool.a;
                IWXAPI c2 = wXTool.c();
                if (c2 == null) {
                    return;
                }
                c2.registerApp(wXTool.b());
            }
        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
    }

    public final void h(@d String str) {
        f4596d = str;
    }

    public final void i(@e IWXAPI iwxapi) {
        f4595c = iwxapi;
    }

    public final void j(@d Bitmap bitmap, boolean z) {
        WXImageObject wXImageObject = new WXImageObject(bitmap);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
        bitmap.recycle();
        wXMediaMessage.thumbData = BitmapKt.B(createScaledBitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = a(IntentAction.o.f7891j);
        req.message = wXMediaMessage;
        req.scene = z ? 1 : 0;
        IWXAPI iwxapi = f4595c;
        if (iwxapi == null) {
            return;
        }
        iwxapi.sendReq(req);
    }
}
