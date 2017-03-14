package com.oneponygames.frozen.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Icewind on 14.03.2017.
 */
public class EndlessIterator<E> implements Iterator<E> {

    private final List<E> data;
    private int index = 0;

    public EndlessIterator(List<E> data) {
        if(data.isEmpty())
            throw new IllegalArgumentException("No empty list is allowed!");
        this.data = data;
    }

    public EndlessIterator(E[] values) {
        this(Arrays.asList(values));
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public E next() {
        this.index++;
        if(index == data.size())
            this.index = 0;
        return this.data.get(this.index);
    }
}
