package bykvm_19do.bykvm_19do.bykvm_19do;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a2 extends t1 {

    /* renamed from: f */
    private static final long[] f72f = {com.heytap.mcssdk.constant.a.f3314d};

    /* renamed from: d */
    private long f73d;

    /* renamed from: e */
    private long f74e;

    public a2(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean a() {
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long b() {
        long Q = this.a.c().Q();
        if (Q > com.heytap.mcssdk.constant.a.f3314d || Q <= 0) {
            Q = 60000;
        }
        f72f[0] = Q;
        return Q + this.f73d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long[] c() {
        return f72f;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() {
        z a;
        if (System.currentTimeMillis() > this.f74e + this.a.c().Q()) {
            JSONObject b = this.a.d().b();
            b2 e2 = this.a.e();
            if (e2 != null && b != null && (a = e2.a()) != null) {
                this.a.b().a(b, a, e2.b());
                this.f74e = System.currentTimeMillis();
            }
        }
        ArrayList<a0> a2 = this.a.b().a();
        ArrayList<a0> arrayList = new ArrayList<>(a2.size());
        ArrayList<a0> arrayList2 = new ArrayList<>(a2.size());
        v1 v1Var = this.a;
        String[] a3 = t.a(v1Var, v1Var.a(), this.a.d().a());
        Iterator<a0> it = a2.iterator();
        while (it.hasNext()) {
            a0 next = it.next();
            int a4 = s.a(a3, next.f67i, this.a.c());
            if (a4 == 200) {
                arrayList.add(next);
            } else {
                next.f69k = a4;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.a.b().a(arrayList, arrayList2);
        }
        l0.d(e() + arrayList.size() + ExpandableTextView.N + a2.size(), null);
        if (arrayList.size() == a2.size()) {
            this.f73d = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public String e() {
        return "s";
    }
}
