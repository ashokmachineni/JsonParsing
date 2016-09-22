package com.prince.jsonparsing;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.prince.jsonparsing.Model.childModel;
import com.prince.jsonparsing.Model.tempItem;
import com.prince.jsonparsing.adapter.content_adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCE on 9/22/2016.
 */
public class ContentActivity extends Activity {

   ListView list_content;
    public ArrayList<childModel> contentlist = new ArrayList<childModel>();
    content_adapter ad_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        list_content=(ListView)findViewById(R.id.listView_content);


        contentlist=tempItem.tmp_content;

        ad_content = new content_adapter(ContentActivity.this, R.layout.content_adapter, contentlist);
        list_content.setAdapter(ad_content);
    }

}
