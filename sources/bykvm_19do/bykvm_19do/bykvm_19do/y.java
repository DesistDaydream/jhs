package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class y extends u {

    /* renamed from: i  reason: collision with root package name */
    public String f195i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f196j;

    /* renamed from: k  reason: collision with root package name */
    private String f197k;

    public y(String str, boolean z, String str2) {
        this.f197k = str;
        this.f196j = z;
        this.f195i = str2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f166c = cursor.getString(2);
        this.f167d = cursor.getString(3);
        this.f197k = cursor.getString(4);
        this.f195i = cursor.getString(5);
        this.f196j = cursor.getInt(6) == 1;
        this.f168e = cursor.getString(7);
        this.f169f = cursor.getString(8);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f166c);
        contentValues.put("user_unique_id", this.f167d);
        contentValues.put("event", this.f197k);
        if (this.f196j && this.f195i == null) {
            try {
                j();
            } catch (JSONException e2) {
                l0.a(e2);
            }
        }
        contentValues.put("params", this.f195i);
        contentValues.put("is_bav", Integer.valueOf(this.f196j ? 1 : 0));
        contentValues.put("ab_version", this.f168e);
        contentValues.put("ab_sdk_version", this.f169f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f166c);
        jSONObject.put("user_unique_id", this.f167d);
        jSONObject.put("event", this.f197k);
        if (this.f196j && this.f195i == null) {
            j();
        }
        jSONObject.put("params", this.f195i);
        jSONObject.put("is_bav", this.f196j);
        jSONObject.put("ab_version", this.f168e);
        jSONObject.put("ab_sdk_version", this.f169f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "event", "varchar", "params", "varchar", "is_bav", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f166c = jSONObject.optString("session_id", null);
        this.f167d = jSONObject.optString("user_unique_id", null);
        this.f197k = jSONObject.optString("event", null);
        this.f195i = jSONObject.optString("params", null);
        this.f196j = jSONObject.optBoolean("is_bav", false);
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
        if (!TextUtils.isEmpty(this.f167d)) {
            jSONObject.put("user_unique_id", this.f167d);
        }
        jSONObject.put("event", this.f197k);
        if (this.f196j) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.f195i)) {
            jSONObject.put("params", new JSONObject(this.f195i));
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
        return "eventv3";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String h() {
        return this.f197k;
    }

    public void j() {
    }

    public String k() {
        return this.f197k;
    }
}
