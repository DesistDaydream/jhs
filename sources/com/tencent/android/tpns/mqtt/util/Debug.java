package com.tencent.android.tpns.mqtt.util;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.util.Enumeration;
import java.util.Properties;

/* loaded from: classes3.dex */
public class Debug {
    private static final String separator = "==============";
    private String clientID;
    private ClientComms comms;
    private static final String CLASS_NAME = "ClientComms";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private static final String lineSep = System.getProperty("line.separator", "\n");

    public Debug(String str, ClientComms clientComms) {
        this.clientID = str;
        this.comms = clientComms;
        log.setResourceName(str);
    }

    public static String dumpProperties(Properties properties, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> propertyNames = properties.propertyNames();
        StringBuilder sb = new StringBuilder();
        String str2 = lineSep;
        sb.append(str2);
        sb.append(separator);
        sb.append(ExpandableTextView.N);
        sb.append(str);
        sb.append(ExpandableTextView.N);
        sb.append(separator);
        sb.append(str2);
        stringBuffer.append(sb.toString());
        while (propertyNames.hasMoreElements()) {
            String str3 = (String) propertyNames.nextElement();
            stringBuffer.append(left(str3, 28, ' ') + ":  " + properties.get(str3) + lineSep);
        }
        stringBuffer.append("==========================================" + lineSep);
        return stringBuffer.toString();
    }

    public static String left(String str, int i2, char c2) {
        if (str.length() >= i2) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i2);
        stringBuffer.append(str);
        int length = i2 - str.length();
        while (true) {
            length--;
            if (length >= 0) {
                stringBuffer.append(c2);
            } else {
                return stringBuffer.toString();
            }
        }
    }

    public void dumpBaseDebug() {
        dumpVersion();
        dumpSystemProperties();
        dumpMemoryTrace();
    }

    public void dumpClientComms() {
        ClientComms clientComms = this.comms;
        if (clientComms != null) {
            Properties debug = clientComms.getDebug();
            Logger logger = log;
            logger.fine(CLASS_NAME, "dumpClientComms", dumpProperties(debug, this.clientID + " : ClientComms").toString());
        }
    }

    public void dumpClientDebug() {
        dumpClientComms();
        dumpConOptions();
        dumpClientState();
        dumpBaseDebug();
    }

    public void dumpClientState() {
        ClientComms clientComms = this.comms;
        if (clientComms == null || clientComms.getClientState() == null) {
            return;
        }
        Properties debug = this.comms.getClientState().getDebug();
        Logger logger = log;
        logger.fine(CLASS_NAME, "dumpClientState", dumpProperties(debug, this.clientID + " : ClientState").toString());
    }

    public void dumpConOptions() {
        ClientComms clientComms = this.comms;
        if (clientComms != null) {
            Properties debug = clientComms.getConOptions().getDebug();
            Logger logger = log;
            logger.fine(CLASS_NAME, "dumpConOptions", dumpProperties(debug, this.clientID + " : Connect Options").toString());
        }
    }

    public void dumpMemoryTrace() {
        log.dumpTrace();
    }

    public void dumpSystemProperties() {
        log.fine(CLASS_NAME, "dumpSystemProperties", dumpProperties(System.getProperties(), "SystemProperties").toString());
    }

    public void dumpVersion() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        String str = lineSep;
        sb.append(str);
        sb.append(separator);
        sb.append(" Version Info ");
        sb.append(separator);
        sb.append(str);
        stringBuffer.append(sb.toString());
        stringBuffer.append(left("Version", 20, ' ') + ":  " + ClientComms.VERSION + str);
        stringBuffer.append(left("Build Level", 20, ' ') + ":  " + ClientComms.BUILD_LEVEL + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("==========================================");
        sb2.append(str);
        stringBuffer.append(sb2.toString());
        log.fine(CLASS_NAME, "dumpVersion", stringBuffer.toString());
    }
}
