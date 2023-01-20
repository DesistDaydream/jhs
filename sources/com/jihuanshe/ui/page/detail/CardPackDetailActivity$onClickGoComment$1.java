package com.jihuanshe.ui.page.detail;

import android.content.Intent;
import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.base.ui.activity.GlobalToastActivityCreator;
import com.jihuanshe.model.CommentBean;
import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.ui.dialog.CardCommentsDialog;
import com.jihuanshe.viewmodel.detail.CardPackDetailViewModel;
import com.vector.util.Res;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailActivity$onClickGoComment$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardPackDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.CardPackDetailActivity$onClickGoComment$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ CardPackDetailActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.detail.CardPackDetailActivity$onClickGoComment$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01021 extends Lambda implements l<CommentBean, t1> {
            public final /* synthetic */ CardPackDetailActivity this$0;

            /* renamed from: com.jihuanshe.ui.page.detail.CardPackDetailActivity$onClickGoComment$1$1$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C01031 extends Lambda implements l<t1, t1> {
                public final /* synthetic */ CardPackDetailActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01031(CardPackDetailActivity cardPackDetailActivity) {
                    super(1);
                    this.this$0 = cardPackDetailActivity;
                }

                @Override // h.k2.u.l
                public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                    invoke2(t1Var);
                    return t1.a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@e t1 t1Var) {
                    this.this$0.F();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01021(CardPackDetailActivity cardPackDetailActivity) {
                super(1);
                this.this$0 = cardPackDetailActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(CommentBean commentBean) {
                invoke2(commentBean);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@d CommentBean commentBean) {
                e.g.d.a.j(BinderKt.p(((CardPackDetailViewModel) this.this$0.L()).J0(commentBean.getScore(), commentBean.getContent(), this.this$0.b0(), this.this$0.c0())), null, new C01031(this.this$0), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CardPackDetailActivity cardPackDetailActivity) {
            super(0);
            this.this$0 = cardPackDetailActivity;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PackDetailResult value = ((CardPackDetailViewModel) this.this$0.L()).B0().getValue();
            if (value != null && value.isGrade()) {
                Intent newIntent = GlobalToastActivityCreator.newIntent(e.t.a.b(), Res.w(Res.a, R.string.review_error_content, null, 2, null));
                newIntent.setFlags(268435456);
                e.t.a.b().startActivity(newIntent);
                return;
            }
            CardPackDetailActivity cardPackDetailActivity = this.this$0;
            CardPackDetailActivity cardPackDetailActivity2 = this.this$0;
            cardPackDetailActivity.x0(new CardCommentsDialog(cardPackDetailActivity2, false, new C01021(cardPackDetailActivity2)));
            CardCommentsDialog a0 = this.this$0.a0();
            if (a0 == null) {
                return;
            }
            a0.y();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailActivity$onClickGoComment$1(CardPackDetailActivity cardPackDetailActivity) {
        super(1);
        this.this$0 = cardPackDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        e.l.h.j.b.e.h(this.this$0, "该功能暂未开放", null, null, null, 0, null, 62, null);
    }
}
