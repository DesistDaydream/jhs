package e.b.a.p.m.h;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import e.b.a.p.k.s;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class j implements e.b.a.p.g<InputStream, c> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f9834d = "StreamGifDecoder";
    private final List<ImageHeaderParser> a;
    private final e.b.a.p.g<ByteBuffer, c> b;

    /* renamed from: c  reason: collision with root package name */
    private final e.b.a.p.k.x.b f9835c;

    public j(List<ImageHeaderParser> list, e.b.a.p.g<ByteBuffer, c> gVar, e.b.a.p.k.x.b bVar) {
        this.a = list;
        this.b = gVar;
        this.f9835c = bVar;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (Log.isLoggable(f9834d, 5)) {
                Log.w(f9834d, "Error reading data from stream", e2);
                return null;
            }
            return null;
        }
    }

    @Override // e.b.a.p.g
    /* renamed from: c */
    public s<c> b(@NonNull InputStream inputStream, int i2, int i3, @NonNull e.b.a.p.f fVar) throws IOException {
        byte[] e2 = e(inputStream);
        if (e2 == null) {
            return null;
        }
        return this.b.b(ByteBuffer.wrap(e2), i2, i3, fVar);
    }

    @Override // e.b.a.p.g
    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull e.b.a.p.f fVar) throws IOException {
        return !((Boolean) fVar.a(i.b)).booleanValue() && e.b.a.p.b.getType(this.a, inputStream, this.f9835c) == ImageHeaderParser.ImageType.GIF;
    }
}
