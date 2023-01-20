package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import e.b.a.p.k.x.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {
    public static final int a = -1;

    /* loaded from: classes.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    int a(@NonNull ByteBuffer byteBuffer, @NonNull b bVar) throws IOException;

    int b(@NonNull InputStream inputStream, @NonNull b bVar) throws IOException;

    @NonNull
    ImageType getType(@NonNull InputStream inputStream) throws IOException;

    @NonNull
    ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException;
}
