package d.a.a.o;

import android.os.SystemClock;
import com.caverock.androidsvg.SVG;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* loaded from: classes.dex */
public class j {
    private long a;

    private long b(byte[] bArr, int i2) {
        int i3 = bArr[i2];
        int i4 = bArr[i2 + 1];
        int i5 = bArr[i2 + 2];
        int i6 = bArr[i2 + 3];
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        if ((i6 & 128) == 128) {
            i6 = (i6 & 127) + 128;
        }
        return (i3 << 24) + (i4 << 16) + (i5 << 8) + i6;
    }

    private void c(byte[] bArr, int i2, long j2) {
        long j3 = (j2 / 1000) + 2208988800L;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j3 >> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j3 >> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j3 >> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) j3;
        long j4 = ((j2 - (j3 * 1000)) * SVG.T) / 1000;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j4 >> 24);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j4 >> 16);
        bArr[i8] = (byte) (j4 >> 8);
        bArr[i8 + 1] = (byte) (Math.random() * 255.0d);
    }

    private long e(byte[] bArr, int i2) {
        return ((b(bArr, i2) - 2208988800L) * 1000) + ((b(bArr, i2 + 4) * 1000) / SVG.T);
    }

    public long a() {
        return this.a;
    }

    public boolean d(String str, int i2) {
        DatagramSocket datagramSocket;
        DatagramSocket datagramSocket2 = null;
        try {
            datagramSocket = new DatagramSocket();
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            datagramSocket.setSoTimeout(i2);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, InetAddress.getByName(str), 123);
            bArr[0] = 27;
            long currentTimeMillis = System.currentTimeMillis();
            c(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime = currentTimeMillis + (SystemClock.elapsedRealtime() - SystemClock.elapsedRealtime());
            long e2 = e(bArr, 24);
            this.a = ((e(bArr, 32) - e2) + (e(bArr, 40) - elapsedRealtime)) / 2;
            datagramSocket.close();
            return true;
        } catch (Exception unused2) {
            datagramSocket2 = datagramSocket;
            if (datagramSocket2 != null) {
                datagramSocket2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            datagramSocket2 = datagramSocket;
            if (datagramSocket2 != null) {
                datagramSocket2.close();
            }
            throw th;
        }
    }
}
