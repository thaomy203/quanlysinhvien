package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> mListUsers;

    public UserAdapter(List<User> mListUsers) {
        this.mListUsers = mListUsers;
    }

    public void setFilteredList(List<User> filteredList){
        this.mListUsers=filteredList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }
    public void setData(List<User> userList) {
        this.mListUsers = userList;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user=mListUsers.get(position);
        if(user==null){
            return;
        }
        holder.imgUser.setImageResource(user.getImage());
        holder.fullName.setText(user.getName());
        holder.nameClass.setText(user.getClassName());
        holder.studentId.setText(user.getId());
        holder.dateOfBirth.setText(user.getDate());
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
        private TextView fullName;
        private TextView studentId;
        private TextView nameClass;
        private TextView dateOfBirth;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser=itemView.findViewById(R.id.img_user);
            fullName=itemView.findViewById(R.id.fullName);
            studentId=itemView.findViewById(R.id.studentId);
            nameClass=itemView.findViewById(R.id.nameClass);
            dateOfBirth=itemView.findViewById(R.id.date);
        }
    }
}
