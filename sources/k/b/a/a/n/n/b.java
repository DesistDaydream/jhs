package k.b.a.a.n.n;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import k.b.a.a.n.n.c;
import org.apache.commons.codec.language.bm.NameType;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<NameType, b> f16196c = new EnumMap(NameType.class);

    /* renamed from: d  reason: collision with root package name */
    private static final String f16197d = "org/apache/commons/codec/language/bm/%s_lang.txt";
    private final c a;
    private final List<C0486b> b;

    /* renamed from: k.b.a.a.n.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0486b {
        private final boolean a;
        private final Set<String> b;

        /* renamed from: c  reason: collision with root package name */
        private final Pattern f16198c;

        public boolean c(String str) {
            return this.f16198c.matcher(str).find();
        }

        private C0486b(Pattern pattern, Set<String> set, boolean z) {
            this.f16198c = pattern;
            this.b = set;
            this.a = z;
        }
    }

    static {
        NameType[] values;
        for (NameType nameType : NameType.values()) {
            f16196c.put(nameType, d(String.format(f16197d, nameType.getName()), c.b(nameType)));
        }
    }

    private b(List<C0486b> list, c cVar) {
        this.b = Collections.unmodifiableList(list);
        this.a = cVar;
    }

    public static b c(NameType nameType) {
        return f16196c.get(nameType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a2, code lost:
        throw new java.lang.IllegalArgumentException("Malformed line '" + r4 + "' in language resource '" + r9 + "'");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static k.b.a.a.n.n.b d(java.lang.String r9, k.b.a.a.n.n.c r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Scanner r1 = new java.util.Scanner
            java.io.InputStream r2 = k.b.a.a.g.a(r9)
            java.lang.String r3 = "UTF-8"
            r1.<init>(r2, r3)
            r2 = 0
        L11:
            r3 = 0
        L12:
            boolean r4 = r1.hasNextLine()     // Catch: java.lang.Throwable -> Lac
            if (r4 == 0) goto La3
            java.lang.String r4 = r1.nextLine()     // Catch: java.lang.Throwable -> Lac
            r5 = 1
            if (r3 == 0) goto L28
        */
        //  java.lang.String r5 = "*/"
        /*
            boolean r4 = r4.endsWith(r5)     // Catch: java.lang.Throwable -> Lac
            if (r4 == 0) goto L12
            goto L11
        L28:
            java.lang.String r6 = "/*"
            boolean r6 = r4.startsWith(r6)     // Catch: java.lang.Throwable -> Lac
            if (r6 == 0) goto L32
            r3 = 1
            goto L12
        L32:
            java.lang.String r6 = "//"
            int r6 = r4.indexOf(r6)     // Catch: java.lang.Throwable -> Lac
            if (r6 < 0) goto L3f
            java.lang.String r6 = r4.substring(r2, r6)     // Catch: java.lang.Throwable -> Lac
            goto L40
        L3f:
            r6 = r4
        L40:
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> Lac
            int r7 = r6.length()     // Catch: java.lang.Throwable -> Lac
            if (r7 != 0) goto L4b
            goto L12
        L4b:
            java.lang.String r7 = "\\s+"
            java.lang.String[] r6 = r6.split(r7)     // Catch: java.lang.Throwable -> Lac
            int r7 = r6.length     // Catch: java.lang.Throwable -> Lac
            r8 = 3
            if (r7 != r8) goto L7f
            r4 = r6[r2]     // Catch: java.lang.Throwable -> Lac
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.lang.Throwable -> Lac
            r5 = r6[r5]     // Catch: java.lang.Throwable -> Lac
            java.lang.String r7 = "\\+"
            java.lang.String[] r5 = r5.split(r7)     // Catch: java.lang.Throwable -> Lac
            r7 = 2
            r6 = r6[r7]     // Catch: java.lang.Throwable -> Lac
            java.lang.String r7 = "true"
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> Lac
            k.b.a.a.n.n.b$b r7 = new k.b.a.a.n.n.b$b     // Catch: java.lang.Throwable -> Lac
            java.util.HashSet r8 = new java.util.HashSet     // Catch: java.lang.Throwable -> Lac
            java.util.List r5 = java.util.Arrays.asList(r5)     // Catch: java.lang.Throwable -> Lac
            r8.<init>(r5)     // Catch: java.lang.Throwable -> Lac
            r5 = 0
            r7.<init>(r4, r8, r6)     // Catch: java.lang.Throwable -> Lac
            r0.add(r7)     // Catch: java.lang.Throwable -> Lac
            goto L12
        L7f:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> Lac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r0.<init>()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = "Malformed line '"
            r0.append(r2)     // Catch: java.lang.Throwable -> Lac
            r0.append(r4)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = "' in language resource '"
            r0.append(r2)     // Catch: java.lang.Throwable -> Lac
            r0.append(r9)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r9 = "'"
            r0.append(r9)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Throwable -> Lac
            r10.<init>(r9)     // Catch: java.lang.Throwable -> Lac
            throw r10     // Catch: java.lang.Throwable -> Lac
        La3:
            r1.close()
            k.b.a.a.n.n.b r9 = new k.b.a.a.n.n.b
            r9.<init>(r0, r10)
            return r9
        Lac:
            r9 = move-exception
            throw r9     // Catch: java.lang.Throwable -> Lae
        Lae:
            r10 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> Lb3
            goto Lb7
        Lb3:
            r0 = move-exception
            r9.addSuppressed(r0)
        Lb7:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: k.b.a.a.n.n.b.d(java.lang.String, k.b.a.a.n.n.c):k.b.a.a.n.n.b");
    }

    public String a(String str) {
        c.AbstractC0487c b = b(str);
        return b.e() ? b.c() : c.b;
    }

    public c.AbstractC0487c b(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        HashSet hashSet = new HashSet(this.a.c());
        for (C0486b c0486b : this.b) {
            if (c0486b.c(lowerCase)) {
                if (c0486b.a) {
                    hashSet.retainAll(c0486b.b);
                } else {
                    hashSet.removeAll(c0486b.b);
                }
            }
        }
        c.AbstractC0487c b = c.AbstractC0487c.b(hashSet);
        return b.equals(c.f16200d) ? c.f16201e : b;
    }
}
