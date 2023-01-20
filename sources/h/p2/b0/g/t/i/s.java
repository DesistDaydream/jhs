package h.p2.b0.g.t.i;

import h.p2.b0.g.t.i.g;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class s<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int a;
    private List<s<K, V>.c> b;

    /* renamed from: c  reason: collision with root package name */
    private Map<K, V> f15463c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15464d;

    /* renamed from: e  reason: collision with root package name */
    private volatile s<K, V>.e f15465e;

    /* loaded from: classes3.dex */
    public static class a extends s<FieldDescriptorType, Object> {
        public a(int i2) {
            super(i2, null);
        }

        @Override // h.p2.b0.g.t.i.s
        public void o() {
            if (!n()) {
                for (int i2 = 0; i2 < k(); i2++) {
                    Map.Entry<FieldDescriptorType, Object> j2 = j(i2);
                    if (((g.b) j2.getKey()).I()) {
                        j2.setValue(Collections.unmodifiableList((List) j2.getValue()));
                    }
                }
                Iterator it = l().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((g.b) entry.getKey()).I()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.o();
        }

        @Override // h.p2.b0.g.t.i.s, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.put((g.b) obj, obj2);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        private static final Iterator<Object> a = new a();
        private static final Iterable<Object> b = new C0461b();

        /* loaded from: classes3.dex */
        public static class a implements Iterator<Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: h.p2.b0.g.t.i.s$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0461b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.a;
            }
        }

        public static <T> Iterable<T> b() {
            return (Iterable<T>) b;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Comparable<s<K, V>.c>, Map.Entry<K, V> {
        private final K a;
        private V b;

        public c(s sVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean b(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(s<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: d */
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return b(this.a, entry.getKey()) && b(this.b, entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.a;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.b;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            s.this.h();
            V v2 = this.b;
            this.b = v;
            return v2;
        }

        public String toString() {
            String valueOf = String.valueOf(String.valueOf(this.a));
            String valueOf2 = String.valueOf(String.valueOf(this.b));
            StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
            sb.append(valueOf);
            sb.append("=");
            sb.append(valueOf2);
            return sb.toString();
        }

        public c(K k2, V v) {
            this.a = k2;
            this.b = v;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends AbstractSet<Map.Entry<K, V>> {
        private e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            s.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            s.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = s.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(s.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                s.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return s.this.size();
        }

        public /* synthetic */ e(s sVar, a aVar) {
            this();
        }
    }

    public /* synthetic */ s(int i2, a aVar) {
        this(i2);
    }

    private int g(K k2) {
        int size = this.b.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo(this.b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k2.compareTo(this.b.get(i3).getKey());
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f15464d) {
            throw new UnsupportedOperationException();
        }
    }

    private void i() {
        h();
        if (!this.b.isEmpty() || (this.b instanceof ArrayList)) {
            return;
        }
        this.b = new ArrayList(this.a);
    }

    private SortedMap<K, V> m() {
        h();
        if (this.f15463c.isEmpty() && !(this.f15463c instanceof TreeMap)) {
            this.f15463c = new TreeMap();
        }
        return (SortedMap) this.f15463c;
    }

    public static <FieldDescriptorType extends g.b<FieldDescriptorType>> s<FieldDescriptorType, Object> p(int i2) {
        return new a(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V r(int i2) {
        h();
        V value = this.b.remove(i2).getValue();
        if (!this.f15463c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = m().entrySet().iterator();
            this.b.add(new c(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.f15463c.isEmpty()) {
            return;
        }
        this.f15463c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return g(comparable) >= 0 || this.f15463c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f15465e == null) {
            this.f15465e = new e(this, null);
        }
        return this.f15465e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int g2 = g(comparable);
        if (g2 >= 0) {
            return this.b.get(g2).getValue();
        }
        return this.f15463c.get(comparable);
    }

    public Map.Entry<K, V> j(int i2) {
        return this.b.get(i2);
    }

    public int k() {
        return this.b.size();
    }

    public Iterable<Map.Entry<K, V>> l() {
        return this.f15463c.isEmpty() ? b.b() : this.f15463c.entrySet();
    }

    public boolean n() {
        return this.f15464d;
    }

    public void o() {
        if (this.f15464d) {
            return;
        }
        this.f15463c = this.f15463c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f15463c);
        this.f15464d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: q */
    public V put(K k2, V v) {
        h();
        int g2 = g(k2);
        if (g2 >= 0) {
            return this.b.get(g2).setValue(v);
        }
        i();
        int i2 = -(g2 + 1);
        if (i2 >= this.a) {
            return m().put(k2, v);
        }
        int size = this.b.size();
        int i3 = this.a;
        if (size == i3) {
            s<K, V>.c remove = this.b.remove(i3 - 1);
            m().put((K) remove.getKey(), remove.getValue());
        }
        this.b.add(i2, new c(k2, v));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int g2 = g(comparable);
        if (g2 >= 0) {
            return (V) r(g2);
        }
        if (this.f15463c.isEmpty()) {
            return null;
        }
        return this.f15463c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.b.size() + this.f15463c.size();
    }

    /* loaded from: classes3.dex */
    public class d implements Iterator<Map.Entry<K, V>> {
        private int a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f15467c;

        private d() {
            this.a = -1;
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f15467c == null) {
                this.f15467c = s.this.f15463c.entrySet().iterator();
            }
            return this.f15467c;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            this.b = true;
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 < s.this.b.size()) {
                return (Map.Entry) s.this.b.get(this.a);
            }
            return a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a + 1 < s.this.b.size() || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.b) {
                this.b = false;
                s.this.h();
                if (this.a < s.this.b.size()) {
                    s sVar = s.this;
                    int i2 = this.a;
                    this.a = i2 - 1;
                    sVar.r(i2);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        public /* synthetic */ d(s sVar, a aVar) {
            this();
        }
    }

    private s(int i2) {
        this.a = i2;
        this.b = Collections.emptyList();
        this.f15463c = Collections.emptyMap();
    }
}
