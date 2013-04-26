package com.zeng.throwingprovider;

import com.google.inject.throwingproviders.CheckedProvider;

public interface GeneralProVider<T> extends CheckedProvider<T> {
    @Override
    public T get() throws Exception;
}