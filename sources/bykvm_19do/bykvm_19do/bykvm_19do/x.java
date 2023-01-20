package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class x extends u {

    /* renamed from: i  reason: collision with root package name */
    private String f192i;

    /* renamed from: j  reason: collision with root package name */
    private String f193j;

    public x(String str, JSONObject jSONObject) {
        this.f193j = str;
        this.f192i = jSONObject.toString();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f166c = cursor.getString(2);
        this.f167d = cursor.getString(3);
        this.f192i = cursor.getString(4);
        this.f193j = cursor.getString(5);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f166c);
        contentValues.put("user_unique_id", this.f167d);
        contentValues.put("params", this.f192i);
        contentValues.put("log_type", this.f193j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f166c);
        jSONObject.put("user_unique_id", this.f167d);
        jSONObject.put("params", this.f192i);
        jSONObject.put("log_type", this.f193j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "params", "varchar", "log_type", "varchar"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f166c = jSONObject.optString("session_id", null);
        this.f167d = jSONObject.optString("user_unique_id", null);
        this.f192i = jSONObject.optString("params", null);
        this.f193j = jSONObject.optString("log_type", null);
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
        jSONObject.put("log_type", this.f193j);
        try {
            JSONObject jSONObject2 = new JSONObject(this.f192i);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    l0.b("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e2) {
            l0.c("解析 event misc 失败", e2);
        }
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String d() {
        return "event_misc";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String h() {
        return "param:" + this.f192i + " logType:" + this.f193j;
    }
}
