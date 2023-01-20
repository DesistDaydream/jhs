package com.jihuanshe.ui.page.detail;

import android.view.View;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$onClickContent$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReviewListInfo $info;
    public final /* synthetic */ ReviewListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.ReviewListActivity$onClickContent$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ ReviewListInfo $info;
        public final /* synthetic */ ReviewListActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReviewListActivity reviewListActivity, ReviewListInfo reviewListInfo) {
            super(0);
            this.this$0 = reviewListActivity;
            this.$info = reviewListInfo;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ConstraintLayout i0;
            EditText l0;
            i0 = this.this$0.i0();
            i0.setVisibility(8);
            ((ReviewListViewModel) this.this$0.L()).K0().setValue(Boolean.TRUE);
            l0 = this.this$0.l0();
            l0.setHint(f0.C("回复 @", this.$info.getUsername()));
            this.this$0.Y0(this.$info);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$onClickContent$1(ReviewListActivity reviewListActivity, ReviewListInfo reviewListInfo) {
        super(1);
        this.this$0 = reviewListActivity;
        this.$info = reviewListInfo;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        e.l.l.a.c(new AnonymousClass1(this.this$0, this.$info));
    }
}
