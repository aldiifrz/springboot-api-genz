package com.boniewijaya2021.springboot.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class MobilPojo {

    private String costumerName;
    private int costumerAge;
    private String costumerCity;
    private String costumerType;
    private List<MobilType> salesItem;

    @Setter
    @Getter
    public static class MobilType implements Serializable {
        private String mobilName;
        private List<String> mobilModel;
    }


}
