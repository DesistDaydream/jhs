package com.huawei.hms.support.api.push;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.android.hms.push.R;
import com.huawei.hms.push.i;

/* loaded from: classes2.dex */
public class TransActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hwpush_trans_activity);
        getWindow().addFlags(67108864);
        i.a(this, getIntent());
        finish();
    }
}
