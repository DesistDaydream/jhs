package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import com.bytedance.msdk.adapter.util.Logger;
import e.t.u.b0;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class f {
    public static long a(long j2) {
        Date date = new Date();
        return a((j2 < com.heytap.mcssdk.constant.a.f3315e ? date.getMinutes() <= 30 ? new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 0, 0) : new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 30, 0) : new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 0, 0)).getTime(), j2);
    }

    private static long a(long j2, long j3) {
        Date date = new Date(j3 + j2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.f14658i);
        long time = date.getTime();
        Logger.d("TTMediationSDK_IntervalEffectiveTime", "old time " + j2 + " new time = " + simpleDateFormat.format(date) + " 毫秒 = " + time);
        return time;
    }

    public static String b(long j2) {
        return new SimpleDateFormat(b0.a.f14658i).format(new Date(j2));
    }
}
