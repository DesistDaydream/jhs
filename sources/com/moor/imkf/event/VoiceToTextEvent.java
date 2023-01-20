package com.moor.imkf.event;

/* loaded from: classes2.dex */
public class VoiceToTextEvent {
    public static final String STATUS_FAIL = "500";
    public static final String STATUS_OK = "21050000";
    public static final String STATUS_TIMEOUT = "400";
    public static final String STATUS_TOLONG = "STATUS_TOLONG";
    public static final String STATUS_UNDEFINED = "21050003";
    public String id = "VoiceToTextEvent_nullID";
    public String status_code;
    public String toText;
}
