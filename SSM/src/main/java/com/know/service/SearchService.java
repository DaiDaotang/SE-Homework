package com.know.service;

import com.know.pojo.User;

import java.util.List;
import java.util.Map;

public interface SearchService {
    Map<String, Object> query(int type, String keyword, int extra, int start, int count, int n);
}
