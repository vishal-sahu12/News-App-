package com.example.mynews.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mynews.Adapter;
import com.example.mynews.ApiInterface;
import com.example.mynews.ApiUtilities;
import com.example.mynews.MainNews;
import com.example.mynews.ModelClass;
import com.example.mynews.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    String api = "9e28fceeb1f945e89d4d1cc68ab6c905";
    private RecyclerView recyclerViewHome;
    Adapter adapter;
    String country = "in";
    ArrayList<ModelClass> modelClassArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home,null);

        recyclerViewHome= v.findViewById(R.id.home_recyclerview);
        modelClassArrayList = new ArrayList<>();
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelClassArrayList);
        recyclerViewHome.setAdapter(adapter);
        
        findNews();
        return v;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getNews(country,50,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });

    }
}