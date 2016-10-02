package com.yapd.alexander.yapd.core.usecase.entrepreneurship;

import com.yapd.alexander.yapd.core.model.Venture;

import java.util.List;

import rx.Observable;

/**
 * Created by alexander on 9/25/16.
 */
public class GetVentures {
    public Observable<List<Venture>> list() {
        return getDataSource().index();
    }

    private VenturesDataSource getDataSource() {
        return new VenturesDataStore();
    }
}
