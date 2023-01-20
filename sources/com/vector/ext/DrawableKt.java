package com.vector.ext;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0005"}, d2 = {"setIntrinsicBounds", "", "Landroid/graphics/drawable/Drawable;", "toBitmap", "Landroid/graphics/Bitmap;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DrawableKt {
    public static final void a(@d Drawable drawable) {
        if (drawable.getBounds().isEmpty()) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @d
    public static final Bitmap b(@d Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        return BitmapKt.a(Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565), new DrawableKt$toBitmap$1(drawable));
    }
}
