package com.prince.jsonparsing;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.reflect.TypeToken;
import com.prince.jsonparsing.Model.JSONUtils;
import com.prince.jsonparsing.Model.parentModel;
import com.prince.jsonparsing.Model.tempItem;

import java.lang.reflect.Type;

public class MainActivity extends Activity implements View.OnClickListener {

    public String URL="http://beroku.com/images/jsonsample.json";
    public parentModel parent = new parentModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_horror=(Button) findViewById(R.id.button);
        Button btn_codemy=(Button)findViewById(R.id.button2);
        Button btn_sicence=(Button)findViewById(R.id.button3);

        btn_horror.setOnClickListener(this);
        btn_codemy.setOnClickListener(this);
        btn_sicence.setOnClickListener(this);

        load_category();
    }

    private void load_category() {

        //Showing the progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Display...","Please wait...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Disimissing the progress dialog
                        loading.dismiss();

                        Type type = new TypeToken<parentModel>() {
                        }.getType();
                        parent = JSONUtils.parseJSONArray(s, type);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        loading.dismiss();
                    }
                });

        //Creating a Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.button): {
                tempItem.tmp_content = parent.Horror;
                Intent ii;
                ii = new Intent(MainActivity.this, ContentActivity.class);
                startActivity(ii);
                break;
            }

            case (R.id.button2): {
                tempItem.tmp_content = parent.Comedy;
                Intent ii;
                ii = new Intent(MainActivity.this, ContentActivity.class);
                startActivity(ii);
                break;
            }

            case (R.id.button3): {
                tempItem.tmp_content = parent.Science;
                Intent ii;
                ii = new Intent(MainActivity.this, ContentActivity.class);
                startActivity(ii);
                break;
            }
        }
    }
}
