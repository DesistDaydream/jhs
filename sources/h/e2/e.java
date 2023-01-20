package h.e2;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.c0;
import h.r0;
import h.s0;
import h.t1;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a?\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00012\u001a\b\u0004\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\f\u0012\u0004\u0012\u00020\r0\u000bH\u0087\bø\u0001\u0000ø\u0001\u0001\u001a@\u0010\u000e\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u001a\b\u0004\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0004\u0012\u00020\r0\u000bH\u0087Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0010\u001aD\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0007\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0007\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\b*#\b\u0001\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016¢\u0006\u0002\b\u00172\u0006\u0010\u0018\u001a\u0002H\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a&\u0010\u001a\u001a\u00020\r\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00072\u0006\u0010\u001b\u001a\u0002H\bH\u0087\b¢\u0006\u0002\u0010\u001c\u001a!\u0010\u001d\u001a\u00020\r\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0087\b\u001a>\u0010 \u001a\u00020\r\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010!\u001aW\u0010 \u001a\u00020\r\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\b*#\b\u0001\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016¢\u0006\u0002\b\u00172\u0006\u0010\u0018\u001a\u0002H\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\"\"\u001b\u0010\u0000\u001a\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Continuation", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "context", "resumeWith", "Lkotlin/Function1;", "Lkotlin/Result;", "", "suspendCoroutine", ReportItem.LogTypeBlock, "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCoroutine", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resume", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeWithException", "exception", "", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class e {

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a implements c<T> {
        public final /* synthetic */ CoroutineContext a;
        public final /* synthetic */ l b;

        public a(CoroutineContext coroutineContext, l lVar) {
            this.a = coroutineContext;
            this.b = lVar;
        }

        @Override // h.e2.c
        @k.e.a.d
        public CoroutineContext getContext() {
            return this.a;
        }

        @Override // h.e2.c
        public void resumeWith(@k.e.a.d Object obj) {
            this.b.invoke(Result.m105boximpl(obj));
        }
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <T> c<T> a(CoroutineContext coroutineContext, l<? super Result<? extends T>, t1> lVar) {
        return new a(coroutineContext, lVar);
    }

    @s0(version = "1.3")
    @k.e.a.d
    public static final <T> c<t1> b(@k.e.a.d l<? super c<? super T>, ? extends Object> lVar, @k.e.a.d c<? super T> cVar) {
        return new h(IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.b(lVar, cVar)), h.e2.j.b.h());
    }

    @s0(version = "1.3")
    @k.e.a.d
    public static final <R, T> c<t1> c(@k.e.a.d p<? super R, ? super c<? super T>, ? extends Object> pVar, R r, @k.e.a.d c<? super T> cVar) {
        return new h(IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.c(pVar, r, cVar)), h.e2.j.b.h());
    }

    private static final CoroutineContext d() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    @h.g2.f
    @s0(version = "1.3")
    public static /* synthetic */ void e() {
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <T> void f(c<? super T> cVar, T t) {
        Result.a aVar = Result.Companion;
        cVar.resumeWith(Result.m106constructorimpl(t));
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <T> void g(c<? super T> cVar, Throwable th) {
        Result.a aVar = Result.Companion;
        cVar.resumeWith(Result.m106constructorimpl(r0.a(th)));
    }

    @s0(version = "1.3")
    public static final <T> void h(@k.e.a.d l<? super c<? super T>, ? extends Object> lVar, @k.e.a.d c<? super T> cVar) {
        c d2 = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.b(lVar, cVar));
        t1 t1Var = t1.a;
        Result.a aVar = Result.Companion;
        d2.resumeWith(Result.m106constructorimpl(t1Var));
    }

    @s0(version = "1.3")
    public static final <R, T> void i(@k.e.a.d p<? super R, ? super c<? super T>, ? extends Object> pVar, R r, @k.e.a.d c<? super T> cVar) {
        c d2 = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.c(pVar, r, cVar));
        t1 t1Var = t1.a;
        Result.a aVar = Result.Companion;
        d2.resumeWith(Result.m106constructorimpl(t1Var));
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <T> Object j(l<? super c<? super T>, t1> lVar, c<? super T> cVar) {
        c0.e(0);
        h hVar = new h(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        lVar.invoke(hVar);
        Object b = hVar.b();
        if (b == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        c0.e(1);
        return b;
    }
}
