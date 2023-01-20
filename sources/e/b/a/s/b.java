package e.b.a.s;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class b {
    private final List<ImageHeaderParser> a = new ArrayList();

    public synchronized void a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.a.add(imageHeaderParser);
    }

    @NonNull
    public synchronized List<ImageHeaderParser> b() {
        return this.a;
    }
}
