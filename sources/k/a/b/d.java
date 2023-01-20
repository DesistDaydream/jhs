package k.a.b;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes4.dex */
public class d {
    private final int a;
    private final d b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Character, d> f16028c;

    /* renamed from: d  reason: collision with root package name */
    private d f16029d;

    /* renamed from: e  reason: collision with root package name */
    private Set<String> f16030e;

    public d() {
        this(0);
    }

    private d k(Character ch, boolean z) {
        d dVar;
        d dVar2 = this.f16028c.get(ch);
        return (z || dVar2 != null || (dVar = this.b) == null) ? dVar2 : dVar;
    }

    public void a(String str) {
        if (this.f16030e == null) {
            this.f16030e = new TreeSet();
        }
        this.f16030e.add(str);
    }

    public void b(Collection<String> collection) {
        for (String str : collection) {
            a(str);
        }
    }

    public d c(Character ch) {
        d l2 = l(ch);
        if (l2 == null) {
            d dVar = new d(this.a + 1);
            this.f16028c.put(ch, dVar);
            return dVar;
        }
        return l2;
    }

    public d d(String str) {
        d dVar = this;
        for (char c2 : str.toCharArray()) {
            dVar = dVar.c(Character.valueOf(c2));
        }
        return dVar;
    }

    public Collection<String> e() {
        Set<String> set = this.f16030e;
        return set == null ? Collections.emptyList() : set;
    }

    public d f() {
        return this.f16029d;
    }

    public int g() {
        return this.a;
    }

    public Collection<d> h() {
        return this.f16028c.values();
    }

    public Collection<Character> i() {
        return this.f16028c.keySet();
    }

    public d j(Character ch) {
        return k(ch, false);
    }

    public d l(Character ch) {
        return k(ch, true);
    }

    public void m(d dVar) {
        this.f16029d = dVar;
    }

    public d(int i2) {
        this.f16028c = new HashMap();
        this.a = i2;
        this.b = i2 == 0 ? this : null;
    }
}
