package com.eth.adapter;

import com.eth.model.NetException;
import com.umeng.analytics.pro.am;
import com.vector.ext.AnyKt;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n;
import i.b.o;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l.r;

@d(c = "com.eth.adapter.FlowCallAdapter$adapt$1", f = "FlowCallAdapter.kt", i = {}, l = {52, 25}, m = "invokeSuspend", n = {}, s = {})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FlowCallAdapter$adapt$1 extends SuspendLambda implements p<f<? super R>, c<? super t1>, Object> {
    public final /* synthetic */ l.d<R> $call;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, d2 = {"com/eth/adapter/FlowCallAdapter$adapt$1$1$1", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", am.aI, "", "onResponse", "response", "Lretrofit2/Response;", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class a implements l.f<R> {
        public final /* synthetic */ n<R> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(n<? super R> nVar) {
            this.a = nVar;
        }

        @Override // l.f
        public void onFailure(@k.e.a.d l.d<R> dVar, @k.e.a.d Throwable th) {
            c cVar = this.a;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }

        @Override // l.f
        public void onResponse(@k.e.a.d l.d<R> dVar, @k.e.a.d r<R> rVar) {
            if (rVar.g()) {
                c cVar = this.a;
                Object I = AnyKt.I(rVar.a(), "data is null");
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m106constructorimpl(I));
                return;
            }
            c cVar2 = this.a;
            NetException netException = new NetException(String.valueOf(rVar.b()), String.valueOf(rVar.e()));
            Result.a aVar2 = Result.Companion;
            cVar2.resumeWith(Result.m106constructorimpl(r0.a(netException)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowCallAdapter$adapt$1(l.d<R> dVar, c<? super FlowCallAdapter$adapt$1> cVar) {
        super(2, cVar);
        this.$call = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        FlowCallAdapter$adapt$1 flowCallAdapter$adapt$1 = new FlowCallAdapter$adapt$1(this.$call, cVar);
        flowCallAdapter$adapt$1.L$0 = obj;
        return flowCallAdapter$adapt$1;
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@k.e.a.d f<? super R> fVar, @e c<? super t1> cVar) {
        return ((FlowCallAdapter$adapt$1) create(fVar, cVar)).invokeSuspend(t1.a);
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
            l.d<R> dVar = this.$call;
            this.L$0 = dVar;
            this.L$1 = fVar;
            this.label = 1;
            o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(this), 1);
            oVar.G();
            dVar.i(new a(oVar));
            oVar.p(new FlowCallAdapter$adapt$1$1$2(dVar));
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
            l.d dVar2 = (l.d) this.L$0;
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
