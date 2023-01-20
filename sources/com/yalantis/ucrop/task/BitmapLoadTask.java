package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import j.k0;
import j.o;
import j.z;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private static final int MAX_BITMAP_SIZE = 104857600;
    private static final String TAG = "BitmapWorkerTask";
    private final BitmapLoadCallback mBitmapLoadCallback;
    private final Context mContext;
    private Uri mInputUri;
    private Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public BitmapLoadTask(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i2, int i3, BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = context;
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = i2;
        this.mRequiredHeight = i3;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    private boolean checkSize(Bitmap bitmap, BitmapFactory.Options options) {
        if ((bitmap != null ? bitmap.getByteCount() : 0) > MAX_BITMAP_SIZE) {
            options.inSampleSize *= 2;
            return true;
        }
        return false;
    }

    private void copyFile(@NonNull Uri uri, @Nullable Uri uri2) throws NullPointerException, IOException {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Log.d(TAG, "copyFile");
        Objects.requireNonNull(uri2, "Output Uri is null - cannot copy image");
        FileOutputStream fileOutputStream2 = null;
        try {
            inputStream = this.mContext.getContentResolver().openInputStream(uri);
            try {
                fileOutputStream = new FileOutputStream(new File(uri2.getPath()));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            if (inputStream == null) {
                throw new NullPointerException("InputStream for given input Uri is null");
            }
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    BitmapLoadUtils.close(fileOutputStream);
                    BitmapLoadUtils.close(inputStream);
                    this.mInputUri = this.mOutputUri;
                    return;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            BitmapLoadUtils.close(fileOutputStream2);
            BitmapLoadUtils.close(inputStream);
            this.mInputUri = this.mOutputUri;
            throw th;
        }
    }

    private void downloadFile(@NonNull Uri uri, @Nullable Uri uri2) throws NullPointerException, IOException {
        Closeable closeable;
        Response response;
        o source;
        Log.d(TAG, "downloadFile");
        Objects.requireNonNull(uri2, "Output Uri is null - cannot download image");
        OkHttpClient okHttpClient = new OkHttpClient();
        o oVar = null;
        try {
            Response execute = okHttpClient.newCall(new Request.Builder().url(uri.toString()).build()).execute();
            try {
                source = execute.body().source();
            } catch (Throwable th) {
                th = th;
                response = execute;
                closeable = null;
            }
            try {
                OutputStream openOutputStream = this.mContext.getContentResolver().openOutputStream(uri2);
                if (openOutputStream != null) {
                    k0 h2 = z.h(openOutputStream);
                    source.s0(h2);
                    BitmapLoadUtils.close(source);
                    BitmapLoadUtils.close(h2);
                    if (execute != null) {
                        BitmapLoadUtils.close(execute.body());
                    }
                    okHttpClient.dispatcher().cancelAll();
                    this.mInputUri = this.mOutputUri;
                    return;
                }
                throw new NullPointerException("OutputStream for given output Uri is null");
            } catch (Throwable th2) {
                th = th2;
                response = execute;
                closeable = null;
                oVar = source;
                BitmapLoadUtils.close(oVar);
                BitmapLoadUtils.close(closeable);
                if (response != null) {
                    BitmapLoadUtils.close(response.body());
                }
                okHttpClient.dispatcher().cancelAll();
                this.mInputUri = this.mOutputUri;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            response = null;
        }
    }

    private void processInputUri() throws NullPointerException, IOException {
        String scheme = this.mInputUri.getScheme();
        Log.d(TAG, "Uri scheme: " + scheme);
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            if ("content".equals(scheme)) {
                try {
                    copyFile(this.mInputUri, this.mOutputUri);
                    return;
                } catch (IOException | NullPointerException e2) {
                    Log.e(TAG, "Copying failed", e2);
                    throw e2;
                }
            } else if ("file".equals(scheme)) {
                return;
            } else {
                Log.e(TAG, "Invalid Uri scheme " + scheme);
                throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
            }
        }
        try {
            downloadFile(this.mInputUri, this.mOutputUri);
        } catch (IOException | NullPointerException e3) {
            Log.e(TAG, "Downloading failed", e3);
            throw e3;
        }
    }

    @Override // android.os.AsyncTask
    @NonNull
    public BitmapWorkerResult doInBackground(Void... voidArr) {
        InputStream openInputStream;
        if (this.mInputUri == null) {
            return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            processInputUri();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, this.mRequiredWidth, this.mRequiredHeight);
            boolean z = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmap = null;
            while (!z) {
                try {
                    openInputStream = this.mContext.getContentResolver().openInputStream(this.mInputUri);
                } catch (IOException e2) {
                    Log.e(TAG, "doInBackground: ImageDecoder.createSource: ", e2);
                    return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]", e2));
                } catch (OutOfMemoryError e3) {
                    Log.e(TAG, "doInBackground: BitmapFactory.decodeFileDescriptor: ", e3);
                    options.inSampleSize *= 2;
                }
                try {
                    bitmap = BitmapFactory.decodeStream(openInputStream, null, options);
                    if (options.outWidth != -1 && options.outHeight != -1) {
                        BitmapLoadUtils.close(openInputStream);
                        if (!checkSize(bitmap, options)) {
                            z = true;
                        }
                    } else {
                        return new BitmapWorkerResult(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.mInputUri + "]"));
                    }
                } finally {
                    BitmapLoadUtils.close(openInputStream);
                }
            }
            if (bitmap == null) {
                return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]"));
            }
            int exifOrientation = BitmapLoadUtils.getExifOrientation(this.mContext, this.mInputUri);
            int exifToDegrees = BitmapLoadUtils.exifToDegrees(exifOrientation);
            int exifToTranslation = BitmapLoadUtils.exifToTranslation(exifOrientation);
            ExifInfo exifInfo = new ExifInfo(exifOrientation, exifToDegrees, exifToTranslation);
            Matrix matrix = new Matrix();
            if (exifToDegrees != 0) {
                matrix.preRotate(exifToDegrees);
            }
            if (exifToTranslation != 1) {
                matrix.postScale(exifToTranslation, 1.0f);
            }
            if (!matrix.isIdentity()) {
                return new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(bitmap, matrix), exifInfo);
            }
            return new BitmapWorkerResult(bitmap, exifInfo);
        } catch (IOException | NullPointerException e4) {
            return new BitmapWorkerResult(e4);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(@NonNull BitmapWorkerResult bitmapWorkerResult) {
        Exception exc = bitmapWorkerResult.mBitmapWorkerException;
        if (exc == null) {
            BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
            Bitmap bitmap = bitmapWorkerResult.mBitmapResult;
            ExifInfo exifInfo = bitmapWorkerResult.mExifInfo;
            String path = this.mInputUri.getPath();
            Uri uri = this.mOutputUri;
            bitmapLoadCallback.onBitmapLoaded(bitmap, exifInfo, path, uri == null ? null : uri.getPath());
            return;
        }
        this.mBitmapLoadCallback.onFailure(exc);
    }

    /* loaded from: classes3.dex */
    public static class BitmapWorkerResult {
        public Bitmap mBitmapResult;
        public Exception mBitmapWorkerException;
        public ExifInfo mExifInfo;

        public BitmapWorkerResult(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(@NonNull Exception exc) {
            this.mBitmapWorkerException = exc;
        }
    }
}
