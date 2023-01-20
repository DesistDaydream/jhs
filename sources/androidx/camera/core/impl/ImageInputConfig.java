package androidx.camera.core.impl;

import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface ImageInputConfig extends ReadableConfig {
    public static final Config.Option<Integer> OPTION_INPUT_FORMAT = Config.Option.create("camerax.core.imageInput.inputFormat", Integer.TYPE);

    int getInputFormat();
}
