package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    /* loaded from: classes.dex */
    public static class AlphaSet extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setAlpha(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class CustomSet extends ViewTimeCycle {
        public String mAttributeName;
        public float[] mCache;
        public SparseArray<ConstraintAttribute> mConstraintAttributeList;
        public float[] mTempValues;
        public SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String attribute, SparseArray<ConstraintAttribute> attrList) {
            this.mAttributeName = attribute.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
            this.mConstraintAttributeList = attrList;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int position, float value, float period, int shape, float offset) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            this.mCurveFit.getPos(t, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = time - this.last_time;
            if (Float.isNaN(this.last_cycle)) {
                float floatValue = cache.getFloatValue(view, this.mAttributeName, 0);
                this.last_cycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.last_cycle = 0.0f;
                }
            }
            float f4 = (float) ((this.last_cycle + ((j2 * 1.0E-9d) * f2)) % 1.0d);
            this.last_cycle = f4;
            this.last_time = time;
            float calcWave = calcWave(f4);
            this.mContinue = false;
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.mCache;
                if (i2 >= fArr2.length) {
                    break;
                }
                boolean z = this.mContinue;
                float[] fArr3 = this.mTempValues;
                this.mContinue = z | (((double) fArr3[i2]) != 0.0d);
                fArr2[i2] = (fArr3[i2] * calcWave) + f3;
                i2++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
            if (f2 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int curveType) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i2 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i2];
            this.mCache = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i3);
                float[] valueAt = this.mWaveProperties.valueAt(i3);
                dArr[i3] = keyAt * 0.01d;
                this.mConstraintAttributeList.valueAt(i3).getValuesToInterpolate(this.mTempValues);
                int i4 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i4 < fArr.length) {
                        dArr2[i3][i4] = fArr[i4];
                        i4++;
                    }
                }
                dArr2[i3][numberOfInterpolatedValues] = valueAt[0];
                dArr2[i3][numberOfInterpolatedValues + 1] = valueAt[1];
            }
            this.mCurveFit = CurveFit.get(curveType, dArr, dArr2);
        }

        public void setPoint(int position, ConstraintAttribute value, float period, int shape, float offset) {
            this.mConstraintAttributeList.append(position, value);
            this.mWaveProperties.append(position, new float[]{period, offset});
            this.mWaveShape = Math.max(this.mWaveShape, shape);
        }
    }

    /* loaded from: classes.dex */
    public static class ElevationSet extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(t, time, view, cache));
            }
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class PathRotate extends ViewTimeCycle {
        public boolean setPathRotate(View view, KeyCache cache, float t, long time, double dx, double dy) {
            view.setRotation(get(t, time, view, cache) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class ProgressSet extends ViewTimeCycle {
        public boolean mNoMethod = false;

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(t, time, view, cache));
            } else if (this.mNoMethod) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(get(t, time, view, cache)));
                    } catch (IllegalAccessException e2) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e2);
                    } catch (InvocationTargetException e3) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e3);
                    }
                }
            }
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class RotationSet extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotation(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class RotationXset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotationX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class RotationYset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotationY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class ScaleXset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setScaleX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class ScaleYset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setScaleY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationXset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setTranslationX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationYset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setTranslationY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class TranslationZset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(t, time, view, cache));
            }
            return this.mContinue;
        }
    }

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> attrList) {
        return new CustomSet(str, attrList);
    }

    public static ViewTimeCycle makeSpline(String str, long currentTime) {
        ViewTimeCycle rotationXset;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c2 = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 11;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                rotationXset = new RotationXset();
                break;
            case 1:
                rotationXset = new RotationYset();
                break;
            case 2:
                rotationXset = new TranslationXset();
                break;
            case 3:
                rotationXset = new TranslationYset();
                break;
            case 4:
                rotationXset = new TranslationZset();
                break;
            case 5:
                rotationXset = new ProgressSet();
                break;
            case 6:
                rotationXset = new ScaleXset();
                break;
            case 7:
                rotationXset = new ScaleYset();
                break;
            case '\b':
                rotationXset = new RotationSet();
                break;
            case '\t':
                rotationXset = new ElevationSet();
                break;
            case '\n':
                rotationXset = new PathRotate();
                break;
            case 11:
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.setStartTime(currentTime);
        return rotationXset;
    }

    public float get(float pos, long time, View view, KeyCache cache) {
        this.mCurveFit.getPos(pos, this.mCache);
        float[] fArr = this.mCache;
        float f2 = fArr[1];
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i2 == 0) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = cache.getFloatValue(view, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f3 = (float) ((this.last_cycle + (((time - this.last_time) * 1.0E-9d) * f2)) % 1.0d);
        this.last_cycle = f3;
        cache.setFloatValue(view, this.mType, 0, f3);
        this.last_time = time;
        float f4 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f4) + this.mCache[2];
        this.mContinue = (f4 == 0.0f && i2 == 0) ? false : true;
        return calcWave;
    }

    public abstract boolean setProperty(View view, float t, long time, KeyCache cache);
}
