package com.google.firebase;

import androidx.annotation.NonNull;
import e.j.a.b.c.r.a0;

/* loaded from: classes2.dex */
public class FirebaseException extends Exception {
    @Deprecated
    public FirebaseException() {
    }

    public FirebaseException(@NonNull String str) {
        super(a0.h(str, "Detail message must not be empty"));
    }

    public FirebaseException(@NonNull String str, Throwable th) {
        super(a0.h(str, "Detail message must not be empty"), th);
    }
}
