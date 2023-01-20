package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class KeyPositionBase extends Key {
    public static final float SELECTION_SLOPE = 20.0f;
    public int mCurveFit = Key.UNSET;

    public abstract void calcPosition(int layoutWidth, int layoutHeight, float start_x, float start_y, float end_x, float end_y);

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> attributes) {
    }

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int layoutWidth, int layoutHeight, RectF start, RectF end, float x, float y);

    public abstract void positionAttributes(View view, RectF start, RectF end, float x, float y, String[] attribute, float[] value);
}
