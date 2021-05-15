package com.example.newsapp

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val progressbar=findViewById<ProgressBar>(R.id.progressbar)
        val myWebView = findViewById<WebView>(R.id.webView)
       val intentValue=intent.getStringExtra("url")
        if (intentValue != null) {
           // myWebView.loadUrl(intentValue)
            //myWebView.settings.setSupportZoom(true)
            myWebView.webViewClient=object :WebViewClient(){
                override fun onPageStarted(view: WebView?, intentValue: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, intentValue, favicon)
                    if (view != null) {
                        view.visibility=View.INVISIBLE
                    }
                    progressbar.visibility=View.VISIBLE
                }

                override fun onPageFinished(view: WebView?, intentValue: String?) {
                    super.onPageFinished(view, intentValue)
                    if (view != null) {
                        view.visibility=View.VISIBLE
                    }
                    progressbar.visibility=View.INVISIBLE
                }
            }
            myWebView.loadUrl(intentValue)
        }
    }
}

