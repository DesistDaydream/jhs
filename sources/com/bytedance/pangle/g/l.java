package com.bytedance.pangle.g;

import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;

/* loaded from: classes.dex */
public final class l implements k {
    private static final long a = Os.sysconf(OsConstants._SC_PAGESIZE);
    private final FileDescriptor b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2296c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2297d;

    public l(FileDescriptor fileDescriptor, long j2, long j3) {
        this.b = fileDescriptor;
        this.f2296c = j2;
        this.f2297d = j3;
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f2297d;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.pangle.g.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.bytedance.pangle.g.j r20, long r21, int r23) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.l.a(com.bytedance.pangle.g.j, long, int):void");
    }
}
