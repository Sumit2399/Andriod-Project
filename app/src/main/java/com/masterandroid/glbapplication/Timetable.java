package com.masterandroid.glbapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class Timetable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        WebView webView=findViewById(R.id.webView);
        final ProgressBar progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        String url="https://drive.google.com/file/d/19p_3ln-EbTr696rujFiH2VAvj4DN8p6o/view?usp=sharing";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                if(newProgress==100){
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        webView.loadUrl(url);
    }
}