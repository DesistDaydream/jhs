package c.c.a.a.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: TypedValues.java */
/* loaded from: classes.dex */
public final /* synthetic */ class f {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c2 = 6;
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
                return TypedValues.Position.TYPE_TRANSITION_EASING;
            case 1:
                return 503;
            case 2:
                return TypedValues.Position.TYPE_PERCENT_HEIGHT;
            case 3:
                return TypedValues.Position.TYPE_DRAWPATH;
            case 4:
                return TypedValues.Position.TYPE_SIZE_PERCENT;
            case 5:
                return TypedValues.Position.TYPE_PERCENT_X;
            case 6:
                return TypedValues.Position.TYPE_PERCENT_Y;
            default:
                return -1;
        }
    }

    public static int b(int i2) {
        if (i2 != 100) {
            if (i2 != 101) {
                switch (i2) {
                    case TypedValues.Position.TYPE_TRANSITION_EASING /* 501 */:
                    case TypedValues.Position.TYPE_DRAWPATH /* 502 */:
                        return 8;
                    case 503:
                    case TypedValues.Position.TYPE_PERCENT_HEIGHT /* 504 */:
                    case TypedValues.Position.TYPE_SIZE_PERCENT /* 505 */:
                    case TypedValues.Position.TYPE_PERCENT_X /* 506 */:
                    case TypedValues.Position.TYPE_PERCENT_Y /* 507 */:
                        return 4;
                    case TypedValues.Position.TYPE_CURVE_FIT /* 508 */:
                        return 2;
                    default:
                        return -1;
                }
            }
            return 8;
        }
        return 2;
    }
}
