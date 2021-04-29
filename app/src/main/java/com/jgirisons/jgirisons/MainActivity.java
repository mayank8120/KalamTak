package com.jgirisons.jgirisons;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class
MainActivity extends AppCompatActivity {

    WebView mywebview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mywebview = findViewById(R.id.webviewmain);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);


        //mywebview.setWebViewClient(new HostsWebClient());

        mywebview.getSettings().setLoadWithOverviewMode(true);
        mywebview.getSettings().setUseWideViewPort(true);
        mywebview.getSettings().setBuiltInZoomControls(true);
        mywebview.getSettings().setPluginState(WebSettings.PluginState.ON);


        mywebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        mywebview.getSettings().setSupportMultipleWindows(false);
        mywebview.getSettings().setSupportZoom(false);
        mywebview.setVerticalScrollBarEnabled(false);
        mywebview.setHorizontalScrollBarEnabled(false);

        //mywebview.setWebChromeClient(new MyChrome);

        //mywebview.getSettings().setAppCacheEnabled(true);
//      //mywebview.getSettings().setCacheMode(LOAD_DEFAULT);

        //mywebview.setWebViewClient(new WebViewClient());


//        WebViewClient webViewClient= new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView  view, String  url){
//                return true;
//            }
//            @Override
//            public void onLoadResource(WebView  view, String  url){
//                if( url.equals("https://www.kalamtak.com") ){
//
//                }
//            }
//        };
        initWebView();
        mywebview.loadUrl("https://www.kalamtak.com");

    }

    private void initWebView() {

        mywebview.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Toast.makeText(MainActivity.this, "" + request.getUrl().toString(), Toast.LENGTH_SHORT).show();


//                this is to test if links are working or not
                if (request.getUrl().toString().startsWith("https://www.kalamtak.com")) ;
//                {
//                    Toast.makeText(MainActivity.this, "kalam", Toast.LENGTH_SHORT).show();
//                }


//                else if(request.getUrl().toString().startsWith("https://www.faceook.com")){
//                      Toast.makeText(MainActivity.this, ""+request.getUrl().toString(), Toast.LENGTH_SHORT).show();
//                    Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
//
//                    facebookIntent.setData(Uri.parse(facebookUrl));
//                    startActivity(facebookIntent);
//                    Intent intent=new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(request.getUrl().toString()));
//                    startActivity(intent);
//                }


                else {

                    //this is toast to check what link is clicked
                    Toast.makeText(MainActivity.this, "" + request.getUrl().toString(), Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request.getUrl().toString()));
                    startActivity(intent);

                }
                return super.shouldOverrideUrlLoading(view, request);
            }


            //(Uri.parse(request.getUrl().toString()).getHost().endsWith("google.com"))

            //            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                /**
//                 * Check for the url, if the url is from same domain
//                 * open the url in the same activity as new intent
//                 * else pass the url to browser activity
//                 * */
//                if (Utils.isSameDomain(postUrl, url)) {
//                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                    intent.putExtra("postUrl", url);
//                    startActivity(intent);
//                } else {
//                    // launch in-app browser i.e BrowserActivity
//                    openInAppBrowser(url);
//                }
//
//                return true;
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                progressBar.setVisibility(View.GONE);
//            }
        });

    }


//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        mywebview.saveState(outState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        mywebview.restoreState(savedInstanceState);
//    }


    @Override
    public void onBackPressed() {
        if (mywebview.canGoBack()) {
            mywebview.goBack();
        } else {
            super.onBackPressed();
        }
    }


//    private class MyWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            if(Uri.parse(url).getHost().equals("https://www.kalamtak.com")){
//                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(url));
//                startActivity(intent);
//                return true;
//            }
//            else {
//
//
//                return false;
//            }
//
//            //return super.shouldOverrideUrlLoading(view, url);
//        }
//    }


}