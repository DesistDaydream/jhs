package e.t.l;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import h.k2.v.c0;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a=\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0004*\u0002H\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00040\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"safeClose", "", "Ljava/io/Closeable;", "safeUse", "R", ExifInterface.GPS_DIRECTION_TRUE, ReportItem.LogTypeBlock, "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class i {
    public static final void a(@k.e.a.e Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @k.e.a.e
    public static final <T extends Closeable, R> R b(T t, @k.e.a.d h.k2.u.l<? super T, ? extends R> lVar) {
        try {
            R invoke = lVar.invoke(t);
            c0.d(1);
            h.h2.b.a(t, null);
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
            return null;
        }
    }
}
