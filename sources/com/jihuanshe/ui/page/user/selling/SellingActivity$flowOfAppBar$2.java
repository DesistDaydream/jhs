package com.jihuanshe.ui.page.user.selling;

import android.content.res.ColorStateList;
import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.search.SearchActivityCreator;
import com.vector.design.ui.nav.ImageAttrs;
import com.vector.util.Res;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingActivity$flowOfAppBar$2 extends Lambda implements l<ImageAttrs, t1> {
    public final /* synthetic */ SellingActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.selling.SellingActivity$flowOfAppBar$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public final /* synthetic */ SellingActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellingActivity sellingActivity) {
            super(1);
            this.this$0 = sellingActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            SearchActivityCreator.create(7).start(this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingActivity$flowOfAppBar$2(SellingActivity sellingActivity) {
        super(1);
        this.this$0 = sellingActivity;
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
        imageAttrs.y(d.a.c(aVar, null, 1, null).d(24));
        imageAttrs.x(R.drawable.svg_search);
        imageAttrs.t(R.drawable.bg_search_left_bar);
        imageAttrs.C(ColorStateList.valueOf(Res.k(R.color.black)));
        imageAttrs.g(new AnonymousClass1(this.this$0));
    }
}
