package d.a.a.o;

import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class l implements e {
    private final long a = SystemClock.elapsedRealtime();
    private final TimeZone b;

    /* renamed from: c  reason: collision with root package name */
    private final d f9306c;

    /* renamed from: d  reason: collision with root package name */
    private Date f9307d;

    public l(d dVar, TimeZone timeZone) {
        this.f9306c = dVar;
        this.b = timeZone;
    }

    private synchronized Date c() {
        if (this.f9307d == null) {
            this.f9307d = this.f9306c.a(this.a);
        }
        return this.f9307d;
    }

    @Override // d.a.a.o.e
    public Double a() {
        return Double.valueOf(n.b(c().getTime(), this.b));
    }

    @Override // d.a.a.o.e
    public String b() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
            simpleDateFormat.setTimeZone(this.b);
            return simpleDateFormat.format(c());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
