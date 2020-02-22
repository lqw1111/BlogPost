package com.example.demo.helper;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final String ID = "id";
    public static final String READS = "reads";
    public static final String LIKES = "likes";
    public static final String POPULARITY = "popularity";

    public static final String DESC = "desc";
    public static final String ASC = "asc";

    public static final String TAGS = "Tags";
    public static final String SORT_BY = "sortBy";
    public static final String DIRECTION = "direction";

    public static final List<String> LIST_SORT_BY = Arrays.asList(ID, READS, LIKES, POPULARITY);
    public static final List<String> LIST_DIRECTION = Arrays.asList(DESC, ASC);
}
