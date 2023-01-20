package h.c2;

import com.moor.imkf.YKFConstants;
import h.g2.f;
import h.k2.g;
import h.k2.u.l;
import h.p0;
import h.t1;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@g(name = "TimersKt")
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aM\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001aO\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a\u001a\u0010\u0010\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001aM\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001aO\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a'\u0010\u0011\u001a\u00020\f2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"fixedRateTimer", "Ljava/util/Timer;", "name", "", "daemon", "", "startAt", "Ljava/util/Date;", "period", "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", YKFConstants.TYPE_SCHEDULE, "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class c {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a extends TimerTask {
        public final /* synthetic */ l a;

        public a(l lVar) {
            this.a = lVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.a.invoke(this);
        }
    }

    @f
    private static final Timer a(String str, boolean z, long j2, long j3, l<? super TimerTask, t1> lVar) {
        Timer k2 = k(str, z);
        k2.scheduleAtFixedRate(new a(lVar), j2, j3);
        return k2;
    }

    @f
    private static final Timer b(String str, boolean z, Date date, long j2, l<? super TimerTask, t1> lVar) {
        Timer k2 = k(str, z);
        k2.scheduleAtFixedRate(new a(lVar), date, j2);
        return k2;
    }

    public static /* synthetic */ Timer c(String str, boolean z, long j2, long j3, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        Timer k2 = k(str, z);
        k2.scheduleAtFixedRate(new a(lVar), j2, j3);
        return k2;
    }

    public static /* synthetic */ Timer d(String str, boolean z, Date date, long j2, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        Timer k2 = k(str, z);
        k2.scheduleAtFixedRate(new a(lVar), date, j2);
        return k2;
    }

    @f
    private static final TimerTask e(Timer timer, long j2, long j3, l<? super TimerTask, t1> lVar) {
        a aVar = new a(lVar);
        timer.schedule(aVar, j2, j3);
        return aVar;
    }

    @f
    private static final TimerTask f(Timer timer, long j2, l<? super TimerTask, t1> lVar) {
        a aVar = new a(lVar);
        timer.schedule(aVar, j2);
        return aVar;
    }

    @f
    private static final TimerTask g(Timer timer, Date date, long j2, l<? super TimerTask, t1> lVar) {
        a aVar = new a(lVar);
        timer.schedule(aVar, date, j2);
        return aVar;
    }

    @f
    private static final TimerTask h(Timer timer, Date date, l<? super TimerTask, t1> lVar) {
        a aVar = new a(lVar);
        timer.schedule(aVar, date);
        return aVar;
    }

    @f
    private static final TimerTask i(Timer timer, long j2, long j3, l<? super TimerTask, t1> lVar) {
        a aVar = new a(lVar);
        timer.scheduleAtFixedRate(aVar, j2, j3);
        return aVar;
    }

    @f
    private static final TimerTask j(Timer timer, Date date, long j2, l<? super TimerTask, t1> lVar) {
        a aVar = new a(lVar);
        timer.scheduleAtFixedRate(aVar, date, j2);
        return aVar;
    }

    @p0
    @d
    public static final Timer k(@e String str, boolean z) {
        return str == null ? new Timer(z) : new Timer(str, z);
    }

    @f
    private static final Timer l(String str, boolean z, long j2, long j3, l<? super TimerTask, t1> lVar) {
        Timer k2 = k(str, z);
        k2.schedule(new a(lVar), j2, j3);
        return k2;
    }

    @f
    private static final Timer m(String str, boolean z, Date date, long j2, l<? super TimerTask, t1> lVar) {
        Timer k2 = k(str, z);
        k2.schedule(new a(lVar), date, j2);
        return k2;
    }

    public static /* synthetic */ Timer n(String str, boolean z, long j2, long j3, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        Timer k2 = k(str, z);
        k2.schedule(new a(lVar), j2, j3);
        return k2;
    }

    public static /* synthetic */ Timer o(String str, boolean z, Date date, long j2, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        Timer k2 = k(str, z);
        k2.schedule(new a(lVar), date, j2);
        return k2;
    }

    @f
    private static final TimerTask p(l<? super TimerTask, t1> lVar) {
        return new a(lVar);
    }
}
