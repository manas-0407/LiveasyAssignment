package com.LiveasyTask.LiveasyTask.controller;

import com.LiveasyTask.LiveasyTask.models.Load;
import com.LiveasyTask.LiveasyTask.models.LoadDto;
import com.LiveasyTask.LiveasyTask.models.UpdateLoadDto;
import com.LiveasyTask.LiveasyTask.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    LoadService loadService;

    @PostMapping
    public ResponseEntity<String> addLoad(@RequestBody LoadDto load) {
        String response = loadService.saveLoad(load);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Load>> getLoadByShipperId(@RequestParam String shipperId){
        return ResponseEntity.ok(loadService.getLoadByShipperId(shipperId));
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable long loadId){
        return ResponseEntity.ok(loadService.getLoadByLoadId(loadId));
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable Long loadId, @RequestBody UpdateLoadDto updateLoadDto) {
        String response = loadService.updateLoad(loadId, updateLoadDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
        String response = loadService.deleteLoadById(loadId);
        return ResponseEntity.ok(response);
    }
}
