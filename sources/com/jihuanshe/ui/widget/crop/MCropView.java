package com.jihuanshe.ui.widget.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qq.e.comm.adevent.AdEventType;
import com.yalantis.ucrop.util.FastBitmapDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import h.k2.u.a;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class MCropView extends GestureCropImageView {
    @d
    private final ColorMatrix a;
    @d
    private final ColorMatrix b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final ColorMatrix f4261c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final ColorMatrix f4262d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final ColorMatrix f4263e;
    @e

    /* renamed from: f  reason: collision with root package name */
    private a<t1> f4264f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final int[][] f4265g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4266h;

    public MCropView(@e Context context) {
        super(context);
        this.a = new ColorMatrix();
        this.b = new ColorMatrix();
        this.f4261c = new ColorMatrix();
        this.f4262d = new ColorMatrix();
        this.f4263e = new ColorMatrix();
        this.f4265g = new int[][]{new int[]{255, 131, 0}, new int[]{255, 138, 18}, new int[]{255, 142, 33}, new int[]{255, 147, 44}, new int[]{255, 152, 54}, new int[]{255, 157, 63}, new int[]{255, 161, 72}, new int[]{255, 165, 79}, new int[]{255, 169, 87}, new int[]{255, 173, 94}, new int[]{255, 177, 101}, new int[]{255, 180, 107}, new int[]{255, 184, 114}, new int[]{255, 187, 120}, new int[]{255, 190, 126}, new int[]{255, 193, 132}, new int[]{255, 196, 137}, new int[]{255, 199, 143}, new int[]{255, AdEventType.VIDEO_CACHE, e.j.f.u.d.f11631g}, new int[]{255, AdEventType.VIDEO_PAUSE, 153}, new int[]{255, AdEventType.VIDEO_COMPLETE, 159}, new int[]{255, AdEventType.VIDEO_INIT, 163}, new int[]{255, AdEventType.VIDEO_LOADING, 168}, new int[]{255, AdEventType.VIDEO_PRELOAD_ERROR, 173}, new int[]{255, 215, 177}, new int[]{255, 217, 182}, new int[]{255, 219, 186}, new int[]{255, 221, 190}, new int[]{255, 223, 194}, new int[]{255, 225, 198}, new int[]{255, 227, AdEventType.VIDEO_START}, new int[]{255, 228, AdEventType.VIDEO_COMPLETE}, new int[]{255, 230, AdEventType.VIDEO_READY}, new int[]{255, 232, AdEventType.VIDEO_PRELOAD_ERROR}, new int[]{255, 233, 217}, new int[]{255, 235, 220}, new int[]{255, 236, 224}, new int[]{255, 238, 227}, new int[]{255, 239, 230}, new int[]{255, 240, 233}, new int[]{255, 242, 236}, new int[]{255, 243, 239}, new int[]{255, 244, 242}, new int[]{255, 245, 245}, new int[]{255, 246, 247}, new int[]{255, 248, 251}, new int[]{255, 249, 253}, new int[]{254, 249, 255}, new int[]{252, 247, 255}, new int[]{249, 246, 255}, new int[]{247, 245, 255}, new int[]{245, 243, 255}, new int[]{243, 242, 255}, new int[]{240, 241, 255}, new int[]{239, 240, 255}, new int[]{237, 239, 255}, new int[]{235, 238, 255}, new int[]{233, 237, 255}, new int[]{231, 236, 255}, new int[]{230, 235, 255}, new int[]{228, 234, 255}, new int[]{227, 233, 255}, new int[]{225, 232, 255}, new int[]{224, 231, 255}, new int[]{222, 230, 255}, new int[]{221, 230, 255}, new int[]{220, 229, 255}, new int[]{218, 229, 255}, new int[]{217, 227, 255}, new int[]{216, 227, 255}, new int[]{215, 226, 255}, new int[]{214, 225, 255}, new int[]{AdEventType.VIDEO_PRELOADED, 225, 255}, new int[]{AdEventType.VIDEO_LOADING, 224, 255}, new int[]{AdEventType.VIDEO_READY, 223, 255}, new int[]{AdEventType.VIDEO_INIT, 223, 255}, new int[]{AdEventType.VIDEO_CLICKED, 222, 255}, new int[]{AdEventType.VIDEO_ERROR, 221, 255}, new int[]{AdEventType.VIDEO_ERROR, 221, 255}, new int[]{AdEventType.VIDEO_COMPLETE, 220, 255}, new int[]{AdEventType.VIDEO_STOP, 220, 255}, new int[]{AdEventType.VIDEO_ERROR, 218, 255}, new int[]{AdEventType.VIDEO_ERROR, 218, 255}, new int[]{AdEventType.VIDEO_COMPLETE, 217, 255}, new int[]{AdEventType.VIDEO_STOP, 217, 255}, new int[]{AdEventType.VIDEO_PAUSE, 216, 255}, new int[]{AdEventType.VIDEO_PAUSE, 216, 255}, new int[]{AdEventType.VIDEO_START, 215, 255}, new int[]{AdEventType.VIDEO_START, 214, 255}, new int[]{200, AdEventType.VIDEO_PRELOAD_ERROR, 255}, new int[]{200, AdEventType.VIDEO_PRELOAD_ERROR, 255}, new int[]{199, AdEventType.VIDEO_PRELOADED, 255}, new int[]{198, AdEventType.VIDEO_PRELOADED, 255}, new int[]{198, AdEventType.VIDEO_PRELOADED, 255}, new int[]{197, AdEventType.VIDEO_LOADING, 255}, new int[]{197, AdEventType.VIDEO_LOADING, 255}, new int[]{197, AdEventType.VIDEO_READY, 255}, new int[]{196, AdEventType.VIDEO_READY, 255}, new int[]{195, AdEventType.VIDEO_READY, 255}, new int[]{195, AdEventType.VIDEO_INIT, 255}};
        this.f4266h = true;
    }

    public final boolean getCanTouch() {
        return this.f4266h;
    }

    @e
    public final a<t1> getImageListener() {
        return this.f4264f;
    }

    @d
    public final int[][] getKelvin_table() {
        return this.f4265g;
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    @e
    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof FastBitmapDrawable)) {
            return null;
        }
        Drawable drawable = getDrawable();
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type com.yalantis.ucrop.util.FastBitmapDrawable");
        Bitmap bitmap = ((FastBitmapDrawable) drawable).getBitmap();
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        Canvas canvas = new Canvas(copy);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(this.f4263e));
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    @Override // com.yalantis.ucrop.view.CropImageView, com.yalantis.ucrop.view.TransformImageView
    public void onImageLaidOut() {
        a<t1> aVar;
        super.onImageLaidOut();
        if (getDrawable() == null || (aVar = this.f4264f) == null) {
            return;
        }
        aVar.invoke();
    }

    @Override // com.yalantis.ucrop.view.GestureCropImageView, android.view.View
    public boolean onTouchEvent(@e MotionEvent motionEvent) {
        if (this.f4266h) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void setBright(float f2) {
        if (getDrawable() == null) {
            return;
        }
        this.a.reset();
        this.f4263e.reset();
        float f3 = (f2 / 100.0f) + 1.0f;
        this.a.setScale(f3, f3, f3, 1.0f);
        this.f4263e.postConcat(this.a);
        this.f4263e.postConcat(this.f4261c);
        this.f4263e.postConcat(this.b);
        this.f4263e.postConcat(this.f4262d);
        getDrawable().setColorFilter(new ColorMatrixColorFilter(this.f4263e));
        invalidate();
    }

    public final void setCanTouch(boolean z) {
        this.f4266h = z;
    }

    public final void setContrast(float f2) {
        if (getDrawable() == null) {
            return;
        }
        this.f4261c.reset();
        this.f4263e.reset();
        float f3 = (f2 / 100.0f) + 1.0f;
        this.f4261c.setScale(f3, f3, f3, 1.0f);
        float[] array = this.f4261c.getArray();
        float f4 = 128 * (1 - f3);
        array[4] = f4;
        array[9] = f4;
        array[14] = f4;
        this.f4263e.postConcat(this.a);
        this.f4263e.postConcat(this.f4261c);
        this.f4263e.postConcat(this.b);
        this.f4263e.postConcat(this.f4262d);
        getDrawable().setColorFilter(new ColorMatrixColorFilter(this.f4263e));
        invalidate();
    }

    public final void setImageListener(@e a<t1> aVar) {
        this.f4264f = aVar;
    }

    public final void setSuiation(float f2) {
        if (getDrawable() == null) {
            return;
        }
        this.b.reset();
        this.f4263e.reset();
        this.b.setSaturation((f2 / 100.0f) + 1.0f);
        this.f4263e.postConcat(this.a);
        this.f4263e.postConcat(this.f4261c);
        this.f4263e.postConcat(this.b);
        this.f4263e.postConcat(this.f4262d);
        getDrawable().setColorFilter(new ColorMatrixColorFilter(this.f4263e));
        invalidate();
    }

    public final void setTemp(int i2) {
        int i3 = 50 - (i2 < 0 ? i2 + 1 : i2);
        if (getDrawable() == null) {
            return;
        }
        this.f4262d.reset();
        this.f4263e.reset();
        if (i2 != 0) {
            ColorMatrix colorMatrix = this.f4262d;
            int[][] iArr = this.f4265g;
            colorMatrix.postConcat(new ColorMatrix(new float[]{iArr[i3][0] / 255.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, iArr[i3][1] / 255.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, iArr[i3][2] / 255.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        }
        this.f4263e.postConcat(this.a);
        this.f4263e.postConcat(this.f4261c);
        this.f4263e.postConcat(this.b);
        this.f4263e.postConcat(this.f4262d);
        getDrawable().setColorFilter(new ColorMatrixColorFilter(this.f4263e));
        invalidate();
    }

    public MCropView(@e Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ColorMatrix();
        this.b = new ColorMatrix();
        this.f4261c = new ColorMatrix();
        this.f4262d = new ColorMatrix();
        this.f4263e = new ColorMatrix();
        this.f4265g = new int[][]{new int[]{255, 131, 0}, new int[]{255, 138, 18}, new int[]{255, 142, 33}, new int[]{255, 147, 44}, new int[]{255, 152, 54}, new int[]{255, 157, 63}, new int[]{255, 161, 72}, new int[]{255, 165, 79}, new int[]{255, 169, 87}, new int[]{255, 173, 94}, new int[]{255, 177, 101}, new int[]{255, 180, 107}, new int[]{255, 184, 114}, new int[]{255, 187, 120}, new int[]{255, 190, 126}, new int[]{255, 193, 132}, new int[]{255, 196, 137}, new int[]{255, 199, 143}, new int[]{255, AdEventType.VIDEO_CACHE, e.j.f.u.d.f11631g}, new int[]{255, AdEventType.VIDEO_PAUSE, 153}, new int[]{255, AdEventType.VIDEO_COMPLETE, 159}, new int[]{255, AdEventType.VIDEO_INIT, 163}, new int[]{255, AdEventType.VIDEO_LOADING, 168}, new int[]{255, AdEventType.VIDEO_PRELOAD_ERROR, 173}, new int[]{255, 215, 177}, new int[]{255, 217, 182}, new int[]{255, 219, 186}, new int[]{255, 221, 190}, new int[]{255, 223, 194}, new int[]{255, 225, 198}, new int[]{255, 227, AdEventType.VIDEO_START}, new int[]{255, 228, AdEventType.VIDEO_COMPLETE}, new int[]{255, 230, AdEventType.VIDEO_READY}, new int[]{255, 232, AdEventType.VIDEO_PRELOAD_ERROR}, new int[]{255, 233, 217}, new int[]{255, 235, 220}, new int[]{255, 236, 224}, new int[]{255, 238, 227}, new int[]{255, 239, 230}, new int[]{255, 240, 233}, new int[]{255, 242, 236}, new int[]{255, 243, 239}, new int[]{255, 244, 242}, new int[]{255, 245, 245}, new int[]{255, 246, 247}, new int[]{255, 248, 251}, new int[]{255, 249, 253}, new int[]{254, 249, 255}, new int[]{252, 247, 255}, new int[]{249, 246, 255}, new int[]{247, 245, 255}, new int[]{245, 243, 255}, new int[]{243, 242, 255}, new int[]{240, 241, 255}, new int[]{239, 240, 255}, new int[]{237, 239, 255}, new int[]{235, 238, 255}, new int[]{233, 237, 255}, new int[]{231, 236, 255}, new int[]{230, 235, 255}, new int[]{228, 234, 255}, new int[]{227, 233, 255}, new int[]{225, 232, 255}, new int[]{224, 231, 255}, new int[]{222, 230, 255}, new int[]{221, 230, 255}, new int[]{220, 229, 255}, new int[]{218, 229, 255}, new int[]{217, 227, 255}, new int[]{216, 227, 255}, new int[]{215, 226, 255}, new int[]{214, 225, 255}, new int[]{AdEventType.VIDEO_PRELOADED, 225, 255}, new int[]{AdEventType.VIDEO_LOADING, 224, 255}, new int[]{AdEventType.VIDEO_READY, 223, 255}, new int[]{AdEventType.VIDEO_INIT, 223, 255}, new int[]{AdEventType.VIDEO_CLICKED, 222, 255}, new int[]{AdEventType.VIDEO_ERROR, 221, 255}, new int[]{AdEventType.VIDEO_ERROR, 221, 255}, new int[]{AdEventType.VIDEO_COMPLETE, 220, 255}, new int[]{AdEventType.VIDEO_STOP, 220, 255}, new int[]{AdEventType.VIDEO_ERROR, 218, 255}, new int[]{AdEventType.VIDEO_ERROR, 218, 255}, new int[]{AdEventType.VIDEO_COMPLETE, 217, 255}, new int[]{AdEventType.VIDEO_STOP, 217, 255}, new int[]{AdEventType.VIDEO_PAUSE, 216, 255}, new int[]{AdEventType.VIDEO_PAUSE, 216, 255}, new int[]{AdEventType.VIDEO_START, 215, 255}, new int[]{AdEventType.VIDEO_START, 214, 255}, new int[]{200, AdEventType.VIDEO_PRELOAD_ERROR, 255}, new int[]{200, AdEventType.VIDEO_PRELOAD_ERROR, 255}, new int[]{199, AdEventType.VIDEO_PRELOADED, 255}, new int[]{198, AdEventType.VIDEO_PRELOADED, 255}, new int[]{198, AdEventType.VIDEO_PRELOADED, 255}, new int[]{197, AdEventType.VIDEO_LOADING, 255}, new int[]{197, AdEventType.VIDEO_LOADING, 255}, new int[]{197, AdEventType.VIDEO_READY, 255}, new int[]{196, AdEventType.VIDEO_READY, 255}, new int[]{195, AdEventType.VIDEO_READY, 255}, new int[]{195, AdEventType.VIDEO_INIT, 255}};
        this.f4266h = true;
    }

    public MCropView(@e Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new ColorMatrix();
        this.b = new ColorMatrix();
        this.f4261c = new ColorMatrix();
        this.f4262d = new ColorMatrix();
        this.f4263e = new ColorMatrix();
        this.f4265g = new int[][]{new int[]{255, 131, 0}, new int[]{255, 138, 18}, new int[]{255, 142, 33}, new int[]{255, 147, 44}, new int[]{255, 152, 54}, new int[]{255, 157, 63}, new int[]{255, 161, 72}, new int[]{255, 165, 79}, new int[]{255, 169, 87}, new int[]{255, 173, 94}, new int[]{255, 177, 101}, new int[]{255, 180, 107}, new int[]{255, 184, 114}, new int[]{255, 187, 120}, new int[]{255, 190, 126}, new int[]{255, 193, 132}, new int[]{255, 196, 137}, new int[]{255, 199, 143}, new int[]{255, AdEventType.VIDEO_CACHE, e.j.f.u.d.f11631g}, new int[]{255, AdEventType.VIDEO_PAUSE, 153}, new int[]{255, AdEventType.VIDEO_COMPLETE, 159}, new int[]{255, AdEventType.VIDEO_INIT, 163}, new int[]{255, AdEventType.VIDEO_LOADING, 168}, new int[]{255, AdEventType.VIDEO_PRELOAD_ERROR, 173}, new int[]{255, 215, 177}, new int[]{255, 217, 182}, new int[]{255, 219, 186}, new int[]{255, 221, 190}, new int[]{255, 223, 194}, new int[]{255, 225, 198}, new int[]{255, 227, AdEventType.VIDEO_START}, new int[]{255, 228, AdEventType.VIDEO_COMPLETE}, new int[]{255, 230, AdEventType.VIDEO_READY}, new int[]{255, 232, AdEventType.VIDEO_PRELOAD_ERROR}, new int[]{255, 233, 217}, new int[]{255, 235, 220}, new int[]{255, 236, 224}, new int[]{255, 238, 227}, new int[]{255, 239, 230}, new int[]{255, 240, 233}, new int[]{255, 242, 236}, new int[]{255, 243, 239}, new int[]{255, 244, 242}, new int[]{255, 245, 245}, new int[]{255, 246, 247}, new int[]{255, 248, 251}, new int[]{255, 249, 253}, new int[]{254, 249, 255}, new int[]{252, 247, 255}, new int[]{249, 246, 255}, new int[]{247, 245, 255}, new int[]{245, 243, 255}, new int[]{243, 242, 255}, new int[]{240, 241, 255}, new int[]{239, 240, 255}, new int[]{237, 239, 255}, new int[]{235, 238, 255}, new int[]{233, 237, 255}, new int[]{231, 236, 255}, new int[]{230, 235, 255}, new int[]{228, 234, 255}, new int[]{227, 233, 255}, new int[]{225, 232, 255}, new int[]{224, 231, 255}, new int[]{222, 230, 255}, new int[]{221, 230, 255}, new int[]{220, 229, 255}, new int[]{218, 229, 255}, new int[]{217, 227, 255}, new int[]{216, 227, 255}, new int[]{215, 226, 255}, new int[]{214, 225, 255}, new int[]{AdEventType.VIDEO_PRELOADED, 225, 255}, new int[]{AdEventType.VIDEO_LOADING, 224, 255}, new int[]{AdEventType.VIDEO_READY, 223, 255}, new int[]{AdEventType.VIDEO_INIT, 223, 255}, new int[]{AdEventType.VIDEO_CLICKED, 222, 255}, new int[]{AdEventType.VIDEO_ERROR, 221, 255}, new int[]{AdEventType.VIDEO_ERROR, 221, 255}, new int[]{AdEventType.VIDEO_COMPLETE, 220, 255}, new int[]{AdEventType.VIDEO_STOP, 220, 255}, new int[]{AdEventType.VIDEO_ERROR, 218, 255}, new int[]{AdEventType.VIDEO_ERROR, 218, 255}, new int[]{AdEventType.VIDEO_COMPLETE, 217, 255}, new int[]{AdEventType.VIDEO_STOP, 217, 255}, new int[]{AdEventType.VIDEO_PAUSE, 216, 255}, new int[]{AdEventType.VIDEO_PAUSE, 216, 255}, new int[]{AdEventType.VIDEO_START, 215, 255}, new int[]{AdEventType.VIDEO_START, 214, 255}, new int[]{200, AdEventType.VIDEO_PRELOAD_ERROR, 255}, new int[]{200, AdEventType.VIDEO_PRELOAD_ERROR, 255}, new int[]{199, AdEventType.VIDEO_PRELOADED, 255}, new int[]{198, AdEventType.VIDEO_PRELOADED, 255}, new int[]{198, AdEventType.VIDEO_PRELOADED, 255}, new int[]{197, AdEventType.VIDEO_LOADING, 255}, new int[]{197, AdEventType.VIDEO_LOADING, 255}, new int[]{197, AdEventType.VIDEO_READY, 255}, new int[]{196, AdEventType.VIDEO_READY, 255}, new int[]{195, AdEventType.VIDEO_READY, 255}, new int[]{195, AdEventType.VIDEO_INIT, 255}};
        this.f4266h = true;
    }
}
