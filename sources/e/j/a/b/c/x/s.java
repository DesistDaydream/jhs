package e.j.a.b.c.x;

import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class s {
    @e.j.a.b.c.m.a
    public static void a(StringBuilder sb, HashMap<String, String> hashMap) {
        sb.append("{");
        boolean z = true;
        for (String str : hashMap.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            String str2 = hashMap.get(str);
            sb.append("\"");
            sb.append(str);
            sb.append("\":");
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append("\"");
                sb.append(str2);
                sb.append("\"");
            }
        }
        sb.append("}");
    }
}
