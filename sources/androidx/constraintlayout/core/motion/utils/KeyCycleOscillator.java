package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import c.c.a.a.b.c;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    private String mWaveString = null;
    public int mVariesBy = 0;
    public ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class CoreSpline extends KeyCycleOscillator {
        public String type;
        public int typeId;

        public CoreSpline(String str) {
            this.type = str;
            this.typeId = c.a(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f2) {
            motionWidget.setValue(this.typeId, get(f2));
        }
    }

    /* loaded from: classes.dex */
    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        public static final int UNSET = -1;
        private final int OFFST;
        private final int PHASE;
        private final int VALUE;
        public CurveFit mCurveFit;
        public float[] mOffset;
        public Oscillator mOscillator;
        public float mPathLength;
        public float[] mPeriod;
        public float[] mPhase;
        public double[] mPosition;
        public float[] mScale;
        public double[] mSplineSlopeCache;
        public double[] mSplineValueCache;
        public float[] mValues;
        private final int mVariesBy;
        public int mWaveShape;

        public CycleOscillator(int i2, String str, int i3, int i4) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.OFFST = 0;
            this.PHASE = 1;
            this.VALUE = 2;
            this.mWaveShape = i2;
            this.mVariesBy = i3;
            oscillator.setType(i2, str);
            this.mValues = new float[i4];
            this.mPosition = new double[i4];
            this.mPeriod = new float[i4];
            this.mOffset = new float[i4];
            this.mPhase = new float[i4];
            this.mScale = new float[i4];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f2) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d2 = f2;
                curveFit.getSlope(d2, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d2, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d3 = f2;
            double value = this.mOscillator.getValue(d3, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d3, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return dArr2[0] + (value * dArr2[2]) + (slope * this.mSplineValueCache[2]);
        }

        public double getValues(float f2) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f2, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffset[0];
                dArr[1] = this.mPhase[0];
                dArr[2] = this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            return dArr2[0] + (this.mOscillator.getValue(f2, dArr2[1]) * this.mSplineValueCache[2]);
        }

        public void setPoint(int i2, int i3, float f2, float f3, float f4, float f5) {
            this.mPosition[i2] = i3 / 100.0d;
            this.mPeriod[i2] = f2;
            this.mOffset[i2] = f3;
            this.mPhase[i2] = f4;
            this.mValues[i2] = f5;
        }

        public void setup(float f2) {
            this.mPathLength = f2;
            double[][] dArr = (double[][]) Array.newInstance(double.class, this.mPosition.length, 3);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 2];
            this.mSplineSlopeCache = new double[fArr.length + 2];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i2 = 0; i2 < dArr.length; i2++) {
                dArr[i2][0] = this.mOffset[i2];
                dArr[i2][1] = this.mPhase[i2];
                dArr[i2][2] = this.mValues[i2];
                this.mOscillator.addPoint(this.mPosition[i2], this.mPeriod[i2]);
            }
            this.mOscillator.normalize();
            double[] dArr3 = this.mPosition;
            if (dArr3.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr3, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class IntDoubleSort {
        private IntDoubleSort() {
        }

        private static int partition(int[] iArr, float[] fArr, int i2, int i3) {
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

        public static void sort(int[] iArr, float[] fArr, int i2, int i3) {
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

        private static void swap(int[] iArr, float[] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
        }
    }

    /* loaded from: classes.dex */
    public static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        private static int partition(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
            int i4 = iArr[i3];
            int i5 = i2;
            while (i2 < i3) {
                if (iArr[i2] <= i4) {
                    swap(iArr, fArr, fArr2, i5, i2);
                    i5++;
                }
                i2++;
            }
            swap(iArr, fArr, fArr2, i5, i3);
            return i5;
        }

        public static void sort(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
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
                    int partition = partition(iArr, fArr, fArr2, i6, i7);
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

        private static void swap(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
            float f3 = fArr2[i2];
            fArr2[i2] = fArr2[i3];
            fArr2[i3] = f3;
        }
    }

    /* loaded from: classes.dex */
    public static class PathRotateSet extends KeyCycleOscillator {
        public String type;
        public int typeId;

        public PathRotateSet(String str) {
            this.type = str;
            this.typeId = c.a(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f2, double d2, double d3) {
            motionWidget.setRotationZ(get(f2) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f2) {
            motionWidget.setValue(this.typeId, get(f2));
        }
    }

    /* loaded from: classes.dex */
    public static class WavePoint {
        public float mOffset;
        public float mPeriod;
        public float mPhase;
        public int mPosition;
        public float mValue;

        public WavePoint(int i2, float f2, float f3, float f4, float f5) {
            this.mPosition = i2;
            this.mValue = f5;
            this.mOffset = f3;
            this.mPeriod = f2;
            this.mPhase = f4;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        if (str.equals("pathRotate")) {
            return new PathRotateSet(str);
        }
        return new CoreSpline(str);
    }

    public float get(float f2) {
        return (float) this.mCycleOscillator.getValues(f2);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f2) {
        return (float) this.mCycleOscillator.getSlope(f2);
    }

    public void setCustom(Object obj) {
    }

    public void setPoint(int i2, int i3, String str, int i4, float f2, float f3, float f4, float f5, Object obj) {
        this.mWavePoints.add(new WavePoint(i2, f2, f3, f4, f5));
        if (i4 != -1) {
            this.mVariesBy = i4;
        }
        this.mWaveShape = i3;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setProperty(MotionWidget motionWidget, float f2) {
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f2) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        char c2 = 0;
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, 3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            WavePoint next = it.next();
            float f3 = next.mPeriod;
            dArr[i2] = f3 * 0.01d;
            double[] dArr3 = dArr2[i2];
            float f4 = next.mValue;
            dArr3[c2] = f4;
            double[] dArr4 = dArr2[i2];
            float f5 = next.mOffset;
            dArr4[1] = f5;
            double[] dArr5 = dArr2[i2];
            float f6 = next.mPhase;
            dArr5[2] = f6;
            this.mCycleOscillator.setPoint(i2, next.mPosition, f3, f5, f6, f4);
            i2++;
            c2 = 0;
        }
        this.mCycleOscillator.setup(f2);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        while (it.hasNext()) {
            WavePoint next = it.next();
            str = str + "[" + next.mPosition + " , " + decimalFormat.format(next.mValue) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i2, int i3, String str, int i4, float f2, float f3, float f4, float f5) {
        this.mWavePoints.add(new WavePoint(i2, f2, f3, f4, f5));
        if (i4 != -1) {
            this.mVariesBy = i4;
        }
        this.mWaveShape = i3;
        this.mWaveString = str;
    }
}
