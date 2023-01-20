package com.m7.imkfsdk;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.m7.imkfsdk.chat.KFBaseActivity;
import com.m7.imkfsdk.utils.FileUtils2;
import com.m7.imkfsdk.utils.statusbar.StatusBarUtils;
import java.io.File;

/* loaded from: classes2.dex */
public class MoorWebCenter extends KFBaseActivity {
    private static final int FILECHOOSER_RESULTCODE = 10000;
    public String Now_Url;
    private ValueCallback mUploadMessage;
    private WebView mWebView;
    public String titleName;
    private ImageView titlebar_back;
    private TextView titlebar_name;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 10000 || this.mUploadMessage == null) {
            return;
        }
        Uri data = (intent == null || i3 != -1) ? null : intent.getData();
        if (data == null) {
            this.mUploadMessage.onReceiveValue(null);
            this.mUploadMessage = null;
            return;
        }
        String path = FileUtils2.getPath(this, data);
        if (TextUtils.isEmpty(path)) {
            this.mUploadMessage.onReceiveValue(null);
            this.mUploadMessage = null;
            return;
        }
        Uri fromFile = Uri.fromFile(new File(path));
        if (Build.VERSION.SDK_INT >= 21) {
            this.mUploadMessage.onReceiveValue(new Uri[]{fromFile});
        } else {
            this.mUploadMessage.onReceiveValue(fromFile);
        }
        this.mUploadMessage = null;
    }

    @Override // com.m7.imkfsdk.chat.KFBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ykfsdk_act_web);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.ykfsdk_all_white));
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("OpenUrl");
        this.Now_Url = stringExtra;
        Log.d("OpenUrl=", stringExtra);
        this.titleName = intent.getStringExtra("titleName");
        TextView textView = (TextView) findViewById(R.id.titlebar_name);
        this.titlebar_name = textView;
        textView.setText(this.titleName);
        ImageView imageView = (ImageView) findViewById(R.id.titlebar_back);
        this.titlebar_back = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.MoorWebCenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MoorWebCenter.this.finish();
            }
        });
        WebView webView = (WebView) findViewById(R.id.webView1);
        this.mWebView = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setUseWideViewPort(true);
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.m7.imkfsdk.MoorWebCenter.2
            @Override // android.webkit.WebChromeClient
            @SuppressLint({"NewApi"})
            public boolean onShowFileChooser(WebView webView2, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (MoorWebCenter.this.mUploadMessage != null) {
                    MoorWebCenter.this.mUploadMessage.onReceiveValue(null);
                }
                MoorWebCenter.this.mUploadMessage = valueCallback;
                Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                intent2.addCategory("android.intent.category.OPENABLE");
                if (fileChooserParams != null && fileChooserParams.getAcceptTypes() != null && fileChooserParams.getAcceptTypes().length > 0 && !"".equals(fileChooserParams.getAcceptTypes()[0])) {
                    intent2.setType(fileChooserParams.getAcceptTypes()[0]);
                } else {
                    intent2.setType("*/*");
                }
                MoorWebCenter.this.startActivityForResult(Intent.createChooser(intent2, "File Chooser"), 10000);
                return true;
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                if (MoorWebCenter.this.mUploadMessage != null) {
                    MoorWebCenter.this.mUploadMessage.onReceiveValue(null);
                }
                MoorWebCenter.this.mUploadMessage = valueCallback;
                Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                intent2.addCategory("android.intent.category.OPENABLE");
                intent2.setType("*/*");
                MoorWebCenter.this.startActivityForResult(Intent.createChooser(intent2, "File Chooser"), 10000);
            }

            public void openFileChooser(ValueCallback valueCallback, String str) {
                if (MoorWebCenter.this.mUploadMessage != null) {
                    MoorWebCenter.this.mUploadMessage.onReceiveValue(null);
                }
                MoorWebCenter.this.mUploadMessage = valueCallback;
                Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                intent2.addCategory("android.intent.category.OPENABLE");
                if (TextUtils.isEmpty(str)) {
                    str = "*/*";
                }
                intent2.setType(str);
                MoorWebCenter.this.startActivityForResult(Intent.createChooser(intent2, "File Chooser"), 10000);
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (MoorWebCenter.this.mUploadMessage != null) {
                    MoorWebCenter.this.mUploadMessage.onReceiveValue(null);
                }
                MoorWebCenter.this.mUploadMessage = valueCallback;
                Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                intent2.addCategory("android.intent.category.OPENABLE");
                if (TextUtils.isEmpty(str)) {
                    str = "*/*";
                }
                intent2.setType(str);
                MoorWebCenter.this.startActivityForResult(Intent.createChooser(intent2, "File Chooser"), 10000);
            }
        });
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.m7.imkfsdk.MoorWebCenter.3
            public Dialog progressDialog;

            {
                this.progressDialog = ProgressDialog.show(MoorWebCenter.this, null, MoorWebCenter.this.getString(R.string.ykfsdk_reading));
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                try {
                    this.progressDialog.cancel();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
                try {
                    this.progressDialog.show();
                    this.progressDialog.setCancelable(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                MoorWebCenter.this.Now_Url = str;
                webView2.loadUrl(str);
                return true;
            }
        });
        this.mWebView.getSettings().setCacheMode(2);
        this.mWebView.loadUrl(this.Now_Url);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        finish();
        return super.onKeyDown(i2, keyEvent);
    }
}
