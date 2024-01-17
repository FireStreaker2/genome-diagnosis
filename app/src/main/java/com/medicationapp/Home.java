package com.medicationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.medicationapp.databinding.HomeBinding;

public class Home extends Fragment {

    private HomeBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Example usage of scheduling a new notification (i used this for development)
//        long notificationTimeMillis = System.currentTimeMillis() + 2000;
//        Notification notification = new Notification(requireContext(), notificationTimeMillis, "test title", "take your meds");
//        notification.initialize(getActivity());

        binding = HomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}