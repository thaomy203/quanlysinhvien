package com.example.myapplication;

import static java.util.Locale.filter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<Users> userList;
    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Replace the following lines with actual user data
        List<Users> originalUserList = new ArrayList<>();
        originalUserList.add(new Users(R.drawable.conan2, "User 1", "Address 1"));
        originalUserList.add(new Users(R.drawable.tabi, "User 2", "Address 2"));
        originalUserList.add(new Users(R.drawable.tabi, "User 3", "Address 3"));
        // ... Add more users as needed

        // Get the first 3 users from the original list
        userList = originalUserList.subList(0, Math.min(originalUserList.size(), 3));
    }
    private void filter(String text) {
        List<Users> filteredList = new ArrayList<>();
        for (Users user : userList) {
            if (user.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(user);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Add the DividerItemDecoration with the desired height (in pixels)
        int dividerHeightInPixels = getResources().getDimensionPixelSize(R.dimen.divider_height);
        recyclerView.addItemDecoration(new DivideritemDecoration(getActivity(), dividerHeightInPixels));

        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
        View view1 = inflater.inflate(R.layout.fragment_search, container, false);



        EditText etSearch = view.findViewById(R.id.et_search);
        ImageButton btnClear = view.findViewById(R.id.btn_clear);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    btnClear.setVisibility(View.VISIBLE);
                } else {
                    btnClear.setVisibility(View.INVISIBLE);
                }
                filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etSearch.setText("");
            }
        });

        return view;
    }

}