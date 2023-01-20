package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003\"\u001c\u0010\u000b\u001a\u00020\u00068\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u0012\u0004\b\t\u0010\n\"\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\r\"\u0016\u0010\u0011\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0014\u001a\u00020\u00068\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0012\u0010\b\u0012\u0004\b\u0013\u0010\n\"\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\r\"\u0016\u0010\u0017\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010\"\u0016\u0010\u0019\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010\"\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\r*\u001e\b\u0002\u0010\u001e\u001a\u0004\b\u0000\u0010\u001c\"\b\u0012\u0004\u0012\u00028\u00000\u001d2\b\u0012\u0004\u0012\u00028\u00000\u001d¨\u0006\u001f"}, d2 = {"", "timeMillis", e.j.a.b.c.f.f10128d, "(J)J", "timeNanos", "c", "Li/b/w3/i0;", "h", "Li/b/w3/i0;", "getCLOSED_EMPTY$annotations", "()V", "CLOSED_EMPTY", "", ExpandableTextView.P, "SCHEDULE_DISPOSED", "g", "J", "MAX_DELAY_NS", am.av, "getDISPOSED_TASK$annotations", "DISPOSED_TASK", "SCHEDULE_COMPLETED", "f", "MAX_MS", com.huawei.hms.push.e.a, "MS_TO_NS", "b", "SCHEDULE_OK", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/w3/v;", "Queue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class m1 {
    private static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f15766c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f15767d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final long f15768e = 1000000;

    /* renamed from: f  reason: collision with root package name */
    private static final long f15769f = 9223372036854L;

    /* renamed from: g  reason: collision with root package name */
    private static final long f15770g = 4611686018427387903L;
    private static final i.b.w3.i0 a = new i.b.w3.i0("REMOVED_TASK");

    /* renamed from: h  reason: collision with root package name */
    private static final i.b.w3.i0 f15771h = new i.b.w3.i0("CLOSED_EMPTY");

    public static final long c(long j2) {
        return j2 / 1000000;
    }

    public static final long d(long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        if (j2 >= f15769f) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j2;
    }

    private static /* synthetic */ void e() {
    }

    private static /* synthetic */ void f() {
    }
}
