package com.example.firstapp.ui.contact;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstapp.MainActivity;
import com.example.firstapp.R;
import com.example.firstapp.contactA;
import com.example.firstapp.contactB;
import com.example.firstapp.contactC;
import com.example.firstapp.contactD;

public class contact extends Fragment {

    TextView textView;

    private ContactViewModel mViewModel;

    public static contact newInstance() {
        return new contact();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_contact, container, false);
        textView = view.findViewById(R.id.contact1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), contactA.class);
                startActivity(intent);
            }
        });
        textView = view.findViewById(R.id.contact2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), contactB.class);
                startActivity(intent);
            }
        });
        textView = view.findViewById(R.id.contact3);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), contactC.class);
                startActivity(intent);
            }
        });
        textView = view.findViewById(R.id.contact4);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), contactD.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        // TODO: Use the ViewModel
    }

}