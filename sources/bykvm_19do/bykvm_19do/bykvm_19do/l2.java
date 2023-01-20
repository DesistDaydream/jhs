package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l2 extends e2 {

    /* renamed from: e  reason: collision with root package name */
    private final Context f148e;

    public l2(Context context) {
        super(true, false);
        this.f148e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        String str;
        DisplayMetrics displayMetrics = this.f148e.getResources().getDisplayMetrics();
        int i2 = displayMetrics.densityDpi;
        switch (i2) {
            case 120:
                str = "ldpi";
                break;
            case 240:
                str = "hdpi";
                break;
            case TipsMessageBean.MSG_TYPE_GROUP_QUITE /* 260 */:
            case 280:
            case 300:
            case 320:
                str = "xhdpi";
                break;
            case 340:
            case 360:
            case 400:
            case TypedValues.Cycle.TYPE_EASING /* 420 */:
            case 440:
            case 480:
                str = "xxhdpi";
                break;
            case 560:
            case 640:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i2);
        jSONObject.put("display_density", str);
        jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        return true;
    }
}
