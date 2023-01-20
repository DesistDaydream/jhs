package com.jihuanshe.binding;

import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.jihuanshe.R;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper;
import com.vector.util.Res;
import h.k2.k;
import h.k2.v.f0;
import java.lang.ref.WeakReference;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class TextViewBinding {
    @d
    public static final TextViewBinding a = new TextViewBinding();
    @d
    private static final String b = "android:tv_selectable";
    @e

    /* renamed from: c  reason: collision with root package name */
    private static WeakReference<SelectTextHelper> f3910c;

    private TextViewBinding() {
    }

    @BindingAdapter({b})
    @k
    public static final void c(@d TextView textView, @e Boolean bool) {
        if (f0.g(bool, Boolean.TRUE)) {
            SelectTextHelper build = new SelectTextHelper.Builder(textView).setCursorHandleColor(Res.k(R.color.common_color)).setCursorHandleSizeInDp(16.0f).setSelectedColor(Res.k(R.color.color_FFE67F)).setSelectAll(true).setIsEmoji(false).setScrollShow(false).setSelectedAllNoPop(true).setMagnifierShow(false).build();
            build.setSelectListener(new TextViewBinding$setSelect$1(build, textView));
        }
    }
}
