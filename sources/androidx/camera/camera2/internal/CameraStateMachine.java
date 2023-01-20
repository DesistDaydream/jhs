package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraState;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.Objects;

@RequiresApi(21)
/* loaded from: classes.dex */
public class CameraStateMachine {
    private static final String TAG = "CameraStateMachine";
    @NonNull
    private final CameraStateRegistry mCameraStateRegistry;
    @NonNull
    private final MutableLiveData<CameraState> mCameraStates;

    /* renamed from: androidx.camera.camera2.internal.CameraStateMachine$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$CameraInternal$State;

        static {
            int[] iArr = new int[CameraInternal.State.values().length];
            $SwitchMap$androidx$camera$core$impl$CameraInternal$State = iArr;
            try {
                iArr[CameraInternal.State.PENDING_OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.OPENING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.RELEASING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.CLOSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.RELEASED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public CameraStateMachine(@NonNull CameraStateRegistry cameraStateRegistry) {
        this.mCameraStateRegistry = cameraStateRegistry;
        MutableLiveData<CameraState> mutableLiveData = new MutableLiveData<>();
        this.mCameraStates = mutableLiveData;
        mutableLiveData.postValue(CameraState.create(CameraState.Type.CLOSED));
    }

    private CameraState onCameraPendingOpen() {
        return this.mCameraStateRegistry.isCameraClosing() ? CameraState.create(CameraState.Type.OPENING) : CameraState.create(CameraState.Type.PENDING_OPEN);
    }

    @NonNull
    public LiveData<CameraState> getStateLiveData() {
        return this.mCameraStates;
    }

    public void updateState(@NonNull CameraInternal.State state, @Nullable CameraState.StateError stateError) {
        CameraState onCameraPendingOpen;
        switch (AnonymousClass1.$SwitchMap$androidx$camera$core$impl$CameraInternal$State[state.ordinal()]) {
            case 1:
                onCameraPendingOpen = onCameraPendingOpen();
                break;
            case 2:
                onCameraPendingOpen = CameraState.create(CameraState.Type.OPENING, stateError);
                break;
            case 3:
                onCameraPendingOpen = CameraState.create(CameraState.Type.OPEN, stateError);
                break;
            case 4:
            case 5:
                onCameraPendingOpen = CameraState.create(CameraState.Type.CLOSING, stateError);
                break;
            case 6:
            case 7:
                onCameraPendingOpen = CameraState.create(CameraState.Type.CLOSED, stateError);
                break;
            default:
                throw new IllegalStateException("Unknown internal camera state: " + state);
        }
        Logger.d(TAG, "New public camera state " + onCameraPendingOpen + " from " + state + " and " + stateError);
        if (Objects.equals(this.mCameraStates.getValue(), onCameraPendingOpen)) {
            return;
        }
        Logger.d(TAG, "Publishing new public camera state " + onCameraPendingOpen);
        this.mCameraStates.postValue(onCameraPendingOpen);
    }
}
