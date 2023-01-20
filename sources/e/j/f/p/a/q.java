package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public abstract class q {
    private final ParsedResultType a;

    public q(ParsedResultType parsedResultType) {
        this.a = parsedResultType;
    }

    public static void b(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public static void c(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                b(str, sb);
            }
        }
    }

    public abstract String a();

    public final ParsedResultType getType() {
        return this.a;
    }

    public final String toString() {
        return a();
    }
}
