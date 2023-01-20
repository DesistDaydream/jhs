package e.t.t;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rJ*\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0012J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rJ\u0018\u0010\u0013\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0014\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/vector/stats/Stats;", "", "()V", "debugMode", "", "statsTool", "Lcom/vector/stats/StatsTool;", "init", "", "onActivityPause", "context", "Landroid/content/Context;", RemoteMessageConst.Notification.TAG, "", "onActivityResume", "onEvent", com.heytap.mcssdk.constant.b.f3343k, "map", "Ljava/util/HashMap;", "onFragmentInvisible", "onFragmentVisible", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    @d
    public static final a a = new a();
    private static boolean b;
    @e

    /* renamed from: c  reason: collision with root package name */
    private static b f14643c;

    private a() {
    }

    public final void a(@d b bVar, boolean z) {
        b = z;
        f14643c = bVar;
    }

    public final void b(@d Context context, @d String str) {
        b bVar;
        if (b || (bVar = f14643c) == null) {
            return;
        }
        bVar.b(context, str);
    }

    public final void c(@d Context context, @d String str) {
        b bVar;
        if (b || (bVar = f14643c) == null) {
            return;
        }
        bVar.d(context, str);
    }

    public final void d(@d Context context, @d String str) {
        b bVar;
        if (b || (bVar = f14643c) == null) {
            return;
        }
        bVar.e(context, str);
    }

    public final void e(@d Context context, @d String str, @d HashMap<String, String> hashMap) {
        b bVar;
        if (b || (bVar = f14643c) == null) {
            return;
        }
        bVar.f(context, str, hashMap);
    }

    public final void f(@d String str) {
        b bVar;
        if (b || (bVar = f14643c) == null) {
            return;
        }
        bVar.g(str);
    }

    public final void g(@e Context context, @d String str) {
        b bVar = f14643c;
        if (bVar == null) {
            return;
        }
        bVar.a(context, str);
    }

    public final void h(@e Context context, @d String str) {
        b bVar;
        if (b || context == null || (bVar = f14643c) == null) {
            return;
        }
        bVar.c(context, str);
    }
}
