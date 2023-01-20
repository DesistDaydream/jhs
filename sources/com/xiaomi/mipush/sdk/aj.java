package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gq;

/* loaded from: classes3.dex */
public /* synthetic */ class aj {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[gq.values().length];
        a = iArr;
        try {
            iArr[gq.Registration.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[gq.UnRegistration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[gq.Subscription.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[gq.UnSubscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[gq.SendMessage.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[gq.AckMessage.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[gq.SetConfig.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[gq.ReportFeedback.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[gq.Notification.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[gq.Command.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
