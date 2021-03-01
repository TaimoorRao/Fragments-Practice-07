package com.example.task08;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class TabFragment3 extends Fragment {
    ConstraintLayout mLayout;
    ImageView mImage;
    int mColor;
    Button mButton_color;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);
        mImage = (ImageView) view.findViewById(R.id.image_filter);
        mButton_color = (Button) view.findViewById(R.id.btn_color_picker);
        mButton_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
        return view;
    }
    public void openColorPicker(){
        AmbilWarnaDialog picker_color = new AmbilWarnaDialog(TabFragment3.super.getContext(),mColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mColor = color;
                mImage.setBackgroundColor(mColor);
            }
        });
        picker_color.show();
    }
}