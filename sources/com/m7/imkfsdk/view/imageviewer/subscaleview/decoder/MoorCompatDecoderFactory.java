package com.m7.imkfsdk.view.imageviewer.subscaleview.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class MoorCompatDecoderFactory<T> implements IMoorDecoderFactory<T> {
    private final Bitmap.Config bitmapConfig;
    private final Class<? extends T> clazz;

    public MoorCompatDecoderFactory(@NonNull Class<? extends T> cls) {
        this(cls, null);
    }

    @Override // com.m7.imkfsdk.view.imageviewer.subscaleview.decoder.IMoorDecoderFactory
    @NonNull
    public T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return this.bitmapConfig == null ? this.clazz.newInstance() : this.clazz.getConstructor(Bitmap.Config.class).newInstance(this.bitmapConfig);
    }

    public MoorCompatDecoderFactory(@NonNull Class<? extends T> cls, Bitmap.Config config) {
        this.clazz = cls;
        this.bitmapConfig = config;
    }
}
