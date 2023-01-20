package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationClient {
    public final Context mAppContext;
    public int mClientId;
    public final Executor mExecutor;
    public final InvalidationTracker mInvalidationTracker;
    public final String mName;
    public final InvalidationTracker.Observer mObserver;
    public final Runnable mRemoveObserverRunnable;
    @Nullable
    public IMultiInstanceInvalidationService mService;
    public final ServiceConnection mServiceConnection;
    public final Runnable mSetUpRunnable;
    public final IMultiInstanceInvalidationCallback mCallback = new IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient.1
        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void onInvalidation(final String[] tables) {
            MultiInstanceInvalidationClient.this.mExecutor.execute(new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.1.1
                @Override // java.lang.Runnable
                public void run() {
                    MultiInstanceInvalidationClient.this.mInvalidationTracker.notifyObserversByTableNames(tables);
                }
            });
        }
    };
    public final AtomicBoolean mStopped = new AtomicBoolean(false);

    public MultiInstanceInvalidationClient(Context context, String name, InvalidationTracker invalidationTracker, Executor executor) {
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: androidx.room.MultiInstanceInvalidationClient.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name2, IBinder service) {
                MultiInstanceInvalidationClient.this.mService = IMultiInstanceInvalidationService.Stub.asInterface(service);
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.mExecutor.execute(multiInstanceInvalidationClient.mSetUpRunnable);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name2) {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.mExecutor.execute(multiInstanceInvalidationClient.mRemoveObserverRunnable);
                MultiInstanceInvalidationClient.this.mService = null;
            }
        };
        this.mServiceConnection = serviceConnection;
        this.mSetUpRunnable = new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.mService;
                    if (iMultiInstanceInvalidationService != null) {
                        multiInstanceInvalidationClient.mClientId = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.mCallback, multiInstanceInvalidationClient.mName);
                        MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = MultiInstanceInvalidationClient.this;
                        multiInstanceInvalidationClient2.mInvalidationTracker.addObserver(multiInstanceInvalidationClient2.mObserver);
                    }
                } catch (RemoteException e2) {
                    Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e2);
                }
            }
        };
        this.mRemoveObserverRunnable = new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.4
            @Override // java.lang.Runnable
            public void run() {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                multiInstanceInvalidationClient.mInvalidationTracker.removeObserver(multiInstanceInvalidationClient.mObserver);
            }
        };
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mName = name;
        this.mInvalidationTracker = invalidationTracker;
        this.mExecutor = executor;
        this.mObserver = new InvalidationTracker.Observer((String[]) invalidationTracker.mTableIdLookup.keySet().toArray(new String[0])) { // from class: androidx.room.MultiInstanceInvalidationClient.5
            @Override // androidx.room.InvalidationTracker.Observer
            public boolean isRemote() {
                return true;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@NonNull Set<String> tables) {
                if (MultiInstanceInvalidationClient.this.mStopped.get()) {
                    return;
                }
                try {
                    MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.mService;
                    if (iMultiInstanceInvalidationService != null) {
                        iMultiInstanceInvalidationService.broadcastInvalidation(multiInstanceInvalidationClient.mClientId, (String[]) tables.toArray(new String[0]));
                    }
                } catch (RemoteException e2) {
                    Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e2);
                }
            }
        };
        applicationContext.bindService(new Intent(applicationContext, MultiInstanceInvalidationService.class), serviceConnection, 1);
    }

    public void stop() {
        if (this.mStopped.compareAndSet(false, true)) {
            this.mInvalidationTracker.removeObserver(this.mObserver);
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.mService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.mCallback, this.mClientId);
                }
            } catch (RemoteException e2) {
                Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e2);
            }
            this.mAppContext.unbindService(this.mServiceConnection);
        }
    }
}
