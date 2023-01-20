package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.net.Proxy;

/* loaded from: classes.dex */
public final class i {
    public static String a(s sVar) {
        String c2 = sVar.c();
        String e2 = sVar.e();
        if (e2 != null) {
            return c2 + k.b.a.a.o.e.a + e2;
        }
        return c2;
    }

    public static String a(y yVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(yVar.e());
        sb.append(' ');
        boolean b = b(yVar, type);
        s g2 = yVar.g();
        if (b) {
            sb.append(g2);
        } else {
            sb.append(a(g2));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(y yVar, Proxy.Type type) {
        return !yVar.d() && type == Proxy.Type.HTTP;
    }
}
