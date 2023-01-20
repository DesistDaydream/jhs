package com.meizu.cloud.pushsdk.c.g;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes2.dex */
public interface l extends Closeable, Flushable {
    void a(b bVar, long j2);

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    void close();

    void flush();
}
