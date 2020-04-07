package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<EarthquakeList>> {

    private String mUrl;
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<EarthquakeList> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<EarthquakeList> list = QueryUtils.fetchEarthquakeData(mUrl);
        return list;
    }
}
