package d.a.a;

import cn.thinkingdata.android.TDPresetProperties;
import cn.thinkingdata.android.ThinkingAnalyticsSDK;
import d.a.a.o.e;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public String a;
    private final e b;

    /* renamed from: c  reason: collision with root package name */
    public final cn.thinkingdata.android.utils.l f9269c;

    /* renamed from: d  reason: collision with root package name */
    private String f9270d;

    /* renamed from: e  reason: collision with root package name */
    private String f9271e;

    /* renamed from: f  reason: collision with root package name */
    private final JSONObject f9272f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f9273g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9274h = true;

    /* renamed from: i  reason: collision with root package name */
    public final String f9275i;

    public a(ThinkingAnalyticsSDK thinkingAnalyticsSDK, cn.thinkingdata.android.utils.l lVar, JSONObject jSONObject, e eVar) {
        this.f9269c = lVar;
        this.f9272f = jSONObject;
        this.b = eVar;
        this.f9275i = thinkingAnalyticsSDK.getToken();
        this.f9270d = thinkingAnalyticsSDK.getDistinctId();
        this.f9271e = thinkingAnalyticsSDK.getLoginId();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("#type", this.f9269c.a());
            jSONObject.put("#time", this.b.b());
            jSONObject.put("#distinct_id", this.f9270d);
            String str = this.f9271e;
            if (str != null) {
                jSONObject.put("#account_id", str);
            }
            Map<String, String> map = this.f9273g;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            if (this.f9269c.b()) {
                jSONObject.put("#event_name", this.a);
                Double a = this.b.a();
                if (a != null && !TDPresetProperties.disableList.contains("#zone_offset")) {
                    this.f9272f.put("#zone_offset", a);
                }
            }
            jSONObject.put("properties", this.f9272f);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void b(Map<String, String> map) {
        this.f9273g = map;
    }

    public void c() {
        this.f9274h = false;
    }
}
