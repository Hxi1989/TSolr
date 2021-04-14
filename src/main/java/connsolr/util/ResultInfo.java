package connsolr.util;

/**
 * @author hx
 * @version 1.0
 * @date 2021/4/13 14:18
 */
import java.util.List;

/**
 * 查询Solr返回的对象，对象类型为Ｔ的集合，还包含Solr中符合条件记录总数
 *
 */
public class ResultInfo<T> {
    private List<T> list = null;
    private Long total = null;

    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
}
