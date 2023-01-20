package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class h {
    private Map<String, g> a;
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.c<g> b;

    /* loaded from: classes.dex */
    public static class b {
        private static h a = new h();
    }

    static {
        String str = "TTMediationSDK_" + h.class.getSimpleName();
    }

    private h() {
        this.b = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
        this.a = new ConcurrentHashMap();
    }

    public static h a() {
        return b.a;
    }

    public void a(g gVar) {
        e eVar;
        g b2 = gVar.h() ? b(gVar.d(), gVar.c()) : b(gVar.d());
        if (b2 == null) {
            if (this.b != null) {
                Map<String, g> map = this.a;
                if (map != null) {
                    map.put(gVar.g(), gVar);
                }
                this.b.a((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.c<g>) gVar);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        for (e eVar2 : b2.i()) {
            hashMap.put(eVar2.d(), eVar2);
        }
        for (e eVar3 : gVar.i()) {
            if (hashMap.containsKey(eVar3.d()) && (eVar = (e) hashMap.get(eVar3.d())) != null) {
                eVar3.a(eVar);
            }
        }
        Map<String, g> map2 = this.a;
        if (map2 != null) {
            map2.put(gVar.g(), gVar);
        }
        b(gVar);
    }

    public void a(g gVar, String str, int i2) {
        if (this.b != null) {
            gVar.a(str, i2);
            Map<String, g> map = this.a;
            if (map != null) {
                map.put(gVar.g(), gVar);
            }
            this.b.b((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.c<g>) gVar);
        }
    }

    public void a(g gVar, String str, long j2) {
        if (this.b != null) {
            gVar.a(str, j2);
            Map<String, g> map = this.a;
            if (map != null) {
                map.put(gVar.g(), gVar);
            }
            this.b.b((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.c<g>) gVar);
        }
    }

    public void a(String str) {
        if (this.b != null) {
            Map<String, g> map = this.a;
            if (map != null) {
                map.remove(str);
            }
            this.b.a(str);
        }
    }

    public void a(String str, String str2) {
        if (this.b != null) {
            Map<String, g> map = this.a;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.b.a(str, str2);
        }
    }

    public g b(String str) {
        if (this.b != null) {
            Map<String, g> map = this.a;
            g gVar = map != null ? map.get(str) : null;
            if (gVar != null) {
                return gVar;
            }
            g b2 = this.b.b(str);
            if (b2 != null) {
                Map<String, g> map2 = this.a;
                if (map2 != null) {
                    map2.put(b2.g(), b2);
                }
                return b2;
            }
            return null;
        }
        return null;
    }

    public g b(String str, String str2) {
        g gVar;
        if (this.b != null) {
            Map<String, g> map = this.a;
            if (map != null) {
                gVar = map.get(str + "_" + str2);
            } else {
                gVar = null;
            }
            if (gVar != null) {
                return gVar;
            }
            g b2 = this.b.b(str, str2);
            if (b2 != null) {
                Map<String, g> map2 = this.a;
                if (map2 != null) {
                    map2.put(b2.g(), b2);
                }
                return b2;
            }
            return null;
        }
        return null;
    }

    public void b(g gVar) {
        if (this.b != null) {
            Map<String, g> map = this.a;
            if (map != null) {
                map.put(gVar.g(), gVar);
            }
            this.b.b((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.c<g>) gVar);
        }
    }
}
