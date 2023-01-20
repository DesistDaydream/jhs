package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import android.content.Context;
import android.location.Address;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.v;
import com.effective.android.panel.Constants;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b {
    private Context a;

    /* renamed from: c  reason: collision with root package name */
    public String f967c = "sp_multi_ttmadnet_config";
    private final c0 b = c0.a("sp_multi_ttmadnet_config", g());

    public a(Context context) {
        this.a = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public Address a(Context context) {
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String a(Context context, String str, String str2) {
        return this.b.a(str, str2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public void a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.b.b(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.b.b(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.b.b(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.b.b(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.b.b(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String[] a() {
        return new String[]{"dm.toutiao.com", "dm.bytedance.com", "dm.pstatp.com"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String b() {
        return Constants.ANDROID;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public int c() {
        return 4741;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String d() {
        return "msdk";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public int e() {
        return e.c.c.a.b.a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String f() {
        return v.d(this.a);
    }

    public Context g() {
        return this.a;
    }
}
