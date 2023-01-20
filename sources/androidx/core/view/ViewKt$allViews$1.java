package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.q2.m;
import h.q2.o;
import h.r0;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@d(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", i = {0}, l = {406, 408}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements p<o<? super View>, c<? super t1>, Object> {
    public final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, c<? super ViewKt$allViews$1> cVar) {
        super(2, cVar);
        this.$this_allViews = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, cVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@k.e.a.d o<? super View> oVar, @e c<? super t1> cVar) {
        return ((ViewKt$allViews$1) create(oVar, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        o oVar;
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            oVar = (o) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = oVar;
            this.label = 1;
            if (oVar.d(view, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r0.n(obj);
            return t1.a;
        } else {
            oVar = (o) this.L$0;
            r0.n(obj);
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            m<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (oVar.h(descendants, this) == h2) {
                return h2;
            }
        }
        return t1.a;
    }
}
