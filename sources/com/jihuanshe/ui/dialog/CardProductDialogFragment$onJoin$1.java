package com.jihuanshe.ui.dialog;

import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.ShopCarResult;
import com.jihuanshe.ui.widget.NumberView;
import com.vector.util.Res;
import e.l.h.d.f;
import e.l.h.d.i;
import e.l.n.c.d;
import h.k2.u.a;
import h.k2.u.l;
import h.r0;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.Result;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardProductDialogFragment$onJoin$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardProductDialogFragment this$0;

    /* renamed from: com.jihuanshe.ui.dialog.CardProductDialogFragment$onJoin$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ int $count;
        public final /* synthetic */ GameCard $item;
        public final /* synthetic */ CardProductDialogFragment this$0;

        /* renamed from: com.jihuanshe.ui.dialog.CardProductDialogFragment$onJoin$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00981 extends Lambda implements l<Result<ShopCarResult>, t1> {
            public final /* synthetic */ CardProductDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00981(CardProductDialogFragment cardProductDialogFragment) {
                super(1);
                this.this$0 = cardProductDialogFragment;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(Result<ShopCarResult> result) {
                invoke2(result);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e Result<ShopCarResult> result) {
                i.d(f.b, e.l.j.a.C, null, 2, null);
                CardProductDialogFragment cardProductDialogFragment = this.this$0;
                try {
                    Result.a aVar = kotlin.Result.Companion;
                    cardProductDialogFragment.dismiss();
                    kotlin.Result.m106constructorimpl(t1.a);
                } catch (Throwable th) {
                    Result.a aVar2 = kotlin.Result.Companion;
                    kotlin.Result.m106constructorimpl(r0.a(th));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GameCard gameCard, int i2, CardProductDialogFragment cardProductDialogFragment) {
            super(0);
            this.$item = gameCard;
            this.$count = i2;
            this.this$0 = cardProductDialogFragment;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$item != null) {
                d dVar = (d) e.l.n.a.d(d.class, false, false, false, 60L, true);
                Integer productId = this.$item.getProductId();
                BinderKt.p(BinderKt.j(e.g.d.a.h(e.g.d.a.j(FlowKt.c(dVar.a(productId == null ? 0 : productId.intValue(), this.$count)), null, new C00981(this.this$0), 1, null), LifecycleOwnerKt.getLifecycleScope(this.this$0), null, 2, null), this.this$0, false, 2, null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardProductDialogFragment$onJoin$1(CardProductDialogFragment cardProductDialogFragment) {
        super(1);
        this.this$0 = cardProductDialogFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@k.e.a.d View view) {
        NumberView K;
        List<GameCard> products;
        K = this.this$0.K();
        int value = K.getValue();
        GameCard gameCard = null;
        if (value <= 0) {
            e.l.h.j.b.e.d(this.this$0, Res.w(Res.a, R.string.error_count, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
            return;
        }
        CardProductNew value2 = this.this$0.F().getValue();
        if (value2 != null && (products = value2.getProducts()) != null) {
            gameCard = (GameCard) CollectionsKt___CollectionsKt.J2(products, this.this$0.E().v());
        }
        e.l.l.a.d(new AnonymousClass1(gameCard, value, this.this$0));
    }
}
