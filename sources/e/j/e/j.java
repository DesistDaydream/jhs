package e.j.e;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class j extends h {
    private final LinkedTreeMap<String, h> a = new LinkedTreeMap<>();

    public void B(String str, h hVar) {
        LinkedTreeMap<String, h> linkedTreeMap = this.a;
        if (hVar == null) {
            hVar = i.a;
        }
        linkedTreeMap.put(str, hVar);
    }

    public void C(String str, Boolean bool) {
        B(str, bool == null ? i.a : new l(bool));
    }

    public void D(String str, Character ch) {
        B(str, ch == null ? i.a : new l(ch));
    }

    public void E(String str, Number number) {
        B(str, number == null ? i.a : new l(number));
    }

    public void F(String str, String str2) {
        B(str, str2 == null ? i.a : new l(str2));
    }

    @Override // e.j.e.h
    /* renamed from: G */
    public j a() {
        j jVar = new j();
        for (Map.Entry<String, h> entry : this.a.entrySet()) {
            jVar.B(entry.getKey(), entry.getValue().a());
        }
        return jVar;
    }

    public Set<Map.Entry<String, h>> H() {
        return this.a.entrySet();
    }

    public h I(String str) {
        return this.a.get(str);
    }

    public e J(String str) {
        return (e) this.a.get(str);
    }

    public j K(String str) {
        return (j) this.a.get(str);
    }

    public l L(String str) {
        return (l) this.a.get(str);
    }

    public boolean M(String str) {
        return this.a.containsKey(str);
    }

    public Set<String> N() {
        return this.a.keySet();
    }

    public h O(String str) {
        return this.a.remove(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof j) && ((j) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public int size() {
        return this.a.size();
    }
}
