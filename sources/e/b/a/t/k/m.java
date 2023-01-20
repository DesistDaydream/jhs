package e.b.a.t.k;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class m<Z> extends e<Z> {
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final Handler f9920c = new Handler(Looper.getMainLooper(), new a());
    private final e.b.a.j a;

    /* loaded from: classes.dex */
    public class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((m) message.obj).a();
                return true;
            }
            return false;
        }
    }

    private m(e.b.a.j jVar, int i2, int i3) {
        super(i2, i3);
        this.a = jVar;
    }

    public static <Z> m<Z> b(e.b.a.j jVar, int i2, int i3) {
        return new m<>(jVar, i2, i3);
    }

    public void a() {
        this.a.r(this);
    }

    @Override // e.b.a.t.k.p
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // e.b.a.t.k.p
    public void onResourceReady(@NonNull Z z, @Nullable e.b.a.t.l.f<? super Z> fVar) {
        f9920c.obtainMessage(1, this).sendToTarget();
    }
}
