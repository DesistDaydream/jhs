package com.jihuanshe.ui.page.user;

import android.content.res.ColorStateList;
import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.model.User;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import com.vector.design.ui.nav.ImageAttrs;
import com.vector.util.Res;
import e.l.q.b.f.g;
import e.t.o.d;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$flowOfAppBar$6 extends Lambda implements l<ImageAttrs, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.SellerDetailActivity$flowOfAppBar$6$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public final /* synthetic */ SellerDetailActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.user.SellerDetailActivity$flowOfAppBar$6$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01261 extends Lambda implements a<t1> {
            public final /* synthetic */ SellerDetailActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01261(SellerDetailActivity sellerDetailActivity) {
                super(0);
                this.this$0 = sellerDetailActivity;
            }

            @Override // h.k2.u.a
            public /* bridge */ /* synthetic */ t1 invoke() {
                invoke2();
                return t1.a;
            }

            @Override // h.k2.u.a
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SellerDetailActivity sellerDetailActivity = this.this$0;
                User value = ((SellerDetailViewModel) sellerDetailActivity.L()).X0().getValue();
                String valueOf = String.valueOf(value == null ? null : Integer.valueOf(value.getId()));
                User value2 = ((SellerDetailViewModel) this.this$0.L()).X0().getValue();
                g.a(sellerDetailActivity, valueOf, value2 != null ? value2.getName() : null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellerDetailActivity sellerDetailActivity) {
            super(1);
            this.this$0 = sellerDetailActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            e.l.l.a.d(new C01261(this.this$0));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$flowOfAppBar$6(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ImageAttrs imageAttrs) {
        invoke2(imageAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ImageAttrs imageAttrs) {
        d.a aVar = e.t.o.d.a;
        imageAttrs.D(d.a.c(aVar, null, 1, null).d(45));
        imageAttrs.v(d.a.c(aVar, null, 1, null).d(32));
        imageAttrs.x(R.drawable.svg_chat);
        imageAttrs.t(R.drawable.bg_search_left_bar);
        imageAttrs.C(ColorStateList.valueOf(Res.k(R.color.white)));
        imageAttrs.y(d.a.c(aVar, null, 1, null).d(12));
        imageAttrs.g(new AnonymousClass1(this.this$0));
    }
}
