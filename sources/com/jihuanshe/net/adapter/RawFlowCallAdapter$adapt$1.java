package com.jihuanshe.net.adapter;

import com.eth.model.NetException;
import com.jihuanshe.R;
import com.vector.util.Res;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.o;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l.d;
import l.r;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* loaded from: classes2.dex */
public final class RawFlowCallAdapter$adapt$1 extends SuspendLambda implements p<f<? super D>, c<? super t1>, Object> {
    public final /* synthetic */ d<D> $call;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawFlowCallAdapter$adapt$1(d<D> dVar, c<? super RawFlowCallAdapter$adapt$1> cVar) {
        super(2, cVar);
        this.$call = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        RawFlowCallAdapter$adapt$1 rawFlowCallAdapter$adapt$1 = new RawFlowCallAdapter$adapt$1(this.$call, cVar);
        rawFlowCallAdapter$adapt$1.L$0 = obj;
        return rawFlowCallAdapter$adapt$1;
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@k.e.a.d f<? super D> fVar, @e c<? super t1> cVar) {
        return ((RawFlowCallAdapter$adapt$1) create(fVar, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        f fVar;
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            fVar = (f) this.L$0;
            d<D> dVar = this.$call;
            this.L$0 = dVar;
            this.L$1 = fVar;
            this.label = 1;
            final o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(this), 1);
            oVar.G();
            dVar.i(new l.f<D>() { // from class: com.jihuanshe.net.adapter.RawFlowCallAdapter$adapt$1$1$1
                @Override // l.f
                public void onFailure(@k.e.a.d d<D> dVar2, @k.e.a.d Throwable th) {
                    e.l.h.k.b bVar = e.l.h.k.b.a;
                    bVar.b(RawFlowCallAdapter.TAG, "onFailure : " + ((Object) th.getMessage()) + ", url = ${call.request()?.url?.toString()");
                    c cVar = oVar;
                    Result.a aVar = Result.Companion;
                    cVar.resumeWith(Result.m106constructorimpl(r0.a(th)));
                }

                @Override // l.f
                public void onResponse(@k.e.a.d d<D> dVar2, @k.e.a.d r<D> rVar) {
                    HttpUrl url;
                    if (!rVar.g()) {
                        e.l.h.k.b bVar = e.l.h.k.b.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("isUnSuccessful, code =  ");
                        sb.append(rVar.b());
                        sb.append(", message = ");
                        sb.append(rVar.i().message());
                        sb.append(", url = ");
                        Request request = dVar2.request();
                        sb.append((Object) ((request == null || (url = request.url()) == null) ? null : url.toString()));
                        bVar.b(RawFlowCallAdapter.TAG, sb.toString());
                        if (rVar.b() == 400) {
                            c cVar = oVar;
                            NetException netException = new NetException(String.valueOf(rVar.b()), Res.w(Res.a, R.string.failed_to_connect_the_internet, null, 2, null));
                            Result.a aVar = Result.Companion;
                            cVar.resumeWith(Result.m106constructorimpl(r0.a(netException)));
                            return;
                        }
                        c cVar2 = oVar;
                        NetException netException2 = new NetException(String.valueOf(rVar.b()), rVar.i().message());
                        Result.a aVar2 = Result.Companion;
                        cVar2.resumeWith(Result.m106constructorimpl(r0.a(netException2)));
                        return;
                    }
                    Object a = rVar.a();
                    if (a instanceof com.jihuanshe.base.model.Result) {
                        com.jihuanshe.base.model.Result result = (com.jihuanshe.base.model.Result) a;
                        result.setHeader(rVar.f());
                        if (!result.isSuccessful()) {
                            c cVar3 = oVar;
                            NetException netException3 = new NetException(String.valueOf(result.getCode()), result.getMsg());
                            Result.a aVar3 = Result.Companion;
                            cVar3.resumeWith(Result.m106constructorimpl(r0.a(netException3)));
                            return;
                        }
                    }
                    c cVar4 = oVar;
                    Result.a aVar4 = Result.Companion;
                    cVar4.resumeWith(Result.m106constructorimpl(a));
                }
            });
            obj = oVar.B();
            if (obj == b.h()) {
                h.e2.k.a.f.c(this);
            }
            if (obj == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r0.n(obj);
            return t1.a;
        } else {
            fVar = (f) this.L$1;
            d dVar2 = (d) this.L$0;
            r0.n(obj);
        }
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (fVar.emit(obj, this) == h2) {
            return h2;
        }
        return t1.a;
    }
}
