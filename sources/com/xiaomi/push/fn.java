package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public class fn extends Exception {
    private fw a;
    private fx b;

    /* renamed from: c  reason: collision with root package name */
    private Throwable f8595c;

    public fn() {
        this.a = null;
        this.b = null;
        this.f8595c = null;
    }

    public fn(fw fwVar) {
        this.a = null;
        this.b = null;
        this.f8595c = null;
        this.a = fwVar;
    }

    public fn(String str) {
        super(str);
        this.a = null;
        this.b = null;
        this.f8595c = null;
    }

    public fn(String str, Throwable th) {
        super(str);
        this.a = null;
        this.b = null;
        this.f8595c = null;
        this.f8595c = th;
    }

    public fn(Throwable th) {
        this.a = null;
        this.b = null;
        this.f8595c = null;
        this.f8595c = th;
    }

    public Throwable a() {
        return this.f8595c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        fw fwVar;
        fx fxVar;
        String message = super.getMessage();
        return (message != null || (fxVar = this.b) == null) ? (message != null || (fwVar = this.a) == null) ? message : fwVar.toString() : fxVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f8595c != null) {
            printStream.println("Nested Exception: ");
            this.f8595c.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f8595c != null) {
            printWriter.println("Nested Exception: ");
            this.f8595c.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        fx fxVar = this.b;
        if (fxVar != null) {
            sb.append(fxVar);
        }
        fw fwVar = this.a;
        if (fwVar != null) {
            sb.append(fwVar);
        }
        if (this.f8595c != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f8595c);
        }
        return sb.toString();
    }
}
