package com.wikrgroup.testapp.users.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wikrgroup.testapp.R;
import com.wikrgroup.testapp.common.events.RecyclerViewClickListener;
import com.wikrgroup.testapp.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ovitaliy on 19.04.2017.
 */

class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<User> users = new ArrayList<>(10);

    private RecyclerViewClickListener<User> viewClickListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view, viewClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    void add(List<User> users) {
        int newItemsCount = users.size();
        int currentListSize = getItemCount();

        this.users.addAll(users);
        notifyItemRangeInserted(currentListSize, newItemsCount);
    }

    ArrayList<User> getItems() {
        return users;
    }

    void set(ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    void setViewClickListener(RecyclerViewClickListener<User> viewClickListener) {
        this.viewClickListener = viewClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView userIdView;
        private final TextView userNameView;
        private final TextView userEmailView;
        private final RecyclerViewClickListener<User> viewClickListener;

        ViewHolder(View itemView, RecyclerViewClickListener<User> viewClickListener) {
            super(itemView);
            this.viewClickListener = viewClickListener;
            userIdView = (TextView) itemView.findViewById(R.id.itemUserId);
            userNameView = (TextView) itemView.findViewById(R.id.itemUserName);
            userEmailView = (TextView) itemView.findViewById(R.id.itemUserEmail);
            itemView.setOnClickListener(this);
        }

        public void setData(User user) {
            itemView.setTag(user);
            userIdView.setText(String.valueOf(user.getId()));
            userNameView.setText(user.getName());
            userEmailView.setText(user.getEmail());
        }

        @Override
        public void onClick(View v) {
            viewClickListener.recyclerViewListClicked((User) itemView.getTag(), getAdapterPosition());
        }
    }

}
