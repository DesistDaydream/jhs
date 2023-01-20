package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.l0;
import com.bytedance.msdk.api.UserInfoForSegment;
import com.bytedance.msdk.api.v2.GMConfigCallback;
import com.bytedance.msdk.api.v2.GMConfigUserInfoForSegment;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    private static final b H = new b();
    private boolean A;
    private JSONObject B;
    private boolean C;
    private String D;
    private boolean E;
    private boolean F;
    private int[] G;

    /* renamed from: c  reason: collision with root package name */
    private String[] f683c;

    /* renamed from: d  reason: collision with root package name */
    private String f684d;

    /* renamed from: e  reason: collision with root package name */
    private String f685e;

    /* renamed from: i  reason: collision with root package name */
    private String f689i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f690j;

    /* renamed from: k  reason: collision with root package name */
    private String f691k;

    /* renamed from: l  reason: collision with root package name */
    private Map<String, String> f692l;

    /* renamed from: m  reason: collision with root package name */
    private String f693m;
    private String n;
    @Deprecated
    private UserInfoForSegment s;
    private GMConfigUserInfoForSegment t;
    private Map<String, Object> x;
    private List<String> y;
    private boolean z;
    private int a = 0;
    private boolean b = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f686f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f687g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f688h = false;
    private Set<String> o = new HashSet();
    private Map<String, Map<String, String>> p = new HashMap();
    private Map<String, Map<String, String>> q = new HashMap();
    private Map<String, Object> r = new HashMap();
    private int u = 2;
    private long v = -1;
    private GMPrivacyConfig w = new GMPrivacyConfig();

    private b() {
    }

    public static b I() {
        return H;
    }

    private static void g(String str) {
        a0.a(str, "appid不能为空");
    }

    private static void h(String str) {
        a0.a(str, "name不能为空");
    }

    public boolean A() {
        return this.f686f;
    }

    public boolean B() {
        return this.f687g;
    }

    public boolean C() {
        return this.f688h;
    }

    public boolean D() {
        return this.b;
    }

    public boolean E() {
        return this.E;
    }

    public boolean F() {
        return this.F;
    }

    public boolean G() {
        return ("com.header.app.untext".equals(a.d().getPackageName()) && "5001121".equals(this.f684d)) || ("com.bytedance.mediation_demo".equals(a.d().getPackageName()) && "5001121".equals(this.f684d));
    }

    public boolean H() {
        return this.C;
    }

    public String a() {
        if (TextUtils.isEmpty(this.n)) {
            String b = c0.a((String) null, a.d()).b();
            this.n = b;
            if (TextUtils.isEmpty(b)) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                c0.a((String) null, a.d()).e(valueOf);
                this.n = valueOf;
                return valueOf;
            }
        }
        return this.n;
    }

    public void a(int i2) {
        this.u = i2;
    }

    public void a(long j2) {
        try {
            c0 R = d.R();
            if (R.a("first_install_time", -1L) == -1) {
                this.v = j2;
                R.b("first_install_time", j2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Deprecated
    public void a(UserInfoForSegment userInfoForSegment, boolean z) {
        if (z) {
            this.s = userInfoForSegment;
            return;
        }
        UserInfoForSegment userInfoForSegment2 = this.s;
        boolean equals = (userInfoForSegment2 == null && userInfoForSegment == null) ? true : (userInfoForSegment2 == null || userInfoForSegment == null) ? false : userInfoForSegment2.equals(userInfoForSegment);
        this.s = userInfoForSegment;
        if (equals) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(a.f()).a().a(1);
    }

    public void a(GMConfigUserInfoForSegment gMConfigUserInfoForSegment, boolean z) {
        if (z) {
            this.t = gMConfigUserInfoForSegment;
            return;
        }
        GMConfigUserInfoForSegment gMConfigUserInfoForSegment2 = this.t;
        boolean equals = (gMConfigUserInfoForSegment2 == null && gMConfigUserInfoForSegment == null) ? true : (gMConfigUserInfoForSegment2 == null || gMConfigUserInfoForSegment == null) ? false : gMConfigUserInfoForSegment2.equals(gMConfigUserInfoForSegment);
        this.t = gMConfigUserInfoForSegment;
        if (equals) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(a.f()).a().a(1);
    }

    public void a(GMPrivacyConfig gMPrivacyConfig) {
        if (gMPrivacyConfig != null) {
            this.w = gMPrivacyConfig;
        }
    }

    public void a(Object obj, Object obj2) {
        if ((obj instanceof List) && (obj2 instanceof GMConfigCallback)) {
            try {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(a.f()).a((List) obj, (GMConfigCallback) obj2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(String str) {
        g(str);
        this.f684d = str;
    }

    public void a(List<String> list) {
        this.y = list;
    }

    public void a(Map<String, String> map) {
        this.f692l = map;
    }

    public void a(Set<String> set) {
        if (set != null) {
            this.o.addAll(set);
        }
    }

    public void a(JSONObject jSONObject) {
        this.B = jSONObject;
    }

    public void a(boolean z) {
        this.z = z;
    }

    public void a(int... iArr) {
        this.G = iArr;
    }

    public void a(String[] strArr) {
        this.f683c = strArr;
    }

    public String b() {
        return this.f684d;
    }

    public void b(int i2) {
        this.a = i2;
    }

    public void b(String str) {
        h(str);
        this.f685e = str;
    }

    public void b(Map<String, Object> map) {
        this.x = map;
    }

    public void b(boolean z) {
        this.A = z;
        if (z) {
            try {
                Class.forName("com.bykv.vk.openvk.TTVfSdk");
            } catch (ClassNotFoundException e2) {
                this.A = false;
                e2.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        return this.B;
    }

    public void c(String str) {
        this.D = str;
    }

    public void c(Map<String, Map<String, String>> map) {
        if (map != null) {
            this.p.putAll(map);
        }
    }

    public void c(boolean z) {
        this.f690j = z;
    }

    public Map<String, String> d() {
        return this.f692l;
    }

    public void d(String str) {
        this.f691k = str;
    }

    public void d(Map<String, Map<String, String>> map) {
        if (map != null) {
            this.q.putAll(map);
        }
    }

    public void d(boolean z) {
        this.f686f = z;
    }

    public long e() {
        long j2;
        long j3 = this.v;
        if (j3 != -1) {
            return j3;
        }
        try {
            c0 R = d.R();
            long a = R.a("first_install_time", -1L);
            if (a == -1) {
                long currentTimeMillis = System.currentTimeMillis();
                R.b("first_install_time", currentTimeMillis);
                this.v = currentTimeMillis;
                j2 = currentTimeMillis;
            } else {
                this.v = a;
                j2 = a;
            }
            return j2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public void e(String str) {
        this.f693m = str;
    }

    public void e(Map<String, String> map) {
        if (this.f692l == null) {
            this.f692l = new HashMap();
        }
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f692l.putAll(map);
    }

    public void e(boolean z) {
        this.f687g = z;
    }

    public GMConfigUserInfoForSegment f() {
        return this.t;
    }

    public void f(String str) {
        this.f689i = str;
    }

    public void f(boolean z) {
        this.f688h = z;
    }

    public Map<String, Object> g() {
        this.r.put("gm_usb", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.a());
        return this.r;
    }

    public void g(boolean z) {
        this.b = z;
    }

    public Map<String, Object> h() {
        return this.x;
    }

    public void h(boolean z) {
        this.E = z;
    }

    public String i() {
        return this.f685e;
    }

    public void i(boolean z) {
        this.F = z;
    }

    public String j() {
        return this.D;
    }

    public void j(boolean z) {
        this.C = z;
    }

    public String k() {
        return this.f691k;
    }

    public String l() {
        return this.f693m;
    }

    public String[] m() {
        return this.f683c;
    }

    public int n() {
        return this.u;
    }

    public int o() {
        return this.a;
    }

    public int[] p() {
        return this.G;
    }

    public String q() {
        if (("com.header.app.untext".equals(a.d().getPackageName()) && "5001121".equals(this.f684d)) || ("com.bytedance.mediation_demo".equals(a.d().getPackageName()) && "5001121".equals(this.f684d))) {
            try {
                return c0.a("tt_mediation_ppe_info", a.d()).d("tt_ppe_content");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public List<String> r() {
        return this.y;
    }

    public GMPrivacyConfig s() {
        return this.w;
    }

    public String t() {
        return this.f689i;
    }

    @Deprecated
    public UserInfoForSegment u() {
        return this.s;
    }

    public boolean v() {
        return ("com.header.app.untext".equals(a.d().getPackageName()) && "5001121".equals(this.f684d)) || ("com.bytedance.mediation_demo".equals(a.d().getPackageName()) && "5001121".equals(this.f684d)) || ("com.msdk.qa.monkey".equals(a.d().getPackageName()) && "5001121".equals(this.f684d));
    }

    public boolean w() {
        String a = l0.a();
        return "com.header.app.untext".equals(a) || "com.bytedance.mediation_demo".equals(a) || "com.msdk.qa.monkey".equals(a);
    }

    public boolean x() {
        return this.z;
    }

    public boolean y() {
        return this.f690j;
    }

    public boolean z() {
        return this.A;
    }
}
