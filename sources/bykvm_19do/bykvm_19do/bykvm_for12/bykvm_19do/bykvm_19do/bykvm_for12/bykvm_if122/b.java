package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class b {
    public v a;
    public String b = null;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f264c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public String f265d = null;

    public b(v vVar) {
        this.a = vVar;
        a(UUID.randomUUID().toString());
    }

    public String a() {
        return this.b;
    }

    public void a(y.a aVar) {
        if (aVar != null && this.f264c.size() > 0) {
            for (Map.Entry<String, String> entry : this.f264c.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    aVar.a(key, value);
                }
            }
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(String str, String str2) {
        this.f264c.put(str, str2);
    }

    public void b(String str) {
        this.f265d = str;
    }
}
