package com.moor.imkf.mp3recorder;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.moor.imkf.mp3recorder.util.LameUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public class DataEncodeThread extends Thread implements AudioRecord.OnRecordPositionUpdateListener {
    public static final int PROCESS_STOP = 1;
    private FileOutputStream mFileOutputStream;
    private StopHandler mHandler;
    private byte[] mMp3Buffer;
    private FileOutputStream mPCMFileOutputStream;
    private CountDownLatch mHandlerInitLatch = new CountDownLatch(1);
    private List<Task> mTasks = Collections.synchronizedList(new ArrayList());

    /* loaded from: classes2.dex */
    public static class StopHandler extends Handler {
        public WeakReference<DataEncodeThread> encodeThread;

        public StopHandler(DataEncodeThread dataEncodeThread) {
            this.encodeThread = new WeakReference<>(dataEncodeThread);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                DataEncodeThread dataEncodeThread = this.encodeThread.get();
                do {
                } while (dataEncodeThread.processData() > 0);
                removeCallbacksAndMessages(null);
                dataEncodeThread.flushAndRelease();
                getLooper().quit();
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes2.dex */
    public class Task {
        private short[] rawData;
        private int readSize;

        public Task(short[] sArr, int i2) {
            this.rawData = (short[]) sArr.clone();
            this.readSize = i2;
        }

        public short[] getData() {
            return this.rawData;
        }

        public int getReadSize() {
            return this.readSize;
        }
    }

    public DataEncodeThread(File file, int i2) throws FileNotFoundException {
        this.mFileOutputStream = new FileOutputStream(file);
        this.mMp3Buffer = new byte[(int) ((i2 * 2 * 1.25d) + 7200.0d)];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushAndRelease() {
        int flush = LameUtil.flush(this.mMp3Buffer);
        if (flush > 0) {
            try {
                try {
                    FileOutputStream fileOutputStream = this.mFileOutputStream;
                    if (fileOutputStream != null) {
                        fileOutputStream.write(this.mMp3Buffer, 0, flush);
                    }
                    FileOutputStream fileOutputStream2 = this.mFileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    FileOutputStream fileOutputStream3 = this.mPCMFileOutputStream;
                    if (fileOutputStream3 != null) {
                        try {
                            fileOutputStream3.close();
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                            LameUtil.close();
                        }
                    }
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream4 = this.mFileOutputStream;
                    if (fileOutputStream4 != null) {
                        try {
                            fileOutputStream4.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    FileOutputStream fileOutputStream5 = this.mPCMFileOutputStream;
                    if (fileOutputStream5 != null) {
                        try {
                            fileOutputStream5.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    LameUtil.close();
                    throw th;
                }
            } catch (IOException e6) {
                e6.printStackTrace();
                FileOutputStream fileOutputStream6 = this.mFileOutputStream;
                if (fileOutputStream6 != null) {
                    try {
                        fileOutputStream6.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                FileOutputStream fileOutputStream7 = this.mPCMFileOutputStream;
                if (fileOutputStream7 != null) {
                    try {
                        fileOutputStream7.close();
                    } catch (IOException e8) {
                        e = e8;
                        e.printStackTrace();
                        LameUtil.close();
                    }
                }
            }
            LameUtil.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int processData() {
        if (this.mTasks.size() > 0) {
            Task remove = this.mTasks.remove(0);
            short[] data = remove.getData();
            int readSize = remove.getReadSize();
            if (readSize > 0) {
                try {
                    FileOutputStream fileOutputStream = this.mPCMFileOutputStream;
                    if (fileOutputStream != null) {
                        fileOutputStream.write(shortArr2byteArrtoByteArray(data));
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            int encode = LameUtil.encode(data, data, readSize, this.mMp3Buffer);
            if (encode > 0) {
                try {
                    FileOutputStream fileOutputStream2 = this.mFileOutputStream;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.write(this.mMp3Buffer, 0, encode);
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return readSize;
        }
        return 0;
    }

    private byte[] shortArr2byteArrtoByteArray(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[sArr.length * 2];
        int i2 = 0;
        int i3 = 0;
        while (i2 != length) {
            bArr[i3] = (byte) (sArr[i2] & 255);
            bArr[i3 + 1] = (byte) ((sArr[i2] & 65280) >> 8);
            i2++;
            i3 += 2;
        }
        return bArr;
    }

    public void addTask(short[] sArr, int i2) {
        this.mTasks.add(new Task(sArr, i2));
    }

    public short[] byteArray2ShortArray(byte[] bArr, int i2) {
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * 2;
            sArr[i3] = (short) (((bArr[i4 + 1] & 255) << 8) | (bArr[i4] & 255));
        }
        return sArr;
    }

    public Handler getHandler() {
        try {
            this.mHandlerInitLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return this.mHandler;
    }

    @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
    public void onMarkerReached(AudioRecord audioRecord) {
    }

    @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
    public void onPeriodicNotification(AudioRecord audioRecord) {
        processData();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.mHandler = new StopHandler(this);
        this.mHandlerInitLatch.countDown();
        Looper.loop();
    }

    public DataEncodeThread(File file, int i2, File file2) throws FileNotFoundException {
        this.mFileOutputStream = new FileOutputStream(file);
        if (file2 != null) {
            this.mPCMFileOutputStream = new FileOutputStream(file2);
        }
        this.mMp3Buffer = new byte[(int) ((i2 * 2 * 1.25d) + 7200.0d)];
    }
}
