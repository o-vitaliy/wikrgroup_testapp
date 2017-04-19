package com.wikrgroup.testapp.users.list;

import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Uran on 1/4/2017.
 */
@Module
class UsersListPresenterModule {

    private UsersListContract.View view;

    UsersListPresenterModule(UsersListContract.View view) {
        this.view = checkNotNull(view);
    }

    @Provides
    UsersListContract.View provideUserListContractView() {
        return view;
    }

}
