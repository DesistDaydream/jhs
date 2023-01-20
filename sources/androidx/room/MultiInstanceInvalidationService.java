package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {
    public int mMaxClientId = 0;
    public final HashMap<Integer, String> mClientNames = new HashMap<>();
    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> mCallbackList = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() { // from class: androidx.room.MultiInstanceInvalidationService.1
        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(IMultiInstanceInvalidationCallback callback, Object cookie) {
            MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(((Integer) cookie).intValue()));
        }
    };
    private final IMultiInstanceInvalidationService.Stub mBinder = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService.2
        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int clientId, String[] tables) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                String str = MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(clientId));
                if (str == null) {
                    Log.w(Room.LOG_TAG, "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.mCallbackList.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    int intValue = ((Integer) MultiInstanceInvalidationService.this.mCallbackList.getBroadcastCookie(i2)).intValue();
                    String str2 = MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(intValue));
                    if (clientId != intValue && str.equals(str2)) {
                        try {
                            MultiInstanceInvalidationService.this.mCallbackList.getBroadcastItem(i2).onInvalidation(tables);
                        } catch (RemoteException e2) {
                            Log.w(Room.LOG_TAG, "Error invoking a remote callback", e2);
                        }
                    }
                }
                MultiInstanceInvalidationService.this.mCallbackList.finishBroadcast();
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback callback, String name) {
            if (name == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i2 = multiInstanceInvalidationService.mMaxClientId + 1;
                multiInstanceInvalidationService.mMaxClientId = i2;
                if (multiInstanceInvalidationService.mCallbackList.register(callback, Integer.valueOf(i2))) {
                    MultiInstanceInvalidationService.this.mClientNames.put(Integer.valueOf(i2), name);
                    return i2;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.mMaxClientId--;
                return 0;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback callback, int clientId) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                MultiInstanceInvalidationService.this.mCallbackList.unregister(callback);
                MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(clientId));
            }
        }
    };

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
