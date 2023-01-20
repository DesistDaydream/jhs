package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CallbackRegistry<C, T, A> implements Cloneable {
    private static final String TAG = "CallbackRegistry";
    private List<C> mCallbacks = new ArrayList();
    private long mFirst64Removed = 0;
    private int mNotificationLevel;
    private final NotifierCallback<C, T, A> mNotifier;
    private long[] mRemainderRemoved;

    /* loaded from: classes.dex */
    public static abstract class NotifierCallback<C, T, A> {
        public abstract void onNotifyCallback(C c2, T t, int i2, A a);
    }

    public CallbackRegistry(NotifierCallback<C, T, A> notifierCallback) {
        this.mNotifier = notifierCallback;
    }

    private boolean isRemoved(int i2) {
        int i3;
        if (i2 < 64) {
            return ((1 << i2) & this.mFirst64Removed) != 0;
        }
        long[] jArr = this.mRemainderRemoved;
        if (jArr != null && (i3 = (i2 / 64) - 1) < jArr.length) {
            return ((1 << (i2 % 64)) & jArr[i3]) != 0;
        }
        return false;
    }

    private void notifyFirst64(T t, int i2, A a) {
        notifyCallbacks(t, i2, a, 0, Math.min(64, this.mCallbacks.size()), this.mFirst64Removed);
    }

    private void notifyRecurse(T t, int i2, A a) {
        int size = this.mCallbacks.size();
        long[] jArr = this.mRemainderRemoved;
        int length = jArr == null ? -1 : jArr.length - 1;
        notifyRemainder(t, i2, a, length);
        notifyCallbacks(t, i2, a, (length + 2) * 64, size, 0L);
    }

    private void notifyRemainder(T t, int i2, A a, int i3) {
        if (i3 < 0) {
            notifyFirst64(t, i2, a);
            return;
        }
        long j2 = this.mRemainderRemoved[i3];
        int i4 = (i3 + 1) * 64;
        int min = Math.min(this.mCallbacks.size(), i4 + 64);
        notifyRemainder(t, i2, a, i3 - 1);
        notifyCallbacks(t, i2, a, i4, min, j2);
    }

    private void removeRemovedCallbacks(int i2, long j2) {
        long j3 = Long.MIN_VALUE;
        for (int i3 = (i2 + 64) - 1; i3 >= i2; i3--) {
            if ((j2 & j3) != 0) {
                this.mCallbacks.remove(i3);
            }
            j3 >>>= 1;
        }
    }

    private void setRemovalBit(int i2) {
        if (i2 < 64) {
            this.mFirst64Removed = (1 << i2) | this.mFirst64Removed;
            return;
        }
        int i3 = (i2 / 64) - 1;
        long[] jArr = this.mRemainderRemoved;
        if (jArr == null) {
            this.mRemainderRemoved = new long[this.mCallbacks.size() / 64];
        } else if (jArr.length <= i3) {
            long[] jArr2 = new long[this.mCallbacks.size() / 64];
            long[] jArr3 = this.mRemainderRemoved;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.mRemainderRemoved = jArr2;
        }
        long j2 = 1 << (i2 % 64);
        long[] jArr4 = this.mRemainderRemoved;
        jArr4[i3] = j2 | jArr4[i3];
    }

    public synchronized void add(C c2) {
        if (c2 != null) {
            int lastIndexOf = this.mCallbacks.lastIndexOf(c2);
            if (lastIndexOf < 0 || isRemoved(lastIndexOf)) {
                this.mCallbacks.add(c2);
            }
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    public synchronized void clear() {
        if (this.mNotificationLevel == 0) {
            this.mCallbacks.clear();
        } else if (!this.mCallbacks.isEmpty()) {
            for (int size = this.mCallbacks.size() - 1; size >= 0; size--) {
                setRemovalBit(size);
            }
        }
    }

    public synchronized ArrayList<C> copyCallbacks() {
        ArrayList<C> arrayList;
        arrayList = new ArrayList<>(this.mCallbacks.size());
        int size = this.mCallbacks.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!isRemoved(i2)) {
                arrayList.add(this.mCallbacks.get(i2));
            }
        }
        return arrayList;
    }

    public synchronized boolean isEmpty() {
        if (this.mCallbacks.isEmpty()) {
            return true;
        }
        if (this.mNotificationLevel == 0) {
            return false;
        }
        int size = this.mCallbacks.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!isRemoved(i2)) {
                return false;
            }
        }
        return true;
    }

    public synchronized void notifyCallbacks(T t, int i2, A a) {
        this.mNotificationLevel++;
        notifyRecurse(t, i2, a);
        int i3 = this.mNotificationLevel - 1;
        this.mNotificationLevel = i3;
        if (i3 == 0) {
            long[] jArr = this.mRemainderRemoved;
            if (jArr != null) {
                for (int length = jArr.length - 1; length >= 0; length--) {
                    long j2 = this.mRemainderRemoved[length];
                    if (j2 != 0) {
                        removeRemovedCallbacks((length + 1) * 64, j2);
                        this.mRemainderRemoved[length] = 0;
                    }
                }
            }
            long j3 = this.mFirst64Removed;
            if (j3 != 0) {
                removeRemovedCallbacks(0, j3);
                this.mFirst64Removed = 0L;
            }
        }
    }

    public synchronized void remove(C c2) {
        if (this.mNotificationLevel == 0) {
            this.mCallbacks.remove(c2);
        } else {
            int lastIndexOf = this.mCallbacks.lastIndexOf(c2);
            if (lastIndexOf >= 0) {
                setRemovalBit(lastIndexOf);
            }
        }
    }

    /* renamed from: clone */
    public synchronized CallbackRegistry<C, T, A> m8clone() {
        CallbackRegistry<C, T, A> callbackRegistry;
        CloneNotSupportedException e2;
        try {
            callbackRegistry = (CallbackRegistry) super.clone();
        } catch (CloneNotSupportedException e3) {
            callbackRegistry = null;
            e2 = e3;
        }
        try {
            callbackRegistry.mFirst64Removed = 0L;
            callbackRegistry.mRemainderRemoved = null;
            callbackRegistry.mNotificationLevel = 0;
            callbackRegistry.mCallbacks = new ArrayList();
            int size = this.mCallbacks.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (!isRemoved(i2)) {
                    callbackRegistry.mCallbacks.add(this.mCallbacks.get(i2));
                }
            }
        } catch (CloneNotSupportedException e4) {
            e2 = e4;
            e2.printStackTrace();
            return callbackRegistry;
        }
        return callbackRegistry;
    }

    public synchronized void copyCallbacks(List<C> list) {
        list.clear();
        int size = this.mCallbacks.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!isRemoved(i2)) {
                list.add(this.mCallbacks.get(i2));
            }
        }
    }

    private void notifyCallbacks(T t, int i2, A a, int i3, int i4, long j2) {
        long j3 = 1;
        while (i3 < i4) {
            if ((j2 & j3) == 0) {
                this.mNotifier.onNotifyCallback(this.mCallbacks.get(i3), t, i2, a);
            }
            j3 <<= 1;
            i3++;
        }
    }
}
