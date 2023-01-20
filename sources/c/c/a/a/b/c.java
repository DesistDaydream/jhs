package c.c.a.a.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: TypedValues.java */
/* loaded from: classes.dex */
public final /* synthetic */ class c {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case -1310311125:
                if (str.equals("easing")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return TypedValues.Cycle.TYPE_EASING;
            case 1:
                return 308;
            case 2:
                return 309;
            case 3:
                return 310;
            case 4:
                return 304;
            case 5:
                return 305;
            case 6:
                return 306;
            case 7:
                return 315;
            case '\b':
                return 313;
            case '\t':
                return 314;
            case '\n':
                return 311;
            case 11:
                return 312;
            case '\f':
                return 403;
            case '\r':
                return 401;
            case 14:
                return 416;
            case 15:
                return 402;
            default:
                return -1;
        }
    }

    public static int b(int i2) {
        if (i2 != 100) {
            if (i2 != 101) {
                if (i2 != 416) {
                    if (i2 == 420 || i2 == 421) {
                        return 8;
                    }
                    switch (i2) {
                        case 304:
                        case 305:
                        case 306:
                        case 307:
                        case 308:
                        case 309:
                        case 310:
                        case 311:
                        case 312:
                        case 313:
                        case 314:
                        case 315:
                            return 4;
                        default:
                            switch (i2) {
                                case 401:
                                case 402:
                                    return 2;
                                case 403:
                                    return 4;
                                default:
                                    switch (i2) {
                                        case TypedValues.Cycle.TYPE_WAVE_PERIOD /* 423 */:
                                        case TypedValues.Cycle.TYPE_WAVE_OFFSET /* 424 */:
                                        case TypedValues.Cycle.TYPE_WAVE_PHASE /* 425 */:
                                            return 4;
                                        default:
                                            return -1;
                                    }
                            }
                    }
                }
                return 4;
            }
            return 8;
        }
        return 2;
    }
}
