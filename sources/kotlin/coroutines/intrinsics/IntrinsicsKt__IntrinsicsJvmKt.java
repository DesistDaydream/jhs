package kotlin.coroutines.intrinsics;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qiniu.android.collect.ReportItem;
import h.e2.c;
import h.e2.k.a.f;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.u.q;
import h.k2.v.t0;
import h.r0;
import h.s0;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0083\b¢\u0006\u0002\b\b\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001an\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0014\"\u0004\b\u0002\u0010\u0003*)\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0006\u0010\u0016\u001a\u0002H\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", ExifInterface.GPS_DIRECTION_TRUE, "completion", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", RemoteMessageConst.MessageBody.PARAM, "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* loaded from: classes3.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    @s0(version = "1.3")
    private static final <T> c<t1> a(final c<? super T> cVar, final l<? super c<? super T>, ? extends Object> lVar) {
        final CoroutineContext context = cVar.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            return new RestrictedContinuationImpl(cVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @e
                public Object invokeSuspend(@d Object obj) {
                    int i2 = this.label;
                    if (i2 == 0) {
                        this.label = 1;
                        r0.n(obj);
                        return lVar.invoke(this);
                    } else if (i2 == 1) {
                        this.label = 2;
                        r0.n(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        return new ContinuationImpl(cVar, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
            private int label;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @e
            public Object invokeSuspend(@d Object obj) {
                int i2 = this.label;
                if (i2 == 0) {
                    this.label = 1;
                    r0.n(obj);
                    return lVar.invoke(this);
                } else if (i2 == 1) {
                    this.label = 2;
                    r0.n(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
            }
        };
    }

    @s0(version = "1.3")
    @d
    public static final <T> c<t1> b(@d final l<? super c<? super T>, ? extends Object> lVar, @d c<? super T> cVar) {
        c<t1> cVar2;
        final c<?> a = f.a(cVar);
        if (lVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) lVar).create(a);
        }
        final CoroutineContext context = a.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            Objects.requireNonNull(a, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            cVar2 = new RestrictedContinuationImpl(a) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @e
                public Object invokeSuspend(@d Object obj) {
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.label = 2;
                            r0.n(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    r0.n(obj);
                    l lVar2 = lVar;
                    Objects.requireNonNull(lVar2, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    return ((l) t0.q(lVar2, 1)).invoke(this);
                }
            };
        } else {
            Objects.requireNonNull(a, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            cVar2 = new ContinuationImpl(a, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @e
                public Object invokeSuspend(@d Object obj) {
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.label = 2;
                            r0.n(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    r0.n(obj);
                    l lVar2 = lVar;
                    Objects.requireNonNull(lVar2, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    return ((l) t0.q(lVar2, 1)).invoke(this);
                }
            };
        }
        return cVar2;
    }

    @s0(version = "1.3")
    @d
    public static final <R, T> c<t1> c(@d final p<? super R, ? super c<? super T>, ? extends Object> pVar, final R r, @d c<? super T> cVar) {
        c<t1> cVar2;
        final c<?> a = f.a(cVar);
        if (pVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) pVar).create(r, a);
        }
        final CoroutineContext context = a.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            Objects.requireNonNull(a, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            cVar2 = new RestrictedContinuationImpl(a) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @e
                public Object invokeSuspend(@d Object obj) {
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.label = 2;
                            r0.n(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    r0.n(obj);
                    p pVar2 = pVar;
                    Objects.requireNonNull(pVar2, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    return ((p) t0.q(pVar2, 2)).invoke(r, this);
                }
            };
        } else {
            Objects.requireNonNull(a, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            cVar2 = new ContinuationImpl(a, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @e
                public Object invokeSuspend(@d Object obj) {
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.label = 2;
                            r0.n(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    r0.n(obj);
                    p pVar2 = pVar;
                    Objects.requireNonNull(pVar2, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    return ((p) t0.q(pVar2, 2)).invoke(r, this);
                }
            };
        }
        return cVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s0(version = "1.3")
    @d
    public static final <T> c<T> d(@d c<? super T> cVar) {
        c<T> cVar2;
        ContinuationImpl continuationImpl = !(cVar instanceof ContinuationImpl) ? null : cVar;
        return (continuationImpl == null || (cVar2 = (c<T>) continuationImpl.intercepted()) == null) ? cVar : cVar2;
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <T> Object e(l<? super c<? super T>, ? extends Object> lVar, c<? super T> cVar) {
        Objects.requireNonNull(lVar, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        return ((l) t0.q(lVar, 1)).invoke(cVar);
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <R, T> Object f(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r, c<? super T> cVar) {
        Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        return ((p) t0.q(pVar, 2)).invoke(r, cVar);
    }

    @h.g2.f
    private static final <R, P, T> Object g(q<? super R, ? super P, ? super c<? super T>, ? extends Object> qVar, R r, P p, c<? super T> cVar) {
        Objects.requireNonNull(qVar, "null cannot be cast to non-null type (R, P, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        return ((q) t0.q(qVar, 3)).invoke(r, p, cVar);
    }
}
