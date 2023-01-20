package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g extends d {

    /* renamed from: g  reason: collision with root package name */
    private List<e> f727g;

    /* renamed from: h  reason: collision with root package name */
    private String f728h;

    /* renamed from: i  reason: collision with root package name */
    private b f729i;

    /* loaded from: classes.dex */
    public class a implements Comparator<e> {
        public a(g gVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(e eVar, e eVar2) {
            int i2 = ((eVar.e() - eVar2.e()) > 0L ? 1 : ((eVar.e() - eVar2.e()) == 0L ? 0 : -1));
            if (i2 == 0) {
                return 0;
            }
            return i2 > 0 ? 1 : -1;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public String a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f730c;

        public b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.f730c = str3;
        }
    }

    public g(String str, String str2, String str3, String str4, int i2, String str5) {
        super(str, str2, str3, str4, i2);
        this.f728h = str5;
        this.f729i = !TextUtils.isEmpty(str2) ? new b("freq", "span", "rule_id") : new b("waterfall_show_freq", "waterfall_show_span", "waterfall_show_rule_id");
    }

    public void a(String str, int i2) {
        for (e eVar : i()) {
            if (TextUtils.equals(eVar.d(), str)) {
                eVar.a(i2);
                return;
            }
        }
    }

    public void a(String str, long j2) {
        for (e eVar : i()) {
            if (TextUtils.equals(eVar.d(), str)) {
                eVar.a(j2);
                return;
            }
        }
    }

    public List<e> i() {
        g h2;
        List<e> list;
        synchronized (this) {
            List<e> list2 = this.f727g;
            if (list2 == null || list2.size() == 0) {
                this.f727g = new ArrayList();
                if (this.f728h == null && (h2 = m.b().h(this.a)) != null) {
                    this.f728h = h2.f728h;
                }
                if (!TextUtils.isEmpty(this.f728h)) {
                    try {
                        JSONArray jSONArray = new JSONArray(this.f728h);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            e eVar = new e();
                            String string = jSONObject.getString(this.f729i.f730c);
                            if (jSONObject != null && !TextUtils.isEmpty(string)) {
                                eVar.b(jSONObject.optInt(this.f729i.a));
                                eVar.b(jSONObject.optLong(this.f729i.b));
                                eVar.a(string);
                                if (jSONObject.has("count")) {
                                    eVar.a(jSONObject.optInt("count"));
                                }
                                if (jSONObject.has("effective_time")) {
                                    eVar.a(jSONObject.optLong("effective_time"));
                                }
                                this.f727g.add(eVar);
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    if (this.f727g.size() > 0) {
                        Collections.sort(this.f727g, new a(this));
                    }
                }
            }
            list = this.f727g;
        }
        return list;
    }

    public String j() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (e eVar : i()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(this.f729i.a, eVar.c());
                jSONObject.put(this.f729i.b, eVar.e());
                jSONObject.put(this.f729i.f730c, eVar.d());
                jSONObject.put("count", eVar.a());
                jSONObject.put("effective_time", eVar.b());
                jSONArray.put(jSONObject);
            }
            this.f728h = jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.f728h;
    }

    public String k() {
        try {
            JSONArray jSONArray = new JSONArray(this.f728h);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                jSONObject.put("count", 0);
                jSONObject.put("effective_time", f.a(jSONObject.getLong(this.f729i.b)));
            }
            this.f728h = jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.f728h;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.a + "', showRulesVersion='" + this.f720c + "', timingMode=" + this.f722e + "}IntervalFreqctlBean{freqctlRules=" + this.f727g + ", freqctlRulesJson='" + this.f728h + "'}";
    }
}
