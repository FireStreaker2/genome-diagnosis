package com.medicationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.medicationapp.databinding.RemindersBinding;

import java.util.HashMap;

public class Reminders extends Fragment {

    // hashmap to store *placeholder* data
    //
    // note that we will change this in the future
    // to represent actual user data, but during
    // development placeholder data will be kept
    private final HashMap<String, String> data = new HashMap<String, String>() {{
        put("go outside", "my friends told me to");
        put("watch anime", "my doctor said its healthy");
        put("test", "i need coffee");
    }};
    private RemindersBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = RemindersBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        LinearLayout reminderContainer = root.findViewById(R.id.reminder_container);

        // dynamically create reminders
        for (String i : data.keySet()) {
            LinearLayout layout = new LinearLayout(requireContext());
            layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));
            layout.setOrientation(LinearLayout.VERTICAL);

            TextView title = new TextView(requireContext());
            title.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            title.setText(i);
            title.setTextSize(24);

            TextView description = new TextView(requireContext());
            description.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            description.setText(data.get(i));

            layout.addView(title);
            layout.addView(description);

            reminderContainer.addView(layout);
        }

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}