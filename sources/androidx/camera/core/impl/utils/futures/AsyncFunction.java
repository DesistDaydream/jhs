package androidx.camera.core.impl.utils.futures;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import e.j.c.a.a.a;

@FunctionalInterface
@RequiresApi(21)
/* loaded from: classes.dex */
public interface AsyncFunction<I, O> {
    a<O> apply(@Nullable I i2) throws Exception;
}
