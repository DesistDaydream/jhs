package d.a.a.o;

import android.os.SystemClock;
import cn.thinkingdata.android.utils.TDLog;
import java.util.Date;

/* loaded from: classes.dex */
public class i implements d {
    private long a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f9303c;

    /* renamed from: d  reason: collision with root package name */
    private final Thread f9304d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final j a = new j();

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            for (String str : i.this.f9303c) {
                if (this.a.d(str, 3000)) {
                    TDLog.i("ThinkingAnalytics.NTP", "NTP offset from " + str + " is: " + this.a.a());
                    i.this.a = System.currentTimeMillis() + this.a.a();
                    i.this.b = SystemClock.elapsedRealtime();
                    return;
                }
            }
        }
    }

    public i(String... strArr) {
        Thread thread = new Thread(new a());
        this.f9304d = thread;
        this.f9303c = strArr;
        thread.start();
    }

    @Override // d.a.a.o.d
    public Date a(long j2) {
        try {
            this.f9304d.join(3000L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.b == 0 ? new Date((System.currentTimeMillis() - SystemClock.elapsedRealtime()) + j2) : new Date((j2 - this.b) + this.a);
    }
}
