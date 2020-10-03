//package com.manuja.shoppingapp.service;
//
//import com.manuja.shoppingapp.entity.SUserType;
//import com.manuja.shoppingapp.repository.UserTypeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class SUserTypeServiceImpl implements SUserTypeService {
//    @Autowired
//    private UserTypeRepository userTypeRepository;
//    @Override
//    public void Save(SUserType userType) {
//        userTypeRepository.save(userType);
//    }
//
//    @Override
//    public void Update(SUserType userType) {
//        userTypeRepository.save(userType);
//    }
//
//    @Override
//    public void Delete(SUserType userType) {
//        userTypeRepository.delete(userType);
//    }
//
//    @Override
//    public List<SUserType> findAll() {
//        return userTypeRepository.findAll();
//    }
//
//    @Override
//    public SUserType findById(Integer id) {
//       return userTypeRepository.findById(id).get();
//    }
//}
