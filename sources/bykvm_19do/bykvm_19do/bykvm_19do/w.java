package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class w extends u {

    /* renamed from: i  reason: collision with root package name */
    private String f186i;

    /* renamed from: j  reason: collision with root package name */
    private String f187j;

    /* renamed from: k  reason: collision with root package name */
    private String f188k;

    /* renamed from: l  reason: collision with root package name */
    private String f189l;

    /* renamed from: m  reason: collision with root package name */
    private long f190m;
    private long n;

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f166c = cursor.getString(2);
        this.f167d = cursor.getString(3);
        this.f186i = cursor.getString(4);
        this.f187j = cursor.getString(5);
        this.f190m = cursor.getInt(6);
        this.n = cursor.getInt(7);
        this.f189l = cursor.getString(8);
        this.f188k = cursor.getString(9);
        this.f168e = cursor.getString(10);
        this.f169f = cursor.getString(11);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f166c);
        contentValues.put("user_unique_id", this.f167d);
        contentValues.put("category", this.f186i);
        contentValues.put(RemoteMessageConst.Notification.TAG, this.f187j);
        contentValues.put("value", Long.valueOf(this.f190m));
        contentValues.put("ext_value", Long.valueOf(this.n));
        contentValues.put("params", this.f189l);
        contentValues.put(TTDownloadField.TT_LABEL, this.f188k);
        contentValues.put("ab_version", this.f168e);
        contentValues.put("ab_sdk_version", this.f169f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f166c);
        jSONObject.put("user_unique_id", this.f167d);
        jSONObject.put("category", this.f186i);
        jSONObject.put(RemoteMessageConst.Notification.TAG, this.f187j);
        jSONObject.put("value", this.f190m);
        jSONObject.put("ext_value", this.n);
        jSONObject.put("params", this.f189l);
        jSONObject.put(TTDownloadField.TT_LABEL, this.f188k);
        jSONObject.put("ab_version", this.f168e);
        jSONObject.put("ab_sdk_version", this.f169f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "category", "varchar", RemoteMessageConst.Notification.TAG, "varchar", "value", "integer", "ext_value", "integer", "params", "varchar", TTDownloadField.TT_LABEL, "varchar", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f166c = jSONObject.optString("session_id", null);
        this.f167d = jSONObject.optString("user_unique_id", null);
        this.f186i = jSONObject.optString("category", null);
        this.f187j = jSONObject.optString(RemoteMessageConst.Notification.TAG, null);
        this.f190m = jSONObject.optLong("value", 0L);
        this.n = jSONObject.optLong("ext_value", 0L);
        this.f189l = jSONObject.optString("params", null);
        this.f188k = jSONObject.optString(TTDownloadField.TT_LABEL, null);
        this.f168e = jSONObject.optString("ab_version", null);
        this.f169f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public JSONObject b() {
        JSONObject jSONObject = !TextUtils.isEmpty(this.f189l) ? new JSONObject(this.f189l) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f166c);
        if (!TextUtils.isEmpty(this.f167d)) {
            jSONObject.put("user_unique_id", this.f167d);
        }
        jSONObject.put("category", this.f186i);
        jSONObject.put(RemoteMessageConst.Notification.TAG, this.f187j);
        jSONObject.put("value", this.f190m);
        jSONObject.put("ext_value", this.n);
        jSONObject.put(TTDownloadField.TT_LABEL, this.f188k);
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
        return "event";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String h() {
        return "" + this.f187j + ", " + this.f188k;
    }

    public String j() {
        return this.f187j;
    }

    public String k() {
        return this.f188k;
    }
}
