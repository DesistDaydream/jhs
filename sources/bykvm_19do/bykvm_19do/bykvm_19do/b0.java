package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b0 extends u {

    /* renamed from: i  reason: collision with root package name */
    public long f75i;

    /* renamed from: j  reason: collision with root package name */
    public String f76j;

    /* renamed from: k  reason: collision with root package name */
    public String f77k;

    /* renamed from: l  reason: collision with root package name */
    public int f78l;

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.f77k);
        jSONObject.put("refer_page_key", this.f76j);
        jSONObject.put("is_back", this.f78l);
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f166c = cursor.getString(2);
        this.f167d = cursor.getString(3);
        this.f77k = cursor.getString(4);
        this.f76j = cursor.getString(5);
        this.f75i = cursor.getLong(6);
        this.f78l = cursor.getInt(7);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f166c);
        contentValues.put("user_unique_id", this.f167d);
        contentValues.put("page_key", this.f77k);
        contentValues.put("refer_page_key", this.f76j);
        contentValues.put("duration", Long.valueOf(this.f75i));
        contentValues.put("is_back", Integer.valueOf(this.f78l));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(JSONObject jSONObject) {
        jSONObject.put("page_key", this.f77k);
        jSONObject.put("refer_page_key", this.f76j);
        jSONObject.put("duration", this.f75i);
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("session_id", this.f166c);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("is_back", this.f78l);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f166c = jSONObject.optString("session_id", null);
        this.f77k = jSONObject.optString("page_key", null);
        this.f76j = jSONObject.optString("refer_page_key", null);
        this.f75i = jSONObject.optLong("duration", 0L);
        this.f78l = jSONObject.optInt("is_back", 0);
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
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", l());
        jSONObject.put("datetime", this.f170g);
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String d() {
        return "page";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String h() {
        return super.h() + " name:" + this.f77k + " duration:" + this.f75i;
    }

    public boolean j() {
        return this.f75i == -1;
    }

    public boolean k() {
        return this.f77k.contains(Constants.COLON_SEPARATOR);
    }
}
