package com.tencent.qcloud.tuicore.component.activities;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.qcloud.tuicore.R;

/* loaded from: classes3.dex */
public class BaseLightActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(134217728);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(getResources().getColor(R.color.core_popup_card_bg));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.navigation_bar_color));
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8192 | 16);
        }
    }
}
