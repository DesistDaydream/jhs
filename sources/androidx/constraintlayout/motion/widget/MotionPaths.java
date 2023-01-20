package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

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
    public LinkedHashMap<String, ConstraintAttribute> attributes;
    public float height;
    public int mAnimateCircleAngleTo;
    public int mAnimateRelativeTo;
    public Easing mKeyFrameEasing;
    public int mMode;
    public int mPathMotionArc;
    public float mRelativeAngle;
    public MotionController mRelativeToController;
    public double[] mTempDelta;
    public double[] mTempValue;
    public float position;
    public float time;
    public float width;
    public float x;
    public float y;
    public int mDrawPath = 0;
    public float mPathRotate = Float.NaN;
    public float mProgress = Float.NaN;

    public MotionPaths() {
        int i2 = Key.UNSET;
        this.mPathMotionArc = i2;
        this.mAnimateRelativeTo = i2;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float a, float b) {
        return (Float.isNaN(a) || Float.isNaN(b)) ? Float.isNaN(a) != Float.isNaN(b) : Math.abs(a - b) > 1.0E-6f;
    }

    private static final float xRotate(float sin, float cos, float cx, float cy, float x, float y) {
        return (((x - cx) * cos) - ((y - cy) * sin)) + cx;
    }

    private static final float yRotate(float sin, float cos, float cx, float cy, float x, float y) {
        return ((x - cx) * sin) + ((y - cy) * cos) + cy;
    }

    public void applyParameters(ConstraintSet.Constraint c2) {
        this.mKeyFrameEasing = Easing.getInterpolator(c2.motion.mTransitionEasing);
        ConstraintSet.Motion motion = c2.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = c2.propertySet.mProgress;
        this.mRelativeAngle = c2.layout.circleAngle;
        for (String str : c2.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = c2.mCustomConstraints.get(str);
            if (constraintAttribute != null && constraintAttribute.isContinuous()) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    public void configureRelativeTo(MotionController toOrbit) {
        toOrbit.getPos(this.mProgress);
    }

    public void different(MotionPaths points, boolean[] mask, String[] custom, boolean arcMode) {
        boolean diff = diff(this.x, points.x);
        boolean diff2 = diff(this.y, points.y);
        mask[0] = mask[0] | diff(this.position, points.position);
        boolean z = diff | diff2 | arcMode;
        mask[1] = mask[1] | z;
        mask[2] = z | mask[2];
        mask[3] = mask[3] | diff(this.width, points.width);
        mask[4] = diff(this.height, points.height) | mask[4];
    }

    public void fillStandard(double[] data, int[] toUse) {
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int i2 = 0;
        for (int i3 = 0; i3 < toUse.length; i3++) {
            if (toUse[i3] < 6) {
                data[i2] = fArr[toUse[i3]];
                i2++;
            }
        }
    }

    public void getBounds(int[] toUse, double[] data, float[] point, int offset) {
        float f2 = this.width;
        float f3 = this.height;
        for (int i2 = 0; i2 < toUse.length; i2++) {
            float f4 = (float) data[i2];
            int i3 = toUse[i2];
            if (i3 == 3) {
                f2 = f4;
            } else if (i3 == 4) {
                f3 = f4;
            }
        }
        point[offset] = f2;
        point[offset + 1] = f3;
    }

    public void getCenter(double p, int[] toUse, double[] data, float[] point, int offset) {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.width;
        float f5 = this.height;
        for (int i2 = 0; i2 < toUse.length; i2++) {
            float f6 = (float) data[i2];
            int i3 = toUse[i2];
            if (i3 == 1) {
                f2 = f6;
            } else if (i3 == 2) {
                f3 = f6;
            } else if (i3 == 3) {
                f4 = f6;
            } else if (i3 == 4) {
                f5 = f6;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            motionController.getCenter(p, fArr, new float[2]);
            float f7 = fArr[0];
            float f8 = fArr[1];
            double d2 = f7;
            double d3 = f2;
            double d4 = f3;
            f2 = (float) ((d2 + (Math.sin(d4) * d3)) - (f4 / 2.0f));
            f3 = (float) ((f8 - (d3 * Math.cos(d4))) - (f5 / 2.0f));
        }
        point[offset] = f2 + (f4 / 2.0f) + 0.0f;
        point[offset + 1] = f3 + (f5 / 2.0f) + 0.0f;
    }

    public void getCenterVelocity(double p, int[] toUse, double[] data, float[] point, int offset) {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.width;
        float f5 = this.height;
        for (int i2 = 0; i2 < toUse.length; i2++) {
            float f6 = (float) data[i2];
            int i3 = toUse[i2];
            if (i3 == 1) {
                f2 = f6;
            } else if (i3 == 2) {
                f3 = f6;
            } else if (i3 == 3) {
                f4 = f6;
            } else if (i3 == 4) {
                f5 = f6;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            motionController.getCenter(p, fArr, new float[2]);
            float f7 = fArr[0];
            float f8 = fArr[1];
            double d2 = f7;
            double d3 = f2;
            double d4 = f3;
            f2 = (float) ((d2 + (Math.sin(d4) * d3)) - (f4 / 2.0f));
            f3 = (float) ((f8 - (d3 * Math.cos(d4))) - (f5 / 2.0f));
        }
        point[offset] = f2 + (f4 / 2.0f) + 0.0f;
        point[offset + 1] = f3 + (f5 / 2.0f) + 0.0f;
    }

    public int getCustomData(String name, double[] value, int offset) {
        ConstraintAttribute constraintAttribute = this.attributes.get(name);
        int i2 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.numberOfInterpolatedValues() == 1) {
            value[offset] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = constraintAttribute.numberOfInterpolatedValues();
        float[] fArr = new float[numberOfInterpolatedValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        while (i2 < numberOfInterpolatedValues) {
            value[offset] = fArr[i2];
            i2++;
            offset++;
        }
        return numberOfInterpolatedValues;
    }

    public int getCustomDataCount(String name) {
        ConstraintAttribute constraintAttribute = this.attributes.get(name);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.numberOfInterpolatedValues();
    }

    public void getRect(int[] toUse, double[] data, float[] path, int offset) {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.width;
        float f5 = this.height;
        for (int i2 = 0; i2 < toUse.length; i2++) {
            float f6 = (float) data[i2];
            int i3 = toUse[i2];
            if (i3 == 1) {
                f2 = f6;
            } else if (i3 == 2) {
                f3 = f6;
            } else if (i3 == 3) {
                f4 = f6;
            } else if (i3 == 4) {
                f5 = f6;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float centerX = motionController.getCenterX();
            double d2 = f2;
            double d3 = f3;
            f3 = (float) ((this.mRelativeToController.getCenterY() - (d2 * Math.cos(d3))) - (f5 / 2.0f));
            f2 = (float) ((centerX + (Math.sin(d3) * d2)) - (f4 / 2.0f));
        }
        float f7 = f4 + f2;
        float f8 = f5 + f3;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i4 = offset + 1;
        path[offset] = f2 + 0.0f;
        int i5 = i4 + 1;
        path[i4] = f3 + 0.0f;
        int i6 = i5 + 1;
        path[i5] = f7 + 0.0f;
        int i7 = i6 + 1;
        path[i6] = f3 + 0.0f;
        int i8 = i7 + 1;
        path[i7] = f7 + 0.0f;
        int i9 = i8 + 1;
        path[i8] = f8 + 0.0f;
        path[i9] = f2 + 0.0f;
        path[i9 + 1] = f8 + 0.0f;
    }

    public boolean hasCustomData(String name) {
        return this.attributes.containsKey(name);
    }

    public void initCartesian(KeyPosition c2, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        float f2 = c2.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = c2.mDrawPath;
        float f3 = Float.isNaN(c2.mPercentWidth) ? f2 : c2.mPercentWidth;
        float f4 = Float.isNaN(c2.mPercentHeight) ? f2 : c2.mPercentHeight;
        float f5 = endTimePoint.width;
        float f6 = startTimePoint.width;
        float f7 = endTimePoint.height;
        float f8 = startTimePoint.height;
        this.position = this.time;
        float f9 = startTimePoint.x;
        float f10 = startTimePoint.y;
        float f11 = (endTimePoint.x + (f5 / 2.0f)) - ((f6 / 2.0f) + f9);
        float f12 = (endTimePoint.y + (f7 / 2.0f)) - (f10 + (f8 / 2.0f));
        float f13 = (f5 - f6) * f3;
        float f14 = f13 / 2.0f;
        this.x = (int) ((f9 + (f11 * f2)) - f14);
        float f15 = (f7 - f8) * f4;
        float f16 = f15 / 2.0f;
        this.y = (int) ((f10 + (f12 * f2)) - f16);
        this.width = (int) (f6 + f13);
        this.height = (int) (f8 + f15);
        float f17 = Float.isNaN(c2.mPercentX) ? f2 : c2.mPercentX;
        float f18 = Float.isNaN(c2.mAltPercentY) ? 0.0f : c2.mAltPercentY;
        if (!Float.isNaN(c2.mPercentY)) {
            f2 = c2.mPercentY;
        }
        float f19 = Float.isNaN(c2.mAltPercentX) ? 0.0f : c2.mAltPercentX;
        this.mMode = 0;
        this.x = (int) (((startTimePoint.x + (f17 * f11)) + (f19 * f12)) - f14);
        this.y = (int) (((startTimePoint.y + (f11 * f18)) + (f12 * f2)) - f16);
        this.mKeyFrameEasing = Easing.getInterpolator(c2.mTransitionEasing);
        this.mPathMotionArc = c2.mPathMotionArc;
    }

    public void initPath(KeyPosition c2, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        float f2;
        float f3;
        float f4 = c2.mFramePosition / 100.0f;
        this.time = f4;
        this.mDrawPath = c2.mDrawPath;
        float f5 = Float.isNaN(c2.mPercentWidth) ? f4 : c2.mPercentWidth;
        float f6 = Float.isNaN(c2.mPercentHeight) ? f4 : c2.mPercentHeight;
        float f7 = endTimePoint.width - startTimePoint.width;
        float f8 = endTimePoint.height - startTimePoint.height;
        this.position = this.time;
        if (!Float.isNaN(c2.mPercentX)) {
            f4 = c2.mPercentX;
        }
        float f9 = startTimePoint.x;
        float f10 = startTimePoint.width;
        float f11 = startTimePoint.y;
        float f12 = startTimePoint.height;
        float f13 = (endTimePoint.x + (endTimePoint.width / 2.0f)) - ((f10 / 2.0f) + f9);
        float f14 = (endTimePoint.y + (endTimePoint.height / 2.0f)) - ((f12 / 2.0f) + f11);
        float f15 = f13 * f4;
        float f16 = (f7 * f5) / 2.0f;
        this.x = (int) ((f9 + f15) - f16);
        float f17 = f4 * f14;
        float f18 = (f8 * f6) / 2.0f;
        this.y = (int) ((f11 + f17) - f18);
        this.width = (int) (f10 + f2);
        this.height = (int) (f12 + f3);
        float f19 = Float.isNaN(c2.mPercentY) ? 0.0f : c2.mPercentY;
        this.mMode = 1;
        float f20 = (int) ((startTimePoint.x + f15) - f16);
        this.x = f20;
        float f21 = (int) ((startTimePoint.y + f17) - f18);
        this.y = f21;
        this.x = f20 + ((-f14) * f19);
        this.y = f21 + (f13 * f19);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(c2.mTransitionEasing);
        this.mPathMotionArc = c2.mPathMotionArc;
    }

    public void initPolar(int parentWidth, int parentHeight, KeyPosition c2, MotionPaths s, MotionPaths e2) {
        float min;
        float f2;
        float f3 = c2.mFramePosition / 100.0f;
        this.time = f3;
        this.mDrawPath = c2.mDrawPath;
        this.mMode = c2.mPositionType;
        float f4 = Float.isNaN(c2.mPercentWidth) ? f3 : c2.mPercentWidth;
        float f5 = Float.isNaN(c2.mPercentHeight) ? f3 : c2.mPercentHeight;
        float f6 = e2.width;
        float f7 = s.width;
        float f8 = e2.height;
        float f9 = s.height;
        this.position = this.time;
        this.width = (int) (f7 + ((f6 - f7) * f4));
        this.height = (int) (f9 + ((f8 - f9) * f5));
        int i2 = c2.mPositionType;
        if (i2 == 1) {
            float f10 = Float.isNaN(c2.mPercentX) ? f3 : c2.mPercentX;
            float f11 = e2.x;
            float f12 = s.x;
            this.x = (f10 * (f11 - f12)) + f12;
            if (!Float.isNaN(c2.mPercentY)) {
                f3 = c2.mPercentY;
            }
            float f13 = e2.y;
            float f14 = s.y;
            this.y = (f3 * (f13 - f14)) + f14;
        } else if (i2 != 2) {
            float f15 = Float.isNaN(c2.mPercentX) ? f3 : c2.mPercentX;
            float f16 = e2.x;
            float f17 = s.x;
            this.x = (f15 * (f16 - f17)) + f17;
            if (!Float.isNaN(c2.mPercentY)) {
                f3 = c2.mPercentY;
            }
            float f18 = e2.y;
            float f19 = s.y;
            this.y = (f3 * (f18 - f19)) + f19;
        } else {
            if (Float.isNaN(c2.mPercentX)) {
                float f20 = e2.x;
                float f21 = s.x;
                min = ((f20 - f21) * f3) + f21;
            } else {
                min = Math.min(f5, f4) * c2.mPercentX;
            }
            this.x = min;
            if (Float.isNaN(c2.mPercentY)) {
                float f22 = e2.y;
                float f23 = s.y;
                f2 = (f3 * (f22 - f23)) + f23;
            } else {
                f2 = c2.mPercentY;
            }
            this.y = f2;
        }
        this.mAnimateRelativeTo = s.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(c2.mTransitionEasing);
        this.mPathMotionArc = c2.mPathMotionArc;
    }

    public void initScreen(int parentWidth, int parentHeight, KeyPosition c2, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        float f2 = c2.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = c2.mDrawPath;
        float f3 = Float.isNaN(c2.mPercentWidth) ? f2 : c2.mPercentWidth;
        float f4 = Float.isNaN(c2.mPercentHeight) ? f2 : c2.mPercentHeight;
        float f5 = endTimePoint.width;
        float f6 = startTimePoint.width;
        float f7 = endTimePoint.height;
        float f8 = startTimePoint.height;
        this.position = this.time;
        float f9 = startTimePoint.x;
        float f10 = startTimePoint.y;
        float f11 = endTimePoint.x + (f5 / 2.0f);
        float f12 = endTimePoint.y + (f7 / 2.0f);
        float f13 = (f5 - f6) * f3;
        this.x = (int) ((f9 + ((f11 - ((f6 / 2.0f) + f9)) * f2)) - (f13 / 2.0f));
        float f14 = (f7 - f8) * f4;
        this.y = (int) ((f10 + ((f12 - (f10 + (f8 / 2.0f))) * f2)) - (f14 / 2.0f));
        this.width = (int) (f6 + f13);
        this.height = (int) (f8 + f14);
        this.mMode = 2;
        if (!Float.isNaN(c2.mPercentX)) {
            this.x = (int) (c2.mPercentX * ((int) (parentWidth - this.width)));
        }
        if (!Float.isNaN(c2.mPercentY)) {
            this.y = (int) (c2.mPercentY * ((int) (parentHeight - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(c2.mTransitionEasing);
        this.mPathMotionArc = c2.mPathMotionArc;
    }

    public void setBounds(float x, float y, float w, float h2) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h2;
    }

    public void setDpDt(float locationX, float locationY, float[] mAnchorDpDt, int[] toUse, double[] deltaData, double[] data) {
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i2 = 0; i2 < toUse.length; i2++) {
            float f6 = (float) deltaData[i2];
            double d2 = data[i2];
            int i3 = toUse[i2];
            if (i3 == 1) {
                f2 = f6;
            } else if (i3 == 2) {
                f4 = f6;
            } else if (i3 == 3) {
                f3 = f6;
            } else if (i3 == 4) {
                f5 = f6;
            }
        }
        float f7 = f2 - ((0.0f * f3) / 2.0f);
        float f8 = f4 - ((0.0f * f5) / 2.0f);
        mAnchorDpDt[0] = (f7 * (1.0f - locationX)) + (((f3 * 1.0f) + f7) * locationX) + 0.0f;
        mAnchorDpDt[1] = (f8 * (1.0f - locationY)) + (((f5 * 1.0f) + f8) * locationY) + 0.0f;
    }

    public void setView(float position, View view, int[] toUse, double[] data, double[] slope, double[] cycle, boolean mForceMeasure) {
        float f2;
        boolean z;
        float f3;
        float f4 = this.x;
        float f5 = this.y;
        float f6 = this.width;
        float f7 = this.height;
        if (toUse.length != 0 && this.mTempValue.length <= toUse[toUse.length - 1]) {
            int i2 = toUse[toUse.length - 1] + 1;
            this.mTempValue = new double[i2];
            this.mTempDelta = new double[i2];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i3 = 0; i3 < toUse.length; i3++) {
            this.mTempValue[toUse[i3]] = data[i3];
            this.mTempDelta[toUse[i3]] = slope[i3];
        }
        float f8 = Float.NaN;
        int i4 = 0;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (true) {
            double[] dArr = this.mTempValue;
            if (i4 >= dArr.length) {
                break;
            }
            if (Double.isNaN(dArr[i4]) && (cycle == null || cycle[i4] == 0.0d)) {
                f3 = f8;
            } else {
                double d2 = cycle != null ? cycle[i4] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i4])) {
                    d2 = this.mTempValue[i4] + d2;
                }
                f3 = f8;
                float f13 = (float) d2;
                float f14 = (float) this.mTempDelta[i4];
                if (i4 == 1) {
                    f8 = f3;
                    f9 = f14;
                    f4 = f13;
                } else if (i4 == 2) {
                    f8 = f3;
                    f10 = f14;
                    f5 = f13;
                } else if (i4 == 3) {
                    f8 = f3;
                    f11 = f14;
                    f6 = f13;
                } else if (i4 == 4) {
                    f8 = f3;
                    f12 = f14;
                    f7 = f13;
                } else if (i4 == 5) {
                    f8 = f13;
                }
                i4++;
            }
            f8 = f3;
            i4++;
        }
        float f15 = f8;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter(position, fArr, fArr2);
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr2[0];
            float f19 = fArr2[1];
            double d3 = f4;
            double d4 = f5;
            float sin = (float) ((f16 + (Math.sin(d4) * d3)) - (f6 / 2.0f));
            f2 = f7;
            float cos = (float) ((f17 - (Math.cos(d4) * d3)) - (f7 / 2.0f));
            double d5 = f9;
            double d6 = f10;
            float sin2 = (float) (f18 + (Math.sin(d4) * d5) + (Math.cos(d4) * d3 * d6));
            float cos2 = (float) ((f19 - (d5 * Math.cos(d4))) + (d3 * Math.sin(d4) * d6));
            if (slope.length >= 2) {
                z = false;
                slope[0] = sin2;
                slope[1] = cos2;
            } else {
                z = false;
            }
            if (!Float.isNaN(f15)) {
                view.setRotation((float) (f15 + Math.toDegrees(Math.atan2(cos2, sin2))));
            }
            f4 = sin;
            f5 = cos;
        } else {
            f2 = f7;
            z = false;
            if (!Float.isNaN(f15)) {
                view.setRotation((float) (0.0f + f15 + Math.toDegrees(Math.atan2(f10 + (f12 / 2.0f), f9 + (f11 / 2.0f)))));
            }
        }
        if (view instanceof FloatLayout) {
            ((FloatLayout) view).layout(f4, f5, f6 + f4, f5 + f2);
            return;
        }
        float f20 = f4 + 0.5f;
        int i5 = (int) f20;
        float f21 = f5 + 0.5f;
        int i6 = (int) f21;
        int i7 = (int) (f20 + f6);
        int i8 = (int) (f21 + f2);
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        if (((i9 == view.getMeasuredWidth() && i10 == view.getMeasuredHeight()) ? true : true) || mForceMeasure) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
        }
        view.layout(i5, i6, i7, i8);
    }

    public void setupRelative(MotionController mc, MotionPaths relative) {
        double d2 = ((this.x + (this.width / 2.0f)) - relative.x) - (relative.width / 2.0f);
        double d3 = ((this.y + (this.height / 2.0f)) - relative.y) - (relative.height / 2.0f);
        this.mRelativeToController = mc;
        this.x = (float) Math.hypot(d3, d2);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.y = (float) (Math.atan2(d3, d2) + 1.5707963267948966d);
        } else {
            this.y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths o) {
        return Float.compare(this.position, o.position);
    }

    public MotionPaths(int parentWidth, int parentHeight, KeyPosition c2, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        int i2 = Key.UNSET;
        this.mPathMotionArc = i2;
        this.mAnimateRelativeTo = i2;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (startTimePoint.mAnimateRelativeTo != Key.UNSET) {
            initPolar(parentWidth, parentHeight, c2, startTimePoint, endTimePoint);
            return;
        }
        int i3 = c2.mPositionType;
        if (i3 == 1) {
            initPath(c2, startTimePoint, endTimePoint);
        } else if (i3 != 2) {
            initCartesian(c2, startTimePoint, endTimePoint);
        } else {
            initScreen(parentWidth, parentHeight, c2, startTimePoint, endTimePoint);
        }
    }

    public void getCenter(double p, int[] toUse, double[] data, float[] point, double[] vdata, float[] velocity) {
        float f2;
        float f3 = this.x;
        float f4 = this.y;
        float f5 = this.width;
        float f6 = this.height;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        for (int i2 = 0; i2 < toUse.length; i2++) {
            float f11 = (float) data[i2];
            float f12 = (float) vdata[i2];
            int i3 = toUse[i2];
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
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter(p, fArr, fArr2);
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr2[0];
            float f19 = fArr2[1];
            double d2 = f3;
            double d3 = f4;
            f2 = f5;
            double d4 = f7;
            double d5 = f9;
            float sin = (float) (f18 + (Math.sin(d3) * d4) + (Math.cos(d3) * d5));
            f15 = (float) ((f19 - (d4 * Math.cos(d3))) + (Math.sin(d3) * d5));
            f14 = sin;
            f3 = (float) ((f16 + (Math.sin(d3) * d2)) - (f5 / 2.0f));
            f4 = (float) ((f17 - (d2 * Math.cos(d3))) - (f6 / 2.0f));
            f13 = 2.0f;
        } else {
            f2 = f5;
        }
        point[0] = f3 + (f2 / f13) + 0.0f;
        point[1] = f4 + (f6 / f13) + 0.0f;
        velocity[0] = f14;
        velocity[1] = f15;
    }
}
