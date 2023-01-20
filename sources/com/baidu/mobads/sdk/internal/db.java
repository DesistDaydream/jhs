package com.baidu.mobads.sdk.internal;

import android.os.CountDownTimer;
import android.widget.TextView;

/* loaded from: classes.dex */
public class db extends CountDownTimer {
    public final /* synthetic */ cz a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db(cz czVar, long j2, long j3) {
        super(j2, j3);
        this.a = czVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.a.b.a("CountDownTimer finished");
        this.a.c();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j2) {
        TextView textView;
        int i2 = (int) (j2 / 1000);
        if (i2 > 5) {
            i2 = 5;
        }
        textView = this.a.f1584d;
        textView.setText(String.valueOf(i2));
    }
}
