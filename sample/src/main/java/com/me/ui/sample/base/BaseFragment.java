package com.me.ui.sample.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * @author tangqi on 16-12-29.
 */

public class BaseFragment extends Fragment {

    protected static final String KEY_TITLE = "key_title";

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString(KEY_TITLE);
            setActionBarTitle(title);
        }
    }

    protected void setActionBarTitle(String title) {
        if (getActivity() != null) {
            getActivity().setTitle(title);
        }
    }

    protected void setActionBarTitle(int resId) {
        if (getActivity() != null) {
            getActivity().setTitle(resId);
        }
    }
}
