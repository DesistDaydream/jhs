package i.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\r"}, d2 = {"Li/b/s2;", "Ljava/lang/Thread;", "Li/b/i3;", am.av, "Li/b/i3;", "dispatcher", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", TypedValues.Attributes.S_TARGET, "", "name", "<init>", "(Li/b/i3;Ljava/lang/Runnable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class s2 extends Thread {
    @h.k2.d
    @k.e.a.d
    public final i3 a;

    public s2(@k.e.a.d i3 i3Var, @k.e.a.d Runnable runnable, @k.e.a.d String str) {
        super(runnable, str);
        this.a = i3Var;
        setDaemon(true);
    }
}
