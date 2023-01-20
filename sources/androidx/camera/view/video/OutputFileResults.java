package androidx.camera.view.video;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import e.j.b.a.c;

@c
@ExperimentalVideo
@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class OutputFileResults {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static OutputFileResults create(@Nullable Uri uri) {
        return new AutoValue_OutputFileResults(uri);
    }

    @Nullable
    public abstract Uri getSavedUri();
}
