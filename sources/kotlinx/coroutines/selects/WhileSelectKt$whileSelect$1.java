package kotlinx.coroutines.selects;

import h.e2.c;
import h.e2.k.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", i = {0}, l = {37}, m = "whileSelect", n = {"builder"}, s = {"L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000¢\u0006\u0002\b\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0087H¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lkotlin/Function1;", "Li/b/z3/a;", "", "Lh/t1;", "Lh/q;", "builder", "Lh/e2/c;", "continuation", "", "whileSelect", "(Lh/k2/u/l;Lh/e2/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public WhileSelectKt$whileSelect$1(c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WhileSelectKt.a(null, this);
    }
}
