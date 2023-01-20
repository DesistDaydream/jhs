package com.bytedance.msdk.api.v2.ad.custom.nativeAd;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import java.util.List;

/* loaded from: classes.dex */
public interface IGMCustomNativeConvert {
    void registerViewForInteractionInner(@Nullable Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, GMViewBinder gMViewBinder);

    void unregisterViewInner();
}
