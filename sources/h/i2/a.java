package h.i2;

import androidx.exifinterface.media.ExifInterface;
import com.caverock.androidsvg.SVG;
import com.qiniu.android.collect.ReportItem;
import h.g2.f;
import h.k2.g;
import h.k2.u.l;
import h.k2.v.c0;
import h.m;
import h.p0;
import h.s0;
import k.e.a.e;
import kotlin.Metadata;

@g(name = "AutoCloseableKt")
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001aH\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"closeFinally", "", "Ljava/lang/AutoCloseable;", "cause", "", "use", "R", ExifInterface.GPS_DIRECTION_TRUE, ReportItem.LogTypeBlock, "Lkotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k = 2, mv = {1, 5, 1}, pn = "kotlin")
/* loaded from: classes3.dex */
public final class a {
    @p0
    @s0(version = SVG.f2474i)
    public static final void a(@e AutoCloseable autoCloseable, @e Throwable th) {
        if (autoCloseable == null) {
            return;
        }
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            m.a(th, th2);
        }
    }

    @f
    @s0(version = SVG.f2474i)
    private static final <T extends AutoCloseable, R> R b(T t, l<? super T, ? extends R> lVar) {
        try {
            R invoke = lVar.invoke(t);
            c0.d(1);
            a(t, null);
            c0.c(1);
            return invoke;
        } finally {
        }
    }
}
