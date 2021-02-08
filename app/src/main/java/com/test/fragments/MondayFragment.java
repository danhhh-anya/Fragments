package com.test.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.test.fragments.adapters.MyRvAdapter;
import com.test.fragments.models.RecipeModel;

import java.util.ArrayList;
import java.util.List;


public class MondayFragment extends BaseFragment {
    private RecyclerView rvList;
    private MyRvAdapter adapter;
    private Button Undo;
    private Button Add;
    private ArrayList<RecipeModel> list;

    private EditText setTitle;
    private EditText setDescription;

    private final MyRvAdapter.OnItemClick listener = this::Delete;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monday, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setTitle = view.findViewById(R.id.Title);
        setDescription = view.findViewById(R.id.Description);

        Undo = view.findViewById(R.id.btnUndo);
        Add = view.findViewById(R.id.btnAdd);


        list = (ArrayList<RecipeModel>) generateRecipes();
        adapter = new MyRvAdapter(list, listener);
        adapter.notifyDataSetChanged();

        rvList = view.findViewById(R.id.rvList);
        rvList.setAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        Add.setOnClickListener(v ->{
        Add();
        });
        Undo.setOnClickListener(v->{
        Delete();
        });
    }

    private void Delete(){
        adapter.notifyItemRemoved(list.size()-1);
        list.remove(list.size()-1);
    }
    private void Add(){
        adapter.notifyItemInserted(0);
        list.add(0, new RecipeModel(" " + setTitle.getText().toString() ," " + setDescription.getText().toString()));
    }
    private List<RecipeModel> generateRecipes(){
        ArrayList<RecipeModel> tmp = new ArrayList<>();
        for (int i = 0; i<10; i++){
            tmp.add(new RecipeModel("Title " + i, "Description " + i));
        } return tmp;
    }

    private void Delete (RecipeModel model){
        adapter.notifyItemRemoved(list.indexOf(model));
        list.remove(model);
    }
 /*   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Add.setOnClickListener(view ->{
            newAdd();
        });
      Undo.setOnClickListener(v->{

        });
    }*/

  /*  private void newAdd(){
        ArrayList<RecipeModel> tmp = new ArrayList<>();

        Add.setOnClickListener(view ->{
            for (int i = 0; i > 9; i++) {
                tmp.add(new RecipeModel("Title " + i, "Description " + i + 1));
            }
        });
    }*/


    @Override
    public String getTitle() {
        return "Mon";
    }

}
