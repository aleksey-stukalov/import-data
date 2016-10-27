package com.company.importdata.service.ordermanagement;

import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.global.AppBeans;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service(OrderNumberGeneratorService.NAME)
public class OrderNumberGeneratorServiceBean implements OrderNumberGeneratorService {

    private static final String SEQ_PREFIX = "order_num_";

    @Override
    public String getOrderNumber() {
        return getOrderNumber(new Date());
    }

    @Override
    public String getOrderNumber(Date datedFrom) {
        UniqueNumbersAPI numbersBean = AppBeans.get(UniqueNumbersAPI.NAME);

        String date = new SimpleDateFormat("yyyy-MM-dd").format(datedFrom);
        String seq_postfix = new SimpleDateFormat("yyyyMM").format(datedFrom);
        String seqName = SEQ_PREFIX.concat(seq_postfix);
        Long number = numbersBean.getNextNumber(seqName);

        return date.concat("-").concat(number.toString());
    }
}