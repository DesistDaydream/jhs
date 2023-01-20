package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.content.Context;
import android.util.Log;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    private static volatile boolean a;
    private static final AtomicLong b = new AtomicLong(0);

    /* renamed from: c  reason: collision with root package name */
    private static volatile int f933c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f934d = false;

    /* renamed from: e  reason: collision with root package name */
    private static volatile boolean f935e = true;

    public static void a(int i2) {
        f933c = i2;
        if (f933c == 1 || f933c == 0) {
            return;
        }
        f933c = 0;
    }

    public static void a(Context context, d dVar, Map<String, Object> map) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().v()) {
            if (a() && !a) {
                Log.d("TTMediationSDK", "--==-- event 还未进行sdk初始化");
                return;
            }
            if (context == null) {
                context = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
            }
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException unused) {
                }
            }
            jSONObject.put("eventIndex", b.getAndIncrement());
            jSONObject.put("if_use_new_loglib", a());
            int j2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().j();
            if (dVar != null) {
                dVar.a("event_id", UUID.randomUUID().toString());
            }
            if (j2 == 0 || j2 == 2) {
                i a2 = i.a(context, dVar, jSONObject);
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.bykvm_19do.a.a(a2, true);
                if (a()) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a aVar = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a(a2.a, a2);
                    aVar.a((byte) 3);
                    aVar.b((byte) 2);
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.a(aVar);
                } else {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.c().a(a2);
                }
            }
            if (j2 == 0 || j2 == 1) {
                a a3 = a.a(context, dVar, jSONObject);
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.bykvm_19do.a.a(a3, false);
                if (!a()) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a().a(a3);
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a aVar2 = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a(a3.a, a3);
                aVar2.a((byte) 0);
                aVar2.b((byte) 2);
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.a(aVar2);
            }
        }
    }

    public static boolean a() {
        if (!f934d) {
            synchronized (c.class) {
                if (!f934d) {
                    f935e = f933c == 1;
                    f934d = true;
                }
            }
        }
        return f935e;
    }

    public static void b() {
        a = true;
    }
}
