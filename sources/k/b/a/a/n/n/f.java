package k.b.a.a.n.n;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import k.b.a.a.n.n.c;
import org.apache.commons.codec.language.bm.NameType;
import org.apache.commons.codec.language.bm.RuleType;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: f  reason: collision with root package name */
    public static final String f16214f = "ALL";

    /* renamed from: g  reason: collision with root package name */
    private static final String f16215g = "\"";

    /* renamed from: h  reason: collision with root package name */
    private static final String f16216h = "#include";
    private final n a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final l f16218c;

    /* renamed from: d  reason: collision with root package name */
    private final n f16219d;

    /* renamed from: e  reason: collision with root package name */
    public static final n f16213e = new b();

    /* renamed from: i  reason: collision with root package name */
    private static final Map<NameType, Map<RuleType, Map<String, Map<String, List<f>>>>> f16217i = new EnumMap(NameType.class);

    /* loaded from: classes4.dex */
    public static class a implements n {
        public Pattern a;
        public final /* synthetic */ String b;

        public a(String str) {
            this.b = str;
            this.a = Pattern.compile(str);
        }

        @Override // k.b.a.a.n.n.f.n
        public boolean a(CharSequence charSequence) {
            return this.a.matcher(charSequence).find();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements n {
        @Override // k.b.a.a.n.n.f.n
        public boolean a(CharSequence charSequence) {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends f {

        /* renamed from: j  reason: collision with root package name */
        private final int f16220j;

        /* renamed from: k  reason: collision with root package name */
        private final String f16221k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ int f16222l;

        /* renamed from: m  reason: collision with root package name */
        public final /* synthetic */ String f16223m;
        public final /* synthetic */ String n;
        public final /* synthetic */ String o;
        public final /* synthetic */ String p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, String str3, l lVar, int i2, String str4, String str5, String str6, String str7) {
            super(str, str2, str3, lVar);
            this.f16222l = i2;
            this.f16223m = str4;
            this.n = str5;
            this.o = str6;
            this.p = str7;
            this.f16220j = i2;
            this.f16221k = str4;
        }

        public String toString() {
            return "Rule{line=" + this.f16220j + ", loc='" + this.f16221k + "', pat='" + this.n + "', lcon='" + this.o + "', rcon='" + this.p + "'}";
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements n {
        @Override // k.b.a.a.n.n.f.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements n {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // k.b.a.a.n.n.f.n
        public boolean a(CharSequence charSequence) {
            return charSequence.equals(this.a);
        }
    }

    /* renamed from: k.b.a.a.n.n.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0488f implements n {
        public final /* synthetic */ String a;

        public C0488f(String str) {
            this.a = str;
        }

        @Override // k.b.a.a.n.n.f.n
        public boolean a(CharSequence charSequence) {
            return f.v(charSequence, this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements n {
        public final /* synthetic */ String a;

        public g(String str) {
            this.a = str;
        }

        @Override // k.b.a.a.n.n.f.n
        public boolean a(CharSequence charSequence) {
            return f.h(charSequence, this.a);
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements n {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public h(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // k.b.a.a.n.n.f.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() == 1 && f.d(this.a, charSequence.charAt(0)) == this.b;
        }
    }

    /* loaded from: classes4.dex */
    public static class i implements n {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public i(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // k.b.a.a.n.n.f.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() > 0 && f.d(this.a, charSequence.charAt(0)) == this.b;
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements n {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public j(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // k.b.a.a.n.n.f.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() > 0 && f.d(this.a, charSequence.charAt(charSequence.length() - 1)) == this.b;
        }
    }

    /* loaded from: classes4.dex */
    public interface l {
        Iterable<k> a();
    }

    /* loaded from: classes4.dex */
    public static final class m implements l {
        private final List<k> a;

        public m(List<k> list) {
            this.a = list;
        }

        @Override // k.b.a.a.n.n.f.l
        /* renamed from: b */
        public List<k> a() {
            return this.a;
        }
    }

    /* loaded from: classes4.dex */
    public interface n {
        boolean a(CharSequence charSequence);
    }

    static {
        NameType[] values;
        RuleType[] values2;
        for (NameType nameType : NameType.values()) {
            EnumMap enumMap = new EnumMap(RuleType.class);
            for (RuleType ruleType : RuleType.values()) {
                HashMap hashMap = new HashMap();
                for (String str : k.b.a.a.n.n.c.b(nameType).c()) {
                    try {
                        Scanner g2 = g(nameType, ruleType, str);
                        hashMap.put(str, s(g2, e(nameType, ruleType, str)));
                        if (g2 != null) {
                            g2.close();
                        }
                    } catch (IllegalStateException e2) {
                        throw new IllegalStateException("Problem processing " + e(nameType, ruleType, str), e2);
                    }
                }
                if (!ruleType.equals(RuleType.RULES)) {
                    Scanner g3 = g(nameType, ruleType, "common");
                    try {
                        hashMap.put("common", s(g3, e(nameType, ruleType, "common")));
                        if (g3 != null) {
                            g3.close();
                        }
                    } finally {
                    }
                }
                enumMap.put((EnumMap) ruleType, (RuleType) Collections.unmodifiableMap(hashMap));
            }
            f16217i.put(nameType, Collections.unmodifiableMap(enumMap));
        }
    }

    public f(String str, String str2, String str3, l lVar) {
        this.b = str;
        this.a = t(str2 + "$");
        this.f16219d = t("^" + str3);
        this.f16218c = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(CharSequence charSequence, char c2) {
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (charSequence.charAt(i2) == c2) {
                return true;
            }
        }
        return false;
    }

    private static String e(NameType nameType, RuleType ruleType, String str) {
        return String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", nameType.getName(), ruleType.getName(), str);
    }

    private static Scanner f(String str) {
        return new Scanner(k.b.a.a.g.a(String.format("org/apache/commons/codec/language/bm/%s.txt", str)), "UTF-8");
    }

    private static Scanner g(NameType nameType, RuleType ruleType, String str) {
        return new Scanner(k.b.a.a.g.a(e(nameType, ruleType, str)), "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        int length = charSequence.length() - 1;
        for (int length2 = charSequence2.length() - 1; length2 >= 0; length2--) {
            if (charSequence.charAt(length) != charSequence2.charAt(length2)) {
                return false;
            }
            length--;
        }
        return true;
    }

    public static List<f> i(NameType nameType, RuleType ruleType, String str) {
        return j(nameType, ruleType, c.AbstractC0487c.b(new HashSet(Arrays.asList(str))));
    }

    public static List<f> j(NameType nameType, RuleType ruleType, c.AbstractC0487c abstractC0487c) {
        Map<String, List<f>> l2 = l(nameType, ruleType, abstractC0487c);
        ArrayList arrayList = new ArrayList();
        for (List<f> list : l2.values()) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public static Map<String, List<f>> k(NameType nameType, RuleType ruleType, String str) {
        Map<String, List<f>> map = f16217i.get(nameType).get(ruleType).get(str);
        if (map != null) {
            return map;
        }
        throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", nameType.getName(), ruleType.getName(), str));
    }

    public static Map<String, List<f>> l(NameType nameType, RuleType ruleType, c.AbstractC0487c abstractC0487c) {
        return abstractC0487c.e() ? k(nameType, ruleType, abstractC0487c.c()) : k(nameType, ruleType, k.b.a.a.n.n.c.b);
    }

    private static k q(String str) {
        int indexOf = str.indexOf("[");
        if (indexOf >= 0) {
            if (str.endsWith("]")) {
                return new k(str.substring(0, indexOf), c.AbstractC0487c.b(new HashSet(Arrays.asList(str.substring(indexOf + 1, str.length() - 1).split("[+]")))));
            }
            throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
        }
        return new k(str, k.b.a.a.n.n.c.f16201e);
    }

    private static l r(String str) {
        if (str.startsWith("(")) {
            if (str.endsWith(")")) {
                ArrayList arrayList = new ArrayList();
                String substring = str.substring(1, str.length() - 1);
                for (String str2 : substring.split("[|]")) {
                    arrayList.add(q(str2));
                }
                if (substring.startsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) || substring.endsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                    arrayList.add(new k("", k.b.a.a.n.n.c.f16201e));
                }
                return new m(arrayList);
            }
            throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
        }
        return q(str);
    }

    private static Map<String, List<f>> s(Scanner scanner, String str) {
        String str2;
        String w;
        String w2;
        String w3;
        HashMap hashMap = new HashMap();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (scanner.hasNextLine()) {
            int i4 = i3 + 1;
            String nextLine = scanner.nextLine();
            if (z) {
                if (nextLine.endsWith(k.b.a.a.n.n.e.f16211c)) {
                    z = false;
                    i3 = i4;
                    i2 = 0;
                }
                i3 = i4;
                i2 = 0;
            } else {
                if (nextLine.startsWith(k.b.a.a.n.n.e.f16212d)) {
                    z = true;
                } else {
                    int indexOf = nextLine.indexOf(k.b.a.a.n.n.e.a);
                    String trim = (indexOf >= 0 ? nextLine.substring(i2, indexOf) : nextLine).trim();
                    if (trim.length() == 0) {
                        i3 = i4;
                    } else if (trim.startsWith(f16216h)) {
                        String trim2 = trim.substring(8).trim();
                        if (!trim2.contains(ExpandableTextView.N)) {
                            Scanner f2 = f(trim2);
                            try {
                                hashMap.putAll(s(f2, str + "->" + trim2));
                                if (f2 != null) {
                                    f2.close();
                                }
                            } finally {
                            }
                        } else {
                            throw new IllegalArgumentException("Malformed import statement '" + nextLine + "' in " + str);
                        }
                    } else {
                        String[] split = trim.split("\\s+");
                        if (split.length == 4) {
                            try {
                                w = w(split[i2]);
                                w2 = w(split[1]);
                                w3 = w(split[2]);
                                str2 = "' in ";
                            } catch (IllegalArgumentException e2) {
                                e = e2;
                                str2 = "' in ";
                            }
                            try {
                                c cVar = new c(w, w2, w3, r(w(split[3])), i4, str, w, w2, w3);
                                String substring = ((f) cVar).b.substring(0, 1);
                                List list = (List) hashMap.get(substring);
                                if (list == null) {
                                    list = new ArrayList();
                                    hashMap.put(substring, list);
                                }
                                list.add(cVar);
                            } catch (IllegalArgumentException e3) {
                                e = e3;
                                throw new IllegalStateException("Problem parsing line '" + i4 + str2 + str, e);
                            }
                        } else {
                            throw new IllegalArgumentException("Malformed rule statement split into " + split.length + " parts: " + nextLine + " in " + str);
                        }
                    }
                }
                i3 = i4;
                i2 = 0;
            }
        }
        return hashMap;
    }

    private static n t(String str) {
        boolean startsWith = str.startsWith("^");
        boolean endsWith = str.endsWith("$");
        int length = str.length();
        if (endsWith) {
            length--;
        }
        String substring = str.substring(startsWith ? 1 : 0, length);
        if (substring.contains("[")) {
            boolean startsWith2 = substring.startsWith("[");
            boolean endsWith2 = substring.endsWith("]");
            if (startsWith2 && endsWith2) {
                String substring2 = substring.substring(1, substring.length() - 1);
                if (!substring2.contains("[")) {
                    boolean startsWith3 = substring2.startsWith("^");
                    if (startsWith3) {
                        substring2 = substring2.substring(1);
                    }
                    boolean z = !startsWith3;
                    if (startsWith && endsWith) {
                        return new h(substring2, z);
                    }
                    if (startsWith) {
                        return new i(substring2, z);
                    }
                    if (endsWith) {
                        return new j(substring2, z);
                    }
                }
            }
        } else if (startsWith && endsWith) {
            if (substring.length() == 0) {
                return new d();
            }
            return new e(substring);
        } else if ((startsWith || endsWith) && substring.length() == 0) {
            return f16213e;
        } else {
            if (startsWith) {
                return new C0488f(substring);
            }
            if (endsWith) {
                return new g(substring);
            }
        }
        return new a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        for (int i2 = 0; i2 < charSequence2.length(); i2++) {
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    private static String w(String str) {
        if (str.startsWith(f16215g)) {
            str = str.substring(1);
        }
        return str.endsWith(f16215g) ? str.substring(0, str.length() - 1) : str;
    }

    public n m() {
        return this.a;
    }

    public String n() {
        return this.b;
    }

    public l o() {
        return this.f16218c;
    }

    public n p() {
        return this.f16219d;
    }

    public boolean u(CharSequence charSequence, int i2) {
        if (i2 >= 0) {
            int length = this.b.length() + i2;
            if (length <= charSequence.length() && charSequence.subSequence(i2, length).equals(this.b) && this.f16219d.a(charSequence.subSequence(length, charSequence.length()))) {
                return this.a.a(charSequence.subSequence(0, i2));
            }
            return false;
        }
        throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
    }

    /* loaded from: classes4.dex */
    public static final class k implements l {

        /* renamed from: c  reason: collision with root package name */
        public static final Comparator<k> f16224c = new a();
        private final StringBuilder a;
        private final c.AbstractC0487c b;

        /* loaded from: classes4.dex */
        public static class a implements Comparator<k> {
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(k kVar, k kVar2) {
                for (int i2 = 0; i2 < kVar.a.length(); i2++) {
                    if (i2 >= kVar2.a.length()) {
                        return 1;
                    }
                    int charAt = kVar.a.charAt(i2) - kVar2.a.charAt(i2);
                    if (charAt != 0) {
                        return charAt;
                    }
                }
                return kVar.a.length() < kVar2.a.length() ? -1 : 0;
            }
        }

        public k(CharSequence charSequence, c.AbstractC0487c abstractC0487c) {
            this.a = new StringBuilder(charSequence);
            this.b = abstractC0487c;
        }

        @Override // k.b.a.a.n.n.f.l
        public Iterable<k> a() {
            return Collections.singleton(this);
        }

        public k c(CharSequence charSequence) {
            this.a.append(charSequence);
            return this;
        }

        public c.AbstractC0487c d() {
            return this.b;
        }

        public CharSequence e() {
            return this.a;
        }

        @Deprecated
        public k f(k kVar) {
            return new k(this.a.toString() + kVar.a.toString(), this.b.g(kVar.b));
        }

        public k g(c.AbstractC0487c abstractC0487c) {
            return new k(this.a.toString(), this.b.f(abstractC0487c));
        }

        public String toString() {
            return this.a.toString() + "[" + this.b + "]";
        }

        public k(k kVar, k kVar2) {
            this(kVar.a, kVar.b);
            this.a.append((CharSequence) kVar2.a);
        }

        public k(k kVar, k kVar2, c.AbstractC0487c abstractC0487c) {
            this(kVar.a, abstractC0487c);
            this.a.append((CharSequence) kVar2.a);
        }
    }
}
