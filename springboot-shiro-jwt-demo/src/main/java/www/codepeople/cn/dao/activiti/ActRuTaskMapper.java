package www.codepeople.cn.dao.activiti;

import org.apache.ibatis.annotations.Mapper;
import www.codepeople.cn.util.activiti.ActRuTask;

import java.util.List;

@Mapper
public interface ActRuTaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActRuTask record);

    int insertSelective(ActRuTask record);

    ActRuTask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActRuTask record);

    int updateByPrimaryKey(ActRuTask record);

    List<ActRuTask> selectAll();
}