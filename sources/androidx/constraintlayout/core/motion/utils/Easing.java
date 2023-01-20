package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    public String str = "identity";
    public static Easing sDefault = new Easing();
    private static final String STANDARD_NAME = "standard";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals(ACCELERATE_NAME)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals(DECELERATE_NAME)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1197605014:
                if (str.equals(ANTICIPATE_NAME)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals(LINEAR_NAME)) {
                    c2 = 3;
                    break;
                }
                break;
            case -749065269:
                if (str.equals(OVERSHOOT_NAME)) {
                    c2 = 4;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals(STANDARD_NAME)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new CubicEasing(ACCELERATE);
            case 1:
                return new CubicEasing(DECELERATE);
            case 2:
                return new CubicEasing(ANTICIPATE);
            case 3:
                return new CubicEasing(LINEAR);
            case 4:
                return new CubicEasing(OVERSHOOT);
            case 5:
                return new CubicEasing(STANDARD);
            default:
                PrintStream printStream = System.err;
                printStream.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double get(double d2) {
        return d2;
    }

    public double getDiff(double d2) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }

    /* loaded from: classes.dex */
    public static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;
        public double x1;
        public double x2;
        public double y1;
        public double y2;

        public CubicEasing(String str) {
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.x1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i2 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i2);
            this.y1 = Double.parseDouble(str.substring(i2, indexOf3).trim());
            int i3 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i3);
            this.x2 = Double.parseDouble(str.substring(i3, indexOf4).trim());
            int i4 = indexOf4 + 1;
            this.y2 = Double.parseDouble(str.substring(i4, str.indexOf(41, i4)).trim());
        }

        private double getDiffX(double d2) {
            double d3 = 1.0d - d2;
            double d4 = this.x1;
            double d5 = this.x2;
            return (d3 * 3.0d * d3 * d4) + (d3 * 6.0d * d2 * (d5 - d4)) + (3.0d * d2 * d2 * (1.0d - d5));
        }

        private double getDiffY(double d2) {
            double d3 = 1.0d - d2;
            double d4 = this.y1;
            double d5 = this.y2;
            return (d3 * 3.0d * d3 * d4) + (d3 * 6.0d * d2 * (d5 - d4)) + (3.0d * d2 * d2 * (1.0d - d5));
        }

        private double getX(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.x1 * d3 * d4 * d2) + (this.x2 * d4 * d2 * d2) + (d2 * d2 * d2);
        }

        private double getY(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.y1 * d3 * d4 * d2) + (this.y2 * d4 * d2 * d2) + (d2 * d2 * d2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > error) {
                d3 *= 0.5d;
                d4 = getX(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double x = getX(d5);
            double d6 = d4 + d3;
            double x2 = getX(d6);
            double y = getY(d5);
            return (((getY(d6) - y) * (d2 - x)) / (x2 - x)) + y;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double d2) {
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > d_error) {
                d3 *= 0.5d;
                d4 = getX(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d4 + d3;
            return (getY(d6) - getY(d5)) / (getX(d6) - getX(d5));
        }

        public void setup(double d2, double d3, double d4, double d5) {
            this.x1 = d2;
            this.y1 = d3;
            this.x2 = d4;
            this.y2 = d5;
        }

        public CubicEasing(double d2, double d3, double d4, double d5) {
            setup(d2, d3, d4, d5);
        }
    }
}
