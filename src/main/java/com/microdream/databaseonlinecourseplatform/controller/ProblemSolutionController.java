package com.microdream.databaseonlinecourseplatform.controller;

import com.microdream.databaseonlinecourseplatform.pojo.ProblemSolution;
import com.microdream.databaseonlinecourseplatform.pojo.response.Result;
import com.microdream.databaseonlinecourseplatform.service.ProblemSolutionService;
import com.microdream.databaseonlinecourseplatform.service.SystemLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hanasaki_Fubuki
 */
@Controller
@ResponseBody
@Slf4j
public class ProblemSolutionController {

    @Resource
    ProblemSolutionService problemSolutionService;

    @Resource
    SystemLogService systemLogService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/problem-list", method = RequestMethod.POST)
    public List<ProblemSolution> getUnsolvedProblemList() {
        return problemSolutionService.getUnsolvedProblemList();
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/user-problem-list", method = RequestMethod.POST)
    public List<ProblemSolution> getUserProblemList(@RequestParam("uid") Integer uid) {
        return problemSolutionService.getUserProblemList(uid);
    }

    @CrossOrigin
    @RequestMapping(value = "/submit-problem", method = RequestMethod.POST)
    @ResponseBody
    public Result submitProblem(@RequestBody ProblemSolution problem) {
        if (problemSolutionService.newProblem(problem)) {
            systemLogService.problemCreated(problem.getUid());
            return new Result(200);
        } else {
            return new Result(400);
        }

    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/solve-problem", method = RequestMethod.POST)
    public Result solveProblem(@RequestBody ProblemSolution problemSolution) {
        if (problemSolutionService.solveProblem(problemSolution)) {
            systemLogService.problemSolved(problemSolution.getUid());
            return new Result(200);
        } else {
            return new Result(400);
        }
    }

}
