package com.jihuanshe.ui.page.common.card;

import android.view.View;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.jihuanshe.model.CardProductNew;
import e.l.q.b.h.k;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ProductManagerHeaderImpl$clickProductCover$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardProductNew $product;
    public final /* synthetic */ ProductManagerHeaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductManagerHeaderImpl$clickProductCover$1(CardProductNew cardProductNew, ProductManagerHeaderImpl productManagerHeaderImpl) {
        super(1);
        this.$product = cardProductNew;
        this.this$0 = productManagerHeaderImpl;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (this.$product == null) {
            return;
        }
        FragmentActivity fragmentActivity = null;
        if (!this.this$0.a()) {
            if (this.$product.hasImage()) {
                AppCompatActivity activity = this.this$0.getActivity();
                if (activity == null) {
                    Fragment m2 = this.this$0.m();
                    if (m2 != null) {
                        fragmentActivity = m2.getActivity();
                    }
                } else {
                    fragmentActivity = activity;
                }
                new k(fragmentActivity, this.$product.getUserUploadPhotoPath(), (ImageView) view).t();
                return;
            }
            return;
        }
        this.this$0.f4012g = this.$product;
        if (!this.$product.hasImage()) {
            ActivityResultLauncher<Integer> n = this.this$0.n();
            if (n == null) {
                return;
            }
            n.launch(this.$product.getCardVersionId());
            return;
        }
        AppCompatActivity activity2 = this.this$0.getActivity();
        if (activity2 == null) {
            Fragment m3 = this.this$0.m();
            if (m3 != null) {
                fragmentActivity = m3.getActivity();
            }
        } else {
            fragmentActivity = activity2;
        }
        new k(fragmentActivity, this.$product.getUserUploadPhotoPath(), (ImageView) view).t();
    }
}
