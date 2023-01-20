package com.jihuanshe.binding;

import android.view.View;
import android.widget.TextView;
import com.jihuanshe.ui.widget.CopyPopupWindow;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper;
import e.t.o.d;
import java.lang.ref.WeakReference;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class TextViewBinding$setSelect$1 implements SelectTextHelper.OnSelectListener {
    @d
    private String a = "";
    @e
    private CopyPopupWindow b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SelectTextHelper f3911c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f3912d;

    public TextViewBinding$setSelect$1(SelectTextHelper selectTextHelper, TextView textView) {
        this.f3911c = selectTextHelper;
        this.f3912d = textView;
    }

    @d
    public final String a() {
        return this.a;
    }

    @e
    public final CopyPopupWindow b() {
        return this.b;
    }

    public final void c(@d String str) {
        this.a = str;
    }

    public final void d(@e CopyPopupWindow copyPopupWindow) {
        this.b = copyPopupWindow;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
    public void onClick(@e View view) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
    public void onClickUrl(@e String str) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
    public void onDismiss() {
        CopyPopupWindow copyPopupWindow = this.b;
        if (copyPopupWindow == null) {
            return;
        }
        copyPopupWindow.dismiss();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
    public void onDismissCustomPop() {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
    public void onLongClick(@e View view) {
        WeakReference weakReference;
        SelectTextHelper selectTextHelper;
        weakReference = TextViewBinding.f3910c;
        if (weakReference != null && (selectTextHelper = (SelectTextHelper) weakReference.get()) != null) {
            selectTextHelper.reset();
        }
        TextViewBinding textViewBinding = TextViewBinding.a;
        TextViewBinding.f3910c = new WeakReference(this.f3911c);
        CopyPopupWindow copyPopupWindow = new CopyPopupWindow(this.f3912d.getContext(), new TextViewBinding$setSelect$1$onLongClick$1(this, this.f3911c));
        d(copyPopupWindow);
        copyPopupWindow.setOutsideTouchable(false);
        int measuredWidth = this.f3912d.getMeasuredWidth();
        d.a aVar = e.t.o.d.a;
        copyPopupWindow.showAsDropDown(view, Math.max((measuredWidth - d.a.c(aVar, null, 1, null).d(63)) / 2, 0), -(this.f3912d.getMeasuredHeight() + d.a.c(aVar, null, 1, null).d(52)));
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
    public void onReset() {
        CopyPopupWindow copyPopupWindow = this.b;
        if (copyPopupWindow == null) {
            return;
        }
        copyPopupWindow.dismiss();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
    public void onScrolling() {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
    public void onSelectAllShowCustomPop() {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.SelectTextHelper.OnSelectListener
    public void onTextSelected(@e CharSequence charSequence) {
        String obj = charSequence == null ? null : charSequence.toString();
        if (obj == null) {
            obj = "";
        }
        this.a = obj;
    }
}
