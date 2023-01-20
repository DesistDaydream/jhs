package com.bytedance.msdk.api.v2.ad.draw;

import android.view.View;

/* loaded from: classes.dex */
public interface GMDrawExpressAdListener extends GMDrawAdListener {
    void onRenderFail(View view, String str, int i2);

    void onRenderSuccess(float f2, float f3);
}
