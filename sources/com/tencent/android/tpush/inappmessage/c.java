package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.android.tpush.logging.TLogger;

/* loaded from: classes3.dex */
public class c extends h {
    public c(Activity activity, d dVar, Intent intent) {
        super(activity, dVar, intent);
    }

    @Override // com.tencent.android.tpush.inappmessage.a
    public RelativeLayout.LayoutParams b() {
        Point displaySize = SizeUtil.getDisplaySize(this.b);
        int dipTopx = SizeUtil.dipTopx(this.b, this.f6131d.a());
        int dipTopx2 = SizeUtil.dipTopx(this.b, this.f6131d.b());
        TLogger.i("Center Popup", "size.x = " + displaySize.x + ", size.y =" + displaySize.y + "width = " + dipTopx + ", height =" + dipTopx2);
        int i2 = displaySize.x;
        int i3 = SizeUtil.dp20;
        int i4 = i2 - i3;
        int i5 = displaySize.y - i3;
        double d2 = (double) dipTopx;
        double d3 = d2 / ((double) dipTopx2);
        if (dipTopx > i4 && ((int) (d2 / d3)) < i5) {
            dipTopx2 = (int) (i4 / d3);
            dipTopx = i4;
        }
        if (dipTopx2 <= i5 || ((int) (dipTopx2 * d3)) >= i4) {
            i5 = dipTopx2;
        } else {
            dipTopx = (int) (i5 * d3);
        }
        TLogger.i("Center Popup", "InAppMsg LayoutParams width = " + dipTopx + ", height = " + i5);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipTopx, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    @Override // com.tencent.android.tpush.inappmessage.a, android.app.Dialog, android.content.DialogInterface
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // com.tencent.android.tpush.inappmessage.a
    public boolean d() {
        return false;
    }

    @Override // com.tencent.android.tpush.inappmessage.a
    public void e() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.addFlags(2);
        if (Build.VERSION.SDK_INT >= 14) {
            window.setDimAmount(0.7f);
        }
    }
}
