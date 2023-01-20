package com.qq.e.comm.managers;

import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class a implements Runnable {
    public final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PM pm;
        try {
            pm = this.a.f5076d;
            pm.getPOFactory();
            this.a.b = true;
        } catch (e e2) {
            GDTLogger.e(e2.getMessage(), e2);
        }
    }
}
