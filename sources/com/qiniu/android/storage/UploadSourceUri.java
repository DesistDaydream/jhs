package com.qiniu.android.storage;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.qiniu.android.utils.ContextGetter;
import com.qiniu.android.utils.StringUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@TargetApi(19)
/* loaded from: classes3.dex */
public class UploadSourceUri extends UploadSourceStream {
    private String modifyDate;
    private Exception readException;
    private ContentResolver resolver;
    private final Uri uri;

    public UploadSourceUri(Uri uri, ContentResolver contentResolver) {
        super(null);
        this.readException = null;
        this.modifyDate = "";
        this.uri = uri;
        this.resolver = contentResolver;
        reloadSource();
        loadFileInfo();
    }

    private InputStream createInputStream() throws Exception {
        ContentResolver contextResolver;
        if (this.uri == null || (contextResolver = getContextResolver()) == null) {
            return null;
        }
        try {
            return contextResolver.openInputStream(this.uri);
        } catch (Exception e2) {
            throw e2;
        }
    }

    private ContentResolver getContextResolver() {
        ContentResolver contentResolver = this.resolver;
        if (contentResolver != null) {
            return contentResolver;
        }
        Context applicationContext = ContextGetter.applicationContext();
        if (applicationContext != null) {
            this.resolver = applicationContext.getContentResolver();
        }
        return this.resolver;
    }

    private void loadFileInfo() {
        Uri uri = this.uri;
        if (uri == null) {
            return;
        }
        if ("file".equals(uri.getScheme())) {
            tryLoadFileInfoByPath();
        } else {
            tryLoadFileInfoByCursor();
        }
    }

    private void tryLoadFileInfoByCursor() {
        String string;
        ContentResolver contextResolver = getContextResolver();
        if (contextResolver == null) {
            return;
        }
        Cursor cursor = null;
        try {
            cursor = contextResolver.query(this.uri, null, null, null, null, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (cursor == null) {
            return;
        }
        try {
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("_data");
                if (!cursor.isNull(columnIndex) && (string = cursor.getString(columnIndex)) != null) {
                    File file = new File(string);
                    setSize(file.length());
                    setFileName(file.getName());
                    this.modifyDate = (file.lastModified() / 1000) + "";
                    return;
                }
                int columnIndex2 = cursor.getColumnIndex("_size");
                if (!cursor.isNull(columnIndex2)) {
                    setSize(cursor.getLong(columnIndex2));
                }
                int columnIndex3 = cursor.getColumnIndex("_display_name");
                if (!cursor.isNull(columnIndex3)) {
                    setFileName(cursor.getString(columnIndex3));
                }
                int columnIndex4 = cursor.getColumnIndex("date_modified");
                if (!cursor.isNull(columnIndex4)) {
                    this.modifyDate = cursor.getString(columnIndex4);
                }
            }
        } finally {
            cursor.close();
        }
    }

    private void tryLoadFileInfoByPath() {
        if (this.uri.getPath() != null) {
            File file = new File(this.uri.getPath());
            if (file.exists() && file.isFile()) {
                setFileName(file.getName());
                setSize(file.length());
                this.modifyDate = file.lastModified() + "";
            }
        }
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public void close() {
        InputStream inputStream = getInputStream();
        if (inputStream != null) {
            try {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                inputStream.close();
            }
        }
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public boolean couldReloadSource() {
        Uri uri = this.uri;
        return (uri == null || StringUtils.isNullOrEmpty(uri.getScheme())) ? false : true;
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public String getId() {
        return getFileName() + "_" + this.modifyDate;
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public String getSourceType() {
        return "Uri";
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public byte[] readData(int i2, long j2) throws IOException {
        if (this.readException == null) {
            return super.readData(i2, j2);
        }
        throw new IOException("Uri read data exception: " + this.readException, this.readException);
    }

    @Override // com.qiniu.android.storage.UploadSourceStream, com.qiniu.android.storage.UploadSource
    public boolean reloadSource() {
        super.reloadSource();
        close();
        InputStream inputStream = null;
        this.readException = null;
        try {
            inputStream = createInputStream();
            setInputStream(inputStream);
        } catch (Exception e2) {
            this.readException = e2;
        }
        return inputStream != null;
    }
}
