package com.tencent.qcloud.tuikit.tuichat.util;

import android.hardware.Camera;
import android.media.AudioRecord;
import android.util.Log;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;

/* loaded from: classes3.dex */
public class CheckPermission {
    public static final int STATE_NO_PERMISSION = -2;
    public static final int STATE_RECORDING = -1;
    public static final int STATE_SUCCESS = 1;
    private static final String TAG = "CheckPermission";

    public static int getRecordState() {
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
        AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                audioRecord.release();
                Log.i(TAG, TUIChatService.getAppContext().getString(R.string.record_occupied));
                return -1;
            } else if (audioRecord.read(sArr, 0, minBufferSize) <= 0) {
                audioRecord.stop();
                audioRecord.release();
                Log.i(TAG, TUIChatService.getAppContext().getString(R.string.record_null));
                return -2;
            } else {
                audioRecord.stop();
                audioRecord.release();
                return 1;
            }
        } catch (Exception unused) {
            audioRecord.release();
            return -2;
        }
    }

    public static synchronized boolean isCameraUseable(int i2) {
        boolean z;
        synchronized (CheckPermission.class) {
            z = false;
            Camera camera = null;
            try {
                try {
                    camera = Camera.open(i2);
                    camera.setParameters(camera.getParameters());
                    if (camera != null) {
                        camera.release();
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (camera != null) {
                    camera.release();
                }
            }
        }
        return z;
    }
}
