package bykvm_19do.bykvm_19do.bykvm_19do;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qiniu.android.collect.ReportItem;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c1 {
    public final String a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f95c;

    /* renamed from: d  reason: collision with root package name */
    public final Long f96d;

    /* renamed from: e  reason: collision with root package name */
    public final Long f97e;

    /* renamed from: f  reason: collision with root package name */
    public final Integer f98f;

    /* renamed from: g  reason: collision with root package name */
    public final Long f99g;

    public c1(String str, String str2, Boolean bool, Long l2, Long l3, Integer num, Long l4) {
        this.a = str;
        this.b = str2;
        this.f95c = bool;
        this.f96d = l2;
        this.f97e = l3;
        this.f98f = num;
        this.f99g = l4;
    }

    @Nullable
    @AnyThread
    public static c1 a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new c1(jSONObject.optString("id", null), jSONObject.optString(ReportItem.RequestKeyRequestId, null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @NonNull
    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        z0.a(hashMap, "id", this.a);
        z0.a(hashMap, ReportItem.RequestKeyRequestId, this.b);
        z0.a(hashMap, "is_track_limited", String.valueOf(this.f95c));
        z0.a(hashMap, "take_ms", String.valueOf(this.f96d));
        z0.a(hashMap, "time", String.valueOf(this.f97e));
        z0.a(hashMap, "query_times", String.valueOf(this.f98f));
        z0.a(hashMap, "hw_id_version_code", String.valueOf(this.f99g));
        return hashMap;
    }

    @NonNull
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        z0.a(jSONObject, "id", this.a);
        z0.a(jSONObject, ReportItem.RequestKeyRequestId, this.b);
        z0.a(jSONObject, "is_track_limited", this.f95c);
        z0.a(jSONObject, "take_ms", this.f96d);
        z0.a(jSONObject, "time", this.f97e);
        z0.a(jSONObject, "query_times", this.f98f);
        z0.a(jSONObject, "hw_id_version_code", this.f99g);
        return jSONObject;
    }

    public String toString() {
        return b().toString();
    }
}
