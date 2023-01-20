package e.l.q.c.t0.e;

import android.content.Context;
import com.effective.android.panel.Constants;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public class b {
    public static int a(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.yms_dimens_50_0_px);
        int identifier = context.getResources().getIdentifier(Constants.STATUS_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID);
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : dimensionPixelSize;
    }

    public static boolean b(float f2, float f3, float f4, float f5, long j2, long j3, long j4) {
        return Math.abs(f4 - f2) <= 10.0f && Math.abs(f5 - f3) <= 10.0f && j3 - j2 >= j4;
    }
}
