package com.bytedance.pangle.service.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.d;
import com.bytedance.pangle.f;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.servermanager.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@Keep
/* loaded from: classes.dex */
public class ServiceManagerNative {
    private static volatile ServiceManagerNative sInstance;
    private final HashMap<ServiceConnection, f> serviceConn2ServiceConn = new HashMap<>();
    public HashMap<IBinder, HashMap<ServiceConnection, HashSet<ComponentName>>> process2ConnAndService = new HashMap<>();
    private HashMap<ServiceConnection, HashSet<ServiceInfo>> conn2Service = new HashMap<>();

    private ServiceManagerNative() {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String ServiceManagerNative1663646904329dc(java.lang.String r2) {
        /*
        L0:
            r0 = 74
            r1 = 55
        L4:
            switch(r0) {
                case 72: goto L0;
                case 73: goto L8;
                case 74: goto Lb;
                default: goto L7;
            }
        L7:
            goto L2b
        L8:
            switch(r1) {
                case 94: goto L26;
                case 95: goto Lf;
                case 96: goto Lf;
                default: goto Lb;
            }
        Lb:
            switch(r1) {
                case 55: goto L26;
                case 56: goto L26;
                case 57: goto Lf;
                default: goto Le;
            }
        Le:
            goto L26
        Lf:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L14:
            int r1 = r2.length
            if (r0 >= r1) goto L20
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L14
        L20:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L26:
            r0 = 73
            r1 = 96
            goto L4
        L2b:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.service.client.ServiceManagerNative.ServiceManagerNative1663646904329dc(java.lang.String):java.lang.String");
    }

    public static ServiceManagerNative getInstance() {
        if (sInstance == null) {
            synchronized (ServiceManagerNative.class) {
                if (sInstance == null) {
                    sInstance = new ServiceManagerNative();
                }
            }
        }
        return sInstance;
    }

    public boolean bindServiceNative(Context context, Intent intent, final ServiceConnection serviceConnection, int i2, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.bindService(intent, serviceConnection, i2);
        }
        if (!this.serviceConn2ServiceConn.containsKey(serviceConnection)) {
            this.serviceConn2ServiceConn.put(serviceConnection, new f.a() { // from class: com.bytedance.pangle.service.client.ServiceManagerNative.1
                @Override // com.bytedance.pangle.f
                public final void a(ComponentName componentName, IBinder iBinder) {
                    serviceConnection.onServiceConnected(componentName, iBinder);
                }

                @Override // com.bytedance.pangle.f
                public final int a() {
                    return serviceConnection.hashCode();
                }
            });
        }
        if (this.conn2Service.get(serviceConnection) == null) {
            this.conn2Service.put(serviceConnection, new HashSet<>());
        }
        this.conn2Service.get(serviceConnection).add(queryServiceFromPlugin);
        d a = b.a(queryServiceFromPlugin.processName);
        IBinder asBinder = a.asBinder();
        HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = this.process2ConnAndService.get(asBinder);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.process2ConnAndService.put(asBinder, hashMap);
        }
        HashSet<ComponentName> hashSet = hashMap.get(serviceConnection);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            hashMap.put(serviceConnection, hashSet);
        }
        hashSet.add(intent.getComponent());
        try {
            return a.a(intent, this.serviceConn2ServiceConn.get(serviceConnection), i2, str);
        } catch (RemoteException e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed!", e2);
            return false;
        }
    }

    public ServiceInfo queryServiceFromPlugin(Intent intent, String str) {
        Zeus.loadPlugin(str);
        ComponentName component = intent.getComponent();
        if (component == null) {
            return null;
        }
        return PluginManager.getInstance().getPlugin(str).pluginServices.get(component.getClassName());
    }

    public ComponentName startServiceNative(Context context, Intent intent, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.startService(intent);
        }
        try {
            return b.a(queryServiceFromPlugin.processName).a(intent, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean stopServiceNative(Context context, Intent intent, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.stopService(intent);
        }
        try {
            return b.a(queryServiceFromPlugin.processName).b(intent, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void unbindServiceNative(ServiceConnection serviceConnection) {
        HashSet<ServiceInfo> hashSet = this.conn2Service.get(serviceConnection);
        if (hashSet != null) {
            Iterator<ServiceInfo> it = hashSet.iterator();
            while (it.hasNext()) {
                try {
                    b.a(it.next().processName).a(this.serviceConn2ServiceConn.get(serviceConnection));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
