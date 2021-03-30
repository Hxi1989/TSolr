package connsolr;


//import org.apache.solr.client.solrj.SolrServer;
//import org.apache.solr.client.solrj.impl.HttpSolrServer;

import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 * @author hx
 * @version 1.0
 * @date 2021/3/30 10:24
 */
public class ConnSolr implements CSolr{

    //solrj4.10.4版本连接
//    public SolrServer connsolrold(String solrurl) {
//        SolrServer solrServer = new HttpSolrServer(solrurl);
//        return solrServer;
//    }

    //新版本连接
    public HttpSolrClient connsolr(String solrurl) {
        HttpSolrClient csolr = new HttpSolrClient.Builder(solrurl)
//                .withConnectionTimeout(10000)
//                .withSocketTimeout(60000)
                .build();
        return csolr;
    }
}
