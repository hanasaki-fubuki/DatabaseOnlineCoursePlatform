package com.microdream.databaseonlinecourseplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.microdream.databaseonlinecourseplatform.pojo.ProblemSolution;

import java.util.List;

/**
 * @author Hanasaki_Fubuki
 */
public interface ProblemSolutionService extends IService<ProblemSolution> {

    /**
     * 新建疑惑知识点
     * @param problemSolution 疑惑知识点，无solution
     * @return 是否成功
     */
    boolean newProblem(ProblemSolution problemSolution);

    /**
     * 答疑
     * @param problemSolution 传入的疑惑知识点，可以包含solution
     * @param solution 问题解决方案
     * @return 是否成功
     */
    boolean solveProblem(ProblemSolution problemSolution, String solution);

    /**
     * 获取用户提问的知识点列表
     * @param uid 用户id
     * @return 单用户对应的知识点列表
     */
    List<ProblemSolution> getUserProblemList(int uid);

}
