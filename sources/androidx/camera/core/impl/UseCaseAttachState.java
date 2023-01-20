package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.SessionConfig;
import c.b.b.b2.t;
import c.b.b.b2.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class UseCaseAttachState {
    private static final String TAG = "UseCaseAttachState";
    private final Map<String, UseCaseAttachInfo> mAttachedUseCasesToInfoMap = new LinkedHashMap();
    private final String mCameraId;

    /* loaded from: classes.dex */
    public interface AttachStateFilter {
        boolean filter(UseCaseAttachInfo useCaseAttachInfo);
    }

    /* loaded from: classes.dex */
    public static final class UseCaseAttachInfo {
        @NonNull
        private final SessionConfig mSessionConfig;
        private boolean mAttached = false;
        private boolean mActive = false;

        public UseCaseAttachInfo(@NonNull SessionConfig sessionConfig) {
            this.mSessionConfig = sessionConfig;
        }

        public boolean getActive() {
            return this.mActive;
        }

        public boolean getAttached() {
            return this.mAttached;
        }

        @NonNull
        public SessionConfig getSessionConfig() {
            return this.mSessionConfig;
        }

        public void setActive(boolean z) {
            this.mActive = z;
        }

        public void setAttached(boolean z) {
            this.mAttached = z;
        }
    }

    public UseCaseAttachState(@NonNull String str) {
        this.mCameraId = str;
    }

    public static /* synthetic */ boolean a(UseCaseAttachInfo useCaseAttachInfo) {
        return useCaseAttachInfo.getActive() && useCaseAttachInfo.getAttached();
    }

    private UseCaseAttachInfo getOrCreateUseCaseAttachInfo(@NonNull String str, @NonNull SessionConfig sessionConfig) {
        UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
        if (useCaseAttachInfo == null) {
            UseCaseAttachInfo useCaseAttachInfo2 = new UseCaseAttachInfo(sessionConfig);
            this.mAttachedUseCasesToInfoMap.put(str, useCaseAttachInfo2);
            return useCaseAttachInfo2;
        }
        return useCaseAttachInfo;
    }

    private Collection<SessionConfig> getSessionConfigs(AttachStateFilter attachStateFilter) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            if (attachStateFilter == null || attachStateFilter.filter(entry.getValue())) {
                arrayList.add(entry.getValue().getSessionConfig());
            }
        }
        return arrayList;
    }

    @NonNull
    public SessionConfig.ValidatingBuilder getActiveAndAttachedBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo value = entry.getValue();
            if (value.getActive() && value.getAttached()) {
                validatingBuilder.add(value.getSessionConfig());
                arrayList.add(entry.getKey());
            }
        }
        Logger.d(TAG, "Active and attached use case: " + arrayList + " for camera: " + this.mCameraId);
        return validatingBuilder;
    }

    @NonNull
    public Collection<SessionConfig> getActiveAndAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(u.a));
    }

    @NonNull
    public SessionConfig.ValidatingBuilder getAttachedBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo value = entry.getValue();
            if (value.getAttached()) {
                validatingBuilder.add(value.getSessionConfig());
                arrayList.add(entry.getKey());
            }
        }
        Logger.d(TAG, "All use case: " + arrayList + " for camera: " + this.mCameraId);
        return validatingBuilder;
    }

    @NonNull
    public Collection<SessionConfig> getAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(t.a));
    }

    public boolean isUseCaseAttached(@NonNull String str) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            return this.mAttachedUseCasesToInfoMap.get(str).getAttached();
        }
        return false;
    }

    public void removeUseCase(@NonNull String str) {
        this.mAttachedUseCasesToInfoMap.remove(str);
    }

    public void setUseCaseActive(@NonNull String str, @NonNull SessionConfig sessionConfig) {
        getOrCreateUseCaseAttachInfo(str, sessionConfig).setActive(true);
    }

    public void setUseCaseAttached(@NonNull String str, @NonNull SessionConfig sessionConfig) {
        getOrCreateUseCaseAttachInfo(str, sessionConfig).setAttached(true);
    }

    public void setUseCaseDetached(@NonNull String str) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setAttached(false);
            if (useCaseAttachInfo.getActive()) {
                return;
            }
            this.mAttachedUseCasesToInfoMap.remove(str);
        }
    }

    public void setUseCaseInactive(@NonNull String str) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setActive(false);
            if (useCaseAttachInfo.getAttached()) {
                return;
            }
            this.mAttachedUseCasesToInfoMap.remove(str);
        }
    }

    public void updateUseCase(@NonNull String str, @NonNull SessionConfig sessionConfig) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = new UseCaseAttachInfo(sessionConfig);
            UseCaseAttachInfo useCaseAttachInfo2 = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setAttached(useCaseAttachInfo2.getAttached());
            useCaseAttachInfo.setActive(useCaseAttachInfo2.getActive());
            this.mAttachedUseCasesToInfoMap.put(str, useCaseAttachInfo);
        }
    }
}
