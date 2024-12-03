package com.Bank.app.Utils;

import com.Bank.app.Response.PageResponse;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class BuilderUtil {
    public static PageResponse buildPageResponseFromBuilder(List<?> listData, Integer pageNo, Integer pageSize) {
        int fromIndex = (pageNo - 1) * pageSize;
        int toIndex = Math.min((pageNo * pageSize), listData.size());
        return PageResponse.builder()
                .data(fromIndex > listData.size() ? new ArrayList<>() :
                        listData.subList(fromIndex, toIndex))
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPage((int) Math.ceil(listData.size() / (float) pageSize))
                .totalElement((long) listData.size())
                .firstPage(pageNo == 1)
                .lastPage(pageNo == ((int) Math.ceil(listData.size() /
                        (float) pageSize)))
                .fromIndex(fromIndex + 1)
                .toIndex(toIndex)
                .build();
    }
}
