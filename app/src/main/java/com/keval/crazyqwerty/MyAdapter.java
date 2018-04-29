package com.keval.crazyqwerty;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Guest2 on 4/7/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Wordy> AllData;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView wordtitle, meaning;

        public ViewHolder(View view) {
            super(view);
            wordtitle = (TextView) view.findViewById(R.id.wordtitle);
            meaning = (TextView) view.findViewById(R.id.meaning);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Wordy> AllData) {
        this.AllData = AllData;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleton, parent, false);

        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Wordy wordy = AllData.get(position);
        holder.wordtitle.setText(wordy.getTitle());
        holder.meaning.setText(wordy.getMeaning());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return AllData.size();
    }
}
