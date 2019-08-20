package com.mood.search;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

/**
 * @Created by mood321
 * @Date 2019/8/21 0021
 * @Description 测试分词
 */
public class AnalyzerTest {
    public static void main(String[] args) throws Exception {

        // Analyzer analyzer=new StandardAnalyzer(); // 标准分词器
        SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
        TokenStream ts = analyzer.tokenStream("name", "护眼带光源");
        ts.reset();
        while (ts.incrementToken()) {
            System.out.println(ts.reflectAsString(false));
        }
    }
}
