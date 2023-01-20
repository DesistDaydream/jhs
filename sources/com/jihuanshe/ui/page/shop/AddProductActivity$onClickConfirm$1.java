package com.jihuanshe.ui.page.shop;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBar;
import com.vector.util.Res;
import e.l.h.d.f;
import e.l.h.d.i;
import e.l.j.a;
import e.l.q.b.b.a.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddProductActivity$onClickConfirm$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ AddProductActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.shop.AddProductActivity$onClickConfirm$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ AddProductActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AddProductActivity addProductActivity) {
            super(1);
            this.this$0 = addProductActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            e.l.h.j.b.e.b(this.this$0, R.string.success, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            i.d(f.b, a.f12241k, null, 2, null);
            this.this$0.finish();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddProductActivity$onClickConfirm$1(AddProductActivity addProductActivity) {
        super(1);
        this.this$0 = addProductActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Integer valueOf;
        Float a = d.a.a(this.this$0.i0(), false, 1, null);
        if (a == null) {
            e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.tips_input_price, null, 2, null), null, null, null, 0, null, 62, null);
            return;
        }
        int b = d.a.b(this.this$0.i0(), false, 1, null);
        String c2 = d.a.c(this.this$0.i0(), false, 1, null);
        int b2 = this.this$0.b0().b();
        if (b <= 0) {
            e.l.h.j.b.e.b(this.this$0, R.string.error_count, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        } else if (b2 < 0) {
            e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.tips_input_condition, null, 2, null), null, null, null, 0, null, 62, null);
        } else {
            e.l.s.n.a aVar = (e.l.s.n.a) this.this$0.L();
            CardProductNew value = ((e.l.s.n.a) this.this$0.L()).A0().getValue();
            Integer cardVersionId = value == null ? null : value.getCardVersionId();
            Integer valueOf2 = Integer.valueOf(b);
            valueOf = Integer.valueOf(b2);
            Game value2 = GameBar.b.a().getValue();
            String gameKey = value2 == null ? null : value2.getGameKey();
            CardProductNew value3 = ((e.l.s.n.a) this.this$0.L()).A0().getValue();
            String userUploadPhotoPath = value3 == null ? null : value3.getUserUploadPhotoPath();
            if (userUploadPhotoPath == null) {
                userUploadPhotoPath = "";
            }
            BinderKt.p(BinderKt.k(e.g.d.a.j(aVar.z0(cardVersionId, a, valueOf2, valueOf, c2, gameKey, userUploadPhotoPath), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null));
        }
    }
}
