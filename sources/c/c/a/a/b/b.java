package c.c.a.a.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: TypedValues.java */
/* loaded from: classes.dex */
public final /* synthetic */ class b {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case -1095013018:
                if (str.equals(TypedValues.Custom.S_DIMENSION)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -891985903:
                if (str.equals("string")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -710953590:
                if (str.equals(TypedValues.Custom.S_REFERENCE)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 64711720:
                if (str.equals("boolean")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 94842723:
                if (str.equals("color")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 97526364:
                if (str.equals("float")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1958052158:
                if (str.equals("integer")) {
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
                return TypedValues.Custom.TYPE_DIMENSION;
            case 1:
                return TypedValues.Custom.TYPE_STRING;
            case 2:
                return TypedValues.Custom.TYPE_REFERENCE;
            case 3:
                return TypedValues.Custom.TYPE_BOOLEAN;
            case 4:
                return TypedValues.Custom.TYPE_COLOR;
            case 5:
                return TypedValues.Custom.TYPE_FLOAT;
            case 6:
                return TypedValues.Custom.TYPE_INT;
            default:
                return -1;
        }
    }
}
