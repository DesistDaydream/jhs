package com.m7.imkfsdk.view.imageviewer.subscaleview.decoder;

import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public interface IMoorDecoderFactory<T> {
    @NonNull
    T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
