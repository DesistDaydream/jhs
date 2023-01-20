package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;
import java.security.SecureRandom;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l0 {
    private static String a = null;
    private static String b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f1017c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f1018d = "ToolUtils";

    public static String a() {
        String str;
        synchronized (l0.class) {
            if (TextUtils.isEmpty(a) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() != null) {
                a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d().getPackageName();
            }
            str = a;
        }
        return str;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return a.a(str.substring(17), b(str.substring(1, 17)));
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                try {
                    String a2 = a.a();
                    String str = 2 + a2 + a.b(jSONObject.toString(), a.a(a2));
                    if (TextUtils.isEmpty(str)) {
                        jSONObject2.put("message", jSONObject.toString());
                        jSONObject2.put("cypher", 0);
                    } else {
                        jSONObject2.put("message", str);
                        jSONObject2.put("cypher", 2);
                    }
                } catch (Throwable unused) {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused2) {
            }
        }
        return jSONObject2;
    }

    public static String b() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return n.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String b(String str) {
        String a2 = a.a(str);
        if (str == null) {
            String a3 = b.a();
            return a3.concat(a3).substring(8, 24);
        }
        return a2;
    }

    public static String c() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Exception unused) {
            str = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(";");
        if (lastIndexOf != -1 && str.length() > lastIndexOf) {
            int i2 = lastIndexOf + 1;
            String substring = str.substring(0, i2);
            String substring2 = str.substring(i2);
            str = substring.concat(ExpandableTextView.N + Locale.getDefault().getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Locale.getDefault().getCountry() + ";").concat(substring2);
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String d() {
        String str;
        synchronized (l0.class) {
            if (TextUtils.isEmpty(b) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() != null) {
                PackageInfo packageInfo = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d().getPackageManager().getPackageInfo(a(), 0);
                b = String.valueOf(packageInfo.versionCode);
                f1017c = packageInfo.versionName;
            }
            str = b;
        }
        return str;
    }

    public static String e() {
        String str;
        synchronized (l0.class) {
            if (TextUtils.isEmpty(f1017c) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() != null) {
                PackageInfo packageInfo = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d().getPackageManager().getPackageInfo(a(), 0);
                b = String.valueOf(packageInfo.versionCode);
                f1017c = packageInfo.versionName;
            }
            str = f1017c;
        }
        return str;
    }
}
