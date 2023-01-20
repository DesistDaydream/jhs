package c.c.a.a.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: TypedValues.java */
/* loaded from: classes.dex */
public final /* synthetic */ class g {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case -1996906958:
                if (str.equals(TypedValues.Transition.S_TRANSITION_FLAGS)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1992012396:
                if (str.equals("duration")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1357874275:
                if (str.equals(TypedValues.Transition.S_INTERPOLATOR)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1298065308:
                if (str.equals(TypedValues.Transition.S_AUTO_TRANSITION)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3707:
                if (str.equals("to")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3151786:
                if (str.equals("from")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1310733335:
                if (str.equals(TypedValues.Transition.S_PATH_MOTION_ARC)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 1839260940:
                if (str.equals(TypedValues.Transition.S_STAGGERED)) {
                    c2 = 7;
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
                return TypedValues.Transition.TYPE_TRANSITION_FLAGS;
            case 1:
                return 700;
            case 2:
                return TypedValues.Transition.TYPE_INTERPOLATOR;
            case 3:
                return TypedValues.Transition.TYPE_AUTO_TRANSITION;
            case 4:
                return TypedValues.Transition.TYPE_TO;
            case 5:
                return TypedValues.Transition.TYPE_FROM;
            case 6:
                return 509;
            case 7:
                return TypedValues.Transition.TYPE_STAGGERED;
            default:
                return -1;
        }
    }

    public static int b(int i2) {
        if (i2 != 509) {
            switch (i2) {
                case 700:
                    return 2;
                case TypedValues.Transition.TYPE_FROM /* 701 */:
                case TypedValues.Transition.TYPE_TO /* 702 */:
                    return 8;
                default:
                    switch (i2) {
                        case TypedValues.Transition.TYPE_INTERPOLATOR /* 705 */:
                        case TypedValues.Transition.TYPE_TRANSITION_FLAGS /* 707 */:
                            return 8;
                        case TypedValues.Transition.TYPE_STAGGERED /* 706 */:
                            return 4;
                        default:
                            return -1;
                    }
            }
        }
        return 2;
    }
}
