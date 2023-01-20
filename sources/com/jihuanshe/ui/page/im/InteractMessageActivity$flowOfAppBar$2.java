package com.jihuanshe.ui.page.im;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.widget.InteractPopupWindow;
import com.jihuanshe.viewmodel.im.InteractMessageViewModel;
import com.vector.design.ui.nav.ImageAttrs;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class InteractMessageActivity$flowOfAppBar$2 extends Lambda implements l<ImageAttrs, t1> {
    public final /* synthetic */ InteractMessageActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.im.InteractMessageActivity$flowOfAppBar$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public final /* synthetic */ InteractMessageActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.im.InteractMessageActivity$flowOfAppBar$2$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01061 extends Lambda implements l<View, t1> {
            public final /* synthetic */ InteractMessageActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01061(InteractMessageActivity interactMessageActivity) {
                super(1);
                this.this$0 = interactMessageActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(View view) {
                invoke2(view);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@d View view) {
                BinderKt.p(BinderKt.k(((InteractMessageViewModel) this.this$0.L()).r0(), this.this$0, false, 2, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InteractMessageActivity interactMessageActivity) {
            super(1);
            this.this$0 = interactMessageActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            View view2;
            InteractMessageActivity interactMessageActivity = this.this$0;
            InteractPopupWindow interactPopupWindow = new InteractPopupWindow(interactMessageActivity, e.t.j.h.d.a.a(new C01061(interactMessageActivity)));
            view2 = this.this$0.x;
            d.a aVar = e.t.o.d.a;
            interactPopupWindow.showAsDropDown(view2, -d.a.c(aVar, null, 1, null).d(38), -d.a.c(aVar, null, 1, null).d(16));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractMessageActivity$flowOfAppBar$2(InteractMessageActivity interactMessageActivity) {
        super(1);
        this.this$0 = interactMessageActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ImageAttrs imageAttrs) {
        invoke2(imageAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@k.e.a.d ImageAttrs imageAttrs) {
        d.a aVar = e.t.o.d.a;
        imageAttrs.D(d.a.c(aVar, null, 1, null).d(40));
        imageAttrs.v(d.a.c(aVar, null, 1, null).d(30));
        imageAttrs.y(d.a.c(aVar, null, 1, null).d(24));
        imageAttrs.x(R.drawable.svg_more);
        imageAttrs.t(R.drawable.bg_back_icon);
        imageAttrs.g(new AnonymousClass1(this.this$0));
    }
}
