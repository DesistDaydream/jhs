package androidx.camera.view.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.VideoCapture;
import androidx.camera.view.video.AutoValue_OutputFileOptions;
import androidx.core.util.Preconditions;
import e.j.b.a.c;
import java.io.File;

@c
@ExperimentalVideo
@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class OutputFileOptions {
    private static final Metadata EMPTY_METADATA = Metadata.builder().build();

    @c.a
    /* loaded from: classes.dex */
    public static abstract class Builder {
        @NonNull
        public abstract OutputFileOptions build();

        public abstract Builder setContentResolver(@Nullable ContentResolver contentResolver);

        public abstract Builder setContentValues(@Nullable ContentValues contentValues);

        public abstract Builder setFile(@Nullable File file);

        public abstract Builder setFileDescriptor(@Nullable ParcelFileDescriptor parcelFileDescriptor);

        @NonNull
        public abstract Builder setMetadata(@NonNull Metadata metadata);

        public abstract Builder setSaveCollection(@Nullable Uri uri);
    }

    @NonNull
    public static Builder builder(@NonNull File file) {
        return new AutoValue_OutputFileOptions.Builder().setMetadata(EMPTY_METADATA).setFile(file);
    }

    private boolean isSavingToFile() {
        return getFile() != null;
    }

    private boolean isSavingToFileDescriptor() {
        return getFileDescriptor() != null;
    }

    private boolean isSavingToMediaStore() {
        return (getSaveCollection() == null || getContentResolver() == null || getContentValues() == null) ? false : true;
    }

    @Nullable
    public abstract ContentResolver getContentResolver();

    @Nullable
    public abstract ContentValues getContentValues();

    @Nullable
    public abstract File getFile();

    @Nullable
    public abstract ParcelFileDescriptor getFileDescriptor();

    @NonNull
    public abstract Metadata getMetadata();

    @Nullable
    public abstract Uri getSaveCollection();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public VideoCapture.OutputFileOptions toVideoCaptureOutputFileOptions() {
        VideoCapture.OutputFileOptions.Builder builder;
        if (isSavingToFile()) {
            builder = new VideoCapture.OutputFileOptions.Builder((File) Preconditions.checkNotNull(getFile()));
        } else if (isSavingToFileDescriptor()) {
            builder = new VideoCapture.OutputFileOptions.Builder(((ParcelFileDescriptor) Preconditions.checkNotNull(getFileDescriptor())).getFileDescriptor());
        } else {
            Preconditions.checkState(isSavingToMediaStore());
            builder = new VideoCapture.OutputFileOptions.Builder((ContentResolver) Preconditions.checkNotNull(getContentResolver()), (Uri) Preconditions.checkNotNull(getSaveCollection()), (ContentValues) Preconditions.checkNotNull(getContentValues()));
        }
        VideoCapture.Metadata metadata = new VideoCapture.Metadata();
        metadata.location = getMetadata().getLocation();
        builder.setMetadata(metadata);
        return builder.build();
    }

    @NonNull
    public static Builder builder(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        Preconditions.checkArgument(Build.VERSION.SDK_INT >= 26, "Using a ParcelFileDescriptor to record a video is only supported for Android 8.0 or above.");
        return new AutoValue_OutputFileOptions.Builder().setMetadata(EMPTY_METADATA).setFileDescriptor(parcelFileDescriptor);
    }

    @NonNull
    public static Builder builder(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull ContentValues contentValues) {
        return new AutoValue_OutputFileOptions.Builder().setMetadata(EMPTY_METADATA).setContentResolver(contentResolver).setSaveCollection(uri).setContentValues(contentValues);
    }
}
