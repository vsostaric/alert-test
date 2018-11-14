package app.controller;

import app.model.Medicine;
import app.model.MedicineSearch;
import app.model.StudySearch;
import app.model.Treatment;
import app.model.rule.dao.Study;
import app.service.StudiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/studies")
public class StudiesController {

    private StudiesService studiesService;

    @Autowired
    public StudiesController(StudiesService studiesService) {
        this.studiesService = studiesService;
    }

    @PostMapping(value = "/saveStudy",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Study>> saveStudy(@RequestBody Study study) {
        studiesService.saveStudy(study);
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping(value = "/searchStudies",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Study>> searchStudies(
            @RequestBody StudySearch studySearch) {
        return ResponseEntity.ok(studiesService.searchStudies(studySearch));
    }
}
