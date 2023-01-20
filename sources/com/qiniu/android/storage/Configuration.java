package com.qiniu.android.storage;

import com.qiniu.android.common.AutoZone;
import com.qiniu.android.common.Zone;
import com.qiniu.android.http.ProxyConfiguration;
import com.qiniu.android.http.UrlConverter;
import java.io.File;

/* loaded from: classes3.dex */
public final class Configuration {
    public static final int BLOCK_SIZE = 4194304;
    public static int RESUME_UPLOAD_VERSION_V1 = 0;
    public static int RESUME_UPLOAD_VERSION_V2 = 1;
    public final boolean allowBackupHost;
    public final int chunkSize;
    public final int concurrentTaskCount;
    public final int connectTimeout;
    public final KeyGenerator keyGen;
    public final ProxyConfiguration proxy;
    public final int putThreshold;
    public final Recorder recorder;
    public final int responseTimeout;
    public final int resumeUploadVersion;
    public final int retryInterval;
    public final int retryMax;
    public final UrlConverter urlConverter;
    public final boolean useConcurrentResumeUpload;
    public final boolean useHttps;
    public final Zone zone;

    /* loaded from: classes3.dex */
    public static class Builder {
        private Zone zone = null;
        private Recorder recorder = null;
        private KeyGenerator keyGen = null;
        private ProxyConfiguration proxy = null;
        private boolean useHttps = true;
        private int chunkSize = 2097152;
        private int putThreshold = 4194304;
        private int connectTimeout = 90;
        private int responseTimeout = 60;
        private int retryMax = 1;
        private int retryInterval = 500;
        private boolean allowBackupHost = true;
        private UrlConverter urlConverter = null;
        private boolean useConcurrentResumeUpload = false;
        private int resumeUploadVersion = Configuration.RESUME_UPLOAD_VERSION_V1;
        private int concurrentTaskCount = 3;

        public Builder allowBackupHost(boolean z) {
            this.allowBackupHost = z;
            return this;
        }

        public Configuration build() {
            return new Configuration(this);
        }

        public Builder chunkSize(int i2) {
            this.chunkSize = i2;
            return this;
        }

        public Builder concurrentTaskCount(int i2) {
            this.concurrentTaskCount = i2;
            return this;
        }

        public Builder connectTimeout(int i2) {
            this.connectTimeout = i2;
            return this;
        }

        public Builder proxy(ProxyConfiguration proxyConfiguration) {
            this.proxy = proxyConfiguration;
            return this;
        }

        public Builder putThreshold(int i2) {
            this.putThreshold = i2;
            return this;
        }

        public Builder recorder(Recorder recorder) {
            this.recorder = recorder;
            return this;
        }

        public Builder responseTimeout(int i2) {
            this.responseTimeout = i2;
            return this;
        }

        public Builder resumeUploadVersion(int i2) {
            this.resumeUploadVersion = i2;
            return this;
        }

        public Builder retryInterval(int i2) {
            this.retryInterval = i2;
            return this;
        }

        public Builder retryMax(int i2) {
            this.retryMax = i2;
            return this;
        }

        public Builder urlConverter(UrlConverter urlConverter) {
            this.urlConverter = urlConverter;
            return this;
        }

        public Builder useConcurrentResumeUpload(boolean z) {
            this.useConcurrentResumeUpload = z;
            return this;
        }

        public Builder useHttps(boolean z) {
            this.useHttps = z;
            return this;
        }

        public Builder zone(Zone zone) {
            this.zone = zone;
            return this;
        }

        public Builder recorder(Recorder recorder, KeyGenerator keyGenerator) {
            this.recorder = recorder;
            this.keyGen = keyGenerator;
            return this;
        }
    }

    private KeyGenerator getKeyGen(KeyGenerator keyGenerator) {
        return keyGenerator == null ? new KeyGenerator() { // from class: com.qiniu.android.storage.Configuration.1
            @Override // com.qiniu.android.storage.KeyGenerator
            public String gen(String str, File file) {
                return str + "_._" + ((Object) new StringBuffer(file.getAbsolutePath()).reverse());
            }

            @Override // com.qiniu.android.storage.KeyGenerator
            public String gen(String str, String str2) {
                if (str2 == null) {
                    str2 = "";
                }
                return str + "_._" + str2;
            }
        } : keyGenerator;
    }

    private Configuration(Builder builder) {
        this.useConcurrentResumeUpload = builder.useConcurrentResumeUpload;
        this.resumeUploadVersion = builder.resumeUploadVersion;
        this.concurrentTaskCount = builder.concurrentTaskCount;
        if (builder.resumeUploadVersion == RESUME_UPLOAD_VERSION_V1) {
            if (builder.chunkSize < 1024) {
                builder.chunkSize = 1024;
            }
        } else if (builder.resumeUploadVersion == RESUME_UPLOAD_VERSION_V2 && builder.chunkSize < 1048576) {
            builder.chunkSize = 1048576;
        }
        this.chunkSize = builder.chunkSize;
        this.putThreshold = builder.putThreshold;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.recorder = builder.recorder;
        this.keyGen = getKeyGen(builder.keyGen);
        this.retryMax = builder.retryMax;
        this.retryInterval = builder.retryInterval;
        this.allowBackupHost = builder.allowBackupHost;
        this.proxy = builder.proxy;
        this.urlConverter = builder.urlConverter;
        this.useHttps = builder.useHttps;
        this.zone = builder.zone != null ? builder.zone : new AutoZone();
    }
}
