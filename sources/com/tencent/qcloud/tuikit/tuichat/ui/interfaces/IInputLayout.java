package com.tencent.qcloud.tuikit.tuichat.ui.interfaces;

import android.view.View;
import android.widget.EditText;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.BaseInputFragment;

/* loaded from: classes3.dex */
public interface IInputLayout {
    void addAction(InputMoreActionUnit inputMoreActionUnit);

    void disableAudioInput(boolean z);

    void disableCaptureAction(boolean z);

    void disableEmojiInput(boolean z);

    void disableMoreInput(boolean z);

    void disableSendFileAction(boolean z);

    void disableSendPhotoAction(boolean z);

    void disableVideoRecordAction(boolean z);

    EditText getInputText();

    void replaceMoreInput(View.OnClickListener onClickListener);

    void replaceMoreInput(BaseInputFragment baseInputFragment);
}
