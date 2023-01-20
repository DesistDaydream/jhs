package e.l.n.d;

import com.jihuanshe.model.NetCode;
import com.jihuanshe.model.NetResponse;
import e.t.l.x;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import l.f;
import l.r;

/* loaded from: classes2.dex */
public abstract class a<T> implements f<NetResponse<T>> {
    private final boolean a;

    public a() {
        this(false, 1, null);
    }

    public a(boolean z) {
        this.a = z;
    }

    public void a(boolean z, @d String str, @d String str2) {
        if (this.a) {
            x.f(str2, 0, 2, null);
        }
    }

    public abstract void b(@e T t);

    @Override // l.f
    public void onFailure(@d l.d<NetResponse<T>> dVar, @d Throwable th) {
        a(false, NetCode.CODE_NO_SERVER_FAIL, th.getLocalizedMessage());
    }

    @Override // l.f
    public void onResponse(@d l.d<NetResponse<T>> dVar, @d r<NetResponse<T>> rVar) {
        if (rVar.g() && rVar.a() != null) {
            NetResponse<T> a = rVar.a();
            if (a == null) {
                return;
            }
            if (a.isSuccessful()) {
                b(a.getData());
                return;
            } else {
                a(true, a.getCode(), a.getMessage());
                return;
            }
        }
        a(false, String.valueOf(rVar.b()), rVar.h());
    }

    public /* synthetic */ a(boolean z, int i2, u uVar) {
        this((i2 & 1) != 0 ? false : z);
    }
}
