package com.itzyf.validation;

import com.itzyf.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @Author： 1ml
 * @Description： TODO
 * @Date： 2024/4/15 23:33
 * @Version： 1.0
 */
public class StateValidation implements ConstraintValidator<State,String> {
    /**
     *
     * @param value 将来要校验的数据
     * @param context
     * @return  如果返回false，则校验不通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //提供校验规则
        if (value == null){
            return false;
        }
        if (value.equals("已发布")||value.equals("草稿")){
            return true;
        }

        return false;
    }
}
