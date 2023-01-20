package com.vector.ext;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroid/graphics/Canvas;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BitmapKt$toCircle$1 extends Lambda implements l<Canvas, t1> {
    public final /* synthetic */ int $min;
    public final /* synthetic */ Paint $paint;
    public final /* synthetic */ Bitmap $this_toCircle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BitmapKt$toCircle$1(int i2, Paint paint, Bitmap bitmap) {
        super(1);
        this.$min = i2;
        this.$paint = paint;
        this.$this_toCircle = bitmap;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Canvas canvas) {
        invoke2(canvas);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Canvas canvas) {
        int i2 = this.$min;
        canvas.drawCircle(i2 / 2.0f, i2 / 2.0f, i2 / 2.0f, this.$paint);
        this.$paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.$this_toCircle, 0.0f, 0.0f, this.$paint);
    }
}
