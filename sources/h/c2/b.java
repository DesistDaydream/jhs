package h.c2;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import h.g2.f;
import h.k2.g;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@g(name = "ThreadsKt")
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a3\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"thread", "Ljava/lang/Thread;", MessageKey.MSG_ACCEPT_TIME_START, "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", RemoteMessageConst.Notification.PRIORITY, "", ReportItem.LogTypeBlock, "Lkotlin/Function0;", "", "getOrSet", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class b {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/ThreadsKt$thread$thread$1", "Ljava/lang/Thread;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a extends Thread {
        public final /* synthetic */ h.k2.u.a a;

        public a(h.k2.u.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.a.invoke();
        }
    }

    @f
    private static final <T> T a(ThreadLocal<T> threadLocal, h.k2.u.a<? extends T> aVar) {
        T t = threadLocal.get();
        if (t != null) {
            return t;
        }
        T invoke = aVar.invoke();
        threadLocal.set(invoke);
        return invoke;
    }

    @d
    public static final Thread b(boolean z, boolean z2, @e ClassLoader classLoader, @e String str, int i2, @d h.k2.u.a<t1> aVar) {
        a aVar2 = new a(aVar);
        if (z2) {
            aVar2.setDaemon(true);
        }
        if (i2 > 0) {
            aVar2.setPriority(i2);
        }
        if (str != null) {
            aVar2.setName(str);
        }
        if (classLoader != null) {
            aVar2.setContextClassLoader(classLoader);
        }
        if (z) {
            aVar2.start();
        }
        return aVar2;
    }
}
