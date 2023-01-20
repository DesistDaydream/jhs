package com.moor.imkf.event;

/* loaded from: classes2.dex */
public class LoginSuccessEvent {
    public String connectionId;
    public String sessionId;

    public LoginSuccessEvent() {
    }

    public LoginSuccessEvent(String str, String str2) {
        this.connectionId = str;
        this.sessionId = str2;
    }
}
