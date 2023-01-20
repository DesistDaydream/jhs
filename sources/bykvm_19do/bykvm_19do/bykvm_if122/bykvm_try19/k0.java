package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.msdk.adapter.util.Logger;

/* loaded from: classes.dex */
public class k0 {
    private static String a;

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            a = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return a;
    }

    public static String a(String str) {
        try {
            if (b()) {
                String a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a();
                if (TextUtils.isEmpty(a2)) {
                    return str;
                }
                Log.d("TestHelperUtils", "AnyDoorId=" + a2);
                return Uri.parse(str).buildUpon().appendQueryParameter(a(), a2).appendQueryParameter("aid", "5001121").toString();
            }
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean b() {
        return Logger.isDebug() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().v() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().w();
    }
}
