package e.t.o;

import com.vector.config.FitConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/vector/fitter/FullScreenDpComputerImpl;", "Lcom/vector/fitter/ScaleDpComputer;", "()V", "scale", "", "getScale$vector_release", "()F", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class g extends i {
    private final float a;

    public g() {
        float e2;
        float d2;
        e.t.q.b bVar = e.t.q.b.a;
        if (bVar.e() > bVar.b()) {
            FitConfig fitConfig = FitConfig.a;
            e2 = bVar.e() / fitConfig.b();
            float b = bVar.b() / fitConfig.e();
            e2 = e2 >= b ? b : e2;
            d2 = fitConfig.d();
        } else {
            FitConfig fitConfig2 = FitConfig.a;
            e2 = bVar.e() / fitConfig2.e();
            float b2 = bVar.b() / fitConfig2.b();
            e2 = e2 >= b2 ? b2 : e2;
            d2 = fitConfig2.d();
        }
        this.a = d2 * e2;
    }

    @Override // e.t.o.i
    public float e() {
        return this.a;
    }
}
