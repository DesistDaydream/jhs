package bykvm_19do.bykvm_19do.bykvm_19do;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e0 implements c {
    private static ArrayList<WeakReference<c>> a = new ArrayList<>(4);

    public void a(c cVar) {
        synchronized (this) {
            if (cVar != null) {
                a.add(new WeakReference<>(cVar));
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
    public void a(String str, String str2, String str3) {
        synchronized (this) {
            Iterator<WeakReference<c>> it = a.iterator();
            while (it.hasNext()) {
                c cVar = it.next().get();
                if (cVar == null) {
                    it.remove();
                } else {
                    cVar.a(str, str2, str3);
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
    public void a(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        synchronized (this) {
            Iterator<WeakReference<c>> it = a.iterator();
            while (it.hasNext()) {
                c cVar = it.next().get();
                if (cVar == null) {
                    it.remove();
                } else {
                    cVar.a(z, str, str2, str3, str4, str5, str6);
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
    public void a(boolean z, JSONObject jSONObject) {
        synchronized (this) {
            Iterator<WeakReference<c>> it = a.iterator();
            while (it.hasNext()) {
                c cVar = it.next().get();
                if (cVar == null) {
                    it.remove();
                } else {
                    cVar.a(z, jSONObject);
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
    public void b(boolean z, JSONObject jSONObject) {
        synchronized (this) {
            Iterator<WeakReference<c>> it = a.iterator();
            while (it.hasNext()) {
                c cVar = it.next().get();
                if (cVar == null) {
                    it.remove();
                } else {
                    cVar.b(z, jSONObject);
                }
            }
        }
    }
}
