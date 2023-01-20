package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.XGServerInfo;
import com.xiaomi.mipush.sdk.Constants;
import e.l.r.i0;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class by {

    /* renamed from: c  reason: collision with root package name */
    public static Context f8310c;

    /* renamed from: l  reason: collision with root package name */
    private static by f8312l;

    /* renamed from: m  reason: collision with root package name */
    private static a f8313m;
    private static String n;
    private static String o;
    public final Map<String, bv> a;

    /* renamed from: d  reason: collision with root package name */
    public b f8314d;

    /* renamed from: f  reason: collision with root package name */
    private bx f8315f;

    /* renamed from: g  reason: collision with root package name */
    private String f8316g;

    /* renamed from: h  reason: collision with root package name */
    private long f8317h;

    /* renamed from: i  reason: collision with root package name */
    private final long f8318i;

    /* renamed from: j  reason: collision with root package name */
    private long f8319j;

    /* renamed from: k  reason: collision with root package name */
    private String f8320k;
    public static final Map<String, bu> b = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static boolean f8311e = false;

    /* loaded from: classes3.dex */
    public interface a {
        by a(Context context, bx bxVar, b bVar, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        String a(String str);
    }

    public by(Context context, bx bxVar, b bVar, String str) {
        this(context, bxVar, bVar, str, null, null);
    }

    public by(Context context, bx bxVar, b bVar, String str, String str2, String str3) {
        this.a = new HashMap();
        this.f8316g = "0";
        this.f8317h = 0L;
        this.f8318i = 15L;
        this.f8319j = 0L;
        this.f8320k = "isp_prov_city_country_ip";
        this.f8314d = bVar;
        this.f8315f = bxVar == null ? new bz(this) : bxVar;
        this.f8316g = str;
        n = str2 == null ? context.getPackageName() : str2;
        o = str3 == null ? m() : str3;
    }

    public static synchronized by a() {
        by byVar;
        synchronized (by.class) {
            byVar = f8312l;
            if (byVar == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return byVar;
    }

    private ArrayList<bu> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        k();
        synchronized (this.a) {
            h();
            for (String str : this.a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        Map<String, bu> map = b;
        synchronized (map) {
            for (Object obj : map.values().toArray()) {
                bu buVar = (bu) obj;
                if (!buVar.b()) {
                    b.remove(buVar.b);
                }
            }
        }
        if (!arrayList.contains(c())) {
            arrayList.add(c());
        }
        ArrayList<bu> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(null);
        }
        try {
            String str2 = al.f(f8310c) ? "wifi" : i0.f14286e;
            String a2 = a(arrayList, str2, this.f8316g, true);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                com.xiaomi.a.a.a.c.b(a2);
                if (com.baidu.mobads.sdk.internal.bp.f1532k.equalsIgnoreCase(jSONObject3.getString(ExifInterface.LATITUDE_SOUTH))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString(XGServerInfo.TAG_IP);
                    String string5 = jSONObject4.getString(com.umeng.analytics.pro.am.O);
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    com.xiaomi.a.a.a.c.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        String str3 = arrayList.get(i3);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            com.xiaomi.a.a.a.c.a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            bu buVar2 = new bu(str3);
                            int i4 = 0;
                            while (i4 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i4);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    buVar2.a(new ce(string6, optJSONArray.length() - i4));
                                }
                                i4++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i3, buVar2);
                            buVar2.f8303g = string5;
                            buVar2.f8299c = string;
                            buVar2.f8301e = string3;
                            buVar2.f8302f = string4;
                            buVar2.f8300d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                buVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                buVar2.c(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                buVar2.a(jSONObject4.getInt("ttl") * 1000);
                            }
                            g(buVar2.e());
                        }
                        i3++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j2 = com.baidu.mobads.sdk.internal.bc.f1469d;
                        if (jSONObject4.has("reserved-ttl")) {
                            j2 = jSONObject4.getInt("reserved-ttl") * 1000;
                        }
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                com.xiaomi.a.a.a.c.a("no bucket found for " + next);
                            } else {
                                bu buVar3 = new bu(next);
                                buVar3.a(j2);
                                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                    String string7 = optJSONArray2.getString(i5);
                                    if (!TextUtils.isEmpty(string7)) {
                                        buVar3.a(new ce(string7, optJSONArray2.length() - i5));
                                    }
                                }
                                Map<String, bu> map2 = b;
                                synchronized (map2) {
                                    if (this.f8315f.a(next)) {
                                        map2.put(next, buVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("failed to get bucket " + e2.getMessage());
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            bu buVar4 = arrayList2.get(i6);
            if (buVar4 != null) {
                a(arrayList.get(i6), buVar4);
            }
        }
        i();
        return arrayList2;
    }

    public static synchronized void a(Context context, bx bxVar, b bVar, String str, String str2, String str3) {
        synchronized (by.class) {
            Context applicationContext = context.getApplicationContext();
            f8310c = applicationContext;
            if (applicationContext == null) {
                f8310c = context;
            }
            if (f8312l == null) {
                a aVar = f8313m;
                if (aVar == null) {
                    f8312l = new by(context, bxVar, bVar, str, str2, str3);
                } else {
                    f8312l = aVar.a(context, bxVar, bVar, str);
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (by.class) {
            f8313m = aVar;
            f8312l = null;
        }
    }

    public static void a(String str, String str2) {
        Map<String, bu> map = b;
        bu buVar = map.get(str);
        synchronized (map) {
            if (buVar == null) {
                bu buVar2 = new bu(str);
                buVar2.a(com.baidu.mobads.sdk.internal.bc.f1469d);
                buVar2.b(str2);
                map.put(str, buVar2);
            } else {
                buVar.b(str2);
            }
        }
    }

    public static String b() {
        NetworkInfo activeNetworkInfo;
        Context context = f8310c;
        if (context == null) {
            return "unknown";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI-UNKNOWN";
            }
            return activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String f(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i2 = 0; i2 < bytes.length; i2++) {
                byte b2 = bytes[i2];
                int i3 = b2 & 240;
                if (i3 != 240) {
                    bytes[i2] = (byte) (((b2 & com.umeng.analytics.pro.cb.f7124m) ^ ((byte) (((b2 >> 4) + length) & 15))) | i3);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private String m() {
        try {
            PackageInfo packageInfo = f8310c.getPackageManager().getPackageInfo(f8310c.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    public bu a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return a(new URL(str).getHost(), true);
    }

    public bu a(String str, boolean z) {
        bu e2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (this.f8315f.a(str)) {
            bu c2 = c(str);
            return (c2 == null || !c2.b()) ? (z && al.c(f8310c) && (e2 = e(str)) != null) ? e2 : new ca(this, str, c2) : c2;
        }
        return null;
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<ak> arrayList3 = new ArrayList();
        arrayList3.add(new ai("type", str));
        if (str.equals(i0.f14286e)) {
            arrayList3.add(new ai("conpt", f(al.l(f8310c))));
        }
        if (z) {
            arrayList3.add(new ai("reserved", "1"));
        }
        arrayList3.add(new ai("uuid", str2));
        arrayList3.add(new ai("list", ar.a(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        arrayList3.add(new ai("countrycode", com.xiaomi.push.service.b.a(f8310c).b()));
        String c2 = c();
        bu c3 = c(c2);
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", c2);
        if (c3 == null) {
            arrayList2.add(format);
            Map<String, bu> map = b;
            synchronized (map) {
                bu buVar = map.get(c2);
                if (buVar != null) {
                    Iterator<String> it = buVar.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = c3.a(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e2 = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (ak akVar : arrayList3) {
                buildUpon.appendQueryParameter(akVar.a(), akVar.b());
            }
            try {
                b bVar = this.f8314d;
                return bVar == null ? al.a(f8310c, new URL(buildUpon.toString())) : bVar.a(buildUpon.toString());
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        com.xiaomi.a.a.a.c.a("network exception: " + e2.getMessage());
        throw e2;
    }

    public void a(String str, bu buVar) {
        if (TextUtils.isEmpty(str) || buVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + buVar);
        } else if (this.f8315f.a(str)) {
            synchronized (this.a) {
                h();
                if (this.a.containsKey(str)) {
                    this.a.get(str).a(buVar);
                } else {
                    bv bvVar = new bv(str);
                    bvVar.a(buVar);
                    this.a.put(str, bvVar);
                }
            }
        }
    }

    public bu b(String str) {
        return a(str, true);
    }

    public bu c(String str) {
        bv bvVar;
        bu a2;
        synchronized (this.a) {
            h();
            bvVar = this.a.get(str);
        }
        if (bvVar == null || (a2 = bvVar.a()) == null) {
            return null;
        }
        return a2;
    }

    public String c() {
        String a2 = com.xiaomi.push.service.b.a(f8310c).a();
        return (TextUtils.isEmpty(a2) || com.xiaomi.push.service.a.a.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    public bu d(String str) {
        bu buVar;
        Map<String, bu> map = b;
        synchronized (map) {
            buVar = map.get(str);
        }
        return buVar;
    }

    public void d() {
        synchronized (this.a) {
            this.a.clear();
        }
    }

    public bu e(String str) {
        if (System.currentTimeMillis() - this.f8319j > this.f8317h * 60 * 1000) {
            this.f8319j = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            bu buVar = a(arrayList).get(0);
            if (buVar != null) {
                this.f8317h = 0L;
                return buVar;
            }
            long j2 = this.f8317h;
            if (j2 < 15) {
                this.f8317h = j2 + 1;
                return null;
            }
            return null;
        }
        return null;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.a) {
            for (Map.Entry<String, bv> entry : this.a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void f() {
        ArrayList<String> arrayList;
        synchronized (this.a) {
            h();
            arrayList = new ArrayList<>(this.a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                bv bvVar = this.a.get(arrayList.get(size));
                if (bvVar != null && bvVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<bu> a2 = a(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (a2.get(i2) != null) {
                a(arrayList.get(i2), a2.get(i2));
            }
        }
    }

    public String g() {
        BufferedReader bufferedReader;
        File file;
        try {
            file = new File(f8310c.getFilesDir(), j());
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        if (!file.isFile()) {
            c.a((Closeable) null);
            return null;
        }
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                com.xiaomi.a.a.a.c.a("load host exception " + th.getMessage());
                return null;
            } finally {
                c.a(bufferedReader);
            }
        }
    }

    public void g(String str) {
        this.f8320k = str;
    }

    public void h(String str) {
        synchronized (this.a) {
            this.a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    bv a2 = new bv().a(optJSONArray.getJSONObject(i2));
                    this.a.put(a2.c(), a2);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i3);
                    String optString = jSONObject2.optString(ReportItem.RequestKeyHost);
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            bu a3 = new bu(optString).a(jSONObject2);
                            b.put(a3.b, a3);
                            com.xiaomi.a.a.a.c.a("load local reserved host for " + a3.b);
                        } catch (JSONException unused) {
                            com.xiaomi.a.a.a.c.a("parse reserved host fail.");
                        }
                    }
                }
            }
        }
    }

    public boolean h() {
        synchronized (this.a) {
            if (f8311e) {
                return true;
            }
            f8311e = true;
            this.a.clear();
            String g2 = g();
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            h(g2);
            com.xiaomi.a.a.a.c.b("loading the new hosts succeed");
            return true;
        }
    }

    public void i() {
        synchronized (this.a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(f8310c.openFileOutput(j(), 0)));
                String jSONObject = l().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.a("persist bucket failure: " + e2.getMessage());
            }
        }
    }

    public String j() {
        if ("com.xiaomi.xmsf".equals(n)) {
            return n;
        }
        return n + ":pushservice";
    }

    public void k() {
        String next;
        synchronized (this.a) {
            for (bv bvVar : this.a.values()) {
                bvVar.a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it = this.a.keySet().iterator();
                    while (it.hasNext()) {
                        next = it.next();
                        if (this.a.get(next).b().isEmpty()) {
                            break;
                        }
                    }
                }
                this.a.remove(next);
            }
        }
    }

    public JSONObject l() {
        JSONObject jSONObject;
        synchronized (this.a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (bv bvVar : this.a.values()) {
                jSONArray.put(bvVar.d());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (bu buVar : b.values()) {
                jSONArray2.put(buVar.f());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }
}
