package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.entity.Log;
import com.manuja.shoppingapp.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogRepository logRepository;
    @Override
    public void Save(Log log) {
        logRepository.save(log);
    }

    @Override
    public void Update(Log log) {
        logRepository.save(log);
    }

    @Override
    public void Delete(Log log) {
        logRepository.delete(log);
    }

    @Override
    public Log FindById(Integer id) {
        return logRepository.findById(id).get();
    }

    @Override
    public List<Log> FindAll() {
        return logRepository.findAll();
    }
}
