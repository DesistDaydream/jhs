package k.b.a.a.n.n;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import k.b.a.a.n.l;
import k.b.a.a.n.n.c;
import k.b.a.a.n.n.f;
import org.apache.commons.codec.language.bm.NameType;
import org.apache.commons.codec.language.bm.RuleType;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    private static final Map<NameType, Set<String>> f16202f;

    /* renamed from: g  reason: collision with root package name */
    private static final int f16203g = 20;
    private final k.b.a.a.n.n.b a;
    private final NameType b;

    /* renamed from: c  reason: collision with root package name */
    private final RuleType f16204c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f16205d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16206e;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NameType.values().length];
            a = iArr;
            try {
                iArr[NameType.SEPHARDIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NameType.ASHKENAZI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NameType.GENERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        private final Set<f.k> a;

        public /* synthetic */ b(Set set, a aVar) {
            this(set);
        }

        public static b c(c.AbstractC0487c abstractC0487c) {
            return new b(new f.k("", abstractC0487c));
        }

        public void a(CharSequence charSequence) {
            for (f.k kVar : this.a) {
                kVar.c(charSequence);
            }
        }

        public void b(f.l lVar, int i2) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(i2);
            loop0: for (f.k kVar : this.a) {
                for (f.k kVar2 : lVar.a()) {
                    c.AbstractC0487c g2 = kVar.d().g(kVar2.d());
                    if (!g2.d()) {
                        f.k kVar3 = new f.k(kVar, kVar2, g2);
                        if (linkedHashSet.size() < i2) {
                            linkedHashSet.add(kVar3);
                            if (linkedHashSet.size() >= i2) {
                                break loop0;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            this.a.clear();
            this.a.addAll(linkedHashSet);
        }

        public Set<f.k> d() {
            return this.a;
        }

        public String e() {
            StringBuilder sb = new StringBuilder();
            for (f.k kVar : this.a) {
                if (sb.length() > 0) {
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                }
                sb.append(kVar.e());
            }
            return sb.toString();
        }

        private b(f.k kVar) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.a = linkedHashSet;
            linkedHashSet.add(kVar);
        }

        private b(Set<f.k> set) {
            this.a = set;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        private final Map<String, List<f>> a;
        private final CharSequence b;

        /* renamed from: c  reason: collision with root package name */
        private final b f16207c;

        /* renamed from: d  reason: collision with root package name */
        private int f16208d;

        /* renamed from: e  reason: collision with root package name */
        private final int f16209e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f16210f;

        public c(Map<String, List<f>> map, CharSequence charSequence, b bVar, int i2, int i3) {
            Objects.requireNonNull(map, "finalRules");
            this.a = map;
            this.f16207c = bVar;
            this.b = charSequence;
            this.f16208d = i2;
            this.f16209e = i3;
        }

        public int a() {
            return this.f16208d;
        }

        public b b() {
            return this.f16207c;
        }

        public c c() {
            int i2;
            this.f16210f = false;
            Map<String, List<f>> map = this.a;
            CharSequence charSequence = this.b;
            int i3 = this.f16208d;
            List<f> list = map.get(charSequence.subSequence(i3, i3 + 1));
            if (list != null) {
                Iterator<f> it = list.iterator();
                i2 = 1;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f next = it.next();
                    int length = next.n().length();
                    if (next.u(this.b, this.f16208d)) {
                        this.f16207c.b(next.o(), this.f16209e);
                        this.f16210f = true;
                        i2 = length;
                        break;
                    }
                    i2 = length;
                }
            } else {
                i2 = 1;
            }
            this.f16208d += this.f16210f ? i2 : 1;
            return this;
        }

        public boolean d() {
            return this.f16210f;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(NameType.class);
        f16202f = enumMap;
        enumMap.put((EnumMap) NameType.ASHKENAZI, (NameType) Collections.unmodifiableSet(new HashSet(Arrays.asList("bar", "ben", "da", "de", "van", "von"))));
        enumMap.put((EnumMap) NameType.SEPHARDIC, (NameType) Collections.unmodifiableSet(new HashSet(Arrays.asList("al", "el", "da", "dal", "de", "del", "dela", "de la", "della", "des", AppIconSetting.DEFAULT_LARGE_ICON, "do", "dos", com.umeng.analytics.pro.d.W, "van", "von"))));
        enumMap.put((EnumMap) NameType.GENERIC, (NameType) Collections.unmodifiableSet(new HashSet(Arrays.asList("da", "dal", "de", "del", "dela", "de la", "della", "des", AppIconSetting.DEFAULT_LARGE_ICON, "do", "dos", com.umeng.analytics.pro.d.W, "van", "von"))));
    }

    public d(NameType nameType, RuleType ruleType, boolean z) {
        this(nameType, ruleType, z, 20);
    }

    private b a(b bVar, Map<String, List<f>> map) {
        Objects.requireNonNull(map, "finalRules");
        if (map.isEmpty()) {
            return bVar;
        }
        TreeMap treeMap = new TreeMap(f.k.f16224c);
        for (f.k kVar : bVar.d()) {
            b c2 = b.c(kVar.d());
            String charSequence = kVar.e().toString();
            b bVar2 = c2;
            int i2 = 0;
            while (i2 < charSequence.length()) {
                c c3 = new c(map, charSequence, bVar2, i2, this.f16206e).c();
                boolean d2 = c3.d();
                bVar2 = c3.b();
                if (!d2) {
                    bVar2.a(charSequence.subSequence(i2, i2 + 1));
                }
                i2 = c3.a();
            }
            for (f.k kVar2 : bVar2.d()) {
                if (treeMap.containsKey(kVar2)) {
                    f.k g2 = ((f.k) treeMap.remove(kVar2)).g(kVar2.d());
                    treeMap.put(g2, g2);
                } else {
                    treeMap.put(kVar2, kVar2);
                }
            }
        }
        return new b(treeMap.keySet(), null);
    }

    private static String i(Iterable<String> iterable, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    public String b(String str) {
        return c(str, this.a.b(str));
    }

    public String c(String str, c.AbstractC0487c abstractC0487c) {
        String str2;
        String substring;
        String substring2;
        Map<String, List<f>> l2 = f.l(this.b, RuleType.RULES, abstractC0487c);
        Map<String, List<f>> k2 = f.k(this.b, this.f16204c, "common");
        Map<String, List<f>> l3 = f.l(this.b, this.f16204c, abstractC0487c);
        String trim = str.toLowerCase(Locale.ENGLISH).replace(l.f16189d, ' ').trim();
        if (this.b == NameType.GENERIC) {
            if (trim.length() >= 2 && trim.substring(0, 2).equals("d'")) {
                String str3 = e.j.a.b.c.f.f10128d + trim.substring(2);
                return "(" + b(substring2) + ")-(" + b(str3) + ")";
            }
            for (String str4 : f16202f.get(this.b)) {
                if (trim.startsWith(str4 + ExpandableTextView.N)) {
                    String str5 = str4 + trim.substring(str4.length() + 1);
                    return "(" + b(substring) + ")-(" + b(str5) + ")";
                }
            }
        }
        List<String> asList = Arrays.asList(trim.split("\\s+"));
        ArrayList<String> arrayList = new ArrayList();
        int i2 = a.a[this.b.ordinal()];
        if (i2 == 1) {
            for (String str6 : asList) {
                String[] split = str6.split("'");
                arrayList.add(split[split.length - 1]);
            }
            arrayList.removeAll(f16202f.get(this.b));
        } else if (i2 == 2) {
            arrayList.addAll(asList);
            arrayList.removeAll(f16202f.get(this.b));
        } else if (i2 == 3) {
            arrayList.addAll(asList);
        } else {
            throw new IllegalStateException("Unreachable case: " + this.b);
        }
        if (this.f16205d) {
            str2 = i(arrayList, ExpandableTextView.N);
        } else if (arrayList.size() == 1) {
            str2 = (String) asList.iterator().next();
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str7 : arrayList) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(b(str7));
            }
            return sb.substring(1);
        }
        b c2 = b.c(abstractC0487c);
        int i3 = 0;
        while (i3 < str2.length()) {
            c c3 = new c(l2, str2, c2, i3, this.f16206e).c();
            i3 = c3.a();
            c2 = c3.b();
        }
        return a(a(c2, k2), l3).e();
    }

    public k.b.a.a.n.n.b d() {
        return this.a;
    }

    public int e() {
        return this.f16206e;
    }

    public NameType f() {
        return this.b;
    }

    public RuleType g() {
        return this.f16204c;
    }

    public boolean h() {
        return this.f16205d;
    }

    public d(NameType nameType, RuleType ruleType, boolean z, int i2) {
        RuleType ruleType2 = RuleType.RULES;
        if (ruleType != ruleType2) {
            this.b = nameType;
            this.f16204c = ruleType;
            this.f16205d = z;
            this.a = k.b.a.a.n.n.b.c(nameType);
            this.f16206e = i2;
            return;
        }
        throw new IllegalArgumentException("ruleType must not be " + ruleType2);
    }
}
