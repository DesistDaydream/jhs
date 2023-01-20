package com.moor.imkf.lib.jobqueue.messaging;

import com.moor.imkf.lib.jobqueue.log.JqLog;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class MessageFactory {
    private static final int CACHE_LIMIT = 20;
    public int[] counts;
    public Message[] pools;

    public MessageFactory() {
        Message[] messageArr = new Message[Type.values().length];
        this.pools = messageArr;
        int[] iArr = new int[messageArr.length];
        this.counts = iArr;
        Arrays.fill(iArr, 0);
    }

    public <T extends Message> T obtain(Class<T> cls) {
        Type type = Type.mapping.get(cls);
        synchronized (type) {
            T t = (T) this.pools[type.ordinal()];
            if (t != null) {
                this.pools[type.ordinal()] = t.next;
                int[] iArr = this.counts;
                int ordinal = type.ordinal();
                iArr[ordinal] = iArr[ordinal] - 1;
                t.next = null;
                return t;
            }
            try {
                try {
                    return cls.newInstance();
                } catch (IllegalAccessException e2) {
                    JqLog.e(e2, "Cannot create an instance of " + cls + ". Make sure it has a public empty constructor.", new Object[0]);
                    return null;
                }
            } catch (InstantiationException e3) {
                JqLog.e(e3, "Cannot create an instance of " + cls + ". Make sure it has a empty constructor.", new Object[0]);
                return null;
            }
        }
    }

    public void release(Message message) {
        Type type = message.type;
        message.recycle();
        synchronized (type) {
            if (this.counts[type.ordinal()] < 20) {
                message.next = this.pools[type.ordinal()];
                this.pools[type.ordinal()] = message;
                int[] iArr = this.counts;
                int ordinal = type.ordinal();
                iArr[ordinal] = iArr[ordinal] + 1;
            }
        }
    }
}
