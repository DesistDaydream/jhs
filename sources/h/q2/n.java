package h.q2;

import androidx.exifinterface.media.ExifInterface;
import h.r0;
import h.t1;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0096\u0002J\u000e\u0010\u001a\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\r\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0016ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lkotlin/sequences/SequenceBuilderIterator;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", "", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/Continuation;", "setNextStep", "(Lkotlin/coroutines/Continuation;)V", "nextValue", "Ljava/lang/Object;", "state", "", "Lkotlin/sequences/State;", "exceptionalState", "", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "yield", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class n<T> extends o<T> implements Iterator<T>, h.e2.c<t1>, h.k2.v.x0.a {
    private int a;
    private T b;

    /* renamed from: c */
    private Iterator<? extends T> f15659c;
    @k.e.a.e

    /* renamed from: d */
    private h.e2.c<? super t1> f15660d;

    private final Throwable i() {
        int i2 = this.a;
        if (i2 != 4) {
            if (i2 != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.a);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    private final T q() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // h.q2.o
    @k.e.a.e
    public Object d(T t, @k.e.a.d h.e2.c<? super t1> cVar) {
        this.b = t;
        this.a = 3;
        this.f15660d = cVar;
        Object h2 = h.e2.j.b.h();
        if (h2 == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return h2 == h.e2.j.b.h() ? h2 : t1.a;
    }

    @Override // h.q2.o
    @k.e.a.e
    public Object g(@k.e.a.d Iterator<? extends T> it, @k.e.a.d h.e2.c<? super t1> cVar) {
        if (it.hasNext()) {
            this.f15659c = it;
            this.a = 2;
            this.f15660d = cVar;
            Object h2 = h.e2.j.b.h();
            if (h2 == h.e2.j.b.h()) {
                h.e2.k.a.f.c(cVar);
            }
            return h2 == h.e2.j.b.h() ? h2 : t1.a;
        }
        return t1.a;
    }

    @Override // h.e2.c
    @k.e.a.d
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i2 = this.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw i();
                } else if (this.f15659c.hasNext()) {
                    this.a = 2;
                    return true;
                } else {
                    this.f15659c = null;
                }
            }
            this.a = 5;
            h.e2.c<? super t1> cVar = this.f15660d;
            this.f15660d = null;
            t1 t1Var = t1.a;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m106constructorimpl(t1Var));
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i2 = this.a;
        if (i2 == 0 || i2 == 1) {
            return q();
        }
        if (i2 == 2) {
            this.a = 1;
            return this.f15659c.next();
        } else if (i2 == 3) {
            this.a = 0;
            T t = this.b;
            this.b = null;
            return t;
        } else {
            throw i();
        }
    }

    @k.e.a.e
    public final h.e2.c<t1> o() {
        return this.f15660d;
    }

    public final void r(@k.e.a.e h.e2.c<? super t1> cVar) {
        this.f15660d = cVar;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // h.e2.c
    public void resumeWith(@k.e.a.d Object obj) {
        r0.n(obj);
        this.a = 4;
    }
}
