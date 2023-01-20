package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HMSPackageManager {

    /* renamed from: l  reason: collision with root package name */
    public static HMSPackageManager f3696l;

    /* renamed from: m  reason: collision with root package name */
    public static final Object f3697m = new Object();
    public static final Object n = new Object();
    public static final Object o = new Object();
    public final Context a;
    public final PackageManagerHelper b;

    /* renamed from: c  reason: collision with root package name */
    public String f3698c;

    /* renamed from: d  reason: collision with root package name */
    public String f3699d;

    /* renamed from: e  reason: collision with root package name */
    public int f3700e;

    /* renamed from: f  reason: collision with root package name */
    public String f3701f;

    /* renamed from: g  reason: collision with root package name */
    public String f3702g;

    /* renamed from: h  reason: collision with root package name */
    public String f3703h;

    /* renamed from: i  reason: collision with root package name */
    public int f3704i;

    /* renamed from: j  reason: collision with root package name */
    public int f3705j;

    /* renamed from: k  reason: collision with root package name */
    public long f3706k;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            for (ResolveInfo resolveInfo : HMSPackageManager.this.a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128)) {
                if ("com.huawei.hwid".equals(resolveInfo.serviceInfo.applicationInfo.packageName)) {
                    HMSPackageManager.this.c();
                }
            }
            HMSLog.i("HMSPackageManager", "quit asyncOnceCheckMDMState");
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Comparable<b> {
        public String a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f3707c;

        /* renamed from: d  reason: collision with root package name */
        public String f3708d;

        /* renamed from: e  reason: collision with root package name */
        public String f3709e;

        /* renamed from: f  reason: collision with root package name */
        public Long f3710f;

        public b(String str, String str2, String str3, String str4, String str5, long j2) {
            this.a = str;
            this.b = str2;
            this.f3707c = str3;
            this.f3708d = str4;
            this.f3709e = str5;
            this.f3710f = Long.valueOf(j2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            if (TextUtils.equals(this.f3709e, bVar.f3709e)) {
                return this.f3710f.compareTo(bVar.f3710f);
            }
            return this.f3709e.compareTo(bVar.f3709e);
        }
    }

    public HMSPackageManager(Context context) {
        this.a = context;
        this.b = new PackageManagerHelper(context);
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (f3697m) {
            if (f3696l == null) {
                if (context.getApplicationContext() != null) {
                    f3696l = new HMSPackageManager(context.getApplicationContext());
                } else {
                    f3696l = new HMSPackageManager(context);
                }
                f3696l.j();
                f3696l.a();
            }
        }
        return f3696l;
    }

    public final int c() {
        synchronized (o) {
            HMSLog.i("HMSPackageManager", "enter checkHmsIsSpoof");
            if (!(this.f3705j == 3 || this.f3706k != this.b.getPackageFirstInstallTime("com.huawei.hwid"))) {
                HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof cached state: " + a(this.f3705j));
                return this.f3705j;
            }
            this.f3705j = b() ? 2 : 1;
            this.f3706k = this.b.getPackageFirstInstallTime("com.huawei.hwid");
            HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof state: " + a(this.f3705j));
            return this.f3705j;
        }
    }

    public final void d() {
        synchronized (n) {
            this.f3701f = null;
            this.f3702g = null;
            this.f3703h = null;
            this.f3704i = 0;
        }
    }

    public final void e() {
        synchronized (n) {
            this.f3698c = null;
            this.f3699d = null;
            this.f3700e = 0;
        }
    }

    public final Pair<String, String> f() {
        List<ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
        if (queryIntentServices.size() == 0) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            String str = serviceInfo.applicationInfo.packageName;
            Bundle bundle = serviceInfo.metaData;
            if (bundle == null) {
                HMSLog.e("HMSPackageManager", "skip package " + str + " for metadata is null");
            } else if (!bundle.containsKey("hms_app_signer")) {
                HMSLog.e("HMSPackageManager", "skip package " + str + " for no signer");
            } else if (bundle.containsKey("hms_app_cert_chain")) {
                String packageSignature = this.b.getPackageSignature(str);
                if (!a(str + ContainerUtils.FIELD_DELIMITER + packageSignature, bundle.getString("hms_app_signer"), bundle.getString("hms_app_cert_chain"))) {
                    HMSLog.e("HMSPackageManager", "checkSigner failed");
                } else {
                    return new Pair<>(str, packageSignature);
                }
            } else {
                HMSLog.e("HMSPackageManager", "skip package " + str + " for no cert chain");
            }
        }
        return null;
    }

    public final Pair<String, String> g() {
        Pair<String, String> f2 = f();
        if (f2 != null) {
            HMSLog.i("HMSPackageManager", "aidlService pkgName: " + ((String) f2.first));
            this.f3703h = "com.huawei.hms.core.aidlservice";
            return f2;
        }
        ArrayList<b> h2 = h();
        if (h2 == null) {
            HMSLog.e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        Iterator<b> it = h2.iterator();
        while (it.hasNext()) {
            b next = it.next();
            String str = next.a;
            String str2 = next.b;
            String str3 = next.f3707c;
            String str4 = next.f3708d;
            String packageSignature = this.b.getPackageSignature(str);
            if (a(str + ContainerUtils.FIELD_DELIMITER + packageSignature + ContainerUtils.FIELD_DELIMITER + str2, str3, str4)) {
                HMSLog.i("HMSPackageManager", "result: " + str + ", " + str2 + ", " + next.f3710f);
                this.f3703h = PackageConstants.GENERAL_SERVICES_ACTION;
                b(str2);
                return new Pair<>(str, packageSignature);
            }
        }
        return null;
    }

    public String getHMSFingerprint() {
        String str = this.f3699d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public String getHMSPackageName() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String str = this.f3698c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                i();
            }
            String str2 = this.f3698c;
            if (str2 != null) {
                return str2;
            }
        }
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates("com.huawei.hwid")) || "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(this.b.getPackageSignature("com.huawei.hwid"))) {
        }
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String str = this.f3701f;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                j();
            }
            String str2 = this.f3701f;
            return str2 != null ? str2 : "com.huawei.hwid";
        }
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        synchronized (f3697m) {
            refresh();
            PackageManagerHelper.PackageStates packageStates = this.b.getPackageStates(this.f3698c);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                e();
                return packageStates2;
            }
            boolean z = false;
            if ("com.huawei.hwid".equals(this.f3698c) && c() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !this.f3699d.equals(this.b.getPackageSignature(this.f3698c))) {
                z = true;
            }
            return z ? packageStates2 : packageStates;
        }
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        synchronized (f3697m) {
            refreshForMultiService();
            PackageManagerHelper.PackageStates packageStates = this.b.getPackageStates(this.f3701f);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                d();
                return packageStates2;
            }
            boolean z = false;
            if ("com.huawei.hwid".equals(this.f3701f) && c() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !this.f3702g.equals(this.b.getPackageSignature(this.f3701f))) {
                z = true;
            }
            return z ? packageStates2 : packageStates;
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.b.getPackageVersionCode(getHMSPackageName());
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    public String getServiceAction() {
        return !TextUtils.isEmpty(this.f3703h) ? this.f3703h : "com.huawei.hms.core.aidlservice";
    }

    public final ArrayList<b> h() {
        List<ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            ArrayList<b> arrayList = new ArrayList<>();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                long packageFirstInstallTime = this.b.getPackageFirstInstallTime(str);
                Bundle bundle = resolveInfo.serviceInfo.metaData;
                if (bundle == null) {
                    HMSLog.e("HMSPackageManager", "package " + str + " get metaData is null");
                } else {
                    String a2 = a(bundle, "hms_app_checker_config");
                    String a3 = a(a2);
                    if (TextUtils.isEmpty(a3)) {
                        HMSLog.i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + a2);
                    } else {
                        String a4 = a(bundle, "hms_app_signer_v2");
                        if (TextUtils.isEmpty(a4)) {
                            HMSLog.i("HMSPackageManager", "get signerV2 fail.");
                        } else {
                            String a5 = a(bundle, "hms_app_cert_chain");
                            if (TextUtils.isEmpty(a5)) {
                                HMSLog.i("HMSPackageManager", "get certChain fail.");
                            } else {
                                HMSLog.i("HMSPackageManager", "add: " + str + ", " + a2 + ", " + packageFirstInstallTime);
                                arrayList.add(new b(str, a2, a4, a5, a3, packageFirstInstallTime));
                            }
                        }
                    }
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        }
        HMSLog.e("HMSPackageManager", "resolveInfoList is null or empty");
        return null;
    }

    public boolean hmsVerHigherThan(int i2) {
        if (this.f3700e >= i2 || !k()) {
            return true;
        }
        int packageVersionCode = this.b.getPackageVersionCode(getHMSPackageName());
        this.f3700e = packageVersionCode;
        return packageVersionCode >= i2;
    }

    public final void i() {
        synchronized (n) {
            Pair<String, String> f2 = f();
            if (f2 == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                e();
                return;
            }
            this.f3698c = (String) f2.first;
            this.f3699d = (String) f2.second;
            this.f3700e = this.b.getPackageVersionCode(getHMSPackageName());
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.f3698c + " version: " + this.f3700e);
        }
    }

    public boolean isApkNeedUpdate(int i2) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i2);
        return hmsVersionCode < i2;
    }

    public boolean isApkUpdateNecessary(int i2) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i2);
        return k() && hmsVersionCode < i2;
    }

    public final void j() {
        synchronized (n) {
            Pair<String, String> g2 = g();
            if (g2 == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                d();
                return;
            }
            this.f3701f = (String) g2.first;
            this.f3702g = (String) g2.second;
            this.f3704i = this.b.getPackageVersionCode(getHMSPackageNameForMultiService());
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f3701f + " version: " + this.f3704i);
        }
    }

    public final boolean k() {
        Bundle bundle;
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (RuntimeException e2) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e2);
        }
        if (!TextUtils.isEmpty(this.f3703h) && (this.f3703h.equals(PackageConstants.GENERAL_SERVICES_ACTION) || this.f3703h.equals(PackageConstants.INTERNAL_SERVICES_ACTION))) {
            HMSLog.i("HMSPackageManager", "action = " + this.f3703h + " exist");
            return false;
        }
        ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
            HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
            return false;
        }
        return true;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.f3698c) || TextUtils.isEmpty(this.f3699d)) {
            i();
        }
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f3701f) || TextUtils.isEmpty(this.f3702g)) {
            j();
        }
    }

    public void resetMultiServiceState() {
        d();
    }

    public final String a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            HMSLog.e("HMSPackageManager", "no " + str + " in metaData");
            return null;
        }
        return bundle.getString(str);
    }

    public final void b(String str) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        a2.substring(9);
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("priority=");
        if (indexOf == -1) {
            HMSLog.e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int indexOf2 = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf, indexOf2);
    }

    public final boolean b() {
        String hmsPath = ReadApkFileUtil.getHmsPath(this.a);
        if (hmsPath == null) {
            HMSLog.i("HMSPackageManager", "hmsPath is null!");
            return false;
        } else if (!ReadApkFileUtil.isCertFound(hmsPath)) {
            HMSLog.i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        } else if (!ReadApkFileUtil.checkSignature()) {
            HMSLog.i("HMSPackageManager", "checkSignature fail!");
            return false;
        } else if (ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        } else {
            HMSLog.i("HMSPackageManager", "verifyApkHash fail!");
            return false;
        }
    }

    public final boolean a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            List<X509Certificate> b2 = com.huawei.hms.device.a.b(str3);
            if (b2.size() == 0) {
                HMSLog.e("HMSPackageManager", "certChain is empty");
                return false;
            } else if (!com.huawei.hms.device.a.a(com.huawei.hms.device.a.a(this.a), b2)) {
                HMSLog.e("HMSPackageManager", "failed to verify cert chain");
                return false;
            } else {
                X509Certificate x509Certificate = b2.get(b2.size() - 1);
                if (!com.huawei.hms.device.a.a(x509Certificate, "Huawei CBG HMS")) {
                    HMSLog.e("HMSPackageManager", "CN is invalid");
                    return false;
                } else if (!com.huawei.hms.device.a.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                    HMSLog.e("HMSPackageManager", "OU is invalid");
                    return false;
                } else if (com.huawei.hms.device.a.a(x509Certificate, str, str2)) {
                    return true;
                } else {
                    HMSLog.e("HMSPackageManager", "signature is invalid: " + str);
                    return false;
                }
            }
        }
        HMSLog.e("HMSPackageManager", "args is invalid");
        return false;
    }

    public final void a() {
        new Thread(new a(), "Thread-asyncOnceCheckMDMState").start();
    }

    public static String a(int i2) {
        if (i2 == 1) {
            return "SPOOFED";
        }
        if (i2 == 2) {
            return "SUCCESS";
        }
        if (i2 == 3) {
            return "UNCHECKED";
        }
        HMSLog.e("HMSPackageManager", "invalid checkMDM state: " + i2);
        return "";
    }
}
