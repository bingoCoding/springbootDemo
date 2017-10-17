package com.example.springbatch.batch;

import com.example.springbatch.domain.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;

public class MyItemProcessor extends ValidatingItemProcessor<Person> {

    /**
     * ValidatingItemProcessor 数据较检
     * ItemProcessor 数据处理
     * @param person
     * @return
     * @throws Exception
     */
    @Override
    public Person process(Person person) {
        super.process(person);//数据较检,需要调用才会调用自定义较检器
        //数据处理
        if ("汉族".equals(person.getNation())){
            person.setNation("01");
        }else {
            person.setNation("02");
        }
        return person;
    }


}
