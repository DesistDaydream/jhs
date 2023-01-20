package com.umeng.analytics.pro;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bf;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class bf<T extends bf<?, ?>, F extends bc> implements av<T, F> {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends cc>, cd> f7065c;
    public Object a;
    public F b;

    /* loaded from: classes3.dex */
    public static class a extends ce<bf> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, bf bfVar) throws bb {
            bfVar.b = null;
            bfVar.a = null;
            buVar.j();
            bp l2 = buVar.l();
            Object a = bfVar.a(buVar, l2);
            bfVar.a = a;
            if (a != null) {
                bfVar.b = (F) bfVar.a(l2.f7102c);
            }
            buVar.m();
            buVar.l();
            buVar.k();
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, bf bfVar) throws bb {
            if (bfVar.a() != null && bfVar.b() != null) {
                buVar.a(bfVar.d());
                buVar.a(bfVar.c(bfVar.b));
                bfVar.a(buVar);
                buVar.c();
                buVar.d();
                buVar.b();
                return;
            }
            throw new bv("Cannot write a TUnion with no set value!");
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends cf<bf> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, bf bfVar) throws bb {
            bfVar.b = null;
            bfVar.a = null;
            short v = buVar.v();
            Object a = bfVar.a(buVar, v);
            bfVar.a = a;
            if (a != null) {
                bfVar.b = (F) bfVar.a(v);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, bf bfVar) throws bb {
            if (bfVar.a() != null && bfVar.b() != null) {
                buVar.a(bfVar.b.a());
                bfVar.b(buVar);
                return;
            }
            throw new bv("Cannot write a TUnion with no set value!");
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements cd {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f7065c = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new d());
    }

    public bf() {
        this.b = null;
        this.a = null;
    }

    private static Object a(Object obj) {
        if (obj instanceof av) {
            return ((av) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return aw.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        return obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    public abstract F a(short s);

    public abstract Object a(bu buVar, bp bpVar) throws bb;

    public abstract Object a(bu buVar, short s) throws bb;

    public abstract void a(bu buVar) throws bb;

    public Object b() {
        return this.a;
    }

    public abstract void b(F f2, Object obj) throws ClassCastException;

    public abstract void b(bu buVar) throws bb;

    public abstract bp c(F f2);

    public boolean c() {
        return this.b != null;
    }

    @Override // com.umeng.analytics.pro.av
    public final void clear() {
        this.b = null;
        this.a = null;
    }

    public abstract bz d();

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f7065c.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getClass().getSimpleName());
        sb.append(ExpandableTextView.N);
        if (a() != null) {
            Object b2 = b();
            sb.append(c(a()).a);
            sb.append(Constants.COLON_SEPARATOR);
            if (b2 instanceof ByteBuffer) {
                aw.a((ByteBuffer) b2, sb);
            } else {
                sb.append(b2.toString());
            }
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f7065c.get(buVar.D()).b().a(buVar, this);
    }

    public boolean b(F f2) {
        return this.b == f2;
    }

    public boolean b(int i2) {
        return b((bf<T, F>) a((short) i2));
    }

    public bf(F f2, Object obj) {
        a((bf<T, F>) f2, obj);
    }

    public bf(bf<T, F> bfVar) {
        if (bfVar.getClass().equals(getClass())) {
            this.b = bfVar.b;
            this.a = a(bfVar.a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            hashSet.add(a(obj));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            arrayList.add(a(obj));
        }
        return arrayList;
    }

    public F a() {
        return this.b;
    }

    public Object a(F f2) {
        if (f2 == this.b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f2 + " because union's set field is " + this.b);
    }

    public Object a(int i2) {
        return a((bf<T, F>) a((short) i2));
    }

    public void a(F f2, Object obj) {
        b(f2, obj);
        this.b = f2;
        this.a = obj;
    }

    public void a(int i2, Object obj) {
        a((bf<T, F>) a((short) i2), obj);
    }
}
