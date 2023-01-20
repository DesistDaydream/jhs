package androidx.constraintlayout.core.motion.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;
    public double mDamping = 0.5d;
    private boolean mInitialized = false;
    private int mBoundaryMode = 0;

    private void compute(double d2) {
        double d3 = this.mStiffness;
        double d4 = this.mDamping;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d3 / this.mMass) * d2) * 4.0d)) + 1.0d);
        double d5 = d2 / sqrt;
        int i2 = 0;
        while (i2 < sqrt) {
            float f2 = this.mPos;
            double d6 = this.mTargetPos;
            float f3 = this.mV;
            double d7 = d3;
            float f4 = this.mMass;
            double d8 = d4;
            double d9 = f3 + ((((((-d3) * (f2 - d6)) - (f3 * d4)) / f4) * d5) / 2.0d);
            double d10 = ((((-((f2 + ((d5 * d9) / 2.0d)) - d6)) * d7) - (d9 * d8)) / f4) * d5;
            float f5 = (float) (f3 + d10);
            this.mV = f5;
            float f6 = (float) (f2 + ((f3 + (d10 / 2.0d)) * d5));
            this.mPos = f6;
            int i3 = this.mBoundaryMode;
            if (i3 > 0) {
                if (f6 < 0.0f && (i3 & 1) == 1) {
                    this.mPos = -f6;
                    this.mV = -f5;
                }
                float f7 = this.mPos;
                if (f7 > 1.0f && (i3 & 2) == 2) {
                    this.mPos = 2.0f - f7;
                    this.mV = -this.mV;
                }
            }
            i2++;
            d3 = d7;
            d4 = d8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f2) {
        return null;
    }

    public float getAcceleration() {
        double d2 = this.mStiffness;
        return ((float) (((-d2) * (this.mPos - this.mTargetPos)) - (this.mDamping * this.mV))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f2) {
        compute(f2 - this.mLastTime);
        this.mLastTime = f2;
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f2) {
        return this.mV;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d2 = this.mPos - this.mTargetPos;
        double d3 = this.mStiffness;
        double d4 = this.mV;
        return Math.sqrt((((d4 * d4) * ((double) this.mMass)) + ((d3 * d2) * d2)) / d3) <= ((double) this.mStopThreshold);
    }

    public void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        PrintStream printStream = System.out;
        printStream.println((".(" + stackTraceElement.getFileName() + Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ") + str);
    }

    public void springConfig(float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2) {
        this.mTargetPos = f3;
        this.mDamping = f7;
        this.mInitialized = false;
        this.mPos = f2;
        this.mLastVelocity = f4;
        this.mStiffness = f6;
        this.mMass = f5;
        this.mStopThreshold = f8;
        this.mBoundaryMode = i2;
        this.mLastTime = 0.0f;
    }
}
