package com.xiaomi.push;

import android.text.TextUtils;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.XGServerInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class bu {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f8299c;

    /* renamed from: d  reason: collision with root package name */
    public String f8300d;

    /* renamed from: e  reason: collision with root package name */
    public String f8301e;

    /* renamed from: f  reason: collision with root package name */
    public String f8302f;

    /* renamed from: g  reason: collision with root package name */
    public String f8303g;

    /* renamed from: h  reason: collision with root package name */
    public String f8304h;

    /* renamed from: i  reason: collision with root package name */
    private long f8305i;

    /* renamed from: k  reason: collision with root package name */
    private String f8307k;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<ce> f8306j = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private double f8308l = 0.1d;

    /* renamed from: m  reason: collision with root package name */
    private String f8309m = "s.mi1.cc";
    private long n = 86400000;

    public bu(String str) {
        this.a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f8305i = System.currentTimeMillis();
        this.f8306j.add(new ce(str, -1));
        this.a = by.b();
        this.b = str;
    }

    private synchronized void d(String str) {
        Iterator<ce> it = this.f8306j.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().a, str)) {
                it.remove();
            }
        }
    }

    public synchronized bu a(JSONObject jSONObject) {
        this.a = jSONObject.optString("net");
        this.n = jSONObject.getLong("ttl");
        this.f8308l = jSONObject.getDouble("pct");
        this.f8305i = jSONObject.getLong("ts");
        this.f8300d = jSONObject.optString("city");
        this.f8299c = jSONObject.optString("prv");
        this.f8303g = jSONObject.optString("cty");
        this.f8301e = jSONObject.optString("isp");
        this.f8302f = jSONObject.optString(XGServerInfo.TAG_IP);
        this.b = jSONObject.optString(ReportItem.RequestKeyHost);
        this.f8304h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a(new ce().a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }

    public ArrayList<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.b)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = a(true).iterator();
            while (it.hasNext()) {
                bw a = bw.a(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a.b(), a.a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        String substring;
        int size = this.f8306j.size();
        ce[] ceVarArr = new ce[size];
        this.f8306j.toArray(ceVarArr);
        Arrays.sort(ceVarArr);
        arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < size; i2++) {
            ce ceVar = ceVarArr[i2];
            if (z) {
                substring = ceVar.a;
            } else {
                int indexOf = ceVar.a.indexOf(Constants.COLON_SEPARATOR);
                substring = indexOf != -1 ? ceVar.a.substring(0, indexOf) : ceVar.a;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    public void a(double d2) {
        this.f8308l = d2;
    }

    public void a(long j2) {
        if (j2 > 0) {
            this.n = j2;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j2);
    }

    public synchronized void a(ce ceVar) {
        d(ceVar.a);
        this.f8306j.add(ceVar);
    }

    public void a(String str, int i2, long j2, long j3, Exception exc) {
        a(str, new bt(i2, j2, j3, exc));
    }

    public void a(String str, long j2, long j3) {
        try {
            b(new URL(str).getHost(), j2, j3);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j2, long j3, Exception exc) {
        try {
            b(new URL(str).getHost(), j2, j3, exc);
        } catch (MalformedURLException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        r1.a(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(java.lang.String r4, com.xiaomi.push.bt r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList<com.xiaomi.push.ce> r0 = r3.f8306j     // Catch: java.lang.Throwable -> L20
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L20
        L7:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L20
            com.xiaomi.push.ce r1 = (com.xiaomi.push.ce) r1     // Catch: java.lang.Throwable -> L20
            java.lang.String r2 = r1.a     // Catch: java.lang.Throwable -> L20
            boolean r2 = android.text.TextUtils.equals(r4, r2)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L7
            r1.a(r5)     // Catch: java.lang.Throwable -> L20
        L1e:
            monitor-exit(r3)
            return
        L20:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bu.a(java.lang.String, com.xiaomi.push.bt):void");
    }

    public synchronized void a(String[] strArr) {
        int i2;
        int size = this.f8306j.size() - 1;
        while (true) {
            i2 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i2 < length) {
                    if (TextUtils.equals(this.f8306j.get(size).a, strArr[i2])) {
                        this.f8306j.remove(size);
                        break;
                    }
                    i2++;
                }
            }
            size--;
        }
        Iterator<ce> it = this.f8306j.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i4 = it.next().b;
            if (i4 > i3) {
                i3 = i4;
            }
        }
        while (i2 < strArr.length) {
            a(new ce(strArr[i2], (strArr.length + i3) - i2));
            i2++;
        }
    }

    public boolean a() {
        return TextUtils.equals(this.a, by.b());
    }

    public boolean a(bu buVar) {
        return TextUtils.equals(this.a, buVar.a);
    }

    public synchronized void b(String str) {
        a(new ce(str));
    }

    public void b(String str, long j2, long j3) {
        a(str, 0, j2, j3, null);
    }

    public void b(String str, long j2, long j3, Exception exc) {
        a(str, -1, j2, j3, exc);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f8305i < this.n;
    }

    public void c(String str) {
        this.f8309m = str;
    }

    public boolean c() {
        long j2 = this.n;
        if (864000000 >= j2) {
            j2 = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f8305i;
        return currentTimeMillis - j3 > j2 || (currentTimeMillis - j3 > this.n && this.a.startsWith("WIFI-"));
    }

    public synchronized ArrayList<String> d() {
        return a(false);
    }

    public synchronized String e() {
        if (!TextUtils.isEmpty(this.f8307k)) {
            return this.f8307k;
        } else if (TextUtils.isEmpty(this.f8301e)) {
            return "hardcode_isp";
        } else {
            String a = ar.a(new String[]{this.f8301e, this.f8299c, this.f8300d, this.f8303g, this.f8302f}, "_");
            this.f8307k = a;
            return a;
        }
    }

    public synchronized JSONObject f() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.a);
        jSONObject.put("ttl", this.n);
        jSONObject.put("pct", this.f8308l);
        jSONObject.put("ts", this.f8305i);
        jSONObject.put("city", this.f8300d);
        jSONObject.put("prv", this.f8299c);
        jSONObject.put("cty", this.f8303g);
        jSONObject.put("isp", this.f8301e);
        jSONObject.put(XGServerInfo.TAG_IP, this.f8302f);
        jSONObject.put(ReportItem.RequestKeyHost, this.b);
        jSONObject.put("xf", this.f8304h);
        JSONArray jSONArray = new JSONArray();
        Iterator<ce> it = this.f8306j.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        sb.append(e());
        Iterator<ce> it = this.f8306j.iterator();
        while (it.hasNext()) {
            sb.append("\n");
            sb.append(it.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
