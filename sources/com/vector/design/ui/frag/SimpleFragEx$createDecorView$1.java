package com.vector.design.ui.frag;

import android.view.View;
import com.vector.R;
import com.vector.design.ui.decor.DecorView;
import com.vector.design.ui.decor.PlaceHolder;
import com.vector.design.ui.frag.SimpleFragEx;
import e.t.u.w;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/vector/design/ui/decor/DecorView;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleFragEx$createDecorView$1 extends Lambda implements l<DecorView, t1> {
    public final /* synthetic */ SimpleFragEx this$0;

    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.vector.design.ui.frag.SimpleFragEx$createDecorView$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements h.k2.u.a<View> {
        public final /* synthetic */ SimpleFragEx this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SimpleFragEx simpleFragEx) {
            super(0);
            this.this$0 = simpleFragEx;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.k2.u.a
        @d
        public final View invoke() {
            View C;
            C = this.this$0.C();
            return C;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SimpleFragEx.LazyLoadMode.values().length];
            iArr[SimpleFragEx.LazyLoadMode.IDLE.ordinal()] = 1;
            iArr[SimpleFragEx.LazyLoadMode.RESUME.ordinal()] = 2;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleFragEx$createDecorView$1(SimpleFragEx simpleFragEx) {
        super(1);
        this.this$0 = simpleFragEx;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(DecorView decorView) {
        invoke2(decorView);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d DecorView decorView) {
        View C;
        PlaceHolder placeHolder = new PlaceHolder(this.this$0.requireContext(), null, 0, 6, null);
        placeHolder.setBackgroundColor(w.g(R.color.transparent, decorView.getContext()));
        int i2 = a.a[this.this$0.F().ordinal()];
        if (i2 != 1 && i2 != 2) {
            C = this.this$0.C();
            placeHolder.setReplaceView(C);
            decorView.setLazyLoad$vector_release(false);
        } else {
            placeHolder.setViewConstructor(new AnonymousClass1(this.this$0));
            decorView.setLazyLoad$vector_release(true);
        }
        decorView.setContentView$vector_release(placeHolder);
        decorView.setAppBarState$vector_release(this.this$0.B());
        decorView.setSetUpErrorView$vector_release(this.this$0.u());
        decorView.setSetUpLoadingView$vector_release(this.this$0.v());
    }
}
