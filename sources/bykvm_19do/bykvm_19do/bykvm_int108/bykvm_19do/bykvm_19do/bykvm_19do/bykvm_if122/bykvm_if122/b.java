package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import android.content.Context;
import android.net.Uri;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.f;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.h;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import com.tencent.android.tpns.mqtt.MqttTopic;

/* loaded from: classes.dex */
public class b {
    public static h a;

    public static h a(Context context) {
        try {
            c.a("getResolver");
            if (a == null) {
                a = j.l().b().g();
            }
        } catch (Exception unused) {
        }
        return a;
    }

    private static String a() {
        return g.b + MqttTopic.TOPIC_LEVEL_SEPARATOR + "ad_log_event" + MqttTopic.TOPIC_LEVEL_SEPARATOR;
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            c.a("dispatch event getResolver before");
            h a2 = a(j.l().d());
            c.a("dispatch event getResolver end");
            if (a2 != null) {
                String a3 = f.a(aVar.f());
                Uri parse = Uri.parse(a() + "adLogDispatch?event=" + a3);
                c.a("dispatch event getType:");
                a2.a(parse);
                c.a("dispatch event getType end ");
            }
        } catch (Throwable th) {
            c.b("dispatch event Throwable:" + th.toString());
        }
    }

    public static void b() {
        c.a("EventProviderImpl#start");
        if (j.l().d() != null) {
            try {
                h a2 = a(j.l().d());
                if (a2 == null) {
                    return;
                }
                Uri parse = Uri.parse(a() + "adLogStart");
                c.a("EventProviderImpl#gettype");
                a2.a(parse);
            } catch (Throwable unused) {
            }
        }
    }
}
