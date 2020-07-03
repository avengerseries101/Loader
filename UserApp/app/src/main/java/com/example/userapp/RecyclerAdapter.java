package com.example.userapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private String[][] userList;

    public RecyclerAdapter(String[][] userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(parent.getContext());
        View view = myInflater.inflate(R.layout.list_item_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        String userName = userList[position][0];
        String userEmail = userList[position][1];
        String userContact = userList[position][2];
        holder.txtName.setText("Name : " + userName);
        holder.txtEmail.setText("Email : " + userEmail);
        holder.txtContact.setText("Contact : " + userContact);

    }

    @Override
    public int getItemCount() {
        return userList.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        Context context;
        TextView txtName;
        TextView txtEmail;
        TextView txtContact;

        public RecyclerViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.textName);
            txtEmail = itemView.findViewById(R.id.textEmail);
            txtContact = itemView.findViewById(R.id.textContact);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    txtName.setText("You Viewed your Data!!");
                    txtEmail.setText("");
                    txtContact.setText("");
                }
            });
        }
    }

}
