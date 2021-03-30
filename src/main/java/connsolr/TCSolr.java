package connsolr;

import connsolr.util.SolrUtil;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
//import org.apache.solr.client.solrj.SolrServer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @version 1.0
 * @date 2021/3/30 10:28
 */
public class TCSolr {

    public static void main(String[] args) throws Exception {
        ConnSolr cs = new ConnSolr();
        SolrUtil su = new SolrUtil();
        SolrQuery solrQuery=new SolrQuery();

        /*
        连接solr，进行增删查。 4.10.4版本
         */
//        SolrServer ss =cs.connsolr("http://localhost:8008/solr8/new_hx");
//        List l1=new ArrayList();
//        List l2=new ArrayList();
//        l1.add("id");
//        l1.add("name");
//        l1.add("age");
//        l2.add("2");
//        l2.add("gdcs");
//        l2.add("9");
        //增加
//        su.addDoc(ss,l1,l2);
        //查询
//        su.selectDoc(ss,solrQuery,"q","id:2");
        //删除
//        su.daleteDoc(ss,null);



        /*
        连接solr，新版本
         */
        HttpSolrClient hsc = cs.connsolr("http://localhost:8008/solr8");///new_hx
//
//        su.sDelete(hsc);
        su.sAdd(hsc);
        su.sQuery(hsc);

    }


}
