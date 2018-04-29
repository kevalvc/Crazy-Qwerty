package com.keval.crazyqwerty;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.animation.DefaultAnimations;
import com.willowtreeapps.spruce.sort.DefaultSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Guest2 on 4/7/2018.
 */

public class WordsData extends AppCompatActivity {

    RecyclerView myList;
    private List<Wordy> AllWords = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                //Animate in the visible children
                Animator spruceAnimator = new Spruce
                        .SpruceBuilder(mRecyclerView)
                        .sortWith(new DefaultSort(100))
                        .animateWith(DefaultAnimations.shrinkAnimator(mRecyclerView, 800),
                                ObjectAnimator.ofFloat(mRecyclerView, "translationX", -mRecyclerView.getWidth(), 0f).setDuration(800))
                        .start();
            }
        };

        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new MyAdapter(AllWords);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);

        Wordy wordy;

        SharedPreferences sp3 = getSharedPreferences("com.keval.crazyqwerty", Context.MODE_PRIVATE);
        Set<String> wordData = sp3.getStringSet("WordsLister", new HashSet<String>());
        Set<String> meaningData = sp3.getStringSet("MeaningLister", new HashSet<String>());

        Log.v("TAG", wordData.toString());
        Log.v("TAG", meaningData.toString());

        Iterator it1 = wordData.iterator();
        Iterator it2 = meaningData.iterator();
        while(it1.hasNext() && it2.hasNext()) {
            String value1 = it1.next().toString();
            String value2 = it2.next().toString();
            Log.i("NEEDY Word ",value1);
            Log.i("NEEDY Meanings ",value2);

            wordy = new Wordy(value1, value2);
            AllWords.add(wordy);

        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        //Display alert message when back button has been pressed

        Intent z = new Intent(getApplicationContext(), GameOver.class);
        startActivity(z);

        return;
    }
}

