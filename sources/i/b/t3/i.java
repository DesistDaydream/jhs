package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import i.b.r1;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@r1
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Li/b/t3/i;", ExifInterface.LONGITUDE_EAST, "Li/b/t3/c0;", "Li/b/t3/y;", "v", "()Li/b/t3/y;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lh/t1;", "b", "(Ljava/util/concurrent/CancellationException;)V", "", "", am.av, "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface i<E> extends c0<E> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ void a(i iVar, CancellationException cancellationException, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    cancellationException = null;
                }
                iVar.b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ boolean b(i iVar, Throwable th, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    th = null;
                }
                return iVar.a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }

    @h.i(level = DeprecationLevel.HIDDEN, message = "Binary compatibility only")
    /* synthetic */ boolean a(@k.e.a.e Throwable th);

    void b(@k.e.a.e CancellationException cancellationException);

    @k.e.a.d
    y<E> v();
}
