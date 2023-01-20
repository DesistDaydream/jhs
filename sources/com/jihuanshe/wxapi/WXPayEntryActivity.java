package com.jihuanshe.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import e.l.h.d.f;
import e.l.h.d.i;
import e.l.h.k.b;
import e.l.j.a;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    @Override // android.app.Activity
    public void onCreate(@e Bundle bundle) {
        super.onCreate(bundle);
        IWXAPI c2 = WXTool.a.c();
        if (c2 == null) {
            return;
        }
        c2.handleIntent(getIntent(), this);
    }

    @Override // android.app.Activity
    public void onNewIntent(@e Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        IWXAPI c2 = WXTool.a.c();
        if (c2 == null) {
            return;
        }
        c2.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(@e BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(@e BaseResp baseResp) {
        boolean z = false;
        if (baseResp != null && baseResp.getType() == 5) {
            z = true;
        }
        if (z) {
            b bVar = b.a;
            String str = baseResp.errStr;
            if (str == null) {
                str = "";
            }
            bVar.d("wxpay", str);
            if (baseResp.errCode == 0) {
                i.d(f.b, a.r, null, 2, null);
            }
            finish();
        }
    }
}
