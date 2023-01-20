package e.j.f.p.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public final class u extends t {
    private static void q(Collection<String> collection, Collection<String> collection2, String str) {
        int indexOf = str.indexOf(59);
        if (indexOf < 0) {
            collection.add(str);
            collection2.add(null);
            return;
        }
        collection.add(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        collection2.add(substring.startsWith("via=") ? substring.substring(4) : null);
    }

    @Override // e.j.f.p.a.t
    /* renamed from: r */
    public v k(e.j.f.k kVar) {
        String str;
        String substring;
        String c2 = t.c(kVar);
        String str2 = null;
        if (!c2.startsWith("sms:") && !c2.startsWith("SMS:") && !c2.startsWith("mms:") && !c2.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> m2 = t.m(c2);
        boolean z = false;
        if (m2 == null || m2.isEmpty()) {
            str = null;
        } else {
            str2 = m2.get("subject");
            str = m2.get("body");
            z = true;
        }
        int indexOf = c2.indexOf(63, 4);
        if (indexOf >= 0 && z) {
            substring = c2.substring(4, indexOf);
        } else {
            substring = c2.substring(4);
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i3 = i2 + 1;
            int indexOf2 = substring.indexOf(44, i3);
            if (indexOf2 > i2) {
                q(arrayList, arrayList2, substring.substring(i3, indexOf2));
                i2 = indexOf2;
            } else {
                q(arrayList, arrayList2, substring.substring(i3));
                return new v((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
        }
    }
}
