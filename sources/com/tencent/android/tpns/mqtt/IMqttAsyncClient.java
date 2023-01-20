package com.tencent.android.tpns.mqtt;

/* loaded from: classes3.dex */
public interface IMqttAsyncClient {
    void close() throws MqttException;

    IMqttToken connect() throws MqttException, MqttSecurityException;

    IMqttToken connect(MqttConnectOptions mqttConnectOptions) throws MqttException, MqttSecurityException;

    IMqttToken connect(MqttConnectOptions mqttConnectOptions, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttSecurityException;

    IMqttToken connect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttSecurityException;

    IMqttToken disconnect() throws MqttException;

    IMqttToken disconnect(long j2) throws MqttException;

    IMqttToken disconnect(long j2, Object obj, IMqttActionListener iMqttActionListener) throws MqttException;

    IMqttToken disconnect(Object obj, IMqttActionListener iMqttActionListener) throws MqttException;

    void disconnectForcibly() throws MqttException;

    void disconnectForcibly(long j2) throws MqttException;

    void disconnectForcibly(long j2, long j3) throws MqttException;

    String getClientId();

    IMqttDeliveryToken[] getPendingDeliveryTokens();

    String getServerURI();

    boolean isConnected();

    void messageArrivedComplete(int i2, int i3) throws MqttException;

    IMqttDeliveryToken publish(String str, MqttMessage mqttMessage) throws MqttException, MqttPersistenceException;

    IMqttDeliveryToken publish(String str, MqttMessage mqttMessage, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException;

    IMqttDeliveryToken publish(String str, byte[] bArr, int i2, boolean z) throws MqttException, MqttPersistenceException;

    IMqttDeliveryToken publish(String str, byte[] bArr, int i2, boolean z, Object obj, IMqttActionListener iMqttActionListener) throws MqttException, MqttPersistenceException;

    void setCallback(MqttCallback mqttCallback);

    void setManualAcks(boolean z);

    IMqttToken subscribe(String str, int i2) throws MqttException;

    IMqttToken subscribe(String str, int i2, IMqttMessageListener iMqttMessageListener) throws MqttException;

    IMqttToken subscribe(String str, int i2, Object obj, IMqttActionListener iMqttActionListener) throws MqttException;

    IMqttToken subscribe(String str, int i2, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener iMqttMessageListener) throws MqttException;

    IMqttToken subscribe(String[] strArr, int[] iArr) throws MqttException;

    IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException;

    IMqttToken subscribe(String[] strArr, int[] iArr, Object obj, IMqttActionListener iMqttActionListener, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException;

    IMqttToken subscribe(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException;

    IMqttToken unsubscribe(String str) throws MqttException;

    IMqttToken unsubscribe(String str, Object obj, IMqttActionListener iMqttActionListener) throws MqttException;

    IMqttToken unsubscribe(String[] strArr) throws MqttException;

    IMqttToken unsubscribe(String[] strArr, Object obj, IMqttActionListener iMqttActionListener) throws MqttException;
}
