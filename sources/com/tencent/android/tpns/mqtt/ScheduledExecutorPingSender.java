package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ScheduledExecutorPingSender implements MqttPingSender {
    private static final String CLASS_NAME = "ScheduledExecutorPingSender";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private String clientid;
    private ClientComms comms;
    private ScheduledExecutorService executorService;
    private ScheduledFuture scheduledFuture;

    /* loaded from: classes3.dex */
    public class PingRunnable extends TTask {
        private static final String methodName = "PingTask.run";

        private PingRunnable() {
        }

        @Override // com.tencent.tpns.baseapi.base.util.TTask
        public void TRun() {
            String name = Thread.currentThread().getName();
            Thread currentThread = Thread.currentThread();
            currentThread.setName("MQTT Ping: " + ScheduledExecutorPingSender.this.clientid);
            ScheduledExecutorPingSender.log.fine(ScheduledExecutorPingSender.CLASS_NAME, methodName, "660", new Object[]{new Long(System.currentTimeMillis())});
            ScheduledExecutorPingSender.this.comms.checkForActivity();
            Thread.currentThread().setName(name);
        }
    }

    public ScheduledExecutorPingSender(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService != null) {
            this.executorService = scheduledExecutorService;
            return;
        }
        throw new IllegalArgumentException("ExecutorService cannot be null.");
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void init(ClientComms clientComms) {
        if (clientComms != null) {
            this.comms = clientComms;
            this.clientid = clientComms.getClient().getClientId();
            return;
        }
        throw new IllegalArgumentException("ClientComms cannot be null.");
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void schedule(long j2) {
        this.scheduledFuture = this.executorService.schedule(new PingRunnable(), j2, TimeUnit.MILLISECONDS);
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void start() {
        log.fine(CLASS_NAME, MessageKey.MSG_ACCEPT_TIME_START, "659", new Object[]{this.clientid});
        schedule(this.comms.getKeepAlive());
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void stop() {
        log.fine(CLASS_NAME, "stop", "661", null);
        ScheduledFuture scheduledFuture = this.scheduledFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }
}
