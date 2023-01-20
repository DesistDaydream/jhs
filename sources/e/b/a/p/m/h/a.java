package e.b.a.p.m.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import e.b.a.n.a;
import e.b.a.v.n;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class a implements e.b.a.p.g<ByteBuffer, c> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f9802f = "BufferGifDecoder";

    /* renamed from: g  reason: collision with root package name */
    private static final C0322a f9803g = new C0322a();

    /* renamed from: h  reason: collision with root package name */
    private static final b f9804h = new b();
    private final Context a;
    private final List<ImageHeaderParser> b;

    /* renamed from: c  reason: collision with root package name */
    private final b f9805c;

    /* renamed from: d  reason: collision with root package name */
    private final C0322a f9806d;

    /* renamed from: e  reason: collision with root package name */
    private final e.b.a.p.m.h.b f9807e;

    @VisibleForTesting
    /* renamed from: e.b.a.p.m.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0322a {
        public e.b.a.n.a a(a.InterfaceC0304a interfaceC0304a, e.b.a.n.c cVar, ByteBuffer byteBuffer, int i2) {
            return new e.b.a.n.f(interfaceC0304a, cVar, byteBuffer, i2);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b {
        private final Queue<e.b.a.n.d> a = n.f(0);

        public synchronized e.b.a.n.d a(ByteBuffer byteBuffer) {
            e.b.a.n.d poll;
            poll = this.a.poll();
            if (poll == null) {
                poll = new e.b.a.n.d();
            }
            return poll.q(byteBuffer);
        }

        public synchronized void b(e.b.a.n.d dVar) {
            dVar.a();
            this.a.offer(dVar);
        }
    }

    public a(Context context) {
        this(context, e.b.a.c.e(context).m().g(), e.b.a.c.e(context).h(), e.b.a.c.e(context).g());
    }

    @Nullable
    private e c(ByteBuffer byteBuffer, int i2, int i3, e.b.a.n.d dVar, e.b.a.p.f fVar) {
        Bitmap.Config config;
        long b2 = e.b.a.v.h.b();
        try {
            e.b.a.n.c d2 = dVar.d();
            if (d2.b() > 0 && d2.c() == 0) {
                if (fVar.a(i.a) == DecodeFormat.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                e.b.a.n.a a = this.f9806d.a(this.f9807e, d2, byteBuffer, e(d2, i2, i3));
                a.d(config);
                a.b();
                Bitmap a2 = a.a();
                if (a2 == null) {
                    return null;
                }
                e eVar = new e(new c(this.a, a, e.b.a.p.m.c.a(), i2, i3, a2));
                if (Log.isLoggable(f9802f, 2)) {
                    Log.v(f9802f, "Decoded GIF from stream in " + e.b.a.v.h.a(b2));
                }
                return eVar;
            }
            if (Log.isLoggable(f9802f, 2)) {
                Log.v(f9802f, "Decoded GIF from stream in " + e.b.a.v.h.a(b2));
            }
            return null;
        } finally {
            if (Log.isLoggable(f9802f, 2)) {
                Log.v(f9802f, "Decoded GIF from stream in " + e.b.a.v.h.a(b2));
            }
        }
    }

    private static int e(e.b.a.n.c cVar, int i2, int i3) {
        int min = Math.min(cVar.a() / i3, cVar.d() / i2);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable(f9802f, 2) && max > 1) {
            Log.v(f9802f, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return max;
    }

    @Override // e.b.a.p.g
    /* renamed from: d */
    public e b(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        e.b.a.n.d a = this.f9805c.a(byteBuffer);
        try {
            return c(byteBuffer, i2, i3, a, fVar);
        } finally {
            this.f9805c.b(a);
        }
    }

    @Override // e.b.a.p.g
    /* renamed from: f */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull e.b.a.p.f fVar) throws IOException {
        return !((Boolean) fVar.a(i.b)).booleanValue() && e.b.a.p.b.getType(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public a(Context context, List<ImageHeaderParser> list, e.b.a.p.k.x.e eVar, e.b.a.p.k.x.b bVar) {
        this(context, list, eVar, bVar, f9804h, f9803g);
    }

    @VisibleForTesting
    public a(Context context, List<ImageHeaderParser> list, e.b.a.p.k.x.e eVar, e.b.a.p.k.x.b bVar, b bVar2, C0322a c0322a) {
        this.a = context.getApplicationContext();
        this.b = list;
        this.f9806d = c0322a;
        this.f9807e = new e.b.a.p.m.h.b(eVar, bVar);
        this.f9805c = bVar2;
    }
}
