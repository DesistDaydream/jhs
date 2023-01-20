package d.a.a.o;

import android.os.SystemClock;
import java.util.Date;

/* loaded from: classes.dex */
public final class h implements d {
    private final long a;
    private final long b = SystemClock.elapsedRealtime();

    public h(long j2) {
        this.a = j2;
    }

    @Override // d.a.a.o.d
    public Date a(long j2) {
        return new Date((j2 - this.b) + this.a);
    }
}
