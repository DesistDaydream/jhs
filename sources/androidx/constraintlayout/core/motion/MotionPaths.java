package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    public static final int OFF_HEIGHT = 4;
    public static final int OFF_PATH_ROTATE = 5;
    public static final int OFF_POSITION = 0;
    public static final int OFF_WIDTH = 3;
    public static final int OFF_X = 1;
    public static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    public static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    public HashMap<String, CustomVariable> customAttributes;
    public float height;
    public int mAnimateCircleAngleTo;
    public int mAnimateRelativeTo;
    public int mDrawPath;
    public Easing mKeyFrameEasing;
    public int mMode;
    public int mPathMotionArc;
    public float mPathRotate;
    public float mProgress;
    public float mRelativeAngle;
    public Motion mRelativeToController;
    public double[] mTempDelta;
    public double[] mTempValue;
    public float position;
    public float time;
    public float width;
    public float x;
    public float y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    private static final float xRotate(float f2, float f3, float f4, float f5, float f6, float f7) {
        return (((f6 - f4) * f3) - ((f7 - f5) * f2)) + f4;
    }

    private static final float yRotate(float f2, float f3, float f4, float f5, float f6, float f7) {
        return ((f6 - f4) * f2) + ((f7 - f5) * f3) + f5;
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.motion.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.propertySet.mProgress;
        this.mRelativeAngle = 0.0f;
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.customAttributes.put(str, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean diff = diff(this.x, motionPaths.x);
        boolean diff2 = diff(this.y, motionPaths.y);
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        boolean z2 = diff | diff2 | z;
        zArr[1] = zArr[1] | z2;
        zArr[2] = z2 | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] < 6) {
                dArr[i2] = fArr[iArr[i3]];
                i2++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.width;
        float f3 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f4 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 3) {
                f2 = f4;
            } else if (i4 == 4) {
                f3 = f4;
            }
        }
        fArr[i2] = f2;
        fArr[i2 + 1] = f3;
    }

    public void getCenter(double d2, int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.width;
        float f5 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d2, fArr2, new float[2]);
            float f7 = fArr2[0];
            float f8 = fArr2[1];
            double d3 = f7;
            double d4 = f2;
            double d5 = f3;
            f2 = (float) ((d3 + (Math.sin(d5) * d4)) - (f4 / 2.0f));
            f3 = (float) ((f8 - (d4 * Math.cos(d5))) - (f5 / 2.0f));
        }
        fArr[i2] = f2 + (f4 / 2.0f) + 0.0f;
        fArr[i2 + 1] = f3 + (f5 / 2.0f) + 0.0f;
    }

    public void getCenterVelocity(double d2, int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.width;
        float f5 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d2, fArr2, new float[2]);
            float f7 = fArr2[0];
            float f8 = fArr2[1];
            double d3 = f7;
            double d4 = f2;
            double d5 = f3;
            f2 = (float) ((d3 + (Math.sin(d5) * d4)) - (f4 / 2.0f));
            f3 = (float) ((f8 - (d4 * Math.cos(d5))) - (f5 / 2.0f));
        }
        fArr[i2] = f2 + (f4 / 2.0f) + 0.0f;
        fArr[i2 + 1] = f3 + (f5 / 2.0f) + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i2) {
        CustomVariable customVariable = this.customAttributes.get(str);
        int i3 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i2] = customVariable.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        float[] fArr = new float[numberOfInterpolatedValues];
        customVariable.getValuesToInterpolate(fArr);
        while (i3 < numberOfInterpolatedValues) {
            dArr[i2] = fArr[i3];
            i3++;
            i2++;
        }
        return numberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.customAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.width;
        float f5 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            double d2 = f2;
            double d3 = f3;
            f3 = (float) ((this.mRelativeToController.getCenterY() - (d2 * Math.cos(d3))) - (f5 / 2.0f));
            f2 = (float) ((centerX + (Math.sin(d3) * d2)) - (f4 / 2.0f));
        }
        float f7 = f4 + f2;
        float f8 = f5 + f3;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i5 = i2 + 1;
        fArr[i2] = f2 + 0.0f;
        int i6 = i5 + 1;
        fArr[i5] = f3 + 0.0f;
        int i7 = i6 + 1;
        fArr[i6] = f7 + 0.0f;
        int i8 = i7 + 1;
        fArr[i7] = f3 + 0.0f;
        int i9 = i8 + 1;
        fArr[i8] = f7 + 0.0f;
        int i10 = i9 + 1;
        fArr[i9] = f8 + 0.0f;
        fArr[i10] = f2 + 0.0f;
        fArr[i10 + 1] = f8 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.customAttributes.containsKey(str);
    }

    public void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f3 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f2 : motionKeyPosition.mPercentWidth;
        float f4 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f2 : motionKeyPosition.mPercentHeight;
        float f5 = motionPaths2.width;
        float f6 = motionPaths.width;
        float f7 = motionPaths2.height;
        float f8 = motionPaths.height;
        this.position = this.time;
        float f9 = motionPaths.x;
        float f10 = motionPaths.y;
        float f11 = (motionPaths2.x + (f5 / 2.0f)) - ((f6 / 2.0f) + f9);
        float f12 = (motionPaths2.y + (f7 / 2.0f)) - (f10 + (f8 / 2.0f));
        float f13 = (f5 - f6) * f3;
        float f14 = f13 / 2.0f;
        this.x = (int) ((f9 + (f11 * f2)) - f14);
        float f15 = (f7 - f8) * f4;
        float f16 = f15 / 2.0f;
        this.y = (int) ((f10 + (f12 * f2)) - f16);
        this.width = (int) (f6 + f13);
        this.height = (int) (f8 + f15);
        float f17 = Float.isNaN(motionKeyPosition.mPercentX) ? f2 : motionKeyPosition.mPercentX;
        float f18 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            f2 = motionKeyPosition.mPercentY;
        }
        float f19 = Float.isNaN(motionKeyPosition.mAltPercentX) ? 0.0f : motionKeyPosition.mAltPercentX;
        this.mMode = 0;
        this.x = (int) (((motionPaths.x + (f17 * f11)) + (f19 * f12)) - f14);
        this.y = (int) (((motionPaths.y + (f11 * f18)) + (f12 * f2)) - f16);
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2;
        float f3;
        float f4 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f4;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f5 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f4 : motionKeyPosition.mPercentWidth;
        float f6 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f4 : motionKeyPosition.mPercentHeight;
        float f7 = motionPaths2.width - motionPaths.width;
        float f8 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            f4 = motionKeyPosition.mPercentX;
        }
        float f9 = motionPaths.x;
        float f10 = motionPaths.width;
        float f11 = motionPaths.y;
        float f12 = motionPaths.height;
        float f13 = (motionPaths2.x + (motionPaths2.width / 2.0f)) - ((f10 / 2.0f) + f9);
        float f14 = (motionPaths2.y + (motionPaths2.height / 2.0f)) - ((f12 / 2.0f) + f11);
        float f15 = f13 * f4;
        float f16 = (f7 * f5) / 2.0f;
        this.x = (int) ((f9 + f15) - f16);
        float f17 = f4 * f14;
        float f18 = (f8 * f6) / 2.0f;
        this.y = (int) ((f11 + f17) - f18);
        this.width = (int) (f10 + f2);
        this.height = (int) (f12 + f3);
        float f19 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        this.mMode = 1;
        float f20 = (int) ((motionPaths.x + f15) - f16);
        this.x = f20;
        float f21 = (int) ((motionPaths.y + f17) - f18);
        this.y = f21;
        this.x = f20 + ((-f14) * f19);
        this.y = f21 + (f13 * f19);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPolar(int i2, int i3, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float min;
        float f2;
        float f3 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f3;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        float f4 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f3 : motionKeyPosition.mPercentWidth;
        float f5 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f3 : motionKeyPosition.mPercentHeight;
        float f6 = motionPaths2.width;
        float f7 = motionPaths.width;
        float f8 = motionPaths2.height;
        float f9 = motionPaths.height;
        this.position = this.time;
        this.width = (int) (f7 + ((f6 - f7) * f4));
        this.height = (int) (f9 + ((f8 - f9) * f5));
        int i4 = motionKeyPosition.mPositionType;
        if (i4 == 1) {
            float f10 = Float.isNaN(motionKeyPosition.mPercentX) ? f3 : motionKeyPosition.mPercentX;
            float f11 = motionPaths2.x;
            float f12 = motionPaths.x;
            this.x = (f10 * (f11 - f12)) + f12;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f3 = motionKeyPosition.mPercentY;
            }
            float f13 = motionPaths2.y;
            float f14 = motionPaths.y;
            this.y = (f3 * (f13 - f14)) + f14;
        } else if (i4 != 2) {
            float f15 = Float.isNaN(motionKeyPosition.mPercentX) ? f3 : motionKeyPosition.mPercentX;
            float f16 = motionPaths2.x;
            float f17 = motionPaths.x;
            this.x = (f15 * (f16 - f17)) + f17;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f3 = motionKeyPosition.mPercentY;
            }
            float f18 = motionPaths2.y;
            float f19 = motionPaths.y;
            this.y = (f3 * (f18 - f19)) + f19;
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f20 = motionPaths2.x;
                float f21 = motionPaths.x;
                min = ((f20 - f21) * f3) + f21;
            } else {
                min = Math.min(f5, f4) * motionKeyPosition.mPercentX;
            }
            this.x = min;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f22 = motionPaths2.y;
                float f23 = motionPaths.y;
                f2 = (f3 * (f22 - f23)) + f23;
            } else {
                f2 = motionKeyPosition.mPercentY;
            }
            this.y = f2;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initScreen(int i2, int i3, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f3 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f2 : motionKeyPosition.mPercentWidth;
        float f4 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f2 : motionKeyPosition.mPercentHeight;
        float f5 = motionPaths2.width;
        float f6 = motionPaths.width;
        float f7 = motionPaths2.height;
        float f8 = motionPaths.height;
        this.position = this.time;
        float f9 = motionPaths.x;
        float f10 = motionPaths.y;
        float f11 = motionPaths2.x + (f5 / 2.0f);
        float f12 = motionPaths2.y + (f7 / 2.0f);
        float f13 = (f5 - f6) * f3;
        this.x = (int) ((f9 + ((f11 - ((f6 / 2.0f) + f9)) * f2)) - (f13 / 2.0f));
        float f14 = (f7 - f8) * f4;
        this.y = (int) ((f10 + ((f12 - (f10 + (f8 / 2.0f))) * f2)) - (f14 / 2.0f));
        this.width = (int) (f6 + f13);
        this.height = (int) (f8 + f14);
        this.mMode = 2;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.x = (int) (motionKeyPosition.mPercentX * ((int) (i2 - this.width)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.y = (int) (motionKeyPosition.mPercentY * ((int) (i3 - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    public void setDpDt(float f2, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f8 = (float) dArr[i2];
            double d2 = dArr2[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f4 = f8;
            } else if (i3 == 2) {
                f6 = f8;
            } else if (i3 == 3) {
                f5 = f8;
            } else if (i3 == 4) {
                f7 = f8;
            }
        }
        float f9 = f4 - ((0.0f * f5) / 2.0f);
        float f10 = f6 - ((0.0f * f7) / 2.0f);
        fArr[0] = (f9 * (1.0f - f2)) + (((f5 * 1.0f) + f9) * f2) + 0.0f;
        fArr[1] = (f10 * (1.0f - f3)) + (((f7 * 1.0f) + f10) * f3) + 0.0f;
    }

    public void setView(float f2, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f3;
        float f4;
        float f5 = this.x;
        float f6 = this.y;
        float f7 = this.width;
        float f8 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i2 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i2];
            this.mTempDelta = new double[i2];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.mTempValue[iArr[i3]] = dArr[i3];
            this.mTempDelta[iArr[i3]] = dArr2[i3];
        }
        float f9 = Float.NaN;
        int i4 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (true) {
            double[] dArr4 = this.mTempValue;
            if (i4 >= dArr4.length) {
                break;
            }
            if (Double.isNaN(dArr4[i4]) && (dArr3 == null || dArr3[i4] == 0.0d)) {
                f4 = f9;
            } else {
                double d2 = dArr3 != null ? dArr3[i4] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i4])) {
                    d2 = this.mTempValue[i4] + d2;
                }
                f4 = f9;
                float f14 = (float) d2;
                float f15 = (float) this.mTempDelta[i4];
                if (i4 == 1) {
                    f9 = f4;
                    f10 = f15;
                    f5 = f14;
                } else if (i4 == 2) {
                    f9 = f4;
                    f11 = f15;
                    f6 = f14;
                } else if (i4 == 3) {
                    f9 = f4;
                    f12 = f15;
                    f7 = f14;
                } else if (i4 == 4) {
                    f9 = f4;
                    f13 = f15;
                    f8 = f14;
                } else if (i4 == 5) {
                    f9 = f14;
                }
                i4++;
            }
            f9 = f4;
            i4++;
        }
        float f16 = f9;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter(f2, fArr, fArr2);
            float f17 = fArr[0];
            float f18 = fArr[1];
            float f19 = fArr2[0];
            float f20 = fArr2[1];
            double d3 = f5;
            double d4 = f6;
            float sin = (float) ((f17 + (Math.sin(d4) * d3)) - (f7 / 2.0f));
            f3 = f8;
            float cos = (float) ((f18 - (Math.cos(d4) * d3)) - (f8 / 2.0f));
            double d5 = f10;
            double d6 = f11;
            float sin2 = (float) (f19 + (Math.sin(d4) * d5) + (Math.cos(d4) * d3 * d6));
            float cos2 = (float) ((f20 - (d5 * Math.cos(d4))) + (d3 * Math.sin(d4) * d6));
            if (dArr2.length >= 2) {
                dArr2[0] = sin2;
                dArr2[1] = cos2;
            }
            if (!Float.isNaN(f16)) {
                motionWidget.setRotationZ((float) (f16 + Math.toDegrees(Math.atan2(cos2, sin2))));
            }
            f5 = sin;
            f6 = cos;
        } else {
            f3 = f8;
            if (!Float.isNaN(f16)) {
                motionWidget.setRotationZ((float) (0.0f + f16 + Math.toDegrees(Math.atan2(f11 + (f13 / 2.0f), f10 + (f12 / 2.0f)))));
            }
        }
        float f21 = f5 + 0.5f;
        float f22 = f6 + 0.5f;
        motionWidget.layout((int) f21, (int) f22, (int) (f21 + f7), (int) (f22 + f3));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d2 = ((this.x + (this.width / 2.0f)) - motionPaths.x) - (motionPaths.width / 2.0f);
        double d3 = ((this.y + (this.height / 2.0f)) - motionPaths.y) - (motionPaths.height / 2.0f);
        this.mRelativeToController = motion;
        this.x = (float) Math.hypot(d3, d2);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.y = (float) (Math.atan2(d3, d2) + 1.5707963267948966d);
        } else {
            this.y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i2, int i3, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != -1) {
            initPolar(i2, i3, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i4 = motionKeyPosition.mPositionType;
        if (i4 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i4 != 2) {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i2, i3, motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d2, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f2;
        float f3 = this.x;
        float f4 = this.y;
        float f5 = this.width;
        float f6 = this.height;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f11 = (float) dArr[i2];
            float f12 = (float) dArr2[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f3 = f11;
                f7 = f12;
            } else if (i3 == 2) {
                f4 = f11;
                f9 = f12;
            } else if (i3 == 3) {
                f5 = f11;
                f8 = f12;
            } else if (i3 == 4) {
                f6 = f11;
                f10 = f12;
            }
        }
        float f13 = 2.0f;
        float f14 = (f8 / 2.0f) + f7;
        float f15 = (f10 / 2.0f) + f9;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d2, fArr3, fArr4);
            float f16 = fArr3[0];
            float f17 = fArr3[1];
            float f18 = fArr4[0];
            float f19 = fArr4[1];
            double d3 = f3;
            double d4 = f4;
            f2 = f5;
            double d5 = f7;
            double d6 = f9;
            float sin = (float) (f18 + (Math.sin(d4) * d5) + (Math.cos(d4) * d6));
            f15 = (float) ((f19 - (d5 * Math.cos(d4))) + (Math.sin(d4) * d6));
            f14 = sin;
            f3 = (float) ((f16 + (Math.sin(d4) * d3)) - (f5 / 2.0f));
            f4 = (float) ((f17 - (d3 * Math.cos(d4))) - (f6 / 2.0f));
            f13 = 2.0f;
        } else {
            f2 = f5;
        }
        fArr[0] = f3 + (f2 / f13) + 0.0f;
        fArr[1] = f4 + (f6 / f13) + 0.0f;
        fArr2[0] = f14;
        fArr2[1] = f15;
    }
}
