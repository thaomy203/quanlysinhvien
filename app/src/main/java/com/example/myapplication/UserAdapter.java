package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends  RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private List<Users>mListUsers;

    public UserAdapter(List<Users> mListUsers) {
        this.mListUsers = mListUsers;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Users users=mListUsers.get(position);
        if(users==null){
            return;
        }
        holder.imgUser.setImageResource(users.getImage());
        holder.tvName.setText(users.getName());
        holder.tvAddress.setText(users.getAddress());
    }

    @Override
    public int getItemCount() {
        if(mListUsers!=null){
            return mListUsers.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView imgUser;
        private TextView tvName;
        private TextView tvAddress;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser=itemView.findViewById(R.id.img_user);
            tvName=itemView.findViewById(R.id.tv_name);
            tvAddress=itemView.findViewById(R.id.tv_address);
        }
    }
    public void filterList(List<Users> filteredList) {
        mListUsers = filteredList;
        notifyDataSetChanged();
    }
}
