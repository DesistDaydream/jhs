package com.vector.ext;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroid/graphics/Canvas;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BitmapKt$copy$1 extends Lambda implements l<Canvas, t1> {
    public final /* synthetic */ Matrix $matrix;
    public final /* synthetic */ Bitmap $this_copy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BitmapKt$copy$1(Bitmap bitmap, Matrix matrix) {
        super(1);
        this.$this_copy = bitmap;
        this.$matrix = matrix;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Canvas canvas) {
        invoke2(canvas);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Canvas canvas) {
        canvas.drawBitmap(this.$this_copy, this.$matrix, null);
    }
}
