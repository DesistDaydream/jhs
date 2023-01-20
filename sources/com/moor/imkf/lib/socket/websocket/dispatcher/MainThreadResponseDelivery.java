package com.moor.imkf.lib.socket.websocket.dispatcher;

import android.text.TextUtils;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.websocket.SocketListener;
import com.moor.imkf.lib.socket.websocket.response.ErrorResponse;
import com.moor.imkf.lib.socket.websocket.util.ThreadUtil;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes2.dex */
public class MainThreadResponseDelivery implements ResponseDelivery {
    private static final Object LISTENER_BLOCK = new Object();
    private static Queue<CallbackRunnable> RUNNABLE_POOL;
    private final List<SocketListener> mSocketListenerList = new ArrayList();

    /* renamed from: com.moor.imkf.lib.socket.websocket.dispatcher.MainThreadResponseDelivery$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$moor$imkf$lib$socket$websocket$dispatcher$MainThreadResponseDelivery$RUNNABLE_TYPE;

        static {
            int[] iArr = new int[RUNNABLE_TYPE.values().length];
            $SwitchMap$com$moor$imkf$lib$socket$websocket$dispatcher$MainThreadResponseDelivery$RUNNABLE_TYPE = iArr;
            try {
                iArr[RUNNABLE_TYPE.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$socket$websocket$dispatcher$MainThreadResponseDelivery$RUNNABLE_TYPE[RUNNABLE_TYPE.CONNECT_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$socket$websocket$dispatcher$MainThreadResponseDelivery$RUNNABLE_TYPE[RUNNABLE_TYPE.DISCONNECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$socket$websocket$dispatcher$MainThreadResponseDelivery$RUNNABLE_TYPE[RUNNABLE_TYPE.SEND_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$socket$websocket$dispatcher$MainThreadResponseDelivery$RUNNABLE_TYPE[RUNNABLE_TYPE.STRING_MSG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$socket$websocket$dispatcher$MainThreadResponseDelivery$RUNNABLE_TYPE[RUNNABLE_TYPE.BYTE_BUFFER_MSG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$socket$websocket$dispatcher$MainThreadResponseDelivery$RUNNABLE_TYPE[RUNNABLE_TYPE.PING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$socket$websocket$dispatcher$MainThreadResponseDelivery$RUNNABLE_TYPE[RUNNABLE_TYPE.PONG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum RUNNABLE_TYPE {
        NON,
        CONNECTED,
        CONNECT_FAILED,
        DISCONNECT,
        SEND_ERROR,
        STRING_MSG,
        BYTE_BUFFER_MSG,
        PING,
        PONG
    }

    private CallbackRunnable getRunnable() {
        if (RUNNABLE_POOL == null) {
            RUNNABLE_POOL = new ArrayDeque(5);
        }
        CallbackRunnable poll = RUNNABLE_POOL.poll();
        return poll == null ? new CallbackRunnable(null) : poll;
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.ResponseDelivery
    public void addListener(SocketListener socketListener) {
        if (socketListener == null || this.mSocketListenerList.contains(socketListener)) {
            return;
        }
        synchronized (LISTENER_BLOCK) {
            this.mSocketListenerList.add(socketListener);
        }
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.ResponseDelivery
    public void clear() {
        if (this.mSocketListenerList.isEmpty()) {
            return;
        }
        synchronized (LISTENER_BLOCK) {
            this.mSocketListenerList.clear();
        }
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.ResponseDelivery
    public boolean isEmpty() {
        return this.mSocketListenerList.isEmpty();
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onConnectFailed(Throwable th) {
        if (isEmpty()) {
            return;
        }
        if (ThreadUtil.checkMainThread()) {
            synchronized (LISTENER_BLOCK) {
                for (SocketListener socketListener : this.mSocketListenerList) {
                    socketListener.onConnectFailed(th);
                }
            }
            return;
        }
        CallbackRunnable runnable = getRunnable();
        runnable.type = RUNNABLE_TYPE.CONNECT_FAILED;
        runnable.connectErrorCause = th;
        runnable.mSocketListenerList = this.mSocketListenerList;
        ThreadUtil.runOnMainThread(runnable);
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onConnected() {
        if (isEmpty()) {
            return;
        }
        if (ThreadUtil.checkMainThread()) {
            synchronized (LISTENER_BLOCK) {
                for (SocketListener socketListener : this.mSocketListenerList) {
                    socketListener.onConnected();
                }
            }
            return;
        }
        CallbackRunnable runnable = getRunnable();
        runnable.type = RUNNABLE_TYPE.CONNECTED;
        runnable.mSocketListenerList = this.mSocketListenerList;
        ThreadUtil.runOnMainThread(runnable);
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onDisconnect() {
        if (isEmpty()) {
            return;
        }
        if (ThreadUtil.checkMainThread()) {
            synchronized (LISTENER_BLOCK) {
                for (SocketListener socketListener : this.mSocketListenerList) {
                    socketListener.onDisconnect();
                }
            }
            return;
        }
        CallbackRunnable runnable = getRunnable();
        runnable.type = RUNNABLE_TYPE.DISCONNECT;
        runnable.mSocketListenerList = this.mSocketListenerList;
        ThreadUtil.runOnMainThread(runnable);
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public <T> void onMessage(String str, T t) {
        if (isEmpty() || str == null) {
            return;
        }
        if (ThreadUtil.checkMainThread()) {
            synchronized (LISTENER_BLOCK) {
                for (SocketListener socketListener : this.mSocketListenerList) {
                    socketListener.onMessage(str, (String) t);
                }
            }
            return;
        }
        CallbackRunnable runnable = getRunnable();
        runnable.type = RUNNABLE_TYPE.STRING_MSG;
        runnable.textResponse = str;
        runnable.formattedData = t;
        runnable.mSocketListenerList = this.mSocketListenerList;
        ThreadUtil.runOnMainThread(runnable);
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onPing(Framedata framedata) {
        if (isEmpty()) {
            return;
        }
        if (ThreadUtil.checkMainThread()) {
            synchronized (LISTENER_BLOCK) {
                for (SocketListener socketListener : this.mSocketListenerList) {
                    socketListener.onPing(framedata);
                }
            }
            return;
        }
        CallbackRunnable runnable = getRunnable();
        runnable.type = RUNNABLE_TYPE.PING;
        runnable.framedataResponse = framedata;
        runnable.mSocketListenerList = this.mSocketListenerList;
        ThreadUtil.runOnMainThread(runnable);
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onPong(Framedata framedata) {
        if (isEmpty()) {
            return;
        }
        if (ThreadUtil.checkMainThread()) {
            synchronized (LISTENER_BLOCK) {
                for (SocketListener socketListener : this.mSocketListenerList) {
                    socketListener.onPong(framedata);
                }
            }
            return;
        }
        CallbackRunnable runnable = getRunnable();
        runnable.type = RUNNABLE_TYPE.PONG;
        runnable.framedataResponse = framedata;
        runnable.mSocketListenerList = this.mSocketListenerList;
        ThreadUtil.runOnMainThread(runnable);
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onSendDataError(ErrorResponse errorResponse) {
        if (isEmpty() || errorResponse == null) {
            return;
        }
        if (ThreadUtil.checkMainThread()) {
            synchronized (LISTENER_BLOCK) {
                for (SocketListener socketListener : this.mSocketListenerList) {
                    socketListener.onSendDataError(errorResponse);
                }
            }
            return;
        }
        CallbackRunnable runnable = getRunnable();
        runnable.type = RUNNABLE_TYPE.SEND_ERROR;
        runnable.errorResponse = errorResponse;
        runnable.mSocketListenerList = this.mSocketListenerList;
        ThreadUtil.runOnMainThread(runnable);
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.ResponseDelivery
    public void removeListener(SocketListener socketListener) {
        if (socketListener == null || isEmpty() || !this.mSocketListenerList.contains(socketListener)) {
            return;
        }
        synchronized (LISTENER_BLOCK) {
            this.mSocketListenerList.remove(socketListener);
        }
    }

    /* loaded from: classes2.dex */
    public static class CallbackRunnable<T> implements Runnable {
        public ByteBuffer byteResponse;
        public Throwable connectErrorCause;
        public ErrorResponse errorResponse;
        public T formattedData;
        public Framedata framedataResponse;
        public List<SocketListener> mSocketListenerList;
        public String textResponse;
        public RUNNABLE_TYPE type;

