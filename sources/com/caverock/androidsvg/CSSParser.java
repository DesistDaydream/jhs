package com.caverock.androidsvg;

import android.util.Log;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class CSSParser {

    /* renamed from: c  reason: collision with root package name */
    private static final String f2456c = "AndroidSVG CSSParser";

    /* renamed from: d  reason: collision with root package name */
    private static final String f2457d = "id";

    /* renamed from: e  reason: collision with root package name */
    private static final String f2458e = "class";
    private MediaType a;
    private boolean b = false;

    /* loaded from: classes.dex */
    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static AttribOp[] valuesCustom() {
            AttribOp[] valuesCustom = values();
            int length = valuesCustom.length;
            AttribOp[] attribOpArr = new AttribOp[length];
            System.arraycopy(valuesCustom, 0, attribOpArr, 0, length);
            return attribOpArr;
        }
    }

    /* loaded from: classes.dex */
    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Combinator[] valuesCustom() {
            Combinator[] valuesCustom = values();
            int length = valuesCustom.length;
            Combinator[] combinatorArr = new Combinator[length];
            System.arraycopy(valuesCustom, 0, combinatorArr, 0, length);
            return combinatorArr;
        }
    }

    /* loaded from: classes.dex */
    public enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        tty,
        tv;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static MediaType[] valuesCustom() {
            MediaType[] valuesCustom = values();
            int length = valuesCustom.length;
            MediaType[] mediaTypeArr = new MediaType[length];
            System.arraycopy(valuesCustom, 0, mediaTypeArr, 0, length);
            return mediaTypeArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public String a;
        public AttribOp b;

        /* renamed from: c  reason: collision with root package name */
        public String f2459c;

        public a(String str, AttribOp attribOp, String str2) {
            this.a = null;
            this.f2459c = null;
            this.a = str;
            this.b = attribOp;
            this.f2459c = str2;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends SVGParser.a {
        public b(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        private String A() {
            if (g()) {
                return null;
            }
            String q = q();
            return q != null ? q : B();
        }

        private int E() {
            int i2;
            if (g()) {
                return this.b;
            }
            int i3 = this.b;
            int charAt = this.a.charAt(i3);
            if (charAt == 45) {
                charAt = a();
            }
            if ((charAt < 65 || charAt > 90) && ((charAt < 97 || charAt > 122) && charAt != 95)) {
                i2 = i3;
            } else {
                int a = a();
                while (true) {
                    if ((a < 65 || a > 90) && ((a < 97 || a > 122) && !((a >= 48 && a <= 57) || a == 45 || a == 95))) {
                        break;
                    }
                    a = a();
                }
                i2 = this.b;
            }
            this.b = i3;
            return i2;
        }

        public String B() {
            int E = E();
            int i2 = this.b;
            if (E == i2) {
                return null;
            }
            String substring = this.a.substring(i2, E);
            this.b = E;
            return substring;
        }

        public String C() {
            if (g()) {
                return null;
            }
            int i2 = this.b;
            int charAt = this.a.charAt(i2);
            int i3 = i2;
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !i(charAt)) {
                if (!j(charAt)) {
                    i3 = this.b + 1;
                }
                charAt = a();
            }
            if (this.b > i2) {
                return this.a.substring(i2, i3);
            }
            this.b = i2;
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:86:0x0156, code lost:
            if (r4 == null) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0158, code lost:
            r11.a(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x015b, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x015c, code lost:
            r10.b = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x015e, code lost:
            return false;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0156 A[EDGE_INSN: B:91:0x0156->B:86:0x0156 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean D(com.caverock.androidsvg.CSSParser.e r11) throws org.xml.sax.SAXException {
            /*
                Method dump skipped, instructions count: 351
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.b.D(com.caverock.androidsvg.CSSParser$e):boolean");
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public e a;
        public SVG.Style b;

        public c(e eVar, SVG.Style style) {
            this.a = null;
            this.b = null;
            this.a = eVar;
            this.b = style;
        }

        public String toString() {
            return this.a + " {}";
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        private List<c> a = null;

        public void a(c cVar) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                if (this.a.get(i2).a.b > cVar.a.b) {
                    this.a.add(i2, cVar);
                    return;
                }
            }
            this.a.add(cVar);
        }

        public void b(d dVar) {
            if (dVar.a == null) {
                return;
            }
            if (this.a == null) {
                this.a = new ArrayList(dVar.a.size());
            }
            for (c cVar : dVar.a) {
                this.a.add(cVar);
            }
        }

        public List<c> c() {
            return this.a;
        }

        public boolean d() {
            List<c> list = this.a;
            return list == null || list.isEmpty();
        }

        public String toString() {
            if (this.a == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c cVar : this.a) {
                sb.append(cVar.toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public List<f> a = null;
        public int b = 0;

        public void a(f fVar) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.add(fVar);
        }

        public void b() {
            this.b += 100;
        }

        public void c() {
            this.b++;
        }

        public void d() {
            this.b += 10000;
        }

        public f e(int i2) {
            return this.a.get(i2);
        }

        public boolean f() {
            List<f> list = this.a;
            if (list == null) {
                return true;
            }
            return list.isEmpty();
        }

        public int g() {
            List<f> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (f fVar : this.a) {
                sb.append(fVar);
                sb.append(' ');
            }
            sb.append('(');
            sb.append(this.b);
            sb.append(')');
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: e  reason: collision with root package name */
        private static /* synthetic */ int[] f2460e;
        public Combinator a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public List<a> f2461c = null;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f2462d = null;

        public f(Combinator combinator, String str) {
            this.a = null;
            this.b = null;
            this.a = combinator == null ? Combinator.DESCENDANT : combinator;
            this.b = str;
        }

        public static /* synthetic */ int[] a() {
            int[] iArr = f2460e;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[AttribOp.valuesCustom().length];
            try {
                iArr2[AttribOp.DASHMATCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[AttribOp.EQUALS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[AttribOp.EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[AttribOp.INCLUDES.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            f2460e = iArr2;
            return iArr2;
        }

        public void b(String str, AttribOp attribOp, String str2) {
            if (this.f2461c == null) {
                this.f2461c = new ArrayList();
            }
            this.f2461c.add(new a(str, attribOp, str2));
        }

        public void c(String str) {
            if (this.f2462d == null) {
                this.f2462d = new ArrayList();
            }
            this.f2462d.add(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Combinator combinator = this.a;
            if (combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.b;
            if (str == null) {
                str = "*";
            }
            sb.append(str);
            List<a> list = this.f2461c;
            if (list != null) {
                for (a aVar : list) {
                    sb.append('[');
                    sb.append(aVar.a);
                    int i2 = a()[aVar.b.ordinal()];
                    if (i2 == 2) {
                        sb.append('=');
                        sb.append(aVar.f2459c);
                    } else if (i2 == 3) {
                        sb.append("~=");
                        sb.append(aVar.f2459c);
                    } else if (i2 == 4) {
                        sb.append("|=");
                        sb.append(aVar.f2459c);
                    }
                    sb.append(']');
                }
            }
            List<String> list2 = this.f2462d;
            if (list2 != null) {
                for (String str2 : list2) {
                    sb.append(':');
                    sb.append(str2);
                }
            }
            return sb.toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.a = null;
        this.a = mediaType;
    }

    private static int a(List<SVG.g0> list, int i2, SVG.i0 i0Var) {
        if (i2 < 0) {
            return -1;
        }
        SVG.g0 g0Var = list.get(i2);
        SVG.g0 g0Var2 = i0Var.b;
        if (g0Var != g0Var2) {
            return -1;
        }
        int i3 = 0;
        for (SVG.k0 k0Var : g0Var2.k()) {
            if (k0Var == i0Var) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static boolean b(String str, MediaType mediaType) throws SAXException {
        b bVar = new b(str);
        bVar.z();
        List<MediaType> h2 = h(bVar);
        if (bVar.g()) {
            return c(h2, mediaType);
        }
        throw new SAXException("Invalid @media type list");
    }

    private static boolean c(List<MediaType> list, MediaType mediaType) {
        for (MediaType mediaType2 : list) {
            if (mediaType2 == MediaType.all) {
                return true;
            }
            if (mediaType2 == mediaType) {
                return true;
            }
        }
        return false;
    }

    private void e(d dVar, b bVar) throws SAXException {
        String B = bVar.B();
        bVar.z();
        if (B != null) {
            if (!this.b && B.equals("media")) {
                List<MediaType> h2 = h(bVar);
                if (bVar.e('{')) {
                    bVar.z();
                    if (c(h2, this.a)) {
                        this.b = true;
                        dVar.b(j(bVar));
                        this.b = false;
                    } else {
                        j(bVar);
                    }
                    if (!bVar.e('}')) {
                        throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new SAXException("Invalid @media rule: missing rule set");
                }
            } else {
                q("Ignoring @%s rule", B);
                p(bVar);
            }
            bVar.z();
            return;
        }
        throw new SAXException("Invalid '@' rule in <style> element");
    }

    public static List<String> f(String str) throws SAXException {
        b bVar = new b(str);
        ArrayList arrayList = null;
        while (!bVar.g()) {
            String B = bVar.B();
            if (B != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(B);
                bVar.z();
            } else {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
        }
        return arrayList;
    }

    private SVG.Style g(b bVar) throws SAXException {
        SVG.Style style = new SVG.Style();
        do {
            String B = bVar.B();
            bVar.z();
            if (!bVar.e(':')) {
                break;
            }
            bVar.z();
            String C = bVar.C();
            if (C == null) {
                break;
            }
            bVar.z();
            if (bVar.e('!')) {
                bVar.z();
                if (bVar.f("important")) {
                    bVar.z();
                } else {
                    throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                }
            }
            bVar.e(';');
            SVGParser.B0(style, B, C);
            bVar.z();
            if (bVar.e('}')) {
                return style;
            }
        } while (!bVar.g());
        throw new SAXException("Malformed rule set in <style> element");
    }

    private static List<MediaType> h(b bVar) throws SAXException {
        ArrayList arrayList = new ArrayList();
        while (!bVar.g()) {
            try {
                arrayList.add(MediaType.valueOf(bVar.s(',')));
                if (!bVar.y()) {
                    break;
                }
            } catch (IllegalArgumentException unused) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private boolean i(d dVar, b bVar) throws SAXException {
        List<e> k2 = k(bVar);
        if (k2 == null || k2.isEmpty()) {
            return false;
        }
        if (bVar.e('{')) {
            bVar.z();
            SVG.Style g2 = g(bVar);
            bVar.z();
            for (e eVar : k2) {
                dVar.a(new c(eVar, g2));
            }
            return true;
        }
        throw new SAXException("Malformed rule block in <style> element: missing '{'");
    }

    private d j(b bVar) throws SAXException {
        d dVar = new d();
        while (!bVar.g()) {
            if (!bVar.f("<!--") && !bVar.f("-->")) {
                if (bVar.e('@')) {
                    e(dVar, bVar);
                } else if (!i(dVar, bVar)) {
                    break;
                }
            }
        }
        return dVar;
    }

    private List<e> k(b bVar) throws SAXException {
        if (bVar.g()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e();
        while (!bVar.g() && bVar.D(eVar)) {
            if (bVar.y()) {
                arrayList.add(eVar);
                eVar = new e();
            }
        }
        if (!eVar.f()) {
            arrayList.add(eVar);
        }
        return arrayList;
    }

    private static boolean l(e eVar, int i2, List<SVG.g0> list, int i3, SVG.i0 i0Var) {
        f e2 = eVar.e(i2);
        if (o(e2, list, i3, i0Var)) {
            Combinator combinator = e2.a;
            if (combinator == Combinator.DESCENDANT) {
                if (i2 == 0) {
                    return true;
                }
                while (i3 >= 0) {
                    if (n(eVar, i2 - 1, list, i3)) {
                        return true;
                    }
                    i3--;
                }
                return false;
            } else if (combinator == Combinator.CHILD) {
                return n(eVar, i2 - 1, list, i3);
            } else {
                int a2 = a(list, i3, i0Var);
                if (a2 <= 0) {
                    return false;
                }
                return l(eVar, i2 - 1, list, i3, (SVG.i0) i0Var.b.k().get(a2 - 1));
            }
        }
        return false;
    }

    public static boolean m(e eVar, SVG.i0 i0Var) {
        ArrayList arrayList = new ArrayList();
        for (SVG.g0 g0Var = i0Var.b; g0Var != null; g0Var = ((SVG.k0) g0Var).b) {
            arrayList.add(0, g0Var);
        }
        int size = arrayList.size() - 1;
        if (eVar.g() == 1) {
            return o(eVar.e(0), arrayList, size, i0Var);
        }
        return l(eVar, eVar.g() - 1, arrayList, size, i0Var);
    }

    private static boolean n(e eVar, int i2, List<SVG.g0> list, int i3) {
        f e2 = eVar.e(i2);
        SVG.i0 i0Var = (SVG.i0) list.get(i3);
        if (o(e2, list, i3, i0Var)) {
            Combinator combinator = e2.a;
            if (combinator == Combinator.DESCENDANT) {
                if (i2 == 0) {
                    return true;
                }
                while (i3 > 0) {
                    i3--;
                    if (n(eVar, i2 - 1, list, i3)) {
                        return true;
                    }
                }
                return false;
            } else if (combinator == Combinator.CHILD) {
                return n(eVar, i2 - 1, list, i3 - 1);
            } else {
                int a2 = a(list, i3, i0Var);
                if (a2 <= 0) {
                    return false;
                }
                return l(eVar, i2 - 1, list, i3, (SVG.i0) i0Var.b.k().get(a2 - 1));
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean o(com.caverock.androidsvg.CSSParser.f r5, java.util.List<com.caverock.androidsvg.SVG.g0> r6, int r7, com.caverock.androidsvg.SVG.i0 r8) {
        /*
            java.lang.String r0 = r5.b
            r1 = 0
            if (r0 == 0) goto L29
            java.lang.String r2 = "G"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L12
            boolean r0 = r8 instanceof com.caverock.androidsvg.SVG.k
            if (r0 != 0) goto L29
            return r1
        L12:
            java.lang.String r0 = r5.b
            java.lang.Class r2 = r8.getClass()
            java.lang.String r2 = r2.getSimpleName()
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r2 = r2.toLowerCase(r3)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L29
            return r1
        L29:
            java.util.List<com.caverock.androidsvg.CSSParser$a> r0 = r5.f2461c
            if (r0 == 0) goto L61
            java.util.Iterator r0 = r0.iterator()
        L31:
            boolean r2 = r0.hasNext()
            if (r2 != 0) goto L38
            goto L61
        L38:
            java.lang.Object r2 = r0.next()
            com.caverock.androidsvg.CSSParser$a r2 = (com.caverock.androidsvg.CSSParser.a) r2
            java.lang.String r3 = r2.a
            java.lang.String r4 = "id"
            if (r3 != r4) goto L4f
            java.lang.String r2 = r2.f2459c
            java.lang.String r3 = r8.f2517c
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L31
            return r1
        L4f:
            java.lang.String r4 = "class"
            if (r3 != r4) goto L60
            java.util.List<java.lang.String> r3 = r8.f2521g
            if (r3 != 0) goto L58
            return r1
        L58:
            java.lang.String r2 = r2.f2459c
            boolean r2 = r3.contains(r2)
            if (r2 != 0) goto L31
        L60:
            return r1
        L61:
            java.util.List<java.lang.String> r5 = r5.f2462d
            if (r5 == 0) goto L85
            java.util.Iterator r5 = r5.iterator()
        L69:
            boolean r0 = r5.hasNext()
            if (r0 != 0) goto L70
            goto L85
        L70:
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "first-child"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L84
            int r0 = a(r6, r7, r8)
            if (r0 == 0) goto L69
        L84:
            return r1
        L85:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.o(com.caverock.androidsvg.CSSParser$f, java.util.List, int, com.caverock.androidsvg.SVG$i0):boolean");
    }

    private void p(b bVar) {
        int i2 = 0;
        while (!bVar.g()) {
            int intValue = bVar.k().intValue();
            if (intValue == 59 && i2 == 0) {
                return;
            }
            if (intValue == 123) {
                i2++;
            } else if (intValue == 125 && i2 > 0 && i2 - 1 == 0) {
                return;
            }
        }
    }

    private static void q(String str, Object... objArr) {
        Log.w(f2456c, String.format(str, objArr));
    }

    public d d(String str) throws SAXException {
        b bVar = new b(str);
        bVar.z();
        return j(bVar);
    }
}
