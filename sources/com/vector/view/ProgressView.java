package com.vector.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.h;
import h.k2.v.u;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/vector/view/ProgressView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anim", "Landroid/view/animation/Animation;", "getAnim", "()Landroid/view/animation/Animation;", "anim$delegate", "Lkotlin/Lazy;", "duration", "", "getDuration", "()J", "isForcePaused", "", "onAttachedToWindow", "", "onDetachedFromWindow", MessageKey.MSG_ACCEPT_TIME_START, "stop", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ProgressView extends AppCompatImageView {
    @d
    private final w a;
    private boolean b;

    @h
    public ProgressView(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public ProgressView(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ProgressView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final Animation getAnim() {
        return (Animation) this.a.getValue();
    }

    private final long getDuration() {
        return 500L;
    }

    public final void A() {
        this.b = false;
        clearAnimation();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b) {
            z();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getAnimation() != null) {
            this.b = true;
            clearAnimation();
        }
    }

    public final void z() {
        startAnimation(getAnim());
    }

    @h
    public ProgressView(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = z.c(new ProgressView$anim$2(context));
        setScaleType(ImageView.ScaleType.FIT_XY);
        getAnim().setDuration(getDuration());
    }
}
