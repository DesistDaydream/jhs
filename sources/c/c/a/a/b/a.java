package c.c.a.a.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: TypedValues.java */
/* loaded from: classes.dex */
public final /* synthetic */ class a {
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
            case -880905839:
                if (str.equals(TypedValues.Attributes.S_TARGET)) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case 97692013:
                if (str.equals(TypedValues.Attributes.S_FRAME)) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case 1167159411:
                if (str.equals(TypedValues.Attributes.S_PIVOT_TARGET)) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c2 = 19;
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
                return TypedValues.Attributes.TYPE_EASING;
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
                return 101;
            case '\r':
                return 307;
            case 14:
                return 303;
            case 15:
                return 100;
            case 16:
                return 301;
            case 17:
                return TypedValues.Attributes.TYPE_PATH_ROTATE;
            case 18:
                return TypedValues.Attributes.TYPE_PIVOT_TARGET;
            case 19:
                return 302;
            default:
                return -1;
        }
    }

    public static int b(int i2) {
        if (i2 != 100) {
            if (i2 != 101) {
                switch (i2) {
                    case 301:
                    case 302:
                        return 2;
                    case 303:
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
                    case TypedValues.Attributes.TYPE_PATH_ROTATE /* 316 */:
                        return 4;
                    case TypedValues.Attributes.TYPE_EASING /* 317 */:
                    case TypedValues.Attributes.TYPE_PIVOT_TARGET /* 318 */:
                        return 8;
                    default:
                        return -1;
                }
            }
            return 8;
        }
        return 2;
    }
}
