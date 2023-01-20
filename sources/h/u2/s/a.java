package h.u2.s;

import h.g2.f;
import h.k2.g;
import h.s0;
import h.u2.d;
import h.u2.j;
import java.time.Duration;
import kotlin.Metadata;

@g(name = "DurationConversionsJDK8Kt")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, d2 = {"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)J", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 5, 1}, pn = "kotlin.time")
/* loaded from: classes4.dex */
public final class a {
    @j
    @f
    @s0(version = "1.3")
    private static final Duration a(long j2) {
        return Duration.ofSeconds(d.X(j2), d.b0(j2));
    }

    @j
    @f
    @s0(version = "1.3")
    private static final long b(Duration duration) {
        d.a aVar = d.f15705e;
        return d.p0(aVar.y(duration.getSeconds()), aVar.u(duration.getNano()));
    }
}
