package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuicore.TUIConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c0 extends u {
    public static String o = "succEvent";

    /* renamed from: i  reason: collision with root package name */
    private String f90i;

    /* renamed from: j  reason: collision with root package name */
    private int f91j;

    /* renamed from: k  reason: collision with root package name */
    public int f92k;

    /* renamed from: l  reason: collision with root package name */
    private String f93l;

    /* renamed from: m  reason: collision with root package name */
    private int f94m;
    private long n;

    public c0() {
    }

    public c0(String str, String str2, int i2) {
        this.f91j = 1;
        this.f92k = a.l();
        this.f90i = str;
        this.f93l = str2;
        this.f94m = i2;
        this.n = k0.a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f166c = cursor.getString(2);
        this.f167d = cursor.getString(3);
        this.f90i = cursor.getString(4);
        this.f91j = cursor.getInt(5);
        this.f92k = cursor.getInt(6);
        this.f93l = cursor.getString(7);
        this.f94m = cursor.getInt(8);
        this.n = cursor.getLong(9);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f166c);
        contentValues.put("user_unique_id", this.f167d);
        contentValues.put(TUIConstants.TUICalling.EVENT_KEY_NAME, this.f90i);
        contentValues.put("is_monitor", Integer.valueOf(this.f91j));
        contentValues.put("bav_monitor_rate", Integer.valueOf(this.f92k));
        contentValues.put("monitor_status", this.f93l);
        contentValues.put("monitor_num", Integer.valueOf(this.f94m));
        contentValues.put(MessageKey.MSG_DATE, Long.valueOf(this.n));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public void a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f166c);
        jSONObject.put("user_unique_id", this.f167d);
        jSONObject.put(TUIConstants.TUICalling.EVENT_KEY_NAME, this.f90i);
        jSONObject.put("is_monitor", this.f91j);
        jSONObject.put("bav_monitor_rate", this.f92k);
        jSONObject.put("monitor_status", this.f93l);
        jSONObject.put("monitor_num", this.f94m);
        jSONObject.put(MessageKey.MSG_DATE, this.n);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", TUIConstants.TUICalling.EVENT_KEY_NAME, "varchar", "is_monitor", "integer", "bav_monitor_rate", "integer", "monitor_status", "varchar", "monitor_num", "integer", MessageKey.MSG_DATE, "integer"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f166c = jSONObject.optString("session_id", null);
        this.f167d = jSONObject.optString("user_unique_id", null);
        this.f90i = jSONObject.optString(TUIConstants.TUICalling.EVENT_KEY_NAME, null);
        this.f91j = jSONObject.optInt("is_monitor", 0);
        this.f92k = jSONObject.optInt("bav_monitor_rate", 0);
        this.f93l = jSONObject.optString("monitor_status", null);
        this.f94m = jSONObject.optInt("monitor_num", 0);
        this.n = jSONObject.optLong(MessageKey.MSG_DATE, 0L);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TUIConstants.TUICalling.EVENT_KEY_NAME, this.f90i);
        jSONObject.put("is_monitor", this.f91j);
        jSONObject.put("bav_monitor_rate", this.f92k);
        jSONObject.put("monitor_status", this.f93l);
        jSONObject.put("monitor_num", this.f94m);
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public String d() {
        return o;
    }
}
