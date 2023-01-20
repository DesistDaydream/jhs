package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {
    public static JSONObject a() {
        Map<String, ITTAdapterConfiguration> e2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
        if (e2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ITTAdapterConfiguration> entry : e2.entrySet()) {
            if (entry.getKey() != null) {
                String[] split = entry.getKey().split("\\.");
                if (split.length >= 5) {
                    String str = split[4];
                    try {
                        jSONObject.put(str + "Adapter", entry.getValue().getAdapterVersion());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }
}
