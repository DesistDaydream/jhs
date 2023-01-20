package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122;

import com.bytedance.msdk.api.reward.RewardItem;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f814c;

    /* renamed from: d  reason: collision with root package name */
    private String f815d;

    /* renamed from: e  reason: collision with root package name */
    private int f816e;

    /* renamed from: f  reason: collision with root package name */
    private int f817f;

    /* renamed from: g  reason: collision with root package name */
    private int f818g;

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(RewardItem.KEY_REASON, this.a);
            jSONObject.put("fill_error_code", this.b);
            jSONObject.put("fill_error_msg", this.f814c);
            jSONObject.put("mediation_rit", this.f815d);
            jSONObject.put("load_sort", this.f816e);
            jSONObject.put("show_sort", this.f817f);
            jSONObject.put("has_shown", this.f818g);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "{\"name\": \"json err\"}";
        }
    }

    public void a(int i2) {
        this.b = i2;
    }

    public void a(String str) {
        this.f814c = str;
    }

    public void b(int i2) {
        this.f818g = i2;
    }

    public void b(String str) {
        this.f815d = str;
    }

    public void c(int i2) {
        this.f816e = i2;
    }

    public void d(int i2) {
        this.a = i2;
    }

    public void e(int i2) {
        this.f817f = i2;
    }
}
