package d.a.a.o;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class k implements e {
    private final TimeZone a;
    private final Date b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9305c = true;

    public k(Date date, TimeZone timeZone) {
        this.b = date == null ? new Date() : date;
        this.a = timeZone;
    }

    @Override // d.a.a.o.e
    public Double a() {
        if (!this.f9305c || this.a == null) {
            return null;
        }
        return Double.valueOf(n.b(this.b.getTime(), this.a));
    }

    @Override // d.a.a.o.e
    public String b() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
            TimeZone timeZone = this.a;
            if (timeZone != null) {
                simpleDateFormat.setTimeZone(timeZone);
            }
            return simpleDateFormat.format(this.b);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void c() {
        this.f9305c = false;
    }
}
