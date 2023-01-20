package com.bytedance.msdk.api.v2.ad.custom.draw;

import android.view.View;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;

/* loaded from: classes.dex */
public interface IGMCustomDrawEvent {
    void callDrawAdClick();

    void callDrawAdShow();

    void callDrawDislikeCancel();

    void callDrawDislikeRefuse();

    void callDrawDislikeSelected(int i2, String str);

    void callDrawDislikeShow();

    void callDrawRenderFail(View view, String str, int i2);

    void callDrawRenderSuccess(float f2, float f3);

    void callDrawVideoCompleted();

    void callDrawVideoError(GMCustomAdError gMCustomAdError);

    void callDrawVideoPause();

    void callDrawVideoProgressUpdate(long j2, long j3);

    void callDrawVideoResume();

    void callDrawVideoStart();
}
