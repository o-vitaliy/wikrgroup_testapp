package com.wikrgroup.testapp.users.list;

import com.wikrgroup.testapp.di.scopes.Scope;
import com.wikrgroup.testapp.di.scopes.Scopes;
import com.wikrgroup.testapp.models.dataSources.UsersRepositoryComponent;

import dagger.Component;

@Scope(Scopes.VIEW)
@Component(
        modules = {
                UsersListPresenterModule.class,
        },
        dependencies = {
                UsersRepositoryComponent.class,
        }
)
interface UsersListComponent {

    void inject(UsersListFragment findActivity);
}
