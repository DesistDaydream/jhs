package e.i.b.a;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public final class a {
    public static final C0332a a = new C0332a();

    /* renamed from: e.i.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0332a implements Comparator<k.a.b.a> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(k.a.b.a aVar, k.a.b.a aVar2) {
            if (aVar.getStart() == aVar2.getStart()) {
                if (aVar.size() < aVar2.size()) {
                    return 1;
                }
                return aVar.size() == aVar2.size() ? 0 : -1;
            } else if (aVar.getStart() < aVar2.getStart()) {
                return -1;
            } else {
                return aVar.getStart() == aVar2.getStart() ? 0 : 1;
            }
        }
    }

    private a() {
    }

    public static String[] a(String str, List<h> list) {
        if (list != null) {
            for (h hVar : list) {
                if (hVar != null && hVar.a() != null && hVar.a().contains(str)) {
                    return hVar.b(str);
                }
            }
        }
        throw new IllegalArgumentException("No pinyin dict contains word: " + str);
    }

    public static String b(String str, k.a.b.f fVar, List<h> list, String str2, j jVar) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (fVar != null && jVar != null) {
            List<k.a.b.a> a2 = jVar.a(fVar.t(str));
            Collections.sort(a2, a);
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            int i3 = 0;
            while (i2 < str.length()) {
                if (i3 < a2.size() && i2 == a2.get(i3).getStart()) {
                    String[] a3 = a(a2.get(i3).d(), list);
                    for (int i4 = 0; i4 < a3.length; i4++) {
                        stringBuffer.append(a3[i4].toUpperCase());
                        if (i4 != a3.length - 1) {
                            stringBuffer.append(str2);
                        }
                    }
                    i2 += a2.get(i3).size();
                    i3++;
                } else {
                    stringBuffer.append(c.g(str.charAt(i2)));
                    i2++;
                }
                if (i2 != str.length()) {
                    stringBuffer.append(str2);
                }
            }
            return stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i5 = 0; i5 < str.length(); i5++) {
            stringBuffer2.append(c.g(str.charAt(i5)));
            if (i5 != str.length() - 1) {
                stringBuffer2.append(str2);
            }
        }
        return stringBuffer2.toString();
    }
}
