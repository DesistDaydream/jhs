package com.vivo.push;

import android.net.Uri;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes3.dex */
public final class p {
    public static final Uri a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");
    public static final Uri b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");

    /* renamed from: c  reason: collision with root package name */
    public static final Uri f8145c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");

    /* renamed from: d  reason: collision with root package name */
    public static final Uri f8146d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

    public static String a(int i2) {
        switch (i2) {
            case ErrorCode.INNER_ERROR /* 2002 */:
                return "method_alias_bind";
            case 2003:
                return "method_alias_unbind";
            case PushConstants.NOTIFICATION_SERVICE_SEND_MESSAGE_ERROR /* 2004 */:
                return "method_tag_bind";
            case PushConstants.NOTIFICATION_SERVICE_SEND_MESSAGE_BROADCAST /* 2005 */:
                return "method_tag_unbind";
            case 2006:
                return "method_sdk_bind";
            case 2007:
                return "method_sdk_unbind";
            case 2008:
                return "method_stop";
            default:
                return null;
        }
    }
}
