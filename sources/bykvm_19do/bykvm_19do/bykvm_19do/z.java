package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class z extends u {

    /* renamed from: i  reason: collision with root package name */
    public int f200i;

    /* renamed from: j  reason: collision with root package name */
    public String f201j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f202k;

    /* renamed from: l  reason: collision with root package name */
    public volatile boolean f203l;

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f166c = cursor.getString(2);
        this.f201j = cursor.getString(3);
        this.f200i = cursor.getInt(4);
        this.f168e = cursor.getString(5);
        this.f169f = cursor.getString(6);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f166c);
        contentValues.put("ver_name", this.f201j);
        contentValues.put("ver_code", Integer.valueOf(this.f200i));
        contentValues.put("ab_version", this.f168e);
        contentValues.put("ab_sdk_version", this.f169f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f166c);
        jSONObject.put("ab_version", this.f168e);
        jSONObject.put("ab_sdk_version", this.f169f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "ver_name", "varchar", "ver_code", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f166c = jSONObject.optString("session_id", null);
        this.f168e = jSONObject.optString("ab_version", null);
        this.f169f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f166c);
        boolean z = this.f202k;
        if (z) {
            jSONObject.put("is_background", z);
        }
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
        return "launch";
    }
}
