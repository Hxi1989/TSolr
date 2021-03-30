package connsolr.util;

import org.apache.solr.client.solrj.SolrQuery;
//import org.apache.solr.client.solrj.SolrServer;
//import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hx
 * @version 1.0
 * @date 2021/3/30 10:38
 */
public class SolrUtil {


    /*//增加数据
    public void addDoc(SolrServer solrServer,List listname,List connname) throws Exception {
        //创建一个SolrServer对象，创建一个连接，参数solr服务的url
//        SolrServer solrServer = new HttpSolrServer("http://127.0.0.1:8080/solr/collection1");
        //创建一个文档对象SolrInputDoCument
        SolrInputDocument document = new SolrInputDocument();
        //向文档对象中添加域，文档中必须包含一个id域，所有的域的名称必须在schema.xml中定义
//        document.addField("id", "doc01");
//        document.addField("name", "测试商品01");
//        document.addField("age", "1000");
        int i = listname.size();
        System.out.println(i);
        for(int j=0;j<i;j++){
            String a = listname.get(j).toString();
            String b = connname.get(j).toString();
            System.out.println("这里开始增加:"+a+" - "+b);
            document.addField(a,b);
        }
        //把文档写入索引库
        solrServer.add(document);
        //提交
        solrServer.commit();
    }

    //删除数据
    public void daleteDoc(SolrServer solrServer,List connname) throws Exception {
        //创建一个SolrServer对象，创建一个连接，参数solr服务的url
//        SolrServer solrServer = new HttpSolrServer("http://127.0.0.1:8080/solr/collection1");
        //按照文档id删除
        //solrServer.deleteById("doc01");
        //或者根据查询删除
        solrServer.deleteByQuery("id:doc01");
//        for(Object s : connname){
//            System.out.println("这里开始删除:"+s.toString());
////            solrServer.deleteByQuery(s.toString());
//        }
        //提交
        solrServer.commit();
    }

    //查询
    public void selectDoc(SolrServer solrServer, SolrQuery solrQuery,String names,String querys) throws Exception {
        //创建一个SolrServer对象，创建一个连接，参数solr服务的url
        //SolrServer solrServer = new HttpSolrServer("http://127.0.0.1:8080/solr/collection1");
        //创建查询对象
        //SolrQuery solrQuery=new SolrQuery();
        //设置查询条件
        solrQuery.set(names,querys);//"q","item_title:3"
        //查询
        QueryResponse query = solrServer.query(solrQuery);
        //获得查询结果
        SolrDocumentList results = query.getResults();
        //获得查询记录数
        long numFound = results.getNumFound();
        System.out.println("获取查询条数："+numFound);
        for (SolrDocument sd : results) {
            String id=(String) sd.getFieldValue("id");
            String name=(String) sd.getFieldValue("name").toString();
            String age=(String) sd.getFieldValue("age").toString();

            System.out.println("========================================");
            System.out.println("id:"+id);
            System.out.println("name:"+name);
            System.out.println("age:"+age);

        }
    }*/

    ////分割线 上为老版本///////////////////////////////////////////////////////////////////////////////

    public void sQuery(HttpSolrClient solrClient) throws IOException, SolrServerException {
//        HttpSolrClient solrClient = getSolrClient();
        // 定义查询条件
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", "*:*");
        SolrParams mapSolrParams = new MapSolrParams(params);
        //执行查询 第一个参数是collection，就是我们在solr中创建的core
        QueryResponse response = solrClient.query("new_hx", mapSolrParams);
        // 获取结果集
        SolrDocumentList results = response.getResults();
        for (SolrDocument result : results) {
            // SolrDocument 数据结构为Map
            System.out.println(result);
        }
    }

    public void sAdd(HttpSolrClient solrClient) throws IOException, SolrServerException {
//        HttpSolrClient solrClient = getSolrClient();
        // 定义数据 solr输入文档 数据结构为Map
        SolrInputDocument inputDocument = new SolrInputDocument();
        inputDocument.addField("id","1");
        inputDocument.addField("name", "名称");
        inputDocument.addField("age", "23");
        inputDocument.addField("conn", "依赖添加正确后，检查本地的类有没有下载下来");
        // 执行添加 ps：如果id相同，则执行更新操作
        // 要指定操作的collection 就是solr-home下定义的core
        UpdateResponse add = solrClient.add("new_hx", inputDocument);
        //提交添加/更新
        solrClient.commit("new_hx");
    }

    public void sDelete(HttpSolrClient solrClient) throws IOException, SolrServerException {
//        HttpSolrClient solrClient = getSolrClient();
        // 通过id删除 执行要删除的collection（core）
//        solrClient.deleteById("new_hx", "2");
        // 还可以通过查询条件删除
         solrClient.deleteByQuery("new_hx", "id:1");
        // 提交删除
        solrClient.commit("new_hx");
    }

}
