package com.Bank.app.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResponse {
    private List data;
    private Integer totalPage;
    private long totalElement;
    private Integer pageNo;
    private Integer pageSize;
    private boolean firstPage;
    private boolean lastPage;
    private int fromIndex;
    private int toIndex;

}
