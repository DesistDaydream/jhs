package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {
    private final int a;

    public e(int i2) {
        this.a = i2;
    }

    public e(int i2, String str) {
        this.a = i2;
    }

    public e(int i2, Throwable th) {
        this.a = i2;
        if (th != null) {
            th.getMessage();
        }
    }

    public e(int i2, JSONObject jSONObject) {
        this.a = i2;
    }

    public boolean a() {
        return this.a == 0;
    }
}
