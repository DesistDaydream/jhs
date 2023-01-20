package com.qiniu.android.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class SingleFlight<T> {
    private Map<String, SingleFlightCall<T>> callInfo = new HashMap();

    /* loaded from: classes3.dex */
    public interface ActionHandler<T> {
        void action(CompleteHandler<T> completeHandler) throws Exception;
    }

    /* loaded from: classes3.dex */
    public interface CompleteHandler<T> {
        void complete(T t);
    }

    /* loaded from: classes3.dex */
    public static class SingleFlightCall<T> {
        private Exception exception;
        private boolean isComplete;
        private List<SingleFlightTask<T>> tasks;
        private T value;

        private SingleFlightCall() {
            this.isComplete = false;
            this.tasks = new ArrayList();
        }
    }

    /* loaded from: classes3.dex */
    public static class SingleFlightTask<T> {
        private CompleteHandler<T> completeHandler;

        private SingleFlightTask() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void perform(final String str, ActionHandler<T> actionHandler, CompleteHandler<T> completeHandler) throws Exception {
        final SingleFlightCall<T> singleFlightCall;
        boolean z;
        if (actionHandler == null) {
            return;
        }
        boolean z2 = false;
        synchronized (this) {
            if (str != null) {
                try {
                    singleFlightCall = this.callInfo.get(str);
                } finally {
                }
            } else {
                singleFlightCall = null;
            }
            if (singleFlightCall == null) {
                singleFlightCall = new SingleFlightCall<>();
                if (str != null) {
                    this.callInfo.put(str, singleFlightCall);
                }
                z2 = true;
            }
            synchronized (singleFlightCall) {
                z = ((SingleFlightCall) singleFlightCall).isComplete;
                if (!z) {
                    SingleFlightTask singleFlightTask = new SingleFlightTask();
                    singleFlightTask.completeHandler = completeHandler;
                    ((SingleFlightCall) singleFlightCall).tasks.add(singleFlightTask);
                }
            }
        }
        if (z) {
            if (((SingleFlightCall) singleFlightCall).exception != null) {
                throw ((SingleFlightCall) singleFlightCall).exception;
            }
            if (completeHandler != 0) {
                completeHandler.complete(((SingleFlightCall) singleFlightCall).value);
            }
        } else if (z2) {
            try {
                actionHandler.action(new CompleteHandler<T>() { // from class: com.qiniu.android.utils.SingleFlight.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.qiniu.android.utils.SingleFlight.CompleteHandler
                    public void complete(T t) {
                        synchronized (singleFlightCall) {
                            if (singleFlightCall.isComplete) {
                                return;
                            }
                            singleFlightCall.isComplete = true;
                            singleFlightCall.value = t;
                            ArrayList<SingleFlightTask> arrayList = new ArrayList(singleFlightCall.tasks);
                            if (str != null) {
                                synchronized (this) {
                                    SingleFlight.this.callInfo.remove(str);
                                }
                            }
                            for (SingleFlightTask singleFlightTask2 : arrayList) {
                                if (singleFlightTask2 != null && singleFlightTask2.completeHandler != null) {
                                    singleFlightTask2.completeHandler.complete(singleFlightCall.value);
                                }
                            }
                        }
                    }
                });
            } catch (Exception e2) {
                synchronized (singleFlightCall) {
                    if (((SingleFlightCall) singleFlightCall).isComplete) {
                        return;
                    }
                    ((SingleFlightCall) singleFlightCall).isComplete = true;
                    ((SingleFlightCall) singleFlightCall).exception = e2;
                    ArrayList<SingleFlightTask> arrayList = new ArrayList(((SingleFlightCall) singleFlightCall).tasks);
                    if (str != null) {
                        synchronized (this) {
                            this.callInfo.remove(str);
                        }
                    }
                    for (SingleFlightTask singleFlightTask2 : arrayList) {
                        if (singleFlightTask2 != null && singleFlightTask2.completeHandler != null) {
                            throw ((SingleFlightCall) singleFlightCall).exception;
                        }
                    }
                }
            }
        }
    }
}
