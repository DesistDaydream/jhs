package j;

import com.umeng.analytics.pro.am;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lj/l0;", "Lj/k;", "Ljava/io/IOException;", "cause", "newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "Lh/t1;", "timedOut", "()V", "Ljava/net/Socket;", am.av, "Ljava/net/Socket;", "socket", "<init>", "(Ljava/net/Socket;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class l0 extends k {
    private final Socket a;

    public l0(@k.e.a.d Socket socket) {
        this.a = socket;
    }

    @Override // j.k
    @k.e.a.d
    public IOException newTimeoutException(@k.e.a.e IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // j.k
    public void timedOut() {
        Logger logger;
        Logger logger2;
        try {
            this.a.close();
        } catch (AssertionError e2) {
            if (z.e(e2)) {
                logger2 = a0.a;
                Level level = Level.WARNING;
                logger2.log(level, "Failed to close timed out socket " + this.a, (Throwable) e2);
                return;
            }
            throw e2;
        } catch (Exception e3) {
            logger = a0.a;
            Level level2 = Level.WARNING;
            logger.log(level2, "Failed to close timed out socket " + this.a, (Throwable) e3);
        }
    }
}
