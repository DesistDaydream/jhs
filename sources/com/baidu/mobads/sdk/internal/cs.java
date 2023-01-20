package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;

/* loaded from: classes.dex */
public class cs implements ViewTreeObserver.OnWindowFocusChangeListener {
    public final /* synthetic */ RelativeLayout a;
    public final /* synthetic */ co b;

    public cs(co coVar, RelativeLayout relativeLayout) {
        this.b = coVar;
        this.a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", (Activity) this.b.f1461h);
            hashMap.put("banner_container", this.a);
            hashMap.put("entry", Integer.valueOf(this.b.D));
            hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.b.E));
            hashMap.put("novel_id", this.b.F);
            hashMap.put("isnight", Boolean.valueOf(this.b.w()));
            this.b.a(co.u, hashMap);
        }
    }
}
