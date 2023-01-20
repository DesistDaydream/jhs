package h.h2;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import h.k2.v.c0;
import h.p0;
import h.s0;
import java.io.Closeable;
import kotlin.Metadata;

@h.k2.g(name = "CloseableKt")
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001aK\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000b\u0082\u0002\u000f\n\u0006\b\u0011(\n0\u0001\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", ExifInterface.GPS_DIRECTION_TRUE, ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class b {
    @p0
    @s0(version = "1.1")
    public static final void a(@k.e.a.e Closeable closeable, @k.e.a.e Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            h.m.a(th, th2);
        }
    }

    @h.g2.f
    private static final <T extends Closeable, R> R b(T t, h.k2.u.l<? super T, ? extends R> lVar) {
        try {
            R invoke = lVar.invoke(t);
            c0.d(1);
            if (h.g2.l.a(1, 1, 0)) {
                a(t, null);
            } else if (t != null) {
                t.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (h.g2.l.a(1, 1, 0)) {
                    a(t, th);
                } else if (t != null) {
                    try {
                        t.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }
}
