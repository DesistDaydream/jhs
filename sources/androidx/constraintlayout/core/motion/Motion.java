package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Motion {
    public static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    public static final int EASE_IN = 1;
    public static final int EASE_IN_OUT = 0;
    public static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    public static final int LINEAR = 3;
    public static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    public String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    public String mConstraintTag;
    public float mCurrentCenterX;
    public float mCurrentCenterY;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    public int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private MotionKeyTrigger[] mKeyTriggers;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    public MotionWidget mView;
    public Rect mTempRect = new Rect();
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    public float mMotionStagger = Float.NaN;
    public float mStaggerOffset = 0.0f;
    public float mStaggerScale = 1.0f;
    private int MAX_DIMENSION = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<MotionKey> mKeyList = new ArrayList<>();
    private int mPathMotionArc = -1;
    private int mTransformPivotTarget = -1;
    private MotionWidget mTransformPivotView = null;
    private int mQuantizeMotionSteps = -1;
    private float mQuantizeMotionPhase = Float.NaN;
    private DifferentialInterpolator mQuantizeMotionInterpolator = null;
    private boolean mNoMovement = false;

    public Motion(MotionWidget motionWidget) {
        setView(motionWidget);
    }

    private float getAdjustedPosition(float f2, float[] fArr) {
        float f3 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f4 = this.mStaggerScale;
            if (f4 != 1.0d) {
                float f5 = this.mStaggerOffset;
                if (f2 < f5) {
                    f2 = 0.0f;
                }
                if (f2 > f5 && f2 < 1.0d) {
                    f2 = Math.min((f2 - f5) * f4, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        float f6 = Float.NaN;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            MotionPaths next = it.next();
            Easing easing2 = next.mKeyFrameEasing;
            if (easing2 != null) {
                float f7 = next.time;
                if (f7 < f2) {
                    easing = easing2;
                    f3 = f7;
                } else if (Float.isNaN(f6)) {
                    f6 = next.time;
                }
            }
        }
        if (easing != null) {
            float f8 = (Float.isNaN(f6) ? 1.0f : f6) - f3;
            double d2 = (f2 - f3) / f8;
            f2 = (((float) easing.get(d2)) * f8) + f3;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d2);
            }
        }
        return f2;
    }

    private static DifferentialInterpolator getInterpolator(int i2, String str, int i3) {
        if (i2 != -1) {
            return null;
        }
        final Easing interpolator = Easing.getInterpolator(str);
        return new DifferentialInterpolator() { // from class: androidx.constraintlayout.core.motion.Motion.1
            public float mX;

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getInterpolation(float f2) {
                this.mX = f2;
                return (float) interpolator.get(f2);
            }

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getVelocity() {
                return (float) interpolator.getDiff(this.mX);
            }
        };
    }

    private float getPreCycleDistance() {
        char c2;
        float f2;
        float f3;
        float[] fArr = new float[2];
        float f4 = 1.0f / 99;
        double d2 = 0.0d;
        double d3 = 0.0d;
        float f5 = 0.0f;
        int i2 = 0;
        while (i2 < 100) {
            float f6 = i2 * f4;
            double d4 = f6;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f7 = Float.NaN;
            float f8 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f9 = next.time;
                    if (f9 < f6) {
                        easing = easing2;
                        f8 = f9;
                    } else if (Float.isNaN(f7)) {
                        f7 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                d4 = (((float) easing.get((f6 - f8) / f3)) * (f7 - f8)) + f8;
            }
            this.mSpline[0].getPos(d4, this.mInterpolateData);
            float f10 = f5;
            int i3 = i2;
            this.mStartMotionPath.getCenter(d4, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i3 > 0) {
                c2 = 0;
                f2 = (float) (f10 + Math.hypot(d3 - fArr[1], d2 - fArr[0]));
            } else {
                c2 = 0;
                f2 = f10;
            }
            d2 = fArr[c2];
            i2 = i3 + 1;
            f5 = f2;
            d3 = fArr[1];
        }
        return f5;
    }

    private void insertKey(MotionPaths motionPaths) {
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        MotionPaths motionPaths2 = null;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            if (motionPaths.position == next.position) {
                motionPaths2 = next;
            }
        }
        if (motionPaths2 != null) {
            this.mMotionPaths.remove(motionPaths2);
        }
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            Utils.loge(TAG, " KeyPath position \"" + motionPaths.position + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds(this.mView.getX(), this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(MotionKey motionKey) {
        this.mKeyList.add(motionKey);
    }

    public void addKeys(ArrayList<MotionKey> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i2) {
        float f2;
        float f3 = 1.0f / (i2 - 1);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            hashMap4.get("translationY");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            float f4 = i3 * f3;
            float f5 = this.mStaggerScale;
            float f6 = 0.0f;
            if (f5 != 1.0f) {
                float f7 = this.mStaggerOffset;
                if (f4 < f7) {
                    f4 = 0.0f;
                }
                if (f4 > f7 && f4 < 1.0d) {
                    f4 = Math.min((f4 - f7) * f5, 1.0f);
                }
            }
            double d2 = f4;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f8 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f9 = next.time;
                    if (f9 < f4) {
                        easing = easing2;
                        f6 = f9;
                    } else if (Float.isNaN(f8)) {
                        f8 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f8)) {
                    f8 = 1.0f;
                }
                d2 = (((float) easing.get((f4 - f6) / f2)) * (f8 - f6)) + f6;
            }
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d2, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 2);
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr != null) {
            double[] timePoints = this.mSpline[0].getTimePoints();
            if (iArr != null) {
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    iArr[i2] = it.next().mMode;
                    i2++;
                }
            }
            int i3 = 0;
            for (double d2 : timePoints) {
                this.mSpline[0].getPos(d2, this.mInterpolateData);
                this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
                i3 += 2;
            }
            return i3 / 2;
        }
        return 0;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr != null) {
            double[] timePoints = this.mSpline[0].getTimePoints();
            if (iArr != null) {
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    iArr[i2] = it.next().mMode;
                    i2++;
                }
            }
            if (iArr2 != null) {
                Iterator<MotionPaths> it2 = this.mMotionPaths.iterator();
                int i3 = 0;
                while (it2.hasNext()) {
                    iArr2[i3] = (int) (it2.next().position * 100.0f);
                    i3++;
                }
            }
            int i4 = 0;
            for (int i5 = 0; i5 < timePoints.length; i5++) {
                this.mSpline[0].getPos(timePoints[i5], this.mInterpolateData);
                this.mStartMotionPath.getCenter(timePoints[i5], this.mInterpolateVariables, this.mInterpolateData, fArr, i4);
                i4 += 2;
            }
            return i4 / 2;
        }
        return 0;
    }

    public void buildPath(float[] fArr, int i2) {
        double d2;
        float f2;
        float f3 = 1.0f;
        float f4 = 1.0f / (i2 - 1);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = hashMap4 != null ? hashMap4.get("translationY") : null;
        int i3 = 0;
        while (i3 < i2) {
            float f5 = i3 * f4;
            float f6 = this.mStaggerScale;
            if (f6 != f3) {
                float f7 = this.mStaggerOffset;
                if (f5 < f7) {
                    f5 = 0.0f;
                }
                if (f5 > f7 && f5 < 1.0d) {
                    f5 = Math.min((f5 - f7) * f6, f3);
                }
            }
            float f8 = f5;
            double d3 = f8;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f9 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f10 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                double d4 = d3;
                if (easing2 != null) {
                    float f11 = next.time;
                    if (f11 < f8) {
                        f10 = f11;
                        easing = easing2;
                    } else if (Float.isNaN(f9)) {
                        f9 = next.time;
                    }
                }
                d3 = d4;
            }
            double d5 = d3;
            if (easing != null) {
                if (Float.isNaN(f9)) {
                    f9 = 1.0f;
                }
                d2 = (((float) easing.get((f8 - f10) / f2)) * (f9 - f10)) + f10;
            } else {
                d2 = d5;
            }
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d2, dArr);
                }
            }
            int i4 = i3 * 2;
            int i5 = i3;
            this.mStartMotionPath.getCenter(d2, this.mInterpolateVariables, this.mInterpolateData, fArr, i4);
            if (keyCycleOscillator != null) {
                fArr[i4] = fArr[i4] + keyCycleOscillator.get(f8);
            } else if (splineSet != null) {
                fArr[i4] = fArr[i4] + splineSet.get(f8);
            }
            if (keyCycleOscillator2 != null) {
                int i6 = i4 + 1;
                fArr[i6] = fArr[i6] + keyCycleOscillator2.get(f8);
            } else if (splineSet2 != null) {
                int i7 = i4 + 1;
                fArr[i7] = fArr[i7] + splineSet2.get(f8);
            }
            i3 = i5 + 1;
            f3 = 1.0f;
        }
    }

    public void buildRect(float f2, float[] fArr, int i2) {
        this.mSpline[0].getPos(getAdjustedPosition(f2, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
    }

    public void buildRectangles(float[] fArr, int i2) {
        float f2 = 1.0f / (i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            this.mSpline[0].getPos(getAdjustedPosition(i3 * f2, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 8);
        }
    }

    public void endTrigger(boolean z) {
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String str, float[] fArr, int i2) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = splineSet.get(i3 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getCenter(double d2, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d2, dArr);
        this.mSpline[0].getSlope(d2, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d2, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getDpDt(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f2, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i2 = 0;
        if (curveFitArr != null) {
            double d2 = adjustedPosition;
            curveFitArr[0].getSlope(d2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            float f5 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i2 >= dArr.length) {
                    break;
                }
                dArr[i2] = dArr[i2] * f5;
                i2++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d2, dArr2);
                    this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
            this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        MotionPaths motionPaths = this.mEndMotionPath;
        float f6 = motionPaths.x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f7 = f6 - motionPaths2.x;
        float f8 = motionPaths.y - motionPaths2.y;
        float f9 = (motionPaths.width - motionPaths2.width) + f7;
        float f10 = (motionPaths.height - motionPaths2.height) + f8;
        fArr[0] = (f7 * (1.0f - f3)) + (f9 * f3);
        fArr[1] = (f8 * (1.0f - f4)) + (f10 * f4);
    }

    public int getDrawPath() {
        int i2 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i2 = Math.max(i2, it.next().mDrawPath);
        }
        return Math.max(i2, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.height;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.width;
    }

    public float getFinalX() {
        return this.mEndMotionPath.x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.y;
    }

    public MotionPaths getKeyFrame(int i2) {
        return this.mMotionPaths.get(i2);
    }

    public int getKeyFrameInfo(int i2, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<MotionKey> it = this.mKeyList.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            MotionKey next = it.next();
            int i5 = next.mType;
            if (i5 == i2 || i2 != -1) {
                iArr[i4] = 0;
                int i6 = i4 + 1;
                iArr[i6] = i5;
                int i7 = i6 + 1;
                int i8 = next.mFramePosition;
                iArr[i7] = i8;
                double d2 = i8 / 100.0f;
                this.mSpline[0].getPos(d2, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d2, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                int i9 = i7 + 1;
                iArr[i9] = Float.floatToIntBits(fArr[0]);
                int i10 = i9 + 1;
                iArr[i10] = Float.floatToIntBits(fArr[1]);
                if (next instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                    int i11 = i10 + 1;
                    iArr[i11] = motionKeyPosition.mPositionType;
                    int i12 = i11 + 1;
                    iArr[i12] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i10 = i12 + 1;
                    iArr[i10] = Float.floatToIntBits(motionKeyPosition.mPercentY);
                }
                int i13 = i10 + 1;
                iArr[i4] = i13 - i4;
                i3++;
                i4 = i13;
            }
        }
        return i3;
    }

    public float getKeyFrameParameter(int i2, float f2, float f3) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f4 = motionPaths.x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f5 = motionPaths2.x;
        float f6 = f4 - f5;
        float f7 = motionPaths.y;
        float f8 = motionPaths2.y;
        float f9 = f7 - f8;
        float f10 = f5 + (motionPaths2.width / 2.0f);
        float f11 = f8 + (motionPaths2.height / 2.0f);
        float hypot = (float) Math.hypot(f6, f9);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f12 = f2 - f10;
        float f13 = f3 - f11;
        if (((float) Math.hypot(f12, f13)) == 0.0f) {
            return 0.0f;
        }
        float f14 = (f12 * f6) + (f13 * f9);
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return 0.0f;
                            }
                            return f13 / f9;
                        }
                        return f12 / f9;
                    }
                    return f13 / f6;
                }
                return f12 / f6;
            }
            return (float) Math.sqrt((hypot * hypot) - (f14 * f14));
        }
        return f14 / hypot;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<MotionKey> it = this.mKeyList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            MotionKey next = it.next();
            int i4 = next.mFramePosition;
            iArr[i2] = (next.mType * 1000) + i4;
            double d2 = i4 / 100.0f;
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d2, this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            i3 += 2;
            i2++;
        }
        return i2;
    }

    public double[] getPos(double d2) {
        this.mSpline[0].getPos(d2, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d2, dArr);
            }
        }
        return this.mInterpolateData;
    }

    public MotionKeyPosition getPositionKeyframe(int i2, int i3, float f2, float f3) {
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f4 = motionPaths.x;
        floatRect.left = f4;
        float f5 = motionPaths.y;
        floatRect.top = f5;
        floatRect.right = f4 + motionPaths.width;
        floatRect.bottom = f5 + motionPaths.height;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f6 = motionPaths2.x;
        floatRect2.left = f6;
        float f7 = motionPaths2.y;
        floatRect2.top = f7;
        floatRect2.right = f6 + motionPaths2.width;
        floatRect2.bottom = f7 + motionPaths2.height;
        Iterator<MotionKey> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            MotionKey next = it.next();
            if (next instanceof MotionKeyPosition) {
                MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                if (motionKeyPosition.intersects(i2, i3, floatRect, floatRect2, f2, f3)) {
                    return motionKeyPosition;
                }
            }
        }
        return null;
    }

    public void getPostLayoutDvDp(float f2, int i2, int i3, float f3, float f4, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f2, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        SplineSet splineSet3 = hashMap3 == null ? null : hashMap3.get("rotationZ");
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        SplineSet splineSet4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator3 = hashMap8 == null ? null : hashMap8.get("rotationZ");
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator4 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator5 = hashMap10 != null ? hashMap10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d2 = adjustedPosition;
                curveFit.getPos(d2, dArr);
                this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
            return;
        }
        int i4 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f5 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i4 < dArr2.length) {
                    dArr2[i4] = dArr2[i4] * f5;
                    i4++;
                } else {
                    this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f6 = motionPaths.x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f7 = f6 - motionPaths2.x;
            float f8 = motionPaths.y - motionPaths2.y;
            KeyCycleOscillator keyCycleOscillator6 = keyCycleOscillator4;
            float f9 = (motionPaths.height - motionPaths2.height) + f8;
            fArr[0] = (f7 * (1.0f - f3)) + (((motionPaths.width - motionPaths2.width) + f7) * f3);
            fArr[1] = (f8 * (1.0f - f4)) + (f9 * f4);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator6, keyCycleOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
        }
    }

    public float getStartHeight() {
        return this.mStartMotionPath.height;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.width;
    }

    public float getStartX() {
        return this.mStartMotionPath.x;
    }

    public float getStartY() {
        return this.mStartMotionPath.y;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public boolean interpolate(MotionWidget motionWidget, float f2, long j2, KeyCache keyCache) {
        double d2;
        MotionWidget motionWidget2;
        float f3;
        float adjustedPosition = getAdjustedPosition(f2, null);
        int i2 = this.mQuantizeMotionSteps;
        if (i2 != -1) {
            float f4 = 1.0f / i2;
            float floor = ((float) Math.floor(adjustedPosition / f4)) * f4;
            float f5 = (adjustedPosition % f4) / f4;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f5 = (f5 + this.mQuantizeMotionPhase) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.mQuantizeMotionInterpolator;
            if (differentialInterpolator != null) {
                f3 = differentialInterpolator.getInterpolation(f5);
            } else {
                f3 = ((double) f5) > 0.5d ? 1.0f : 0.0f;
            }
            adjustedPosition = (f3 * f4) + floor;
        }
        float f6 = adjustedPosition;
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            for (SplineSet splineSet : hashMap.values()) {
                splineSet.setProperty(motionWidget, f6);
            }
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d3 = f6;
            curveFitArr[0].getPos(d3, this.mInterpolateData);
            this.mSpline[0].getSlope(d3, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d3, dArr);
                    this.mArcSpline.getSlope(d3, this.mInterpolateVelocity);
                }
            }
            if (this.mNoMovement) {
                d2 = d3;
            } else {
                d2 = d3;
                this.mStartMotionPath.setView(f6, motionWidget, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
            }
            if (this.mTransformPivotTarget != -1) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = motionWidget.getParent().findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float top = (motionWidget2.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
                    float left = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
                    if (motionWidget.getRight() - motionWidget.getLeft() > 0 && motionWidget.getBottom() - motionWidget.getTop() > 0) {
                        motionWidget.setPivotX(left - motionWidget.getLeft());
                        motionWidget.setPivotY(top - motionWidget.getTop());
                    }
                }
            }
            int i3 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i3 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i3].getPos(d2, this.mValuesBuff);
                this.mStartMotionPath.customAttributes.get(this.mAttributeNames[i3 - 1]).setInterpolatedValue(motionWidget, this.mValuesBuff);
                i3++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (f6 <= 0.0f) {
                    motionWidget.setVisibility(motionConstrainedPoint.visibility);
                } else if (f6 >= 1.0f) {
                    motionWidget.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    motionWidget.setVisibility(4);
                }
            }
            if (this.mKeyTriggers != null) {
                int i4 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = this.mKeyTriggers;
                    if (i4 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i4].conditionallyFire(f6, motionWidget);
                    i4++;
                }
            }
        } else {
            MotionPaths motionPaths = this.mStartMotionPath;
            float f7 = motionPaths.x;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f8 = f7 + ((motionPaths2.x - f7) * f6);
            float f9 = motionPaths.y;
            float f10 = f9 + ((motionPaths2.y - f9) * f6);
            float f11 = motionPaths.width;
            float f12 = f11 + ((motionPaths2.width - f11) * f6);
            float f13 = motionPaths.height;
            float f14 = f8 + 0.5f;
            float f15 = f10 + 0.5f;
            motionWidget.layout((int) f14, (int) f15, (int) (f14 + f12), (int) (f15 + f13 + ((motionPaths2.height - f13) * f6)));
        }
        HashMap<String, KeyCycleOscillator> hashMap2 = this.mCycleMap;
        if (hashMap2 != null) {
            for (KeyCycleOscillator keyCycleOscillator : hashMap2.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr2 = this.mInterpolateVelocity;
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(motionWidget, f6, dArr2[0], dArr2[1]);
                } else {
                    keyCycleOscillator.setProperty(motionWidget, f6);
                }
            }
            return false;
        }
        return false;
    }

    public String name() {
        return this.mView.getName();
    }

    public void positionKeyframe(MotionWidget motionWidget, MotionKeyPosition motionKeyPosition, float f2, float f3, String[] strArr, float[] fArr) {
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f4 = motionPaths.x;
        floatRect.left = f4;
        float f5 = motionPaths.y;
        floatRect.top = f5;
        floatRect.right = f4 + motionPaths.width;
        floatRect.bottom = f5 + motionPaths.height;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f6 = motionPaths2.x;
        floatRect2.left = f6;
        float f7 = motionPaths2.y;
        floatRect2.top = f7;
        floatRect2.right = f6 + motionPaths2.width;
        floatRect2.bottom = f7 + motionPaths2.height;
        motionKeyPosition.positionAttributes(motionWidget, floatRect, floatRect2, f2, f3, strArr, fArr);
    }

    public void rotate(Rect rect, Rect rect2, int i2, int i3, int i4) {
        if (i2 == 1) {
            int i5 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i4 - ((i5 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i2 == 2) {
            int i6 = rect.left + rect.right;
            rect2.left = i3 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i6 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            int i7 = rect.left + rect.right;
            rect2.left = i3 - (((rect.bottom + rect.top) + rect.width()) / 2);
            rect2.top = (i7 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else {
            int i8 = rect.left + rect.right;
            int i9 = rect.top;
            int i10 = rect.bottom;
            rect2.left = ((rect.height() / 2) + rect.top) - (i8 / 2);
            rect2.top = i4 - ((i8 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        }
    }

    public void setBothStates(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartPoint.setState(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setDrawPath(int i2) {
        this.mStartMotionPath.mDrawPath = i2;
    }

    public void setEnd(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(motionWidget.getLeft(), motionWidget.getTop(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.applyParameters(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setPathMotionArc(int i2) {
        this.mPathMotionArc = i2;
    }

    public void setStart(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartMotionPath.applyParameters(motionWidget);
        this.mStartPoint.setState(motionWidget);
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i2, int i3, int i4) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        Rect rect = new Rect();
        if (i2 == 1) {
            int i5 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i3 - ((i5 + viewState.height()) / 2);
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        } else if (i2 == 2) {
            int i6 = viewState.left + viewState.right;
            rect.left = i4 - (((viewState.top + viewState.bottom) + viewState.width()) / 2);
            rect.top = (i6 - viewState.height()) / 2;
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        }
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mStartPoint.setState(rect, motionWidget, i2, viewState.rotation);
    }

    public void setTransformPivotTarget(int i2) {
        this.mTransformPivotTarget = i2;
        this.mTransformPivotView = null;
    }

    public void setView(MotionWidget motionWidget) {
        this.mView = motionWidget;
    }

    public void setup(int i2, int i3, float f2, long j2) {
        ArrayList arrayList;
        String[] strArr;
        Class<double> cls;
        int i4;
        CustomVariable customVariable;
        SplineSet makeSpline;
        CustomVariable customVariable2;
        Integer num;
        Iterator<String> it;
        SplineSet makeSpline2;
        CustomVariable customVariable3;
        Class<double> cls2 = double.class;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i5 = this.mPathMotionArc;
        if (i5 != -1) {
            this.mStartMotionPath.mPathMotionArc = i5;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<MotionKey> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            Iterator<MotionKey> it2 = arrayList2.iterator();
            arrayList = null;
            while (it2.hasNext()) {
                MotionKey next = it2.next();
                if (next instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                    insertKey(new MotionPaths(i2, i3, motionKeyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i6 = motionKeyPosition.mCurveFit;
                    if (i6 != -1) {
                        this.mCurveFitType = i6;
                    }
                } else if (next instanceof MotionKeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof MotionKeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof MotionKeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((MotionKeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        char c2 = 1;
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                String next2 = it3.next();
                if (next2.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar = new KeyFrameArray.CustomVar();
                    String str = next2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[c2];
                    Iterator<MotionKey> it4 = this.mKeyList.iterator();
                    while (it4.hasNext()) {
                        MotionKey next3 = it4.next();
                        Iterator<String> it5 = it3;
                        HashMap<String, CustomVariable> hashMap2 = next3.mCustom;
                        if (hashMap2 != null && (customVariable3 = hashMap2.get(str)) != null) {
                            customVar.append(next3.mFramePosition, customVariable3);
                        }
                        it3 = it5;
                    }
                    it = it3;
                    makeSpline2 = SplineSet.makeCustomSplineSet(next2, customVar);
                } else {
                    it = it3;
                    makeSpline2 = SplineSet.makeSpline(next2, j2);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next2);
                    this.mAttributesMap.put(next2, makeSpline2);
                }
                it3 = it;
                c2 = 1;
            }
            ArrayList<MotionKey> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                Iterator<MotionKey> it6 = arrayList3.iterator();
                while (it6.hasNext()) {
                    MotionKey next4 = it6.next();
                    if (next4 instanceof MotionKeyAttributes) {
                        next4.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                int intValue = (!hashMap.containsKey(str2) || (num = hashMap.get(str2)) == null) ? 0 : num.intValue();
                SplineSet splineSet = this.mAttributesMap.get(str2);
                if (splineSet != null) {
                    splineSet.setup(intValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it7 = hashSet.iterator();
            while (it7.hasNext()) {
                String next5 = it7.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                        String str3 = next5.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
                        Iterator<MotionKey> it8 = this.mKeyList.iterator();
                        while (it8.hasNext()) {
                            MotionKey next6 = it8.next();
                            HashMap<String, CustomVariable> hashMap3 = next6.mCustom;
                            if (hashMap3 != null && (customVariable2 = hashMap3.get(str3)) != null) {
                                customVar2.append(next6.mFramePosition, customVariable2);
                            }
                        }
                        makeSpline = SplineSet.makeCustomSplineSet(next5, customVar2);
                    } else {
                        makeSpline = SplineSet.makeSpline(next5, j2);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next5);
                    }
                }
            }
            ArrayList<MotionKey> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                Iterator<MotionKey> it9 = arrayList4.iterator();
                while (it9.hasNext()) {
                    MotionKey next7 = it9.next();
                    if (next7 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) next7).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str4).setup(hashMap.containsKey(str4) ? hashMap.get(str4).intValue() : 0);
            }
        }
        int i7 = 2;
        int size = this.mMotionPaths.size() + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[size];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == MotionKey.UNSET) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it10 = this.mMotionPaths.iterator();
        int i8 = 1;
        while (it10.hasNext()) {
            motionPathsArr[i8] = it10.next();
            i8++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.mEndMotionPath.customAttributes.keySet()) {
            if (this.mStartMotionPath.customAttributes.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i9 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i9 >= strArr.length) {
                break;
            }
            String str6 = strArr[i9];
            this.mAttributeInterpolatorCount[i9] = 0;
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                if (motionPathsArr[i10].customAttributes.containsKey(str6) && (customVariable = motionPathsArr[i10].customAttributes.get(str6)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i9] = iArr[i9] + customVariable.numberOfInterpolatedValues();
                    break;
                }
                i10++;
            }
            i9++;
        }
        boolean z = motionPathsArr[0].mPathMotionArc != -1;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i11 = 1; i11 < size; i11++) {
            motionPathsArr[i11].different(motionPathsArr[i11 - 1], zArr, this.mAttributeNames, z);
        }
        int i12 = 0;
        for (int i13 = 1; i13 < length; i13++) {
            if (zArr[i13]) {
                i12++;
            }
        }
        this.mInterpolateVariables = new int[i12];
        int max = Math.max(2, i12);
        this.mInterpolateData = new double[max];
        this.mInterpolateVelocity = new double[max];
        int i14 = 0;
        for (int i15 = 1; i15 < length; i15++) {
            if (zArr[i15]) {
                this.mInterpolateVariables[i14] = i15;
                i14++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls2, size, this.mInterpolateVariables.length);
        double[] dArr2 = new double[size];
        for (int i16 = 0; i16 < size; i16++) {
            motionPathsArr[i16].fillStandard(dArr[i16], this.mInterpolateVariables);
            dArr2[i16] = motionPathsArr[i16].time;
        }
        int i17 = 0;
        while (true) {
            int[] iArr2 = this.mInterpolateVariables;
            if (i17 >= iArr2.length) {
                break;
            }
            if (iArr2[i17] < MotionPaths.names.length) {
                String str7 = MotionPaths.names[this.mInterpolateVariables[i17]] + " [";
                for (int i18 = 0; i18 < size; i18++) {
                    str7 = str7 + dArr[i18][i17];
                }
            }
            i17++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i19 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i19 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i19];
            int i20 = 0;
            int i21 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i20 < size) {
                if (motionPathsArr[i20].hasCustomData(str8)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr3 = new int[i7];
                        iArr3[1] = motionPathsArr[i20].getCustomDataCount(str8);
                        i4 = 0;
                        iArr3[0] = size;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls2, iArr3);
                    } else {
                        i4 = 0;
                    }
                    cls = cls2;
                    dArr3[i21] = motionPathsArr[i20].time;
                    motionPathsArr[i20].getCustomData(str8, dArr4[i21], i4);
                    i21++;
                } else {
                    cls = cls2;
                }
                i20++;
                cls2 = cls;
                i7 = 2;
            }
            i19++;
            this.mSpline[i19] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i21), (double[][]) Arrays.copyOf(dArr4, i21));
            cls2 = cls2;
            i7 = 2;
        }
        Class<double> cls3 = cls2;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != -1) {
            int[] iArr4 = new int[size];
            double[] dArr5 = new double[size];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls3, size, 2);
            for (int i22 = 0; i22 < size; i22++) {
                iArr4[i22] = motionPathsArr[i22].mPathMotionArc;
                dArr5[i22] = motionPathsArr[i22].time;
                dArr6[i22][0] = motionPathsArr[i22].x;
                dArr6[i22][1] = motionPathsArr[i22].y;
            }
            this.mArcSpline = CurveFit.getArc(iArr4, dArr5, dArr6);
        }
        float f3 = Float.NaN;
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it11 = hashSet3.iterator();
            while (it11.hasNext()) {
                String next8 = it11.next();
                KeyCycleOscillator makeWidgetCycle = KeyCycleOscillator.makeWidgetCycle(next8);
                if (makeWidgetCycle != null) {
                    if (makeWidgetCycle.variesByPath() && Float.isNaN(f3)) {
                        f3 = getPreCycleDistance();
                    }
                    makeWidgetCycle.setType(next8);
                    this.mCycleMap.put(next8, makeWidgetCycle);
                }
            }
            Iterator<MotionKey> it12 = this.mKeyList.iterator();
            while (it12.hasNext()) {
                MotionKey next9 = it12.next();
                if (next9 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            for (KeyCycleOscillator keyCycleOscillator : this.mCycleMap.values()) {
                keyCycleOscillator.setup(f3);
            }
        }
    }

    public void setupRelative(Motion motion) {
        this.mStartMotionPath.setupRelative(motion, motion.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motion, motion.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }
}
