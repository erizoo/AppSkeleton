package com.bastau.app.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bastau.app.R;
import com.bastau.app.ui.auth.AuthActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ImageFragmentSeventh extends Fragment {

    @BindView(R.id.button)
    Button button;

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image_seventh, container, false);
        unbinder = ButterKnife.bind(this, v);
        button.setOnClickListener(m -> {
            startActivity(new Intent(getActivity(), AuthActivity.class));
            getActivity().finish();
        });
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
