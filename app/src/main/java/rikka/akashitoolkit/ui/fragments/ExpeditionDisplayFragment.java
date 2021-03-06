package rikka.akashitoolkit.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rikka.akashitoolkit.R;
import rikka.akashitoolkit.adapter.ViewPagerStateAdapter;
import rikka.akashitoolkit.support.Statistics;
import rikka.akashitoolkit.ui.MainActivity;

/**
 * Created by Rikka on 2016/3/14.
 */
public class ExpeditionDisplayFragment extends BaseDrawerItemFragment {
    private ViewPager mViewPager;

    @Override
    protected boolean getTabLayoutVisible() {
        return true;
    }

    @Override
    public void onShow() {
        super.onShow();

        MainActivity activity = ((MainActivity) getActivity());
        activity.getTabLayout().setupWithViewPager(mViewPager);
        activity.getSupportActionBar().setTitle(getString(R.string.expedition));

        Statistics.onFragmentStart("ExpeditionDisplayFragment");
    }

    @Override
    public void onHide() {
        super.onHide();

        Statistics.onFragmentEnd("ExpeditionDisplayFragment");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_viewpager, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mViewPager.setAdapter(getAdapter());

        if (!isHiddenBeforeSaveInstanceState()) {
            onShow();
        }

        return view;
    }

    private ViewPagerStateAdapter getAdapter() {
        ViewPagerStateAdapter adapter = new ViewPagerStateAdapter(getChildFragmentManager()) {
            @Override
            public Bundle getArgs(int position) {
                Bundle bundle = new Bundle();
                bundle.putInt("TYPE", position);
                return bundle;
            }
        };
        adapter.addFragment(ExpeditionFragment.class, "镇守府海域");
        adapter.addFragment(ExpeditionFragment.class, "南西诸岛海域");
        adapter.addFragment(ExpeditionFragment.class, "北方海域");
        adapter.addFragment(ExpeditionFragment.class, "西方海域");
        adapter.addFragment(ExpeditionFragment.class, "南方海域");

        return adapter;
    }
}
