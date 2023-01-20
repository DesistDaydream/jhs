package e.l.h.k;

import android.util.Log;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.e;
import e.j.a.b.c.f;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/jihuanshe/base/utils/Log;", "", "()V", "isDebug", "", "()Z", "setDebug", "(Z)V", f.f10128d, "", RemoteMessageConst.Notification.TAG, "", "msg", e.a, "", "i", IAdInterListener.AdReqParam.WIDTH, "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class b {
    @d
    public static final b a = new b();
    private static boolean b;

    private b() {
    }

    public final void a(@d String str, @d String str2) {
        if (b) {
            Log.d(str, str2);
        }
    }

    public final void b(@d String str, @d String str2) {
        if (b) {
            Log.e(str, str2);
        }
    }

    public final void c(@d String str, @d String str2, @d Throwable th) {
        if (b) {
            Log.e(str, str2, th);
        }
    }

    public final void d(@d String str, @d String str2) {
        if (b) {
            Log.i(str, str2);
        }
    }

    public final boolean e() {
        return b;
    }

    public final void f(boolean z) {
        b = z;
    }

    public final void g(@d String str, @d String str2) {
        if (b) {
            Log.w(str, str2);
        }
    }
}
