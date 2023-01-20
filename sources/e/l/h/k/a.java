package e.l.h.k;

import com.ss.android.download.api.constant.BaseConstants;
import java.util.Calendar;
import java.util.Date;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/jihuanshe/base/utils/DateUtils;", "", "()V", "TODAY", "", "WEEK", "YESTERDAY", "diffDay", "", "time1", "time2", "isToday", "", "time", "isWeekAround", "isYesterday", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class a {
    @d
    public static final a a = new a();
    private static final int b = -7;

    /* renamed from: c  reason: collision with root package name */
    private static final int f12147c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f12148d = 0;

    private a() {
    }

    public final long a(long j2, long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(j3));
        return Math.abs((calendar2.getTime().getTime() - calendar.getTime().getTime()) / ((long) BaseConstants.Time.DAY));
    }

    public final boolean b(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(System.currentTimeMillis()));
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) - calendar2.get(6) == 0;
    }

    public final boolean c(long j2) {
        return a(j2, System.currentTimeMillis()) < 7;
    }

    public final boolean d(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(System.currentTimeMillis()));
        return calendar.get(1) == calendar2.get(1) ? calendar.get(6) - calendar2.get(6) == -1 : a(j2, System.currentTimeMillis()) == 1;
    }
}
