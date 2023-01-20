package com.vector.view;

import android.graphics.Paint;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ToggleButton$circleEdgeP$2 extends Lambda implements a<Paint> {
    public final /* synthetic */ ToggleButton this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToggleButton$circleEdgeP$2(ToggleButton toggleButton) {
        super(0);
        this.this$0 = toggleButton;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final Paint invoke() {
        int i2;
        Paint paint = new Paint();
        i2 = this.this$0.t;
        paint.setColor(i2);
        paint.setStrokeWidth(this.this$0.f7951e);
        return paint;
    }
}
