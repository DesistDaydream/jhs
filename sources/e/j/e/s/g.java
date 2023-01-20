package e.j.e.s;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class g {
    private static String a(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return "M/d/yy";
                    }
                    throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
                }
                return "MMM d, y";
            }
            return "MMMM d, y";
        }
        return "EEEE, MMMM d, y";
    }

    private static String b(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return "M/d/yy";
                    }
                    throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
                }
                return "MMM d, yyyy";
            }
            return "MMMM d, yyyy";
        }
        return "EEEE, MMMM d, yyyy";
    }

    private static String c(int i2) {
        if (i2 == 0 || i2 == 1) {
            return "h:mm:ss a z";
        }
        if (i2 != 2) {
            if (i2 == 3) {
                return "h:mm a";
            }
            throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
        }
        return "h:mm:ss a";
    }

    public static DateFormat d(int i2) {
        return new SimpleDateFormat(a(i2), Locale.US);
    }

    public static DateFormat e(int i2, int i3) {
        return new SimpleDateFormat(b(i2) + ExpandableTextView.N + c(i3), Locale.US);
    }
}
