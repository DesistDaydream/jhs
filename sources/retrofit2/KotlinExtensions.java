package retrofit2;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.k2.g;
import h.k2.v.f0;
import h.r0;
import i.b.n;
import i.b.o;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import l.k;
import l.r;

@g(name = "KotlinExtensions")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0087@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a)\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00060\u000bj\u0002`\fH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ll/s;", f.f10128d, "(Ll/s;)Ljava/lang/Object;", "", "Ll/d;", am.av, "(Ll/d;Lh/e2/c;)Ljava/lang/Object;", "b", "Ll/r;", "c", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", e.a, "(Ljava/lang/Exception;Lh/e2/c;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class KotlinExtensions {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"retrofit2/KotlinExtensions$a", "Ll/f;", "Ll/d;", "call", "Ll/r;", "response", "Lh/t1;", "onResponse", "(Ll/d;Ll/r;)V", "", am.aI, "onFailure", "(Ll/d;Ljava/lang/Throwable;)V", "retrofit"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements l.f<T> {
        public final /* synthetic */ n a;

        public a(n nVar) {
            this.a = nVar;
        }

        @Override // l.f
        public void onFailure(@k.e.a.d l.d<T> dVar, @k.e.a.d Throwable th) {
            n nVar = this.a;
            Result.a aVar = Result.Companion;
            nVar.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }

        @Override // l.f
        public void onResponse(@k.e.a.d l.d<T> dVar, @k.e.a.d r<T> rVar) {
            if (rVar.g()) {
                Object a = rVar.a();
                if (a == null) {
                    Object tag = dVar.request().tag(k.class);
                    if (tag == null) {
                        f0.L();
                    }
                    Method b = ((k) tag).b();
                    KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + b.getDeclaringClass().getName() + '.' + b.getName() + " was null but response body type was declared as non-null");
                    n nVar = this.a;
                    Result.a aVar = Result.Companion;
                    nVar.resumeWith(Result.m106constructorimpl(r0.a(kotlinNullPointerException)));
                    return;
                }
                n nVar2 = this.a;
                Result.a aVar2 = Result.Companion;
                nVar2.resumeWith(Result.m106constructorimpl(a));
                return;
            }
            n nVar3 = this.a;
            HttpException httpException = new HttpException(rVar);
            Result.a aVar3 = Result.Companion;
            nVar3.resumeWith(Result.m106constructorimpl(r0.a(httpException)));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J/\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"retrofit2/KotlinExtensions$b", "Ll/f;", "Ll/d;", "call", "Ll/r;", "response", "Lh/t1;", "onResponse", "(Ll/d;Ll/r;)V", "", am.aI, "onFailure", "(Ll/d;Ljava/lang/Throwable;)V", "retrofit"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b implements l.f<T> {
        public final /* synthetic */ n a;

        public b(n nVar) {
            this.a = nVar;
        }

        @Override // l.f
        public void onFailure(@k.e.a.d l.d<T> dVar, @k.e.a.d Throwable th) {
            n nVar = this.a;
            Result.a aVar = Result.Companion;
            nVar.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }

        @Override // l.f
        public void onResponse(@k.e.a.d l.d<T> dVar, @k.e.a.d r<T> rVar) {
            if (rVar.g()) {
                n nVar = this.a;
                Object a = rVar.a();
                Result.a aVar = Result.Companion;
                nVar.resumeWith(Result.m106constructorimpl(a));
                return;
            }
            n nVar2 = this.a;
            HttpException httpException = new HttpException(rVar);
            Result.a aVar2 = Result.Companion;
            nVar2.resumeWith(Result.m106constructorimpl(r0.a(httpException)));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"retrofit2/KotlinExtensions$c", "Ll/f;", "Ll/d;", "call", "Ll/r;", "response", "Lh/t1;", "onResponse", "(Ll/d;Ll/r;)V", "", am.aI, "onFailure", "(Ll/d;Ljava/lang/Throwable;)V", "retrofit"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c implements l.f<T> {
        public final /* synthetic */ n a;

        public c(n nVar) {
            this.a = nVar;
        }

        @Override // l.f
        public void onFailure(@k.e.a.d l.d<T> dVar, @k.e.a.d Throwable th) {
            n nVar = this.a;
            Result.a aVar = Result.Companion;
            nVar.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }

        @Override // l.f
        public void onResponse(@k.e.a.d l.d<T> dVar, @k.e.a.d r<T> rVar) {
            n nVar = this.a;
            Result.a aVar = Result.Companion;
            nVar.resumeWith(Result.m106constructorimpl(rVar));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lh/t1;", "run", "()V", "retrofit2/KotlinExtensions$suspendAndThrow$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class d implements Runnable {
        public final /* synthetic */ h.e2.c a;
        public final /* synthetic */ Exception b;

        public d(h.e2.c cVar, Exception exc) {
            this.a = cVar;
            this.b = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.e2.c d2 = IntrinsicsKt__IntrinsicsJvmKt.d(this.a);
            Exception exc = this.b;
            Result.a aVar = Result.Companion;
            d2.resumeWith(Result.m106constructorimpl(r0.a(exc)));
        }
    }

    @k.e.a.e
    public static final <T> Object a(@k.e.a.d l.d<T> dVar, @k.e.a.d h.e2.c<? super T> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.p(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(dVar));
        dVar.i(new a(oVar));
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    @g(name = "awaitNullable")
    @k.e.a.e
    public static final <T> Object b(@k.e.a.d l.d<T> dVar, @k.e.a.d h.e2.c<? super T> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.p(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(dVar));
        dVar.i(new b(oVar));
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    @k.e.a.e
    public static final <T> Object c(@k.e.a.d l.d<T> dVar, @k.e.a.d h.e2.c<? super r<T>> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.p(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(dVar));
        dVar.i(new c(oVar));
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object e(@k.e.a.d java.lang.Exception r4, @k.e.a.d h.e2.c<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            h.r0.n(r5)
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            h.r0.n(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.CoroutineDispatcher r5 = i.b.b1.a()
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            retrofit2.KotlinExtensions$d r3 = new retrofit2.KotlinExtensions$d
            r3.<init>(r0, r4)
            r5.dispatch(r2, r3)
            java.lang.Object r4 = h.e2.j.b.h()
            java.lang.Object r5 = h.e2.j.b.h()
            if (r4 != r5) goto L59
            h.e2.k.a.f.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            h.t1 r4 = h.t1.a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.e(java.lang.Exception, h.e2.c):java.lang.Object");
    }
}
