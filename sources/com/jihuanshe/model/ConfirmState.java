package com.jihuanshe.model;

import e.j.e.r.c;
import h.k2.v.f0;
import h.k2.v.u;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ConfirmState {
    @c("applyment_state")
    @e
    private final String state;
    @c("sign_url")
    @e
    private final String url;

    public ConfirmState() {
        this(null, null, 3, null);
    }

    public ConfirmState(@e String str, @e String str2) {
        this.state = str;
        this.url = str2;
    }

    @e
    public final String getState() {
        return this.state;
    }

    @e
    public final String getUrl() {
        return this.url;
    }

    public final boolean isAuditing() {
        return f0.g("AUDITING", this.state);
    }

    public final boolean isFinish() {
        return f0.g("FINISH", this.state);
    }

    public final boolean isRejected() {
        return f0.g("REJECTED", this.state);
    }

    public final boolean isSigning() {
        return f0.g("NEED_SIGN", this.state);
    }

    public /* synthetic */ ConfirmState(String str, String str2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }
}
