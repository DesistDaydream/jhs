package h.p2.b0.g.t.i;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class k extends AbstractList<String> implements RandomAccess, l {
    public static final l b = new k().o();
    private final List<Object> a;

    public k() {
        this.a = new ArrayList();
    }

    private static d b(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj instanceof String) {
            return d.g((String) obj);
        }
        return d.e((byte[]) obj);
    }

    private static String d(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            return ((d) obj).z();
        }
        return h.b((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public void add(int i2, String str) {
        this.a.add(i2, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: e */
    public String get(int i2) {
        Object obj = this.a.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String z = dVar.z();
            if (dVar.q()) {
                this.a.set(i2, z);
            }
            return z;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = h.b(bArr);
        if (h.a(bArr)) {
            this.a.set(i2, b2);
        }
        return b2;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f */
    public String remove(int i2) {
        Object remove = this.a.remove(i2);
        ((AbstractList) this).modCount++;
        return d(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g */
    public String set(int i2, String str) {
        return d(this.a.set(i2, str));
    }

    @Override // h.p2.b0.g.t.i.l
    public List<?> j() {
        return Collections.unmodifiableList(this.a);
    }

    @Override // h.p2.b0.g.t.i.l
    public d k(int i2) {
        Object obj = this.a.get(i2);
        d b2 = b(obj);
        if (b2 != obj) {
            this.a.set(i2, b2);
        }
        return b2;
    }

    @Override // h.p2.b0.g.t.i.l
    public void l(d dVar) {
        this.a.add(dVar);
        ((AbstractList) this).modCount++;
    }

    @Override // h.p2.b0.g.t.i.l
    public l o() {
        return new t(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends String> collection) {
        if (collection instanceof l) {
            collection = ((l) collection).j();
        }
        boolean addAll = this.a.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    public k(l lVar) {
        this.a = new ArrayList(lVar.size());
        addAll(lVar);
    }
}
