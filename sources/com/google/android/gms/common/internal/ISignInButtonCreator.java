package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.RemoteException;
import e.j.a.b.d.d;

/* loaded from: classes2.dex */
public interface ISignInButtonCreator extends IInterface {
    d newSignInButton(d dVar, int i2, int i3) throws RemoteException;

    d newSignInButtonFromConfig(d dVar, SignInButtonConfig signInButtonConfig) throws RemoteException;
}
