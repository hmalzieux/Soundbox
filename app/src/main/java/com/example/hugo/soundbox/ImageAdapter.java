package com.example.hugo.soundbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Object[][] contenu;
    private LayoutInflater inflater;
    public ImageAdapter(Context c, Object[][] contenu) {
        mContext = c;
        this.contenu = contenu;
    }

    public int getCount() {
        return contenu.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;

        if (convertView == null) {
            inflater =(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.item_box, null);
        }
        ImageView imageView = (ImageView) gridView.findViewById(R.id.img);
        TextView textView = (TextView) gridView.findViewById(R.id.text);
        imageView.setImageResource(R.drawable.sound);
        textView.setText((String)contenu[position][1]);
        return gridView;
    }
}
