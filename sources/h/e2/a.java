package h.e2;

import h.k2.u.p;
import h.s0;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
/* loaded from: classes3.dex */
public abstract class a implements CoroutineContext.a {
    @k.e.a.d
    private final CoroutineContext.b<?> key;

    public a(@k.e.a.d CoroutineContext.b<?> bVar) {
        this.key = bVar;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @k.e.a.d p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) CoroutineContext.a.C0492a.a(this, r, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.e
    public <E extends CoroutineContext.a> E get(@k.e.a.d CoroutineContext.b<E> bVar) {
        return (E) CoroutineContext.a.C0492a.b(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @k.e.a.d
    public CoroutineContext.b<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.d
    public CoroutineContext minusKey(@k.e.a.d CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0492a.c(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @k.e.a.d
    public CoroutineContext plus(@k.e.a.d CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0492a.d(this, coroutineContext);
    }
}
