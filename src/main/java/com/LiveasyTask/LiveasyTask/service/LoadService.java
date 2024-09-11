package com.LiveasyTask.LiveasyTask.service;

import com.LiveasyTask.LiveasyTask.models.Load;
import com.LiveasyTask.LiveasyTask.models.LoadDto;
import com.LiveasyTask.LiveasyTask.models.UpdateLoadDto;
import com.LiveasyTask.LiveasyTask.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoadService {

    @Autowired
    LoadRepository loadRepository;

    public String saveLoad(LoadDto loadDTO) {
        Load load = new Load();
        load.setLoadingPoint(loadDTO.getLoadingPoint());
        load.setUnloadingPoint(loadDTO.getUnloadingPoint());
        load.setProductType(loadDTO.getProductType());
        load.setTruckType(loadDTO.getTruckType());
        load.setNoOfTrucks(loadDTO.getNoOfTrucks());
        load.setWeight(loadDTO.getWeight());
        load.setComment(loadDTO.getComment());
        load.setShipperId(loadDTO.getShipperId());
        load.setDate(loadDTO.getDate());
        loadRepository.save(load);
        return "Load details added successfully";
    }

    public List<Load> getLoadByShipperId(String shipperId){
        return loadRepository.findByShipperId(shipperId);
    }

    public Load getLoadByLoadId(long loadId){
        Optional<Load> optionalLoad = loadRepository.findById(loadId);
        if(optionalLoad.isEmpty()) return null;
        return optionalLoad.get();
    }

    public String updateLoad(long loadId, UpdateLoadDto loadDTO) {
        Optional<Load> existingLoadOpt = loadRepository.findById(loadId);
        if (existingLoadOpt.isPresent()) {
            Load existingLoad = existingLoadOpt.get();
            existingLoad.setLoadingPoint(loadDTO.getLoadingPoint());
            existingLoad.setUnloadingPoint(loadDTO.getUnloadingPoint());
            existingLoad.setProductType(loadDTO.getProductType());
            existingLoad.setTruckType(loadDTO.getTruckType());
            existingLoad.setNoOfTrucks(loadDTO.getNoOfTrucks());
            existingLoad.setWeight(loadDTO.getWeight());
            existingLoad.setComment(loadDTO.getComment());
            existingLoad.setDate(loadDTO.getDate());

            loadRepository.save(existingLoad);
            return "Load Updated Successfully";
        } else {
            return "Load not found";
        }
    }

    public String deleteLoadById(long loadId) {
        if (loadRepository.existsById(loadId)) {
            loadRepository.deleteById(loadId);
            return "Load detail deleted successfully";
        }else{
            return "No such load exists";
        }
    }

}
