package com.m7.imkfsdk.chat;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.m7.imkfsdk.R;
import com.moor.imkf.YKFConstants;

/* loaded from: classes2.dex */
public class KFBaseActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        int i2 = getSharedPreferences(YKFConstants.MOOR_SP, 0).getInt(YKFConstants.SYSTHEME, 0);
        if (i2 == 0) {
            setTheme(R.style.ykfsdk_KFSdkAppTheme);
        } else if (i2 == 1) {
            setTheme(R.style.ykfsdk_KFSdkAppTheme1);
        }
    }
}
