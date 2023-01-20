package k.b.a.a.n.n;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import k.b.a.a.g;
import org.apache.commons.codec.language.bm.NameType;

/* loaded from: classes4.dex */
public class c {
    public static final String b = "any";

    /* renamed from: c  reason: collision with root package name */
    private static final Map<NameType, c> f16199c = new EnumMap(NameType.class);

    /* renamed from: d  reason: collision with root package name */
    public static final AbstractC0487c f16200d;

    /* renamed from: e  reason: collision with root package name */
    public static final AbstractC0487c f16201e;
    private final Set<String> a;

    /* loaded from: classes4.dex */
    public static class a extends AbstractC0487c {
        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public boolean a(String str) {
            return false;
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public String c() {
            throw new NoSuchElementException("Can't fetch any language from the empty language set.");
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public boolean d() {
            return true;
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public boolean e() {
            return false;
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public AbstractC0487c f(AbstractC0487c abstractC0487c) {
            return abstractC0487c;
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public AbstractC0487c g(AbstractC0487c abstractC0487c) {
            return this;
        }

        public String toString() {
            return "NO_LANGUAGES";
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends AbstractC0487c {
        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public boolean a(String str) {
            return true;
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public String c() {
            throw new NoSuchElementException("Can't fetch any language from the any language set.");
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public boolean d() {
            return false;
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public boolean e() {
            return false;
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public AbstractC0487c f(AbstractC0487c abstractC0487c) {
            return abstractC0487c;
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public AbstractC0487c g(AbstractC0487c abstractC0487c) {
            return abstractC0487c;
        }

        public String toString() {
            return "ANY_LANGUAGE";
        }
    }

    /* renamed from: k.b.a.a.n.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC0487c {
        public static AbstractC0487c b(Set<String> set) {
            return set.isEmpty() ? c.f16200d : new d(set, null);
        }

        public abstract boolean a(String str);

        public abstract String c();

        public abstract boolean d();

        public abstract boolean e();

        public abstract AbstractC0487c f(AbstractC0487c abstractC0487c);

        public abstract AbstractC0487c g(AbstractC0487c abstractC0487c);
    }

    /* loaded from: classes4.dex */
    public static final class d extends AbstractC0487c {
        private final Set<String> a;

        public /* synthetic */ d(Set set, a aVar) {
            this(set);
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public boolean a(String str) {
            return this.a.contains(str);
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public String c() {
            return this.a.iterator().next();
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public boolean d() {
            return this.a.isEmpty();
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public boolean e() {
            return this.a.size() == 1;
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public AbstractC0487c f(AbstractC0487c abstractC0487c) {
            if (abstractC0487c == c.f16200d) {
                return this;
            }
            if (abstractC0487c == c.f16201e) {
                return abstractC0487c;
            }
            HashSet hashSet = new HashSet(this.a);
            for (String str : ((d) abstractC0487c).a) {
                hashSet.add(str);
            }
            return AbstractC0487c.b(hashSet);
        }

        @Override // k.b.a.a.n.n.c.AbstractC0487c
        public AbstractC0487c g(AbstractC0487c abstractC0487c) {
            if (abstractC0487c == c.f16200d) {
                return abstractC0487c;
            }
            if (abstractC0487c == c.f16201e) {
                return this;
            }
            d dVar = (d) abstractC0487c;
            HashSet hashSet = new HashSet(Math.min(this.a.size(), dVar.a.size()));
            for (String str : this.a) {
                if (dVar.a.contains(str)) {
                    hashSet.add(str);
                }
            }
            return AbstractC0487c.b(hashSet);
        }

        public Set<String> h() {
            return this.a;
        }

        public String toString() {
            return "Languages(" + this.a.toString() + ")";
        }

        private d(Set<String> set) {
            this.a = Collections.unmodifiableSet(set);
        }
    }

    static {
        NameType[] values;
        for (NameType nameType : NameType.values()) {
            f16199c.put(nameType, a(d(nameType)));
        }
        f16200d = new a();
        f16201e = new b();
    }

    private c(Set<String> set) {
        this.a = set;
    }

    public static c a(String str) {
        HashSet hashSet = new HashSet();
        Scanner scanner = new Scanner(g.a(str), "UTF-8");
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                try {
                    String trim = scanner.nextLine().trim();
                    if (z) {
                        if (trim.endsWith(e.f16211c)) {
                            break;
                        }
                    } else if (trim.startsWith(e.f16212d)) {
                        z = true;
                    } else if (trim.length() > 0) {
                        hashSet.add(trim);
                    }
                } finally {
                }
            }
            c cVar = new c(Collections.unmodifiableSet(hashSet));
            scanner.close();
            return cVar;
        }
    }

    public static c b(NameType nameType) {
        return f16199c.get(nameType);
    }

    private static String d(NameType nameType) {
        return String.format("org/apache/commons/codec/language/bm/%s_languages.txt", nameType.getName());
    }

    public Set<String> c() {
        return this.a;
    }
}
