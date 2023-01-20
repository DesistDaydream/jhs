package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate = true;
    public double[] mSlopeTemp;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        int i2 = length - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, i2, length2);
        double[][] dArr4 = (double[][]) Array.newInstance(double.class, length, length2);
        for (int i3 = 0; i3 < length2; i3++) {
            int i4 = 0;
            while (i4 < i2) {
                int i5 = i4 + 1;
                dArr3[i4][i3] = (dArr2[i5][i3] - dArr2[i4][i3]) / (dArr[i5] - dArr[i4]);
                if (i4 == 0) {
                    dArr4[i4][i3] = dArr3[i4][i3];
                } else {
                    dArr4[i4][i3] = (dArr3[i4 - 1][i3] + dArr3[i4][i3]) * 0.5d;
                }
                i4 = i5;
            }
            dArr4[i2][i3] = dArr3[length - 2][i3];
        }
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < length2; i7++) {
                if (dArr3[i6][i7] == 0.0d) {
                    dArr4[i6][i7] = 0.0d;
                    dArr4[i6 + 1][i7] = 0.0d;
                } else {
                    double d2 = dArr4[i6][i7] / dArr3[i6][i7];
                    int i8 = i6 + 1;
                    double d3 = dArr4[i8][i7] / dArr3[i6][i7];
                    double hypot = Math.hypot(d2, d3);
                    if (hypot > 9.0d) {
                        double d4 = 3.0d / hypot;
                        dArr4[i6][i7] = d2 * d4 * dArr3[i6][i7];
                        dArr4[i8][i7] = d4 * d3 * dArr3[i6][i7];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[str.length() / 2];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i2 = 0;
        while (indexOf2 != -1) {
            dArr[i2] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i2++;
        }
        dArr[i2] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        return buildWave(Arrays.copyOf(dArr, i2 + 1));
    }

    private static double diff(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 * d3;
        double d9 = d3 * 6.0d;
        double d10 = 3.0d * d2;
        return ((((((((((-6.0d) * d8) * d5) + (d9 * d5)) + ((6.0d * d8) * d4)) - (d9 * d4)) + ((d10 * d7) * d8)) + ((d10 * d6) * d8)) - (((2.0d * d2) * d7) * d3)) - (((4.0d * d2) * d6) * d3)) + (d2 * d6);
    }

    private static double interpolate(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 * d3;
        double d9 = d8 * d3;
        double d10 = 3.0d * d8;
        double d11 = d2 * d7;
        double d12 = d2 * d6;
        return (((((((((((-2.0d) * d9) * d5) + (d10 * d5)) + ((d9 * 2.0d) * d4)) - (d10 * d4)) + d4) + (d11 * d9)) + (d9 * d12)) - (d11 * d8)) - (((d2 * 2.0d) * d6) * d8)) + (d12 * d3);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d2, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i2 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            if (d2 <= dArr2[0]) {
                getSlope(dArr2[0], this.mSlopeTemp);
                for (int i3 = 0; i3 < length2; i3++) {
                    dArr[i3] = this.mY[0][i3] + ((d2 - this.mT[0]) * this.mSlopeTemp[i3]);
                }
                return;
            }
            int i4 = length - 1;
            if (d2 >= dArr2[i4]) {
                getSlope(dArr2[i4], this.mSlopeTemp);
                while (i2 < length2) {
                    dArr[i2] = this.mY[i4][i2] + ((d2 - this.mT[i4]) * this.mSlopeTemp[i2]);
                    i2++;
                }
                return;
            }
        } else if (d2 <= dArr2[0]) {
            for (int i5 = 0; i5 < length2; i5++) {
                dArr[i5] = this.mY[0][i5];
            }
            return;
        } else {
            int i6 = length - 1;
            if (d2 >= dArr2[i6]) {
                while (i2 < length2) {
                    dArr[i2] = this.mY[i6][i2];
                    i2++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d2 == this.mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.mY[i7][i8];
                }
            }
            double[] dArr3 = this.mT;
            int i9 = i7 + 1;
            if (d2 < dArr3[i9]) {
                double d3 = dArr3[i9] - dArr3[i7];
                double d4 = (d2 - dArr3[i7]) / d3;
                while (i2 < length2) {
                    double[][] dArr4 = this.mY;
                    double d5 = dArr4[i7][i2];
                    double d6 = dArr4[i9][i2];
                    double[][] dArr5 = this.mTangent;
                    dArr[i2] = interpolate(d3, d4, d5, d6, dArr5[i7][i2], dArr5[i9][i2]);
                    i2++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d2, double[] dArr) {
        double d3;
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        if (d2 <= dArr2[0]) {
            d3 = dArr2[0];
        } else {
            int i2 = length - 1;
            d3 = d2 >= dArr2[i2] ? dArr2[i2] : d2;
        }
        int i3 = 0;
        while (i3 < length - 1) {
            double[] dArr3 = this.mT;
            int i4 = i3 + 1;
            if (d3 <= dArr3[i4]) {
                double d4 = dArr3[i4] - dArr3[i3];
                double d5 = (d3 - dArr3[i3]) / d4;
                for (int i5 = 0; i5 < length2; i5++) {
                    double[][] dArr4 = this.mY;
                    double d6 = dArr4[i3][i5];
                    double d7 = dArr4[i4][i5];
                    double[][] dArr5 = this.mTangent;
                    dArr[i5] = diff(d4, d5, d6, d7, dArr5[i3][i5], dArr5[i4][i5]) / d4;
                }
                return;
            }
            i3 = i4;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    private static MonotonicCurveFit buildWave(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d2 = 1.0d / length2;
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, length, 1);
        double[] dArr3 = new double[length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            double d3 = dArr[i2];
            int i3 = i2 + length2;
            dArr2[i3][0] = d3;
            double d4 = i2 * d2;
            dArr3[i3] = d4;
            if (i2 > 0) {
                int i4 = (length2 * 2) + i2;
                dArr2[i4][0] = d3 + 1.0d;
                dArr3[i4] = d4 + 1.0d;
                int i5 = i2 - 1;
                dArr2[i5][0] = (d3 - 1.0d) - d2;
                dArr3[i5] = (d4 - 1.0d) - d2;
            }
        }
        return new MonotonicCurveFit(dArr3, dArr2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d2, int i2) {
        double d3;
        double[] dArr = this.mT;
        int length = dArr.length;
        int i3 = 0;
        if (d2 < dArr[0]) {
            d3 = dArr[0];
        } else {
            int i4 = length - 1;
            d3 = d2 >= dArr[i4] ? dArr[i4] : d2;
        }
        while (i3 < length - 1) {
            double[] dArr2 = this.mT;
            int i5 = i3 + 1;
            if (d3 <= dArr2[i5]) {
                double d4 = dArr2[i5] - dArr2[i3];
                double[][] dArr3 = this.mY;
                double d5 = dArr3[i3][i2];
                double d6 = dArr3[i5][i2];
                double[][] dArr4 = this.mTangent;
                return diff(d4, (d3 - dArr2[i3]) / d4, d5, d6, dArr4[i3][i2], dArr4[i5][i2]) / d4;
            }
            i3 = i5;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d2, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i2 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            if (d2 <= dArr[0]) {
                getSlope(dArr[0], this.mSlopeTemp);
                for (int i3 = 0; i3 < length2; i3++) {
                    fArr[i3] = (float) (this.mY[0][i3] + ((d2 - this.mT[0]) * this.mSlopeTemp[i3]));
                }
                return;
            }
            int i4 = length - 1;
            if (d2 >= dArr[i4]) {
                getSlope(dArr[i4], this.mSlopeTemp);
                while (i2 < length2) {
                    fArr[i2] = (float) (this.mY[i4][i2] + ((d2 - this.mT[i4]) * this.mSlopeTemp[i2]));
                    i2++;
                }
                return;
            }
        } else if (d2 <= dArr[0]) {
            for (int i5 = 0; i5 < length2; i5++) {
                fArr[i5] = (float) this.mY[0][i5];
            }
            return;
        } else {
            int i6 = length - 1;
            if (d2 >= dArr[i6]) {
                while (i2 < length2) {
                    fArr[i2] = (float) this.mY[i6][i2];
                    i2++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d2 == this.mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) this.mY[i7][i8];
                }
            }
            double[] dArr2 = this.mT;
            int i9 = i7 + 1;
            if (d2 < dArr2[i9]) {
                double d3 = dArr2[i9] - dArr2[i7];
                double d4 = (d2 - dArr2[i7]) / d3;
                while (i2 < length2) {
                    double[][] dArr3 = this.mY;
                    double d5 = dArr3[i7][i2];
                    double d6 = dArr3[i9][i2];
                    double[][] dArr4 = this.mTangent;
                    fArr[i2] = (float) interpolate(d3, d4, d5, d6, dArr4[i7][i2], dArr4[i9][i2]);
                    i2++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d2, int i2) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i3 = 0;
        if (this.mExtrapolate) {
            if (d2 <= dArr[0]) {
                return this.mY[0][i2] + ((d2 - dArr[0]) * getSlope(dArr[0], i2));
            }
            int i4 = length - 1;
            if (d2 >= dArr[i4]) {
                return this.mY[i4][i2] + ((d2 - dArr[i4]) * getSlope(dArr[i4], i2));
            }
        } else if (d2 <= dArr[0]) {
            return this.mY[0][i2];
        } else {
            int i5 = length - 1;
            if (d2 >= dArr[i5]) {
                return this.mY[i5][i2];
            }
        }
        while (i3 < length - 1) {
            double[] dArr2 = this.mT;
            if (d2 == dArr2[i3]) {
                return this.mY[i3][i2];
            }
            int i6 = i3 + 1;
            if (d2 < dArr2[i6]) {
                double d3 = dArr2[i6] - dArr2[i3];
                double d4 = (d2 - dArr2[i3]) / d3;
                double[][] dArr3 = this.mY;
                double d5 = dArr3[i3][i2];
                double d6 = dArr3[i6][i2];
                double[][] dArr4 = this.mTangent;
                return interpolate(d3, d4, d5, d6, dArr4[i3][i2], dArr4[i6][i2]);
            }
            i3 = i6;
        }
        return 0.0d;
    }
}
