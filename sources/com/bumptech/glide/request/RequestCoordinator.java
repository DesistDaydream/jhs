package com.bumptech.glide.request;

import e.b.a.t.e;

/* loaded from: classes.dex */
public interface RequestCoordinator {

    /* loaded from: classes.dex */
    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        
        private final boolean isComplete;

        RequestState(boolean z) {
            this.isComplete = z;
        }

        public boolean isComplete() {
            return this.isComplete;
        }
    }

    boolean a();

    boolean b(e eVar);

    boolean c(e eVar);

    void e(e eVar);

    void g(e eVar);

    RequestCoordinator getRoot();

    boolean i(e eVar);
}
