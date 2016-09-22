package com.prince.jsonparsing.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.prince.jsonparsing.Model.childModel;
import com.prince.jsonparsing.R;
import com.prince.jsonparsing.UILUtils;

import java.util.ArrayList;

/**
 * Created by PRINCE on 9/22/2016.
 */
public class content_adapter extends ArrayAdapter<childModel> {
    private Activity context;
    private int mResource;
    private ArrayList<childModel> itemName;
    AlertDialog mAlertDialog;

    public content_adapter(Activity context, int itemResourceId,
                            ArrayList<childModel> list) {
        super(context, itemResourceId, list);
        this.context = context;
        this.mResource = itemResourceId;
        this.itemName = list;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = null;
        if (null == convertView) {
            LayoutInflater inflater = context.getLayoutInflater();
            v = inflater.inflate(mResource, null);

        } else {
            v = convertView;
        }
        childModel content_Item = itemName.get(position);

        TextView title= (TextView) v.findViewById(R.id.txt_title);
        TextView image=(TextView)v.findViewById(R.id.txt_image);
        TextView video=(TextView)v.findViewById(R.id.txt_video);

        title.setText(content_Item.title);
        image.setText(content_Item.poster);
        video.setText(content_Item.videoUrl);
        return v;
    }

    private void showImage(String url, ImageView img) {
//        new DownloadImage().execute(url);
        UILUtils.displayImage(context, url, img);
    }
}
