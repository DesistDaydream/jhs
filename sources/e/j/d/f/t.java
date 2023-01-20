package e.j.d.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class t {

    /* renamed from: d  reason: collision with root package name */
    private static final long f11256d = TimeUnit.DAYS.toMillis(7);
    public final String a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final long f11257c;

    private t(String str, String str2, long j2) {
        this.a = str;
        this.b = str2;
        this.f11257c = j2;
    }

    public static t a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("{")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new t(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                sb.append("Failed to parse token: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                return null;
            }
        }
        return new t(str, null, 0L);
    }

    public static String b(@Nullable t tVar) {
        if (tVar == null) {
            return null;
        }
        return tVar.a;
    }

    public static String c(String str, String str2, long j2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
            sb.append("Failed to encode token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    public final boolean d(String str) {
        return System.currentTimeMillis() > this.f11257c + f11256d || !str.equals(this.b);
    }
}
