package com.fym.service.imp;

import com.fym.dao.MessageMapper;
import com.fym.entity.Message;
import com.fym.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceImp implements MsgService {
    @Autowired
    MessageMapper mapper;

    @Override
    public List<Message> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public void add(Message message) {
        mapper.insert(message);
    }

    @Override
    public void delect(long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Message message) {
        mapper.updateByPrimaryKey(message);
    }

    @Override
    public Message selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
