package com.example.messenger.presentation;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messenger.databinding.LatestMessageRowBinding;
import com.example.messenger.presentation.models.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder>{

    private final List<User> users;
    private final UserListener userListener;

    public UsersAdapter(List<User> users, UserListener userListener) {
        this.users = users;
        this.userListener = userListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LatestMessageRowBinding latestMessageRowBinding = LatestMessageRowBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new UserViewHolder(latestMessageRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setUserData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        LatestMessageRowBinding binding;


        UserViewHolder(LatestMessageRowBinding latestMessageRowBinding) {
            super(latestMessageRowBinding.getRoot());
            binding = latestMessageRowBinding;
        }
        void setUserData(User user){
            binding.usernameTextviewLatestMessage.setText(user.getName());
            binding.latestMessageTextview.setText(user.getLatestMessage());
            binding.latestMsgTime.setText("12.20");
            binding.getRoot().setOnClickListener(v-> userListener.onUserClicked(user));
        }
    }
}
