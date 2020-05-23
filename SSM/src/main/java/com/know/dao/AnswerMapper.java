package com.know.dao;

import java.util.Map;

public interface AnswerMapper {
    // 修改收藏数
    int modifyAnswerCollected(Map<String, Object> map);
    // 查询答主Id by answerId
    int queryAnswererIdByAnswerId(int answerId);
}
