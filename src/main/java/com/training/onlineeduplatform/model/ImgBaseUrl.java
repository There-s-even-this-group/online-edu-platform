package com.training.onlineeduplatform.model;

import lombok.Data;

/**
 * Created on 2020/2/22.
 *
 * @author Hongwe Xiong
 */
@Data
public class ImgBaseUrl {
    private String basePah;

    public void setBasePah(String basePah) {
        this.basePah = basePah;
    }

    public String getBasePah() {
        return basePah;
    }
}
