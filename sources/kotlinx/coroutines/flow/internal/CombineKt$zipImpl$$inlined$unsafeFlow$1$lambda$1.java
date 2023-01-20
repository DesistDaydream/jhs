package kotlinx.coroutines.flow.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.l;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import i.b.t3.c0;
import i.b.t3.w;
import i.b.t3.y;
import i.b.v3.c0.n;
import i.b.v3.f;
import i.b.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T1", "T2", "R", "Li/b/n0;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ f $this_unsafeFlow;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    private n0 p$;
    public final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1 this$0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T1", "T2", "R", "Li/b/t3/w;", "", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$second$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<w<? super Object>, c<? super t1>, Object> {
        public Object L$0;
        public Object L$1;
        public int label;
        private w p$;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$second$1$invokeSuspend$$inlined$collect$1"}, k = 1, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1$a */
        /* loaded from: classes4.dex */
        public static final class a implements f<T2> {
            public final /* synthetic */ w a;

            public a(w wVar) {
                this.a = wVar;
            }

            @Override // i.b.v3.f
            @e
            public Object emit(Object obj, @d c cVar) {
                c0 channel = this.a.getChannel();
                if (obj == null) {
                    obj = n.a;
                }
                Object N = channel.N(obj, cVar);
                return N == b.h() ? N : t1.a;
            }
        }

        public AnonymousClass1(c cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @d
        public final c<t1> create(@e Object obj, @d c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(cVar);
            anonymousClass1.p$ = (w) obj;
            return anonymousClass1;
        }

        @Override // h.k2.u.p
        public final Object invoke(w<? super Object> wVar, c<? super t1> cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@d Object obj) {
            Object h2 = b.h();
            int i2 = this.label;
            if (i2 == 0) {
                r0.n(obj);
                w wVar = this.p$;
                Flow flow = CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this.this$0.a;
                a aVar = new a(wVar);
                this.L$0 = wVar;
                this.L$1 = flow;
                this.label = 1;
                if (flow.e(aVar, this) == h2) {
                    return h2;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Flow flow2 = (Flow) this.L$1;
                w wVar2 = (w) this.L$0;
                r0.n(obj);
            }
            return t1.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T1", "T2", "R", "", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Throwable;)V", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Throwable, t1> {
        public final /* synthetic */ z $collectJob;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(z zVar) {
            super(1);
            this.$collectJob = zVar;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
            invoke2(th);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e Throwable th) {
            if (this.$collectJob.j()) {
                this.$collectJob.b(new AbortFlowException(CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this.$this_unsafeFlow));
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T1", "T2", "R", "Lh/t1;", AdvanceSetting.NETWORK_TYPE, "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements p<t1, c<? super t1>, Object> {
        public final /* synthetic */ Object $cnt;
        public final /* synthetic */ CoroutineContext $scopeContext;
        public final /* synthetic */ y $second;
        public Object L$0;
        public Object L$1;
        public int label;
        private t1 p$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(CoroutineContext coroutineContext, Object obj, y yVar, c cVar) {
            super(2, cVar);
            this.$scopeContext = coroutineContext;
            this.$cnt = obj;
            this.$second = yVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @d
        public final c<t1> create(@e Object obj, @d c<?> cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$scopeContext, this.$cnt, this.$second, cVar);
            anonymousClass3.p$0 = (t1) obj;
            return anonymousClass3;
        }

        @Override // h.k2.u.p
        public final Object invoke(t1 t1Var, c<? super t1> cVar) {
            return ((AnonymousClass3) create(t1Var, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@d Object obj) {
            Object h2 = b.h();
            int i2 = this.label;
            if (i2 == 0) {
                r0.n(obj);
                t1 t1Var = this.p$0;
                Flow flow = CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this.this$0.b;
                Object obj2 = new f<T1>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$.inlined.unsafeFlow.1.lambda.1.3.1

                    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T1", "T2", "R", "Lh/t1;", AdvanceSetting.NETWORK_TYPE, "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$invokeSuspend$$inlined$collect$1$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
                    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1$1  reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes4.dex */
                    public static final class C05031 extends SuspendLambda implements p<t1, c<? super t1>, Object> {
                        public final /* synthetic */ Object $value;
                        public Object L$0;
                        public Object L$1;
                        public Object L$2;
                        public int label;
                        private t1 p$0;
                        public final /* synthetic */ AnonymousClass1 this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C05031(Object obj, c cVar, AnonymousClass1 anonymousClass1) {
                            super(2, cVar);
                            this.$value = obj;
                            this.this$0 = anonymousClass1;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @d
                        public final c<t1> create(@e Object obj, @d c<?> cVar) {
                            C05031 c05031 = new C05031(this.$value, cVar, this.this$0);
                            c05031.p$0 = (t1) obj;
                            return c05031;
                        }

                        @Override // h.k2.u.p
                        public final Object invoke(t1 t1Var, c<? super t1> cVar) {
                            return ((C05031) create(t1Var, cVar)).invokeSuspend(t1.a);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:27:0x0094 A[RETURN] */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @k.e.a.e
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r9) {
                            /*
                                r8 = this;
                                java.lang.Object r0 = h.e2.j.b.h()
                                int r1 = r8.label
                                r2 = 3
                                r3 = 2
                                r4 = 1
                                if (r1 == 0) goto L39
                                if (r1 == r4) goto L30
                                if (r1 == r3) goto L22
                                if (r1 != r2) goto L1a
                                java.lang.Object r0 = r8.L$0
                                h.t1 r0 = (h.t1) r0
                                h.r0.n(r9)
                                goto L95
                            L1a:
                                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r9.<init>(r0)
                                throw r9
                            L22:
                                java.lang.Object r1 = r8.L$2
                                i.b.v3.f r1 = (i.b.v3.f) r1
                                java.lang.Object r3 = r8.L$1
                                java.lang.Object r4 = r8.L$0
                                h.t1 r4 = (h.t1) r4
                                h.r0.n(r9)
                                goto L88
                            L30:
                                java.lang.Object r1 = r8.L$0
                                h.t1 r1 = (h.t1) r1
                                h.r0.n(r9)
                                r4 = r1
                                goto L51
                            L39:
                                h.r0.n(r9)
                                h.t1 r9 = r8.p$0
                                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1 r1 = r8.this$0
                                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3 r1 = kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.AnonymousClass3.this
                                i.b.t3.y r1 = r1.$second
                                r8.L$0 = r9
                                r8.label = r4
                                java.lang.Object r1 = i.b.t3.o.F1(r1, r8)
                                if (r1 != r0) goto L4f
                                return r0
                            L4f:
                                r4 = r9
                                r9 = r1
                            L51:
                                if (r9 == 0) goto L98
                                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1 r1 = r8.this$0
                                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3 r1 = kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.AnonymousClass3.this
                                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r1 = kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this
                                i.b.v3.f r5 = r1.$this_unsafeFlow
                                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1 r1 = r1.this$0
                                h.k2.u.q r1 = r1.f16979c
                                java.lang.Object r6 = r8.$value
                                i.b.w3.i0 r7 = i.b.v3.c0.n.a
                                if (r9 != r7) goto L67
                                r7 = 0
                                goto L68
                            L67:
                                r7 = r9
                            L68:
                                r8.L$0 = r4
                                r8.L$1 = r9
                                r8.L$2 = r5
                                r8.label = r3
                                r3 = 6
                                h.k2.v.c0.e(r3)
                                h.k2.v.c0.e(r3)
                                java.lang.Object r1 = r1.invoke(r6, r7, r8)
                                r3 = 7
                                h.k2.v.c0.e(r3)
                                h.k2.v.c0.e(r3)
                                if (r1 != r0) goto L85
                                return r0
                            L85:
                                r3 = r9
                                r9 = r1
                                r1 = r5
                            L88:
                                r8.L$0 = r4
                                r8.L$1 = r3
                                r8.label = r2
                                java.lang.Object r9 = r1.emit(r9, r8)
                                if (r9 != r0) goto L95
                                return r0
                            L95:
                                h.t1 r9 = h.t1.a
                                return r9
                            L98:
                                kotlinx.coroutines.flow.internal.AbortFlowException r9 = new kotlinx.coroutines.flow.internal.AbortFlowException
                                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1 r0 = r8.this$0
                                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3 r0 = kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.AnonymousClass3.this
                                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r0 = kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this
                                i.b.v3.f r0 = r0.$this_unsafeFlow
                                r9.<init>(r0)
                                throw r9
                            */
                            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.AnonymousClass3.AnonymousClass1.C05031.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    @Override // i.b.v3.f
                    @e
                    public Object emit(Object obj3, @d c cVar) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        CoroutineContext coroutineContext = anonymousClass3.$scopeContext;
                        t1 t1Var2 = t1.a;
                        Object c2 = i.b.v3.c0.e.c(coroutineContext, t1Var2, anonymousClass3.$cnt, new C05031(obj3, null, this), cVar);
                        return c2 == b.h() ? c2 : t1Var2;
                    }
                };
                this.L$0 = t1Var;
                this.L$1 = flow;
                this.label = 1;
                if (flow.e(obj2, this) == h2) {
                    return h2;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Flow flow2 = (Flow) this.L$1;
                t1 t1Var2 = (t1) this.L$0;
                r0.n(obj);
            }
            return t1.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(f fVar, c cVar, CombineKt$zipImpl$$inlined$unsafeFlow$1 combineKt$zipImpl$$inlined$unsafeFlow$1) {
        super(2, cVar);
        this.$this_unsafeFlow = fVar;
        this.this$0 = combineKt$zipImpl$$inlined$unsafeFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.$this_unsafeFlow, cVar, this.this$0);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.p$ = (n0) obj;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(n0 n0Var, c<? super t1> cVar) {
        return ((CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a0, code lost:
        if (r1.f() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a2, code lost:
        i.b.t3.y.a.b(r1, null, 1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
        if (r1.f() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b9, code lost:
        return h.t1.a;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [i.b.t3.y] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r21) {
        /*
            r20 = this;
            r8 = r20
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r8.label
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L32
            if (r1 != r9) goto L2a
            java.lang.Object r0 = r8.L$3
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            java.lang.Object r0 = r8.L$2
            i.b.z r0 = (i.b.z) r0
            java.lang.Object r0 = r8.L$1
            r1 = r0
            i.b.t3.y r1 = (i.b.t3.y) r1
            java.lang.Object r0 = r8.L$0
            i.b.n0 r0 = (i.b.n0) r0
            h.r0.n(r21)     // Catch: java.lang.Throwable -> L24 kotlinx.coroutines.flow.internal.AbortFlowException -> L27
            goto L9c
        L24:
            r0 = move-exception
            goto Lba
        L27:
            r0 = move-exception
            goto Lab
        L2a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L32:
            h.r0.n(r21)
            i.b.n0 r11 = r8.p$
            r3 = 0
            r4 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1 r5 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1
            r5.<init>(r10)
            r6 = 3
            r7 = 0
            r2 = r11
            i.b.t3.y r12 = kotlinx.coroutines.channels.ProduceKt.f(r2, r3, r4, r5, r6, r7)
            i.b.z r7 = i.b.e2.d(r10, r9, r10)
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>"
            java.util.Objects.requireNonNull(r12, r1)
            r1 = r12
            i.b.t3.c0 r1 = (i.b.t3.c0) r1
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$2 r2 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$2
            r2.<init>(r7)
            r1.x(r2)
            kotlin.coroutines.CoroutineContext r13 = r11.getCoroutineContext()     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            java.lang.Object r14 = kotlinx.coroutines.internal.ThreadContextKt.b(r13)     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            kotlin.coroutines.CoroutineContext r1 = r11.getCoroutineContext()     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            kotlin.coroutines.CoroutineContext r15 = r1.plus(r7)     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            h.t1 r16 = h.t1.a     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r17 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3 r18 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r6 = 0
            r1 = r18
            r2 = r20
            r3 = r13
            r4 = r14
            r5 = r12
            r1.<init>(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r6 = 4
            r19 = 0
            r8.L$0 = r11     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r8.L$1 = r12     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r8.L$2 = r7     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r8.L$3 = r13     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r8.L$4 = r14     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r8.label = r9     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r20
            r7 = r19
            java.lang.Object r1 = i.b.v3.c0.e.d(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La6 kotlinx.coroutines.flow.internal.AbortFlowException -> La9
            if (r1 != r0) goto L9b
            return r0
        L9b:
            r1 = r12
        L9c:
            boolean r0 = r1.f()
            if (r0 != 0) goto Lb7
        La2:
            i.b.t3.y.a.b(r1, r10, r9, r10)
            goto Lb7
        La6:
            r0 = move-exception
            r1 = r12
            goto Lba
        La9:
            r0 = move-exception
            r1 = r12
        Lab:
            i.b.v3.f r2 = r8.$this_unsafeFlow     // Catch: java.lang.Throwable -> L24
            i.b.v3.c0.i.b(r0, r2)     // Catch: java.lang.Throwable -> L24
            boolean r0 = r1.f()
            if (r0 != 0) goto Lb7
            goto La2
        Lb7:
            h.t1 r0 = h.t1.a
            return r0
        Lba:
            boolean r2 = r1.f()
            if (r2 != 0) goto Lc3
            i.b.t3.y.a.b(r1, r10, r9, r10)
        Lc3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
