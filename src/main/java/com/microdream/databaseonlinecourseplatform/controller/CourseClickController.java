package com.microdream.databaseonlinecourseplatform.controller;

import com.microdream.databaseonlinecourseplatform.service.CourseClickService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Hanasaki_Fubuki
 */

@RestController
@Slf4j
public class CourseClickController {

    @Resource
    CourseClickService courseClickService;

    @CrossOrigin
    @RequestMapping(value = "/course-click", method = RequestMethod.POST)
    public void courseClicked(@RequestParam("chapterName") String chapterName) {
        courseClickService.addClick(chapterName);
    }

}
