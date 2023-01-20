package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    public double eps;
    public double mS;
    public double mT;

    public Schlick(String str) {
        this.str = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.mS = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i2 = indexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i2, str.indexOf(44, i2)).trim());
    }

    private double dfunc(double d2) {
        double d3 = this.mT;
        if (d2 < d3) {
            double d4 = this.mS;
            return ((d4 * d3) * d3) / ((((d3 - d2) * d4) + d2) * ((d4 * (d3 - d2)) + d2));
        }
        double d5 = this.mS;
        return (((d3 - 1.0d) * d5) * (d3 - 1.0d)) / (((((-d5) * (d3 - d2)) - d2) + 1.0d) * ((((-d5) * (d3 - d2)) - d2) + 1.0d));
    }

    private double func(double d2) {
        double d3 = this.mT;
        if (d2 < d3) {
            return (d3 * d2) / (d2 + (this.mS * (d3 - d2)));
        }
        return ((1.0d - d3) * (d2 - 1.0d)) / ((1.0d - d2) - (this.mS * (d3 - d2)));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d2) {
        return func(d2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d2) {
        return dfunc(d2);
    }
}
