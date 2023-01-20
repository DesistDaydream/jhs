package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gq;

/* loaded from: classes3.dex */
public /* synthetic */ class an {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[gq.values().length];
        a = iArr;
        try {
            iArr[gq.SendMessage.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[gq.Registration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[gq.UnRegistration.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[gq.Subscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[gq.UnSubscription.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[gq.Command.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[gq.Notification.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
