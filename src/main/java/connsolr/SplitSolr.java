package connsolr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.FieldAnalysisRequest;
import org.apache.solr.client.solrj.response.AnalysisResponseBase;
import org.apache.solr.client.solrj.response.FieldAnalysisResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hx
 * @version 1.0
 * @date 2021/3/30 15:21
 */
public class SplitSolr {

    public static void main(String []args) throws SolrServerException, IOException {

        String urlString = "http://120.78.230.209:8008/solr8/new_hx";
        Init(urlString);
        String txt = "全党同志一定要登高望远、居安思危，勇于变革、勇于创新，永不僵化、永不停滞，团结带领全国各族人民决胜全面建成小康社会，奋力夺取新时代中国特色社会主义伟大胜利";
        List<String> results = getAnalysis(txt);
        for (String word : results) {
            System.out.println(word);
        }
    }

    private static SolrClient solr;
    /**
     * @Author：sks
     * @Description：初始化solr客户端
     * @Date：
     */
    public static void Init(String urlString){

        solr = new HttpSolrClient.Builder(urlString).build();
    }
    /**
     * @Author：sks
     * @Description：分词统计，把字符串分词并返回分词列表
     * @Date:
     */
    public static List<String> getAnalysis(String sentence) {
        FieldAnalysisRequest request = new FieldAnalysisRequest(
                "/analysis/field");
        request.addFieldName("conn");// 字段名，随便指定一个支持中文分词的字段
        request.setFieldValue("");// 字段值，可以为空字符串，但是需要显式指定此参数
        request.setQuery(sentence);

        FieldAnalysisResponse response = null;
        try {
            response = request.process(solr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> results = new ArrayList<String>();
        Iterator<AnalysisResponseBase.AnalysisPhase> it = response.getFieldNameAnalysis("conn")
                .getQueryPhases().iterator();
        while(it.hasNext()) {
            AnalysisResponseBase.AnalysisPhase pharse = (AnalysisResponseBase.AnalysisPhase)it.next();
            List<AnalysisResponseBase.TokenInfo> list = pharse.getTokens();
            for (AnalysisResponseBase.TokenInfo info : list) {
                results.add(info.getText());
            }

        }

        return results;
    }

}
