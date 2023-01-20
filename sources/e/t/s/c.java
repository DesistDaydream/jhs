package e.t.s;

import com.umeng.analytics.pro.am;
import com.vector.receiver.BatteryReceiver;
import com.vector.receiver.ScreenOnOffReceiver;
import com.vector.receiver.TimeTickReceiver;
import com.vector.receiver.TimeTickUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/vector/receiver/LiveReceiver;", "", "()V", am.Z, "Lcom/vector/receiver/BatteryReceiver;", "screenOnOff", "Lcom/vector/receiver/ScreenOnOffReceiver;", "timeTick", "Lcom/vector/receiver/TimeTickReceiver;", "unit", "Lcom/vector/receiver/TimeTickUnit;", "count", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    @k.e.a.d
    public static final c a = new c();

    private c() {
    }

    public static /* synthetic */ TimeTickReceiver d(c cVar, TimeTickUnit timeTickUnit, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            timeTickUnit = TimeTickUnit.MINUTE;
        }
        if ((i2 & 2) != 0) {
            j2 = 1;
        }
        return cVar.c(timeTickUnit, j2);
    }

    @k.e.a.d
    public final BatteryReceiver a() {
        return new BatteryReceiver();
    }

    @k.e.a.d
    public final ScreenOnOffReceiver b() {
        return new ScreenOnOffReceiver();
    }

    @k.e.a.d
    public final TimeTickReceiver c(@k.e.a.d TimeTickUnit timeTickUnit, long j2) {
        return new TimeTickReceiver(timeTickUnit, j2);
    }
}
