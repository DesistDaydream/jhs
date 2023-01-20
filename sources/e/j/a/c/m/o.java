package e.j.a.c.m;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.google.android.material.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class o {
    public static final String a = "UTC";
    public static AtomicReference<n> b = new AtomicReference<>();

    private o() {
    }

    public static void A(@Nullable n nVar) {
        b.set(nVar);
    }

    public static long a(long j2) {
        Calendar v = v();
        v.setTimeInMillis(j2);
        return f(v).getTimeInMillis();
    }

    private static int b(@NonNull String str, @NonNull String str2, int i2, int i3) {
        while (i3 >= 0 && i3 < str.length() && str2.indexOf(str.charAt(i3)) == -1) {
            if (str.charAt(i3) == '\'') {
                do {
                    i3 += i2;
                    if (i3 >= 0 && i3 < str.length()) {
                    }
                } while (str.charAt(i3) != '\'');
            }
            i3 += i2;
        }
        return i3;
    }

    @TargetApi(24)
    public static DateFormat c(Locale locale) {
        return e("MMMd", locale);
    }

    @TargetApi(24)
    public static DateFormat d(Locale locale) {
        return e("MMMEd", locale);
    }

    @TargetApi(24)
    private static DateFormat e(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(u());
        return instanceForSkeleton;
    }

    public static Calendar f(Calendar calendar) {
        Calendar w = w(calendar);
        Calendar v = v();
        v.set(w.get(1), w.get(2), w.get(5));
        return v;
    }

    private static java.text.DateFormat g(int i2, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i2, locale);
        dateInstance.setTimeZone(s());
        return dateInstance;
    }

    public static java.text.DateFormat h() {
        return i(Locale.getDefault());
    }

    public static java.text.DateFormat i(Locale locale) {
        return g(0, locale);
    }

    public static java.text.DateFormat j() {
        return k(Locale.getDefault());
    }

    public static java.text.DateFormat k(Locale locale) {
        return g(2, locale);
    }

    public static java.text.DateFormat l() {
        return m(Locale.getDefault());
    }

    public static java.text.DateFormat m(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) k(locale);
        simpleDateFormat.applyPattern(z(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    public static SimpleDateFormat n(String str) {
        return o(str, Locale.getDefault());
    }

    private static SimpleDateFormat o(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(s());
        return simpleDateFormat;
    }

    public static SimpleDateFormat p() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(s());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    public static String q(Resources resources, SimpleDateFormat simpleDateFormat) {
        String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll(e.j.a.b.c.f.f10128d, resources.getString(R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(R.string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(R.string.mtrl_picker_text_input_year_abbr));
    }

    public static n r() {
        n nVar = b.get();
        return nVar == null ? n.e() : nVar;
    }

    private static TimeZone s() {
        return TimeZone.getTimeZone(a);
    }

    public static Calendar t() {
        Calendar c2 = r().c();
        c2.set(11, 0);
        c2.set(12, 0);
        c2.set(13, 0);
        c2.set(14, 0);
        c2.setTimeZone(s());
        return c2;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone u() {
        return android.icu.util.TimeZone.getTimeZone(a);
    }

    public static Calendar v() {
        return w(null);
    }

    public static Calendar w(@Nullable Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(s());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    @TargetApi(24)
    public static DateFormat x(Locale locale) {
        return e("yMMMd", locale);
    }

    @TargetApi(24)
    public static DateFormat y(Locale locale) {
        return e("yMMMEd", locale);
    }

    @NonNull
    private static String z(@NonNull String str) {
        int b2 = b(str, "yY", 1, 0);
        if (b2 >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int b3 = b(str, "EMd", 1, b2);
        if (b3 < str.length()) {
            str2 = "EMd" + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str.replace(str.substring(b(str, str2, -1, b2) + 1, b3), ExpandableTextView.N).trim();
    }
}
