package com.fym.service;

import com.fym.entity.Message;

public interface MsgService extends BaseService<Message> {

    /**
     * 后台控制台查留言数
     * @return
     */
    int selectByCon();
}
