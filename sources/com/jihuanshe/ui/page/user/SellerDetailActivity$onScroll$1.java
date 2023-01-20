package com.jihuanshe.ui.page.user;

import android.content.res.ColorStateList;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.appbar.AppBarLayout;
import com.jihuanshe.R;
import com.jihuanshe.model.Constants;
import com.jihuanshe.ui.widget.UserBar;
import com.vector.ext.view.ViewKt;
import com.vector.network.image.NImageView;
import com.vector.util.Res;
import e.n.i;
import h.k2.u.p;
import h.r0;
import h.t1;
import k.e.a.d;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onScroll$1 extends Lambda implements p<AppBarLayout, Integer, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onScroll$1(SellerDetailActivity sellerDetailActivity) {
        super(2);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(AppBarLayout appBarLayout, Integer num) {
        invoke(appBarLayout, num.intValue());
        return t1.a;
    }

    public final void invoke(@d AppBarLayout appBarLayout, int i2) {
        boolean z;
        UserBar userBar;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView;
        ImageView imageView4;
        boolean z2;
        UserBar userBar2;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        TextView textView2;
        ImageView imageView9;
        UserBar userBar3;
        UserBar userBar4;
        ImageView imageView10;
        ImageView imageView11;
        ImageView imageView12;
        ImageView imageView13;
        ImageView imageView14;
        SellerDetailActivity sellerDetailActivity = this.this$0;
        try {
            Result.a aVar = Result.Companion;
            int abs = Math.abs(i2);
            float totalScrollRange = abs / (appBarLayout.getTotalScrollRange() / 3);
            float f2 = 255;
            int H0 = h.l2.d.H0(Math.min(totalScrollRange, 1.0f) * f2);
            i iVar = null;
            if (sellerDetailActivity.w().getBackgroundAlpha() != H0) {
                sellerDetailActivity.w().setBackgroundAlpha(H0);
                userBar3 = sellerDetailActivity.b0;
                TextView textView3 = userBar3 == null ? null : (TextView) userBar3.findViewById(R.id.tvName);
                if (textView3 != null) {
                    textView3.setAlpha(H0 / f2);
                }
                userBar4 = sellerDetailActivity.b0;
                NImageView nImageView = userBar4 == null ? null : (NImageView) userBar4.findViewById(R.id.ivBar);
                if (nImageView != null) {
                    nImageView.setAlpha(H0 / f2);
                }
                imageView10 = sellerDetailActivity.Y;
                if (imageView10 != null) {
                    imageView10.setAlpha(H0 / f2);
                }
                if (H0 == 0) {
                    imageView13 = sellerDetailActivity.Z;
                    if (imageView13 != null) {
                        imageView13.setAlpha(1.0f);
                    }
                    imageView14 = sellerDetailActivity.a0;
                    if (imageView14 != null) {
                        imageView14.setAlpha(1.0f);
                    }
                } else {
                    imageView11 = sellerDetailActivity.Z;
                    if (imageView11 != null) {
                        imageView11.setAlpha(H0 / f2);
                    }
                    imageView12 = sellerDetailActivity.a0;
                    if (imageView12 != null) {
                        imageView12.setAlpha(H0 / f2);
                    }
                }
            }
            if (abs > 0) {
                z2 = sellerDetailActivity.L;
                if (z2) {
                    sellerDetailActivity.L = false;
                    userBar2 = sellerDetailActivity.b0;
                    i hideUser = userBar2 == null ? null : userBar2.getHideUser();
                    if (hideUser != null) {
                        hideUser.setValue(Boolean.FALSE);
                    }
                    imageView5 = sellerDetailActivity.a0;
                    if (imageView5 != null) {
                        imageView5.setImageTintList(null);
                    }
                    imageView6 = sellerDetailActivity.a0;
                    if (imageView6 != null) {
                        imageView6.setImageTintList(null);
                    }
                    imageView7 = sellerDetailActivity.Y;
                    if (imageView7 != null) {
                        imageView7.setImageTintList(null);
                    }
                    imageView8 = sellerDetailActivity.Z;
                    if (imageView8 != null) {
                        imageView8.setImageTintList(null);
                    }
                    if (sellerDetailActivity.Z0() != Constants.Companion.getWAREHOUSE_SELLER_USER_ID()) {
                        textView2 = sellerDetailActivity.X;
                        ViewKt.n(textView2);
                        imageView9 = sellerDetailActivity.Y;
                        if (imageView9 != null) {
                            ViewKt.I(imageView9);
                        }
                    }
                }
            } else {
                z = sellerDetailActivity.L;
                if (!z && sellerDetailActivity.Z0() != Constants.Companion.getWAREHOUSE_SELLER_USER_ID()) {
                    sellerDetailActivity.L = true;
                    userBar = sellerDetailActivity.b0;
                    if (userBar != null) {
                        iVar = userBar.getHideUser();
                    }
                    if (iVar != null) {
                        iVar.setValue(Boolean.TRUE);
                    }
                    imageView = sellerDetailActivity.a0;
                    if (imageView != null) {
                        imageView.setImageTintList(ColorStateList.valueOf(-1));
                    }
                    imageView2 = sellerDetailActivity.Z;
                    if (imageView2 != null) {
                        imageView2.setImageTintList(ColorStateList.valueOf(-1));
                    }
                    imageView3 = sellerDetailActivity.Y;
                    if (imageView3 != null) {
                        imageView3.setImageTintList(ColorStateList.valueOf(Res.k(R.color.common_color_1)));
                    }
                    textView = sellerDetailActivity.X;
                    ViewKt.I(textView);
                    imageView4 = sellerDetailActivity.Y;
                    if (imageView4 != null) {
                        ViewKt.n(imageView4);
                    }
                }
            }
            Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
    }
}
