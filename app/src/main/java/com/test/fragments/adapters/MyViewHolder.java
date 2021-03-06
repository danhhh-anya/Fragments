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
    private Button btnDeleteItem;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtDescription = itemView.findViewById(R.id.txtDescription);
        btnDeleteItem = itemView.findViewById(R.id.btnDeleteItem);
    }

    public void onBind(RecipeModel recipeModel, MyRvAdapter.OnItemClick listener){
        txtTitle.setText(recipeModel.getTitle());
        txtDescription.setText(recipeModel.getDescription());
        btnDeleteItem.setOnClickListener(v -> listener.onClick(recipeModel));
    }

}
