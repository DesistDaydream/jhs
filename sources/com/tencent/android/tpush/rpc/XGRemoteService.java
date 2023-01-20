package com.tencent.android.tpush.rpc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.rpc.a;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.SERVICESCHECK})
/* loaded from: classes3.dex */
public class XGRemoteService extends Service {
    private a.AbstractBinderC0223a a = new d();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.tencent.android.tpush.service.b.b(getApplicationContext());
        return this.a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }
}
