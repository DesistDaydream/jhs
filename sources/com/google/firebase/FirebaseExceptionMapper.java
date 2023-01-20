package com.google.firebase;

import com.google.android.gms.common.api.Status;
import e.j.a.b.c.m.a;
import e.j.a.b.c.n.u.u;

@a
/* loaded from: classes2.dex */
public class FirebaseExceptionMapper implements u {
    @Override // e.j.a.b.c.n.u.u
    public Exception getException(Status status) {
        if (status.getStatusCode() == 8) {
            return new FirebaseException(status.zzg());
        }
        return new FirebaseApiNotAvailableException(status.zzg());
    }
}
