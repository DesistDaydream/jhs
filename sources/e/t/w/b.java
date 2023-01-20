package e.t.w;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.t1;
import java.lang.ref.WeakReference;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vector/weak/WeakThread;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Thread;", am.aI, ReportItem.LogTypeBlock, "Lkotlin/Function0;", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "ref", "Ljava/lang/ref/WeakReference;", "run", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b<T> extends Thread {
    @d
    private final h.k2.u.a<t1> a;
    @d
    private final WeakReference<T> b;

    public b(T t, @d h.k2.u.a<t1> aVar) {
        this.a = aVar;
        this.b = new WeakReference<>(t);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.b.get() != null) {
            this.a.invoke();
        }
    }
}
