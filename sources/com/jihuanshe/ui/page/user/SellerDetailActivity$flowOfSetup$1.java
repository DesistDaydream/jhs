package com.jihuanshe.ui.page.user;

import android.content.res.ColorStateList;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$flowOfSetup$1 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$flowOfSetup$1(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        ImageView imageView3;
        ImageView imageView4;
        TextView textView2;
        if (!z) {
            this.this$0.w().setBackgroundAlpha(0);
            imageView3 = this.this$0.a0;
            if (imageView3 != null) {
                imageView3.setImageTintList(ColorStateList.valueOf(-1));
            }
            imageView4 = this.this$0.Z;
            if (imageView4 != null) {
                imageView4.setImageTintList(ColorStateList.valueOf(-1));
            }
            textView2 = this.this$0.X;
            if (textView2 == null) {
                return;
            }
            textView2.setTextColor(Res.k(R.color.white));
            TextViewCompat.setCompoundDrawableTintList(textView2, ColorStateList.valueOf(Res.k(R.color.white)));
            return;
        }
        this.this$0.w().setBackgroundAlpha(255);
        imageView = this.this$0.a0;
        if (imageView != null) {
            imageView.setImageTintList(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK));
        }
        imageView2 = this.this$0.Z;
        if (imageView2 != null) {
            imageView2.setImageTintList(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK));
        }
        textView = this.this$0.X;
        if (textView == null) {
            return;
        }
        textView.setTextColor(Res.k(R.color.black));
        TextViewCompat.setCompoundDrawableTintList(textView, ColorStateList.valueOf(Res.k(R.color.black)));
    }
}
