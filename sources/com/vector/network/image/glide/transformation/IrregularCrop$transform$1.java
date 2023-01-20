package com.vector.network.image.glide.transformation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.vector.ext.BitmapKt;
import e.t.a;
import e.t.u.c;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroid/graphics/Canvas;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IrregularCrop$transform$1 extends Lambda implements l<Canvas, t1> {
    public final /* synthetic */ int $outHeight;
    public final /* synthetic */ int $outWidth;
    public final /* synthetic */ Bitmap $toTransform;
    public final /* synthetic */ IrregularCrop this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IrregularCrop$transform$1(IrregularCrop irregularCrop, int i2, int i3, Bitmap bitmap) {
        super(1);
        this.this$0 = irregularCrop;
        this.$outWidth = i2;
        this.$outHeight = i3;
        this.$toTransform = bitmap;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Canvas canvas) {
        invoke2(canvas);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Canvas canvas) {
        Bitmap s = c.a.s(a.b(), this.this$0.d());
        if (s == null) {
            return;
        }
        Bitmap s2 = BitmapKt.s(s, this.$outWidth, this.$outHeight);
        s.recycle();
        canvas.drawBitmap(s2, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(this.$toTransform, 0.0f, 0.0f, paint);
    }
}
