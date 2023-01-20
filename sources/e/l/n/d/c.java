package e.l.n.d;

import com.jihuanshe.model.NetCode;
import com.jihuanshe.model.NetResponse;
import com.vector.design.ui.activity.SimpleActivityEx;
import com.vector.design.ui.decor.ViewState;
import e.t.l.x;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import l.f;
import l.r;

/* loaded from: classes2.dex */
public abstract class c<T> implements f<NetResponse<T>> {
    @d
    private final SimpleActivityEx a;
    private final boolean b;

    public c(@d SimpleActivityEx simpleActivityEx, boolean z) {
        this.a = simpleActivityEx;
        this.b = z;
        simpleActivityEx.G(ViewState.LOADING);
    }

    public void a(boolean z, @d String str, @d String str2) {
        if (this.b) {
            x.f(str2, 0, 2, null);
        }
        this.a.G(ViewState.ERROR);
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
                this.a.G(ViewState.NORMAL);
                return;
            }
            a(true, a.getCode(), a.getMessage());
            return;
        }
        a(false, String.valueOf(rVar.b()), rVar.h());
    }

    public /* synthetic */ c(SimpleActivityEx simpleActivityEx, boolean z, int i2, u uVar) {
        this(simpleActivityEx, (i2 & 2) != 0 ? false : z);
    }
}
