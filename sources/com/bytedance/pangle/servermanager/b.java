package com.bytedance.pangle.servermanager;

import com.bytedance.pangle.c;
import com.bytedance.pangle.d;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class b {
    private static final Object a = new Object();
    private static final Object b = new Object();

    /* renamed from: c */
    private static final Object f2336c = new Object();

    /* renamed from: d */
    private static final Map<String, Boolean> f2337d = new ConcurrentHashMap();

    /* renamed from: e */
    private static final Map<String, d> f2338e = new ConcurrentHashMap();

    /* renamed from: f */
    private static c f2339f;

    public static d a(String str) {
        Boolean bool = f2337d.get(str);
        if (bool == null || !bool.booleanValue()) {
            f2338e.remove(str);
        }
        Map<String, d> map = f2338e;
        if (map.get(str) == null) {
            synchronized (b) {
                d dVar = (d) a("service", str);
                if (dVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                map.put(str, dVar);
            }
        }
        return map.get(str);
    }

    public static c a() {
        Boolean bool = f2337d.get("main");
        if (bool == null || !bool.booleanValue()) {
            f2339f = null;
        }
        if (f2339f == null) {
            synchronized (f2336c) {
                c cVar = (c) a("package", "main");
                if (cVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                f2339f = cVar;
            }
        }
        return f2339f;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0081 A[Catch: RemoteException -> 0x009a, TryCatch #0 {RemoteException -> 0x009a, blocks: (B:57:0x0056, B:72:0x0090, B:74:0x0095, B:62:0x0077, B:65:0x0081), top: B:83:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0095 A[Catch: RemoteException -> 0x009a, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x009a, blocks: (B:57:0x0056, B:72:0x0090, B:74:0x0095, B:62:0x0077, B:65:0x0081), top: B:83:0x0056 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.os.IInterface a(java.lang.String r6, final java.lang.String r7) {
        /*
            boolean r0 = com.bytedance.pangle.Zeus.hasInit()
            if (r0 == 0) goto Lb3
            java.util.HashMap r0 = com.bytedance.pangle.Zeus.getServerManagerHashMap()
            java.lang.Object r0 = r0.get(r7)
            android.content.pm.ProviderInfo r0 = (android.content.pm.ProviderInfo) r0
            if (r0 == 0) goto La3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "content://"
            r1.<init>(r2)
            java.lang.String r0 = r0.authority
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.app.Application r1 = com.bytedance.pangle.Zeus.getAppApplication()
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.lang.String r2 = "query_binder"
            r3 = 0
            android.os.Bundle r0 = r1.call(r0, r2, r6, r3)
            if (r0 == 0) goto L4d
            java.lang.Class<com.bytedance.pangle.servermanager.AbsServerManager> r1 = com.bytedance.pangle.servermanager.AbsServerManager.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            java.lang.String r1 = "binder"
            android.os.Parcelable r0 = r0.getParcelable(r1)
            com.bytedance.pangle.servermanager.a r0 = (com.bytedance.pangle.servermanager.a) r0
            if (r0 == 0) goto L4d
            android.os.IBinder r0 = r0.a
            goto L4e
        L4d:
            r0 = r3
        L4e:
            if (r0 == 0) goto La2
            boolean r1 = r0.isBinderAlive()
            if (r1 == 0) goto La2
            com.bytedance.pangle.servermanager.b$1 r1 = new com.bytedance.pangle.servermanager.b$1     // Catch: android.os.RemoteException -> L9a
            r1.<init>()     // Catch: android.os.RemoteException -> L9a
            r2 = 0
            r0.linkToDeath(r1, r2)     // Catch: android.os.RemoteException -> L9a
            java.util.Map<java.lang.String, java.lang.Boolean> r1 = com.bytedance.pangle.servermanager.b.f2337d     // Catch: android.os.RemoteException -> L9a
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch: android.os.RemoteException -> L9a
            r1.put(r7, r4)     // Catch: android.os.RemoteException -> L9a
            r7 = -1
            int r1 = r6.hashCode()     // Catch: android.os.RemoteException -> L9a
            r4 = -807062458(0xffffffffcfe53446, float:-7.6908165E9)
            r5 = 1
            if (r1 == r4) goto L81
            r2 = 1984153269(0x7643c6b5, float:9.927033E32)
            if (r1 == r2) goto L77
            goto L8a
        L77:
            java.lang.String r1 = "service"
            boolean r6 = r6.equals(r1)     // Catch: android.os.RemoteException -> L9a
            if (r6 == 0) goto L8a
            r2 = 1
            goto L8b
        L81:
            java.lang.String r1 = "package"
            boolean r6 = r6.equals(r1)     // Catch: android.os.RemoteException -> L9a
            if (r6 == 0) goto L8a
            goto L8b
        L8a:
            r2 = -1
        L8b:
            if (r2 == 0) goto L95
            if (r2 == r5) goto L90
            goto La2
        L90:
            com.bytedance.pangle.d r6 = com.bytedance.pangle.d.a.a(r0)     // Catch: android.os.RemoteException -> L9a
            return r6
        L95:
            com.bytedance.pangle.c r6 = com.bytedance.pangle.c.a.a(r0)     // Catch: android.os.RemoteException -> L9a
            return r6
        L9a:
            r6 = move-exception
            java.lang.String r7 = "Zeus/server"
            java.lang.String r0 = "generateServerManager failed."
            com.bytedance.pangle.log.ZeusLogger.errReport(r7, r0, r6)
        La2:
            return r3
        La3:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r0 = "????????????????????????????????????serverManager "
            java.lang.String r7 = r0.concat(r7)
            r6.<init>(r7)
            throw r6
        Lb3:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r0 = "generateServerManager ???????????????Zeus, processName:"
            java.lang.String r7 = r0.concat(r7)
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.servermanager.b.a(java.lang.String, java.lang.String):android.os.IInterface");
    }
}
