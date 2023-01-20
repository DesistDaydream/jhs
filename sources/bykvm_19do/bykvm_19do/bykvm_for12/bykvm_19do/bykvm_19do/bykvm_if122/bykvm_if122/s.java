package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.moor.imkf.lib.socket.java_websocket.WebSocketImpl;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: i  reason: collision with root package name */
    private static final char[] f621i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f622c;

    /* renamed from: d  reason: collision with root package name */
    public final String f623d;

    /* renamed from: e  reason: collision with root package name */
    public final int f624e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f625f;

    /* renamed from: g  reason: collision with root package name */
    private final String f626g;

    /* renamed from: h  reason: collision with root package name */
    private final String f627h;

    /* loaded from: classes.dex */
    public static final class a {
        public String a;

        /* renamed from: d  reason: collision with root package name */
        public String f629d;

        /* renamed from: f  reason: collision with root package name */
        public final List<String> f631f;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f632g;

        /* renamed from: h  reason: collision with root package name */
        public String f633h;
        public String b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f628c = "";

        /* renamed from: e  reason: collision with root package name */
        public int f630e = -1;

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0024a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f631f = arrayList;
            arrayList.add("");
        }

        private a a(String str, boolean z) {
            int i2 = 0;
            do {
                int a = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, i2, str.length(), "/\\");
                a(str, i2, a, a < str.length(), z);
                i2 = a + 1;
            } while (i2 <= str.length());
            return this;
        }

        private static String a(String str, int i2, int i3) {
            return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(s.a(str, i2, i3, false));
        }

        private void a(String str, int i2, int i3, boolean z, boolean z2) {
            String a = s.a(str, i2, i3, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, null);
            if (g(a)) {
                return;
            }
            if (h(a)) {
                d();
                return;
            }
            List<String> list = this.f631f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f631f;
                list2.set(list2.size() - 1, a);
            } else {
                this.f631f.add(a);
            }
            if (z) {
                this.f631f.add("");
            }
        }

        private static int b(String str, int i2, int i3) {
            try {
                int parseInt = Integer.parseInt(s.a(str, i2, i3, "", false, false, false, true, null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        private static int c(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 < i3) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        private void d() {
            List<String> list = this.f631f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f631f.isEmpty()) {
                this.f631f.add("");
                return;
            }
            List<String> list2 = this.f631f;
            list2.set(list2.size() - 1, "");
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0028 -> B:12:0x002a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void d(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                goto L43
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.f631f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L2a
            L1e:
                java.util.List<java.lang.String> r0 = r10.f631f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f631f
                r0.add(r2)
            L28:
                int r12 = r12 + 1
            L2a:
                r6 = r12
                if (r6 >= r13) goto L43
                java.lang.String r12 = "/\\"
                int r12 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(r11, r6, r13, r12)
                if (r12 >= r13) goto L37
                r0 = 1
                goto L38
            L37:
                r0 = 0
            L38:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L2a
                goto L28
            L43:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s.a.d(java.lang.String, int, int):void");
        }

        private static int e(String str, int i2, int i3) {
            char charAt;
            if (i3 - i2 >= 2 && (((charAt = str.charAt(i2)) >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int f(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        private boolean g(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean h(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public EnumC0024a a(s sVar, String str) {
            int a;
            int i2;
            int b = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(str, 0, str.length());
            int c2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.c(str, b, str.length());
            if (e(str, b, c2) != -1) {
                if (str.regionMatches(true, b, "https:", 0, 6)) {
                    this.a = "https";
                    b += 6;
                } else if (!str.regionMatches(true, b, "http:", 0, 5)) {
                    return EnumC0024a.UNSUPPORTED_SCHEME;
                } else {
                    this.a = "http";
                    b += 5;
                }
            } else if (sVar == null) {
                return EnumC0024a.MISSING_SCHEME;
            } else {
                this.a = sVar.a;
            }
            int f2 = f(str, b, c2);
            char c3 = k.b.a.a.o.e.a;
            char c4 = '#';
            if (f2 >= 2 || sVar == null || !sVar.a.equals(this.a)) {
                int i3 = b + f2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, i3, c2, "@/\\?#");
                    char charAt = a != c2 ? str.charAt(a) : (char) 65535;
                    if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        break;
                    } else if (charAt == '@') {
                        if (z) {
                            i2 = a;
                            this.f628c += "%40" + s.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int a2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, i3, a, ':');
                            i2 = a;
                            String a3 = s.a(str, i3, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a3 = this.b + "%40" + a3;
                            }
                            this.b = a3;
                            if (a2 != i2) {
                                this.f628c = s.a(str, a2 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        }
                        i3 = i2 + 1;
                        c3 = k.b.a.a.o.e.a;
                        c4 = '#';
                    }
                }
                int c5 = c(str, i3, a);
                int i4 = c5 + 1;
                this.f629d = a(str, i3, c5);
                if (i4 < a) {
                    int b2 = b(str, i4, a);
                    this.f630e = b2;
                    if (b2 == -1) {
                        return EnumC0024a.INVALID_PORT;
                    }
                } else {
                    this.f630e = s.c(this.a);
                }
                if (this.f629d == null) {
                    return EnumC0024a.INVALID_HOST;
                }
                b = a;
            } else {
                this.b = sVar.f();
                this.f628c = sVar.b();
                this.f629d = sVar.f623d;
                this.f630e = sVar.f624e;
                this.f631f.clear();
                this.f631f.addAll(sVar.d());
                if (b == c2 || str.charAt(b) == '#') {
                    b(sVar.e());
                }
            }
            int a4 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, b, c2, "?#");
            d(str, b, a4);
            if (a4 < c2 && str.charAt(a4) == '?') {
                int a5 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, a4, c2, '#');
                this.f632g = s.e(s.a(str, a4 + 1, a5, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                a4 = a5;
            }
            if (a4 < c2 && str.charAt(a4) == '#') {
                this.f633h = s.a(str, 1 + a4, c2, "", true, false, false, false, null);
            }
            return EnumC0024a.SUCCESS;
        }

        public a a(int i2) {
            if (i2 > 0 && i2 <= 65535) {
                this.f630e = i2;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i2);
        }

        public a a(String str) {
            Objects.requireNonNull(str, "encodedPathSegments == null");
            return a(str, true);
        }

        public a a(String str, String str2) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.f632g == null) {
                this.f632g = new ArrayList();
            }
            this.f632g.add(s.a(str, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            this.f632g.add(str2 != null ? s.a(str2, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true) : null);
            return this;
        }

        public s a() {
            if (this.a != null) {
                if (this.f629d != null) {
                    return new s(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public int b() {
            int i2 = this.f630e;
            return i2 != -1 ? i2 : s.c(this.a);
        }

        public a b(String str) {
            this.f632g = str != null ? s.e(s.a(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public a c() {
            int size = this.f631f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f631f.set(i2, s.a(this.f631f.get(i2), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            List<String> list = this.f632g;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.f632g.get(i3);
                    if (str != null) {
                        this.f632g.set(i3, s.a(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            String str2 = this.f633h;
            if (str2 != null) {
                this.f633h = s.a(str2, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public a c(String str) {
            Objects.requireNonNull(str, "host == null");
            String a = a(str, 0, str.length());
            if (a != null) {
                this.f629d = a;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public a d(String str) {
            Objects.requireNonNull(str, "password == null");
            this.f628c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a e(String str) {
            Objects.requireNonNull(str, "scheme == null");
            String str2 = "http";
            if (!str.equalsIgnoreCase("http")) {
                str2 = "https";
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
            }
            this.a = str2;
            return this;
        }

        public a f(String str) {
            Objects.requireNonNull(str, "username == null");
            this.b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("://");
            if (!this.b.isEmpty() || !this.f628c.isEmpty()) {
                sb.append(this.b);
                if (!this.f628c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f628c);
                }
                sb.append('@');
            }
            if (this.f629d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f629d);
                sb.append(']');
            } else {
                sb.append(this.f629d);
            }
            int b = b();
            if (b != s.c(this.a)) {
                sb.append(':');
                sb.append(b);
            }
            s.b(sb, this.f631f);
            if (this.f632g != null) {
                sb.append(k.b.a.a.o.e.a);
                s.a(sb, this.f632g);
            }
            if (this.f633h != null) {
                sb.append('#');
                sb.append(this.f633h);
            }
            return sb.toString();
        }
    }

    public s(a aVar) {
        this.a = aVar.a;
        this.b = a(aVar.b, false);
        this.f622c = a(aVar.f628c, false);
        this.f623d = aVar.f629d;
        this.f624e = aVar.b();
        a(aVar.f631f, false);
        List<String> list = aVar.f632g;
        this.f625f = list != null ? a(list, true) : null;
        String str = aVar.f633h;
        this.f626g = str != null ? a(str, false) : null;
        this.f627h = aVar.toString();
    }

    public static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
            cVar.a(str, i2, i4);
            a(cVar, str, i4, i3, str2, z, z2, z3, z4, charset);
            return cVar.n();
        }
        return str.substring(i2, i3);
    }

    public static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
                cVar.a(str, i2, i4);
                a(cVar, str, i4, i3, z);
                return cVar.n();
            }
        }
        return str.substring(i2, i3);
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    public static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.a(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i2, i3)))))) {
                    if (cVar2 == null) {
                        cVar2 = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
                    }
                    if (charset == null || charset.equals(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f548i)) {
                        cVar2.c(codePointAt);
                    } else {
                        cVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                    }
                    while (!cVar2.f()) {
                        int readByte = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        char[] cArr = f621i;
                        cVar.writeByte((int) cArr[(readByte >> 4) & 15]);
                        cVar.writeByte((int) cArr[readByte & 15]);
                    }
                } else {
                    cVar.c(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt != 37 || (i4 = i2 + 2) >= i3) {
                if (codePointAt == 43 && z) {
                    cVar.writeByte(32);
                }
                cVar.c(codePointAt);
            } else {
                int a2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str.charAt(i2 + 1));
                int a3 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str.charAt(i4));
                if (a2 != -1 && a3 != -1) {
                    cVar.writeByte((a2 << 4) + a3);
                    i2 = i4;
                }
                cVar.c(codePointAt);
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append(h.t2.y.f15690c);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str.charAt(i2 + 1)) != -1 && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str.charAt(i4)) != -1;
    }

    public static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(Attributes.InternalPrefix);
            sb.append(list.get(i2));
        }
    }

    public static int c(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return WebSocketImpl.DEFAULT_WSS_PORT;
        }
        return -1;
    }

    public static s d(String str) {
        a aVar = new a();
        if (aVar.a((s) null, str) == a.EnumC0024a.SUCCESS) {
            return aVar.a();
        }
        return null;
    }

    public static List<String> e(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public a a(String str) {
        a aVar = new a();
        if (aVar.a(this, str) == a.EnumC0024a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public String a() {
        if (this.f626g == null) {
            return null;
        }
        return this.f627h.substring(this.f627h.indexOf(35) + 1);
    }

    public s b(String str) {
        a a2 = a(str);
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    public String b() {
        if (this.f622c.isEmpty()) {
            return "";
        }
        int indexOf = this.f627h.indexOf(58, this.a.length() + 3);
        return this.f627h.substring(indexOf + 1, this.f627h.indexOf(64));
    }

    public String c() {
        int indexOf = this.f627h.indexOf(47, this.a.length() + 3);
        String str = this.f627h;
        return this.f627h.substring(indexOf, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, indexOf, str.length(), "?#"));
    }

    public List<String> d() {
        int indexOf = this.f627h.indexOf(47, this.a.length() + 3);
        String str = this.f627h;
        int a2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f627h, i2, a2, (char) Attributes.InternalPrefix);
            arrayList.add(this.f627h.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String e() {
        if (this.f625f == null) {
            return null;
        }
        int indexOf = this.f627h.indexOf(63) + 1;
        String str = this.f627h;
        return this.f627h.substring(indexOf, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, indexOf, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).f627h.equals(this.f627h);
    }

    public String f() {
        if (this.b.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.f627h;
        return this.f627h.substring(length, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f623d;
    }

    public boolean h() {
        return this.a.equals("https");
    }

    public int hashCode() {
        return this.f627h.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.b = f();
        aVar.f628c = b();
        aVar.f629d = this.f623d;
        aVar.f630e = this.f624e != c(this.a) ? this.f624e : -1;
        aVar.f631f.clear();
        aVar.f631f.addAll(d());
        aVar.b(e());
        aVar.f633h = a();
        return aVar;
    }

    public int j() {
        return this.f624e;
    }

    public String k() {
        if (this.f625f == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.f625f);
        return sb.toString();
    }

    public String l() {
        return a("/...").f("").d("").a().toString();
    }

    public String m() {
        return this.a;
    }

    public URI n() {
        String aVar = i().c().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public URL o() {
        try {
            return new URL(this.f627h);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String toString() {
        return this.f627h;
    }
}
