package com.moor.imkf.lib.socket.websocket.dispatcher;

import android.os.Process;
import com.moor.imkf.lib.socket.websocket.dispatcher.ResponseProcessEngine;
import com.moor.imkf.lib.utils.MoorLogUtils;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class EngineThread extends Thread {
    private ExecutorService executorService;
    private boolean stop;
    private String TAG = "WSEngineThread";
    private ArrayBlockingQueue<ResponseProcessEngine.EngineEntity> jobQueue = new ArrayBlockingQueue<>(10);

    public void add(final ResponseProcessEngine.EngineEntity engineEntity) {
        if (this.jobQueue.offer(engineEntity)) {
            return;
        }
        MoorLogUtils.d(this.TAG, "Offer response to Engine failed!start an thread to put.");
        if (this.executorService == null) {
            this.executorService = Executors.newCachedThreadPool();
        }
        this.executorService.execute(new Runnable() { // from class: com.moor.imkf.lib.socket.websocket.dispatcher.EngineThread.1
            @Override // java.lang.Runnable
            public void run() {
                if (EngineThread.this.stop) {
                    return;
                }
                try {
                    EngineThread.this.jobQueue.put(engineEntity);
                } catch (Exception e2) {
                    if (EngineThread.this.stop) {
                        MoorLogUtils.d(EngineThread.this.TAG, "put response failed!", e2);
                    } else {
                        EngineThread.this.interrupt();
                    }
                }
            }
        });
    }

    public void quit() {
        this.stop = true;
        this.jobQueue.clear();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Process.setThreadPriority(10);
        while (!this.stop) {
            try {
                ResponseProcessEngine.EngineEntity take = this.jobQueue.take();
                if (take.isError) {
                    take.dispatcher.onSendDataError(take.errorResponse, take.delivery);
                } else {
                    take.response.onResponse(take.dispatcher, take.delivery);
                }
                ResponseProcessEngine.EngineEntity.release(take);
            } catch (InterruptedException unused) {
                if (this.stop) {
                    return;
                }
            } catch (Exception e2) {
                MoorLogUtils.d(this.TAG, "run()->Exception", e2);
            }
        }
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        this.stop = false;
        super.start();
    }
}
