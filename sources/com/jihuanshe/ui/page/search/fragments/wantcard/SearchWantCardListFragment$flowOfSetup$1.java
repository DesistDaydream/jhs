package com.jihuanshe.ui.page.search.fragments.wantcard;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.WantCardListViewModel;
import e.g.e.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchWantCardListFragment$flowOfSetup$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ SearchWantCardListFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.search.fragments.wantcard.SearchWantCardListFragment$flowOfSetup$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<a, t1> {
        public final /* synthetic */ SearchWantCardListFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SearchWantCardListFragment searchWantCardListFragment) {
            super(1);
            this.this$0 = searchWantCardListFragment;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
            invoke2(aVar);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d a aVar) {
            ((WantCardListViewModel) this.this$0.T()).v0().setValue(CollectionsKt__CollectionsKt.E());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchWantCardListFragment$flowOfSetup$1(SearchWantCardListFragment searchWantCardListFragment) {
        super(1);
        this.this$0 = searchWantCardListFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e String str) {
        String str2;
        this.this$0.x = str;
        WantCardListViewModel wantCardListViewModel = (WantCardListViewModel) this.this$0.T();
        Integer i0 = this.this$0.i0();
        int intValue = i0 == null ? 0 : i0.intValue();
        str2 = this.this$0.x;
        e.g.d.a.o(BinderKt.t(WantCardListViewModel.w0(wantCardListViewModel, intValue, str2, null, 4, null), this.this$0, false, 2, null), null, new AnonymousClass1(this.this$0), 1, null);
    }
}
