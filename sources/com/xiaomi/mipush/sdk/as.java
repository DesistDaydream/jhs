package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes3.dex */
public class as implements ServiceConnection {
    public final /* synthetic */ ao a;

    public as(ao aoVar) {
        this.a = aoVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.a) {
            this.a.f29a = new Messenger(iBinder);
            this.a.f8222c = false;
            list = this.a.f32a;
            for (Message message : list) {
                try {
                    messenger = this.a.f29a;
                    messenger.send(message);
                } catch (RemoteException e2) {
                    com.xiaomi.a.a.a.c.a(e2);
                }
            }
            list2 = this.a.f32a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.f29a = null;
        this.a.f8222c = false;
    }
}
