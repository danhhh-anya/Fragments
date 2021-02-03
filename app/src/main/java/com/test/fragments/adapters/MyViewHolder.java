package com.test.fragments.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.fragments.R;
import com.test.fragments.models.RecipeModel;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView txtTitle;
    private TextView txtDescription;
    private Button DeleteItem;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtDescription = itemView.findViewById(R.id.txtDescription);
    }

    public void onBind(RecipeModel recipeModel, MyRvAdapter.OnItemClick listener){
        txtTitle.setText(recipeModel.getTitle());
        txtDescription.setText(recipeModel.getDescription());
        DeleteItem.setOnClickListener(v -> listener.onClick(recipeModel));
    }

}
