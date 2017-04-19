package com.wikrgroup.testapp.users.list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wikrgroup.testapp.R;
import com.wikrgroup.testapp.WikrApp;
import com.wikrgroup.testapp.models.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class UsersListFragment extends Fragment implements UsersListContract.View {

    private OnUserSelectListener onUserSelectListener;

    @Inject
    UsersListPresenter presenter;


    private ContentLoadingProgressBar contentLoadingProgressBar;
    private Adapter usersListAdapter;

    public UsersListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnUserSelectListener) {
            onUserSelectListener = (OnUserSelectListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnUserSelectListener");
        }

        DaggerUsersListComponent.builder()
                .usersRepositoryComponent(((WikrApp) getActivity().getApplication()).usersRepositoryComponent())
                .usersListPresenterModule(new UsersListPresenterModule(this))
                .build().inject(this);

        usersListAdapter = new Adapter();
        usersListAdapter.setViewClickListener((user, position) -> onUserSelectListener.onUserSelected(user));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_users_list_fragmnet, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contentLoadingProgressBar = (ContentLoadingProgressBar) view.findViewById(R.id.usersListProgressBar);

        RecyclerView usersListView = (RecyclerView) view.findViewById(R.id.usersList);
        usersListView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        usersListView.setLayoutManager(new LinearLayoutManager(getContext()));
        usersListView.setAdapter(usersListAdapter);

        if (savedInstanceState == null) {
            presenter.load();
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        onUserSelectListener = null;
    }

    @Override
    public void showProgressBar() {
        contentLoadingProgressBar.show();
    }

    @Override
    public void hideProgressBar() {
        contentLoadingProgressBar.hide();
    }

    @Override
    public void showUserList(List<User> users) {
        usersListAdapter.add(users);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("users", usersListAdapter.getItems());
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            @SuppressWarnings("unchecked")
            ArrayList<User> users = (ArrayList<User>) savedInstanceState.getSerializable("users");
            usersListAdapter.set(users);
        }
    }

    @Override
    public boolean isActive() {
        return isVisible();
    }

    public interface OnUserSelectListener {
        void onUserSelected(User user);
    }

}
