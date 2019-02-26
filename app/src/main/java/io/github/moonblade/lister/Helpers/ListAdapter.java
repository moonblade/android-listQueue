package io.github.moonblade.lister.Helpers;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.github.moonblade.lister.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    ListQueue listQueue;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.title);
        }
    }

    public ListAdapter(ListQueue listQueue) {
        this.listQueue = listQueue;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d("ListAdapter", "onBindViewHolder: " + listQueue.getQueue().get(i).getTitle());
        viewHolder.title.setText(listQueue.getQueue().get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return listQueue.getQueue().size();
    }
}
