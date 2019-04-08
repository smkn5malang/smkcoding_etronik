package com.adlubagusi.e_tronik.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.adlubagusi.e_tronik.R;
import com.adlubagusi.e_tronik.model.HorizontalProductScrollModel;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {

    List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public GridProductLayoutAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout, null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));

            ImageView productImg = view.findViewById(R.id.h_s_product_img);
            TextView proudctTitle = view.findViewById(R.id.h_s_product_title);
            TextView proudctDesc = view.findViewById(R.id.h_s_product_desc);
            TextView proudctPrice = view.findViewById(R.id.h_s_product_price);

            productImg.setImageResource(horizontalProductScrollModelList.get(position).getProductImg());
            proudctTitle.setText(horizontalProductScrollModelList.get(position).getProductTitle());
            proudctDesc.setText(horizontalProductScrollModelList.get(position).getProductDesc());
            proudctPrice.setText(horizontalProductScrollModelList.get(position).getProductPrice());

        }else{
            view = convertView;
        }
        return view;
    }
}
