package e.j.a.c.m;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class d {
    private d() {
    }

    public static Pair<String, String> a(@Nullable Long l2, @Nullable Long l3) {
        return b(l2, l3, null);
    }

    public static Pair<String, String> b(@Nullable Long l2, @Nullable Long l3, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l2 == null && l3 == null) {
            return Pair.create(null, null);
        }
        if (l2 == null) {
            return Pair.create(null, d(l3.longValue(), simpleDateFormat));
        }
        if (l3 == null) {
            return Pair.create(d(l2.longValue(), simpleDateFormat), null);
        }
        Calendar t = o.t();
        Calendar v = o.v();
        v.setTimeInMillis(l2.longValue());
        Calendar v2 = o.v();
        v2.setTimeInMillis(l3.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l2.longValue())), simpleDateFormat.format(new Date(l3.longValue())));
        } else if (v.get(1) == v2.get(1)) {
            if (v.get(1) == t.get(1)) {
                return Pair.create(f(l2.longValue(), Locale.getDefault()), f(l3.longValue(), Locale.getDefault()));
            }
            return Pair.create(f(l2.longValue(), Locale.getDefault()), k(l3.longValue(), Locale.getDefault()));
        } else {
            return Pair.create(k(l2.longValue(), Locale.getDefault()), k(l3.longValue(), Locale.getDefault()));
        }
    }

    public static String c(long j2) {
        return d(j2, null);
    }

    public static String d(long j2, @Nullable SimpleDateFormat simpleDateFormat) {
        Calendar t = o.t();
        Calendar v = o.v();
        v.setTimeInMillis(j2);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j2));
        }
        if (t.get(1) == v.get(1)) {
            return e(j2);
        }
        return j(j2);
    }

    public static String e(long j2) {
        return f(j2, Locale.getDefault());
    }

    public static String f(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return o.c(locale).format(new Date(j2));
        }
        return o.m(locale).format(new Date(j2));
    }

    public static String g(long j2) {
        return h(j2, Locale.getDefault());
    }

    public static String h(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return o.d(locale).format(new Date(j2));
        }
        return o.i(locale).format(new Date(j2));
    }

    public static String i(Context context, long j2) {
        return DateUtils.formatDateTime(context, j2 - TimeZone.getDefault().getOffset(j2), 36);
    }

    public static String j(long j2) {
        return k(j2, Locale.getDefault());
    }

    public static String k(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return o.x(locale).format(new Date(j2));
        }
        return o.k(locale).format(new Date(j2));
    }

    public static String l(long j2) {
        return m(j2, Locale.getDefault());
    }

    public static String m(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return o.y(locale).format(new Date(j2));
        }
        return o.i(locale).format(new Date(j2));
    }
}
