package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Poster;
import com.jihuanshe.ui.dialog.PosterDialog;
import com.jihuanshe.ui.widget.OnePopupWindow;
import com.jihuanshe.viewmodel.user.WantCardListViewModel;
import com.vector.util.Res;
import e.g.d.a;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantCardListActivity$flowOfAppBar$3 extends Lambda implements l<View, t1> {
    public final /* synthetic */ WantCardListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.WantCardListActivity$flowOfAppBar$3$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public final /* synthetic */ WantCardListActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.user.WantCardListActivity$flowOfAppBar$3$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01301 extends Lambda implements l<Poster, t1> {
            public final /* synthetic */ WantCardListActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01301(WantCardListActivity wantCardListActivity) {
                super(1);
                this.this$0 = wantCardListActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(Poster poster) {
                invoke2(poster);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e Poster poster) {
                PosterDialog.a aVar = PosterDialog.f3991i;
                String url = poster == null ? null : poster.getUrl();
                if (url == null) {
                    url = "";
                }
                aVar.a(url).show(this.this$0.getSupportFragmentManager(), "poster");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WantCardListActivity wantCardListActivity) {
            super(1);
            this.this$0 = wantCardListActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            BinderKt.p(BinderKt.k(a.j(((WantCardListViewModel) this.this$0.L()).q0(), null, new C01301(this.this$0), 1, null), this.this$0, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantCardListActivity$flowOfAppBar$3(WantCardListActivity wantCardListActivity) {
        super(1);
        this.this$0 = wantCardListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        OnePopupWindow onePopupWindow = new OnePopupWindow(this.this$0, Res.w(Res.a, R.string.common_create_poster, null, 2, null), e.t.j.h.d.a.a(new AnonymousClass1(this.this$0)));
        d.a aVar = e.t.o.d.a;
        onePopupWindow.showAsDropDown(view, -d.a.c(aVar, null, 1, null).d(38), -d.a.c(aVar, null, 1, null).d(16));
    }
}
