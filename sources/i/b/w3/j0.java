package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import i.b.x1;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007*\u0010\b\u0007\u0010\t\"\u00020\u00012\u00020\u0001B\u0002\b\b¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "lock", "Lkotlin/Function0;", ReportItem.LogTypeBlock, "b", "(Ljava/lang/Object;Lh/k2/u/a;)Ljava/lang/Object;", "Li/b/x1;", "SynchronizedObject", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class j0 {
    @x1
    public static /* synthetic */ void a() {
    }

    @x1
    public static final <T> T b(@k.e.a.d Object obj, @k.e.a.d h.k2.u.a<? extends T> aVar) {
        T invoke;
        synchronized (obj) {
            try {
                invoke = aVar.invoke();
                h.k2.v.c0.d(1);
            } catch (Throwable th) {
                h.k2.v.c0.d(1);
                h.k2.v.c0.c(1);
                throw th;
            }
        }
        h.k2.v.c0.c(1);
        return invoke;
    }
}
