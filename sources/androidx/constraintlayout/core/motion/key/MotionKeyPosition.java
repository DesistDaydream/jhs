package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import c.c.a.a.b.f;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public class MotionKeyPosition extends MotionKey {
    public static final int KEY_TYPE = 2;
    public static final String NAME = "KeyPosition";
    public static final float SELECTION_SLOPE = 20.0f;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX;
    public float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    public int mCurveFit;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing;

    public MotionKeyPosition() {
        int i2 = MotionKey.UNSET;
        this.mCurveFit = i2;
        this.mTransitionEasing = null;
        this.mPathMotionArc = i2;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    private void calcCartesianPosition(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float f8 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f9 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f10 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        this.mCalculatedPositionX = (int) (f2 + (f8 * f6) + ((Float.isNaN(this.mAltPercentX) ? 0.0f : this.mAltPercentX) * f7));
        this.mCalculatedPositionY = (int) (f3 + (f6 * f9) + (f7 * f10));
    }

    private void calcPathPosition(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float f8 = this.mPercentX;
        float f9 = this.mPercentY;
        this.mCalculatedPositionX = f2 + (f6 * f8) + ((-f7) * f9);
        this.mCalculatedPositionY = f3 + (f7 * f8) + (f6 * f9);
    }

    private void calcScreenPosition(int i2, int i3) {
        float f2 = this.mPercentX;
        float f3 = 0;
        this.mCalculatedPositionX = ((i2 - 0) * f2) + f3;
        this.mCalculatedPositionY = ((i3 - 0) * f2) + f3;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    public void calcPosition(int i2, int i3, float f2, float f3, float f4, float f5) {
        int i4 = this.mPositionType;
        if (i4 == 1) {
            calcPathPosition(f2, f3, f4, f5);
        } else if (i4 != 2) {
            calcCartesianPosition(f2, f3, f4, f5);
        } else {
            calcScreenPosition(i2, i3);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.mTransitionEasing = motionKeyPosition.mTransitionEasing;
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mPercentWidth = motionKeyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = motionKeyPosition.mPercentX;
        this.mPercentY = motionKeyPosition.mPercentY;
        this.mAltPercentX = motionKeyPosition.mAltPercentX;
        this.mAltPercentY = motionKeyPosition.mAltPercentY;
        this.mCalculatedPositionX = motionKeyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = motionKeyPosition.mCalculatedPositionY;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return f.a(str);
    }

    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int i2, int i3, FloatRect floatRect, FloatRect floatRect2, float f2, float f3) {
        calcPosition(i2, i3, floatRect.centerX(), floatRect.centerY(), floatRect2.centerX(), floatRect2.centerY());
        return Math.abs(f2 - this.mCalculatedPositionX) < 20.0f && Math.abs(f3 - this.mCalculatedPositionY) < 20.0f;
    }

    public void positionAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f2, float f3, String[] strArr, float[] fArr) {
        int i2 = this.mPositionType;
        if (i2 == 1) {
            positionPathAttributes(floatRect, floatRect2, f2, f3, strArr, fArr);
        } else if (i2 != 2) {
            positionCartAttributes(floatRect, floatRect2, f2, f3, strArr, fArr);
        } else {
            positionScreenAttributes(motionWidget, floatRect, floatRect2, f2, f3, strArr, fArr);
        }
    }

    public void positionCartAttributes(FloatRect floatRect, FloatRect floatRect2, float f2, float f3, String[] strArr, float[] fArr) {
        float centerX = floatRect.centerX();
        float centerY = floatRect.centerY();
        float centerX2 = floatRect2.centerX() - centerX;
        float centerY2 = floatRect2.centerY() - centerY;
        if (strArr[0] != null) {
            if ("percentX".equals(strArr[0])) {
                fArr[0] = (f2 - centerX) / centerX2;
                fArr[1] = (f3 - centerY) / centerY2;
                return;
            }
            fArr[1] = (f2 - centerX) / centerX2;
            fArr[0] = (f3 - centerY) / centerY2;
            return;
        }
        strArr[0] = "percentX";
        fArr[0] = (f2 - centerX) / centerX2;
        strArr[1] = "percentY";
        fArr[1] = (f3 - centerY) / centerY2;
    }

    public void positionPathAttributes(FloatRect floatRect, FloatRect floatRect2, float f2, float f3, String[] strArr, float[] fArr) {
        float centerX = floatRect.centerX();
        float centerY = floatRect.centerY();
        float centerX2 = floatRect2.centerX() - centerX;
        float centerY2 = floatRect2.centerY() - centerY;
        float hypot = (float) Math.hypot(centerX2, centerY2);
        if (hypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f4 = centerX2 / hypot;
        float f5 = centerY2 / hypot;
        float f6 = f3 - centerY;
        float f7 = f2 - centerX;
        float f8 = ((f4 * f6) - (f7 * f5)) / hypot;
        float f9 = ((f4 * f7) + (f5 * f6)) / hypot;
        if (strArr[0] != null) {
            if ("percentX".equals(strArr[0])) {
                fArr[0] = f9;
                fArr[1] = f8;
                return;
            }
            return;
        }
        strArr[0] = "percentX";
        strArr[1] = "percentY";
        fArr[0] = f9;
        fArr[1] = f8;
    }

    public void positionScreenAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f2, float f3, String[] strArr, float[] fArr) {
        floatRect.centerX();
        floatRect.centerY();
        floatRect2.centerX();
        floatRect2.centerY();
        MotionWidget parent = motionWidget.getParent();
        int width = parent.getWidth();
        int height = parent.getHeight();
        if (strArr[0] != null) {
            if ("percentX".equals(strArr[0])) {
                fArr[0] = f2 / width;
                fArr[1] = f3 / height;
                return;
            }
            fArr[1] = f2 / width;
            fArr[0] = f3 / height;
            return;
        }
        strArr[0] = "percentX";
        fArr[0] = f2 / width;
        strArr[1] = "percentY";
        fArr[1] = f3 / height;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, int i3) {
        if (i2 == 100) {
            this.mFramePosition = i3;
            return true;
        } else if (i2 == 508) {
            this.mCurveFit = i3;
            return true;
        } else if (i2 != 510) {
            return super.setValue(i2, i3);
        } else {
            this.mPositionType = i3;
            return true;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return new MotionKeyPosition().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, float f2) {
        switch (i2) {
            case 503:
                this.mPercentWidth = f2;
                return true;
            case TypedValues.Position.TYPE_PERCENT_HEIGHT /* 504 */:
                this.mPercentHeight = f2;
                return true;
            case TypedValues.Position.TYPE_SIZE_PERCENT /* 505 */:
                this.mPercentWidth = f2;
                this.mPercentHeight = f2;
                return true;
            case TypedValues.Position.TYPE_PERCENT_X /* 506 */:
                this.mPercentX = f2;
                return true;
            case TypedValues.Position.TYPE_PERCENT_Y /* 507 */:
                this.mPercentY = f2;
                return true;
            default:
                return super.setValue(i2, f2);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, String str) {
        if (i2 != 501) {
            return super.setValue(i2, str);
        }
        this.mTransitionEasing = str.toString();
        return true;
    }
}
