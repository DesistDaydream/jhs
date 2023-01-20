package com.jihuanshe.viewmodel;

import e.g.e.a;
import e.l.r.i0;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.l;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.b1;
import i.b.g;
import i.b.i;
import i.b.l2;
import i.b.n0;
import i.b.w0;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SplashViewModel$getGlobalConfig$2 extends Lambda implements l<a, t1> {
    public final /* synthetic */ SplashViewModel this$0;

    /* renamed from: com.jihuanshe.viewmodel.SplashViewModel$getGlobalConfig$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
        public int label;
        public final /* synthetic */ SplashViewModel this$0;

        /* renamed from: com.jihuanshe.viewmodel.SplashViewModel$getGlobalConfig$2$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01391 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
            public int label;
            public final /* synthetic */ SplashViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01391(SplashViewModel splashViewModel, c<? super C01391> cVar) {
                super(2, cVar);
                this.this$0 = splashViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @d
            public final c<t1> create(@e Object obj, @d c<?> cVar) {
                return new C01391(this.this$0, cVar);
            }

            @Override // h.k2.u.p
            @e
            public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
                return ((C01391) create(n0Var, cVar)).invokeSuspend(t1.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @e
            public final Object invokeSuspend(@d Object obj) {
                b.h();
                if (this.label == 0) {
                    r0.n(obj);
                    this.this$0.t0().setValue(h.e2.k.a.a.a(true));
                    return t1.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SplashViewModel splashViewModel, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = splashViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @d
        public final c<t1> create(@e Object obj, @d c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // h.k2.u.p
        @e
        public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
            return ((AnonymousClass1) create(n0Var, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@d Object obj) {
            Object h2 = b.h();
            int i2 = this.label;
            if (i2 == 0) {
                r0.n(obj);
                this.label = 1;
                if (w0.b(5000L, this) == h2) {
                    return h2;
                }
            } else if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r0.n(obj);
                return t1.a;
            } else {
                r0.n(obj);
            }
            l2 e2 = b1.e();
            C01391 c01391 = new C01391(this.this$0, null);
            this.label = 2;
            if (g.i(e2, c01391, this) == h2) {
                return h2;
            }
            return t1.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashViewModel$getGlobalConfig$2(SplashViewModel splashViewModel) {
        super(1);
        this.this$0 = splashViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        int i2;
        int i3;
        Boolean bool = Boolean.TRUE;
        if (e.l.m.c.f14093c.q().length() == 0) {
            SplashViewModel splashViewModel = this.this$0;
            i2 = splashViewModel.b;
            splashViewModel.b = i2 - 1;
            i3 = splashViewModel.b;
            if (i3 <= 0) {
                this.this$0.r0().setValue(bool);
                return;
            } else if (!i0.a.e(e.t.a.b())) {
                i.f(i.b.t1.a, null, null, new AnonymousClass1(this.this$0, null), 3, null);
                return;
            } else {
                this.this$0.t0().setValue(bool);
                return;
            }
        }
        this.this$0.u0().setValue(bool);
    }
}
