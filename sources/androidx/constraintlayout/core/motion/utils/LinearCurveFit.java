package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    public double[] mSlopeTemp;
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        this.mT = dArr;
        this.mY = dArr2;
        if (length2 > 2) {
            double d2 = 0.0d;
            double d3 = 0.0d;
            int i2 = 0;
            while (i2 < dArr.length) {
                double d4 = dArr2[i2][0];
                double d5 = dArr2[i2][0];
                if (i2 > 0) {
                    Math.hypot(d4 - d2, d5 - d3);
                }
                i2++;
                d2 = d4;
                d3 = d5;
            }
            this.mTotalLength = 0.0d;
        }
    }

    private double getLength2D(double d2) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d2 <= dArr[0]) {
            return 0.0d;
        }
        int i2 = length - 1;
        if (d2 >= dArr[i2]) {
            return this.mTotalLength;
        }
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        int i3 = 0;
        while (i3 < i2) {
            double[][] dArr2 = this.mY;
            double d6 = dArr2[i3][0];
            double d7 = dArr2[i3][1];
            if (i3 > 0) {
                d3 += Math.hypot(d6 - d4, d7 - d5);
            }
            double[] dArr3 = this.mT;
            if (d2 == dArr3[i3]) {
                return d3;
            }
            int i4 = i3 + 1;
            if (d2 < dArr3[i4]) {
                double d8 = (d2 - dArr3[i3]) / (dArr3[i4] - dArr3[i3]);
                double[][] dArr4 = this.mY;
                double d9 = 1.0d - d8;
                return d3 + Math.hypot(d7 - ((dArr4[i3][1] * d9) + (dArr4[i4][1] * d8)), d6 - ((dArr4[i3][0] * d9) + (dArr4[i4][0] * d8)));
            }
            i3 = i4;
            d4 = d6;
            d5 = d7;
        }
        return 0.0d;
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
                double d3 = (d2 - dArr3[i7]) / (dArr3[i9] - dArr3[i7]);
                while (i2 < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i2] = (dArr4[i7][i2] * (1.0d - d3)) + (dArr4[i9][i2] * d3);
                    i2++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d2, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        if (d2 <= dArr2[0]) {
            d2 = dArr2[0];
        } else {
            int i2 = length - 1;
            if (d2 >= dArr2[i2]) {
                d2 = dArr2[i2];
            }
        }
        int i3 = 0;
        while (i3 < length - 1) {
            double[] dArr3 = this.mT;
            int i4 = i3 + 1;
            if (d2 <= dArr3[i4]) {
                double d3 = dArr3[i4] - dArr3[i3];
                double d4 = dArr3[i3];
                for (int i5 = 0; i5 < length2; i5++) {
                    double[][] dArr4 = this.mY;
                    dArr[i5] = (dArr4[i4][i5] - dArr4[i3][i5]) / d3;
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

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d2, int i2) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i3 = 0;
        if (d2 < dArr[0]) {
            d2 = dArr[0];
        } else {
            int i4 = length - 1;
            if (d2 >= dArr[i4]) {
                d2 = dArr[i4];
            }
        }
        while (i3 < length - 1) {
            double[] dArr2 = this.mT;
            int i5 = i3 + 1;
            if (d2 <= dArr2[i5]) {
                double d3 = dArr2[i5] - dArr2[i3];
                double d4 = dArr2[i3];
                double[][] dArr3 = this.mY;
                return (dArr3[i5][i2] - dArr3[i3][i2]) / d3;
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
                double d3 = (d2 - dArr2[i7]) / (dArr2[i9] - dArr2[i7]);
                while (i2 < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i2] = (float) ((dArr3[i7][i2] * (1.0d - d3)) + (dArr3[i9][i2] * d3));
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
                double d3 = (d2 - dArr2[i3]) / (dArr2[i6] - dArr2[i3]);
                double[][] dArr3 = this.mY;
                return (dArr3[i3][i2] * (1.0d - d3)) + (dArr3[i6][i2] * d3);
            }
            i3 = i6;
        }
        return 0.0d;
    }
}
