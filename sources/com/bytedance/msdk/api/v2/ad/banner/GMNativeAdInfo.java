package com.bytedance.msdk.api.v2.ad.banner;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface GMNativeAdInfo {
    @Nullable
    String getActionText();

    int getAdImageMode();

    @Nullable
    String getDescription();

    @Nullable
    GMAdDislike getDislikeDialog(Activity activity);

    @Nullable
    GMAdDislike getDislikeDialog(Activity activity, Map<String, Object> map);

    @Nullable
    String getIconUrl();

    @Nullable
    List<String> getImageList();

    @Nullable
    String getImageUrl();

    int getInteractionType();

    GMNativeAdAppInfo getNativeAdAppInfo();

    @Nullable
    String getSource();

    double getStarRating();

    @Nullable
    String getTitle();

    boolean hasDislike();

    void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, GMViewBinder gMViewBinder);
}
