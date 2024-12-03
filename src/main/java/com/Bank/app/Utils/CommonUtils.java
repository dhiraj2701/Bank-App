package com.Bank.app.Utils;

import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class CommonUtils {
    public static LocalDateTime getLocalDateTime(){
        return LocalDateTime.now(ZoneOffset.UTC);
    }
    @SneakyThrows
    public static void paginationCheck(Integer pageNo,Integer pageSize){
        if(pageNo<1) throw new BadRequestException("page no can't be less than 1");
        if(pageSize<1) throw new BadRequestException("page size can't be less than 1");
    }
}
