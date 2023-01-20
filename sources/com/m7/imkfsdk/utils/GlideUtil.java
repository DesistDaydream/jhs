package com.m7.imkfsdk.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.m7.imkfsdk.R;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import e.b.a.c;
import e.b.a.p.m.d.b0;
import e.b.a.p.m.d.n;
import e.b.a.t.g;
import e.b.a.t.h;

/* loaded from: classes2.dex */
public class GlideUtil {
    public static void loadCircleImage(Context context, String str, ImageView imageView) {
        c.D(context).k(str).y0(R.drawable.ykfsdk_kf_pic_thumb_bg).z(R.drawable.ykfsdk_image_download_fail_icon).l(h.U0(new n())).m1(imageView);
    }

    public static void loadFirstFrame(Context context, String str, ImageView imageView) {
        c.D(context).k(str).z(R.drawable.ykfsdk_image_download_fail_icon).F(0L).m1(imageView);
    }

    public static void loadHeader(Context context, String str, int i2, int i3, ImageView imageView) {
        c.D(context).k(str).y0(i2).z(i3).l(h.U0(new b0(MoorDensityUtil.dp2px(8.0f)))).m1(imageView);
    }

    public static void loadImage(Context context, String str, float f2, ImageView imageView) {
        c.D(context).k(str).y0(R.drawable.ykfsdk_kf_pic_thumb_bg).z(R.drawable.ykfsdk_image_download_fail_icon).l(h.U0(new b0(MoorDensityUtil.dp2px(f2)))).m1(imageView);
    }

    public static void loadImageNoRounder(Context context, String str, ImageView imageView) {
        c.D(context).k(str).y0(R.drawable.ykfsdk_kf_pic_thumb_bg).z(R.drawable.ykfsdk_image_download_fail_icon).m1(imageView);
    }

    public static void loadCircleImage(Context context, String str, int i2, ImageView imageView) {
        c.D(context).k(str).y0(i2).z(i2).l(h.U0(new n())).m1(imageView);
    }

    public static void loadImage(Context context, String str, ImageView imageView) {
        loadImage(context, str, 8.0f, imageView);
    }

    public static void loadImage(Context context, String str, ImageView imageView, g<Drawable> gVar) {
        c.D(context).k(str).y0(R.drawable.ykfsdk_kf_pic_thumb_bg).z(R.drawable.ykfsdk_image_download_fail_icon).U0(gVar).m1(imageView);
    }
}
