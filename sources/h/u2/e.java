package h.u2;

import h.q0;
import h.s0;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0003ø\u0001\u0000¢\u0006\u0002\u0010&\u001a\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a\u001f\u00101\u001a\u00020\u0007*\u00020\b2\u0006\u00102\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a\u001f\u00101\u001a\u00020\u0007*\u00020\u00052\u0006\u00102\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a \u00107\u001a\u00020\u0007*\u00020\b2\n\u00108\u001a\u000609j\u0002`:H\u0007ø\u0001\u0000¢\u0006\u0002\u0010;\u001a \u00107\u001a\u00020\u0007*\u00020\u00052\n\u00108\u001a\u000609j\u0002`:H\u0007ø\u0001\u0000¢\u0006\u0002\u0010<\u001a \u00107\u001a\u00020\u0007*\u00020\u00012\n\u00108\u001a\u000609j\u0002`:H\u0007ø\u0001\u0000¢\u0006\u0002\u0010=\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"!\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"!\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"!\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"!\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"!\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"!\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"!\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"!\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"!\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(DLjava/util/concurrent/TimeUnit;)J", "(ILjava/util/concurrent/TimeUnit;)J", "(JLjava/util/concurrent/TimeUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class e {
    public static final int a = 1000000;
    public static final long b = 4611686018426999999L;

    /* renamed from: c */
    public static final long f15706c = 4611686018427387903L;

    /* renamed from: d */
    private static final long f15707d = 4611686018426L;

    public static final long A(long j2) {
        return i0(j2, TimeUnit.MICROSECONDS);
    }

    @j
    @h.i(message = "Use Duration.microseconds() function instead.", replaceWith = @q0(expression = "Duration.microseconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void B(double d2) {
    }

    @j
    @h.i(message = "Use Duration.microseconds() function instead.", replaceWith = @q0(expression = "Duration.microseconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void C(int i2) {
    }

    @j
    @h.i(message = "Use Duration.microseconds() function instead.", replaceWith = @q0(expression = "Duration.microseconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void D(long j2) {
    }

    public static final long E(double d2) {
        return g0(d2, TimeUnit.MILLISECONDS);
    }

    public static final long F(int i2) {
        return h0(i2, TimeUnit.MILLISECONDS);
    }

    public static final long G(long j2) {
        return i0(j2, TimeUnit.MILLISECONDS);
    }

    @j
    @h.i(message = "Use Duration.milliseconds() function instead.", replaceWith = @q0(expression = "Duration.milliseconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void H(double d2) {
    }

    @j
    @h.i(message = "Use Duration.milliseconds() function instead.", replaceWith = @q0(expression = "Duration.milliseconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void I(int i2) {
    }

    @j
    @h.i(message = "Use Duration.milliseconds() function instead.", replaceWith = @q0(expression = "Duration.milliseconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void J(long j2) {
    }

    public static final long K(double d2) {
        return g0(d2, TimeUnit.MINUTES);
    }

    public static final long L(int i2) {
        return h0(i2, TimeUnit.MINUTES);
    }

    public static final long M(long j2) {
        return i0(j2, TimeUnit.MINUTES);
    }

    @j
    @h.i(message = "Use Duration.minutes() function instead.", replaceWith = @q0(expression = "Duration.minutes(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void N(double d2) {
    }

    @j
    @h.i(message = "Use Duration.minutes() function instead.", replaceWith = @q0(expression = "Duration.minutes(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void O(int i2) {
    }

    @j
    @h.i(message = "Use Duration.minutes() function instead.", replaceWith = @q0(expression = "Duration.minutes(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void P(long j2) {
    }

    public static final long Q(double d2) {
        return g0(d2, TimeUnit.NANOSECONDS);
    }

    public static final long R(int i2) {
        return h0(i2, TimeUnit.NANOSECONDS);
    }

    public static final long S(long j2) {
        return i0(j2, TimeUnit.NANOSECONDS);
    }

    @j
    @h.i(message = "Use Duration.nanoseconds() function instead.", replaceWith = @q0(expression = "Duration.nanoseconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void T(double d2) {
    }

    @j
    @h.i(message = "Use Duration.nanoseconds() function instead.", replaceWith = @q0(expression = "Duration.nanoseconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void U(int i2) {
    }

    @j
    @h.i(message = "Use Duration.nanoseconds() function instead.", replaceWith = @q0(expression = "Duration.nanoseconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void V(long j2) {
    }

    public static final long W(double d2) {
        return g0(d2, TimeUnit.SECONDS);
    }

    public static final long X(int i2) {
        return h0(i2, TimeUnit.SECONDS);
    }

    public static final long Y(long j2) {
        return i0(j2, TimeUnit.SECONDS);
    }

    @j
    @h.i(message = "Use Duration.seconds() function instead.", replaceWith = @q0(expression = "Duration.seconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void Z(double d2) {
    }

    public static final /* synthetic */ long a(long j2, int i2) {
        return h(j2, i2);
    }

    @j
    @h.i(message = "Use Duration.seconds() function instead.", replaceWith = @q0(expression = "Duration.seconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void a0(int i2) {
    }

    public static final /* synthetic */ long b(long j2) {
        return i(j2);
    }

    @j
    @h.i(message = "Use Duration.seconds() function instead.", replaceWith = @q0(expression = "Duration.seconds(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void b0(long j2) {
    }

    public static final /* synthetic */ long c(long j2) {
        return j(j2);
    }

    public static final long c0(long j2) {
        return j2 * ((long) a);
    }

    public static final /* synthetic */ long d(long j2) {
        return k(j2);
    }

    public static final long d0(long j2) {
        return j2 / ((long) a);
    }

    public static final /* synthetic */ long e(long j2) {
        return l(j2);
    }

    @j
    @h.g2.f
    @s0(version = "1.3")
    private static final long e0(double d2, long j2) {
        return d.r0(j2, d2);
    }

    public static final /* synthetic */ long f(long j2) {
        return c0(j2);
    }

    @j
    @h.g2.f
    @s0(version = "1.3")
    private static final long f0(int i2, long j2) {
        return d.s0(j2, i2);
    }

    public static final /* synthetic */ long g(long j2) {
        return d0(j2);
    }

    @j
    @s0(version = "1.3")
    public static final long g0(double d2, @k.e.a.d TimeUnit timeUnit) {
        double b2 = h.b(d2, timeUnit, TimeUnit.NANOSECONDS);
        if (!Double.isNaN(b2)) {
            long j2 = (long) b2;
            if (-4611686018426999999L <= j2 && b >= j2) {
                return k(j2);
            }
            return j((long) h.b(d2, timeUnit, TimeUnit.MILLISECONDS));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    @j
    public static final long h(long j2, int i2) {
        return d.i((j2 << 1) + i2);
    }

    @j
    @s0(version = "1.3")
    public static final long h0(int i2, @k.e.a.d TimeUnit timeUnit) {
        if (timeUnit.compareTo(TimeUnit.SECONDS) <= 0) {
            return k(h.d(i2, timeUnit, TimeUnit.NANOSECONDS));
        }
        return i0(i2, timeUnit);
    }

    @j
    public static final long i(long j2) {
        return d.i((j2 << 1) + 1);
    }

    @j
    @s0(version = "1.3")
    public static final long i0(long j2, @k.e.a.d TimeUnit timeUnit) {
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        long d2 = h.d(b, timeUnit2, timeUnit);
        if ((-d2) <= j2 && d2 >= j2) {
            return k(h.d(j2, timeUnit, timeUnit2));
        }
        return i(h.o2.q.D(h.c(j2, timeUnit, TimeUnit.MILLISECONDS), -4611686018427387903L, f15706c));
    }

    @j
    public static final long j(long j2) {
        if (-4611686018426L <= j2 && f15707d >= j2) {
            return k(c0(j2));
        }
        return i(h.o2.q.D(j2, -4611686018427387903L, f15706c));
    }

    @j
    public static final long k(long j2) {
        return d.i(j2 << 1);
    }

    @j
    public static final long l(long j2) {
        if (-4611686018426999999L <= j2 && b >= j2) {
            return k(j2);
        }
        return i(d0(j2));
    }

    public static final long m(double d2) {
        return g0(d2, TimeUnit.DAYS);
    }

    public static final long n(int i2) {
        return h0(i2, TimeUnit.DAYS);
    }

    public static final long o(long j2) {
        return i0(j2, TimeUnit.DAYS);
    }

    @j
    @h.i(message = "Use Duration.days() function instead.", replaceWith = @q0(expression = "Duration.days(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void p(double d2) {
    }

    @j
    @h.i(message = "Use Duration.days() function instead.", replaceWith = @q0(expression = "Duration.days(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void q(int i2) {
    }

    @j
    @h.i(message = "Use Duration.days() function instead.", replaceWith = @q0(expression = "Duration.days(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void r(long j2) {
    }

    public static final long s(double d2) {
        return g0(d2, TimeUnit.HOURS);
    }

    public static final long t(int i2) {
        return h0(i2, TimeUnit.HOURS);
    }

    public static final long u(long j2) {
        return i0(j2, TimeUnit.HOURS);
    }

    @j
    @h.i(message = "Use Duration.hours() function instead.", replaceWith = @q0(expression = "Duration.hours(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void v(double d2) {
    }

    @j
    @h.i(message = "Use Duration.hours() function instead.", replaceWith = @q0(expression = "Duration.hours(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void w(int i2) {
    }

    @j
    @h.i(message = "Use Duration.hours() function instead.", replaceWith = @q0(expression = "Duration.hours(this)", imports = {"kotlin.time.Duration"}))
    @s0(version = "1.3")
    public static /* synthetic */ void x(long j2) {
    }

    public static final long y(double d2) {
        return g0(d2, TimeUnit.MICROSECONDS);
    }

    public static final long z(int i2) {
        return h0(i2, TimeUnit.MICROSECONDS);
    }
}
