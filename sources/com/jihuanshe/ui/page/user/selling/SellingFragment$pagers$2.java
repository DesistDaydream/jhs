package com.jihuanshe.ui.page.user.selling;

import com.jihuanshe.R;
import com.vector.util.Res;
import e.t.k.a.c.h.c;
import h.k2.u.a;
import h.k2.u.l;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingFragment$pagers$2 extends Lambda implements a<c> {
    public final /* synthetic */ SellingFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.user.selling.SellingFragment$pagers$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Integer, SellingChildFragment> {
        public final /* synthetic */ SellingFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellingFragment sellingFragment) {
            super(1);
            this.this$0 = sellingFragment;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ SellingChildFragment invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final SellingChildFragment invoke(int i2) {
            return SellingChildFragmentCreator.create(1).search(Boolean.valueOf(this.this$0.p0())).get();
        }
    }

    /* renamed from: com.jihuanshe.ui.page.user.selling.SellingFragment$pagers$2$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Integer, SellingChildFragment> {
        public final /* synthetic */ SellingFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SellingFragment sellingFragment) {
            super(1);
            this.this$0 = sellingFragment;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ SellingChildFragment invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final SellingChildFragment invoke(int i2) {
            return SellingChildFragmentCreator.create(0).search(Boolean.valueOf(this.this$0.p0())).get();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingFragment$pagers$2(SellingFragment sellingFragment) {
        super(0);
        this.this$0 = sellingFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final c invoke() {
        Res res = Res.a;
        return e.t.k.a.c.h.d.a(CollectionsKt__CollectionsKt.P(new AnonymousClass1(this.this$0), new AnonymousClass2(this.this$0)), CollectionsKt__CollectionsKt.P(Res.w(res, R.string.shop_on_sale, null, 2, null), Res.w(res, R.string.shop_remove, null, 2, null)));
    }
}
