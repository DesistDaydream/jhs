package com.tencent.qcloud.tuikit.tuichat.ui.view.input.inputmore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.BaseInputFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class InputMoreFragment extends BaseInputFragment {
    public static final int REQUEST_CODE_FILE = 1011;
    public static final int REQUEST_CODE_PHOTO = 1012;
    private View mBaseView;
    private IUIKitCallback mCallback;
    private List<InputMoreActionUnit> mInputMoreList = new ArrayList();

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if ((i2 == 1011 || i2 == 1012) && i3 == -1) {
            Uri data = intent.getData();
            IUIKitCallback iUIKitCallback = this.mCallback;
            if (iUIKitCallback != null) {
                iUIKitCallback.onSuccess(data);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.chat_inputmore_fragment, viewGroup, false);
        this.mBaseView = inflate;
        ((InputMoreLayout) inflate.findViewById(R.id.input_extra_area)).init(this.mInputMoreList);
        return this.mBaseView;
    }

    public void setActions(List<InputMoreActionUnit> list) {
        this.mInputMoreList = list;
    }

    public void setCallback(IUIKitCallback iUIKitCallback) {
        this.mCallback = iUIKitCallback;
    }
}
