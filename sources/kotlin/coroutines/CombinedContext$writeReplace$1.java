package kotlin.coroutines;

import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class CombinedContext$writeReplace$1 extends Lambda implements p<t1, CoroutineContext.a, t1> {
    public final /* synthetic */ CoroutineContext[] $elements;
    public final /* synthetic */ Ref.IntRef $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombinedContext$writeReplace$1(CoroutineContext[] coroutineContextArr, Ref.IntRef intRef) {
        super(2);
        this.$elements = coroutineContextArr;
        this.$index = intRef;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var, CoroutineContext.a aVar) {
        invoke2(t1Var, aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d t1 t1Var, @d CoroutineContext.a aVar) {
        CoroutineContext[] coroutineContextArr = this.$elements;
        Ref.IntRef intRef = this.$index;
        int i2 = intRef.element;
        intRef.element = i2 + 1;
        coroutineContextArr[i2] = aVar;
    }
}
