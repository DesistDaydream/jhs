package e.b.a.p.l;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class t implements e.b.a.p.a<InputStream> {
    private static final String b = "StreamEncoder";
    private final e.b.a.p.k.x.b a;

    public t(e.b.a.p.k.x.b bVar) {
        this.a = bVar;
    }

    @Override // e.b.a.p.a
    /* renamed from: c */
    public boolean a(@NonNull InputStream inputStream, @NonNull File file, @NonNull e.b.a.p.f fVar) {
        byte[] bArr = (byte[]) this.a.c(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            if (Log.isLoggable(b, 3)) {
                                Log.d(b, "Failed to encode data onto the OutputStream", e);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            this.a.e(bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            this.a.e(bArr);
                            throw th;
                        }
                    }
                    fileOutputStream2.close();
                    z = true;
                    fileOutputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException unused2) {
        }
        this.a.e(bArr);
        return z;
    }
}
