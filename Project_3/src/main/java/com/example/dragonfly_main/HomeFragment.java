package com.example.dragonfly_main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener {
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button checklist = getView().findViewById(R.id.createChecklist);

        checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShowListActivity();
            }
        });
    }

    public void openShowListActivity(){
        Intent intent = new Intent(this.getContext(), ShowListActivity.class);
        startActivity(intent);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);

    }


    @Override
    public void onClick(View view) {

        Fragment fragment = null;
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}





















