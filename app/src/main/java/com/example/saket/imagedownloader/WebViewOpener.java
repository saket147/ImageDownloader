package com.example.saket.imagedownloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class WebViewOpener extends AppCompatActivity {

    private WebView wv1;
    String newString;
    String Url = "https://www.google.co.in/";
    EditText editText;
    Button hit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_opener);
        editText = (EditText)findViewById(R.id.addUrl);
        hit =(Button)findViewById(R.id.hit);
        /*Bundle extras = getIntent().getExtras();
        if(extras == null) {
            newString= null;
        } else {
            newString= extras.getString("URL");
        }*/
        Toast.makeText(this,Url,Toast.LENGTH_SHORT).show();
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv1=(WebView)findViewById(R.id.webview);
                wv1.setWebViewClient(new MyBrowser());
                wv1.getSettings().setLoadsImagesAutomatically(true);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv1.loadUrl(editText.getText().toString());

            }
        });
        /*wv1=(WebView)findViewById(R.id.webview);
        wv1.setWebViewClient(new MyBrowser());
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(editText.getText().toString());*/
        try {
            wv1.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            editText.setVisibility(View.INVISIBLE);
                            getSupportActionBar().show();
                            break;
                        case MotionEvent.ACTION_UP:
                            editText.setVisibility(View.VISIBLE);
                            getSupportActionBar().hide();
                            break;
                        default: break;
                    }
                    return false;
                }
            });
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }


    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
