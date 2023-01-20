package e.t.w;

import android.os.Handler;
import android.os.Message;
import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.k2.u.l;
import h.t1;
import java.lang.ref.WeakReference;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/vector/weak/WeakHandler;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Handler;", am.aI, ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Landroid/os/Message;", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "ref", "Ljava/lang/ref/WeakReference;", "handleMessage", "msg", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a<T> extends Handler {
    @d
    private final l<Message, t1> a;
    @d
    private final WeakReference<T> b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(T t, @d l<? super Message, t1> lVar) {
        this.a = lVar;
        this.b = new WeakReference<>(t);
    }

    @Override // android.os.Handler
    public void handleMessage(@d Message message) {
        if (this.b.get() != null) {
            this.a.invoke(message);
        }
    }
}
