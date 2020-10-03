package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.Log;

import java.util.List;

public interface LogService {
    public void Save(Log log);
    public void Update(Log log);
    public void Delete(Log log);
    public Log FindById(Integer id);
    public List<Log> FindAll();
}
