package com.jihuanshe.ext;

import android.content.res.ColorStateList;
import android.view.View;
import com.jihuanshe.R;
import com.vector.design.ui.nav.ImageAttrs;
import e.t.o.d;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AppbarKt$addTickView$1 extends Lambda implements l<ImageAttrs, t1> {
    public final /* synthetic */ a<t1> $block;
    public final /* synthetic */ int $endDp;

    /* renamed from: com.jihuanshe.ext.AppbarKt$addTickView$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public final /* synthetic */ a<t1> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a<t1> aVar) {
            super(1);
            this.$block = aVar;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            a<t1> aVar = this.$block;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppbarKt$addTickView$1(int i2, a<t1> aVar) {
        super(1);
        this.$endDp = i2;
        this.$block = aVar;
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
        imageAttrs.x(R.drawable.ic_svg_tick);
        imageAttrs.t(R.drawable.bg_back_icon_white);
        imageAttrs.C(ColorStateList.valueOf(-1));
        imageAttrs.g(new AnonymousClass1(this.$block));
    }
}
