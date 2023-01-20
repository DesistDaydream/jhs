package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a0 extends u {

    /* renamed from: i  reason: collision with root package name */
    public byte[] f67i;

    /* renamed from: j  reason: collision with root package name */
    public int f68j;

    /* renamed from: k  reason: collision with root package name */
    public int f69k;

    /* renamed from: l  reason: collision with root package name */
    private JSONArray f70l;

    /* renamed from: m  reason: collision with root package name */
    private JSONArray f71m;
    private z n;
    private JSONArray o;
    private d0 p;
    private JSONObject q;
    private JSONArray r;

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.f67i = cursor.getBlob(1);
        this.f68j = cursor.getInt(2);
        this.q = null;
        this.n = null;
        this.p = null;
        this.o = null;
        this.f70l = null;
        this.f71m = null;
        this.r = null;
        return this;
    }

    public void a(long j2, JSONObject jSONObject, z zVar, d0 d0Var, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
        this.a = j2;
        this.q = jSONObject;
        this.n = zVar;
        this.p = d0Var;
        this.o = null;
        this.f70l = jSONArray2;
        this.f71m = jSONArray3;
        this.r = jSONArray4;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("_data", a.a(f().toString()));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(JSONObject jSONObject) {
        l0.a(null);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String[] a() {
        return new String[]{"local_time_ms", "integer", "_data", "blob", "_fail", "integer", "_full", "integer"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u b(JSONObject jSONObject) {
        l0.a(null);
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.q);
        jSONObject.put("time_sync", s.b);
        if (this.n != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.n.f());
            jSONObject.put("launch", jSONArray);
        }
        d0 d0Var = this.p;
        if (d0Var != null) {
            JSONObject f2 = d0Var.f();
            JSONArray jSONArray2 = this.o;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            for (int i2 = 0; i2 < length; i2++) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(new JSONObject(this.o.optString(i2)).optString("params"));
                jSONArray4.put(0, jSONObject2.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject2.optInt("duration", 0) + 999) / 1000);
                jSONArray3.put(jSONArray4);
            }
            if (length > 0) {
                f2.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(f2);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.f70l;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put("event", this.f70l);
        }
        JSONArray jSONArray7 = this.o;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        if (this.f71m == null) {
            this.f71m = this.o;
        } else if (length3 > 0) {
            for (int i3 = 0; i3 < length3; i3++) {
                this.f71m.put(this.o.get(i3));
            }
        }
        JSONArray jSONArray8 = this.f71m;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.f71m);
        }
        JSONArray jSONArray9 = this.r;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.r);
        }
        StringBuilder sb = new StringBuilder("wP {");
        Object obj = this.n;
        if (obj == null) {
            obj = "la";
        }
        sb.append(obj);
        sb.append(", ");
        Object obj2 = this.p;
        if (obj2 == null) {
            obj2 = "te";
        }
        sb.append(obj2);
        sb.append(", p: ");
        sb.append(length3);
        sb.append(", v1: ");
        sb.append(length2);
        sb.append(", v3: ");
        sb.append(length4);
        sb.append("}");
        sb.append(", m: ");
        sb.append(length5);
        sb.append("}");
        l0.d(sb.toString(), null);
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String d() {
        return "pack";
    }
}
