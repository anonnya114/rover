package com.example.lenovo.rover;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button searchButton;
    private EditText search;
    private ImageButton facebookbtn;
    private ImageButton youtubebtn;
    private ImageButton googlebtn;
    private ImageButton yahoobtn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton=(Button)findViewById(R.id.button);
        search=(EditText)findViewById(R.id.editText);


        facebookbtn=(ImageButton)findViewById(R.id.facebook);
        youtubebtn=(ImageButton)findViewById(R.id.youtube);
        googlebtn=(ImageButton)findViewById(R.id.google);
        yahoobtn=(ImageButton)findViewById(R.id.yahoo);

        facebookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==facebookbtn)
                {
                    Intent open_facebook=new Intent(MainActivity.this,URLSEARCH.class);
                    open_facebook.putExtra("url_search","https://www.facebook.com");
                    startActivity(open_facebook);

                }
            }
        });

        youtubebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==youtubebtn)
                {
                    Intent open_youtube=new Intent(MainActivity.this,URLSEARCH.class);
                    open_youtube.putExtra("url_search","https://www.youtube.com");
                    startActivity(open_youtube);

                }
            }
        });

        googlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==googlebtn)
                {
                    Intent open_google=new Intent(MainActivity.this,URLSEARCH.class);
                    open_google.putExtra("url_search","https://www.google.com");
                    startActivity(open_google);

                }
            }
        });

        yahoobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==yahoobtn)
                {
                    Intent open_yahoo=new Intent(MainActivity.this,URLSEARCH.class);
                    open_yahoo.putExtra("url_search","https://www.yahoo.com");
                    startActivity(open_yahoo);

                }
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==searchButton)
                {
                    openwebsite();
                }

            }

            private void openwebsite() {
                String url_search=search.getText().toString();
                if(TextUtils.isEmpty(url_search))
                {
                    Toast empty=Toast.makeText(MainActivity.this,"Please Enter Url or website",Toast.LENGTH_LONG);
                    empty.show();
                }
                else
                {
                    String url_without_http=url_search.replaceAll("https://www.","");
                    String https="https://";
                    String www="www.";
                    Intent searchInt=new Intent(MainActivity.this,URLSEARCH.class);
                    searchInt.putExtra("url_search",https+www+url_without_http);
                    startActivity(searchInt);
                }
            }
        });
    }
}
