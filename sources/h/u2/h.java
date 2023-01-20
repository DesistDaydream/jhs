package h.u2;

import h.s0;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0001\u001a(\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0001\u001a(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0001*\u001e\b\u0007\u0010\t\"\u00020\u00042\u00020\u0004B\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fB\u0002\b\r¨\u0006\u000e"}, d2 = {"convertDurationUnit", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "", "convertDurationUnitOverflow", "DurationUnit", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes4.dex */
public class h {
    @j
    @s0(version = "1.3")
    public static /* synthetic */ void a() {
    }

    @j
    @s0(version = "1.3")
    public static final double b(double d2, @k.e.a.d TimeUnit timeUnit, @k.e.a.d TimeUnit timeUnit2) {
        long convert = timeUnit2.convert(1L, timeUnit);
        return convert > 0 ? d2 * convert : d2 / timeUnit.convert(1L, timeUnit2);
    }

    @j
    @s0(version = "1.5")
    public static final long c(long j2, @k.e.a.d TimeUnit timeUnit, @k.e.a.d TimeUnit timeUnit2) {
        return timeUnit2.convert(j2, timeUnit);
    }

    @j
    @s0(version = "1.5")
    public static final long d(long j2, @k.e.a.d TimeUnit timeUnit, @k.e.a.d TimeUnit timeUnit2) {
        return timeUnit2.convert(j2, timeUnit);
    }
}
