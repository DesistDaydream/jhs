package com.effective.android.panel.view.content;

import android.view.View;
import android.widget.EditText;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0011H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b\u001f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/effective/android/panel/view/content/IInputAction;", "", "Landroid/widget/EditText;", "editText", "Lh/t1;", "addSecondaryInputView", "(Landroid/widget/EditText;)V", "removeSecondaryInputView", "Landroid/view/View$OnClickListener;", NotifyType.LIGHTS, "setEditTextClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnFocusChangeListener;", "setEditTextFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "requestKeyboard", "()V", "", "clearFocus", "hideKeyboard", "(Z)V", "showKeyboard", "()Z", "getFullScreenPixelInputView", "()Landroid/widget/EditText;", "isFullScreen", "", "panelId", "panelHeight", "updateFullScreenParams", "(ZII)V", "recycler", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface IInputAction {
    void addSecondaryInputView(@d EditText editText);

    @d
    EditText getFullScreenPixelInputView();

    void hideKeyboard(boolean z);

    void recycler();

    void removeSecondaryInputView(@d EditText editText);

    void requestKeyboard();

    void setEditTextClickListener(@d View.OnClickListener onClickListener);

    void setEditTextFocusChangeListener(@d View.OnFocusChangeListener onFocusChangeListener);

    boolean showKeyboard();

    void updateFullScreenParams(boolean z, int i2, int i3);
}
