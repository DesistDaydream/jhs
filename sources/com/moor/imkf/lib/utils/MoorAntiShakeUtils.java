package com.moor.imkf.lib.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes2.dex */
public class MoorAntiShakeUtils {
    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private final List<OneClickUtil> utils;

    /* loaded from: classes2.dex */
    public static class OneClickUtil {
        private long lastClickTime = 0;
        private final String methodName;

        public OneClickUtil(String str) {
            this.methodName = str;
        }

        public boolean check() {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis - this.lastClickTime > 1000) {
                this.lastClickTime = timeInMillis;
                return false;
            }
            return true;
        }

        public String getMethodName() {
            return this.methodName;
        }
    }

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final MoorAntiShakeUtils sInstance = new MoorAntiShakeUtils();

        private SingletonHolder() {
        }
    }

    public static MoorAntiShakeUtils getInstance() {
        return SingletonHolder.sInstance;
    }

    public boolean check() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        for (OneClickUtil oneClickUtil : this.utils) {
            if (oneClickUtil.getMethodName().equals(methodName)) {
                return oneClickUtil.check();
            }
        }
        OneClickUtil oneClickUtil2 = new OneClickUtil(methodName);
        this.utils.add(oneClickUtil2);
        return oneClickUtil2.check();
    }

    private MoorAntiShakeUtils() {
        this.utils = new ArrayList();
    }
}
