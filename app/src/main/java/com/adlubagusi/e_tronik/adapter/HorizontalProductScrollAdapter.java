package com.adlubagusi.e_tronik.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adlubagusi.e_tronik.R;
import com.adlubagusi.e_tronik.model.HorizontalProductScrollModel;

import java.util.List;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder> {

    private List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public HorizontalProductScrollAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @NonNull
    @Override
    public HorizontalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.ViewHolder viewHolder, int position) {
        int resource = horizontalProductScrollModelList.get(position).getProductImg();
        String title = horizontalProductScrollModelList.get(position).getProductTitle();
        String desc = horizontalProductScrollModelList.get(position).getProductDesc();
        String price = horizontalProductScrollModelList.get(position).getProductPrice();

        viewHolder.setProductImg(resource);
        viewHolder.setProductTitle(title);
        viewHolder.setProductDesc(desc);
        viewHolder.setProductPrice(price);
    }

    @Override
    public int getItemCount() {
        return horizontalProductScrollModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImg;
        private TextView productTitle, productDesc, productPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImg = itemView.findViewById(R.id.h_s_product_img);
            productTitle = itemView.findViewById(R.id.h_s_product_title);
            productDesc = itemView.findViewById(R.id.h_s_product_desc);
            productPrice = itemView.findViewById(R.id.h_s_product_price);

        }

        private void setProductImg(int resource){
            productImg.setImageResource(resource);
        }
        private void setProductTitle(String title){
            productTitle.setText(title);
        }
        private void setProductDesc(String desc){
            productDesc.setText(desc);
        }
        private void setProductPrice(String price){
            productPrice.setText(price);
        }
    }
}
