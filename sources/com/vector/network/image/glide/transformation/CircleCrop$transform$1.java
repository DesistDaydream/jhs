package com.vector.network.image.glide.transformation;

import android.graphics.Canvas;
import android.graphics.Paint;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroid/graphics/Canvas;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CircleCrop$transform$1 extends Lambda implements l<Canvas, t1> {
    public final /* synthetic */ int $outHeight;
    public final /* synthetic */ int $outWidth;
    public final /* synthetic */ CircleCrop this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleCrop$transform$1(CircleCrop circleCrop, int i2, int i3) {
        super(1);
        this.this$0 = circleCrop;
        this.$outWidth = i2;
        this.$outHeight = i3;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Canvas canvas) {
        invoke2(canvas);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Canvas canvas) {
        int i2;
        float f2;
        float f3;
        Paint paint = new Paint();
        i2 = this.this$0.f7831d;
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        f2 = this.this$0.f7830c;
        paint.setStrokeWidth(f2);
        float min = Math.min(this.$outWidth, this.$outHeight) / 2.0f;
        f3 = this.this$0.f7830c;
        canvas.drawCircle(min, min, min - (f3 / 2), paint);
    }
}
