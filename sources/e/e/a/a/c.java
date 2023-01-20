package e.e.a.a;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.f;
import java.util.UUID;

/* loaded from: classes.dex */
public class c {
    public static String[] a = {am.av, "b", "c", f.f10128d, e.a, "f", "g", "h", "i", "j", "k", NotifyType.LIGHTS, "m", "n", "o", am.ax, "q", "r", "s", am.aI, am.aH, "v", IAdInterListener.AdReqParam.WIDTH, "x", "y", am.aD, "0", "1", "2", "3", PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION, "5", "6", "7", "8", "9", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", ExpandableTextView.P, "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};

    public static String a() {
        return UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public static String b(int i2) {
        StringBuilder sb = new StringBuilder(UUID.randomUUID().toString());
        while (sb.length() < i2) {
            sb.append(UUID.randomUUID().toString());
        }
        return sb.substring(0, i2);
    }
}
