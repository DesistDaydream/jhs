package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class n implements Runnable {
    public final /* synthetic */ IOAdEvent a;
    public final /* synthetic */ m b;

    public n(m mVar, IOAdEvent iOAdEvent) {
        this.b = mVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener2;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener3;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener4;
        IOAdEvent iOAdEvent = this.a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.a.getType();
        if (v.ak.equals(type)) {
            List<CpuChannelResponse> a = k.a((JSONArray) this.a.getData().get("cpuChannelList"));
            cpuChannelListListener3 = this.b.a.q;
            if (cpuChannelListListener3 != null) {
                cpuChannelListListener4 = this.b.a.q;
                cpuChannelListListener4.onChannelListLoaded(a);
            }
        } else if (v.al.equals(type)) {
            Map<String, Object> data = this.a.getData();
            int i2 = 0;
            if (data != null) {
                str = (String) data.get("error_message");
                int i3 = data.get("error_code");
                if (i3 == null) {
                    i3 = 0;
                }
                i2 = ((Integer) i3).intValue();
            } else {
                str = "";
            }
            cpuChannelListListener = this.b.a.q;
            if (cpuChannelListListener != null) {
                cpuChannelListListener2 = this.b.a.q;
                cpuChannelListListener2.onChannelListError(str, i2);
            }
        }
    }
}
