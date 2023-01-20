package com.tencent.android.tpush.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.tencent.android.tpush.XGPushProvider;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class a {
    private static volatile a a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private PackageManager f6050c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, b> f6051d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Long> f6052e = new HashMap();

    private a(Context context) {
        this.b = null;
        this.f6050c = null;
        this.b = context;
        this.f6050c = context.getPackageManager();
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private boolean d() {
        String str = com.tencent.android.tpush.service.a.a.a(this.b).I;
        String str2 = Build.MANUFACTURER;
        TLogger.d("IPCManager", "wakeCtr:" + str + ",mf:" + str2);
        if (!i.b(str) || !i.b(str2)) {
            for (String str3 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (str3.toLowerCase().equals(str2.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void b() {
        TLogger.d("IPCManager", "action - initProviders");
        List<ProviderInfo> queryContentProviders = this.f6050c.queryContentProviders(null, 0, 0);
        List<String> c2 = c();
        if (queryContentProviders == null || c2 == null) {
            return;
        }
        for (ProviderInfo providerInfo : queryContentProviders) {
            if (c2.contains(providerInfo.packageName) && providerInfo.exported) {
                b bVar = this.f6051d.get(providerInfo.packageName);
                if (bVar == null) {
                    bVar = new b();
                }
                bVar.a(providerInfo.packageName);
                if (providerInfo.name.equals(XGPushProvider.class.getName())) {
                    bVar.a(providerInfo);
                } else {
                    bVar.b(providerInfo);
                }
                this.f6051d.put(providerInfo.packageName, bVar);
            }
        }
    }

    public List<String> c() {
        TLogger.d("IPCManager", "action - getAllLocalXGApps");
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryBroadcastReceivers = this.f6050c.queryBroadcastReceivers(new Intent(com.tencent.android.tpush.common.Constants.ACTION_SDK_INSTALL), 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                arrayList.add(resolveInfo.resolvePackageName);
            }
        }
        Map<String, ProviderInfo> a2 = com.tencent.android.tpush.a.a(this.b);
        if (a2 != null) {
            for (Map.Entry<String, ProviderInfo> entry : a2.entrySet()) {
                if (!arrayList.contains(entry.getKey())) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        return arrayList;
    }

    public void a() {
        try {
            b();
        } catch (Throwable th) {
            TLogger.e("IPCManager", "init", th);
        }
    }

    public void a(String str) {
        try {
            if (!d() || this.b.getPackageName().equals(str)) {
                return;
            }
            TLogger.d("IPCManager", "tryWakeUpApp packageName:" + str);
            c(str);
        } catch (Throwable th) {
            TLogger.e("IPCManager", "tryWakeUpApp", th);
        }
    }

    private void c(String str) {
        Long l2 = this.f6052e.get(str);
        if (l2 == null || System.currentTimeMillis() <= l2.longValue()) {
            b b = b(str);
            TLogger.d("IPCManager", "tryWakeUpApp ipcAppInfo:" + b);
            if (b != null) {
                ArrayList<ProviderInfo> a2 = b.a();
                TLogger.d("IPCManager", "tryWakeUpApp providerInfoList:" + a2);
                if (a2 != null) {
                    for (ProviderInfo providerInfo : a2) {
                        if (providerInfo.exported) {
                            String str2 = providerInfo.authority;
                            Uri parse = Uri.parse("content://" + str2);
                            TLogger.d("IPCManager", "tryWakeUpApp uri:" + parse);
                            this.b.getContentResolver().getType(parse);
                        }
                    }
                }
            }
            this.f6052e.put(str, Long.valueOf(System.currentTimeMillis() + com.heytap.mcssdk.constant.a.f3315e));
        }
    }

    public b b(String str) {
        if (!this.f6051d.containsKey(str)) {
            a();
        }
        return this.f6051d.get(str);
    }
}
