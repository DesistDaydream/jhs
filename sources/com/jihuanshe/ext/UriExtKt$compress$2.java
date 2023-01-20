package com.jihuanshe.ext;

import com.jihuanshe.R;
import com.vector.util.Res;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* loaded from: classes2.dex */
public final class UriExtKt$compress$2 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    private /* synthetic */ Object L$0;
    public int label;

    public UriExtKt$compress$2(c<? super UriExtKt$compress$2> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        UriExtKt$compress$2 uriExtKt$compress$2 = new UriExtKt$compress$2(cVar);
        uriExtKt$compress$2.L$0 = obj;
        return uriExtKt$compress$2;
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
        return ((UriExtKt$compress$2) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            e.l.h.j.b.e.f((n0) this.L$0, Res.w(Res.a, R.string.error_photo, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            return t1.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
