package com.vector.ext;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class DrawableKt$toBitmap$1 extends FunctionReferenceImpl implements l<Canvas, t1> {
    public DrawableKt$toBitmap$1(Drawable drawable) {
        super(1, drawable, Drawable.class, "draw", "draw(Landroid/graphics/Canvas;)V", 0);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Canvas canvas) {
        invoke2(canvas);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Canvas canvas) {
        ((Drawable) this.receiver).draw(canvas);
    }
}
