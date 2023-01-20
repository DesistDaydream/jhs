package com.jihuanshe.viewmodel.search.globals;

import com.jihuanshe.model.Rarity;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* loaded from: classes2.dex */
public final class SearchProductViewModel$search$1$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ List<Rarity> $list;
    public int label;
    public final /* synthetic */ SearchProductViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchProductViewModel$search$1$1(SearchProductViewModel searchProductViewModel, List<Rarity> list, c<? super SearchProductViewModel$search$1$1> cVar) {
        super(2, cVar);
        this.this$0 = searchProductViewModel;
        this.$list = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        return new SearchProductViewModel$search$1$1(this.this$0, this.$list, cVar);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@d n0 n0Var, @e c<? super t1> cVar) {
        return ((SearchProductViewModel$search$1$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            this.this$0.s0().r(this.$list);
            return t1.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
