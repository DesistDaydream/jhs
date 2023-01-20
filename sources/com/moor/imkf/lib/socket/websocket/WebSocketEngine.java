package com.moor.imkf.lib.socket.websocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.moor.imkf.lib.socket.websocket.request.Request;
import com.moor.imkf.lib.utils.MoorLogUtils;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public class WebSocketEngine {
    private static final String TAG = "WSWebSocketEngine";
    private OptionThread mOptionThread;

    /* loaded from: classes2.dex */
    public static class OptionHandler extends Handler {
        private static final int QUIT = 1;

        private OptionHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* loaded from: classes2.dex */
    public class OptionThread extends Thread {
        private OptionHandler mHandler;

        private OptionThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            Looper.prepare();
            this.mHandler = new OptionHandler();
            Looper.loop();
        }
    }

    /* loaded from: classes2.dex */
    public static class ReRunnable implements Runnable {
        private static Queue<ReRunnable> POOL = new ArrayDeque(10);
        private Request request;
        private int type;
        private WebSocketWrapper webSocketWrapper;

        private ReRunnable() {
        }

        public static ReRunnable obtain() {
            ReRunnable poll = POOL.poll();
            return poll == null ? new ReRunnable() : poll;
        }

        public void release() {
            POOL.offer(this);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.moor.imkf.lib.socket.websocket.WebSocketWrapper, com.moor.imkf.lib.socket.websocket.request.Request] */
        @Override // java.lang.Runnable
        public void run() {
            int i2;
            try {
                WebSocketWrapper webSocketWrapper = this.webSocketWrapper;
                if (webSocketWrapper != null && ((i2 = this.type) != 0 || this.request != null)) {
                    if (i2 == 0) {
                        webSocketWrapper.send(this.request);
                    } else if (i2 == 1) {
                        webSocketWrapper.reconnect();
                    } else if (i2 == 2) {
                        webSocketWrapper.disConnect();
                    } else if (i2 == 3) {
                        webSocketWrapper.destroy();
                    }
                }
            } finally {
                this.webSocketWrapper = null;
                this.request = null;
                release();
            }
        }
    }

    public WebSocketEngine() {
        OptionThread optionThread = new OptionThread();
        this.mOptionThread = optionThread;
        optionThread.start();
    }

    public void connect(WebSocketWrapper webSocketWrapper, SocketWrapperListener socketWrapperListener) {
        if (this.mOptionThread.mHandler == null) {
            socketWrapperListener.onConnectFailed(new Exception("WebSocketEngine not start!"));
            return;
        }
        ReRunnable obtain = ReRunnable.obtain();
        obtain.type = 1;
        obtain.webSocketWrapper = webSocketWrapper;
        this.mOptionThread.mHandler.post(obtain);
    }

    public void destroy() {
        OptionThread optionThread = this.mOptionThread;
        if (optionThread == null || optionThread.mHandler == null) {
            return;
        }
        this.mOptionThread.mHandler.sendEmptyMessage(1);
    }

    public void destroyWebSocket(WebSocketWrapper webSocketWrapper) {
        if (this.mOptionThread.mHandler != null) {
            ReRunnable obtain = ReRunnable.obtain();
            obtain.type = 3;
            obtain.webSocketWrapper = webSocketWrapper;
            this.mOptionThread.mHandler.post(obtain);
            return;
        }
        MoorLogUtils.d(TAG, "WebSocketEngine not start!");
    }

    public void disConnect(WebSocketWrapper webSocketWrapper, SocketWrapperListener socketWrapperListener) {
        if (this.mOptionThread.mHandler != null) {
            ReRunnable obtain = ReRunnable.obtain();
            obtain.type = 2;
            obtain.webSocketWrapper = webSocketWrapper;
            this.mOptionThread.mHandler.post(obtain);
            return;
        }
        MoorLogUtils.d(TAG, "WebSocketEngine not start!");
    }

    public void sendRequest(WebSocketWrapper webSocketWrapper, Request request, SocketWrapperListener socketWrapperListener) {
        if (this.mOptionThread.mHandler == null) {
            socketWrapperListener.onSendDataError(request, 2, null);
            return;
        }
        ReRunnable obtain = ReRunnable.obtain();
        obtain.type = 0;
        obtain.request = request;
        obtain.webSocketWrapper = webSocketWrapper;
        this.mOptionThread.mHandler.post(obtain);
    }
}
