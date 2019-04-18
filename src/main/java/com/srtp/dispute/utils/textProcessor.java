package com.srtp.dispute.utils;

import com.hankcs.hanlp.HanLP;
import com.srtp.dispute.model.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 文本处理相关方法
 */
public class textProcessor {
    // 依据案情描述提取关键词
    public static List<String> getKeyword(String content, int size){
        List<String> keyword = new ArrayList<>();
        //匹配疾病并添加
        for(String disease: Constants.diseaseName){
            if(content.contains(disease)){
                keyword.add(disease);
            }
        }
        //匹配医疗行为并添加
        for(String treatment:Constants.treatmentName){
            if(content.contains(treatment)){
                keyword.add(treatment);
            }
        }
        //匹配伤害结果并添加
        for(String injury:Constants.injuryResult){
            if(content.contains(injury)){
                keyword.add(injury);
            }
        }

        int remain = size - keyword.size();
        //HanLP生成关键词
        List<String> list=new ArrayList<String>();
        list = HanLP.extractKeyword(content, remain);
        for(String s:list) {
//            System.out.println("关键词:" + s);
            if(s != null && s.length() != 0) {
                keyword.add(s);
            }
        }

        return keyword;
    }
}