        private CallbackRunnable() {
            this.type = RUNNABLE_TYPE.NON;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<SocketListener> list;
            RUNNABLE_TYPE runnable_type;
            RUNNABLE_TYPE runnable_type2;
            try {
                if (this.type != RUNNABLE_TYPE.NON && (list = this.mSocketListenerList) != null && !list.isEmpty() && (((runnable_type = this.type) != RUNNABLE_TYPE.CONNECT_FAILED || this.connectErrorCause != null) && ((runnable_type != RUNNABLE_TYPE.SEND_ERROR || this.errorResponse != null) && ((runnable_type != RUNNABLE_TYPE.STRING_MSG || !TextUtils.isEmpty(this.textResponse)) && (((runnable_type2 = this.type) != RUNNABLE_TYPE.BYTE_BUFFER_MSG || this.byteResponse != null) && ((runnable_type2 != RUNNABLE_TYPE.PING || this.framedataResponse != null) && (runnable_type2 != RUNNABLE_TYPE.PONG || this.framedataResponse != null))))))) {
                    synchronized (MainThreadResponseDelivery.LISTENER_BLOCK) {
                        switch (AnonymousClass1.$SwitchMap$com$moor$imkf$lib$socket$websocket$dispatcher$MainThreadResponseDelivery$RUNNABLE_TYPE[this.type.ordinal()]) {
                            case 1:
                                for (SocketListener socketListener : this.mSocketListenerList) {
                                    socketListener.onConnected();
                                }
                                break;
                            case 2:
                                for (SocketListener socketListener2 : this.mSocketListenerList) {
                                    socketListener2.onConnectFailed(this.connectErrorCause);
                                }
                                break;
                            case 3:
                                for (SocketListener socketListener3 : this.mSocketListenerList) {
                                    socketListener3.onDisconnect();
                                }
                                break;
                            case 4:
                                for (SocketListener socketListener4 : this.mSocketListenerList) {
                                    socketListener4.onSendDataError(this.errorResponse);
                                }
                                break;
                            case 5:
                                for (SocketListener socketListener5 : this.mSocketListenerList) {
                                    socketListener5.onMessage(this.textResponse, (String) this.formattedData);
                                }
                                break;
                            case 6:
                                for (SocketListener socketListener6 : this.mSocketListenerList) {
                                    socketListener6.onMessage(this.byteResponse, (ByteBuffer) this.formattedData);
                                }
                                break;
                            case 7:
                                for (SocketListener socketListener7 : this.mSocketListenerList) {
                                    socketListener7.onPing(this.framedataResponse);
                                }
                                break;
                            case 8:
                                for (SocketListener socketListener8 : this.mSocketListenerList) {
                                    socketListener8.onPong(this.framedataResponse);
                                }
                                break;
                        }
                        this.mSocketListenerList = null;
                        this.errorResponse = null;
                        this.connectErrorCause = null;
                        this.textResponse = null;
                        this.byteResponse = null;
                        this.framedataResponse = null;
                        this.formattedData = null;
                    }
                }
            } finally {
                MainThreadResponseDelivery.RUNNABLE_POOL.offer(this);
            }
        }

        public /* synthetic */ CallbackRunnable(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public <T> void onMessage(ByteBuffer byteBuffer, T t) {
        if (isEmpty() || byteBuffer == null) {
            return;
        }
        if (ThreadUtil.checkMainThread()) {
            synchronized (LISTENER_BLOCK) {
                for (SocketListener socketListener : this.mSocketListenerList) {
                    socketListener.onMessage(byteBuffer, (ByteBuffer) t);
                }
            }
            return;
        }
        CallbackRunnable runnable = getRunnable();
        runnable.type = RUNNABLE_TYPE.BYTE_BUFFER_MSG;
        runnable.byteResponse = byteBuffer;
        runnable.formattedData = t;
        runnable.mSocketListenerList = this.mSocketListenerList;
        ThreadUtil.runOnMainThread(runnable);
    }
}
