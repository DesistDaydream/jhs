package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.android.tpush.common.MessageKey;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public class TimerPingSender implements MqttPingSender {
    private static final String CLASS_NAME = "TimerPingSender";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ClientComms comms;
    private Timer timer;

    /* loaded from: classes3.dex */
    public class PingTask extends TimerTask {
        private static final String methodName = "PingTask.run";

        private PingTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            TimerPingSender.log.fine(TimerPingSender.CLASS_NAME, methodName, "660", new Object[]{new Long(System.currentTimeMillis())});
            TimerPingSender.this.comms.checkForActivity();
        }
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void init(ClientComms clientComms) {
        if (clientComms != null) {
            this.comms = clientComms;
            return;
        }
        throw new IllegalArgumentException("ClientComms cannot be null.");
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void schedule(long j2) {
        this.timer.schedule(new PingTask(), j2);
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void start() {
        String clientId = this.comms.getClient().getClientId();
        log.fine(CLASS_NAME, MessageKey.MSG_ACCEPT_TIME_START, "659", new Object[]{clientId});
        Timer timer = new Timer("MQTT Ping: " + clientId);
        this.timer = timer;
        timer.schedule(new PingTask(), this.comms.getKeepAlive());
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPingSender
    public void stop() {
        log.fine(CLASS_NAME, "stop", "661", null);
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
    }
}
