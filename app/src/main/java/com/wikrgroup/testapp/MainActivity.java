package com.wikrgroup.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wikrgroup.testapp.models.User;
import com.wikrgroup.testapp.users.list.UsersListFragment;
import com.wikrgroup.testapp.users.view.UserFragment;

public class MainActivity extends AppCompatActivity implements UsersListFragment.OnUserSelectListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            final String tag = "userList";
            UsersListFragment usersListFragment = new UsersListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.mainContainer, usersListFragment, tag)
                    .commit();
        }
    }

    @Override
    public void onUserSelected(User user) {
        final String tag = "viewUser";
        UserFragment usersListFragment = UserFragment.newInstance(user);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainContainer, usersListFragment, tag)
                .addToBackStack(tag)
                .commit();
    }
}
