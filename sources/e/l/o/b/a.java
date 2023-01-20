package e.l.o.b;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.Product;
import e.l.h.i.b;
import e.l.h.i.e;
import e.l.n.c.k;
import e.l.n.c.r;
import k.e.a.d;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class a {
    @d
    public static final a a = new a();

    private a() {
    }

    @d
    public final Flow<Result<b<e<Product>>>> a(@d String str, @k.e.a.e String str2, @k.e.a.e String str3, @k.e.a.e String str4, int i2) {
        return ((k) e.l.n.a.d(k.class, false, true, true, 60L, true)).q0(str, str2, i2, str3, str4);
    }

    @d
    public final Flow<Result<e<Product>>> b(@k.e.a.e String str, @d String str2, @k.e.a.e String str3, @k.e.a.e String str4, @k.e.a.e String str5, int i2) {
        return ((r) e.l.n.a.d(r.class, false, false, false, 60L, true)).a(str, str2, str3, str4, str5, i2);
    }
}
