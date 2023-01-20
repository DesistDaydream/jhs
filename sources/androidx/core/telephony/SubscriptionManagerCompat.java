package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(22)
/* loaded from: classes.dex */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static int getSlotIndex(int i2) {
            return SubscriptionManager.getSlotIndex(i2);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int i2) {
        if (i2 == -1) {
            return -1;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            return Api29Impl.getSlotIndex(i2);
        }
        try {
            if (sGetSlotIndexMethod == null) {
                if (i3 >= 26) {
                    sGetSlotIndexMethod = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", Integer.TYPE);
                } else {
                    sGetSlotIndexMethod = SubscriptionManager.class.getDeclaredMethod("getSlotId", Integer.TYPE);
                }
                sGetSlotIndexMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSlotIndexMethod.invoke(null, Integer.valueOf(i2));
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }
}
