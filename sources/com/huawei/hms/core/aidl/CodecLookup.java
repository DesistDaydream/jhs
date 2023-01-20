package com.huawei.hms.core.aidl;

/* loaded from: classes2.dex */
public final class CodecLookup {
    private CodecLookup() {
    }

    public static MessageCodec find(int i2) {
        if (i2 == 2) {
            return new a();
        }
        return new MessageCodec();
    }
}
