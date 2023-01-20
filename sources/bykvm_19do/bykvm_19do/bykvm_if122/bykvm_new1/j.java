package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class j implements h {
    private Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c> b = new HashMap();
    private c0 a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.S();

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.h
    public void a(Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c> map) {
        String b;
        JSONArray jSONArray = new JSONArray();
        this.b.clear();
        for (Map.Entry<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c> entry : map.entrySet()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c value = entry.getValue();
            if (value != null && value.s() == 3 && value.r() != null) {
                this.b.put(value.q(), value);
                jSONArray.put(value.r());
            }
        }
        if (jSONArray.length() <= 0 || (b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(jSONArray.toString(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a())) == null || TextUtils.isEmpty(b)) {
            return;
        }
        this.a.b("splash_config", b);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.h
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c c(String str) {
        String a;
        if (!TextUtils.isEmpty(str)) {
            Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c> map = this.b;
            if (map != null && map.get(str) != null) {
                return this.b.get(str);
            }
            c0 c0Var = this.a;
            if (c0Var != null && (a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(c0Var.d("splash_config"), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a())) != null && !TextUtils.isEmpty(a)) {
                this.b.clear();
                try {
                    JSONArray jSONArray = new JSONArray(a);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c.b(jSONArray.getJSONObject(i2));
                        if (b != null) {
                            this.b.put(b.q(), b);
                        }
                    }
                    return this.b.get(str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }
}
