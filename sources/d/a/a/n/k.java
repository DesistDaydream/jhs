package d.a.a.n;

import android.content.SharedPreferences;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k extends a<JSONObject> {
    public k(Future<SharedPreferences> future) {
        super(future, "superProperties");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [org.json.JSONObject, T] */
    @Override // d.a.a.n.a
    public void c(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(this.b, null);
        if (string == null) {
            d(a());
            return;
        }
        try {
            this.a = new JSONObject(string);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.a.a.n.a
    /* renamed from: g */
    public JSONObject a() {
        return new JSONObject();
    }

    @Override // d.a.a.n.a
    /* renamed from: h */
    public void b(SharedPreferences.Editor editor, JSONObject jSONObject) {
        editor.putString(this.b, jSONObject == null ? null : jSONObject.toString());
        editor.apply();
    }
}
