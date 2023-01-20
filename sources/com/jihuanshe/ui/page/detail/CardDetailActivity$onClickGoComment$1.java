package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.CommentBean;
import com.jihuanshe.ui.dialog.CardCommentsDialog;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import com.vector.util.Res;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onClickGoComment$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.CardDetailActivity$onClickGoComment$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ CardDetailActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.detail.CardDetailActivity$onClickGoComment$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01001 extends Lambda implements l<CommentBean, t1> {
            public final /* synthetic */ CardDetailActivity this$0;

            /* renamed from: com.jihuanshe.ui.page.detail.CardDetailActivity$onClickGoComment$1$1$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C01011 extends Lambda implements l<t1, t1> {
                public final /* synthetic */ CardDetailActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01011(CardDetailActivity cardDetailActivity) {
                    super(1);
                    this.this$0 = cardDetailActivity;
                }

                @Override // h.k2.u.l
                public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                    invoke2(t1Var);
                    return t1.a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@e t1 t1Var) {
                    this.this$0.l0("");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01001(CardDetailActivity cardDetailActivity) {
                super(1);
                this.this$0 = cardDetailActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(CommentBean commentBean) {
                invoke2(commentBean);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@d CommentBean commentBean) {
                e.g.d.a.j(BinderKt.p(((CardDetailViewModel) this.this$0.L()).e1(commentBean.getScore(), commentBean.getContent(), this.this$0.w0(), this.this$0.x0())), null, new C01011(this.this$0), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CardDetailActivity cardDetailActivity) {
            super(0);
            this.this$0 = cardDetailActivity;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CardDetailInfo value = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
            if (value == null ? false : f0.g(value.isGrade(), Boolean.TRUE)) {
                e.l.h.j.b.e.a(this.this$0, Res.w(Res.a, R.string.review_error_content, null, 2, null));
                return;
            }
            CardDetailActivity cardDetailActivity = this.this$0;
            CardDetailActivity cardDetailActivity2 = this.this$0;
            cardDetailActivity.h1(new CardCommentsDialog(cardDetailActivity2, true, new C01001(cardDetailActivity2)));
            CardCommentsDialog q0 = this.this$0.q0();
            if (q0 == null) {
                return;
            }
            q0.y();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onClickGoComment$1(CardDetailActivity cardDetailActivity) {
        super(1);
        this.this$0 = cardDetailActivity;
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
