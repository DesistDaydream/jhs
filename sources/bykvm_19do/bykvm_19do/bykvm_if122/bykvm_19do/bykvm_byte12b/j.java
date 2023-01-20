package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class j {
    private Map<String, i> a;
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.e<i> b;

    /* loaded from: classes.dex */
    public static class b {
        private static j a = new j();
    }

    static {
        String str = "TTMediationSDK_" + j.class.getSimpleName();
    }

    private j() {
        this.b = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.f(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
        this.a = new ConcurrentHashMap();
    }

    public static j a() {
        return b.a;
    }

    public void a(i iVar) {
        if (this.b == null || TextUtils.isEmpty(iVar.j())) {
            return;
        }
        Map<String, i> map = this.a;
        if (map != null) {
            map.put(iVar.g(), iVar);
        }
        this.b.a((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.e<i>) iVar);
    }

    public void a(String str) {
        if (this.b != null) {
            Map<String, i> map = this.a;
            if (map != null) {
                map.remove(str);
            }
            this.b.a(str);
        }
    }

    public void a(String str, long j2) {
        if (this.b != null) {
            Map<String, i> map = this.a;
            i iVar = map != null ? map.get(str) : null;
            if (iVar != null) {
                iVar.a(j2);
            }
            this.b.a(str, j2);
        }
    }

    public void a(String str, String str2) {
        if (this.b != null) {
            Map<String, i> map = this.a;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.b.a(str, str2);
        }
    }

    public void a(String str, String str2, long j2) {
        if (this.b != null) {
            i iVar = null;
            Map<String, i> map = this.a;
            if (map != null) {
                iVar = map.get(str + "_" + str2);
            }
            if (iVar != null) {
                iVar.a(j2);
            }
            this.b.a(str, str2, j2);
        }
    }

    public i b(String str) {
        if (this.b != null) {
            Map<String, i> map = this.a;
            r1 = map != null ? map.get(str) : null;
            if (r1 == null && (r1 = this.b.b(str)) != null) {
                this.a.put(r1.d(), r1);
            }
        }
        return r1;
    }

    public i b(String str, String str2) {
        i iVar = null;
        if (this.b != null) {
            Map<String, i> map = this.a;
            if (map != null) {
                iVar = map.get(str + "_" + str2);
            }
            if (iVar == null && (iVar = this.b.b(str, str2)) != null) {
                this.a.put(iVar.g(), iVar);
            }
        }
        return iVar;
    }
}
