package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CommentBean;
import com.jihuanshe.ui.dialog.CardCommentsDialog;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$onClickGoComment$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReviewListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.ReviewListActivity$onClickGoComment$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ ReviewListActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.detail.ReviewListActivity$onClickGoComment$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01041 extends Lambda implements l<CommentBean, t1> {
            public final /* synthetic */ ReviewListActivity this$0;

            /* renamed from: com.jihuanshe.ui.page.detail.ReviewListActivity$onClickGoComment$1$1$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C01051 extends Lambda implements l<t1, t1> {
                public final /* synthetic */ ReviewListActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01051(ReviewListActivity reviewListActivity) {
                    super(1);
                    this.this$0 = reviewListActivity;
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
            public C01041(ReviewListActivity reviewListActivity) {
                super(1);
                this.this$0 = reviewListActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(CommentBean commentBean) {
                invoke2(commentBean);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@d CommentBean commentBean) {
                ReviewListViewModel reviewListViewModel = (ReviewListViewModel) this.this$0.L();
                Integer j0 = this.this$0.j0();
                int intValue = j0 == null ? 0 : j0.intValue();
                Integer A0 = this.this$0.A0();
                e.g.d.a.j(BinderKt.p(reviewListViewModel.O0(intValue, A0 == null ? 0 : A0.intValue(), this.this$0.getType(), commentBean.getScore(), commentBean.getContent())), null, new C01051(this.this$0), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReviewListActivity reviewListActivity) {
            super(0);
            this.this$0 = reviewListActivity;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ReviewListActivity reviewListActivity = this.this$0;
            ReviewListActivity reviewListActivity2 = this.this$0;
            reviewListActivity.W0(new CardCommentsDialog(reviewListActivity2, f0.g(reviewListActivity2.getType(), "card_version"), new C01041(this.this$0)));
            CardCommentsDialog e0 = this.this$0.e0();
            if (e0 == null) {
                return;
            }
            e0.y();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$onClickGoComment$1(ReviewListActivity reviewListActivity) {
        super(1);
        this.this$0 = reviewListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (this.this$0.getType() == null || f0.g(this.this$0.getType(), "")) {
            return;
        }
        e.l.l.a.d(new AnonymousClass1(this.this$0));
    }
}
