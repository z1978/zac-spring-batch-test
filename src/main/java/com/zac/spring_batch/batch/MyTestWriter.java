package com.zac.spring_batch.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.zac.spring_batch.entity.people;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * @author 
 * @version
 * @since 2.0.0
 */

@Getter
@Setter
@Component
public class MyTestWriter implements ItemWriter<people> {
    private static final Logger logger = LoggerFactory.getLogger(MyTestWriter.class);
    @Override
    public void write(List<? extends people> peopleBean)
            throws Exception {
        // TODO Auto-generated method stub
        logger.debug("peopleBean count = [" + peopleBean.size() + "]");
        
        for (int i = 0; i < peopleBean.size(); i++) {
            logger.debug(peopleBean.get(i).getFirst_name());
        }
    }
}
