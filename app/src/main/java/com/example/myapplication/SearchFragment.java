package com.example.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView rcv_users;
    private UserAdapter userAdapter;
    private MenuItem menuItem;
    private SearchView searchView;
    private Toolbar toolbar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        menuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setIconified(true);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setId(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                filterList(query);
                return true;
            }
        });


        super.onCreateOptionsMenu(menu, inflater);
    }

//    private void mySearch(String query) {
//        List<User> filteredUsers = new ArrayList<>();
//
//        for (User user : getListUser()) {
//            if (user.getName().toLowerCase().contains(query.toLowerCase())) {
//                filteredUsers.add(user);
//            }
//        }
//
//        userAdapter.setData(filteredUsers);
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        rcv_users = view.findViewById(R.id.rcv_users);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcv_users.setLayoutManager(linearLayoutManager);
        userAdapter = new UserAdapter(getListUser());
        rcv_users.setAdapter(userAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rcv_users.addItemDecoration(itemDecoration);


        return view;

    }

    private void filterList(String text) {
        List<User> filteredList=new ArrayList<>();
        for(User user: getListUser()){
            if(user.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(user);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
        }else{
            userAdapter.setFilteredList(filteredList);
        }
    }


    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.conan2, "Van Y", "71505107", "2003-07-26", "k71E2"));
        list.add(new User(R.drawable.conan2, "Van N", "71505107", "2003-07-26", "k71E2"));
        list.add(new User(R.drawable.conan2, "Van L", "71505107", "2003-07-26", "k71E2"));
        list.add(new User(R.drawable.conan2, "Van X", "71505107", "2003-07-26", "k71E2"));
        list.add(new User(R.drawable.conan2, "Van A", "71505107", "2003-07-26", "k71E2"));
        list.add(new User(R.drawable.conan2, "Van B", "71505107", "2003-07-26", "k71E2"));
        list.add(new User(R.drawable.conan2, "Van C", "71505107", "2003-07-26", "k71E2"));
        list.add(new User(R.drawable.conan2, "Van E", "71505107", "2003-07-26", "k71E2"));
        list.add(new User(R.drawable.conan2, "Van F", "71505107", "2003-07-26", "k71E2"));

        return list;
    }
}