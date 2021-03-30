package connsolr;

//import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 * @author hx
 * @version 1.0
 * @date 2021/3/30 10:11
 */
public interface CSolr {
    //连接solr 老版本
//    SolrServer connsolr(String solrurl);

    //连接solr 新版本
    HttpSolrClient connsolr(String solrurl);


}
