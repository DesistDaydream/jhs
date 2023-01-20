package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d0 extends u {

    /* renamed from: i  reason: collision with root package name */
    public long f101i;

    /* renamed from: j  reason: collision with root package name */
    public long f102j;

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        l0.a(null);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(ContentValues contentValues) {
        l0.a(null);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(JSONObject jSONObject) {
        l0.a(null);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String[] a() {
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u b(JSONObject jSONObject) {
        l0.a(null);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f166c);
        jSONObject.put("stop_timestamp", this.f102j);
        jSONObject.put("duration", this.f101i / 1000);
        jSONObject.put("datetime", this.f170g);
        if (!TextUtils.isEmpty(this.f168e)) {
            jSONObject.put("ab_version", this.f168e);
        }
        if (!TextUtils.isEmpty(this.f169f)) {
            jSONObject.put("ab_sdk_version", this.f169f);
        }
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String d() {
        return "terminate";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String h() {
        return super.h() + " duration:" + this.f101i;
    }
}
