package com.geektech.hv2_m2.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import com.geektech.hv2_m2.R;


abstract public class BaseFragment<VB extends ViewBinding> extends Fragment {

    protected VB binding;
    protected NavController controller;

    protected abstract VB bind();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = bind();
        controller = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);
        setupUI();
        setupObserver();
        return binding.getRoot();
    }

    protected abstract void setupUI();


    protected void setupObserver() {

    }
}
