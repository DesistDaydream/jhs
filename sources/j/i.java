package j;

import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@h.k2.g(name = "-Platform")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f*\n\u0010\u000e\"\u00020\r2\u00020\r*\n\u0010\u0010\"\u00020\u000f2\u00020\u000f*\n\u0010\u0012\"\u00020\u00112\u00020\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"", "", "c", "([B)Ljava/lang/String;", am.av, "(Ljava/lang/String;)[B", "R", "", "lock", "Lkotlin/Function0;", ReportItem.LogTypeBlock, "b", "(Ljava/lang/Object;Lh/k2/u/a;)Ljava/lang/Object;", "Ljava/lang/ArrayIndexOutOfBoundsException;", "ArrayIndexOutOfBoundsException", "Ljava/io/EOFException;", "EOFException", "Ljava/io/IOException;", "IOException", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class i {
    @k.e.a.d
    public static final byte[] a(@k.e.a.d String str) {
        return str.getBytes(h.t2.d.a);
    }

    public static final <R> R b(@k.e.a.d Object obj, @k.e.a.d h.k2.u.a<? extends R> aVar) {
        R invoke;
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

    @k.e.a.d
    public static final String c(@k.e.a.d byte[] bArr) {
        return new String(bArr, h.t2.d.a);
    }
}
