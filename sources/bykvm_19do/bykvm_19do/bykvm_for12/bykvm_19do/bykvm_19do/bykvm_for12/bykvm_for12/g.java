package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.IOException;

/* loaded from: classes.dex */
public class g implements t {
    private int a;

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t
    public a0 a(t.a aVar) throws IOException {
        a0 a0Var;
        y b = aVar.b();
        if (h.a().a(this.a).a() != null) {
            h.a().a(this.a).a().e();
        }
        String sVar = b.g().toString();
        String a = h.a().a(this.a).a(sVar);
        if (!sVar.equals(a)) {
            b = b.f().b(a).a();
        }
        try {
            a0Var = aVar.a(b);
        } catch (Exception e2) {
            h.a().a(this.a).a(b, e2);
            a0Var = null;
        }
        h.a().a(this.a).a(b, a0Var);
        return a0Var == null ? aVar.a(b) : a0Var;
    }

    public void a(int i2) {
        this.a = i2;
    }
}
