package org.conscrypt;

import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;

/* loaded from: classes4.dex */
public class KeyManagerFactoryImpl extends KeyManagerFactorySpi {
    private KeyStore keyStore;
    private char[] pwd;

    @Override // javax.net.ssl.KeyManagerFactorySpi
    public KeyManager[] engineGetKeyManagers() {
        if (this.keyStore != null) {
            return new KeyManager[]{new KeyManagerImpl(this.keyStore, this.pwd)};
        }
        throw new IllegalStateException("KeyManagerFactory is not initialized");
    }

    @Override // javax.net.ssl.KeyManagerFactorySpi
    public void engineInit(KeyStore keyStore, char[] cArr) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        if (keyStore != null) {
            this.keyStore = keyStore;
            if (cArr != null) {
                this.pwd = (char[]) cArr.clone();
                return;
            } else {
                this.pwd = EmptyArray.CHAR;
                return;
            }
        }
        this.keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        String property = System.getProperty(SSLSocketFactoryFactory.SYSKEYSTORE);
        if (property != null && !property.equalsIgnoreCase("NONE") && !property.isEmpty()) {
            String property2 = System.getProperty(SSLSocketFactoryFactory.SYSKEYSTOREPWD);
            if (property2 == null) {
                this.pwd = EmptyArray.CHAR;
            } else {
                this.pwd = property2.toCharArray();
            }
            try {
                this.keyStore.load(new FileInputStream(new File(property)), this.pwd);
                return;
            } catch (FileNotFoundException e2) {
                throw new KeyStoreException(e2);
            } catch (IOException e3) {
                throw new KeyStoreException(e3);
            } catch (CertificateException e4) {
                throw new KeyStoreException(e4);
            }
        }
        try {
            this.keyStore.load(null, null);
        } catch (IOException e5) {
            throw new KeyStoreException(e5);
        } catch (CertificateException e6) {
            throw new KeyStoreException(e6);
        }
    }

    @Override // javax.net.ssl.KeyManagerFactorySpi
    public void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("ManagerFactoryParameters not supported");
    }
}
