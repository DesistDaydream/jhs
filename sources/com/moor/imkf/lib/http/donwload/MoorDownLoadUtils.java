package com.moor.imkf.lib.http.donwload;

import com.moor.imkf.lib.MoorBaseLibManager;
import com.moor.imkf.lib.constants.MoorPathConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class MoorDownLoadUtils {
    private static OkHttpClient mOkHttpClient;

    public static OkHttpClient getLoadFileOkHttp() {
        File cacheDir = MoorBaseLibManager.getInstance().getApplication().getCacheDir();
        if (mOkHttpClient == null) {
            OkHttpClient.Builder retryOnConnectionFailure = new OkHttpClient.Builder().retryOnConnectionFailure(true);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            mOkHttpClient = retryOnConnectionFailure.connectTimeout(15L, timeUnit).writeTimeout(15L, timeUnit).readTimeout(15L, timeUnit).cache(new Cache(cacheDir.getAbsoluteFile(), 10485760)).build();
        }
        return mOkHttpClient;
    }

    public static void loadFile(String str, File file, IMoorOnDownloadListener iMoorOnDownloadListener) {
    }

    public static void loadFile(String str, String str2, final IMoorOnDownloadListener iMoorOnDownloadListener) {
        final String str3 = MoorPathConstants.getStoragePath(MoorPathConstants.PATH_NAME_MOOR_DOWNLOAD_FILE) + str2;
        final File file = new File(str3);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        Request build = new Request.Builder().addHeader("Accept-Encoding", "application/octet-stream").url(str).build();
        if (iMoorOnDownloadListener != null) {
            iMoorOnDownloadListener.onDownloadStart();
        }
        getLoadFileOkHttp().newCall(build).enqueue(new Callback() { // from class: com.moor.imkf.lib.http.donwload.MoorDownLoadUtils.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                IMoorOnDownloadListener iMoorOnDownloadListener2 = IMoorOnDownloadListener.this;
                if (iMoorOnDownloadListener2 != null) {
                    iMoorOnDownloadListener2.onDownloadFailed();
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                FileOutputStream fileOutputStream;
                Throwable th;
                InputStream inputStream;
                if (200 == response.code()) {
                    FileOutputStream fileOutputStream2 = null;
                    try {
                        long contentLength = response.body().contentLength();
                        long j2 = 0;
                        inputStream = response.body().byteStream();
                        try {
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    byte[] bArr = new byte[4194304];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                        IMoorOnDownloadListener iMoorOnDownloadListener2 = IMoorOnDownloadListener.this;
                                        if (iMoorOnDownloadListener2 != null) {
                                            j2 += read;
                                            int i2 = (int) (((((float) j2) * 1.0f) / ((float) contentLength)) * 100.0f);
                                            if (i2 % 2 == 0) {
                                                iMoorOnDownloadListener2.onDownloading(i2);
                                            }
                                        }
                                    }
                                    fileOutputStream.flush();
                                    IMoorOnDownloadListener iMoorOnDownloadListener3 = IMoorOnDownloadListener.this;
                                    if (iMoorOnDownloadListener3 != null) {
                                        iMoorOnDownloadListener3.onDownloadSuccess(str3);
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                    fileOutputStream2 = fileOutputStream;
                                    IMoorOnDownloadListener iMoorOnDownloadListener4 = IMoorOnDownloadListener.this;
                                    if (iMoorOnDownloadListener4 != null) {
                                        iMoorOnDownloadListener4.onDownloadFailed();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                fileOutputStream = fileOutputStream2;
                                th = th3;
                            }
                        } catch (IOException unused2) {
                        }
                    } catch (IOException unused3) {
                        inputStream = null;
                    } catch (Throwable th4) {
                        fileOutputStream = null;
                        th = th4;
                        inputStream = null;
                    }
                } else {
                    IMoorOnDownloadListener iMoorOnDownloadListener5 = IMoorOnDownloadListener.this;
                    if (iMoorOnDownloadListener5 != null) {
                        iMoorOnDownloadListener5.onDownloadFailed();
                    }
                }
            }
        });
    }
}
