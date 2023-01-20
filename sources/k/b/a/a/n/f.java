package k.b.a.a.n;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class f implements k.b.a.a.i {
    private static final String b = "//";

    /* renamed from: c  reason: collision with root package name */
    private static final String f16147c = "\"";

    /* renamed from: d  reason: collision with root package name */
    private static final String f16148d = "*/";

    /* renamed from: e  reason: collision with root package name */
    private static final String f16149e = "/*";

    /* renamed from: f  reason: collision with root package name */
    private static final String f16150f = "org/apache/commons/codec/language/dmrules.txt";

    /* renamed from: g  reason: collision with root package name */
    private static final int f16151g = 6;

    /* renamed from: h  reason: collision with root package name */
    private static final Map<Character, List<c>> f16152h;

    /* renamed from: i  reason: collision with root package name */
    private static final Map<Character, Character> f16153i;
    private final boolean a;

    /* loaded from: classes4.dex */
    public static class a implements Comparator<c> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return cVar2.b() - cVar.b();
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        private final StringBuilder a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f16154c;

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b a() {
            b bVar = new b();
            bVar.a.append(toString());
            bVar.f16154c = this.f16154c;
            return bVar;
        }

        public void b() {
            while (this.a.length() < 6) {
                this.a.append('0');
                this.b = null;
            }
        }

        public void c(String str, boolean z) {
            String str2 = this.f16154c;
            if ((str2 == null || !str2.endsWith(str) || z) && this.a.length() < 6) {
                this.a.append(str);
                if (this.a.length() > 6) {
                    StringBuilder sb = this.a;
                    sb.delete(6, sb.length());
                }
                this.b = null;
            }
            this.f16154c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return toString().equals(((b) obj).toString());
            }
            return false;
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public String toString() {
            if (this.b == null) {
                this.b = this.a.toString();
            }
            return this.b;
        }

        private b() {
            this.a = new StringBuilder();
            this.f16154c = null;
            this.b = null;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        private final String a;
        private final String[] b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f16155c;

        /* renamed from: d  reason: collision with root package name */
        private final String[] f16156d;

        public c(String str, String str2, String str3, String str4) {
            this.a = str;
            this.b = str2.split("\\|");
            this.f16155c = str3.split("\\|");
            this.f16156d = str4.split("\\|");
        }

        private boolean d(char c2) {
            return c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u';
        }

        public int b() {
            return this.a.length();
        }

        public String[] c(String str, boolean z) {
            if (z) {
                return this.b;
            }
            int b = b();
            if (b < str.length() ? d(str.charAt(b)) : false) {
                return this.f16155c;
            }
            return this.f16156d;
        }

        public boolean e(String str) {
            return str.startsWith(this.a);
        }

        public String toString() {
            return String.format("%s=(%s,%s,%s)", this.a, Arrays.asList(this.b), Arrays.asList(this.f16155c), Arrays.asList(this.f16156d));
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f16152h = hashMap;
        HashMap hashMap2 = new HashMap();
        f16153i = hashMap2;
        Scanner scanner = new Scanner(k.b.a.a.g.a(f16150f), "UTF-8");
        try {
            b(scanner, f16150f, hashMap, hashMap2);
            scanner.close();
            for (Map.Entry entry : hashMap.entrySet()) {
                Collections.sort((List) entry.getValue(), new a());
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    scanner.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public f() {
        this(true);
    }

    private String a(String str) {
        char[] charArray;
        StringBuilder sb = new StringBuilder();
        for (char c2 : str.toCharArray()) {
            if (!Character.isWhitespace(c2)) {
                char lowerCase = Character.toLowerCase(c2);
                if (this.a) {
                    Map<Character, Character> map = f16153i;
                    if (map.containsKey(Character.valueOf(lowerCase))) {
                        lowerCase = map.get(Character.valueOf(lowerCase)).charValue();
                    }
                }
                sb.append(lowerCase);
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
        throw new java.lang.IllegalArgumentException("Malformed folding statement - patterns are not single characters: " + r4 + " in " + r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(java.util.Scanner r11, java.lang.String r12, java.util.Map<java.lang.Character, java.util.List<k.b.a.a.n.f.c>> r13, java.util.Map<java.lang.Character, java.lang.Character> r14) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k.b.a.a.n.f.b(java.util.Scanner, java.lang.String, java.util.Map, java.util.Map):void");
    }

    private String[] d(String str, boolean z) {
        String str2;
        int i2;
        String str3;
        if (str == null) {
            return null;
        }
        String a2 = a(str);
        LinkedHashSet<b> linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new b(null));
        int i3 = 0;
        char c2 = 0;
        while (i3 < a2.length()) {
            char charAt = a2.charAt(i3);
            if (!Character.isWhitespace(charAt)) {
                String substring = a2.substring(i3);
                List<c> list = f16152h.get(Character.valueOf(charAt));
                if (list != null) {
                    List arrayList = z ? new ArrayList() : Collections.emptyList();
                    Iterator<c> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str2 = a2;
                            i2 = 1;
                            break;
                        }
                        c next = it.next();
                        if (next.e(substring)) {
                            if (z) {
                                arrayList.clear();
                            }
                            String[] c3 = next.c(substring, c2 == 0);
                            boolean z2 = c3.length > 1 && z;
                            for (b bVar : linkedHashSet) {
                                int length = c3.length;
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= length) {
                                        str3 = a2;
                                        break;
                                    }
                                    String str4 = c3[i4];
                                    b a3 = z2 ? bVar.a() : bVar;
                                    str3 = a2;
                                    a3.c(str4, (c2 == 'm' && charAt == 'n') || (c2 == 'n' && charAt == 'm'));
                                    if (z) {
                                        arrayList.add(a3);
                                        i4++;
                                        a2 = str3;
                                    }
                                }
                                a2 = str3;
                            }
                            str2 = a2;
                            if (z) {
                                linkedHashSet.clear();
                                linkedHashSet.addAll(arrayList);
                            }
                            i2 = 1;
                            i3 += next.b() - 1;
                        }
                    }
                    c2 = charAt;
                    i3 += i2;
                    a2 = str2;
                }
            }
            str2 = a2;
            i2 = 1;
            i3 += i2;
            a2 = str2;
        }
        String[] strArr = new String[linkedHashSet.size()];
        int i5 = 0;
        for (b bVar2 : linkedHashSet) {
            bVar2.b();
            strArr[i5] = bVar2.toString();
            i5++;
        }
        return strArr;
    }

    private static String e(String str) {
        if (str.startsWith(f16147c)) {
            str = str.substring(1);
        }
        return str.endsWith(f16147c) ? str.substring(0, str.length() - 1) : str;
    }

    public String c(String str) {
        String[] d2 = d(str, true);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String str2 : d2) {
            sb.append(str2);
            i2++;
            if (i2 < d2.length) {
                sb.append('|');
            }
        }
        return sb.toString();
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return f((String) obj);
        }
        throw new EncoderException("Parameter supplied to DaitchMokotoffSoundex encode is not of type java.lang.String");
    }

    @Override // k.b.a.a.i
    public String f(String str) {
        if (str == null) {
            return null;
        }
        return d(str, false)[0];
    }

    public f(boolean z) {
        this.a = z;
    }
}
