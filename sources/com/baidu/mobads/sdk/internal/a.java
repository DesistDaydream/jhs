package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public static final String a = "none";
    public static final String b = "text";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1398c = "static_image";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1399d = "gif";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1400e = "rich_media";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1401f = "html";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1402g = "hybrid";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1403h = "video";

    /* renamed from: i  reason: collision with root package name */
    private static final long f1404i = 1750000;
    private String A;
    private String B;
    private int C;
    private String D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private String K;
    private List<String> M;
    private JSONObject N;
    private long O;
    private long P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private JSONObject X;
    private int Y;
    private int Z;
    private int aa;
    private List<String> ab;

    /* renamed from: j  reason: collision with root package name */
    private String f1405j;

    /* renamed from: k  reason: collision with root package name */
    private String f1406k;

    /* renamed from: l  reason: collision with root package name */
    private String f1407l;

    /* renamed from: m  reason: collision with root package name */
    private String f1408m;
    private int n;
    private int o;
    private String p;
    private long q;
    private int r;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    private int s = 1;
    private String L = "none";

    /* JADX WARN: Removed duplicated region for block: B:43:0x0146 A[Catch: all -> 0x0175, JSONException -> 0x017a, TryCatch #3 {JSONException -> 0x017a, all -> 0x0175, blocks: (B:5:0x007c, B:8:0x008e, B:10:0x009f, B:11:0x00b6, B:13:0x00c2, B:15:0x00cd, B:17:0x00d3, B:18:0x00d5, B:20:0x00db, B:22:0x00e1, B:24:0x00e9, B:28:0x00f2, B:30:0x00fc, B:31:0x0119, B:33:0x011f, B:34:0x0125, B:36:0x012d, B:38:0x0133, B:40:0x013d, B:43:0x0146, B:45:0x0154, B:47:0x015b, B:48:0x0163, B:50:0x0169), top: B:101:0x007c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.mobads.sdk.internal.a a(org.json.JSONObject r17) {
        /*
            Method dump skipped, instructions count: 781
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.a.a(org.json.JSONObject):com.baidu.mobads.sdk.internal.a");
    }

    public static boolean a(int i2) {
        return (i2 < 28 || 31 == i2 || 32 == i2 || 38 == i2 || 39 == i2 || 40 == i2 || 42 < i2) ? false : true;
    }

    public String A() {
        return this.z;
    }

    public String B() {
        return this.y;
    }

    public String C() {
        return this.A;
    }

    public String D() {
        return this.B;
    }

    public long E() {
        return this.P;
    }

    public List<String> F() {
        return this.M;
    }

    public String G() {
        return this.Q;
    }

    public JSONObject H() {
        return this.N;
    }

    public String I() {
        return this.T;
    }

    public String J() {
        return this.U;
    }

    public String K() {
        return this.V;
    }

    public String L() {
        String str = this.W;
        return (str == null || str.length() <= 4) ? this.W : "";
    }

    public int M() {
        return this.aa;
    }

    public List<String> N() {
        return this.ab;
    }

    public JSONObject O() {
        return this.X;
    }

    public int P() {
        return this.Y;
    }

    public int Q() {
        return this.Z;
    }

    public JSONObject R() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.Q);
            jSONObject.put("tit", this.f1405j);
            jSONObject.put("desc", this.f1406k);
            jSONObject.put(PushConstants.URI_PACKAGE_NAME, this.v);
            jSONObject.put("appname", this.p);
            jSONObject.put("act", this.C);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b() {
        return this.f1406k;
    }

    public String c() {
        return this.f1407l;
    }

    public String d() {
        return this.f1408m;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.o;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.R;
    }

    public String i() {
        return this.S;
    }

    public long j() {
        return this.q;
    }

    public int k() {
        return this.r;
    }

    public int l() {
        return this.s;
    }

    public String m() {
        return this.v;
    }

    public String n() {
        return this.w;
    }

    public String o() {
        return this.x;
    }

    public int p() {
        return this.C;
    }

    public String q() {
        return this.D;
    }

    public int r() {
        return this.E;
    }

    public int s() {
        return this.F;
    }

    public int t() {
        return this.G;
    }

    public int u() {
        return this.H;
    }

    public int v() {
        return this.I;
    }

    public int w() {
        return this.J;
    }

    public String x() {
        return this.L;
    }

    public long y() {
        return this.O;
    }

    public String z() {
        if (!TextUtils.isEmpty(this.u)) {
            return this.u;
        }
        return this.t;
    }

    public static List<a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i2)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static int a(JSONObject jSONObject, int i2, int i3) {
        String[] split;
        int i4 = 0;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("st_op");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("tp_id");
                    if (!TextUtils.isEmpty(optString) && optString.startsWith("opt_style_") && (split = optString.substring(10).split("_")) != null && split.length > 0) {
                        i4 = Integer.parseInt(split[0]);
                    }
                }
            } catch (Throwable th) {
                bj.a().d(th.getMessage());
            }
        }
        if (a(i4)) {
            i2 = i4;
        } else if (!a(i2)) {
            i2 = i3;
        }
        if (i2 == 42) {
            return 41;
        }
        return i2;
    }

    public String a() {
        return this.f1405j;
    }
}
