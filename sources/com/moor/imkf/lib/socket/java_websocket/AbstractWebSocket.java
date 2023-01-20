package com.moor.imkf.lib.socket.java_websocket;

import com.moor.imkf.lib.socket.java_websocket.logger.Logger;
import com.moor.imkf.lib.socket.java_websocket.logger.LoggerFactory;
import com.moor.imkf.lib.socket.java_websocket.util.NamedThreadFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class AbstractWebSocket extends WebSocketAdapter {
    private ScheduledFuture connectionLostCheckerFuture;
    private ScheduledExecutorService connectionLostCheckerService;
    private boolean reuseAddr;
    private boolean tcpNoDelay;
    private final Logger log = LoggerFactory.getLogger(AbstractWebSocket.class);
    private long connectionLostTimeout = TimeUnit.SECONDS.toNanos(60);
    private boolean websocketRunning = false;
    private final Object syncConnectionLost = new Object();

    private void cancelConnectionLostTimer() {
        ScheduledExecutorService scheduledExecutorService = this.connectionLostCheckerService;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.connectionLostCheckerService = null;
        }
        ScheduledFuture scheduledFuture = this.connectionLostCheckerFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.connectionLostCheckerFuture = null;
        }
    }

    public void executeConnectionLostDetection(WebSocket webSocket, long j2) {
        if (webSocket instanceof WebSocketImpl) {
            WebSocketImpl webSocketImpl = (WebSocketImpl) webSocket;
            if (webSocketImpl.getLastPong() < j2) {
                this.log.trace("Closing connection due to no pong received: {}", webSocketImpl);
                webSocketImpl.closeConnection(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
            } else if (webSocketImpl.isOpen()) {
                webSocketImpl.sendPing();
            } else {
                this.log.trace("Trying to ping a non open connection: {}", webSocketImpl);
            }
        }
    }

    private void restartConnectionLostTimer() {
        cancelConnectionLostTimer();
        this.connectionLostCheckerService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("connectionLostChecker"));
        Runnable runnable = new Runnable() { // from class: com.moor.imkf.lib.socket.java_websocket.AbstractWebSocket.1
            private ArrayList<WebSocket> connections = new ArrayList<>();

            {
                AbstractWebSocket.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.connections.clear();
                try {
                    this.connections.addAll(AbstractWebSocket.this.getConnections());
                    long nanoTime = (long) (System.nanoTime() - (AbstractWebSocket.this.connectionLostTimeout * 1.5d));
                    Iterator<WebSocket> it = this.connections.iterator();
                    while (it.hasNext()) {
                        AbstractWebSocket.this.executeConnectionLostDetection(it.next(), nanoTime);
                    }
                } catch (Exception unused) {
                }
                this.connections.clear();
            }
        };
        ScheduledExecutorService scheduledExecutorService = this.connectionLostCheckerService;
        long j2 = this.connectionLostTimeout;
        this.connectionLostCheckerFuture = scheduledExecutorService.scheduleAtFixedRate(runnable, j2, j2, TimeUnit.NANOSECONDS);
    }

    public int getConnectionLostTimeout() {
        int seconds;
        synchronized (this.syncConnectionLost) {
            seconds = (int) TimeUnit.NANOSECONDS.toSeconds(this.connectionLostTimeout);
        }
        return seconds;
    }

    public abstract Collection<WebSocket> getConnections();

    public boolean isReuseAddr() {
        return this.reuseAddr;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public void setConnectionLostTimeout(int i2) {
        synchronized (this.syncConnectionLost) {
            long nanos = TimeUnit.SECONDS.toNanos(i2);
            this.connectionLostTimeout = nanos;
            if (nanos <= 0) {
                this.log.trace("Connection lost timer stopped");
                cancelConnectionLostTimer();
                return;
            }
            if (this.websocketRunning) {
                this.log.trace("Connection lost timer restarted");
                try {
                    Iterator it = new ArrayList(getConnections()).iterator();
                    while (it.hasNext()) {
                        WebSocket webSocket = (WebSocket) it.next();
                        if (webSocket instanceof WebSocketImpl) {
                            ((WebSocketImpl) webSocket).updateLastPong();
                        }
                    }
                } catch (Exception e2) {
                    this.log.error("Exception during connection lost restart", e2);
                }
                restartConnectionLostTimer();
            }
        }
    }

    public void setReuseAddr(boolean z) {
        this.reuseAddr = z;
    }

    public void setTcpNoDelay(boolean z) {
        this.tcpNoDelay = z;
    }

    public void startConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            if (this.connectionLostTimeout <= 0) {
                this.log.trace("Connection lost timer deactivated");
                return;
            }
            this.log.trace("Connection lost timer started");
            this.websocketRunning = true;
            restartConnectionLostTimer();
        }
    }

    public void stopConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            if (this.connectionLostCheckerService != null || this.connectionLostCheckerFuture != null) {
                this.websocketRunning = false;
                this.log.trace("Connection lost timer stopped");
                cancelConnectionLostTimer();
            }
        }
    }
}
