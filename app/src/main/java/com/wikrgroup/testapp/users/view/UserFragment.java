package com.wikrgroup.testapp.users.view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wikrgroup.testapp.R;
import com.wikrgroup.testapp.models.User;
import com.wikrgroup.testapp.utils.FormatUtil;

import java.util.Locale;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserFragment extends Fragment {

    private User user;

    public static UserFragment newInstance(User user) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putSerializable("user", user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = checkNotNull((User) getArguments().getSerializable("user"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setText(view, R.string.user_name, R.id.userViewUserName, user.getUsername());
        setText(view, R.string.name, R.id.userViewName, user.getName());
        setText(view, R.string.email, R.id.userViewEmail, user.getEmail());
        setText(view, R.string.website, R.id.userViewWebsite, user.getWebsite());
        setText(view, R.string.phone, R.id.userViewPhone, user.getPhone());
        setText(view, R.string.address, R.id.userViewAddress, FormatUtil.formatAddress(user.getAddress()));
        setText(view, R.string.company, R.id.userViewCompany, FormatUtil.formatCompany(user.getCompany()));


    }

    @SuppressWarnings("deprecated")
    private static void setText(View rootView, @StringRes int stringId, @IdRes int id, String value) {
        String label = rootView.getResources().getString(stringId);
        String text = String.format(Locale.getDefault(), "<b>%s</b>: %s", label, value);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ((TextView) rootView.findViewById(id)).setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));
        } else {
            ((TextView) rootView.findViewById(id)).setText(Html.fromHtml(text));
        }
    }
}
