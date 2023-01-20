package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a {
    private b a;
    private byte b;

    /* renamed from: c  reason: collision with root package name */
    private byte f1125c;

    /* renamed from: d  reason: collision with root package name */
    private long f1126d;

    /* renamed from: e  reason: collision with root package name */
    private long f1127e;

    /* renamed from: f  reason: collision with root package name */
    private String f1128f;

    /* renamed from: g  reason: collision with root package name */
    private String f1129g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f1130h;

    /* renamed from: i  reason: collision with root package name */
    private byte f1131i;

    /* renamed from: j  reason: collision with root package name */
    private String f1132j;

    public a(String str, b bVar) {
        this.f1129g = str;
        this.a = bVar;
    }

    public a(String str, JSONObject jSONObject) {
        this.f1129g = str;
        this.f1130h = jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public long a() {
        return this.f1126d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public void a(byte b) {
        this.b = b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public void a(long j2) {
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public byte b() {
        return this.b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public void b(byte b) {
        this.f1125c = b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public void b(long j2) {
        this.f1127e = j2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public byte c() {
        return this.f1131i;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public void c(long j2) {
        this.f1126d = j2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public JSONObject d() {
        JSONObject jSONObject;
        b bVar;
        synchronized (this) {
            if (this.f1130h == null && (bVar = this.a) != null) {
                this.f1130h = bVar.a(k());
            }
            jSONObject = this.f1130h;
        }
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public byte e() {
        return this.f1125c;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public String f() {
        if (TextUtils.isEmpty(this.f1129g)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.f1129g);
            jSONObject.put("event", d());
            jSONObject.put("genTime", j());
            jSONObject.put(RemoteMessageConst.Notification.PRIORITY, (int) this.f1125c);
            jSONObject.put("type", (int) this.b);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public b g() {
        return this.a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public long h() {
        return this.f1127e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public String i() {
        return this.f1129g;
    }

    public String j() {
        return this.f1128f;
    }

    public String k() {
        return this.f1132j;
    }
}
