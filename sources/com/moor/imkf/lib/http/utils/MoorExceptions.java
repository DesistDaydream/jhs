package com.moor.imkf.lib.http.utils;

/* loaded from: classes2.dex */
public class MoorExceptions {
    public static void illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }
}
