package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.heytap.mcssdk.constant.a;
import com.tencent.android.tpns.mqtt.MqttTopic;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    public LongRational(long j2, long j3) {
        this.mNumerator = j2;
        this.mDenominator = j3;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public double toDouble() {
        return this.mNumerator / this.mDenominator;
    }

    @NonNull
    public String toString() {
        return this.mNumerator + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.mDenominator;
    }

    public LongRational(double d2) {
        this((long) (d2 * 10000.0d), a.q);
    }
}
