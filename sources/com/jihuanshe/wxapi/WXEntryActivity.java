package com.jihuanshe.wxapi;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private final int a = 1;
    private final int b = 2;

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    @Override // android.app.Activity
    public void onCreate(@e Bundle bundle) {
        super.onCreate(bundle);
        IWXAPI c2 = WXTool.a.c();
        if (c2 == null) {
            return;
        }
        c2.handleIntent(getIntent(), this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(@e BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(@d BaseResp baseResp) {
        int i2 = baseResp.errCode;
        if (i2 == -4 || i2 == -2) {
            if (this.b == baseResp.getType()) {
                e.l.h.j.b.e.h(this, "分享失败", null, null, null, 0, null, 62, null);
            } else {
                e.l.h.j.b.e.h(this, "登录失败", null, null, null, 0, null, 62, null);
            }
            finish();
        } else if (i2 != 0) {
            int type = baseResp.getType();
            if (type == this.a) {
                e.l.h.j.b.e.h(this, "微信登录失败", null, null, null, 0, null, 62, null);
            } else if (type == this.b) {
                e.l.h.j.b.e.h(this, "微信分享失败", null, null, null, 0, null, 62, null);
            }
            finish();
        } else {
            int type2 = baseResp.getType();
            if (type2 == this.a) {
                WXTool.a.d().r(((SendAuth.Resp) baseResp).code);
            } else if (type2 == this.b) {
                e.l.h.j.b.e.h(this, "微信分享成功", null, null, null, 0, null, 62, null);
            }
            finish();
        }
    }
}
