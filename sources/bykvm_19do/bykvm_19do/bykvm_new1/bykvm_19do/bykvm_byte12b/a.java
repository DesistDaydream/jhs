package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.h;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile a b;
    private volatile Context a;

    private a(@NonNull Context context) {
        this.a = context;
    }

    public static a a() {
        if (b == null) {
            b = new a(i.b());
        }
        return b;
    }

    @Nullable
    public String a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                return bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.d.a(h.c(this.a), h.b(), b.a(i.e().d()), jSONObject, b.a());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String a = b.a(i.e().d());
                String a2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.d.a(h.c(this.a), h.a(), a, jSONObject, b.b());
                jSONObject.put("upload_scene", "direct");
                if (!b.a(a, jSONObject.toString()).a()) {
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.d.a(a2);
            } catch (Throwable unused) {
            }
        }
    }
}
