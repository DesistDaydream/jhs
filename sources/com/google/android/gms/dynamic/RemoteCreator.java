package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import e.j.a.b.c.h;
import e.j.a.b.c.m.a;
import e.j.a.b.c.r.a0;

@a
/* loaded from: classes2.dex */
public abstract class RemoteCreator<T> {
    private final String zzic;
    private T zzid;

    @a
    /* loaded from: classes2.dex */
    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    @a
    public RemoteCreator(String str) {
        this.zzic = str;
    }

    @a
    public abstract T getRemoteCreator(IBinder iBinder);

    @a
    public final T getRemoteCreatorInstance(Context context) throws RemoteCreatorException {
        if (this.zzid == null) {
            a0.k(context);
            Context i2 = h.i(context);
            if (i2 != null) {
                try {
                    this.zzid = getRemoteCreator((IBinder) i2.getClassLoader().loadClass(this.zzic).newInstance());
                } catch (ClassNotFoundException e2) {
                    throw new RemoteCreatorException("Could not load creator class.", e2);
                } catch (IllegalAccessException e3) {
                    throw new RemoteCreatorException("Could not access creator.", e3);
                } catch (InstantiationException e4) {
                    throw new RemoteCreatorException("Could not instantiate creator.", e4);
                }
            } else {
                throw new RemoteCreatorException("Could not get remote context.");
            }
        }
        return this.zzid;
    }
}
