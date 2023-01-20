package h.u2;

import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import h.s0;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0001¨\u0006\u0004"}, d2 = {"shortName", "", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes4.dex */
public class i extends h {
    @j
    @s0(version = "1.3")
    @k.e.a.d
    public static final String e(@k.e.a.d TimeUnit timeUnit) {
        switch (f.a[timeUnit.ordinal()]) {
            case 1:
                return NotificationStyle.NOTIFICATION_STYLE;
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "m";
            case 6:
                return "h";
            case 7:
                return e.j.a.b.c.f.f10128d;
            default:
                throw new IllegalStateException(("Unknown unit: " + timeUnit).toString());
        }
    }
}
