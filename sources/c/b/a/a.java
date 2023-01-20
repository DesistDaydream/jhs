package c.b.a;

import android.content.Context;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.impl.UseCaseConfigFactory;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements UseCaseConfigFactory.Provider {
    public static final /* synthetic */ a a = new a();

    @Override // androidx.camera.core.impl.UseCaseConfigFactory.Provider
    public final UseCaseConfigFactory newInstance(Context context) {
        return Camera2Config.b(context);
    }
}
