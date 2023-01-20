package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l extends e2 {

    /* renamed from: e  reason: collision with root package name */
    private final Context f147e;

    public l(Context context) {
        super(false, false);
        this.f147e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        String str;
        try {
            str = Settings.Secure.getString(this.f147e.getContentResolver(), "android_id");
        } catch (Exception e2) {
            l0.c("", e2);
            str = null;
        }
        if (!k2.a(str) || "9774d56d682e549c".equals(str)) {
            SharedPreferences sharedPreferences = this.f147e.getSharedPreferences("snssdk_openudid", 0);
            String string = sharedPreferences.getString("openudid", null);
            if (!k2.a(string)) {
                string = new BigInteger(64, new SecureRandom()).toString(16);
                if (string.charAt(0) == '-') {
                    string = string.substring(1);
                }
                int length = 13 - string.length();
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (length > 0) {
                        sb.append('F');
                        length--;
                    }
                    sb.append(string);
                    string = sb.toString();
                }
                try {
                    string = a("openudid.dat", string);
                } catch (Exception unused) {
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("openudid", string);
                edit.apply();
            }
            str = string;
        }
        jSONObject.put("openudid", str);
        return true;
    }
}
