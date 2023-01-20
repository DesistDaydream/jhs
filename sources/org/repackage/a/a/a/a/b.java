package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import org.repackage.a.a.a.a;

/* loaded from: classes4.dex */
public class b implements ServiceConnection {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.a = a.AbstractBinderC0508a.a(iBinder);
        synchronized (this.a.f17116d) {
            this.a.f17116d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.a = null;
    }
}
