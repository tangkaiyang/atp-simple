package com.tang.atpsimple.common.utils;

import com.netease.mebius.client.action.CodeAnalyze;
import com.netease.mebius.client.action.CodeOperate;
import com.netease.mebius.client.action.ProjectCompile;
import com.netease.mebius.client.enums.ExecType;
import com.netease.mebius.client.model.MethodCallResult;
import com.netease.mebius.client.model.MethodsCallResult;
import com.netease.mebius.client.model.project.GitParam;
import com.netease.mebius.client.model.project.MavenParam;
import com.netease.mebius.client.model.project.ProjectParam;
//import junit.framework.Assert;
//import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static com.netease.mebius.client.enums.GitAccessType.ACCESS_TOKEN;

public class MebiusTest {
    public static void main(String[] args) {
        GitParam gitParam = new GitParam();
        gitParam.setGitAccessType(ACCESS_TOKEN);
        gitParam.setGitAccessToken("gsMsb2Byi2AAzydAWqym");
        gitParam.setGitRepoDir("http://tangkaiyang:Tangky19931228@172.30.3.50/nnfw/shop/ordercenter/ordercenter.git");

        List<ProjectParam> projectParams = Lists.newArrayList();
        ProjectParam projectParam = new ProjectParam();
        projectParam.setProjectRootPath("D:\\IdeaProjects\\ordercenter");
        projectParam.setExecType(ExecType.BRANCH_DIFF);
        projectParam.setCurrentBranch("feature/order202407");
        projectParam.setCompareBranch("master");
        projectParam.setGitParam(gitParam);
        projectParams.add(projectParam);

        try {
            List<MethodsCallResult> results = CodeAnalyze.analyzeWithDiff(projectParams, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
