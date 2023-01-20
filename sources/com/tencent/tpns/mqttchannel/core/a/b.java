package com.tencent.tpns.mqttchannel.core.a;

import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback;

/* loaded from: classes3.dex */
public abstract class b extends IMqttCallback.a {
    public abstract void callback(int i2, String str);

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback
    public final void handleCallback(final int i2, final String str) {
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.tpns.mqttchannel.core.a.b.1
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                b.this.callback(i2, str);
            }
        });
    }
}
