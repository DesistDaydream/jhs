package com.m7.imkfsdk.view.imageviewer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class MoorImageSource {
    public static final String ASSET_SCHEME = "file:///android_asset/";
    public static final String FILE_SCHEME = "file:///";
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    private MoorImageSource(Bitmap bitmap, boolean z) {
        this.bitmap = bitmap;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.cached = z;
    }

    @NonNull
    public static MoorImageSource asset(@NonNull String str) {
        Objects.requireNonNull(str, "Asset name must not be null");
        return uri(ASSET_SCHEME + str);
    }

    @NonNull
    public static MoorImageSource bitmap(@NonNull Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        return new MoorImageSource(bitmap, false);
    }

    @NonNull
    public static MoorImageSource cachedBitmap(@NonNull Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        return new MoorImageSource(bitmap, true);
    }

    @NonNull
    public static MoorImageSource resource(int i2) {
        return new MoorImageSource(i2);
    }

    private void setInvariants() {
        Rect rect = this.sRegion;
        if (rect != null) {
            this.tile = true;
            this.sWidth = rect.width();
            this.sHeight = this.sRegion.height();
        }
    }

    @NonNull
    public static MoorImageSource uri(@NonNull String str) {
        Objects.requireNonNull(str, "Uri must not be null");
        if (!str.contains("://")) {
            if (str.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                str = str.substring(1);
            }
            str = FILE_SCHEME + str;
        }
        return new MoorImageSource(Uri.parse(str));
    }

    @NonNull
    public MoorImageSource dimensions(int i2, int i3) {
        if (this.bitmap == null) {
            this.sWidth = i2;
            this.sHeight = i3;
        }
        setInvariants();
        return this;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Integer getResource() {
        return this.resource;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final Rect getSRegion() {
        return this.sRegion;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final boolean getTile() {
        return this.tile;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean isCached() {
        return this.cached;
    }

    @NonNull
    public MoorImageSource region(Rect rect) {
        this.sRegion = rect;
        setInvariants();
        return this;
    }

    @NonNull
    public MoorImageSource tiling(boolean z) {
        this.tile = z;
        return this;
    }

    @NonNull
    public MoorImageSource tilingDisabled() {
        return tiling(false);
    }

    @NonNull
    public MoorImageSource tilingEnabled() {
        return tiling(true);
    }

    @NonNull
    public static MoorImageSource uri(@NonNull Uri uri) {
        Objects.requireNonNull(uri, "Uri must not be null");
        return new MoorImageSource(uri);
    }

    private MoorImageSource(@NonNull Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith(FILE_SCHEME) && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.bitmap = null;
        this.uri = uri;
        this.resource = null;
        this.tile = true;
    }

    private MoorImageSource(int i2) {
        this.bitmap = null;
        this.uri = null;
        this.resource = Integer.valueOf(i2);
        this.tile = true;
    }
}
