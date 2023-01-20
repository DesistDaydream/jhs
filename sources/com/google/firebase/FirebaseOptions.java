package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.f0;
import e.j.a.b.c.r.y;
import e.j.a.b.c.x.b0;

@e.j.d.c.a
/* loaded from: classes2.dex */
public final class FirebaseOptions {
    private static final String API_KEY_RESOURCE_NAME = "google_api_key";
    private static final String APP_ID_RESOURCE_NAME = "google_app_id";
    private static final String DATABASE_URL_RESOURCE_NAME = "firebase_database_url";
    private static final String GA_TRACKING_ID_RESOURCE_NAME = "ga_trackingId";
    private static final String GCM_SENDER_ID_RESOURCE_NAME = "gcm_defaultSenderId";
    private static final String PROJECT_ID_RESOURCE_NAME = "project_id";
    private static final String STORAGE_BUCKET_RESOURCE_NAME = "google_storage_bucket";
    private final String apiKey;
    private final String applicationId;
    private final String databaseUrl;
    private final String gaTrackingId;
    private final String gcmSenderId;
    private final String projectId;
    private final String storageBucket;

    @e.j.d.c.a
    /* loaded from: classes2.dex */
    public static final class Builder {
        private String apiKey;
        private String applicationId;
        private String databaseUrl;
        private String gaTrackingId;
        private String gcmSenderId;
        private String projectId;
        private String storageBucket;

        @e.j.d.c.a
        public Builder() {
        }

        @e.j.d.c.a
        public FirebaseOptions build() {
            return new FirebaseOptions(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId);
        }

        @e.j.d.c.a
        public Builder setApiKey(@NonNull String str) {
            this.apiKey = a0.h(str, "ApiKey must be set.");
            return this;
        }

        @e.j.d.c.a
        public Builder setApplicationId(@NonNull String str) {
            this.applicationId = a0.h(str, "ApplicationId must be set.");
            return this;
        }

        @e.j.d.c.a
        public Builder setDatabaseUrl(@Nullable String str) {
            this.databaseUrl = str;
            return this;
        }

        @e.j.a.b.c.m.a
        public Builder setGaTrackingId(@Nullable String str) {
            this.gaTrackingId = str;
            return this;
        }

        @e.j.d.c.a
        public Builder setGcmSenderId(@Nullable String str) {
            this.gcmSenderId = str;
            return this;
        }

        @e.j.d.c.a
        public Builder setProjectId(@Nullable String str) {
            this.projectId = str;
            return this;
        }

        @e.j.d.c.a
        public Builder setStorageBucket(@Nullable String str) {
            this.storageBucket = str;
            return this;
        }

        @e.j.d.c.a
        public Builder(FirebaseOptions firebaseOptions) {
            this.applicationId = firebaseOptions.applicationId;
            this.apiKey = firebaseOptions.apiKey;
            this.databaseUrl = firebaseOptions.databaseUrl;
            this.gaTrackingId = firebaseOptions.gaTrackingId;
            this.gcmSenderId = firebaseOptions.gcmSenderId;
            this.storageBucket = firebaseOptions.storageBucket;
            this.projectId = firebaseOptions.projectId;
        }
    }

    @e.j.d.c.a
    public static FirebaseOptions fromResource(Context context) {
        f0 f0Var = new f0(context);
        String a2 = f0Var.a(APP_ID_RESOURCE_NAME);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new FirebaseOptions(a2, f0Var.a(API_KEY_RESOURCE_NAME), f0Var.a(DATABASE_URL_RESOURCE_NAME), f0Var.a(GA_TRACKING_ID_RESOURCE_NAME), f0Var.a(GCM_SENDER_ID_RESOURCE_NAME), f0Var.a(STORAGE_BUCKET_RESOURCE_NAME), f0Var.a(PROJECT_ID_RESOURCE_NAME));
    }

    public boolean equals(Object obj) {
        if (obj instanceof FirebaseOptions) {
            FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
            return y.a(this.applicationId, firebaseOptions.applicationId) && y.a(this.apiKey, firebaseOptions.apiKey) && y.a(this.databaseUrl, firebaseOptions.databaseUrl) && y.a(this.gaTrackingId, firebaseOptions.gaTrackingId) && y.a(this.gcmSenderId, firebaseOptions.gcmSenderId) && y.a(this.storageBucket, firebaseOptions.storageBucket) && y.a(this.projectId, firebaseOptions.projectId);
        }
        return false;
    }

    @e.j.d.c.a
    public String getApiKey() {
        return this.apiKey;
    }

    @e.j.d.c.a
    public String getApplicationId() {
        return this.applicationId;
    }

    @e.j.d.c.a
    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    @e.j.a.b.c.m.a
    public String getGaTrackingId() {
        return this.gaTrackingId;
    }

    @e.j.d.c.a
    public String getGcmSenderId() {
        return this.gcmSenderId;
    }

    @e.j.d.c.a
    public String getProjectId() {
        return this.projectId;
    }

    @e.j.d.c.a
    public String getStorageBucket() {
        return this.storageBucket;
    }

    public int hashCode() {
        return y.b(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId);
    }

    public String toString() {
        return y.c(this).a("applicationId", this.applicationId).a("apiKey", this.apiKey).a("databaseUrl", this.databaseUrl).a("gcmSenderId", this.gcmSenderId).a("storageBucket", this.storageBucket).a("projectId", this.projectId).toString();
    }

    private FirebaseOptions(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        a0.r(!b0.b(str), "ApplicationId must be set.");
        this.applicationId = str;
        this.apiKey = str2;
        this.databaseUrl = str3;
        this.gaTrackingId = str4;
        this.gcmSenderId = str5;
        this.storageBucket = str6;
        this.projectId = str7;
    }
}
