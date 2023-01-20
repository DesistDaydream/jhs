package com.moor.imkf.lib.socket;

/* loaded from: classes2.dex */
public class MoorWsManager {
    private boolean socketConnectStatus = false;

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final MoorWsManager sInstance = new MoorWsManager();

        private SingletonHolder() {
        }
    }

    public static MoorWsManager getInstance() {
        return SingletonHolder.sInstance;
    }

    public boolean isSocketConnectStatus() {
        return this.socketConnectStatus;
    }

    public void setSocketConnectStatus(boolean z) {
        this.socketConnectStatus = z;
    }
}
