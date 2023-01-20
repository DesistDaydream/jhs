package com.jihuanshe.ui.page.search.fragments.wantcard;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardInfo;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.dialog.AddCardDialog;
import com.jihuanshe.viewmodel.user.WantCardListViewModel;
import com.vector.ext.AnyKt;
import com.vector.util.Res;
import e.l.h.d.f;
import e.l.h.i.b;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchWantCardListFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ SearchWantCardListFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.search.fragments.wantcard.SearchWantCardListFragment$onItemClick$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<b<CardInfo>, t1> {
        public final /* synthetic */ WantCard $a;
        public final /* synthetic */ SearchWantCardListFragment this$0;

        /* renamed from: com.jihuanshe.ui.page.search.fragments.wantcard.SearchWantCardListFragment$onItemClick$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01181 extends Lambda implements a<t1> {
            public final /* synthetic */ WantCard $a;
            public final /* synthetic */ SearchWantCardListFragment this$0;

            /* renamed from: com.jihuanshe.ui.page.search.fragments.wantcard.SearchWantCardListFragment$onItemClick$1$1$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C01191 extends Lambda implements l<t1, t1> {
                public final /* synthetic */ WantCard $a;
                public final /* synthetic */ SearchWantCardListFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01191(SearchWantCardListFragment searchWantCardListFragment, WantCard wantCard) {
                    super(1);
                    this.this$0 = searchWantCardListFragment;
                    this.$a = wantCard;
                }

                @Override // h.k2.u.l
                public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                    invoke2(t1Var);
                    return t1.a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@e t1 t1Var) {
                    List<WantCard> value = ((WantCardListViewModel) this.this$0.T()).v0().getValue();
                    List<WantCard> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
                    if (L5 != null) {
                        L5.remove(this.$a);
                    }
                    ((WantCardListViewModel) this.this$0.T()).v0().setValue(L5);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01181(SearchWantCardListFragment searchWantCardListFragment, WantCard wantCard) {
                super(0);
                this.this$0 = searchWantCardListFragment;
                this.$a = wantCard;
            }

            @Override // h.k2.u.a
            public /* bridge */ /* synthetic */ t1 invoke() {
                invoke2();
                return t1.a;
            }

            @Override // h.k2.u.a
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BinderKt.p(BinderKt.j(e.g.d.a.j(((WantCardListViewModel) this.this$0.T()).s0(this.$a.getId()), null, new C01191(this.this$0, this.$a), 1, null), this.this$0, false, 2, null));
            }
        }

        /* renamed from: com.jihuanshe.ui.page.search.fragments.wantcard.SearchWantCardListFragment$onItemClick$1$1$2  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends Lambda implements l<WantCard, t1> {
            public final /* synthetic */ SearchWantCardListFragment this$0;

            /* renamed from: com.jihuanshe.ui.page.search.fragments.wantcard.SearchWantCardListFragment$onItemClick$1$1$2$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C01201 extends Lambda implements l<t1, t1> {
                public final /* synthetic */ WantCard $it;
                public final /* synthetic */ SearchWantCardListFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01201(SearchWantCardListFragment searchWantCardListFragment, WantCard wantCard) {
                    super(1);
                    this.this$0 = searchWantCardListFragment;
                    this.$it = wantCard;
                }

                @Override // h.k2.u.l
                public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                    invoke2(t1Var);
                    return t1.a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@e t1 t1Var) {
                    List<WantCard> value = ((WantCardListViewModel) this.this$0.T()).v0().getValue();
                    List<WantCard> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
                    if (L5 != null) {
                        L5.set(L5.indexOf(this.$it), this.$it);
                    }
                    ((WantCardListViewModel) this.this$0.T()).v0().setValue(L5);
                    e.l.h.j.b.e.d(this.this$0, Res.w(Res.a, R.string.success, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
                    f.b.a(e.l.j.a.A, this.$it);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(SearchWantCardListFragment searchWantCardListFragment) {
                super(1);
                this.this$0 = searchWantCardListFragment;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(WantCard wantCard) {
                invoke2(wantCard);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@d WantCard wantCard) {
                if (AnyKt.l(wantCard.getId())) {
                    return;
                }
                BinderKt.p(BinderKt.j(e.g.d.a.j(((WantCardListViewModel) this.this$0.T()).y0(wantCard.getVersionId(), wantCard.getId(), wantCard.getWishPrice(), wantCard.getQuantity(), wantCard.getRemark(), wantCard.getIgnoreVersion()), null, new C01201(this.this$0, wantCard), 1, null), this.this$0, false, 2, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SearchWantCardListFragment searchWantCardListFragment, WantCard wantCard) {
            super(1);
            this.this$0 = searchWantCardListFragment;
            this.$a = wantCard;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(b<CardInfo> bVar) {
            invoke2(bVar);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e b<CardInfo> bVar) {
            FragmentActivity requireActivity = this.this$0.requireActivity();
            CardInfo a = bVar == null ? null : bVar.a();
            WantCard wantCard = this.$a;
            new AddCardDialog(requireActivity, a, ((WantCardListViewModel) this.this$0.T()).x0().getValue(), null, wantCard, false, null, new C01181(this.this$0, wantCard), new AnonymousClass2(this.this$0), null, TypedValues.Motion.TYPE_DRAW_PATH, null).y();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchWantCardListFragment$onItemClick$1(SearchWantCardListFragment searchWantCardListFragment) {
        super(2);
        this.this$0 = searchWantCardListFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<WantCard> value = ((WantCardListViewModel) this.this$0.T()).v0().getValue();
        WantCard wantCard = value == null ? null : (WantCard) CollectionsKt___CollectionsKt.J2(value, i2);
        if (wantCard == null) {
            return;
        }
        BinderKt.p(BinderKt.j(e.g.d.a.j(((WantCardListViewModel) this.this$0.T()).t0(wantCard.getCid().intValue()), null, new AnonymousClass1(this.this$0, wantCard), 1, null), this.this$0, false, 2, null));
    }
}
