package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes3.dex */
public class ax implements ServiceConnection {
    public final /* synthetic */ a a;

    public ax(a aVar) {
        this.a = aVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.a) {
            this.a.f9059j = new Messenger(iBinder);
            this.a.f9058i = false;
            list = this.a.f9057h;
            for (Message message : list) {
                try {
                    messenger = this.a.f9059j;
                    messenger.send(message);
                } catch (RemoteException e2) {
                    com.xiaomi.a.a.a.c.a(e2);
                }
            }
            list2 = this.a.f9057h;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.f9059j = null;
        this.a.f9058i = false;
    }
}
