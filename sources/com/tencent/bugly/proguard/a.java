package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.qiniu.android.common.Constants;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static Proxy f6655e;
    public HashMap<String, HashMap<String, byte[]>> a = new HashMap<>();
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public h f6656c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, Object> f6657d;

    public a() {
        new HashMap();
        this.f6657d = new HashMap<>();
        this.b = "GBK";
        this.f6656c = new h();
    }

    public static void a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            f6655e = null;
        } else {
            f6655e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        }
    }

    public static Proxy b() {
        return f6655e;
    }

    public static ao b(byte[] bArr) {
        if (bArr != null) {
            try {
                d dVar = new d();
                dVar.c();
                dVar.a(Constants.UTF_8);
                dVar.a(bArr);
                Object b = dVar.b("detail", new ao());
                if (ao.class.isInstance(b)) {
                    return (ao) ao.class.cast(b);
                }
                return null;
            } catch (Throwable th) {
                if (!y.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static boolean a(ActivityManager activityManager) {
        boolean z;
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                y.c("running proc info list is empty, my proc not running.", new Object[0]);
            } else {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        y.c("my proc is running.", new Object[0]);
                    }
                }
                y.c("proc not in running proc info list, my proc not running.", new Object[0]);
            }
            z = false;
            return z && a(activityManager, 0L) != null;
        }
        y.c("is proc running, ActivityManager is null", new Object[0]);
        z = true;
        if (z) {
            return false;
        }
    }

    public static void a(InetAddress inetAddress, int i2) {
        if (inetAddress == null) {
            f6655e = null;
        } else {
            f6655e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i2));
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public static ar a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        ar arVar = new ar();
        arVar.a = userInfoBean.f6495e;
        arVar.f6732e = userInfoBean.f6500j;
        arVar.f6731d = userInfoBean.f6493c;
        arVar.f6730c = userInfoBean.f6494d;
        arVar.f6734g = userInfoBean.o == 1;
        int i2 = userInfoBean.b;
        if (i2 == 1) {
            arVar.b = (byte) 1;
        } else if (i2 == 2) {
            arVar.b = (byte) 4;
        } else if (i2 == 3) {
            arVar.b = (byte) 2;
        } else if (i2 == 4) {
            arVar.b = (byte) 3;
        } else if (i2 == 8) {
            arVar.b = (byte) 8;
        } else if (i2 < 10 || i2 >= 20) {
            y.e("unknown uinfo type %d ", Integer.valueOf(i2));
            return null;
        } else {
            arVar.b = (byte) i2;
        }
        HashMap hashMap = new HashMap();
        arVar.f6733f = hashMap;
        if (userInfoBean.p >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.p);
            hashMap.put("C01", sb.toString());
        }
        if (userInfoBean.q >= 0) {
            Map<String, String> map = arVar.f6733f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.q);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = userInfoBean.r;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                Map<String, String> map3 = arVar.f6733f;
                map3.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map4 = userInfoBean.s;
        if (map4 != null && map4.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                Map<String, String> map5 = arVar.f6733f;
                map5.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map6 = arVar.f6733f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.f6502l);
        map6.put("A36", sb3.toString());
        Map<String, String> map7 = arVar.f6733f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.f6497g);
        map7.put("F02", sb4.toString());
        Map<String, String> map8 = arVar.f6733f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f6498h);
        map8.put("F03", sb5.toString());
        Map<String, String> map9 = arVar.f6733f;
        map9.put("F04", userInfoBean.f6500j);
        Map<String, String> map10 = arVar.f6733f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f6499i);
        map10.put("F05", sb6.toString());
        Map<String, String> map11 = arVar.f6733f;
        map11.put("F06", userInfoBean.f6503m);
        Map<String, String> map12 = arVar.f6733f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f6501k);
        map12.put("F10", sb7.toString());
        y.c("summary type %d vm:%d", Byte.valueOf(arVar.b), Integer.valueOf(arVar.f6733f.size()));
        return arVar;
    }

    public static ActivityManager.ProcessErrorStateInfo a(ActivityManager activityManager, long j2) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo;
        if (activityManager == null) {
            y.c("get anr state, ActivityManager is null", new Object[0]);
            return null;
        }
        y.c("get anr state, timeout:%d", Long.valueOf(j2));
        long j3 = j2 / 500;
        int i2 = 0;
        while (true) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState == null || processesInErrorState.isEmpty()) {
                y.c("error state info list is null", new Object[0]);
            } else {
                int myPid = Process.myPid();
                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                while (it.hasNext()) {
                    processErrorStateInfo = it.next();
                    if (processErrorStateInfo.pid == myPid) {
                        y.c("found current proc in the error state", new Object[0]);
                        break;
                    }
                }
                y.c("current proc not in the error state", new Object[0]);
            }
            processErrorStateInfo = null;
            if (processErrorStateInfo == null) {
                y.c("found proc state is null", new Object[0]);
            } else {
                int i3 = processErrorStateInfo.condition;
                if (i3 == 2) {
                    y.c("found proc state is anr! proc:%s", processErrorStateInfo.processName);
                    return processErrorStateInfo;
                } else if (i3 == 1) {
                    y.c("found proc state is crashed!", new Object[0]);
                    return null;
                }
            }
            int i4 = i2 + 1;
            if (i2 < j3) {
                y.c("try the %s times:", Integer.valueOf(i4));
                ab.b(500L);
                i2 = i4;
            } else {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfo2 = new ActivityManager.ProcessErrorStateInfo();
                processErrorStateInfo2.pid = Process.myPid();
                processErrorStateInfo2.processName = AppInfo.a(Process.myPid());
                processErrorStateInfo2.shortMsg = "Find process anr, but unable to get anr message.";
                return processErrorStateInfo2;
            }
        }
    }

    public static String a(ArrayList<String> arrayList) {
        int i2;
        int i3;
        int i4;
        StringBuffer stringBuffer = new StringBuffer();
        int i5 = 0;
        while (true) {
            String str = "map";
            if (i5 < arrayList.size()) {
                String str2 = arrayList.get(i5);
                if (str2.equals("java.lang.Integer") || str2.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                    str = "int32";
                } else if (str2.equals("java.lang.Boolean") || str2.equals("boolean")) {
                    str = "bool";
                } else if (str2.equals("java.lang.Byte") || str2.equals("byte")) {
                    str = "char";
                } else if (str2.equals("java.lang.Double") || str2.equals("double")) {
                    str = "double";
                } else if (str2.equals("java.lang.Float") || str2.equals("float")) {
                    str = "float";
                } else if (str2.equals("java.lang.Long") || str2.equals("long")) {
                    str = "int64";
                } else if (str2.equals("java.lang.Short") || str2.equals("short")) {
                    str = "short";
                } else if (str2.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                } else {
                    if (str2.equals("java.lang.String")) {
                        str = "string";
                    } else if (str2.equals("java.util.List")) {
                        str = "list";
                    } else if (!str2.equals("java.util.Map")) {
                        str = str2;
                    }
                }
                arrayList.set(i5, str);
                i5++;
            } else {
                Collections.reverse(arrayList);
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    String str3 = arrayList.get(i6);
                    if (str3.equals("list")) {
                        arrayList.set(i6 - 1, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i4));
                        arrayList.set(0, arrayList.get(0) + SimpleComparison.GREATER_THAN_OPERATION);
                    } else if (str3.equals("map")) {
                        arrayList.set(i6 - 1, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i3) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                        arrayList.set(0, arrayList.get(0) + SimpleComparison.GREATER_THAN_OPERATION);
                    } else if (str3.equals("Array")) {
                        arrayList.set(i6 - 1, SimpleComparison.LESS_THAN_OPERATION + arrayList.get(i2));
                        arrayList.set(0, arrayList.get(0) + SimpleComparison.GREATER_THAN_OPERATION);
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
        }
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t != null) {
            if (!(t instanceof Set)) {
                i iVar = new i();
                iVar.a(this.b);
                iVar.a(t, 0);
                byte[] a = k.a(iVar.a());
                HashMap<String, byte[]> hashMap = new HashMap<>(1);
                ArrayList<String> arrayList = new ArrayList<>(1);
                a(arrayList, t);
                hashMap.put(a(arrayList), a);
                this.f6657d.remove(str);
                this.a.put(str, hashMap);
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    public static as a(List<UserInfoBean> list, int i2) {
        com.tencent.bugly.crashreport.common.info.a b;
        if (list == null || list.size() == 0 || (b = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        b.s();
        as asVar = new as();
        asVar.b = b.f6520d;
        asVar.f6738c = b.k();
        ArrayList<ar> arrayList = new ArrayList<>();
        for (UserInfoBean userInfoBean : list) {
            ar a = a(userInfoBean);
            if (a != null) {
                arrayList.add(a);
            }
        }
        asVar.f6739d = arrayList;
        HashMap hashMap = new HashMap();
        asVar.f6740e = hashMap;
        StringBuilder sb = new StringBuilder();
        b.getClass();
        hashMap.put("A7", sb.toString());
        Map<String, String> map = asVar.f6740e;
        map.put("A6", com.tencent.bugly.crashreport.common.info.a.r());
        Map<String, String> map2 = asVar.f6740e;
        map2.put("A5", b.q());
        Map<String, String> map3 = asVar.f6740e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b.o());
        map3.put("A2", sb2.toString());
        Map<String, String> map4 = asVar.f6740e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(b.o());
        map4.put("A1", sb3.toString());
        Map<String, String> map5 = asVar.f6740e;
        map5.put("A24", b.f6523g);
        Map<String, String> map6 = asVar.f6740e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(b.p());
        map6.put("A17", sb4.toString());
        Map<String, String> map7 = asVar.f6740e;
        map7.put("A15", b.u());
        Map<String, String> map8 = asVar.f6740e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(b.v());
        map8.put("A13", sb5.toString());
        Map<String, String> map9 = asVar.f6740e;
        map9.put("F08", b.u);
        Map<String, String> map10 = asVar.f6740e;
        map10.put("F09", b.v);
        Map<String, String> C = b.C();
        if (C != null && C.size() > 0) {
            for (Map.Entry<String, String> entry : C.entrySet()) {
                Map<String, String> map11 = asVar.f6740e;
                map11.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i2 == 1) {
            asVar.a = (byte) 1;
        } else if (i2 != 2) {
            y.e("unknown up type %d ", Integer.valueOf(i2));
            return null;
        } else {
            asVar.a = (byte) 2;
        }
        return asVar;
    }

    public static <T extends j> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                h hVar = new h(bArr);
                hVar.a(Constants.UTF_8);
                newInstance.a(hVar);
                return newInstance;
            } catch (Throwable th) {
                if (!y.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static an a(Context context, int i2, byte[] bArr) {
        String str;
        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (b != null && c2 != null) {
            try {
                an anVar = new an();
                synchronized (b) {
                    anVar.a = 1;
                    anVar.b = b.f();
                    anVar.f6699c = b.f6519c;
                    anVar.f6700d = b.f6525i;
                    anVar.f6701e = b.f6527k;
                    anVar.f6702f = b.f6522f;
                    anVar.f6703g = i2;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    anVar.f6704h = bArr;
                    anVar.f6705i = b.l();
                    anVar.f6706j = b.f6523g;
                    anVar.f6707k = new HashMap();
                    anVar.f6708l = b.e();
                    anVar.f6709m = c2.n;
                    anVar.o = b.k();
                    anVar.p = com.tencent.bugly.crashreport.common.info.b.b(context);
                    anVar.q = System.currentTimeMillis();
                    anVar.r = b.m();
                    anVar.s = b.k();
                    anVar.t = anVar.p;
                    b.getClass();
                    anVar.n = "com.tencent.bugly";
                    Map<String, String> map = anVar.f6707k;
                    map.put("A26", b.w());
                    Map<String, String> map2 = anVar.f6707k;
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.tencent.bugly.crashreport.common.info.a.H());
                    map2.put("A62", sb.toString());
                    Map<String, String> map3 = anVar.f6707k;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(com.tencent.bugly.crashreport.common.info.a.I());
                    map3.put("A63", sb2.toString());
                    Map<String, String> map4 = anVar.f6707k;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(b.z);
                    map4.put("F11", sb3.toString());
                    Map<String, String> map5 = anVar.f6707k;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(b.y);
                    map5.put("F12", sb4.toString());
                    Map<String, String> map6 = anVar.f6707k;
                    map6.put("D3", b.f6526j);
                    List<com.tencent.bugly.a> list = com.tencent.bugly.b.b;
                    if (list != null) {
                        for (com.tencent.bugly.a aVar : list) {
                            String str2 = aVar.versionKey;
                            if (str2 != null && (str = aVar.version) != null) {
                                anVar.f6707k.put(str2, str);
                            }
                        }
                    }
                    anVar.f6707k.put("G15", ab.c("G15", ""));
                    anVar.f6707k.put("G10", ab.c("G10", ""));
                    anVar.f6707k.put("D4", ab.c("D4", "0"));
                }
                Map<String, String> B = b.B();
                if (B != null) {
                    for (Map.Entry<String, String> entry : B.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getValue())) {
                            anVar.f6707k.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                return anVar;
            } catch (Throwable th) {
                if (!y.b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        y.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (obj.getClass().getComponentType().toString().equals("byte")) {
                if (Array.getLength(obj) > 0) {
                    arrayList.add("java.util.List");
                    a(arrayList, Array.get(obj, 0));
                    return;
                }
                arrayList.add("Array");
                arrayList.add("?");
                return;
            }
            throw new IllegalArgumentException("only byte[] is supported");
        } else if (!(obj instanceof Array)) {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    a(arrayList, list.get(0));
                } else {
                    arrayList.add("?");
                }
            } else if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    Object obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                    a(arrayList, obj2);
                    return;
                }
                arrayList.add("?");
                arrayList.add("?");
            } else {
                arrayList.add(obj.getClass().getName());
            }
        } else {
            throw new IllegalArgumentException("can not support Array, please use List");
        }
    }

    public byte[] a() {
        i iVar = new i(0);
        iVar.a(this.b);
        iVar.a((Map) this.a, 0);
        return k.a(iVar.a());
    }

    public static byte[] a(Object obj) {
        try {
            d dVar = new d();
            dVar.c();
            dVar.a(Constants.UTF_8);
            dVar.a(1);
            dVar.b("RqdServer");
            dVar.c("sync");
            dVar.a("detail", (String) obj);
            return dVar.a();
        } catch (Throwable th) {
            if (y.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public void a(byte[] bArr) {
        this.f6656c.a(bArr);
        this.f6656c.a(this.b);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.a = this.f6656c.a((Map) hashMap, 0, false);
    }

    public static byte[] a(j jVar) {
        try {
            i iVar = new i();
            iVar.a(Constants.UTF_8);
            jVar.a(iVar);
            return iVar.b();
        } catch (Throwable th) {
            if (y.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
