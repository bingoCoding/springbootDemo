package com.example.springmvc.springdata;

import com.example.springmvc.springsecurity.Person;
import org.springframework.batch.item.ItemProcessor;
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
        String personName=person.getUsername().toUpperCase();
        person.setUsername(personName);
        return person;
    }


}
