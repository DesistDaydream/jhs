package com.jihuanshe.ext;

import android.view.View;
import com.jihuanshe.R;
import com.vector.design.ui.nav.ImageAttrs;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AppbarKt$addMoreView$1 extends Lambda implements l<ImageAttrs, t1> {
    public final /* synthetic */ l<View, t1> $block;
    public final /* synthetic */ int $endDp;

    /* renamed from: com.jihuanshe.ext.AppbarKt$addMoreView$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public final /* synthetic */ l<View, t1> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(l<? super View, t1> lVar) {
            super(1);
            this.$block = lVar;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            l<View, t1> lVar = this.$block;
            if (lVar == null) {
                return;
            }
            lVar.invoke(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppbarKt$addMoreView$1(int i2, l<? super View, t1> lVar) {
        super(1);
        this.$endDp = i2;
        this.$block = lVar;
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
        imageAttrs.y(this.$endDp);
        imageAttrs.B(true);
        imageAttrs.x(R.drawable.svg_more);
        imageAttrs.t(R.drawable.bg_back_icon);
        imageAttrs.g(new AnonymousClass1(this.$block));
    }
}
