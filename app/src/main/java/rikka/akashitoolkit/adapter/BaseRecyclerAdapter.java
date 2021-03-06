package rikka.akashitoolkit.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.squareup.otto.Subscribe;

import java.util.List;

import rikka.akashitoolkit.otto.BusProvider;
import rikka.akashitoolkit.otto.DataChangedAction;

/**
 * Created by Rikka on 2016/4/13.
 */
public abstract class BaseRecyclerAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    /*protected Object busEventListener;

    public BaseRecyclerAdapter() {
        busEventListener = new Object() {
            @Subscribe
            public void dataChanged(final DataChangedAction event) {
                BaseRecyclerAdapter.this.dataChanged(event);
            }
        };

        BusProvider.instance().register(busEventListener);
    }*/

    public abstract void rebuildDataList();

    public void onDataListRebuilt(List data) {

    }

    /*@Subscribe
    public void dataChanged(DataChangedAction action) {
        Log.d("QAQ", action.getClassName());
        if (action.getClassName().equals(getClass().getName())) {
            rebuildDataList();
        }
    }*/
}
