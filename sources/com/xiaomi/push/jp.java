package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* loaded from: classes3.dex */
public final class jp extends jo {
    public final /* synthetic */ Runnable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jp(Context context, File file, Runnable runnable) {
        super(context, file, null);
        this.a = runnable;
    }

    @Override // com.xiaomi.push.jo
    public void a(Context context) {
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
