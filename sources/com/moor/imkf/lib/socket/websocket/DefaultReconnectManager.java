package com.moor.imkf.lib.socket.websocket;

import com.moor.imkf.lib.socket.MoorWsManager;
import com.moor.imkf.lib.socket.websocket.ReconnectManager;
import com.moor.imkf.lib.utils.MoorLogUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes2.dex */
public class DefaultReconnectManager implements ReconnectManager {
    private static final String TAG = "WSDefaultRM";
    private ReconnectManager.OnConnectListener mOnDisconnectListener;
    private WebSocketManager mWebSocketManager;
    private long delayTime = 5000;
    private final Object BLOCK = new Object();
    private volatile boolean needStopReconnect = false;
    private volatile boolean connected = false;
    private final ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    private int reconnectCount = 1;
    private int finishCount = 1;
    private volatile boolean reconnecting = false;
    private volatile boolean destroyed = false;

    public DefaultReconnectManager(WebSocketManager webSocketManager, ReconnectManager.OnConnectListener onConnectListener) {
        this.mWebSocketManager = webSocketManager;
        this.mOnDisconnectListener = onConnectListener;
    }

    public static /* synthetic */ int access$308(DefaultReconnectManager defaultReconnectManager) {
        int i2 = defaultReconnectManager.reconnectCount;
        defaultReconnectManager.reconnectCount = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int access$908(DefaultReconnectManager defaultReconnectManager) {
        int i2 = defaultReconnectManager.finishCount;
        defaultReconnectManager.finishCount = i2 + 1;
        return i2;
    }

    private Runnable getReconnectRunnable() {
        if (this.mOnDisconnectListener == null) {
            return null;
        }
        return new Runnable() { // from class: com.moor.imkf.lib.socket.websocket.DefaultReconnectManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (DefaultReconnectManager.this.destroyed || DefaultReconnectManager.this.needStopReconnect) {
                    DefaultReconnectManager.this.reconnecting = false;
                    return;
                }
                MoorWsManager.getInstance().setSocketConnectStatus(false);
                MoorLogUtils.d(DefaultReconnectManager.TAG, "开始重连:" + DefaultReconnectManager.this.reconnectCount);
                DefaultReconnectManager.access$308(DefaultReconnectManager.this);
                DefaultReconnectManager.this.reconnecting = true;
                DefaultReconnectManager.this.connected = false;
                try {
                    try {
                        int reconnectFrequency = DefaultReconnectManager.this.mWebSocketManager.getSetting().getReconnectFrequency();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= reconnectFrequency) {
                                break;
                            }
                            if (DefaultReconnectManager.this.reconnectCount != 2) {
                                Thread.sleep(DefaultReconnectManager.this.delayTime);
                            }
                            i2++;
                            MoorLogUtils.d(DefaultReconnectManager.TAG, String.format("for第%s次重连", Integer.valueOf(i2)));
                            DefaultReconnectManager.this.mWebSocketManager.reconnectOnce();
                            synchronized (DefaultReconnectManager.this.BLOCK) {
                                try {
                                    DefaultReconnectManager.this.BLOCK.wait(DefaultReconnectManager.this.mWebSocketManager.getSetting().getConnectTimeout());
                                    if (!DefaultReconnectManager.this.connected) {
                                        if (DefaultReconnectManager.this.needStopReconnect) {
                                        }
                                    } else {
                                        MoorWsManager.getInstance().setSocketConnectStatus(true);
                                        MoorLogUtils.d(DefaultReconnectManager.TAG, "reconnectOnce success!");
                                        DefaultReconnectManager.this.mOnDisconnectListener.onConnected();
                                        MoorLogUtils.d(DefaultReconnectManager.TAG, "重连结束:" + DefaultReconnectManager.this.finishCount);
                                        DefaultReconnectManager.access$908(DefaultReconnectManager.this);
                                        DefaultReconnectManager.this.reconnecting = false;
                                        MoorLogUtils.d(DefaultReconnectManager.TAG, "reconnecting = false");
                                        return;
                                    }
                                } catch (InterruptedException unused) {
                                } finally {
                                }
                            }
                        }
                        MoorLogUtils.d(DefaultReconnectManager.TAG, "reconnectOnce failed!");
                        if (DefaultReconnectManager.this.mOnDisconnectListener != null) {
                            DefaultReconnectManager.this.mOnDisconnectListener.onDisconnect();
                        }
                        MoorLogUtils.d(DefaultReconnectManager.TAG, "重连结束:" + DefaultReconnectManager.this.finishCount);
                        DefaultReconnectManager.access$908(DefaultReconnectManager.this);
                        DefaultReconnectManager.this.reconnecting = false;
                        MoorLogUtils.d(DefaultReconnectManager.TAG, "reconnecting = false");
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        MoorLogUtils.d(DefaultReconnectManager.TAG, "重连结束:" + DefaultReconnectManager.this.finishCount);
                        DefaultReconnectManager.access$908(DefaultReconnectManager.this);
                        DefaultReconnectManager.this.reconnecting = false;
                        MoorLogUtils.d(DefaultReconnectManager.TAG, "reconnecting = false");
                    }
                } catch (Throwable th) {
                    MoorLogUtils.d(DefaultReconnectManager.TAG, "重连结束:" + DefaultReconnectManager.this.finishCount);
                    DefaultReconnectManager.access$908(DefaultReconnectManager.this);
                    DefaultReconnectManager.this.reconnecting = false;
                    MoorLogUtils.d(DefaultReconnectManager.TAG, "reconnecting = false");
                    throw th;
                }
            }
        };
    }

    @Override // com.moor.imkf.lib.socket.websocket.ReconnectManager
    public void destroy() {
        this.destroyed = true;
        stopReconnect();
        this.mWebSocketManager = null;
    }

    @Override // com.moor.imkf.lib.socket.websocket.ReconnectManager
    public void onConnectError(Throwable th) {
        this.connected = false;
        synchronized (this.BLOCK) {
            MoorLogUtils.d(TAG, "onConnectError(Throwable)->BLOCK.notifyAll()");
            this.BLOCK.notifyAll();
        }
    }

    @Override // com.moor.imkf.lib.socket.websocket.ReconnectManager
    public void onConnected() {
        this.connected = true;
        synchronized (this.BLOCK) {
            MoorLogUtils.d(TAG, "onConnected()->BLOCK.notifyAll()");
            this.BLOCK.notifyAll();
        }
    }

    @Override // com.moor.imkf.lib.socket.websocket.ReconnectManager
    public boolean reconnecting() {
        return this.reconnecting;
    }

    @Override // com.moor.imkf.lib.socket.websocket.ReconnectManager
    public void startReconnect() {
        if (this.reconnecting) {
            MoorLogUtils.d(TAG, "Reconnecting, do not call again.");
        } else if (this.destroyed) {
            MoorLogUtils.d(TAG, "ReconnectManager is destroyed!!!");
        } else {
            this.needStopReconnect = false;
            this.reconnecting = true;
            try {
                this.singleThreadPool.execute(getReconnectRunnable());
            } catch (RejectedExecutionException e2) {
                MoorLogUtils.d(TAG, "线程队列已满，无法执行此次任务。", e2);
                this.reconnecting = false;
            }
        }
    }

    @Override // com.moor.imkf.lib.socket.websocket.ReconnectManager
    public void stopReconnect() {
        this.needStopReconnect = true;
        ExecutorService executorService = this.singleThreadPool;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }
}
