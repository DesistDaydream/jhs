package e.j.a.b.c.n;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class b extends BasePendingResult<c> {
    private int q;
    private boolean r;
    private boolean s;
    private final k<?>[] t;
    private final Object u;

    /* loaded from: classes2.dex */
    public static final class a {
        private List<k<?>> a = new ArrayList();
        private i b;

        public a(i iVar) {
            this.b = iVar;
        }

        public final <R extends p> d<R> a(k<R> kVar) {
            d<R> dVar = new d<>(this.a.size());
            this.a.add(kVar);
            return dVar;
        }

        public final b b() {
            return new b(this.a, this.b, null);
        }
    }

    private b(List<k<?>> list, i iVar) {
        super(iVar);
        this.u = new Object();
        int size = list.size();
        this.q = size;
        k<?>[] kVarArr = new k[size];
        this.t = kVarArr;
        if (list.isEmpty()) {
            setResult(new c(Status.RESULT_SUCCESS, kVarArr));
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            k<?> kVar = list.get(i2);
            this.t[i2] = kVar;
            kVar.b(new v(this));
        }
    }

    public static /* synthetic */ int y(b bVar) {
        int i2 = bVar.q;
        bVar.q = i2 - 1;
        return i2;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, e.j.a.b.c.n.k
    public final void e() {
        super.e();
        for (k<?> kVar : this.t) {
            kVar.e();
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* renamed from: v */
    public final c k(Status status) {
        return new c(status, this.t);
    }

    public /* synthetic */ b(List list, i iVar, v vVar) {
        this(list, iVar);
    }
}
