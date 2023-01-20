package com.jihuanshe.ui.page.search.fragments.global;

import android.view.View;
import com.jihuanshe.ui.page.user.WantBuyActivityCreator;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchFragment$onClickWantBug$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ GlobalSearchFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.search.fragments.global.GlobalSearchFragment$onClickWantBug$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ GlobalSearchFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GlobalSearchFragment globalSearchFragment) {
            super(0);
            this.this$0 = globalSearchFragment;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WantBuyActivityCreator.create().start(this.this$0.getActivity());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchFragment$onClickWantBug$1(GlobalSearchFragment globalSearchFragment) {
        super(1);
        this.this$0 = globalSearchFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        e.l.l.a.d(new AnonymousClass1(this.this$0));
    }
}
