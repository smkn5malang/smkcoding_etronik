package com.adlubagusi.e_tronik;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.adlubagusi.e_tronik.adapter.CategoryAdapter;
import com.adlubagusi.e_tronik.adapter.SliderAdapter;
import com.adlubagusi.e_tronik.model.CategoryModel;
import com.adlubagusi.e_tronik.model.SliderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    /////////////////// baner slide
    private ViewPager bannerSliderViewPger;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;
    ////////////////// baner slide

    ////////////////// strip ad
    private ImageView stripAdImg;
    private ConstraintLayout stripAdContainer;
    ////////////////// strip ad

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
        categoryModelList.add(new CategoryModel("link", "Electronics"));
        categoryModelList.add(new CategoryModel("link", "Hardware"));
        categoryModelList.add(new CategoryModel("link", "TV"));
        categoryModelList.add(new CategoryModel("link", "Multimedia"));
        categoryModelList.add(new CategoryModel("link", "Storage"));
        categoryModelList.add(new CategoryModel("link", "Cable"));
        categoryModelList.add(new CategoryModel("link", "Camera"));
        categoryModelList.add(new CategoryModel("link", "Books"));
        categoryModelList.add(new CategoryModel("link", "Other"));


        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

        /////////////////// baner slide
        bannerSliderViewPger = view.findViewById(R.id.banner_slider_viewpager);
        sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.mipmap.slide1, "#F15A25"));
        sliderModelList.add(new SliderModel(R.mipmap.slide2, "#014C90"));
        sliderModelList.add(new SliderModel(R.mipmap.slide3, "#EAEAEA"));

        sliderModelList.add(new SliderModel(R.mipmap.slide4, "#B7B7B7"));
        sliderModelList.add(new SliderModel(R.mipmap.slide5, "#3E23A8"));
        sliderModelList.add(new SliderModel(R.mipmap.slide6, "#2780E4"));
        sliderModelList.add(new SliderModel(R.mipmap.slide1, "#F15A25"));
        sliderModelList.add(new SliderModel(R.mipmap.slide2, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.slide3, "#EAEAEA"));
        sliderModelList.add(new SliderModel(R.mipmap.slide4, "#B7B7B7"));

        sliderModelList.add(new SliderModel(R.mipmap.slide5, "#3E23A8"));
        sliderModelList.add(new SliderModel(R.mipmap.slide6, "#2780E4"));

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPger.setAdapter(sliderAdapter);
        bannerSliderViewPger.setClipToPadding(false);
        bannerSliderViewPger.setPageMargin(20);

        bannerSliderViewPger.setCurrentItem(currentPage);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if(i == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };
        bannerSliderViewPger.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();

        bannerSliderViewPger.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideShow();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });

        /////////////////// baner slide

        ////////////////// strip ad
        stripAdImg = view.findViewById(R.id.strip_ad_img);
        stripAdContainer = view.findViewById(R.id.strip_ad_container);

        stripAdImg.setImageResource(R.mipmap.bannerasus);
        stripAdImg.setBackgroundColor(Color.parseColor("#000000"));
        ////////////////// strip ad

        return view;

    }
    /////////////////// baner slide
    private void pageLooper(){
        if(currentPage == sliderModelList.size() - 2){
            currentPage = 2;
            bannerSliderViewPger.setCurrentItem(currentPage, false);
        }
        if(currentPage == 1){
            currentPage = sliderModelList.size() - 3;
            bannerSliderViewPger.setCurrentItem(currentPage, false);
        }
    }

    private void startBannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPger.setCurrentItem(currentPage++, true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME, PERIOD_TIME);
    }
    private void stopBannerSlideShow(){
        timer.cancel();
    }
    /////////////////// baner slide

}
