package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class af implements NativeCPUManager.DataPostBackListener {
    public final /* synthetic */ Object a;
    public final /* synthetic */ ac b;

    public af(ac acVar, Object obj) {
        this.b = acVar;
        this.a = obj;
    }

    @Override // com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener
    public void postback(JSONObject jSONObject) {
        Object obj = this.a;
        if (obj instanceof Activity) {
            View findViewById = ((Activity) obj).findViewById(17);
            if (findViewById instanceof WebView) {
                this.b.a((WebView) findViewById, jSONObject);
            }
        }
    }
}
