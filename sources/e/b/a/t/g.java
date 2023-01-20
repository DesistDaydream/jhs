package e.b.a.t;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import e.b.a.t.k.p;

/* loaded from: classes.dex */
public interface g<R> {
    boolean onLoadFailed(@Nullable GlideException glideException, Object obj, p<R> pVar, boolean z);

    boolean onResourceReady(R r, Object obj, p<R> pVar, DataSource dataSource, boolean z);
}
