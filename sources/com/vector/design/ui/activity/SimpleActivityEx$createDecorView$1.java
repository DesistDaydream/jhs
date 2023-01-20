package com.vector.design.ui.activity;

import androidx.databinding.ViewDataBinding;
import com.vector.design.ui.decor.DecorView;
import com.vector.design.ui.decor.PlaceHolder;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/vector/design/ui/decor/DecorView;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleActivityEx$createDecorView$1 extends Lambda implements l<DecorView, t1> {
    public final /* synthetic */ SimpleActivityEx this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleActivityEx$createDecorView$1(SimpleActivityEx simpleActivityEx) {
        super(1);
        this.this$0 = simpleActivityEx;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(DecorView decorView) {
        invoke2(decorView);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d DecorView decorView) {
        PlaceHolder placeHolder = new PlaceHolder(this.this$0, null, 0, 6, null);
        SimpleActivityEx simpleActivityEx = this.this$0;
        ViewDataBinding q = simpleActivityEx.q();
        q.setLifecycleOwner(simpleActivityEx);
        placeHolder.setReplaceView(q.getRoot());
        t1 t1Var = t1.a;
        decorView.setContentView$vector_release(placeHolder);
        decorView.setAppBarState$vector_release(this.this$0.x());
        decorView.setSetUpErrorView$vector_release(this.this$0.s());
        decorView.setSetUpLoadingView$vector_release(this.this$0.t());
    }
}
