package e.j.a.b.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class b implements ServiceConnection {
    private boolean a = false;
    private final BlockingQueue<IBinder> b = new LinkedBlockingQueue();

    @e.j.a.b.c.m.a
    public IBinder a() throws InterruptedException {
        e.j.a.b.c.r.a0.j("BlockingServiceConnection.getService() called on main thread");
        if (!this.a) {
            this.a = true;
            return this.b.take();
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @e.j.a.b.c.m.a
    public IBinder b(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        e.j.a.b.c.r.a0.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.a) {
            this.a = true;
            IBinder poll = this.b.poll(j2, timeUnit);
            if (poll != null) {
                return poll;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
