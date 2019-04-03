package com.example.lenovo.rover;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class URLSEARCH extends AppCompatActivity implements View.OnClickListener {


    private Button searchB;
    private EditText urlsearch;
    private WebView webView;
    ProgressBar superProgressBar;

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlsearch);


        searchB=(Button)findViewById(R.id.button2);
        urlsearch=(EditText) findViewById(R.id.editText2);
        webView=(WebView)findViewById(R.id.mywebView2);
        superProgressBar=findViewById(R.id.myProgressBar);


        superProgressBar.setMax(100);

        url=getIntent().getExtras().get("url_search").toString();
        urlsearch.setText(url);


        searchB.setOnClickListener(this);



        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onClick(View view) {
        if(view==searchB)
        {
            searchwebadd();

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.super_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_back:
                onBackPressed();
                break;
            case R.id.menu_forward:
                onForwardPressed();
                break;

            case R.id.refresh:
                webView.reload();
                break;
            case R.id.share:
                Intent shareIntent=new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,url);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Copied Url");
                startActivity(Intent.createChooser(shareIntent,"Share Url"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onForwardPressed(){

        if(webView.canGoForward())
        {
            webView.goForward();
        }
        else{
            Toast.makeText(this,"Cannot Go Further",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else{
            finish();
        }



    }

    private void searchwebadd() {


        String url_search=urlsearch.getText().toString();
        if(TextUtils.isEmpty(url_search))
        {
            Toast empty=Toast.makeText(URLSEARCH.this,"Please,Enter Url or website",Toast.LENGTH_LONG);
            empty.show();
        }
        else
        {
            String url_without_http=url_search.replaceAll("https://www.","");
            String https="https://";
            String www="www.";
            Intent searchInt=new Intent(URLSEARCH.this,URLSEARCH.class);
            searchInt.putExtra("url_search",https+www+url_without_http);
            startActivity(searchInt);

            searchB.setText("");
            searchB.requestFocus();
        }



    }
}
