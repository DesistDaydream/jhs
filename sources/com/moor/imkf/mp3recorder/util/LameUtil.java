package com.moor.imkf.mp3recorder.util;

import com.moor.imkf.lib.utils.MoorLogUtils;

/* loaded from: classes2.dex */
public class LameUtil {
    static {
        try {
            System.loadLibrary("moormp3");
        } catch (UnsatisfiedLinkError unused) {
            MoorLogUtils.e("录音功能不可用,so包加载失败");
        }
    }

    public static native void close();

    public static native int encode(short[] sArr, short[] sArr2, int i2, byte[] bArr);

    public static native int flush(byte[] bArr);

    public static native void init(int i2, int i3, int i4, int i5, int i6);
}
