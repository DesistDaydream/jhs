package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;
import android.util.Log;

/* loaded from: classes4.dex */
public class IdentifierIdObserver extends ContentObserver {
    private static final String a = "VMS_IDLG_SDK_Observer";
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f17161c;

    /* renamed from: d  reason: collision with root package name */
    private IdentifierIdClient f17162d;

    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i2, String str) {
        super(null);
        this.f17162d = identifierIdClient;
        this.f17161c = i2;
        this.b = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        IdentifierIdClient identifierIdClient = this.f17162d;
        if (identifierIdClient != null) {
            identifierIdClient.a(this.f17161c, this.b);
        } else {
            Log.e(a, "mIdentifierIdClient is null");
        }
    }
}
