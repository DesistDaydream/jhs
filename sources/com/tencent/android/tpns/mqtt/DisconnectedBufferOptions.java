package com.tencent.android.tpns.mqtt;

/* loaded from: classes3.dex */
public class DisconnectedBufferOptions {
    public static final boolean DELETE_OLDEST_MESSAGES_DEFAULT = false;
    public static final boolean DISCONNECTED_BUFFER_ENABLED_DEFAULT = false;
    public static final int DISCONNECTED_BUFFER_SIZE_DEFAULT = 5000;
    public static final boolean PERSIST_DISCONNECTED_BUFFER_DEFAULT = false;
    private int bufferSize = 5000;
    private boolean bufferEnabled = false;
    private boolean persistBuffer = false;
    private boolean deleteOldestMessages = false;

    public int getBufferSize() {
        return this.bufferSize;
    }

    public boolean isBufferEnabled() {
        return this.bufferEnabled;
    }

    public boolean isDeleteOldestMessages() {
        return this.deleteOldestMessages;
    }

    public boolean isPersistBuffer() {
        return this.persistBuffer;
    }

    public void setBufferEnabled(boolean z) {
        this.bufferEnabled = z;
    }

    public void setBufferSize(int i2) {
        if (i2 >= 1) {
            this.bufferSize = i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setDeleteOldestMessages(boolean z) {
        this.deleteOldestMessages = z;
    }

    public void setPersistBuffer(boolean z) {
        this.persistBuffer = z;
    }
}
