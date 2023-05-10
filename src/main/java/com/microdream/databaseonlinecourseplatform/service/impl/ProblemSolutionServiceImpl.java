package com.microdream.databaseonlinecourseplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microdream.databaseonlinecourseplatform.mapper.ProblemSolutionMapper;
import com.microdream.databaseonlinecourseplatform.pojo.ProblemSolution;
import com.microdream.databaseonlinecourseplatform.service.ProblemSolutionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Hanasaki_Fubuki
 */
@Service
@Resource
public class ProblemSolutionServiceImpl extends ServiceImpl<ProblemSolutionMapper, ProblemSolution> implements ProblemSolutionService {
    @Override
    public boolean newProblem(ProblemSolution problemSolution) {
        problemSolution.setSubmitTime(new Date());
        return save(problemSolution);
    }

    @Override
    public boolean solveProblem(ProblemSolution problemSolution) {
        return updateById(problemSolution);
    }

    @Override
    public List<ProblemSolution> getUserProblemList(int uid) {
        QueryWrapper<ProblemSolution> qw = new QueryWrapper<>();
        qw.eq("uid", uid).orderByDesc("id");
        return list(qw);
    }

    @Override
    public List<ProblemSolution> getUnsolvedProblemList() {
        QueryWrapper<ProblemSolution> qw = new QueryWrapper<>();
        qw.isNull("solution");
        return list(qw);
    }
}
