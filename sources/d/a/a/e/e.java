package d.a.a.e;

import android.text.TextUtils;
import cn.thinkingdata.android.TDConfig;
import cn.thinkingdata.android.encrypt.TDSecreteKey;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, e> f9286d = new HashMap();
    private a a;
    private final List<a> b;

    /* renamed from: c  reason: collision with root package name */
    private final TDConfig f9287c;

    private e(TDConfig tDConfig) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.f9287c = tDConfig;
        arrayList.add(new d());
    }

    public static e b(String str) {
        e eVar;
        Map<String, e> map = f9286d;
        synchronized (map) {
            eVar = map.get(str);
        }
        return eVar;
    }

    public static e c(String str, TDConfig tDConfig) {
        e eVar;
        Map<String, e> map = f9286d;
        synchronized (map) {
            eVar = map.get(str);
            if (eVar == null) {
                eVar = new e(tDConfig);
                map.put(str, eVar);
            }
        }
        return eVar;
    }

    private boolean e(a aVar) {
        return TextUtils.isEmpty(aVar.b()) || TextUtils.isEmpty(aVar.a());
    }

    private boolean g(TDSecreteKey tDSecreteKey) {
        return tDSecreteKey == null || TextUtils.isEmpty(tDSecreteKey.publicKey);
    }

    public a a(TDSecreteKey tDSecreteKey) {
        if (g(tDSecreteKey)) {
            return null;
        }
        for (a aVar : this.b) {
            if (aVar != null && f(aVar, tDSecreteKey)) {
                return aVar;
            }
        }
        return null;
    }

    public JSONObject d(JSONObject jSONObject) {
        try {
            TDConfig tDConfig = this.f9287c;
            if (tDConfig == null) {
                return jSONObject;
            }
            TDSecreteKey secreteKey = tDConfig.getSecreteKey();
            if (g(secreteKey)) {
                return jSONObject;
            }
            if (!f(this.a, secreteKey)) {
                this.a = a(secreteKey);
            }
            if (this.a == null) {
                return jSONObject;
            }
            String str = secreteKey.publicKey;
            if (str.startsWith("EC:")) {
                str = str.substring(str.indexOf(Constants.COLON_SEPARATOR) + 1);
            }
            String b = this.a.b(str);
            if (TextUtils.isEmpty(b)) {
                return jSONObject;
            }
            String a = this.a.a(jSONObject.toString());
            if (TextUtils.isEmpty(a)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ekey", b);
            jSONObject2.put("pkv", secreteKey.version);
            jSONObject2.put("payload", a);
            return jSONObject2;
        } catch (Exception unused) {
            return jSONObject;
        }
    }

    public boolean f(a aVar, TDSecreteKey tDSecreteKey) {
        return (aVar == null || g(tDSecreteKey) || e(aVar) || !aVar.b().equals(tDSecreteKey.asymmetricEncryption) || !aVar.a().equals(tDSecreteKey.symmetricEncryption)) ? false : true;
    }
}
