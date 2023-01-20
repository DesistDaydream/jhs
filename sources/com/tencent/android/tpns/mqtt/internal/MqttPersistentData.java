package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttPersistable;

/* loaded from: classes3.dex */
public class MqttPersistentData implements MqttPersistable {
    private int hLength;
    private int hOffset;
    private byte[] header;
    private String key;
    private int pLength;
    private int pOffset;
    private byte[] payload;

    public MqttPersistentData(String str, byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        this.key = null;
        this.header = null;
        this.hOffset = 0;
        this.hLength = 0;
        this.payload = null;
        this.pOffset = 0;
        this.pLength = 0;
        this.key = str;
        this.header = bArr;
        this.hOffset = i2;
        this.hLength = i3;
        this.payload = bArr2;
        this.pOffset = i4;
        this.pLength = i5;
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public byte[] getHeaderBytes() {
        return this.header;
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public int getHeaderLength() {
        return this.hLength;
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public int getHeaderOffset() {
        return this.hOffset;
    }

    public String getKey() {
        return this.key;
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public byte[] getPayloadBytes() {
        return this.payload;
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public int getPayloadLength() {
        if (this.payload == null) {
            return 0;
        }
        return this.pLength;
    }

    @Override // com.tencent.android.tpns.mqtt.MqttPersistable
    public int getPayloadOffset() {
        return this.pOffset;
    }
}
