package com.effective.android.panel.view.content;

import android.view.View;
import androidx.annotation.IdRes;
import com.effective.android.panel.interfaces.ContentScrollMeasurer;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006JU\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/effective/android/panel/view/content/IContentContainer;", "", "", "id", "Landroid/view/View;", "findTriggerView", "(I)Landroid/view/View;", NotifyType.LIGHTS, am.aI, "r", "b", "", "Lcom/effective/android/panel/interfaces/ContentScrollMeasurer;", "contentScrollMeasurer", "defaultScrollHeight", "", "canScrollOutsize", "reset", "Lh/t1;", "layoutContainer", "(IIIILjava/util/List;IZZ)V", "targetHeight", "changeContainerHeight", "(I)V", "Lcom/effective/android/panel/view/content/IInputAction;", "getInputActionImpl", "()Lcom/effective/android/panel/view/content/IInputAction;", "Lcom/effective/android/panel/view/content/IResetAction;", "getResetActionImpl", "()Lcom/effective/android/panel/view/content/IResetAction;", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface IContentContainer {
    void changeContainerHeight(int i2);

    @e
    View findTriggerView(@IdRes int i2);

    @d
    IInputAction getInputActionImpl();

    @d
    IResetAction getResetActionImpl();

    void layoutContainer(int i2, int i3, int i4, int i5, @d List<ContentScrollMeasurer> list, int i6, boolean z, boolean z2);
}
