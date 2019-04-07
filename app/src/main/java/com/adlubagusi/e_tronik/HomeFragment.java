package com.adlubagusi.e_tronik;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.adlubagusi.e_tronik.adapter.CategoryAdapter;
import com.adlubagusi.e_tronik.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);
        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link", "Hand Phone"));
        categoryModelList.add(new CategoryModel("link", "Laptop"));
        categoryModelList.add(new CategoryModel("link", "TV"));
        categoryModelList.add(new CategoryModel("link", "Electronics"));
        categoryModelList.add(new CategoryModel("link", "Hardware"));
        categoryModelList.add(new CategoryModel("link", "Casing"));
        categoryModelList.add(new CategoryModel("link", "Network Tools"));
        categoryModelList.add(new CategoryModel("link", "Cable"));
        categoryModelList.add(new CategoryModel("link", "Module"));
        categoryModelList.add(new CategoryModel("link", "Books"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
        return view;
    }
}
