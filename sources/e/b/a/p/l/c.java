package e.b.a.p.l;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class c implements e.b.a.p.a<ByteBuffer> {
    private static final String a = "ByteBufferEncoder";

    @Override // e.b.a.p.a
    /* renamed from: c */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull e.b.a.p.f fVar) {
        try {
            e.b.a.v.a.e(byteBuffer, file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable(a, 3)) {
                Log.d(a, "Failed to write data", e2);
            }
            return false;
        }
    }
}
