package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    public static final int CURVE_OFFSET = 2;
    public static final int CURVE_PERIOD = 1;
    public static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    public static float VAL_2PI = 6.2831855f;
    public int count;
    public long last_time;
    public CurveFit mCurveFit;
    public String mType;
    public int mWaveShape = 0;
    public int[] mTimePoints = new int[10];
    public float[][] mValues = (float[][]) Array.newInstance(float.class, 10, 3);
    public float[] mCache = new float[3];
    public boolean mContinue = false;
    public float last_cycle = Float.NaN;

    /* loaded from: classes.dex */
    public static class CustomSet extends TimeCycleSplineSet {
        public String mAttributeName;
        public float[] mCache;
        public KeyFrameArray.CustomArray mConstraintAttributeList;
        public float[] mTempValues;
        public KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
            this.mConstraintAttributeList = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i2, float f2, float f3, int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f2, long j2, KeyCache keyCache) {
            this.mCurveFit.getPos(f2, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j3 = j2 - this.last_time;
            if (Float.isNaN(this.last_cycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                this.last_cycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.last_cycle = 0.0f;
                }
            }
            float f5 = (float) ((this.last_cycle + ((j3 * 1.0E-9d) * f3)) % 1.0d);
            this.last_cycle = f5;
            this.last_time = j2;
            float calcWave = calcWave(f5);
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
                fArr2[i2] = (fArr3[i2] * calcWave) + f4;
                i2++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mCache);
            if (f3 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i2) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i3 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i3];
            this.mCache = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, i3);
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i4);
                CustomAttribute valueAt = this.mConstraintAttributeList.valueAt(i4);
                float[] valueAt2 = this.mWaveProperties.valueAt(i4);
                dArr[i4] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i5 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i5 < fArr.length) {
                        dArr2[i4][i5] = fArr[i5];
                        i5++;
                    }
                }
                dArr2[i4][numberOfInterpolatedValues] = valueAt2[0];
                dArr2[i4][numberOfInterpolatedValues + 1] = valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }

        public void setPoint(int i2, CustomAttribute customAttribute, float f2, int i3, float f3) {
            this.mConstraintAttributeList.append(i2, customAttribute);
            this.mWaveProperties.append(i2, new float[]{f2, f3});
            this.mWaveShape = Math.max(this.mWaveShape, i3);
        }
    }

    /* loaded from: classes.dex */
    public static class CustomVarSet extends TimeCycleSplineSet {
        public String mAttributeName;
        public float[] mCache;
        public KeyFrameArray.CustomVar mConstraintAttributeList;
        public float[] mTempValues;
        public KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
            this.mConstraintAttributeList = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i2, float f2, float f3, int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f2, long j2, KeyCache keyCache) {
            this.mCurveFit.getPos(f2, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j3 = j2 - this.last_time;
            if (Float.isNaN(this.last_cycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                this.last_cycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.last_cycle = 0.0f;
                }
            }
            float f5 = (float) ((this.last_cycle + ((j3 * 1.0E-9d) * f3)) % 1.0d);
            this.last_cycle = f5;
            this.last_time = j2;
            float calcWave = calcWave(f5);
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
                fArr2[i2] = (fArr3[i2] * calcWave) + f4;
                i2++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mCache);
            if (f3 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i2) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i3 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i3];
            this.mCache = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, i3);
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i4);
                CustomVariable valueAt = this.mConstraintAttributeList.valueAt(i4);
                float[] valueAt2 = this.mWaveProperties.valueAt(i4);
                dArr[i4] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i5 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i5 < fArr.length) {
                        dArr2[i4][i5] = fArr[i5];
                        i5++;
                    }
                }
                dArr2[i4][numberOfInterpolatedValues] = valueAt2[0];
                dArr2[i4][numberOfInterpolatedValues + 1] = valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }

        public void setPoint(int i2, CustomVariable customVariable, float f2, int i3, float f3) {
            this.mConstraintAttributeList.append(i2, customVariable);
            this.mWaveProperties.append(i2, new float[]{f2, f3});
            this.mWaveShape = Math.max(this.mWaveShape, i3);
        }
    }

    /* loaded from: classes.dex */
    public static class Sort {
        public static void doubleQuickSort(int[] iArr, float[][] fArr, int i2, int i3) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i3;
            iArr2[1] = i2;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = i4 - 1;
                int i6 = iArr2[i5];
                i4 = i5 - 1;
                int i7 = iArr2[i4];
                if (i6 < i7) {
                    int partition = partition(iArr, fArr, i6, i7);
                    int i8 = i4 + 1;
                    iArr2[i4] = partition - 1;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    int i10 = i9 + 1;
                    iArr2[i9] = i7;
                    i4 = i10 + 1;
                    iArr2[i10] = partition + 1;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i2, int i3) {
            int i4 = iArr[i3];
            int i5 = i2;
            while (i2 < i3) {
                if (iArr[i2] <= i4) {
                    swap(iArr, fArr, i5, i2);
                    i5++;
                }
                i2++;
            }
            swap(iArr, fArr, i5, i3);
            return i5;
        }

        private static void swap(int[] iArr, float[][] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float[] fArr2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = fArr2;
        }
    }

    public float calcWave(float f2) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f2 * VAL_2PI);
            case 2:
                abs = Math.abs(f2);
                break;
            case 3:
                return (((f2 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f2 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f2 * VAL_2PI);
            case 6:
                float abs2 = 1.0f - Math.abs(((f2 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f2 * VAL_2PI);
        }
        return 1.0f - abs;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i2, float f2, float f3, int i3, float f4) {
        int[] iArr = this.mTimePoints;
        int i4 = this.count;
        iArr[i4] = i2;
        float[][] fArr = this.mValues;
        fArr[i4][0] = f2;
        fArr[i4][1] = f3;
        fArr[i4][2] = f4;
        this.mWaveShape = Math.max(this.mWaveShape, i3);
        this.count++;
    }

    public void setStartTime(long j2) {
        this.last_time = j2;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i2) {
        int i3;
        int i4 = this.count;
        if (i4 == 0) {
            PrintStream printStream = System.err;
            printStream.println("Error no points added to " + this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i4 - 1);
        int i5 = 1;
        int i6 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i5 >= iArr.length) {
                break;
            }
            if (iArr[i5] != iArr[i5 - 1]) {
                i6++;
            }
            i5++;
        }
        if (i6 == 0) {
            i6 = 1;
        }
        double[] dArr = new double[i6];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i6, 3);
        int i7 = 0;
        while (i3 < this.count) {
            if (i3 > 0) {
                int[] iArr2 = this.mTimePoints;
                i3 = iArr2[i3] == iArr2[i3 + (-1)] ? i3 + 1 : 0;
            }
            dArr[i7] = this.mTimePoints[i3] * 0.01d;
            double[] dArr3 = dArr2[i7];
            float[][] fArr = this.mValues;
            dArr3[0] = fArr[i3][0];
            dArr2[i7][1] = fArr[i3][1];
            dArr2[i7][2] = fArr[i3][2];
            i7++;
        }
        this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.count; i2++) {
            str = str + "[" + this.mTimePoints[i2] + " , " + decimalFormat.format(this.mValues[i2]) + "] ";
        }
        return str;
    }
}
