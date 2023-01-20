package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class j {
    private SharedPreferences a;

    public j(Context context) {
        this.a = context.getSharedPreferences("npth", 0);
    }

    public String a() {
        String c2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i.e().c();
        return (TextUtils.isEmpty(c2) || "0".equals(c2)) ? this.a.getString("device_id", "0") : c2;
    }

    public void a(String str) {
        this.a.edit().putString("device_id", str).apply();
    }
}
