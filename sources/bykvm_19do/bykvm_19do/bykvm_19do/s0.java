package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class s0 {
    private static String a = null;
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static final String f161c = s0.class.getSimpleName() + MqttTopic.MULTI_LEVEL_WILDCARD;

    /* renamed from: d  reason: collision with root package name */
    private static o0<z0> f162d = new a();

    /* loaded from: classes.dex */
    public static final class a extends o0<z0> {
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.o0
        /* renamed from: c */
        public z0 a(Object... objArr) {
            if (objArr.length == 0) {
                return null;
            }
            return new z0((Context) objArr[0]);
        }
    }

    public static String a() {
        return a;
    }

    public static String a(SharedPreferences sharedPreferences) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String a2 = q0.a(sharedPreferences);
        t0.b("TrackerDr", f161c + "getCdid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return a2;
    }

    public static String a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static Map<String, String> a(Context context, SharedPreferences sharedPreferences) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, String> a2 = f162d.b(context).a(100L);
        t0.b("TrackerDr", f161c + "getOaid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return a2;
    }

    public static void a(Context context) {
        f162d.b(context).a(false);
    }

    public static void a(e eVar) {
        z0.a(eVar);
    }

    public static void a(String str) {
        a = str;
    }

    public static void a(boolean z) {
        b = z;
    }

    public static boolean b() {
        return b;
    }
}
