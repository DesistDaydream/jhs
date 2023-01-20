package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class i implements g {
    private Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c> b = new HashMap();
    private c0 a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.Q();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c a;

        public a(i iVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.a;
            if (cVar == null || cVar.q() == null) {
                return;
            }
            if (this.a.H()) {
                if (m.b().a(this.a.g())) {
                    m.b().b(this.a.g());
                }
                if (m.b().a(this.a.f())) {
                    m.b().b(this.a.f());
                }
            } else {
                m b = m.b();
                b.e(this.a.q() + "");
                m b2 = m.b();
                b2.d(this.a.q() + "");
            }
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar : this.a.B()) {
                if (jVar.D()) {
                    if (l.b().a(jVar.o())) {
                        l.b().b(jVar.o());
                    }
                    if (k.b().a(jVar.n())) {
                        k.b().b(jVar.n());
                    }
                } else {
                    l b3 = l.b();
                    b3.b(this.a.q() + "", jVar.d());
                    k b4 = k.b();
                    b4.c(this.a.q() + "", jVar.d());
                }
            }
        }
    }

    private void a() {
        String a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(this.a.d("rit_config"), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
        if (a2 == null || TextUtils.isEmpty(a2)) {
            return;
        }
        try {
            b(new JSONArray(a2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar) {
        ThreadHelper.runOnThreadPool(new a(this, cVar));
    }

    private void b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            this.b.clear();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c.b(jSONArray.getJSONObject(i2));
                if (b != null) {
                    this.b.put(b.q(), b);
                    if (b.s() == 3) {
                        hashMap.put(b.q(), b);
                    }
                    a(b);
                }
            }
            b.h().a(hashMap);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public void a(JSONArray jSONArray) {
        b(jSONArray);
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        String b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(jSONArray.toString(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
        if (b != null && !TextUtils.isEmpty(b)) {
            this.a.b("rit_config", b);
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_for12.a.j().a(jSONArray);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.b.get(str) == null) {
            a();
        }
        return this.b.get(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public boolean g() {
        if (this.b.size() == 0) {
            a();
        }
        return this.b.isEmpty();
    }
}
