package com.cross.easygoband_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class SplashActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        compositeDisposable = new CompositeDisposable();

        isInternetAvailable();
    }

    public void isInternetAvailable() {
        Handler handler = new Handler();
        Disposable disposable = hasInternetConnection().subscribe((hasInternet) -> {
            if(hasInternet) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }else {
                Toast.makeText(SplashActivity.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        finish();
                    }}, 2000);
            }
        });

        compositeDisposable.add(disposable);
    }

    public static Single<Boolean> hasInternetConnection() {
        return Single.fromCallable(() -> {
            try {
                // Connect to Google DNS to check for connection
                int timeoutMs = 1500;
                Socket socket = new Socket();
                InetSocketAddress socketAddress = new InetSocketAddress("8.8.8.8", 53);

                socket.connect(socketAddress, timeoutMs);
                socket.close();

                return true;
            } catch (IOException e) {
                return false;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}

