package e.j.a.c.m;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    private static final n f10918c = new n(null, null);
    @Nullable
    private final Long a;
    @Nullable
    private final TimeZone b;

    private n(@Nullable Long l2, @Nullable TimeZone timeZone) {
        this.a = l2;
        this.b = timeZone;
    }

    public static n a(long j2) {
        return new n(Long.valueOf(j2), null);
    }

    public static n b(long j2, @Nullable TimeZone timeZone) {
        return new n(Long.valueOf(j2), timeZone);
    }

    public static n e() {
        return f10918c;
    }

    public Calendar c() {
        return d(this.b);
    }

    public Calendar d(@Nullable TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l2 = this.a;
        if (l2 != null) {
            calendar.setTimeInMillis(l2.longValue());
        }
        return calendar;
    }
}
