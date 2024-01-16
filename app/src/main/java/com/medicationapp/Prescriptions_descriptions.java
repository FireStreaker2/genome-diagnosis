package com.medicationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.medicationapp.databinding.PrescriptionsDescriptionsBinding;

public class Prescriptions_descriptions extends Fragment {
    private PrescriptionsDescriptionsBinding binding;
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = PrescriptionsDescriptionsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
