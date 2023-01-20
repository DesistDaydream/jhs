package e.q.a.f;

import android.annotation.TargetApi;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import com.tencent.qcloud.tuicore.util.PermissionRequester;
import e.q.a.g.u;
import e.q.a.g.v;
import h.a2.d1;
import h.a2.t0;
import h.z0;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\"\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"allSpecialPermissions", "", "", "getAllSpecialPermissions", "()Ljava/util/Set;", "permissionMapOnQ", "", "getPermissionMapOnQ", "()Ljava/util/Map;", "permissionMapOnR", "getPermissionMapOnR", "permissionMapOnS", "getPermissionMapOnS", "permissionx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class b {
    @k.e.a.d
    private static final Set<String> a = d1.u("android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission.SYSTEM_ALERT_WINDOW", "android.permission.WRITE_SETTINGS", v.f14431f, u.f14429f);
    @TargetApi(29)
    @k.e.a.d
    private static final Map<String, String> b;
    @TargetApi(30)
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, String> f14398c;
    @TargetApi(31)
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, String> f14399d;

    static {
        Map<String, String> W = t0.W(z0.a("android.permission.READ_CALENDAR", PermissionRequester.PermissionConstants.CALENDAR), z0.a("android.permission.WRITE_CALENDAR", PermissionRequester.PermissionConstants.CALENDAR), z0.a("android.permission.READ_CALL_LOG", "android.permission-group.CALL_LOG"), z0.a("android.permission.WRITE_CALL_LOG", "android.permission-group.CALL_LOG"), z0.a("android.permission.PROCESS_OUTGOING_CALLS", "android.permission-group.CALL_LOG"), z0.a(PermissionConstants.CAMERA, PermissionRequester.PermissionConstants.CAMERA), z0.a(PermissionConstants.READ_CONTACTS, PermissionRequester.PermissionConstants.CONTACTS), z0.a("android.permission.WRITE_CONTACTS", PermissionRequester.PermissionConstants.CONTACTS), z0.a("android.permission.GET_ACCOUNTS", PermissionRequester.PermissionConstants.CONTACTS), z0.a("android.permission.ACCESS_FINE_LOCATION", PermissionRequester.PermissionConstants.LOCATION), z0.a("android.permission.ACCESS_COARSE_LOCATION", PermissionRequester.PermissionConstants.LOCATION), z0.a("android.permission.ACCESS_BACKGROUND_LOCATION", PermissionRequester.PermissionConstants.LOCATION), z0.a(PermissionConstants.RECORD_AUDIO, PermissionRequester.PermissionConstants.MICROPHONE), z0.a(PermissionConstants.PHONE_STATE, PermissionRequester.PermissionConstants.PHONE), z0.a("android.permission.READ_PHONE_NUMBERS", PermissionRequester.PermissionConstants.PHONE), z0.a(PermissionConstants.CALL_PHONE, PermissionRequester.PermissionConstants.PHONE), z0.a("android.permission.ANSWER_PHONE_CALLS", PermissionRequester.PermissionConstants.PHONE), z0.a("com.android.voicemail.permission.ADD_VOICEMAIL", PermissionRequester.PermissionConstants.PHONE), z0.a("android.permission.USE_SIP", PermissionRequester.PermissionConstants.PHONE), z0.a("android.permission.ACCEPT_HANDOVER", PermissionRequester.PermissionConstants.PHONE), z0.a("android.permission.BODY_SENSORS", PermissionRequester.PermissionConstants.SENSORS), z0.a("android.permission.ACTIVITY_RECOGNITION", "android.permission-group.ACTIVITY_RECOGNITION"), z0.a("android.permission.SEND_SMS", PermissionRequester.PermissionConstants.SMS), z0.a("android.permission.RECEIVE_SMS", PermissionRequester.PermissionConstants.SMS), z0.a("android.permission.READ_SMS", PermissionRequester.PermissionConstants.SMS), z0.a("android.permission.RECEIVE_WAP_PUSH", PermissionRequester.PermissionConstants.SMS), z0.a("android.permission.RECEIVE_MMS", PermissionRequester.PermissionConstants.SMS), z0.a("android.permission.READ_EXTERNAL_STORAGE", PermissionRequester.PermissionConstants.STORAGE), z0.a(PermissionConstants.STORE, PermissionRequester.PermissionConstants.STORAGE), z0.a("android.permission.ACCESS_MEDIA_LOCATION", PermissionRequester.PermissionConstants.STORAGE));
        b = W;
        f14398c = W;
        Map J0 = t0.J0(t0.W(z0.a("android.permission.BLUETOOTH_SCAN", "android.permission-group.NEARBY_DEVICES"), z0.a("android.permission.BLUETOOTH_ADVERTISE", "android.permission-group.NEARBY_DEVICES"), z0.a("android.permission.BLUETOOTH_CONNECT", "android.permission-group.NEARBY_DEVICES")));
        J0.putAll(c());
        f14399d = t0.D0(J0);
    }

    @k.e.a.d
    public static final Set<String> a() {
        return a;
    }

    @k.e.a.d
    public static final Map<String, String> b() {
        return b;
    }

    @k.e.a.d
    public static final Map<String, String> c() {
        return f14398c;
    }

    @k.e.a.d
    public static final Map<String, String> d() {
        return f14399d;
    }
}
