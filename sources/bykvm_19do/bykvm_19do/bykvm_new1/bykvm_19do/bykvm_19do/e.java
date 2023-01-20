package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.m;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {
    public static String a(Context context, int i2) {
        ActivityManager.ProcessErrorStateInfo a = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.a(context, i2);
        if (a == null || Process.myPid() != a.pid) {
            return null;
        }
        return b.a(a);
    }

    public static JSONObject a(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", m.a(stackTrace));
        return jSONObject;
    }
}
